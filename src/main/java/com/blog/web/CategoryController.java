package com.blog.web;

import com.blog.dto.CategoryDto;
import com.blog.models.Category;
import com.blog.service.category.CategoryService;

import com.blog.web.error.exception.ResourceCreationErrorsException;
import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public ResponseEntity allCategory(){

        final List<Category> read = categoryService.allCategory();

        if(read.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        final List<CategoryDto.Read> categoryList
                                        = read.stream()
                                                .map( category -> modelMapper.map(category, CategoryDto.Read.class) )
                                                .collect(Collectors.toList());

        return new ResponseEntity(categoryList,HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getCategory(@PathVariable String name){
        Optional<Category> read = categoryService.getCategory(name);

        if(read.isPresent()){
            final CategoryDto.Read readDto = modelMapper.map(read.get(), CategoryDto.Read.class);
            return new ResponseEntity(readDto, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
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

        throw new ResourceCreationErrorsException("요청하신 리소스 생성에 실패 하였습니다.");
    }

}
