package com.blog.repository;

import com.blog.models.Owner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */

@EnableJpaRepositories
public interface OwnerRepository extends JpaRepository<Owner,Long>{

    Optional<Owner> findByEmail(String email);
}
