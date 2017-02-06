package com.blog.web.error.support;

import com.blog.web.error.enumerate.ErrorCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */

@Getter
@ToString
public class RequestResponse extends ResponseSetting {

    public RequestResponse(final String errorMessage, final ErrorCode errorCode){
        super(errorMessage,errorCode);
    }

    @Override
    public RequestResponse createResponse() {
        return this;
    }
}
