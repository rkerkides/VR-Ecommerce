package com.rkerkides.ecommerce.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity  // JPA entity, mapped to a database table
@Table(name = "Headset")  // Specifies the table name in the database
@Getter  // Lombok: Generates getter methods
@Setter  // Lombok: Generates setter methods
@NoArgsConstructor  // Lombok: Generates a no-arg constructor
@AllArgsConstructor  // Lombok: Generates a constructor with all fields as arguments
@ToString  // Lombok: Generates a toString method
public class Product {
    @Id  // Marks 'id' as the primary key
    Long id;

    // Database column mappings with custom field names.
    // The prefixes "b_", "c_", etc., are used to control the alphabetical
    // ordering of columns in database tools that list columns alphabetically.
    // This ensures that related columns are grouped together in such listings.
    @Column(name = "brand")
    String b_brand;
    @Column(name = "image")
    String c_image;
    @Column(name = "price")
    String d_price;
    @Column(name = "arrival")
    String e_arrival;
    @Column(name = "discount")
    int f_discount;
}
