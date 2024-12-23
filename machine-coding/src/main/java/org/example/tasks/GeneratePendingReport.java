package org.example.tasks;

import org.example.entities.TaskExecution;

public class GeneratePendingReport implements Task {
//    private TaskExecutionRepository taskExecutionRepository;

    @Override
    public void execute(TaskExecution taskExecution) {
        System.out.println("report generated");
    }
//        // better to put this in template method pattern
//        taskExecution.setStatus(TaskExecution.Status.COMPLETED);
//        taskExecutionRepository.update(taskExecution.getId(), taskExecution);
}
