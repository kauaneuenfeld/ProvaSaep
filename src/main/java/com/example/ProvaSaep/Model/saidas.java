package com.example.ProvaSaep.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class saidas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private LocalDate dataSaida;

    @Positive(message = "A quantidade de saída deve ser positiva")
    private int quantidadeSaida;

    @ManyToOne
    private produtos produto;
}
