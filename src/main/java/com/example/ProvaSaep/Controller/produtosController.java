package com.example.ProvaSaep.Controller;

import com.example.ProvaSaep.Model.produtos;
import com.example.ProvaSaep.Repository.produtosRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class produtosController {
    private final produtosRepository produtosRepository;

    @GetMapping
    public List<produtos> listar(){
        return produtosRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<produtos> cadastrar(@Valid @RequestBody produtos produtos) {
        return ResponseEntity.status(201).body(produtosRepository.save(produtos));
    }

    @GetMapping("/categoria")
    public List<produtos> listarPorCategoria() {
        return produtosRepository.findAllOrderByNomeAndCategoria();
    }

    @GetMapping("/{id}")
    public ResponseEntity<produtos> buscarPorId(@PathVariable Long id) {
        return produtosRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
