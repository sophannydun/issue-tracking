package com.issue.tracking.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication arg2)
			throws IOException, ServletException {
		System.out.println("Hello World!");
		//then redirect here
		arg1.sendRedirect("/");
	}

}
