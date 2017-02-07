package com.blog.service.category;

import com.blog.models.Category;

import java.util.List;
import java.util.Optional;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */
public interface CategoryService {
    List<Category> allCategory();
    Optional<Category> getCategoryByName(String name);
    List<Category> getCategoryByDepth(Integer depth);
    List<Category> getCategoryByParent(Long parent);
    Optional<Category> createCategory(Category category);
    Optional<Category> updateCategory(Category category);
    void deleteCategory(Long id);
}
