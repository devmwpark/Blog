package com.blog.web;

import com.blog.dto.OwnerDto;
import com.blog.models.Owner;
import com.blog.service.owner.OwnerService;
import com.blog.web.error.exception.ResourceErrorsException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */

@RestController
@Slf4j
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService ownerService;
    private final ModelMapper modelMapper;

    public  OwnerController(OwnerService service, ModelMapper mapper){
        this.ownerService = service;
        this.modelMapper = mapper;
    }

    @PostMapping
    public ResponseEntity createOwner(@RequestBody @Valid OwnerDto.Create created, BindingResult bindingResult){

        final Optional<Owner> read =
                ownerService.createOwner(modelMapper.map(created, Owner.class));
        if (read.isPresent()){
            return new ResponseEntity<>(read, HttpStatus.OK);
        }
        log.debug("category create failed... ");
        throw new ResourceErrorsException("요청하신 리소스 생성에 실패 하였습니다.");
    }

    @PutMapping
    public ResponseEntity updateOwner(@RequestBody @Valid OwnerDto.Create updated, BindingResult bindingResult){

        final Optional<Owner> read =
                ownerService.createOwner(modelMapper.map(updated, Owner.class));
        if (read.isPresent()){
            return new ResponseEntity<>(read, HttpStatus.OK);
        }

        log.debug("category update failed... ");
        throw new ResourceErrorsException("요청하신 리소스 수정에 실패 하였습니다.");
    }
}
