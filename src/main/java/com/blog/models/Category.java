package com.blog.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 *  @author devmwpark[devmwpark@gmail.com]
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class Category extends BaseEntity{

    @Column(nullable = false, length = 100, unique = true)
    private String name;

    @Column(nullable = false, length = 10)
    private int depth;

    @Column(nullable = false)
    private boolean isParent;

    @Column(length = 10)
    private int parentId;
}
