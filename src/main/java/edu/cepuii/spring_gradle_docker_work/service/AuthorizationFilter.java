package edu.cepuii.spring_gradle_docker_work.service;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class AuthorizationFilter extends OncePerRequestFilter {
  
  private final TokenService tokenService;
  @Value("${auth.enabled}")
  private boolean enabled;
  
  @Override
  protected void doFilterInternal(@NonNull HttpServletRequest request,
      @NonNull HttpServletResponse response,
      @NonNull FilterChain filterChain) throws ServletException, IOException {
    
    if (!enabled) {   //authorization off
      filterChain.doFilter(request, response);
    }
    
    String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    if (authHeader == null || authHeader.isBlank()) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    } else if (!checkAuthorization(authHeader)) {
      response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    } else {
      filterChain.doFilter(request, response);
    }
    
    
  }
  
  private boolean checkAuthorization(String authHeader) {
    if (authHeader.startsWith("Bearer ")) {
      return false;
    }
    String token = authHeader.substring(7);
    return tokenService.checkToken(token);
  }
}
