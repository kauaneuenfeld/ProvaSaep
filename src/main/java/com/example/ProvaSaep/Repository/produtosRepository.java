package com.example.ProvaSaep.Repository;

import com.example.ProvaSaep.Model.produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface produtosRepository extends JpaRepository<produtos, Long> {

    @Query("SELECT p FROM produtos p ORDER BY p.nome ASC, p.categoria ASC")
    List<produtos> findAllOrderByNomeAndCategoria();

    @Query("SELECT p FROM produtos p WHERE p.quantidade = 0 OR p.quantidade = 100")
    List<produtos> findProdutosEmLimites();

}
