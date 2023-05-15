package com.roomup.backend.repository;

import com.roomup.backend.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query(value = "SELECT * from student s where s.username = :username" , nativeQuery = true)
    Student getStudentIDbyUsername(@Param("username") String username);
}
