package com.example.cartservice.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cart {
    @Id
    private Long cart_id;
    private int quantity;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

}
