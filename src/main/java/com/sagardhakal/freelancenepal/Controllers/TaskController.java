package com.sagardhakal.freelancenepal.Controllers;

import com.sagardhakal.freelancenepal.Helper.ResponseHelper;
import com.sagardhakal.freelancenepal.Models.JobCategory;
import com.sagardhakal.freelancenepal.Models.Task;
import com.sagardhakal.freelancenepal.Models.User;
import com.sagardhakal.freelancenepal.Request.TaskCreateRequest;
import com.sagardhakal.freelancenepal.Response.TaskResponseDto;
import com.sagardhakal.freelancenepal.Services.JobCategoryService;
import com.sagardhakal.freelancenepal.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private JobCategoryService jobCategoryService;

    @PostMapping("/create")
    public ResponseEntity createNewTasks(@RequestBody TaskCreateRequest taskCreateRequest){
        try{
            JobCategory jobCategory=jobCategoryService.getJobCategoryWithId(taskCreateRequest.getCategoryId());
            User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Task task=taskService.createNewTask(taskCreateRequest,jobCategory,user);
            return ResponseHelper.getResponse(200,"Create New Task", TaskResponseDto.getTaskResponseDto(task,jobCategory));
        }catch (Exception e){
            return ResponseHelper.getResponse(400,e.getMessage());
        }
    }

    @GetMapping("/lists")
    public ResponseEntity getAllTasks(){
        try{
            User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            List<Task> task=taskService.getAllTasks();
            return ResponseHelper.getResponse(200,"Task List Fetched Successfully!!", TaskResponseDto.getTaskResponseDtoList(task));
        }catch (Exception e){
            return ResponseHelper.getResponse(400,e.getMessage());
        }
    }
}
