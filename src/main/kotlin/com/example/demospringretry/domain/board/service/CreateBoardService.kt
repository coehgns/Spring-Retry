package com.example.demospringretry.domain.board.service

import com.example.demospringretry.domain.board.domain.Board
import com.example.demospringretry.domain.board.domain.repository.BoardRepository
import com.example.demospringretry.domain.board.presentation.dto.request.CreateBoardRequest
import org.slf4j.LoggerFactory
import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Recover
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateBoardService(
    private val boardRepository: BoardRepository
) {

    companion object {
        private val logger = LoggerFactory.getLogger(CreateBoardService::class.java)
    }

    @Retryable(
        maxAttempts = 3,
        backoff = Backoff(delay = 1000),
        value = [RuntimeException::class],
        recover = "recover"
    )
    @Transactional
    fun execute(request: CreateBoardRequest) {
        val board = request.run {
            Board(
                title = title,
                content = content
            )
        }
        boardRepository.save(board)
    }

    @Recover
    fun recover(e: RuntimeException) {
        logger.info("recover $e")
    }
}