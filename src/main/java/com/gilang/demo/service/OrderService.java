package com.gilang.demo.service;

import com.gilang.demo.model.Order;
import com.gilang.demo.vo.ResponseTemplate;
import com.gilang.demo.model.Produk;
import com.gilang.demo.model.Pelanggan;
import com.gilang.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    // Ambil semua order
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Ambil order berdasarkan ID
    public Order getOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElse(null);
    }

    // Buat order baru
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // Hapus order
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    // Ambil order beserta produk dan pelanggan berdasarkan ID
    public List<ResponseTemplate> getOrderWithProdukById(Long id) {
        List<ResponseTemplate> responseList = new ArrayList<>();
        Order order = getOrderById(id);

        if (order != null) {
            Produk produk = restTemplate.getForObject(
                "http://localhost:8081/api/produk/" + order.getProdukId(),
                Produk.class
            );

            Pelanggan pelanggan = restTemplate.getForObject(
                "http://localhost:8082/api/pelanggan/" + order.getPelangganId(),
                Pelanggan.class
            );

            ResponseTemplate vo = new ResponseTemplate();
            vo.setOrder(order);
            vo.setProduk(produk);
            vo.setPelanggan(pelanggan);

            responseList.add(vo);
        }

        return responseList;
    }
}