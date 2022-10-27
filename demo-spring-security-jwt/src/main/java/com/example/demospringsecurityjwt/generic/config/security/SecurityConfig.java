package com.example.demospringsecurityjwt.generic.config.security;

import com.example.demospringsecurityjwt.generic.config.security.jwt.JwtAuthenticationFilter;
import com.example.demospringsecurityjwt.member.domain.MemberRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    private final AuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> {
            log.error("Responding with forbidden error. Message - {}", accessDeniedException.getMessage());
            response.sendError(HttpServletResponse.SC_FORBIDDEN, accessDeniedException.getMessage());
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                    .and()
                .csrf()
                    .disable()
                .exceptionHandling()
                    .authenticationEntryPoint(authenticationEntryPoint)
                    .accessDeniedHandler(accessDeniedHandler())
                    .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                .authorizeRequests()
                    .antMatchers("/images/**", "/favicon.ico",
                        "/**/*.png", "/**/*.gif", "/**/*.svg", "/**/*.jpg", "/**/*.ttf",
                        "/swagger*/**", "/**/api-docs", "/**/ui", "/configuration/**",
                        "/**/*.html*", "/**/*.css", "/**/*.js", "/**/*.json")
                        .permitAll()

//                .antMatchers("/", "/category/**", "/product/**", "/login", "/signup", "/order/**", "/oauth2/redirect") // 화면조회 url
//                        .permitAll()
                    .antMatchers("/api/members/login", "/api/members/signup")
                        .permitAll()
                    .antMatchers("/api/members/{id}").hasRole(MemberRole.MEMBER.name())
                    .antMatchers("/h2-console/**")
                        .permitAll()
                    .anyRequest()
                        .authenticated()
                    .and()
                .headers()
                    .frameOptions().disable()
                    .and()
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
