package com.issue.tracking.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class UserController {
	
	// @RequestMapping(value="/index")
		@GetMapping(value = { "", "user/index" })
		public String index() {			
			return "user/index";
		}

}
