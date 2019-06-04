package com.example.springbootswagger2.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootswagger2.model.Student;
import com.example.springbootswagger2.model.repository.StudentRepository;
import com.example.springbootswagger2.services.StudentServices;
@Service
@Transactional
public class StudentImpl implements StudentServices {
	@Autowired
	StudentRepository studentRepository;

    public void createStudent(Student student) {
        // TODO Auto-generated method stub
    	studentRepository.save(student);
    }
    public List<Student> getStudent() {
        // TODO Auto-generated method stub
        return (List<Student>) studentRepository.findAll();
    }
    @Override
    public Student findById(long id) {
        // TODO Auto-generated method stub
        return studentRepository.findOne(id);
    }
    @Override
    public Student update(Student user, long l) {
        // TODO Auto-generated method stub
        return studentRepository.save(user);
    }
    @Override
    public void deleteStudentById(long id) {
        // TODO Auto-generated method stub
    	studentRepository.delete(id);
    }
    @Override
    public Student updatePartially(Student user, long id) {
        // TODO Auto-generated method stub
        Student student = findById(id);
        student.setCountry(user.getCountry());
        return studentRepository.save(student);
    }
	@Override
	public Student findBycountry(String country) {
		// TODO Auto-generated method stub
		return studentRepository.findByCountry(country);
	}
	@Override
	public Student findByCls(String cls) {
		// TODO Auto-generated method stub
		return studentRepository.findBycls(cls);
	}
	
}