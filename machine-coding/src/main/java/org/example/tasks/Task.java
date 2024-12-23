package org.example.tasks;

import org.example.entities.TaskExecution;

public interface Task {
    void execute(TaskExecution taskExecution);
}
