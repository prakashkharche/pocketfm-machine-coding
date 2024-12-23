package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class TaskExecution {
    private String id;
    private String taskId;
    private String taskType;
    private LocalDateTime executionStartTime;
    private LocalDateTime executionEndTime;
    private Status status;

    public TaskExecution(String taskId, String taskType, LocalDateTime executionStartTime, Status status) {
        this.taskId = taskId;
        this.taskType = taskType;
        this.executionStartTime = executionStartTime;
        this.status = status;
    }

    public enum Status {
        COMPLETED, PENDING, FAILED;
    }
}
