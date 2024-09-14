package com.example.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    // cascade: aplica todas as mudanças (delete, update) da classe pai(recipe) para a classe filha (ingredient)
    // orphanRemoval: garante que entidades filhas que não estão mais associadas à entidade pai sejam removidas automaticamente do banco de dados
    private List<Ingredient> ingredients = new ArrayList<>();

    @Column(nullable = false)
    private String method;

    @Column(nullable = false)
    private String description;
}
