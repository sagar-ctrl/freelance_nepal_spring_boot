package com.sagardhakal.freelancenepal.Response;

import com.sagardhakal.freelancenepal.Models.JobCategory;
import com.sagardhakal.freelancenepal.Models.Task;
import jdk.jfr.Category;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class TaskResponseDto {
    private Long id;
    private String title;
    private String description;
    private String location;
    private String category_name;
    private Long category_id;
    private Double minimum;
    private Double maximum;
    private String type;

    public static TaskResponseDto getTaskResponseDto(Task task, JobCategory category){
        return TaskResponseDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .category_name(category.getName())
                .maximum(task.getMaximum())
                .minimum(task.getMinimum())
                .category_id(category.getId())
                .location(task.getLocation())
                .type(task.getType())
                .build();
    }
    public static TaskResponseDto getTaskResponseDto(Task task){
        return TaskResponseDto.builder()
                .id(task.getId())
                .category_id(task.getCategory_id())
                .title(task.getTitle())
                .description(task.getDescription())
                .maximum(task.getMaximum())
                .minimum(task.getMinimum())
                .location(task.getLocation())
                .type(task.getType())
                .build();
    }

    public static List<TaskResponseDto> getTaskResponseDtoList(List<Task>taskList){
        List<TaskResponseDto> lists=new ArrayList<>();
        for(Task task:taskList){
            lists.add(getTaskResponseDto(task));
        }
        return lists;
    }
}
