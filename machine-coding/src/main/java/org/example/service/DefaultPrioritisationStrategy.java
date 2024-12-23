package org.example.service;

import org.example.entities.TaskEntity;

import java.util.List;

public class DefaultPrioritisationStrategy implements PrioritisationStrategy {
    @Override
    public List<TaskEntity> prioritise(List<TaskEntity> taskEntities) {
        return taskEntities;
    }
}
