package com.blog.web.error.support;

import com.blog.web.error.enumerate.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */

@AllArgsConstructor
@Getter
public abstract class ResponseSetting<T extends ResponseSetting>{

    private String errorMessage;
    private ErrorCode errorCode;

    abstract T createResponse();
}
