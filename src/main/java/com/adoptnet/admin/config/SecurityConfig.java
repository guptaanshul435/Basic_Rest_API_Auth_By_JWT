package com.adoptnet.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.adoptnet.admin.security.JwtAuthenticationEntryPoint;
import com.adoptnet.admin.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	
    	http.csrf(csrf -> csrf.disable())
//           .cors(cors ->cors.disable())
			.authorizeHttpRequests((authorizeRequests) ->
				authorizeRequests
			    	.requestMatchers("/dep/**").hasRole("ADMIN")
					.requestMatchers("/student/**").hasRole("ADMIN")
					.requestMatchers("/admins/**").hasRole("ADMIN")
					.requestMatchers("/auth/login").permitAll()
					.anyRequest().authenticated())
			.exceptionHandling(ex-> ex.authenticationEntryPoint(point))
			.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
			
			
			
		//return http.build();

//        http.csrf(csrf -> csrf.disable())
//                .cors(cors ->cors.disable())
//                .authorizeRequests(auth-> auth.requestMatchers("/student/**","/departments/**","/admins/**").authenticated().requestMatchers("/auth/login").permitAll().anyRequest().authenticated())
//                .exceptionHandling(ex-> ex.authenticationEntryPoint(point))    //.requestMatchers("/department/**").authenticated().requestMatchers("/admins/**").authenticated()
//                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
               
                
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


}
