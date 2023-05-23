package com.example.productservice.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "checkouts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long checkout_id;

    @Enumerated(EnumType.ORDINAL)
    private Status quantity;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;


}

enum Status{
    PROCESSING,
    COMPLETED
}