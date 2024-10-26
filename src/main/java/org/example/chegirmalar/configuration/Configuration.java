package org.example.chegirmalar.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@org.springframework.context.annotation.Configuration
@EnableWebSecurity
public class Configuration {


    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails user1 = User.withUsername("qwer1").password("qwer1").build();
        UserDetails user2 = User.withUsername("qwer2").password("qwer2").build();
        return new InMemoryUserDetailsManager(user1, user2);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
