package com.blog.web.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.BindingResult;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */

@AllArgsConstructor
public class BindingResultHasErrorsException extends RuntimeException{
    @Getter
    BindingResult result;
}
