package com.sapient.pst.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri:http://localhost:8083/oauth2/jwks}")
	private String issuerUri;
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
		security.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
		.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
	
		return security.build();
	}
	
	@Bean
	JwtDecoder jwtDecoder() {
		NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder.withJwkSetUri(issuerUri)
				.build();
		
		return jwtDecoder;
	}
}
