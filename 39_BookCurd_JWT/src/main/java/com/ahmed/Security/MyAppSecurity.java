package com.ahmed.Security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ahmed.filter.JwtFilter;


@Configuration
@EnableWebSecurity

public class MyAppSecurity {

    private final JwtFilter jwtFilter;
	
	@Autowired
	DataSource source;

    MyAppSecurity(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }
/*
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) {
		
		http.authorizeHttpRequests(authorize -> authorize
				.requestMatchers(HttpMethod.GET,"{/id}","/books").hasAnyRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE,"{/id}").hasAnyRole("ADMIN")
				.requestMatchers(HttpMethod.POST,"/add").hasAnyRole("MANAGER"))
				.csrf(Customizer.withDefaults());
			
				http.sessionManagement(config -> config.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		/*this is used to configure state less session policy so we are working with jwt session are not created 
		  by using sessionCreationPolicy by  STATELESS
		
			http.addFilterBefore(jwtFilter
					, UsernamePasswordAuthenticationFilter.class);
			
			/*jwtFiler is added before  UsernamePasswordAuthenticationFilter, this jwtFilter it will execute before
			  UsernamePasswordAuthenticationFilter
		
		
				return http.build();
				
	}
*/
    
    @Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/login").permitAll()
				                                          .requestMatchers(HttpMethod.GET, "/{id}", "/books").hasAnyRole("ADMIN")
				                                          .requestMatchers(HttpMethod.DELETE, "/{id}").hasAnyRole("ADMIN")
				                                          .requestMatchers("/create").hasAnyRole("MANAGER")
				                                          
				                  )
		                          .formLogin(customizer -> customizer.disable());

		http.csrf(csrf -> csrf.disable());

		http.sessionManagement(config -> config.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		//this is used to configure state less session policy so we are working with jwt session are not created 
		  //by using sessionCreationPolicy by  STATELESS
		
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		/*jwtFiler is added before  UsernamePasswordAuthenticationFilter, this jwtFilter it will execute before
		  UsernamePasswordAuthenticationFilter*/
	

		return http.build();
	}

	
	@Bean
	public UserDetailsService userDetails() {
		
		JdbcUserDetailsManager manager = new JdbcUserDetailsManager(source);
		return manager;
		
	}
	
	@Bean
	public PasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
		
        AuthenticationManagerBuilder authenticationManagerBuilder = 
                http.getSharedObject(AuthenticationManagerBuilder.class);
        
        authenticationManagerBuilder.userDetailsService(userDetails()).passwordEncoder(passEncoder());
        return authenticationManagerBuilder.build();
    }
}
