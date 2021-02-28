package softuni.linkedout_validationlab.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import softuni.linkedout_validationlab.service.impl.AppUserService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final AppUserService appUserService;

    public AppSecurityConfig(PasswordEncoder passwordEncoder, AppUserService appUserService) {
        this.passwordEncoder = passwordEncoder;
        this.appUserService = appUserService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable().
                authorizeRequests().
                antMatchers("/js/**", "/css/**", "/pic/**").permitAll().
                antMatchers("/", "/users/login", "/users/register").permitAll().
                antMatchers("/companies/all", "/employees/all").permitAll().
                antMatchers("/employees/add", "/companies/add").hasAuthority("ADMIN").
                antMatchers("/**").authenticated().
        and().
                formLogin().
                    loginPage("/users/login").
                    usernameParameter("username").
                    passwordParameter("password").
                    defaultSuccessUrl("/").
                    failureForwardUrl("/users/login-failure").
                and().
                logout().
                    logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(appUserService)
                .passwordEncoder(passwordEncoder);
    }
}
