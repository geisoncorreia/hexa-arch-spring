package com.example.hexaarchspring.movie.persistence.repositories;

import com.example.hexaarchspring.movie.persistence.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    public Collection<CategoryEntity> findByName(String name);
}
