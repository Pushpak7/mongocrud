package com.mongodemo1.mongocrud.repository;

import com.mongodemo1.mongocrud.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


/**
 * Created by pushpak on 10/10/17.
 */

public interface StudentRepo extends MongoRepository<Student,String>{


    @Query(value = "{'id':'?0'}")
    Student findOne(String id);
    Student findByName(String name);

    List<Student> findByNameAndCity(String name, String city);

    List<Student> findByNameOrCity(String name, String city);

    List<Student> findByIdBetween(Integer id1, Integer id2);

    List<Student> findByIdLessThan(Integer id);
}
