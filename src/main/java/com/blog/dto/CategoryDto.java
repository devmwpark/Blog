package com.blog.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */

public class CategoryDto {

    @Data
    public static class Create {
        @NotBlank
        private String name;
        @NotNull
        private Integer depth;
        private Long parent;
    }

    @Data
    public static class Read{
        private Long id;
        private String name;
        private Integer depth;
        private Long parent;
        private LocalDateTime createTime;
        private LocalDateTime updateTime;
    }

}
