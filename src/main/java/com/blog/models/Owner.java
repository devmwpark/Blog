package com.blog.models;

import com.blog.models.enumerate.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(exclude = "password")
public class Owner extends BaseEntity{

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String password;

    @Enumerated(value = EnumType.STRING)
    private AccessLevel accessLevel = AccessLevel.UNKNOWN;
}
