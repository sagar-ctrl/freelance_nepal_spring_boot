package com.sagardhakal.freelancenepal.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "job_categories")
@Data
public class JobCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false,unique = true)
    private String name;
}
