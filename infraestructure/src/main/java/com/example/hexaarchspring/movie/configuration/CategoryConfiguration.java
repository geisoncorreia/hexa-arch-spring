package com.example.hexaarchspring.movie.configuration;


import com.example.hexaarchspring.movie.category.usecase.CreateCategoryUseCaseImpl;
import com.example.hexaarchspring.movie.category.usecase.GetAllCategoriesUseCaseImpl;
import com.example.hexaarchspring.movie.persistence.impl.CategoryServiceImpl;
import com.example.hexaarchspring.movie.persistence.repositories.CategoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfiguration {

    private final CategoryRepository categoryRepository;

    public CategoryConfiguration(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Bean
    public CategoryServiceImpl createCategoryServiceImpl() {
        return new CategoryServiceImpl(categoryRepository);
    }

    @Bean
    public GetAllCategoriesUseCaseImpl createGetAllCategoriesUseCase() {
        return new GetAllCategoriesUseCaseImpl(createCategoryServiceImpl());
    }

    @Bean
    public CreateCategoryUseCaseImpl createCreateCategoryUseCase() {
        return new CreateCategoryUseCaseImpl(createCategoryServiceImpl());
    }

}
