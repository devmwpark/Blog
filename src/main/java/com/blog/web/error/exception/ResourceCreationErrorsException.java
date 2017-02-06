package com.blog.web.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */
@AllArgsConstructor
public class ResourceCreationErrorsException extends RuntimeException {

    @Getter
    String message;
}
