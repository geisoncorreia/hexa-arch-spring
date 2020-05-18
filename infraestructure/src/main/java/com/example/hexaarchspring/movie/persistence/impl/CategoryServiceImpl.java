package com.example.hexaarchspring.movie.persistence.impl;


import com.example.hexaarchspring.movie.category.Category;
import com.example.hexaarchspring.movie.category.ports.CategoryRepositoryService;
import com.example.hexaarchspring.movie.persistence.converters.CategoryMapper;
import com.example.hexaarchspring.movie.persistence.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryRepositoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    @Override
    public Collection<Category> getAllCategories() {
        return categoryRepository.findAll().stream().map(c -> categoryMapper.categoryEntityToCategory(c))
                .collect(Collectors.toList());
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(categoryMapper.categoryToCategoryEntity(category));
    }

    @Override
    public Boolean doesCategoryNameExists(String name) {
        return !categoryRepository.findByName(name).isEmpty();
    }
}
