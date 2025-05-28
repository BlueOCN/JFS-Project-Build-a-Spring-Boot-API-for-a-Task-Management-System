package com.blueocn.TaskManagementSystem.data.repository;

import com.blueocn.TaskManagementSystem.data.entity.Task;
import com.blueocn.TaskManagementSystem.data.entity.TaskPriority;
import com.blueocn.TaskManagementSystem.data.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
    List<Task> findByPriority(TaskPriority priority);
    List<Task> findByAssignedTo(String assignedTo);
}
