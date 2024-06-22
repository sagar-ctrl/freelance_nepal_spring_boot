package com.sagardhakal.freelancenepal.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
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

    @Column(name = "table_type")
    private String tableType;

    @Transient()
    @Column(name = "job_category_id")
    private Long category_id;

    @JoinColumn(name = "user_id",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
