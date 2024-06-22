package com.sagardhakal.freelancenepal;

import com.sagardhakal.freelancenepal.Services.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FreelancenepalApplication implements CommandLineRunner {
	@Autowired
	private JobCategoryService jobCategoryService;
	public static void main(String[] args) {
		SpringApplication.run(FreelancenepalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<String> categories=new ArrayList();
		categories.add("Admin Support");
		categories.add("Customer Service");
		categories.add("Design And Creative");
		categories.add("Legal");
		categories.add("Software Developing");
		categories.add("Data Analytics");
		categories.add("IT And Networking");
		categories.add("Writing");
		categories.add("Translations");
		categories.add("Sales And Marketing");
		jobCategoryService.createJobCategoriesWithName(categories);
	}
}
