package com.sagardhakal.freelancenepal.Models;

import jakarta.persistence.*;

public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "location",nullable = false)
    private String location;

    @Column(name = "minimum",nullable = false)
    private Double minimum;

    @Column(name = "maximum",nullable = false)
    private Double maximum;

    @Column(name = "type",nullable = false)
    private String type;

    @Column(name = "description",nullable = false)
    private String description;

    @JoinColumn(name = "job_category_id",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private JobCategory category;

    @Transient()
    @Column(name = "job_category_id")
    private Long category_id;

    @JoinColumn(name = "user_id",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
