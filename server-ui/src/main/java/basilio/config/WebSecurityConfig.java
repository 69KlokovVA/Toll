package basilio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css", "/img", "/login", "hello").permitAll()
                .antMatchers("/home").authenticated()
                .antMatchers("/error").authenticated()
                .antMatchers("/routes", "/payments/**").hasAnyRole("CLIENT", "MANAGER", "ROOT")
                .antMatchers("/registerClient/**").hasAnyRole("MANAGER", "ROOT")
                .antMatchers("/registerManager/**").hasRole("ROOT")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("user123").roles("USER")
                .and()
                .withUser("client").password("client123").roles("CLIENT")
                .and()
                .withUser("manager").password("manager123").roles("MANAGER","CLIENT")
                .and()
                .withUser("root").password("root123").roles("ROOT","MANAGER","CLIENT");

    }
}
