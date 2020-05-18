package com.example.hexaarchspring.movie.category.usecase;


import com.example.hexaarchspring.movie.category.Category;
import com.example.hexaarchspring.movie.category.exception.CategoryAlreadyExistException;

public interface CreateCategoryUseCase {

    public void execute(Category category) throws CategoryAlreadyExistException;
}
