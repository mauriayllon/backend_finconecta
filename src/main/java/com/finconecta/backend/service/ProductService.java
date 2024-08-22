package com.finconecta.backend.service;

import com.finconecta.backend.dto.ProductDto;
import com.finconecta.backend.model.domain.Product;
import com.finconecta.backend.model.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Flux<Product> findAll() {
        return productRepository.findAll();
    }

    public Flux<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public Mono<Product> findById(UUID id) {
        return productRepository.findById(id);
    }

    public Mono<Product> save(ProductDto productDto) {
            Product product = productDtoToEntity(productDto);
            return productRepository.save(product);
    }

    public Mono<Product> update(UUID id, ProductDto updatedProduct) {
        return productRepository.findById(id)
                .flatMap(existingProduct -> {
                    existingProduct.setName(updatedProduct.getName());
                    existingProduct.setPrice(updatedProduct.getPrice());
                    existingProduct.setStored(updatedProduct.getStored());

                    return productRepository.save(existingProduct);
                })
                .switchIfEmpty(Mono.error(new RuntimeException("Product not found")));
    }

    public Mono<Void> deleteById(UUID id) {
        return productRepository.deleteById(id);
    }

    public Mono<Void> deleteAll() {
        return productRepository.deleteAll();
    }

    public Flux<Product> findByStorage(boolean isStored) {
        return productRepository.findByStored(isStored);
    }

    public static Product productDtoToEntity(ProductDto productDto){
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }
}
