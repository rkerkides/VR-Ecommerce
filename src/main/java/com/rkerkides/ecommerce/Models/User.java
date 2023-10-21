package com.rkerkides.ecommerce.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  // Marks this class as a JPA entity
@NoArgsConstructor  // Generates a no-argument constructor
@Data  // Generates getters, setters, equals, hashCode, and toString methods
public class User {

    @SequenceGenerator(
            name = "user_sequence",  // Logical name for the generator
            sequenceName = "user_sequence",  // Actual database sequence name
            allocationSize = 1  // Increment by 1 each time a new value is needed
    )
    // The above annotation defines a sequence generator for primary key

    private Long id; // Primary key
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)  // Enum will be stored as a string
    private UserRole UserRole;

    // Constructor to initialize all fields except id
    public User(String firstName, String lastName, String email, String password, com.rkerkides.ecommerce.Models.UserRole userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.UserRole = userRole;
    }
}
