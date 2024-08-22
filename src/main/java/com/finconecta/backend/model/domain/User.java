package com.finconecta.backend.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public @Data class User implements Serializable {

    @Id
    private String id;

    private String name;

    private String email;
}