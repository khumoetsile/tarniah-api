//package com.example.demo.config.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Configuration
//    @EnableWebSecurity
//    @EnableGlobalMethodSecurity(prePostEnabled = true)
//    public class WebSecurityConfig {
//
//        @Autowired
//        UsuariService userDetailsService;
//
//        @Autowired
//        private AuthEntryPointJwt unauthorizedHandler;
//
//        @Bean
//        public AuthTokenFilter authenticationJwtTokenFilter() {
//            return new AuthTokenFilter();
//        }
//
//        @Bean
//        AuthenticationManager authenticationManager(AuthenticationManagerBuilder builder) throws Exception {
//            return builder.userDetailsService(userDetailsService).passwordEncoder(encoder()).and().build();
//        }
//
//        @Bean
//        public PasswordEncoder encoder() {
//            return new BCryptPasswordEncoder();
//        }
//
//        @Bean
//        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//            http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
//                    .antMatchers("/api/auth/**").permitAll()
//                    .antMatchers("/api/test/**").permitAll()
//                    .antMatchers("/api/v1/**").permitAll()
//                    .anyRequest().authenticated();
//            http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//            return http.build();
//        }
//    }
//}
