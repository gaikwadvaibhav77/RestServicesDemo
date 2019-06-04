package com.example.springbootswagger2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.springbootswagger2.model.Student;
import com.example.springbootswagger2.services.StudentServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Swagger2DemoRestController", description = "REST Apis related to Student Entity!!!!")
@RestController
public class Swagger2DemoRestController {
	@Autowired
	StudentServices studentService;

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	//@ApiOperation(value = "Get specific Student By id in the System ", response = Student.class, tags = "getStudentByID")
	@GetMapping(value = "/fetch/{id}", headers = "Accept=application/json")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) {
		System.out.println("Fetching Student with id " + id);
		Student Student = studentService.findById(id);
		if (Student == null) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(Student, HttpStatus.OK);
	}

	//@ApiOperation(value = "Retrive list of student in list  ", response = Student.class, tags = "ListOfStudent")
	@GetMapping(value = "/get", headers = "Accept=application/json")
	public List<Student> getAllStudent() {
		List<Student> tasks = studentService.getStudent();
		return tasks;

	}

//	@ApiOperation(value = "Get specific Student By Country", response = Student.class, tags = "getStudentByCountry")
	// @RequestMapping(value = "/getStudentByCountry/{country}",
	// method=RequestMethod.GET)
	@GetMapping(value = "/getStudentByCountry/{country}", headers = "Accept=application/json")
	public ResponseEntity<Student> getStudentByCountry(@PathVariable(value = "country") String country) {
		System.out.println("Searching Student in country : " + country);
		Student Student = studentService.findBycountry(country);
		if (Student == null) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(Student, HttpStatus.OK);
	}

	//@ApiOperation(value = "Get specific Student By Class ", response = Student.class, tags = "getStudentByClass")
	// @RequestMapping(value = "/getStudentByClass/{cls}", method=
	// RequestMethod.GET)
	@GetMapping(value = "/getStudentByClass/{cls}", headers = "Accept=application/json")
	public ResponseEntity<Student> getStudentByClass(@PathVariable(value = "cls") String cls) {
		Student student = studentService.findByCls(cls);
		if (student == null) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	//@ApiOperation(value = "create new Student", response = Student.class, tags = "CreateNewStudent")
	@PostMapping(value = "/create", headers = "Accept=application/json")
	public ResponseEntity<Void> createStudent(@RequestBody Student Student, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Student " + Student.getName());
		studentService.createStudent(Student);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/Student/{id}").buildAndExpand(Student.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping(value = "/update", headers = "Accept=application/json")
	public ResponseEntity<String> updateStudent(@RequestBody Student currentStudent) {
		System.out.println("sd");
		Student Student = studentService.findById(currentStudent.getId());
		if (Student == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		studentService.update(currentStudent, currentStudent.getId());
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	//@ApiOperation(value = "Delete student by id", response = Student.class, tags = "DeleteStudentById")
	@DeleteMapping(value = "/cde/{id}", headers = "Accept=application/json")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") long id) {
		Student Student = studentService.findById(id);
		if (Student == null) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		studentService.deleteStudentById(id);
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}

	@PatchMapping(value = "/abc/{id}", headers = "Accept=application/json")
	public ResponseEntity<Student> updateStudentPartially(@PathVariable("id") long id,
			@RequestBody Student currentStudent) {
		Student Student = studentService.findById(id);
		if (Student == null) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		Student usr = studentService.updatePartially(currentStudent, id);
		return new ResponseEntity<Student>(usr, HttpStatus.OK);
	}
}
