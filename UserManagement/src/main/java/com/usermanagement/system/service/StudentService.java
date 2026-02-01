package com.usermanagement.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.usermanagement.system.dto.LoginRequest;
import com.usermanagement.system.dto.RegisterRequest;
import com.usermanagement.system.model.Student;
import com.usermanagement.system.model.StudentForm;
import com.usermanagement.system.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// Register Student
	public Student register(RegisterRequest request) {
		
		
		Student student = new Student();
		if(student.getId() == null) {
			if(studentRepository.existsByEmail(student.getEmail())){
				throw new RuntimeException("Email already exists!");
			}
		}
		
		student.setName(request.getName());
		student.setEmail(request.getEmail());
		student.setAge(request.getAge());
		student.setPassword(passwordEncoder.encode(request.getPassword()));
		return studentRepository.save(student);
	}
	
	
	
	
	
	
}
