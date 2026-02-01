package com.usermanagement.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagement.system.model.Student;
import com.usermanagement.system.model.StudentForm;
import com.usermanagement.system.repository.NewStudentRepository;

@Service
public class NewStudentService {
	
	@Autowired
	private NewStudentRepository newStudentRepository;

	
	 public void save(StudentForm student) {
		 
		 if(student.getId() == null)
			{
				if(newStudentRepository.existsByEmail(student.getEmail())) {
					throw new RuntimeException("Email Already Exists!");
				}
			}
		 newStudentRepository.save(student);
	    }

	 
	    public List<StudentForm> findAll() {
	        return newStudentRepository.findAll();
	    }

	    

	    public void delete(Long id) {
	    	newStudentRepository.deleteById(id);
	    }
	    
}
