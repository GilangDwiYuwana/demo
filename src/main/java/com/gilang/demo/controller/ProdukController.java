package com.gilang.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gilang.demo.model.Produk;
import com.gilang.demo.service.ProdukService;

@RestController
@RequestMapping("/api/produk")
public class ProdukController {

    @Autowired
    private ProdukService produkService;

    @GetMapping
    public List<Produk> getAllProduks() {
        return produkService.getAllProduks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produk> getProdukById(@PathVariable Long id) {
        Produk produk = produkService.getProdukById(id);
        return produk != null ? ResponseEntity.ok(produk) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Produk createProduk(@RequestBody Produk produk) {
        return produkService.createProduk(produk);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduk(@PathVariable Long id) {
        produkService.deleteProduk(id);
        return ResponseEntity.ok().build();
    }
}
