package com.finconecta.backend.service;

import com.finconecta.backend.dto.UserDto;
import com.finconecta.backend.model.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> saveUser(UserDto UserDto);

    Mono<User> findById(String id);

    Flux<User> findAll();

    Mono<User> update(UserDto UserDto);

    Mono<Void> delete(String id);
}
