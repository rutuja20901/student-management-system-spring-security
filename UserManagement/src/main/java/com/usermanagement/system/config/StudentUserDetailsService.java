package com.usermanagement.system.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.usermanagement.system.model.Student;
import com.usermanagement.system.repository.StudentRepository;


@Service
public class StudentUserDetailsService implements UserDetailsService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Student student = studentRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Student not found!"));
		
		return User.builder()
                .username(student.getEmail())
                .password(student.getPassword())
                .roles("STUDENT")
                .build();
	}

}
