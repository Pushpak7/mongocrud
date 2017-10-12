package com.mongodemo1.mongocrud.controller;

import com.mongodemo1.mongocrud.model.Student;
import com.mongodemo1.mongocrud.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by pushpak on 11/10/17.
 */
@RestController
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;


    @PostMapping(value = "/savestudentdata")
    String savestudentdata(@RequestBody Student student) {
        studentRepo.save(student);
        return "successful data transfer";
    }

    @GetMapping(value = "/getstudentdata")
    Student getstudentdata(@RequestParam String id) {
        Student st = studentRepo.findOne(id);
        return st;
    }

    @GetMapping(value = "/getalldata")
    List<Student> getalldata() {
        List<Student> list = studentRepo.findAll();
        return list;
    }


    @RequestMapping(value = "delete/{id}")
    ResponseEntity<?> deleteData(@PathVariable String id) {
        ResponseEntity<String> entity = null;
        studentRepo.delete(id);
        entity = new ResponseEntity<String>("Delete Success", HttpStatus.OK);
        return entity;
    }


    @GetMapping(value = "/getnameandcity")
    List<Student> getnameandcity(@RequestParam String name, @RequestParam String city) {
        List<Student> list = studentRepo.findByNameAndCity(name, city);
        return list;
    }

    @GetMapping(value = "/getbyname")
    Student getData2(@RequestParam String name) {
        Student s = studentRepo.findByName(name);
        return s;
    }



    @GetMapping(value = "/getnameorcity")
        List<Student> dataOr(@RequestParam String name,@RequestParam String city){
           List<Student> list=studentRepo.findByNameOrCity(name,city);
            return list;
        }

            @GetMapping(value = "getdatabetweenids")

            List<Student> getdatabetweenids(@RequestParam Integer id1,@RequestParam Integer id2){
            List<Student>lst=studentRepo.findByIdBetween(id1,id2);
            return  lst;

            }


                 @GetMapping(value = "/getlessthan")
                 List<Student> getless(@RequestParam Integer id){
                     List<Student> list=studentRepo.findByIdLessThan(id);
                     return list;
                 }   }



