package com.example.userservice.Model;


import javax.persistence.*;

@Entity
@Table(name = "productsx")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long product_id;
    private String name;
    private String sku;
    private String images;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", name='" + name + '\'' +
                ", sku='" + sku + '\'' +
                ", images='" + images + '\'' +
                ", description='" + description + '\'' +
                ", user="  +user+
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product(String name, String sku, String images, String description) {
        this.name = name;
        this.sku = sku;
        this.images = images;
        this.description = description;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
