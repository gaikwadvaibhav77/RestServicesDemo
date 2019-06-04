package com.example.springbootswagger2.services;

import java.util.List;
import com.example.springbootswagger2.model.Student;

public interface StudentServices {
	public void createStudent(Student student);
    public List<Student> getStudent();
    public Student findById(long id);
    public Student update(Student Student, long l);
    public void deleteStudentById(long id);
    public Student updatePartially(Student Student, long id);
	public Student findBycountry(String country);
	public Student findByCls(String cls);


}
