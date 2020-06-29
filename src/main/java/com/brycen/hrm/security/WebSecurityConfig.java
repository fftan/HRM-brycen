package com.brycen.hrm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.brycen.hrm.security.jwt.AuthEntryPointJwt;
import com.brycen.hrm.security.jwt.AuthTokenFilter;
import com.brycen.hrm.security.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			
			// Public link
			.authorizeRequests().antMatchers("/login").permitAll()
			
			// Access by admin
//			.antMatchers("/roles?page&name").hasAuthority("ADMIN")
			.antMatchers("/employees").hasAnyAuthority("ADMIN", "PM")
			.antMatchers("/employees/create").hasAuthority("ADMIN")
			.antMatchers("/permissions/**").hasAuthority("ADMIN")
			.antMatchers("/role-permission/**").hasAnyAuthority("ADMIN")
			
			// Access by PL & PM
			.antMatchers("/skills/create").hasAnyAuthority("ADMIN", "PM")
			.antMatchers("/status/create").hasAnyAuthority("ADMIN", "PM")
			.antMatchers("/departments/create").hasAnyAuthority("ADMIN", "PM")
			.antMatchers("/project-types/create").hasAnyAuthority("ADMIN", "PM")
			
			// Access all role
			.antMatchers("/tasks/**").hasAnyAuthority("ADMIN", "EMPLOYEE", "PL", "PM")
//			.antMatchers("/roles/**").hasAnyAuthority("ADMIN", "EMPLOYEE", "PL", "PM")
			.antMatchers("/skills/**").hasAnyAuthority("ADMIN", "EMPLOYEE", "PL", "PM")
			.antMatchers("/levels/**").hasAnyAuthority("ADMIN", "EMPLOYEE", "PL", "PM")
			.antMatchers("/status/**").hasAnyAuthority("ADMIN", "EMPLOYEE", "PL", "PM")
			.antMatchers("/dashboard").hasAnyAuthority("ADMIN", "EMPLOYEE", "PL", "PM")
			.antMatchers("/employees/{id}").hasAnyAuthority("ADMIN", "EMPLOYEE", "PL", "PM")
			.antMatchers("/departments/**").hasAnyAuthority("ADMIN", "EMPLOYEE", "PL", "PM")
			.antMatchers("/project-types/**").hasAnyAuthority("ADMIN", "EMPLOYEE", "PL", "PM")
			.antMatchers("/employee-task/**").hasAnyAuthority("ADMIN", "EMPLOYEE", "PL", "PM")
			.antMatchers("/employee-roles/**").hasAnyAuthority("ADMIN", "EMPLOYEE", "PL", "PM")
			.antMatchers("/employee-skill/**").hasAnyAuthority("ADMIN", "EMPLOYEE", "PL", "PM")
			.anyRequest().authenticated();

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}