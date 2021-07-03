package com.example.demo.repository;

import com.example.demo.model.Numbers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NumbersInterface extends MongoRepository<Numbers,String> {

    @Query("{'value':?0}")
    Numbers findByValue(int value);

}
