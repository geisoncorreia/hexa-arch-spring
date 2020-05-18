package com.example.hexaarchspring.movie.persistence.converters;

import com.example.hexaarchspring.movie.category.Category;
import com.example.hexaarchspring.movie.persistence.entities.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {

    Category categoryEntityToCategory(CategoryEntity categoryEntity);

    CategoryEntity categoryToCategoryEntity(Category category);
}
