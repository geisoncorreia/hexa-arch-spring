package com.example.hexaarchspring.movie.delivery.converters;

import com.example.hexaarchspring.movie.category.Category;
import com.example.hexaarchspring.movie.delivery.rest.CategoryRest;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryRestMapper {

    Category categoryRestToCategory(CategoryRest category);

    CategoryRest categoryToCategoryRest(Category category);
}
