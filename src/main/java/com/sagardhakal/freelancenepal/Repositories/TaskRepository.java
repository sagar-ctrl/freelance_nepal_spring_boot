package com.sagardhakal.freelancenepal.Repositories;

import com.sagardhakal.freelancenepal.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
