package com.example.hexaarchspring.movie.delivery.impl;

import com.example.hexaarchspring.movie.category.usecase.CreateCategoryUseCase;
import com.example.hexaarchspring.movie.category.usecase.GetAllCategoriesUseCase;
import com.example.hexaarchspring.movie.delivery.CategoryController;
import com.example.hexaarchspring.movie.delivery.converters.CategoryRestMapper;
import com.example.hexaarchspring.movie.delivery.rest.CategoryRest;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
//@RequiredArgsConstructor
@Service
public class CategoryControllerImpl implements CategoryController {

//    @Qualifier("getAllCategoriesUseCase")
    private final GetAllCategoriesUseCase getAllCategoriesUseCase;

    private final CreateCategoryUseCase createCategoryUseCase;

    public CategoryControllerImpl(GetAllCategoriesUseCase getAllCategoriesUseCase, CreateCategoryUseCase createCategoryUseCase) {
        this.getAllCategoriesUseCase = getAllCategoriesUseCase;
        this.createCategoryUseCase = createCategoryUseCase;
    }

    private final CategoryRestMapper categoryRestMapper = Mappers.getMapper(CategoryRestMapper.class);

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/categories")
    public ResponseEntity<Collection<CategoryRest>> getCategories() throws Exception {

        if(getAllCategoriesUseCase.execute().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(
                getAllCategoriesUseCase.execute()
                        .stream().map(c -> categoryRestMapper.categoryToCategoryRest(c))
                        .collect(Collectors.toList()));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/categories", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createCategory(CategoryRest category) throws Exception {
        createCategoryUseCase.execute(categoryRestMapper.categoryRestToCategory(category));
        return new ResponseEntity<Boolean>(HttpStatus.CREATED);
    }
}
