package br.com.KotlinProject.Exception

import br.com.KotlinProject.dto.ExceptionDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(DataBaseException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun databaseException(ex: DataBaseException) : ResponseEntity<ExceptionDto> {
        val erro = ExceptionDto(ex.message, HttpStatus.INTERNAL_SERVER_ERROR)
        return ResponseEntity(erro,HttpStatus.INTERNAL_SERVER_ERROR)
    }
}