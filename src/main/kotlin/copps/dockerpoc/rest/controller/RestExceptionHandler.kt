package copps.dockerpoc.rest.controller

import copps.dockerpoc.domain.model.ValidationException
import copps.dockerpoc.rest.payload.ErrorPayload
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(ValidationException::class)
    fun handleValidationException(e: ValidationException) : ResponseEntity<ErrorPayload> {
        val payload = ErrorPayload(e.message, e.errors)
        // log it

        return ResponseEntity(payload, HttpStatus.BAD_REQUEST)
    }
}