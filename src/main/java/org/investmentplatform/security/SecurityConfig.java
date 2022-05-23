package org.investmentplatform.security;

import javax.servlet.http.HttpServletResponse;

import org.investmentplatform.exception.UserNotFoundException;
import org.investmentplatform.model.user.UserRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserRepository userRepository;
    private final Logger logger;
    private final JwtTokenFilter jwtTokenFilter;
    
    @Value("${springdoc.api-docs.path}")
    private String restApiDocPath;
    @Value("${springdoc.swagger-ui.path}")
    private String swaggerPath;
    
    public SecurityConfig(Logger logger,
            UserRepository userRepo,
            JwtTokenFilter jwtTokenFilter) {
	super();
	
	this.logger = logger;
	this.userRepository = userRepo;
	this.jwtTokenFilter = jwtTokenFilter;

	// Inherit security context in async function calls
	SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
	}

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(email -> userRepository
            .findByEmail(email)
            .orElseThrow(
                () -> new UserNotFoundException(email)
            ));
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http = http.cors().and().csrf().disable();
        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();
        http = http
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, ex) -> {
                            logger.error("Unauthorized request - {}", ex.getMessage());
                            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
                        }
                )
                .and();

        http.authorizeRequests()
                // Swagger endpoints must be publicly accessible
                .antMatchers("/").permitAll()
                .antMatchers(restApiDocPath+"/**").permitAll()
                .antMatchers(swaggerPath+"/**").permitAll()
                // Our public endpoints
                
                .antMatchers("/api/public/**").permitAll()
                .antMatchers(HttpMethod.GET, "/categories/**").permitAll()
                .antMatchers(HttpMethod.GET, "/category/**").permitAll()
                .antMatchers(HttpMethod.GET, "/projects/**").permitAll()
                .antMatchers(HttpMethod.POST, "/login/**").permitAll()
                .antMatchers(HttpMethod.GET, "/login/**").permitAll()
                .antMatchers(HttpMethod.GET, "/admins/info/**").permitAll()
                .antMatchers(HttpMethod.GET, "/access/**").permitAll()
                // Our private endpoints
                
                .anyRequest().authenticated();

        // Add JWT token filter
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

}