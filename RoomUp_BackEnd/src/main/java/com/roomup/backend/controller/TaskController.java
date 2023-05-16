package com.roomup.backend.controller;

import com.roomup.backend.model.Task;
import com.roomup.backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @PostMapping("/task")
    Task newTask(@RequestBody Task newTask)
    {
        try
        {
            logger.info("[TASK] - " + "Received New Task Creation Request: {}", newTask);
            Task savedTask = taskRepository.save(newTask);
            logger.info("[RESULT - TASK] - " + "Successfully Created New Task: {}", savedTask);
            return taskRepository.save(savedTask);

        } catch(Exception e)
        {
            logger.error("[ERROR - TASK] - " + "Error occurred while creating a New Task: {}", e.getMessage());
            throw e;
        }
    }

    @GetMapping("/tasks")
    List<Task> getAllTasks()
    {
        try {
            logger.info("[TASKS] - Received Request to Get All Tasks");
            List<Task> tasks = taskRepository.findAll();
            logger.info("[RESULT - TASKS] - " + "Successfully Retrieved {} Tasks", tasks.size());
            return tasks;
        } catch (Exception e) {
            logger.error("[ERROR - TASKS] - " + "Error occurred while retrieving Tasks: {}", e.getMessage());
            throw e;
        }
    }

    @GetMapping("/gettasksbystudentid")

    List<Task> getAllTasksbyStudentID(@RequestParam("studentID") Long studentID)
    {
        logger.info("[TASK_LIST] - Received Request to get the All Tasks by StudentID: {}", studentID);
        List<Task> plist= null;
        try
        {
            logger.info("[RESULT - TASK_LIST] - " + "Successfully Retrieved All Tasks by StudentID: {}", studentID);
            List<Task> PList = taskRepository.getTasksbyStudentID(studentID);
            return PList;
        }

        catch (Exception e)
        {
            logger.error("[ERROR - TASK_LIST] - " + "Error occurred while retrieving All Tasks by StudentID: {}", e.getMessage());
            e.printStackTrace();
        }

        return plist;
    }

}
