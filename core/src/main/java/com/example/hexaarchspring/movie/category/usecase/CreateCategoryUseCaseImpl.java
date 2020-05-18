package com.example.hexaarchspring.movie.category.usecase;


import com.example.hexaarchspring.movie.category.Category;
import com.example.hexaarchspring.movie.category.exception.CategoryAlreadyExistException;
import com.example.hexaarchspring.movie.category.ports.CategoryRepositoryService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {

    private final CategoryRepositoryService categoryRepositoryService;

    @Override
    public void execute(Category category) throws CategoryAlreadyExistException {

        if(categoryRepositoryService.doesCategoryNameExists(category.getName())) {
            throw new CategoryAlreadyExistException();
        }

        categoryRepositoryService.saveCategory(category);

    }
}
