package com.blog.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */

public class CategoryDto {

    @Data
    public static class Create {
        @NotNull
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
