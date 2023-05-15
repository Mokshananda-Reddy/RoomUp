package com.roomup.backend.repository;

import com.roomup.backend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query(value = "SELECT * from task t where t.studentID = :studentID", nativeQuery = true)
    List<Task> getTasksbyStudentID(@Param("studentID") Long studentID);

}