package com.ahmed.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class MyAppSecurity {
	
	@Autowired
	DataSource dataSource;

	/*
	 * @Autowired PasswordEncoder passEncoder; // our class depends on
	 * PasswordEncoder so we are injecting it.  optional we will runtime exception 
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { //this is predefined object we we need to create it by using bean method
		
		http.authorizeHttpRequests(
				authorize ->authorize.requestMatchers(HttpMethod.GET,"/{id}","/books").hasAnyRole("ADMIN")// this end can permitted to all the users means any one can access
									.requestMatchers(HttpMethod.DELETE,"/{id}").hasAnyRole("ADMIN") // only ADMIN can delete the user
									.requestMatchers("/add").hasAnyRole("MANAGER")  // only MANAGER can add the user
									.requestMatchers(
								            "/swagger-ui/**",
								            "/v3/api-docs/**",
								            "/swagger-ui.html"
								        ).permitAll()
				)
		//.httpBasic(Customizer.withDefaults())
		.formLogin(Customizer.withDefaults()) // this is another authentication model of http protocol
		
		;
		http.csrf(Csrf -> Csrf.disable());
									
		return http.build();// it is used to return securityFilterChain object

	}
	/*
	 --> AuthenticationManagerBuilder is used to create AuthenticationManager object this AuthenticationManager contains
	  userDetails
	  
	  --> create two table in db with the name users and authority
	  and insert the recores thorough spring application by encoding the password
	  */
	
	
	@Autowired  // this is spring boot 2.0 version configuration
	public void configureGloble(AuthenticationManagerBuilder auth) throws Exception {  // it is a helper class to build AM object
		auth.jdbcAuthentication()     // this is called jdbcAuthentication
		.dataSource(dataSource)
		.passwordEncoder(passwordEncoder());
		
	}
	
	         // or In new Version in 3.0 which is simplified.
	
	public UserDetailsService userDetailsService() {  // it is an interface
		JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource); // it is an impl class with accept data source object, it 
																				// is used to get the data from the db by executing the queries automatically
		return manager;
	}

	/*
	 * AuthenticationProvider uses UserDetailsService object, to load the user’s
	 * details.
	 **/
	
	
	/*
	@Bean
	public UserDetailsService userDetails() { // UserDatailsService is an interface so we are returning implementation
												// object

		// creating userDetails objects
		UserDetails admin = User.withUsername("John")            //User is a class which has a static method 
							.password(passwordEncoder()
							.encode("john@123"))
							.roles("ADMIN").build();// password should be encoded so use
					          						// PasswordEncoder  object it has encode method which uses SHA1 128 bit(secured hash algorithm)and SHA2 256 bit
																														
		
		UserDetails manager = User.withUsername("Alice")
							  .password(passwordEncoder()
							  .encode("alice@123"))
							  .roles("MANAGER")
							  .build();
		
		return new InMemoryUserDetailsManager(admin, manager);   // UserDetaisService is an Interface and InMemoryUserDetailManaget is a impl class
	}
	
	*/

	@Bean
	public PasswordEncoder passwordEncoder() { // here PasswordEncoder is an interface and BCryptPasswordEncoder is an
												// impl class object.
		return new BCryptPasswordEncoder();
	}

}
/*What is HttpSecurity in Spring Security?

HttpSecurity is a configuration helper class used inside Spring Security to define how HTTP requests
should be secured in your web application.

With HttpSecurity, you can decide things like:

which URLs are public.

which URLs need login

which URLs need a role (ADMIN/USER)

what login page to use

logout rules

CSRF rules, etc.

You usually use it inside a SecurityFilterChain bean.


What is authorize / authorizeHttpRequests()?

“Authorize” means give permission.

So, authorizeHttpRequests() means:
✅ “For each incoming HTTP request, decide whether to allow it or block it.”

authorizeHttpRequests accepts a functional interface (Consumer) where Spring passes 
an authorization config object, and we use lambda expressions to define access rules.

Inside it, you write rules like:

/login → allow everyone

/admin/** → only ADMIN

any other request → must be authenticated (logged in)

Simple line-by-line example (most common)
@Bean
SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/login", "/register", "/css/**", "/js/**").permitAll()
            .requestMatchers("/admin/**").hasRole("ADMIN")
            .anyRequest().authenticated()
        )
        .formLogin(form -> form
            .loginPage("/login")
            .defaultSuccessUrl("/dashboard", true)
            .permitAll()
        )
        .logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login?logout")
        );

    return http.build();
}

Line by line explanation
1) http.authorizeHttpRequests(auth -> auth ... )

👉 Start defining authorization rules (who can access what).

2) .requestMatchers("/login", "/register", "/css/**", "/js/**").permitAll()

requestMatchers(...) → these URL patterns

permitAll() → anyone can access, even without login

✅ Means: login page, register page, static files should open for all.*/
