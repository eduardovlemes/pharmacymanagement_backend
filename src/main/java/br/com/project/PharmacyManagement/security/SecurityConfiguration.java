package br.com.project.PharmacyManagement.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final AuthenticationProvider authenticationProvider;

    @Bean
    public JwtAuthenticationFilter filter() {
        return new JwtAuthenticationFilter();
    };

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authenticationProvider(authenticationProvider)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests((auth) ->
                        auth
                                .requestMatchers(HttpMethod.POST,"/usuario/**").permitAll()

                                .requestMatchers(HttpMethod.POST,"/farmacia/**").hasAnyRole("COLLABORATOR", "MANAGER", "ADMINISTRATOR")
                                .requestMatchers(HttpMethod.GET,"/farmacia/**").hasAnyRole("COLLABORATOR", "MANAGER", "ADMINISTRATOR")
                                .requestMatchers(HttpMethod.PUT,"/farmacia/**").hasAnyRole("MANAGER", "ADMINISTRATOR")
                                .requestMatchers(HttpMethod.DELETE,"/farmacia/**").hasAnyRole("ADMINISTRATOR")

                                .requestMatchers(HttpMethod.POST,"/medicamentos/**").hasAnyRole("COLLABORATOR", "MANAGER", "ADMINISTRATOR")
                                .requestMatchers(HttpMethod.GET,"/medicamentos/**").hasAnyRole("COLLABORATOR", "MANAGER", "ADMINISTRATOR")
                                .requestMatchers(HttpMethod.PUT,"/medicamentos/**").hasAnyRole("MANAGER", "ADMINISTRATOR")
                                .requestMatchers(HttpMethod.DELETE,"/medicamentos/**").hasAnyRole("ADMINISTRATOR")

                                .requestMatchers(HttpMethod.GET,"/demo/**").hasAnyRole("COLLABORATOR", "MANAGER", "ADMINISTRATOR")
                );
        http.addFilterBefore(filter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
