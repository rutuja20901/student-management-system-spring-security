package com.usermanagement.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//		
//		http
//		.csrf(csrf -> csrf.disable())
//		.authorizeHttpRequests(auth -> auth.requestMatchers("/login")
//				.permitAll()
//				.anyRequest()
//				.authenticated())
//		.formLogin(form -> form
//				.loginPage("/login")
//				.loginProcessingUrl("/login")
//				.defaultSuccessUrl("/dashboard" ,true)
//				.permitAll())
//		.logout(logout -> logout.logoutSuccessUrl("/login?logout"));
		
		
		return http.formLogin(httpForm -> {
			httpForm.loginPage("/login")
			.usernameParameter("email") // email
		    .passwordParameter("password")
		    .defaultSuccessUrl("/students/dashboard", true)
		    .failureUrl("/login?error")
		    .permitAll();
		})
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(registry -> {
					registry.requestMatchers("/register","/css/**","/js/**","/students").permitAll()
					.requestMatchers("/students/dashboard").authenticated();     //Login required
				registry.anyRequest().permitAll();
				})
		.logout(logout -> {
			logout.logoutUrl("/logout")
			.logoutSuccessUrl("/login?logout")
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.deleteCookies("JSESSIONID");
		})
		
		 .build();
		
	}
	
}
