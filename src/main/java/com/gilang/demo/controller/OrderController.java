package com.gilang.demo.controller;

import com.gilang.demo.model.Order;
import com.gilang.demo.service.OrderService;
import com.gilang.demo.vo.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // GET semua order
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // GET order by ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
    }

    // POST buat order baru
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    // DELETE order by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }

    // GET order beserta produk dan pelanggan
    @GetMapping("/{id}/detail")
    public ResponseEntity<List<ResponseTemplate>> getOrderDetail(@PathVariable Long id) {
        List<ResponseTemplate> detail = orderService.getOrderWithProdukById(id);
        if (detail.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detail);
    }
}