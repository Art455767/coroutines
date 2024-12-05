package ru.netology.nmedia.exception



import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(ex: NotFoundException): ResponseEntity<String> {
        return ResponseEntity("Ресурс не найден", HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(RuntimeException::class)
    fun handleGenericException(ex: RuntimeException): ResponseEntity<String> {
        return ResponseEntity("Произошла ошибка: ${ex.message}", HttpStatus.INTERNAL_SERVER_ERROR)
    }
}