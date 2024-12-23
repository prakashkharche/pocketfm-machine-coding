package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


// better to keep an interface and fields specific to schedule type
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Schedule {
    private final int fixedDelay;
    private LocalDateTime exactTime;
    private String cronExpression;
}
