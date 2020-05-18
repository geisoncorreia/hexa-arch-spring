package com.example.hexaarchspring.movie.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorySeq")
    @SequenceGenerator(name = "categorySeq", sequenceName = "category_id_seq", allocationSize=1)
    private Long id;

    @Column(name = "NAME", unique = true)
    private String name;

    @Column(name = "AVAILABLE", unique = true)
    private Boolean available;

}
