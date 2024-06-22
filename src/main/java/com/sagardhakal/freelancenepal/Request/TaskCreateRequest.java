package com.sagardhakal.freelancenepal.Request;

import lombok.Data;

@Data
public class TaskCreateRequest {
    private String title;
    private Long categoryId;
    private String location;
    private Double minimum;
    private Double maximum;
    private String skills;
    private String description;
    private String type;
}
