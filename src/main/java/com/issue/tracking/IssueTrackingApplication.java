package com.issue.tracking;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.issue.tracking.model.Role;
import com.issue.tracking.repository.RoleRepository;

@SpringBootApplication
public class IssueTrackingApplication{

	public static void main(String[] args) {
		SpringApplication.run(IssueTrackingApplication.class, args);
	}
	
}
