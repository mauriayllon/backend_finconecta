package com.finconecta.backend.controller;

import com.finconecta.backend.dto.ProductDto;
import com.finconecta.backend.model.domain.Product;
import com.finconecta.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Product> getAllProducts() {
        Flux<Product> prodAll= productService.findAll();
        return prodAll;
    }

    @GetMapping("/getById")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Product> getProductById(@RequestParam("id") UUID id) {
        return productService.findById(id);
    }

    @GetMapping("/search/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Product> getProductByName(@PathVariable("name") String name) {
        return productService.findByName(name);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> createProduct(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Product> updateProduct(@PathVariable("id") UUID id, @RequestBody ProductDto productDto) {
        return productService.update(id, productDto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteProduct(@PathVariable("id") UUID id) {
        return productService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAllProducts() {
        return productService.deleteAll();
    }

    @GetMapping("/stored")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Product> findByStored() {
        return productService.findByStorage(true);
    }
}
