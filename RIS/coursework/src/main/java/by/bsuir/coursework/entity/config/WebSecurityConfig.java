package by.bsuir.coursework.entity.config;

import by.bsuir.coursework.service.CustomUserDetailsService;
import by.bsuir.coursework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    CustomUserDetailsService userDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;

//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

//    @Bean
//    public AuthenticationManager authenticationManager(
//            AuthenticationConfiguration authConfig) throws Exception {
//        return authConfig.getAuthenticationManager();
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests((req) -> req
                        //Доступ только для не зарегистрированных пользователей
                        .requestMatchers("/registration").permitAll()
                        //Доступ только для пользователей с ролью Администратор
                        .requestMatchers("/admin/*").hasRole("ADMIN")
                        .requestMatchers("/news").hasRole("USER")
                        //Доступ разрешен всем пользователей
                        .requestMatchers("/", "/resources/**").permitAll()
                        //Все остальные страницы требуют аутентификации
                        .anyRequest().authenticated())
                //Настройка для входа в систему
                .formLogin((form) -> form
                        .loginPage("/login")
                        //Перенарпавление на главную страницу после успешного входа
                        .defaultSuccessUrl("/")
                        .permitAll())
                .logout((logout) -> logout
                        .permitAll()
                        .logoutSuccessUrl("/"));
        return http.build();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}
