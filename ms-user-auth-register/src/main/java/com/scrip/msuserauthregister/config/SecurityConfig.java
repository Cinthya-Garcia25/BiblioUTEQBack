package com.scrip.msuserauthregister.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// LOS IMPORTS CORREGIDOS PARA 3.x:
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Cadena de Filtros 1: Dedicada exclusivamente al Servidor de Autorización OAuth 2.1
//    @Bean
//    @Order(1)
//    public SecurityFilterChain authServerSecurityFilterChain(HttpSecurity http) throws Exception {
//        // 1. Crear la instancia de configuración primero
//        OAuth2AuthorizationServerConfigurer authorizationServerConfigurer =
//                new OAuth2AuthorizationServerConfigurer();
//
//        // 2. Delimitar el alcance de la cadena y asociar el configurer a http
//        http
//                .securityMatcher(authorizationServerConfigurer.getEndpointsMatcher())
//                .with(authorizationServerConfigurer, Customizer.withDefaults());
//
//        // 3. AHORA SÍ recuperamos el objeto ya registrado para activar OpenID Connect
//        http.getConfigurer(OAuth2AuthorizationServerConfigurer.class)
//                .oidc(Customizer.withDefaults()); // Habilita OpenID Connect 1.0 (OIDC)
//
//        http.exceptionHandling(exceptions -> exceptions
//                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
//        );
//
//        return http.build();
//    }

    @Bean
    @Order(1)
    public SecurityFilterChain authServerSecurityFilterChain(HttpSecurity http) throws Exception {
        // 1. En la versión 3.x, aplicamos la configuración por defecto de forma estática y limpia:
        OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);

        // 2. Recuperamos el configurer ya inicializado internamente por el helper para activar OpenID Connect
        http.getConfigurer(OAuth2AuthorizationServerConfigurer.class)
                .oidc(Customizer.withDefaults()); // Habilita OpenID Connect 1.0 (OIDC)

        http.exceptionHandling(exceptions -> exceptions
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
        );

        return http.build();
    }

    // Cadena de Filtros 2: Dedicada a tus endpoints de negocio (API REST)
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        // Tus rutas públicas (registro, etc.)
                        .requestMatchers("/api/v1/users/register").permitAll()
                        // Cualquier otra requiere estar autenticado
                        .anyRequest().authenticated()
                )
                // 1. Esto es lo que te está pintando el HTML. Lo dejamos por si se ocupa,
                // pero añadimos soporte para tokens Bearer:
                .formLogin(Customizer.withDefaults())

                // 2. AÑADE ESTA LÍNEA CRUCIAL:
                // Le dice al microservicio que si viene un token JWT en la cabecera, lo use para autenticar
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));

        return http.build();
    }
}