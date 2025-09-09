package com.gilang.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orders") // biar tabel DB lebih jelas
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long produkId;
    private Long pelangganId;
    private int jumlah;
    private String tanggal;  // bisa pakai LocalDate kalau mau lebih rapi
    private String status;
    private double total;
}
