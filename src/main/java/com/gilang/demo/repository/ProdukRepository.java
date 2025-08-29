package com.gilang.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gilang.demo.model.Produk;

@Repository
public interface ProdukRepository extends JpaRepository<Produk, Long> {
}
