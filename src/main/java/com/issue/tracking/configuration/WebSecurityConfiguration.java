package com.issue.tracking.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

//enable web security
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// redirect user to formLogin if user trying to access protected resource

		// To open from login
		/*http.formLogin()
				.usernameParameter("username")
				.passwordParameter("password")
				// custom login page
				.loginPage("/login").permitAll();*/
		//logout
				/*http.logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/");*/

		// Enable Basic Web Security authentication
		http.httpBasic();
		// disable token generate from server for client that don't have token like
		// mobile for web service
		http.csrf().disable();
		// secure end point URL

		http.authorizeRequests()
								.anyRequest()
								.authenticated();
		/*.antMatchers("/api/**").hasRole("admin");*/


		// API not Store Session or anything that is STATELESS API
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}