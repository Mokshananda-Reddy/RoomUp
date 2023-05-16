package com.roomup.backend.controller;

import com.roomup.backend.model.Student;
import com.roomup.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @PostMapping("/student")
    Student newStudent(@RequestBody Student newStudent)
    {
        try
        {
            logger.info("[STUDENT] - " + "Received New Student Creation Request: {}", newStudent);
            Student savedStudent = studentRepository.save(newStudent);
            logger.info("[RESULT - STUDENT] - " + "Successfully Created New Student: {}", savedStudent);
            return studentRepository.save(savedStudent);

        } catch(Exception e)
        {
            logger.error("[ERROR - STUDENT] - " + "Error occurred while creating a New Student: {}", e.getMessage());
            throw e;
        }
    }

    @GetMapping("/students")
    List<Student> getAllStudents()
    {
        try {
            logger.info("[STUDENTS] - Received Request to Get All Students");
            List<Student> students = studentRepository.findAll();
            logger.info("[RESULT - STUDENTS] - " + "Successfully Retrieved {} Students", students.size());
            return students;
        } catch (Exception e) {
            logger.error("[ERROR - STUDENTS] - " + "Error occurred while retrieving Students: {}", e.getMessage());
            throw e;
        }
    }

    @GetMapping("/getstudentid")
    Student getCurrentStudentDetails(@RequestParam("username") String username)
    {
        logger.info("[STUDENT_DETAILS] - Received Request to get the Student Details by Username: {}", username);
        Student s1 = new Student(null, null, null, null, null, null, null, null);
        try
        {
            logger.info("[RESULT - STUDENT_DETAILS] - " + "Successfully Retrieved Student Details by Username: {}", username);
            Student s = studentRepository.getStudentIDbyUsername(username);
            return s;
        }

        catch(Exception e)
        {
            logger.error("[ERROR - STUDENT_DETAILS] - " + "Error occurred while retrieving Student Details by Username: {}", e.getMessage());
            e.printStackTrace();
        }
        return s1;
    }
}