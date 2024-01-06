package com.rediscache.redis.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "products")
public class Product implements Serializable {
    private static final long serialVersionUID = 4L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long prodId;
    private String productName;
    //NoArgsConstructor
    //AllArgsConstructor
    //getters and setters
    //ToString
    //EqualsAndHashCode
    //RequiredArgsConstructor

}
