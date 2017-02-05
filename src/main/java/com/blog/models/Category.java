package com.blog.models;



import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;


/**
 *  @author devmwpark[devmwpark@gmail.com]
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Category extends BaseEntity{

    @Column(nullable = false, length = 100, unique = true)
    private String name;

    @Column(nullable = false, length = 10)
    private Integer depth;

    @Column(length = 10)
    private Long parentId;
}
