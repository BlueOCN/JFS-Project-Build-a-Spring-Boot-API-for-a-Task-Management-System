package com.blueocn.TaskManagementSystem.data.entity;

public enum TaskStatus {
    PENDING,      // Task is not started yet
    IN_PROGRESS,  // Task is actively being worked on
    COMPLETED,    // Task is finished successfully
    CANCELLED,    // Task was cancelled before completion
    ON_HOLD       // Task is paused temporarily
}