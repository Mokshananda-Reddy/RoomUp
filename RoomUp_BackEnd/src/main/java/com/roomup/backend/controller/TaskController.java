package com.roomup.backend.controller;

import com.roomup.backend.model.Task;
import com.roomup.backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/task")
    Task newTask(@RequestBody Task newTask)
    {
        return taskRepository.save(newTask);
    }

    @GetMapping("/tasks")
    List<Task> getAllTasks()
    {
        return taskRepository.findAll();
    }

    @GetMapping("/gettasksbystudentid")

    List<Task> getAllTasksbyStudentID(@RequestParam("studentID") Long studentID)
    {
        List<Task> plist= null;

        try
        {
            List<Task> PList = taskRepository.getTasksbyStudentID(studentID);
            return PList;
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        return plist;
    }

}
