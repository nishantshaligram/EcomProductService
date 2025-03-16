package com.scaler.ecomproductservice.controller.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.scaler.ecomproductservice.dto.ErrorResponseDTO;
import com.scaler.ecomproductservice.exception.ProductNotFoundException;

@ControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleProductNotFoundException(Exception ex){
        ErrorResponseDTO errorResponse = new ErrorResponseDTO();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setMessageCode(404);

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
