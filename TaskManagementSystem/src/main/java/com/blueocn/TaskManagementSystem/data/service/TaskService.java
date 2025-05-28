package com.blueocn.TaskManagementSystem.data.service;

import com.blueocn.TaskManagementSystem.data.entity.Task;
import com.blueocn.TaskManagementSystem.data.entity.TaskNotFoundException;
import com.blueocn.TaskManagementSystem.data.entity.TaskPriority;
import com.blueocn.TaskManagementSystem.data.entity.TaskStatus;
import com.blueocn.TaskManagementSystem.data.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Save a Task
    public Task saveTask(Task task) {
        LOGGER.info("Attempting to save task: {}", task.getTitle());
        Task savedTask = taskRepository.save(task);
        LOGGER.info("Task saved successfully with ID: {}", savedTask.getId());
        return savedTask;
    }

    // Get all Tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Get Task by ID
    public Task getTaskById(long id) {
        LOGGER.info("Fetching task with ID: {}", id);
        return taskRepository.findById(id)
                .orElseThrow(() -> {
                    LOGGER.error("Task with ID {} not found!", id);
                    return new TaskNotFoundException(id);
                });
    }

    // Get Tasks by status
    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    // Get Tasks by priority
    public List<Task> getTasksByPriority(TaskPriority priority) {
        return taskRepository.findByPriority(priority);
    }

    // Get Tasks by assignee
    public List<Task> getTasksByAssignee(String assignedTo) {
        return taskRepository.findByAssignedTo(assignedTo);
    }

    // Update task
    public Task updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setDescription(updatedTask.getDescription());
                    task.setStatus(updatedTask.getStatus());
                    task.setPriority(updatedTask.getPriority());
                    task.setDueDate(updatedTask.getDueDate());
                    task.setAssignedTo(updatedTask.getAssignedTo());
                    return taskRepository.save(task);
                }).orElseThrow(() -> new TaskNotFoundException(id));
    }

    // Delete task
    public ResponseEntity<String> deleteTask(Long id) {
        LOGGER.info("Attempting to delete task with ID: {}", id);
        if (!taskRepository.existsById(id)) {
            LOGGER.warn("Task ID {} does not exist. Cannot delete.", id);
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
        LOGGER.info("Task with ID {} deleted successfully.", id);
        return ResponseEntity.ok("Task with ID " + id + " deleted successfully.");
    }

}
