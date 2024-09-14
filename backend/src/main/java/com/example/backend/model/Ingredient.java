package com.example.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY) // Faz o relacionamento com a tabela "recipes" (Uma receita pode ter vários ingredientes)
    @JoinColumn(name = "recipe_id") // Indica o nome da coluna que irá receber o id da tabela "recipes"
    private Recipe recipe;
}
