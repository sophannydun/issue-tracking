package com.issue.tracking.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

//enable web security
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationSuccessHandler successHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService);
	}

	// To enable style
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/static/**", "/resources/templates/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// redirect user to formLogin if user trying to access protected
		// resource

		// To enable style
		http
			.authorizeRequests()
			.antMatchers("/image/**").permitAll()
			.antMatchers("/css/**").permitAll();
		// To open from login	
		http.formLogin()
				/*
				 * disabled .usernameParameter and .passwordParameter coz it is default if wrong
				 * binding name mush enable both
				 */
				// .usernameParameter("username")
				// .passwordParameter("password")

				// custom login page

				.loginPage("/login").permitAll()
				

				/*
				 * If .defaultSuccessUrl is not working must implement from SuccessHandler
				 * interface
				 * 
				 * @Autowired private AuthenticationSuccessHandler successHandler;
				 */
				// .defaultSuccessUrl("/index1")
				.successHandler(successHandler);
		// logout
		/*
		 * http.logout() .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		 * .logoutSuccessUrl("/");
		 */

		/******
		 * API only ***** Enable Basic Web Security authentication
		 */
		// http.httpBasic();

		/*
		 * disable token generate from server for client that don't have token like
		 * mobile for web service
		 */
		http.csrf().disable();

		// secure end point URL

		http.authorizeRequests().anyRequest().authenticated()
		.antMatchers("/user/addUser").hasRole("ADMIN");;
		 

		/*****
		 * Below use only with API ***** API not Store Session or anything that is
		 * STATELESS API
		 * http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 */
	}
}