package com.example.proto.repo;

import com.example.proto.model.Travel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TravelRepo extends CrudRepository<Travel,Long>{

    List<Travel> findAllByUser_Email(String email);
}
