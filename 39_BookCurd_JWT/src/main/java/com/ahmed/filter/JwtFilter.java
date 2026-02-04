package com.ahmed.filter;
/* if there is no token the the user need to be authenticated , if sucessfully authenticated then generated token
 * if the token is coming in the request then get the token first then check weather the token is valid or invalid
 * it is expired or not  then allow to request 
 * 
    to do this work we are defining a filter class this is jwt filter and include in chain of filter in spring security
    
    *entire logic i cannot create in the class so to create and validate the filter i am creating one helper class
     called Util class */
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ahmed.exceptions.TokenExpiredException;
import com.ahmed.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		try {
			String authorizationHeader = request.getHeader("Authorization");// this filter will get the value from header and store 

			String username = null;
			String jwt = null;

			if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
				jwt = authorizationHeader.substring(7);
				username = jwtUtil.extractUsername(jwt);
			}

			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

				if (jwtUtil.validateToken(jwt)) {
					// Set authentication context
					SecurityContextHolder.getContext().setAuthentication(
							new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()));
				}
			}
			chain.doFilter(request, response);
		} catch (TokenExpiredException ex) {
			PrintWriter out = response.getWriter();
			out.println(" JWT Token expired.....");
			out.close();
		}
	}	
}
/* MyJwt class will extends OncePerRequestFilter inheritance means this filter will execute only one per every request
 * 
  and override  doFilterInternal contains internal logic of the filter
  when the client is making the request he will send the token in the Authorization header 
  String authorizationHeader = request.getHeader("Authorization");// this filter will get the value from header and store 
  in the authorizationHeader.
  
   if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")) { if not == null and starts with Bearer if yes then
    jwt = authorizationHeader.substring(7);  token value is starts from 7 and in jwt variable token will be stored,
    
    
    username = jwtUtil.extractUsername(jwt);
    
    •	Here we are extracting the user name, user name is available in the payload (body) so here jwtUtil 
    is a class which I have created and extracting the user name from the body., extracted then user name is there then
    
    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
    after extracting the user name and it is not = to null
    
    •	If the user is already authenticate then
•	Authentication object is stored in security and it is managed by AuthenticationContextHolder.
•	How to check weather Authentication object is there or not in the security context, first
•	SecurityContextHolder has a method called getContext(). Return Security Context object, getAuthentication() method return Authentication object if == null means Authentication method is not there.
•	Then load the UserDetails  by the name from the Data base call loadUserByUsername () method,
•	Here  we are creating Custom UserDetailsService Class by implementing userDetailsServices
•	Then call the validateToken() method of jwtUtil if valid then and set the Authentication object in the securityContext it will give security context object
•	Authentication is an interface and UserNamePasswordAuthenticationToken is its implementation class object






JwtFilter
   |
   | read Authorization header
   |
   | extract token
   |
   | extract username from token
   |
   | load user from DB
   |
   | validate token
   |
   | set authentication in SecurityContext
   |
   | pass request to controller
  */



