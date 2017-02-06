package com.blog.web.error.advice;

import com.blog.web.error.exception.ResourceCreationErrorsException;
import com.blog.web.error.support.BindingResultResponse;
import com.blog.web.error.exception.BindingResultHasErrorsException;
import com.blog.web.error.enumerate.ErrorCode;
import com.blog.web.error.support.RequestResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */

@ControllerAdvice
@RestController
@Slf4j
public class ExceptionAdviceController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        log.debug("internal server error :: ",e);
        return new ResponseEntity<>(
                new RequestResponse("요청이 실패하였습니다.",ErrorCode.INTERNAL_SERVER_ERROR).createResponse(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(BindingResultHasErrorsException.class)
    public ResponseEntity handleBindingResultHasErrorsException(BindingResultHasErrorsException e) {
        return new ResponseEntity<>(
                new BindingResultResponse(
            "잘못된 요청입니다."
                        ,ErrorCode.BAD_REQUEST_ERROR
                        ,e.getResult().getFieldErrors().stream()
                        .map(error ->
                                new BindingResultResponse.RejectFieldInfo( error.getField(),
                                        String.valueOf(error.getRejectedValue()),
                                        error.getDefaultMessage())
                        ).collect(Collectors.toList())
                ).createResponse(), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(ResourceCreationErrorsException.class)
    public ResponseEntity ResourceCreationErrorsException(ResourceCreationErrorsException e){
        return new ResponseEntity<>(
                new RequestResponse(e.getMessage(),ErrorCode.RESOURCE_CREATE_ERROR).createResponse(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
