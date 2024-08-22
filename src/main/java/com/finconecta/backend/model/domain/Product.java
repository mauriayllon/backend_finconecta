package com.finconecta.backend.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "product")
public class Product implements Serializable {

    @Id
    private UUID id;

    private String name;

    private Double price;

    private Boolean stored;
}