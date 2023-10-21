package com.rkerkides.ecommerce.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.UUID;

@Entity  // JPA entity, mapped to a database table
@Table(name = "item")  // Specifies the table name in the database
@Getter  // Lombok: Generates getter methods
@Setter  // Lombok: Generates setter methods
@NoArgsConstructor  // Lombok: Generates a no-arg constructor
@AllArgsConstructor  // Lombok: Generates a constructor with all fields as arguments
public class OrderItem {

    @Id  // Marks 'id' as the primary key
    private String id;

    @OneToOne  // One-to-one relationship with Product
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)  // Many-to-one relationship with ShoppingCart, not optional
    @JoinColumn(name = "cart_id", nullable = false)  // Foreign key column
    @JsonIgnore  // Ignore this field during JSON serialization
    private ShoppingCart cart;

    private int quantity;  // Quantity of the product in the cart

    // Method to populate fields from DTO
    public void fromDto(Product p, ShoppingCart cart, int quantity) {
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.product = p;
        this.cart = cart;
        this.quantity = quantity;
    }
}
