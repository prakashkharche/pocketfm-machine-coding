package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class TaskEntity {
    private String id;
    //revisit
    private final String type;
    private final Status status;
    private final Schedule schedule;
    private Map<String, String> attributes;


    public enum Status {
        ACTIVE, CANCELLED;
    }
}
