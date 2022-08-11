package com.employeemgmt.security;

import com.employeemgmt.service.EmployeeUserDetailsServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	@Bean
	public UserDetailsService userDetailsService() {
		return new EmployeeUserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authnticationManager() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll()
				.antMatchers(HttpMethod.POST, "/user/add", "/role/add").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/employee/list", "/employee/{employeeId}")
				.hasAnyAuthority("USER", "ADMIN").antMatchers(HttpMethod.POST, "/employee/add").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.PUT, "/employee/update").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/employee/delete/*").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/employee/search/*", "/employee/sort").hasAnyAuthority("USER", "ADMIN")
				.antMatchers("/swagger-ui.html").hasAuthority("ADMIN").anyRequest().authenticated().and().httpBasic()
				.and().formLogin().and().logout().logoutSuccessUrl("/login").permitAll().and().cors().and().csrf()
				.disable();
	}
}
