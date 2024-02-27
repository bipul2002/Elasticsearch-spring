//package com.elasticsearch.elasticsearch.config;
//
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .requiresChannel(channel->channel
//                        .anyRequest().requiresSecure())      //to access only secure connection
//                .authorizeRequests(authorize -> authorize
//                        .anyRequest().authenticated())
//                .oauth2Login(authLogin -> authLogin
//                        .defaultSuccessUrl("/person/all", true));
//
//
//        return http.build();
//
//
//    }
//}
