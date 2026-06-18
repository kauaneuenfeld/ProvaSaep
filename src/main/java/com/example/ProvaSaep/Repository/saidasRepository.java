package com.example.ProvaSaep.Repository;

import com.example.ProvaSaep.Model.saidas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface saidasRepository extends JpaRepository<saidas, Long> {

    @Query("SELECT s FROM saidas s ORDER BY s.dataSaida DESC")
    List<saidas> findAllOrderByData();

    List<saidas> findByDataSaidaBetween(LocalDate dataInicio, LocalDate dataFim);

    @Query("SELECT s FROM saidas s WHERE s.dataSaida BETWEEN :inicio AND :fim ORDER BY s.dataSaida DESC")
    List<saidas> findByPeriodo(@Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim);

}
