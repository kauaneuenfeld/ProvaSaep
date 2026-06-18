package com.example.ProvaSaep.Service;

import com.example.ProvaSaep.Model.produtos;
import com.example.ProvaSaep.Model.saidas;
import com.example.ProvaSaep.Repository.produtosRepository;
import com.example.ProvaSaep.Repository.saidasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class saidasService {

    private final saidasRepository saidasRepository;
    private final produtosRepository produtosRepository;

    public saidas registrar(saidas saida){
        produtos produto = produtosRepository.findById(saida.getProduto().getId()).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        Integer quantidadeAtual = produto.getQuantidade();

        produto.setQuantidade(quantidadeAtual - saida.getQuantidadeSaida());
        produtosRepository.save(produto);
        saida.setProduto(produto);
        return saidasRepository.save(saida);
    }
}
