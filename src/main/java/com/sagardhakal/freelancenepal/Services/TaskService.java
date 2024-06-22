package com.sagardhakal.freelancenepal.Services;

import com.sagardhakal.freelancenepal.Models.JobCategory;
import com.sagardhakal.freelancenepal.Models.Task;
import com.sagardhakal.freelancenepal.Models.User;
import com.sagardhakal.freelancenepal.Repositories.JobCategoryRepository;
import com.sagardhakal.freelancenepal.Repositories.TaskRepository;
import com.sagardhakal.freelancenepal.Request.TaskCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createNewTask(TaskCreateRequest taskCreateRequest, JobCategory jobCategory,User user)throws Exception{

        Task task=Task.builder()
                .title(taskCreateRequest.getTitle())
                .description(taskCreateRequest.getDescription())
                .location(taskCreateRequest.getLocation())
                .category(jobCategory)
                .maximum(taskCreateRequest.getMaximum())
                .minimum(taskCreateRequest.getMinimum())
                .user(user)
                .type(taskCreateRequest.getType())
                .build();
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
