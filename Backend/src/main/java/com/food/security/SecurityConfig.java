//package com.food.security;
//
//import java.util.List;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import lombok.RequiredArgsConstructor;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//@RequiredArgsConstructor
//public class SecurityConfig {
//
//private final CustomJwtVerificationFilter jwtAuthenticationFilter;
//
//@Bean
//public SecurityFilterChain securityFilterChain(
//        HttpSecurity http) throws Exception {
//
//    http
//
//        //==================================================
//        // CORS
//        // ==================================================
//        .cors(cors ->
//            cors.configurationSource(
//                corsConfigurationSource()
//            )
//        )
//
//        // ==================================================
//        // CSRF
//        // ==================================================
//        .csrf(csrf ->
//            csrf.disable()
//        )
//
//        // ==================================================
//        // STATELESS
//        // ==================================================
//        .sessionManagement(session ->
//            session.sessionCreationPolicy(
//                SessionCreationPolicy.STATELESS
//            )
//        )
//
//        // ==================================================
//        // AUTHORIZATION
//        // ==================================================
//        .authorizeHttpRequests(request -> request
//
//            // ------------------------------------------------
//            // CORS PREFLIGHT
//            // ------------------------------------------------
//            .requestMatchers(
//                HttpMethod.OPTIONS,
//                "/**"
//            ).permitAll()
//
//            // ------------------------------------------------
//            // PUBLIC
//            // ------------------------------------------------
//            .requestMatchers(
//                "/api/auth/**",
//                "/swagger-ui/**",
//                "/swagger-ui.html",
//                "/v3/api-docs/**"
//            ).permitAll()
//
//            // =================================================
//            // ADMIN ONLY
//            // =================================================
//
//            .requestMatchers(
//                "/api/admin/**"
//            ).hasRole("ADMIN")
//
//            .requestMatchers(
//                "/api/users/**"
//            ).hasRole("ADMIN")
//
//            .requestMatchers(
//                "/api/activity-logs/**"
//            ).hasRole("ADMIN")
//
//            .requestMatchers(
//                "/api/documents/**"
//            ).hasRole("ADMIN")
//
//            // =================================================
//            // DONOR
//            // =================================================
//
//            .requestMatchers(
//                "/api/donor/**"
//            ).hasAnyRole(
//                "DONOR",
//                "ADMIN"
//            )
//
//            .requestMatchers(
//                "/api/media/**"
//            ).hasAnyRole(
//                "DONOR",
//                "ADMIN"
//            )
//
//            // =================================================
//            // REQUESTS
//            // =================================================
//
//            .requestMatchers(
//                HttpMethod.GET,
//                "/api/requests/active"
//            ).hasAnyRole(
//                "RECEIVER",
//                "ADMIN"
//            )
//
//            .requestMatchers(
//                "/api/requests/**"
//            ).hasAnyRole(
//                "DONOR",
//                "RECEIVER",
//                "ADMIN"
//            )
//
//            // =================================================
//            // REQUEST ITEMS
//            // =================================================
//
//            .requestMatchers(
//                "/api/request-item/**"
//            ).hasAnyRole(
//                "DONOR",
//                "RECEIVER",
//                "ADMIN"
//            )
//
//            // =================================================
//            // MATCHING
//            // =================================================
//
//            // Admin approves/rejects and assigns
//            .requestMatchers(
//                "/api/match/*/approve",
//                "/api/match/*/reject",
//                "/api/match/*/assign-delivery"
//            ).hasRole("ADMIN")
//
//            // Receiver can create/view their matching requests
//            .requestMatchers(
//                HttpMethod.POST,
//                "/api/match/**"
//            ).hasAnyRole(
//                "RECEIVER",
//                "ADMIN"
//            )
//
//            .requestMatchers(
//                HttpMethod.GET,
//                "/api/match/**"
//            ).hasAnyRole(
//                "RECEIVER",
//                "VOLUNTEER",
//                "ADMIN"
//            )
//
//            // =================================================
//            // DELIVERIES
//            // =================================================
//
//            .requestMatchers(
//                "/api/deliveries/**"
//            ).hasAnyRole(
//                "VOLUNTEER",
//                "ADMIN"
//            )
//
//            // =================================================
//            // WASTE / INDUSTRY
//            // =================================================
//
//            .requestMatchers(
//                "/api/waste/**"
//            ).hasAnyRole(
//                "BIOGAS_PARTNER",
//                "ADMIN"
//            )
//
//            // =================================================
//            // DASHBOARDS
//            // =================================================
//
//            .requestMatchers(
//                "/api/dashboard/admin/**"
//            ).hasRole("ADMIN")
//
//            .requestMatchers(
//                "/api/dashboard/donor/**"
//            ).hasAnyRole(
//                "DONOR",
//                "ADMIN"
//            )
//
//            .requestMatchers(
//                "/api/dashboard/receiver/**"
//            ).hasAnyRole(
//                "RECEIVER",
//                "ADMIN"
//            )
//
//            .requestMatchers(
//                "/api/dashboard/volunteer/**"
//            ).hasAnyRole(
//                "VOLUNTEER",
//                "ADMIN"
//            )
//
//            .requestMatchers(
//                "/api/dashboard/waste-dashboard/**"
//            ).hasAnyRole(
//                "BIOGAS_PARTNER",
//                "ADMIN"
//            )
//
//            .requestMatchers(
//                "/api/dashboard/impact",
//                "/api/dashboard/statistics"
//            ).hasAnyRole(
//                "ADMIN",
//                "DONOR",
//                "RECEIVER",
//                "VOLUNTEER",
//                "BIOGAS_PARTNER"
//            )
//
//            // =================================================
//            // NOTIFICATIONS
//            // =================================================
//
//            .requestMatchers(
//                "/api/notification/**"
//            ).authenticated()
//
//            // =================================================
//            // DELIVERY OUTCOME
//            // =================================================
//
//            .requestMatchers(
//                "/api/delivery-outcomes/**"
//            ).hasAnyRole(
//                "VOLUNTEER",
//                "ADMIN"
//            )
//
//            // =================================================
//            // EVERYTHING ELSE
//            // =================================================
//
//            .anyRequest().authenticated()
//        )
//
//        // ==================================================
//        // JWT
//        // ==================================================
//
//        .addFilterBefore(
//            jwtAuthenticationFilter,
//            UsernamePasswordAuthenticationFilter.class
//        );
//
//    return http.build();
//}
//
//// ======================================================
//// CORS
//// ======================================================
//
//@Bean
//public CorsConfigurationSource corsConfigurationSource() {
//
//    CorsConfiguration configuration =
//            new CorsConfiguration();
//
//    configuration.setAllowedOriginPatterns(
//            List.of(
//                "http://localhost:5173",
//                "http://localhost:5174"
//            )
//    );
//
//    configuration.setAllowedMethods(
//            List.of(
//                "GET",
//                "POST",
//                "PUT",
//                "DELETE",
//                "OPTIONS"
//            )
//    );
//
//    configuration.setAllowedHeaders(
//            List.of("*")
//    );
//
//    configuration.setExposedHeaders(
//            List.of("*")
//    );
//
//    configuration.setAllowCredentials(true);
//
//    UrlBasedCorsConfigurationSource source =
//            new UrlBasedCorsConfigurationSource();
//
//    source.registerCorsConfiguration(
//            "/**",
//            configuration
//    );
//
//    return source;
//}
//
//// ======================================================
//// PASSWORD ENCODER
//// ======================================================
//
//@Bean
//public PasswordEncoder passwordEncoder() {
//
//    return new BCryptPasswordEncoder();
//}
//
//// ======================================================
//// AUTHENTICATION MANAGER
//// ======================================================
//
//@Bean
//public AuthenticationManager authenticationManager(
//        AuthenticationConfiguration config)
//        throws Exception {
//
//    return config.getAuthenticationManager();
//}
//
//
//}



