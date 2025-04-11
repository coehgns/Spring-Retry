package com.example.demospringretry.domain.board.presentation

import com.example.demospringretry.domain.board.presentation.dto.request.CreateBoardRequest
import com.example.demospringretry.domain.board.service.CreateBoardService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/boards")
class BoardController(
    private val createBoardService: CreateBoardService
) {
    @PostMapping
    fun createBoard(request: CreateBoardRequest) {
        createBoardService.execute(request)
    }
}