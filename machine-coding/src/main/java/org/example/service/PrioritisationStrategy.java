package org.example.service;

import org.example.entities.TaskEntity;

import java.util.List;

public interface PrioritisationStrategy {
    default List<TaskEntity> prioritise(List<TaskEntity> taskEntities){
        return taskEntities;
    }
}
