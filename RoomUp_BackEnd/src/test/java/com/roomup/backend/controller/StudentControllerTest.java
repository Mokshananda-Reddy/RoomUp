package com.roomup.backend.controller;

import com.roomup.backend.model.Student;
import com.roomup.backend.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class StudentControllerTest {

    private MockMvc mockMvc;

    @Mock
    private StudentRepository studentRepository;

    private StudentController studentController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        studentController = new StudentController(studentRepository);
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    public void testNewStudent() throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dob = dateFormat.parse("2001-01-01");

        Student student = new Student();

        student.setStudentID(1L);
        student.setName("Karan");
        student.setDob(dob);
        student.setUsername("karan");
        student.setPassword("karan");
        student.setGender("Male");
        student.setRoom("B221");
        student.setAdmissionID("IMT2019001");
        student.setEmail("karan@iiitb.ac.in");


        when(studentRepository.save(any(Student.class))).thenReturn(student);

        mockMvc.perform(MockMvcRequestBuilders.post("/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(student)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentID").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Karan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dob").value(dob))
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("karan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("karan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.gender").value("Male"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.room").value("B221"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.admissionID").value("IMT2019001"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("karan@iiitb.ac.in"));

        verify(studentRepository, times(2)).save(any(Student.class));
    }

    @Test
    public void testGetAllStudents() throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dob1 = dateFormat.parse("2001-01-01");
        Date dob2 = dateFormat.parse("2001-02-02");

        Student student1 = new Student();
        student1.setStudentID(1L);
        student1.setName("Karan");
        student1.setDob(dob1);
        student1.setUsername("karan");
        student1.setPassword("karan");
        student1.setGender("Male");
        student1.setRoom("B221");
        student1.setAdmissionID("IMT2019001");
        student1.setEmail("karan@iiitb.ac.in");

        Student student2 = new Student();
        student2.setStudentID(2L);
        student2.setName("Sita");
        student2.setDob(dob2);
        student2.setUsername("sita");
        student2.setPassword("sita");
        student2.setGender("Female");
        student2.setRoom("L111");
        student2.setAdmissionID("IMT20190021");
        student2.setEmail("sita@iiitb.ac.in");

        List<Student> blockList = new ArrayList<>();
        blockList.add(student1);
        blockList.add(student2);

        when(studentRepository.findAll()).thenReturn(blockList);

        mockMvc.perform(MockMvcRequestBuilders.get("/students"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].studentID").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Karan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].dob").value(dob1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].username").value("karan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].password").value("karan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].gender").value("Male"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].room").value("B221"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].admissionID").value("IMT2019001"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("karan@iiitb.ac.in"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].studentID").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Sita"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].dob").value(dob2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].username").value("sita"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].password").value("sita"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].gender").value("Female"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].room").value("L111"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].admissionID").value("IMT20190021"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].email").value("sita@iiitb.ac.in"));

        verify(studentRepository, times(1)).findAll();
    }

    @Test
    public void testGetCurrentStudentDetails() throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dob = dateFormat.parse("2002-11-21");

        Student student = new Student();

        student.setStudentID(10L);
        student.setName("Akash");
        student.setDob(dob);
        student.setUsername("akash");
        student.setPassword("akash");
        student.setGender("Male");
        student.setRoom("B721");
        student.setAdmissionID("IMT2015061");
        student.setEmail("akash@iiitb.ac.in");

        when(studentRepository.getStudentIDbyUsername("akash")).thenReturn(student);

        mockMvc.perform(MockMvcRequestBuilders.get("/getstudentid")
                        .param("username", "akash"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentID").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Akash"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dob").value(dob))
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("akash"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("akash"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.gender").value("Male"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.room").value("B721"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.admissionID").value("IMT2015061"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("akash@iiitb.ac.in"));
    }

    // Helper method to convert objects to JSON string
    private static String asJsonString(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}