package com.example.ProvaSaep.Repository;

import com.example.ProvaSaep.Model.entradas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface entradasRepository extends JpaRepository<entradas, Long> {

    @Query("SELECT e FROM entradas e ORDER BY e.dataEntrada DESC")
    List<entradas> findAllOrderByData();

    List<entradas> findByDataEntradaBetween(LocalDate dataInicio, LocalDate dataFim);

    @Query("SELECT e FROM entradas e WHERE e.dataEntrada BETWEEN :inicio AND :fim ORDER BY e.dataEntrada DESC")
    List<entradas> findByPeriodo(@Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim);

}
