package com.banking.authservice.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.banking.authservice.jwt.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//1.create this class and anotate it to @Componenet and extend OnceRequestFilter
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	//2.Override the parent class method
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//3.get the string value from header using get header
		String authHeader=request.getHeader("Authorization");
		
		//4. then check authHeader null or it starts with Bearer or not
		if(authHeader==null|| !authHeader.startsWith("Bearer")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		//5. authHeader not null and has Bearer then get the Except Bearer string into jwt
		final String token=authHeader.substring(7);
		//6. get the userName from extractUserName method
		final String userName=this.jwtService.extractUserName(token);
		
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		
		if(userName!=null && authentication==null) {
			UserDetails userDetails=this.userDetailsService.loadUserByUsername(userName);
			if(this.jwtService.isTokenValid(token,userDetails)) {
				UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				authenticationToken.setDetails(
						new WebAuthenticationDetailsSource()
						.buildDetails(request)
						);
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
		
		filterChain.doFilter(request, response);
	}

}
