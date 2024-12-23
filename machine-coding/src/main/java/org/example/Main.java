package org.example;

import org.example.entities.Schedule;
import org.example.entities.TaskEntity;
import org.example.repository.TaskRepository;
import org.example.service.TaskExecutionService;

import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TaskRepository taskRepository = Initializer.taskRepository;
        TaskEntity task = new TaskEntity("pending_report", TaskEntity.Status.ACTIVE, new Schedule(1));
        taskRepository.add(task);

        TaskExecutionService executionService = Initializer.init();

        executionService.fetchAndExecute(LocalDateTime.now());
    }
}