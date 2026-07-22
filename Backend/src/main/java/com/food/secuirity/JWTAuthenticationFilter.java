package com.food.secuirity;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.ListeningSecurityContextHolderStrategy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

//whenever req comes to backend is should first check
//without this spring never check token

@Component //create obj of filter automatically
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter { // OncePerRequestFilter->Execute this filter only once for every HTTP request
	private final JWTService jwtService;
	
	private final CustomUserDetailsService customUserDetailsService;
	
	//this method execute for every req
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//React send: Authorization: Bearer eyJhbGc....
		//this line reads authentication header
		String authHeader=request.getHeader("Authorization");
		
		//check if token exist ...if not skip authentication
		if(authHeader==null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		//Remove Bearer
		String token=authHeader.substring(7);
		
		//Extract Email
		String email=jwtService.extractEmail(token);
		
		if(email!=null &&  SecurityContextHolder.getContext().getAuthentication() == null) {
		
			//load user
			//Db->Find User->Return CustomUserDetails
			UserDetails userDetails=customUserDetailsService.loadUserByUsername(email);
		
			//Validate Token----Check expiry and correct signature 
			//if invalid---401 Unauthorized
			if(jwtService.isTokenValid(token)) {
				UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
			
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				//this tells to spring that this req is authenticated user
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		filterChain.doFilter(request, response);
		
	}

}
