package com.issue.tracking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {
	 @RequestMapping("/form")
	    public String form(){
	        return "form";
	    }

	    @RequestMapping("/form_advanced")
	    public String formAdvanced(){
	        return "form_advanced";
	    }
	    @RequestMapping("/form_old")
	    public String formOld(){
	        return "form_old";
	    }
	    @RequestMapping("/form_validation")
	    public String formValidation(){
	        return "form_validation";
	    }
	    @RequestMapping("/tables_dynamic")
	    public String tables_dynamic(){
	        return "tables_dynamic";
	    }
}
