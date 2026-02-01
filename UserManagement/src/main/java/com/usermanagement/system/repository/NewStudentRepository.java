package com.usermanagement.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.system.model.StudentForm;

@Repository
public interface NewStudentRepository extends JpaRepository<StudentForm,Long>{

	boolean existsByEmail(String email);

}
