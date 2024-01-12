package com.rediscache.redis.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product implements Serializable {
    private static final long serialVersionUID = 4L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long prodId;
    private String productName;
    private String uom;
    //NoArgsConstructor
    //AllArgsConstructor
    //getters and setters
    //ToString
    //EqualsAndHashCode
    //RequiredArgsConstructor

}
