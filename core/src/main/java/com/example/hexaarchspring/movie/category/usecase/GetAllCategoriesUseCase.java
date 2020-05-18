package com.example.hexaarchspring.movie.category.usecase;


import com.example.hexaarchspring.movie.category.Category;

import java.util.Collection;

public interface GetAllCategoriesUseCase {

    public Collection<Category> execute();

}
