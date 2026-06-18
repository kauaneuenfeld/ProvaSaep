package com.example.ProvaSaep.Service;

import com.example.ProvaSaep.Model.entradas;
import com.example.ProvaSaep.Model.produtos;
import com.example.ProvaSaep.Repository.entradasRepository;
import com.example.ProvaSaep.Repository.produtosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class entradasService {

    private final produtosRepository produtosRepository;
    private final entradasRepository entradasRepository;

    public entradas registrar(entradas entrada){
        produtos produto = produtosRepository.findById(entrada.getProduto().getId()).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Integer quantidadeAtual = produto.getQuantidade();
        produto.setQuantidade(quantidadeAtual + entrada.getQuantidadeEntrada());

        produtosRepository.save(produto);
        entrada.setProduto(produto);
        return entradasRepository.save(entrada);
    }
}
