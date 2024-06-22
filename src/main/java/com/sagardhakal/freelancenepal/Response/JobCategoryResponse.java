package com.sagardhakal.freelancenepal.Response;

import com.sagardhakal.freelancenepal.Models.JobCategory;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Builder
public class JobCategoryResponse {
    private Long id;
    private String name;
    public static JobCategoryResponse getResponseDto(JobCategory jobCategory){
        return JobCategoryResponse.builder()
                .id(jobCategory.getId())
                .name(jobCategory.getName())
                .build();
    }

    public static List<JobCategoryResponse> getResponseDtoList(List<JobCategory>categoryResponses){
        List<JobCategoryResponse>jobCategoryResponses=new ArrayList<>();
        for (JobCategory jobCategory:categoryResponses){
            jobCategoryResponses.add(getResponseDto(jobCategory));
        }
        return jobCategoryResponses;
    }
}
