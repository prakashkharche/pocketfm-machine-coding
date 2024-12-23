package org.example.repository;

import org.example.entities.TaskExecution;

import java.util.Optional;

public interface TaskExecutionRepository {
    TaskExecution add(TaskExecution execution);
    Optional<TaskExecution> get(String id);
    TaskExecution update(String id, TaskExecution execution);
}
