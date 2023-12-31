package com.springboot2.essentials.handler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot2.essentials.exception.BadRequestException;
import com.springboot2.essentials.exception.BadRequestExceptionDetails;
import com.springboot2.essentials.exception.ExceptionDetails;
import com.springboot2.essentials.exception.ValidationExceptionDetails;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(BadRequestException.class)
        public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException bre) {
                return new ResponseEntity<>(
                                BadRequestExceptionDetails.builder()
                                                .timestap(LocalDateTime.now())
                                                .status(HttpStatus.BAD_REQUEST.value())
                                                .title("Bad Request Exception")
                                                .details(bre.getMessage())
                                                .developerMessage(bre.getClass().getName())
                                                .build(),
                                HttpStatus.BAD_REQUEST);
        }

        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(
                MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

                List<FieldError> fieldErros = exception.getBindingResult().getFieldErrors();

                String fields = fieldErros.stream().map(FieldError::getField).collect(Collectors.joining(","));
                String fieldsMessages = fieldErros.stream().map(FieldError::getDefaultMessage)
                                .collect(Collectors.joining(","));

                return new ResponseEntity<>(
                                ValidationExceptionDetails.builder()
                                                .timestap(LocalDateTime.now())
                                                .status(HttpStatus.BAD_REQUEST.value())
                                                .title("Bad Request Exception, Invalid Fields")
                                                .details("Check the fields error")
                                                .developerMessage(exception.getClass().getName())
                                                .fieldsMessage(fieldsMessages)
                                                .fields(fields)
                                                .build(),
                                HttpStatus.BAD_REQUEST);
        }

        @Override
        protected ResponseEntity<Object> handleExceptionInternal(
                        Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatusCode statusCode,
                        WebRequest request) {

                return new ResponseEntity<>(
                                ExceptionDetails.builder()
                                                .timestap(LocalDateTime.now())
                                                .status(HttpStatus.BAD_REQUEST.value())
                                                .title(ex.getCause().getMessage())
                                                .details(ex.getMessage())
                                                .developerMessage(ex.getClass().getName())
                                                .build(),
                                headers,
                                statusCode);
        }

}
