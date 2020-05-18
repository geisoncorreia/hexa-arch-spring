package com.example.hexaarchspring.movie.delivery.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRest {

    private String name;

    private Boolean available;
}
