package com.example.hexaarchspring.movie.category.usecase;

import com.example.hexaarchspring.movie.category.Category;
import com.example.hexaarchspring.movie.category.ports.CategoryRepositoryService;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

@RequiredArgsConstructor
public class GetAllCategoriesUseCaseImpl implements GetAllCategoriesUseCase {

    private final CategoryRepositoryService categoryRepositoryService;

    @Override
    public Collection<Category> execute() {
        return categoryRepositoryService.getAllCategories();
    }
}
