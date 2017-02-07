package com.blog.service.owner;

import com.blog.models.Owner;
import com.blog.repository.OwnerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService{

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository repository){
        this.ownerRepository = repository;
    }

    @Override
    public Optional<Owner> getOwner(String email) {
        return ownerRepository.findByEmail(email);
    }

    @Override
    public Optional<Owner> createOwner(Owner owner) {
        return Optional.ofNullable(ownerRepository.save(owner));
    }

    @Override
    public Optional<Owner> updateOwner(Owner owner) {
        return Optional.ofNullable(ownerRepository.save(owner));
    }

    @Override
    public void deleteOwner(Owner owner) {
        ownerRepository.delete(owner);
    }

}
