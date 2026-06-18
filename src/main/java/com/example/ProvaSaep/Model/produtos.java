package com.example.ProvaSaep.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotBlank(message = "O nome do produto é obrigatório")
    private String nome;

    @NotBlank(message = "A categoria do produto é obrigatoria")
    private String categoria;

    @Min(value = 0, message = "A quantidade em estoque não pode ser negativa")
    @Max(value = 100, message = "O valor maximo é 100")
    private int quantidade;

    @Positive(message = "O preço do produto é obrigatório")
    private double preco_Unitario;


}