package com.sagardhakal.freelancenepal.Services;

import com.sagardhakal.freelancenepal.Models.JobCategory;
import com.sagardhakal.freelancenepal.Repositories.JobCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobCategoryService {
    @Autowired
    private JobCategoryRepository jobCategoryRepository;

    public JobCategory getJobCategoryWithId(Long id) throws Exception{
        Optional<JobCategory> jobCategory=jobCategoryRepository.findById(id);
        if(jobCategory.isEmpty()){
            throw new Exception("No Job Category Was Chosen");
        }
        return jobCategory.get();
    }

    public void createJobCategoriesWithName(List<String > categories){
        List<JobCategory>categoryList=jobCategoryRepository.getAllJobCategoryWithName(categories);
        for(String category:categories){
            boolean isExists=false;
            for(JobCategory category1:categoryList){
                if(category1.getName().equals(category)){
                    isExists=true;
                    break;
                }
            }
            if(!isExists){
                JobCategory jobCategory=new JobCategory();
                jobCategory.setName(category);
                jobCategoryRepository.save(jobCategory);
            }
        }
    }

    public List<JobCategory> getAllJobCategories() throws Exception{
        return jobCategoryRepository.findAll();
    }
}
