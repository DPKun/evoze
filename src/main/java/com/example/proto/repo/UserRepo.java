package com.example.proto.repo;

import com.example.proto.model.User;
import org.springframework.data.repository.CrudRepository;



public interface UserRepo extends CrudRepository<User,String> {
    User findByEmail(String email);

}
