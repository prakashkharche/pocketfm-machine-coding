package org.example.repository;

import org.example.entities.TaskExecution;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InMemTaskExecutionRepository implements TaskExecutionRepository {
    private final Map<String, TaskExecution> taskExecutionMap;

    public InMemTaskExecutionRepository() {
        this.taskExecutionMap = new HashMap<>();
    }

    @Override
    public TaskExecution add(TaskExecution execution) {
        String id = UUID.randomUUID().toString();
        if (taskExecutionMap.containsKey(id)) {
            throw new RuntimeException("id already present");
        }
        execution.setId(id);
        taskExecutionMap.put(execution.getId(), execution);
        return execution;
    }

    @Override
    public Optional<TaskExecution> get(String id) {
        return Optional.ofNullable(taskExecutionMap.get(id));
    }

    @Override
    public TaskExecution update(String id, TaskExecution execution) {
        if (!taskExecutionMap.containsKey(id)) {
            throw new RuntimeException("id does not exists");
        }
        taskExecutionMap.put(id, execution);
        return execution;
    }
}
