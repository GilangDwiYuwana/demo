package com.gilang.demo.vo;

import com.gilang.demo.model.Order;
import com.gilang.demo.model.Produk;
import com.gilang.demo.model.Pelanggan;
import java.util.Objects;

public class ResponseTemplate {
    private Order order;
    private Produk produk;
    private Pelanggan pelanggan;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Produk getProduk() {
        return produk;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    @Override
    public String toString() {
        return "ResponseTemplate{" +
                "order=" + order +
                ", produk=" + produk +
                ", pelanggan=" + pelanggan +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseTemplate that = (ResponseTemplate) o;
        return Objects.equals(order, that.order) &&
               Objects.equals(produk, that.produk) &&
               Objects.equals(pelanggan, that.pelanggan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, produk, pelanggan);
    }
}