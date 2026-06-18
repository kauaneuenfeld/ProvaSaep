package com.example.ProvaSaep.Controller;

import com.example.ProvaSaep.Model.entradas;
import com.example.ProvaSaep.Repository.entradasRepository;
import com.example.ProvaSaep.Service.entradasService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entradas")
@RequiredArgsConstructor
public class entradasController {
    private final entradasRepository entradasRepository;
    private final entradasService entradasService;

    @GetMapping
    public List<entradas> listar(){
        return entradasRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<entradas> cadastrar (@Valid @RequestBody entradas entrada) {
        return ResponseEntity.status(201).body(entradasService.registrar(entrada));
    }

    @GetMapping("/{id}")
    public ResponseEntity<entradas> buscarPorId(@PathVariable Long id) {
        return entradasRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}