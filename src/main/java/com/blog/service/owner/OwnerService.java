package com.blog.service.owner;

import com.blog.models.Owner;

import java.util.Optional;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */

public interface OwnerService {

    Optional<Owner> getOwner(String email);
    Optional<Owner> createOwner(Owner owner);
    Optional<Owner> updateOwner(Owner owner);
    void deleteOwner(Owner owner);

}
