package com.usermanagement.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.system.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

	Optional<Student> findByEmail(String email);

	boolean existsByEmail(String email);
	

}
