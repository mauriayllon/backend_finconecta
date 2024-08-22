package com.finconecta.backend.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public @Data class UserDto implements Serializable {
    @Id
    private String id;

    private String name;

    private String email;
}