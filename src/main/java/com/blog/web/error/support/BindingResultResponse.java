package com.blog.web.error.support;

import com.blog.web.error.enumerate.ErrorCode;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */
@Slf4j
@Getter
@ToString(callSuper = true)
public class BindingResultResponse extends ResponseSetting {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<RejectFieldInfo> RejectFieldInfoList;

    public BindingResultResponse(String errorMessage, ErrorCode errorCode, List<RejectFieldInfo> RejectFieldInfoList){
        super(errorMessage,errorCode);
        this.RejectFieldInfoList = RejectFieldInfoList;
    }

    @Override
    public BindingResultResponse createResponse() {
        return this;
    }

    @AllArgsConstructor
    @Getter
    public static class RejectFieldInfo{
        private String rejectFieldName;
        private String rejectFieldValue;
        private String rejectMessage;
    }
}
