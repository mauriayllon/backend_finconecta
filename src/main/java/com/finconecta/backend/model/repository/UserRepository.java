package com.finconecta.backend.model.repository;

import com.finconecta.backend.model.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User,String>  {

}
