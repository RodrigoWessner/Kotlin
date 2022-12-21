package br.com.KotlinProject.dto

import org.springframework.http.HttpStatus

class ExceptionDto(
    val mensagem: String?,
    val status: HttpStatus
)