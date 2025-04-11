package com.example.demospringretry.domain.board.presentation.dto.request

data class CreateBoardRequest(
    val title: String,
    val content: String?
)
