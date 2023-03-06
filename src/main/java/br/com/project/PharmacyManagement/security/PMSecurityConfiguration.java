package br.com.project.PharmacyManagement.security;

import br.com.project.PharmacyManagement.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class PMSecurityConfiguration {

    @Autowired
    private UserEntityService userEntityService;

    @Autowired
    private PMJwtUserEntryPoint pmJwtUserEntryPoint;

    @Bean
    public PMJwtAuthenticationFilter filter() {
        return new PMJwtAuthenticationFilter();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .exceptionHandling()
                .authenticationEntryPoint(pmJwtUserEntryPoint)
                .and()
                .csrf().disable()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

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
                        );

        http.addFilterBefore(filter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }
}
