package com.blog.models;

import lombok.Data;

import javax.persistence.*;

/**
 *  @author devmwpark[devmwpark@gmail.com]
 */
@Entity
@Data
public class Category extends CommonModel{

    @Column(nullable = false, length = 100, unique = true)
    private String name;

    @Column(nullable = false, length = 10)
    private int depth;

    @Column(nullable = false)
    private boolean isParent;

    @Column(length = 10)
    private int parentId;
}
