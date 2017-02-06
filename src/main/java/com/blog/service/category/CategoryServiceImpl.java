package com.blog.service.category;

import com.blog.models.Category;
import com.blog.repository.CategoryRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository repository){
        this.categoryRepository = repository;
    }

    @Override
    public Optional<Category> createCategory(Category category) {
        return Optional.ofNullable(categoryRepository.save(category));
    }

    @Override
    public Optional<Category> getCategory(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public List<Category> allCategory() {
        return categoryRepository.findAll();
    }
}
