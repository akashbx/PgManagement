package com.ottego.PgManagement.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String phone = null;
        String jwt = null;

        try {
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                jwt = authHeader.substring(7);
                phone = jwtUtil.extractPhone(jwt);
            }

            if (phone != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                if (jwtUtil.validateToken(jwt, phone)) {
                    String role = jwtUtil.extractRole(jwt);
                    Integer id = jwtUtil.extractUserId(jwt);

                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(
                                    phone,
                                    null,
                                    List.of(new SimpleGrantedAuthority("ROLE_" + role)) // ROLE_OWNER / ROLE_CARETAKER
                            );

                    authentication.setDetails(Map.of(
                            "id", id,
                            "phone", phone,
                            "role", role
                    ));

                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }

            chain.doFilter(request, response);

        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            sendError(response, "Token expired");
        } catch (io.jsonwebtoken.SignatureException | io.jsonwebtoken.MalformedJwtException e) {
            sendError(response, "Invalid token");
        } catch (Exception e) {
            sendError(response, "Need authorization");
        }
    }

    private void sendError(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        new ObjectMapper().writeValue(response.getOutputStream(), Map.of("error", message));
    }
}
