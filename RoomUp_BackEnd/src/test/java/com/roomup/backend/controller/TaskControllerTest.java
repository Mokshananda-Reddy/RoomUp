package com.roomup.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roomup.backend.model.Task;
import com.roomup.backend.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

class TaskControllerTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskController taskController;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
    }

    @Test
    void newTask() throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = dateFormat.parse("2023-04-21");

        Task task = new Task();
        task.setTaskID(1L);
        task.setStudentID(1L);
        task.setRoom("B543");
        task.setDate(dt);
        task.setService("Standard");
        task.setDescription("Please clean the windows");
        task.setFeedback("Very Good");

        when(taskRepository.save(any(Task.class))).thenReturn(task);

        mockMvc.perform(MockMvcRequestBuilders.post("/task")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(task)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.taskID").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentID").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.date").value(dt))
                .andExpect(MockMvcResultMatchers.jsonPath("$.room").value("B543"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.service").value("Standard"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Please clean the windows"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.feedback").value("Very Good"));

        verify(taskRepository, times(2)).save(any(Task.class));

    }

    @Test
    void getAllTasks() throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dt1 = dateFormat.parse("2023-04-21");
        Date dt2 = dateFormat.parse("2023-05-17");

        Task task1 = new Task();
        task1.setTaskID(1L);
        task1.setStudentID(1L);
        task1.setRoom("B543");
        task1.setDate(dt1);
        task1.setService("Standard");
        task1.setDescription("Please clean the windows");
        task1.setFeedback("Very Good");

        Task task2 = new Task();
        task2.setTaskID(2L);
        task2.setStudentID(2L);
        task2.setRoom("L113");
        task2.setDate(dt2);
        task2.setService("Urgent");
        task2.setDescription("Please clean the curtains");
        task2.setFeedback("Very Good");

        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);

        when(taskRepository.findAll()).thenReturn(taskList);

        mockMvc.perform(MockMvcRequestBuilders.get("/tasks"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].taskID").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].studentID").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].date").value(dt1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].room").value("B543"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].service").value("Standard"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value("Please clean the windows"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].feedback").value("Very Good"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].taskID").value(2L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].studentID").value(2L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].date").value(dt2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].room").value("L113"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].service").value("Urgent"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].description").value("Please clean the curtains"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].feedback").value("Very Good"));

        verify(taskRepository, times(1)).findAll();
    }

    @Test
    void getAllTasksbyStudentID() throws Exception {
        Long teststudentID = 1L;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dt1 = dateFormat.parse("2023-04-21");
        Date dt2 = dateFormat.parse("2023-05-17");

        Task task1 = new Task();
        task1.setTaskID(1L);
        task1.setStudentID(1L);
        task1.setRoom("B543");
        task1.setDate(dt1);
        task1.setService("Standard");
        task1.setDescription("Please clean the windows");
        task1.setFeedback("Very Good");

        Task task2 = new Task();
        task2.setTaskID(2L);
        task2.setStudentID(1L);
        task2.setRoom("B543");
        task2.setDate(dt2);
        task2.setService("Urgent");
        task2.setDescription("Please clean the curtains");
        task2.setFeedback("Did not clean it last time");

        Task task3 = new Task();
        task3.setTaskID(2L);
        task3.setStudentID(2L);
        task3.setRoom("L113");
        task3.setDate(dt2);
        task3.setService("Urgent");
        task3.setDescription("Please clean the table");
        task3.setFeedback("Good");

        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task2);

        when(taskRepository.getTasksbyStudentID(teststudentID)).thenReturn(taskList);

        mockMvc.perform(MockMvcRequestBuilders.get("/gettasksbystudentid")
                        .param("studentID", String.valueOf(teststudentID)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].taskID").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].studentID").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].date").value(dt1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].room").value("B543"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].service").value("Standard"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value("Please clean the windows"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].feedback").value("Very Good"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].taskID").value(2L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].studentID").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].date").value(dt2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].room").value("B543"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].service").value("Urgent"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].description").value("Please clean the curtains"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].feedback").value("Did not clean it last time"));
    }
}

