package com.example.springbootswagger2.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootswagger2.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	Student findByCountry(String country);

	Student findBycls(String cls);





}
