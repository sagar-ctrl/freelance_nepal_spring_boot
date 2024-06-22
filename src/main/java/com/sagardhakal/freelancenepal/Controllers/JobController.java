package com.sagardhakal.freelancenepal.Controllers;

import com.sagardhakal.freelancenepal.Helper.ResponseHelper;
import com.sagardhakal.freelancenepal.Models.JobCategory;
import com.sagardhakal.freelancenepal.Response.JobCategoryResponse;
import com.sagardhakal.freelancenepal.Services.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class JobController {
    @Autowired
    private JobCategoryService jobCategoryService;


    @GetMapping("/lists")
    public ResponseEntity getAllJobCategories(){
       try {
           List<JobCategory> categoryList=jobCategoryService.getAllJobCategories();
           return ResponseHelper.getResponse(JobCategoryResponse.getResponseDtoList(categoryList));
       }catch (Exception e){
           return ResponseHelper.getResponse(400, e.getMessage());
       }
    }
}
