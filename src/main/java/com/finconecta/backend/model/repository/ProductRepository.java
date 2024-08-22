package com.finconecta.backend.model.repository;

import com.finconecta.backend.model.domain.Product;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface ProductRepository extends R2dbcRepository<Product, UUID> {
    Flux<Product> findByName(String name);

    Flux<Product> findByStored(boolean isStored);
}
