package com.blog.web;

import com.blog.dto.CategoryDto;
import com.blog.models.Category;
import com.blog.service.category.CategoryService;

import com.blog.web.error.exception.ResourceErrorsException;
import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

/**
 *  @author devmwpark[devmwpark@gmail.com]
 *
 */

@Slf4j
@RestController
@RequestMapping("/categories")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class CategoryController {

    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public CategoryController(CategoryService service, ModelMapper mapper){
        this.categoryService = service;
        this.modelMapper = mapper;
    }

    @GetMapping
    public ResponseEntity getCategories(){

        final List<Category> read = categoryService.allCategory();

        if(read.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(read,HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getCategoryByName(@PathVariable String name){

        final Optional<Category> read = categoryService.getCategoryByName(name);

        if(read.isPresent()){
            final CategoryDto.Read readDto = modelMapper.map(read.get(), CategoryDto.Read.class);
            return new ResponseEntity(readDto, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/depth/{depth}")
    public ResponseEntity getCategoryByDepthAndParent(@PathVariable Integer depth){

        final List<Category> read = categoryService.getCategoryByDepth(depth);

        if(read.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(read, HttpStatus.OK);
    }

    @GetMapping("/parent/{parent}")
    public ResponseEntity getCategoryByDepthAndParent(@PathVariable Long parent){

        final List<Category> read = categoryService.getCategoryByParent(parent);

        if(read.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(read, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveCategory(@RequestBody @Valid final CategoryDto.Create createModel
                                                                    , BindingResult bindingResult){

        final Optional<Category> created =
                categoryService.createCategory(modelMapper.map(createModel, Category.class));

        if(created.isPresent()){
            final CategoryDto.Read readDto = this.modelMapper.map(created.get(), CategoryDto.Read.class);
            return new ResponseEntity<>(readDto, HttpStatus.OK);
        }

        log.debug("category create failed... ");
        throw new ResourceErrorsException("요청하신 리소스 생성에 실패 하였습니다.");
    }

    @PutMapping
    public ResponseEntity modifyCategory(@RequestBody @Valid final CategoryDto.Create updateModel
                                                                    , BindingResult bindingResult ){
        final Optional<Category> updated =
                categoryService.updateCategory(modelMapper.map(updateModel, Category.class));

        if(updated.isPresent()){
            final CategoryDto.Read readDto = this.modelMapper.map(updated.get(), CategoryDto.Read.class);
            return new ResponseEntity<>(readDto, HttpStatus.OK);
        }

        log.debug("category update failed... ");
        throw new ResourceErrorsException("요청하신 리소스 수정에 실패 하였습니다.");
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
