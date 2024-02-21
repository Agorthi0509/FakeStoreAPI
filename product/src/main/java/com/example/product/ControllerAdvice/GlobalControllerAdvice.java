package com.example.product.ControllerAdvice;

import com.example.product.DTO.ErrorResponseDto;
import com.example.product.services.InvalidIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidProduct() {
        return new ResponseEntity<>(new ErrorResponseDto("Invalid product from global"), HttpStatus.NOT_FOUND);
    }
}
