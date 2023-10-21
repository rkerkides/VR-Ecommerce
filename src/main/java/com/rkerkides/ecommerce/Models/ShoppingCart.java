package com.rkerkides.ecommerce.Models;

import lombok.*;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity  // JPA entity, mapped to a database table
@Table(name = "cart")  // Specifies the table name in the database
@AllArgsConstructor  // Lombok: Generates a constructor with all fields as arguments
@NoArgsConstructor  // Lombok: Generates a no-arg constructor
@Getter  // Lombok: Generates getter methods
@Setter  // Lombok: Generates setter methods
@ToString  // Lombok: Generates a toString method
public class ShoppingCart {

    @Id  // Marks 'id' as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generates the ID value
    private Long id;

    @Column(name = "user_id")  // Maps to 'user_id' column in the database
    private String userId;

    // One-to-many relationship with OrderItem
    // Items in the cart are lazily fetched and all operations are cascaded
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrderItem> items = new HashSet<>();
}
