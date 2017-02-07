package com.blog.dto;

import com.blog.models.enumerate.AccessLevel;
import lombok.Data;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDateTime;


/**
 * @author devmwpark[devmwpark@gmail.com]
 */


public class OwnerDto {

    @Data
    public static class Create{

        @Email
        @NotBlank
        private String email;

        @NotBlank
        private String password;

        private String name;
    }

    @Data
    public static class Read{
        private String email;
        private String name;
        private AccessLevel accessLevel;
        private LocalDateTime createTime;
        private LocalDateTime updateTime;
    }
}
