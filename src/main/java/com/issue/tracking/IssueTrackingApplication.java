package com.issue.tracking;



import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.issue.tracking.model.Role;
import com.issue.tracking.service.RoleService;

@SpringBootApplication
public class IssueTrackingApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(IssueTrackingApplication.class, args);
	}

	@Autowired
	private RoleService roleService;	
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		/*Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		Role role=new Role("java2", "spring2", "boot2", "thymeleaf2", date, date);
		System.out.println(roleService.save(role));
		System.out.println(role=roleService.findRoleById(13));	
		*/
		
	}
	
}
