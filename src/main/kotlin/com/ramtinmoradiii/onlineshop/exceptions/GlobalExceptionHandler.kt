package com.ramtinmoradiii.onlineshop.exceptions

import com.ramtinmoradiii.onlineshop.responses.ServiceResponse
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
import jakarta.validation.ConstraintViolationException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleGenericException(e: Exception): ResponseEntity<ServiceResponse<Any?>> {
        val response = ServiceResponse<Any?>(
            success = false,
            data = null,
            message = ResponseMessage.INTERNAL_SERVER_ERROR_PREFIX + e.message
        )
        return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(e: MethodArgumentNotValidException): ResponseEntity<ServiceResponse<Any?>> {
        val errors = e.bindingResult.fieldErrors.map {
            "${it.field}: ${it.defaultMessage}"
        }
        val response = ServiceResponse<Any?>(
            success = false,
            data = null,
            message = ResponseMessage.VALIDATION_FAILED_PREFIX + errors.joinToString(", ")
        )
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolation(e: ConstraintViolationException): ResponseEntity<ServiceResponse<Any?>> {
        val errors = e.constraintViolations.map {
            it.message
        }
        val response = ServiceResponse<Any?>(
            success = false,
            data = null,
            message = ResponseMessage.CONSTRAINT_VIOLATION_PREFIX + errors.joinToString(", ")
        )
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleMalformedJson(e: HttpMessageNotReadableException): ResponseEntity<ServiceResponse<Any?>> {
        val response = ServiceResponse<Any?>(
            success = false,
            data = null,
            message = ResponseMessage.MALFORMED_JSON
        )
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    fun handleTypeMismatch(e: MethodArgumentTypeMismatchException): ResponseEntity<ServiceResponse<Any?>> {
        val message = String.format(
            ResponseMessage.TYPE_MISMATCH_TEMPLATE,
            e.value,
            e.name,
            e.requiredType?.simpleName ?: "نا مشخص"
        )

        val response = ServiceResponse<Any?>(
            success = false,
            data = null,
            message = message
        )
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFound(e: ResourceNotFoundException): ResponseEntity<ServiceResponse<Any?>> {
        val response = ServiceResponse<Any?>(
            success = false,
            data = null,
            message = e.message ?: ResponseMessage.NOT_FOUND
        )
        return ResponseEntity(response, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleDataIntegrity(e: DataIntegrityViolationException): ResponseEntity<ServiceResponse<Any?>> {
        val response = ServiceResponse<Any?>(
            success = false,
            data = null,
            message = ResponseMessage.DATA_INTEGRITY_VIOLATION
        )
        return ResponseEntity(response, HttpStatus.CONFLICT)
    }
}