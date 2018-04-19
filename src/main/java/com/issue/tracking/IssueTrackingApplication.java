package com.issue.tracking;



import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.issue.tracking.repository.retrofit.service.RoleServiceRetrofit;
import com.issue.tracking.repository.retrofit.service.RoleServiceRetrofitImp;

@SpringBootApplication
public class IssueTrackingApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(IssueTrackingApplication.class, args);
	}

/*	@Autowired
	private RoleService roleService;	
	
	@Autowired
	private RoleServiceRetrofitImp roleServiceRetrofit;
	@Override*/
	public void run(ApplicationArguments arg0) throws Exception {		
		/*Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		Role role;
		for(int i=0;i<=15;i++){
			role=new Role("java" + i+1 , "spring " + i+1, "boot " + i+1, "thymeleaf " + i+1, date, date);
			System.out.println(roleService.save(role));
		}
		System.out.println(role=roleService.findRoleById(13));	
		System.out.println(roleService.save(role));
		//roleService.remove(16)	
	      role=new Role(15,"u" , "s1 " , "b1 ", "t1 " , date, date);
	      System.out.println(roleService.update(role));*/
		/*Role role;
		role=new Role(6,"u" ,"b1 ", "t1 " , "12-Apr-2018", "12-Apr-2018");
		Boolean b=roleServiceRetrofit.createRole(role);
		System.out.println(b);*/
		//roleServiceRetrofit.getAllRoles();
	}
	
}
