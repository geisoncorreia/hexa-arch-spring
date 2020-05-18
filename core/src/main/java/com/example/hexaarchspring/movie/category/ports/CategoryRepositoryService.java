package com.example.hexaarchspring.movie.category.ports;

import com.example.hexaarchspring.movie.category.Category;

import java.util.Collection;

public interface CategoryRepositoryService {

    public Collection<Category> getAllCategories();

    public void saveCategory(Category category) ;

    public Boolean doesCategoryNameExists(String name);
}
