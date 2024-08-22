package com.finconecta.backend.controller;

import com.finconecta.backend.dto.UserDto;
import com.finconecta.backend.model.domain.User;
import com.finconecta.backend.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/all")
    public Flux<User> findAll() {
        Flux<User> orgAll = userService.findAll();
        return orgAll;
    }

    @GetMapping("/{id}")
    public Mono<User> getUserById(@PathVariable String id) {
        return userService.findById(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes={"application/json"})
    public ResponseEntity<Mono<User>> createUser(@RequestBody UserDto userDto) {
        Mono<User> userSave = userService.saveUser(userDto);
        return new ResponseEntity<Mono<User>>(userSave, HttpStatus.OK);
    }

    @PutMapping("/update")
    public Mono<User> updateUser(@RequestBody UserDto user) {
        return userService.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id) {
        userService.delete(id).subscribe();
    }
}