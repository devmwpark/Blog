package com.blog.web.error.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */

@AllArgsConstructor
public enum ErrorCode {

    BAD_REQUEST_ERROR("BAD_REQUEST_ERROR"),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR");

    @Getter
    public String errorCode;
}
