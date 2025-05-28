package com.blueocn.TaskManagementSystem.data.entity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TaskNotFoundException extends RuntimeException {

    private final Long taskId;

    public TaskNotFoundException(Long taskId) {
        super("Task with ID " + taskId + " not found");
        this.taskId = taskId;
    }

    public Long getTaskId() {
        return taskId;
    }
}