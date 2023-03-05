package br.com.project.PharmacyManagement.security;

import br.com.project.PharmacyManagement.service.UserEntityService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class PMJwtAuthenticationFilter extends OncePerRequestFilter {

    private String ultraPassword = "AMaeDeMariaTemTresFilhosJoseEJoaoQualONomeDoTerceiro";

    @Autowired
    private UserEntityService userEntityService;

    @Autowired
    private PMJwtAuthenticationProvider pmJwtAuthenticationProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = pmJwtAuthenticationProvider.getToken(request.getHeader("Authorization"));

        if (token != null && pmJwtAuthenticationProvider.isTokenValid(token)){

            String username = pmJwtAuthenticationProvider.getUsername(token);

            UserDetails userDetails = this.userEntityService.loadUserByUsername(username);

            if (userDetails != null) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities());

                usernamePasswordAuthenticationToken.setDetails(new
                        WebAuthenticationDetailsSource()
                        .buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request,response);
    }

}
