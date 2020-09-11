package com.example.hexaarchspring.movie.category;

import com.example.hexaarchspring.movie.shared.SelfValidating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category extends SelfValidating<Category> implements Serializable {

//    @Min(0)
    private Long id;

    @NotEmpty
    private String name;

    @NonNull
    private Boolean available;

}