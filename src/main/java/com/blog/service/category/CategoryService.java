package com.blog.service.category;

import com.blog.models.Category;

import java.util.List;
import java.util.Optional;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */
public interface CategoryService {
    Optional<Category> createCategory(Category category);
    Optional<Category> getCategory(String name);
    List<Category> allCategory();
}