package com.food.security;

import java.util.Arrays;
import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomJwtVerificationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            .authorizeHttpRequests(request -> request

                // CORS preflight
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                // Public APIs
                .requestMatchers(
                    "/api/auth/**",
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/v3/api-docs/**"
                ).permitAll()

                // Admin APIs
                .requestMatchers("/api/admin/**").hasRole("ADMIN")
                .requestMatchers("/api/users/**").hasRole("ADMIN")
                .requestMatchers("/api/activity-logs/**").hasRole("ADMIN")
                .requestMatchers("/api/documents/**").hasRole("ADMIN")

                // Donor APIs
                .requestMatchers("/api/donor/**")
                    .hasAnyRole("DONOR", "ADMIN")

                .requestMatchers("/api/media/**")
                    .hasAnyRole("DONOR", "ADMIN")

                // Request APIs
                .requestMatchers(
                    HttpMethod.GET,
                    "/api/requests/active"
                ).hasAnyRole("RECEIVER", "ADMIN")

                .requestMatchers("/api/requests/**")
                    .hasAnyRole("DONOR", "RECEIVER", "ADMIN")

                // Request item APIs
                .requestMatchers("/api/request-item/**")
                    .hasAnyRole("DONOR", "RECEIVER", "ADMIN")

                // Match APIs: admin actions
                .requestMatchers(
                    "/api/match/*/approve",
                    "/api/match/*/reject",
                    "/api/match/*/assign-delivery"
                ).hasRole("ADMIN")

                // Only admin can view all pending matches
                .requestMatchers(
                    HttpMethod.GET,
                    "/api/match/pending"
                ).hasRole("ADMIN")

                // Users can request their own matches.
                // IMPORTANT: enforce user ownership in the service/controller.
                .requestMatchers(
                    HttpMethod.GET,
                    "/api/match/user/*"
                ).hasAnyRole("DONOR", "RECEIVER", "ADMIN")

                // Individual match details.
                // IMPORTANT: enforce user ownership in the service/controller.
                .requestMatchers(
                    HttpMethod.GET,
                    "/api/match/*"
                ).hasAnyRole("DONOR", "RECEIVER", "VOLUNTEER", "ADMIN")

                // Only admin and volunteer can list all matches
                .requestMatchers(
                    HttpMethod.GET,
                    "/api/match"
                ).hasAnyRole("ADMIN", "VOLUNTEER")

                // Match creation
                .requestMatchers(
                    HttpMethod.POST,
                    "/api/match",
                    "/api/match/"
                ).hasAnyRole("RECEIVER", "ADMIN")

                // Block other match operations unless explicitly authorized
                .requestMatchers("/api/match/**").denyAll()

                // Delivery APIs
                .requestMatchers("/api/deliveries/**")
                    .hasAnyRole("VOLUNTEER", "ADMIN")

                // Waste / industry APIs
                .requestMatchers("/api/waste/**")
                    .hasAnyRole("BIOGAS_PARTNER", "ADMIN")

                // Dashboard APIs
                .requestMatchers("/api/dashboard/admin/**")
                    .hasRole("ADMIN")

                .requestMatchers("/api/dashboard/donor/**")
                    .hasAnyRole("DONOR", "ADMIN")

                .requestMatchers("/api/dashboard/receiver/**")
                    .hasAnyRole("RECEIVER", "ADMIN")

                .requestMatchers("/api/dashboard/volunteer/**")
                    .hasAnyRole("VOLUNTEER", "ADMIN")

                .requestMatchers("/api/dashboard/waste-dashboard/**")
                    .hasAnyRole("BIOGAS_PARTNER", "ADMIN")

                .requestMatchers(
                    "/api/dashboard/impact",
                    "/api/dashboard/statistics"
                ).hasAnyRole(
                    "ADMIN",
                    "DONOR",
                    "RECEIVER",
                    "VOLUNTEER",
                    "BIOGAS_PARTNER"
                )

                // Notifications
                .requestMatchers("/api/notification/**").authenticated()

                // Delivery outcome
                .requestMatchers("/api/delivery-outcomes/**")
                    .hasAnyRole("VOLUNTEER", "ADMIN")

                // All remaining endpoints require authentication
                .anyRequest().authenticated()
            )

            .addFilterBefore(
                jwtAuthenticationFilter,
                UsernamePasswordAuthenticationFilter.class
            );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();

        // Add your deployed frontend origin here before production deployment.
        String configuredOrigins = System.getenv().getOrDefault(
            "FRONTEND_ORIGINS",
            "http://localhost:5173,http://localhost:5174"
        );

        List<String> origins = Arrays.stream(configuredOrigins.split(","))
            .map(String::trim)
            .filter(origin -> !origin.isEmpty())
            .toList();

        configuration.setAllowedOrigins(origins);

        configuration.setAllowedMethods(
            List.of("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
        );

        configuration.setAllowedHeaders(
            List.of("Authorization", "Content-Type", "Accept")
        );

        configuration.setExposedHeaders(
            List.of("Authorization")
        );

        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source =
            new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
