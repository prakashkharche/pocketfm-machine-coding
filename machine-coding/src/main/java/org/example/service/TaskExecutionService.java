package org.example.service;

import org.example.entities.TaskEntity;
import org.example.entities.TaskExecution;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskExecutionService {
    List<TaskExecution> fetchAndExecute(LocalDateTime dateTime);
}
