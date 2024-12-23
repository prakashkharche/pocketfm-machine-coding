package org.example;

import org.example.repository.InMemTaskExecutionRepository;
import org.example.repository.InMemTaskRepository;
import org.example.repository.TaskExecutionRepository;
import org.example.repository.TaskRepository;
import org.example.service.DefaultPrioritisationStrategy;
import org.example.tasks.GeneratePendingReport;
import org.example.tasks.Task;
import org.example.service.TaskExecutionService;
import org.example.service.TaskExecutionServiceImpl;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Initializer {

    public static TaskRepository taskRepository = new InMemTaskRepository();

    public static TaskExecutionService init() {
        TaskExecutionRepository executionRepository = new InMemTaskExecutionRepository();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Map<String, Task> taskMap = Map.of("pending_report", new GeneratePendingReport());
        return new TaskExecutionServiceImpl(taskRepository, executionRepository, new DefaultPrioritisationStrategy(),executorService, taskMap, 5);
    }
}
