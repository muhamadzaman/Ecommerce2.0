package com.example.cartservice.Model;

import javax.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long inventory_id;

    private int quantity;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;


    public long getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(long inventory_id) {
        this.inventory_id = inventory_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Inventory(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public Inventory() {
    }



}
