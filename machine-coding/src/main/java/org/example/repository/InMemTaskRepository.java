package org.example.repository;

import org.example.entities.TaskEntity;

import java.time.LocalDateTime;
import java.util.*;

public class InMemTaskRepository implements TaskRepository {
    private Map<String, TaskEntity> taskMap;

    public InMemTaskRepository() {
        this.taskMap = new HashMap<>();
    }

    @Override
    public TaskEntity add(TaskEntity task) {
        String id = UUID.randomUUID().toString();
        if (taskMap.containsKey(id)) {
            throw new RuntimeException("id already present");
        }
        task.setId(id);
        taskMap.put(task.getId(), task);
        return task;
    }

    @Override
    public TaskEntity update(String id, TaskEntity task) {
        taskMap.put(id, task);
        return task;
    }

    @Override
    public List<TaskEntity> getAll(LocalDateTime time, int minutes) {

        return new ArrayList<>(taskMap.values());
        // TODO : come back here later.
        //return List.of();
    }
}
