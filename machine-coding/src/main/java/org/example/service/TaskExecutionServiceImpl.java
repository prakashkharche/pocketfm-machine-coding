package org.example.service;

import org.example.entities.TaskEntity;
import org.example.entities.TaskExecution;
import org.example.repository.TaskExecutionRepository;
import org.example.repository.TaskRepository;
import org.example.tasks.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class TaskExecutionServiceImpl implements TaskExecutionService {
    private TaskRepository taskRepository;
    private TaskExecutionRepository taskExecutionRepository;
    private PrioritisationStrategy prioritisationStrategy;
    private ExecutorService taskWorkers;
    private Map<String, Task> taskMap;
    private int minutesBeforeNow;

    public TaskExecutionServiceImpl(TaskRepository taskRepository,
                                    TaskExecutionRepository taskExecutionRepository,
                                    PrioritisationStrategy prioritisationStrategy,
                                    ExecutorService taskWorkers,
                                    Map<String, Task> taskMap,
                                    int minutesBeforeNow) {
        this.taskRepository = taskRepository;
        this.taskExecutionRepository = taskExecutionRepository;
        this.prioritisationStrategy = prioritisationStrategy;
        this.taskWorkers = taskWorkers;
        this.taskMap = taskMap;
        this.minutesBeforeNow = minutesBeforeNow;
    }

    @Override
    public List<TaskExecution> fetchAndExecute(LocalDateTime dateTime) {

        // add validations


        List<TaskEntity> tasks = taskRepository.getAll(dateTime, minutesBeforeNow);
        tasks = prioritisationStrategy.prioritise(tasks);

        List<TaskExecution> taskExecutions = new ArrayList<>();
        for (TaskEntity task : tasks) {
            TaskExecution execution = taskExecutionRepository.add(new TaskExecution(task.getId(), task.getType(),LocalDateTime.now(), TaskExecution.Status.PENDING));
            taskExecutions.add(execution);
        }

        for (TaskExecution taskExecution : taskExecutions) {
            taskWorkers.submit(() -> taskMap.get(taskExecution.getTaskType()).execute(taskExecution));
        }
        return taskExecutions;
    }
}
