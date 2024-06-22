package com.sagardhakal.freelancenepal.Repositories;

import com.sagardhakal.freelancenepal.Models.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobCategoryRepository extends JpaRepository<JobCategory,Long> {

    @Query(nativeQuery = true,value = "select * from job_categories where name in :categories")
    List<JobCategory> getAllJobCategoryWithName(@Param("categories") List<String> categories);
}
