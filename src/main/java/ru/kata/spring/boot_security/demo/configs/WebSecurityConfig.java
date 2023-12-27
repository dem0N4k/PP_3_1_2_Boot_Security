package ru.kata.spring.boot_security.demo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final SuccessUserHandler successUserHandler;
//    private final UserDetailsService userDetailsService;
//    private final AuthProviderImpl authProvider;

    public WebSecurityConfig(SuccessUserHandler successUserHandler) {
        this.successUserHandler = successUserHandler;
//        this.userDetailsService = userDetailsService;
//        this.authProvider = authProvider;
    }
//    @Autowired
//    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http
//                .authorizeRequests()
//                .antMatchers("/", "/index").permitAll()
//                .antMatchers("/user/**").hasRole("USER")
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .successHandler(successUserHandler)
//                .permitAll()
//                .and()
//                .logout().permitAll()
//                .logoutSuccessUrl("/");
//    }
//        http
//                .authorizeRequests()
//                .antMatchers("/", "/index").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().successHandler(successUserHandler)
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }


        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").anonymous()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()

                .formLogin()
//                .loginPage("/login")
                .successHandler(successUserHandler)
//                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and()

                .logout().permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/");

//                //выключаем кросс-доменную секьюрность (на этапе обучения неважна)
//                .and().csrf().disable(); //- попробуйте выяснить сами, что это даёт
    }

    // аутентификация inMemory
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password("{bcrypt}$2a$12$fGRsrvjEfZY52KTpi1GWBOw/qx0zLC7aXg0vhFikcNtuunXNbz9yy")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{bcrypt}$2a$12$/pkLowPtlt5ZMVdYSVk6l.hjhApupJp8Ivm05c.wO0wemg6QOJobm")
                .roles("ADMIN", "USER")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(12);
//    }


}