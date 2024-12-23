package org.example.repository;

import org.example.entities.TaskEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository {
    TaskEntity add(TaskEntity task);

    TaskEntity update(String id, TaskEntity task);

    List<TaskEntity> getAll(LocalDateTime time, int minutes);
}
