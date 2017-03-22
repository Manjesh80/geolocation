package com.manjesh.microservices.exception;

import com.manjesh.microservices.model.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 3/22/2017.
 */

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(HttpServletRequest request, Exception e) {
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTimeStamp(new Date().getTime());
        errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
        errorDetail.setTitle("Resource Not Found");
        errorDetail.setDetail(e.getMessage());
        errorDetail.setDeveloperMessage(e.toString());
        return new ResponseEntity<>(errorDetail, null, HttpStatus.NOT_FOUND);
    }
}
