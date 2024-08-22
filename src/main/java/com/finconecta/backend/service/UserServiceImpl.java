package com.finconecta.backend.service;

import com.finconecta.backend.dto.UserDto;
import com.finconecta.backend.model.domain.User;
import com.finconecta.backend.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService  {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<User> saveUser(UserDto UserDto){
        if(Objects.nonNull(UserDto)){
            return userRepository.save(UserDtoToEntity(UserDto));
        }else{
            return null;
        }
    }

    @Override
    public Mono<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> update(UserDto UserDto) {
        return this.userRepository.findById(UserDto.getId())
                .map(org -> UserDtoToEntity(UserDto))
                .flatMap(this.userRepository::save);
    }

    @Override
    public Mono<Void> delete(String id) {
        return userRepository.deleteById(id);
    }

    public static User UserDtoToEntity(UserDto userDto){
        User user= new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }

}
