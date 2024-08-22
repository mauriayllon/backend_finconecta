package com.finconecta.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public @Data class ProductDto implements Serializable {

    private String name;

    private Double price;

    private Boolean stored;
}
