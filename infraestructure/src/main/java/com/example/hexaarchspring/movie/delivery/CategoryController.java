package com.example.hexaarchspring.movie.delivery;

import com.example.hexaarchspring.movie.delivery.rest.CategoryRest;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface CategoryController {

    ResponseEntity<Collection<CategoryRest>> getCategories() throws Exception;

    ResponseEntity<Boolean> createCategory(CategoryRest category) throws Exception;

}
