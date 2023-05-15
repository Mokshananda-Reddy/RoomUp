package com.roomup.backend.controller;

import com.roomup.backend.model.Student;
import com.roomup.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/student")
    Student newPatient(@RequestBody Student newStudent)
    {
        return studentRepository.save(newStudent);
    }

    @GetMapping("/students")
    List<Student> getAllPatients()
    {
        return studentRepository.findAll();
    }

    @GetMapping("/getstudentid")
    Student getCurrentStudentDetails(@RequestParam("username") String username)
    {
        Student s1 = new Student(null, null, null, null, null, null, null, null);
        try
        {
            Student s = studentRepository.getStudentIDbyUsername(username);
//            String nusername = s.getUsername();
//            System.out.println("This the method of get username"+nusername);
            return s;
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
        return s1;
    }
}

//    @Test
//    public void testNewStudent() throws Exception {
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date dob = dateFormat.parse("2001-01-01");
//
//        Student student = new Student();
//
//        student.setStudentID(1L);
//        student.setName("Karan");
//        student.setDob(dob);
//        student.setUsername("karan");
//        student.setPassword("karan");
//        student.setGender("Male");
//        student.setRoom("B221");
//        student.setAdmissionID("IMT2019001");
//        student.setEmail("karan@iiitb.ac.in");
//
//
//        when(studentRepository.save(any(Student.class))).thenReturn(student);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/student")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(student)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.studentID").value(20))
//                .andExpect(jsonPath("$.name").value("Karan"))
//                .andExpect(jsonPath("$.dob").value(dob))
//                .andExpect(jsonPath("$.username").value("karan"))
//                .andExpect(jsonPath("$.password").value("karan"))
//                .andExpect(jsonPath("$.gender").value("Male"))
//                .andExpect(jsonPath("$.room").value("B221"))
//                .andExpect(jsonPath("$.admissionID").value("IMT2019001"))
//                .andExpect(jsonPath("$.email").value("karan@iiitb.ac.in"));
//    }