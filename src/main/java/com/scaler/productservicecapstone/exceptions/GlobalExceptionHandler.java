package com.scaler.productservicecapstone.exceptions;

import com.scaler.productservicecapstone.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ErrorDto handleNullExceptions() {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setStatus("error");
        errorDto.setMessage("Null Pointer Exception Occured");
        return errorDto;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFoundExceptions(ProductNotFoundException e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setStatus("error");
        errorDto.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }
}
