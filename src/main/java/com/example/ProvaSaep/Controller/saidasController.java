package com.example.ProvaSaep.Controller;

import com.example.ProvaSaep.Model.saidas;
import com.example.ProvaSaep.Repository.saidasRepository;
import com.example.ProvaSaep.Service.saidasService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/saidas")
@RequiredArgsConstructor
public class saidasController {
    private final saidasRepository saidasRepository;
    private final saidasService saidasService;

    @GetMapping
    public List<saidas> listar() {
        return saidasRepository.findAllOrderByData();
    }

    @PostMapping
    public ResponseEntity<saidas> cadastrar(@Valid @RequestBody saidas saidas) {
        return ResponseEntity.status(201).body(saidasService.registrar(saidas));
    }

    @GetMapping("/data")
    public List<saidas> listarPorData(@RequestParam LocalDate inicio, @RequestParam LocalDate fim) {
        return saidasRepository.findByDataSaidaBetween(inicio, fim);
    }

    @GetMapping("/{id}")
    public ResponseEntity<saidas> buscarPorId(@PathVariable Long id) {
        return saidasRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
