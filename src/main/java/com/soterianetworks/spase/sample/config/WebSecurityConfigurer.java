package com.soterianetworks.spase.sample.config;

import com.soterianetworks.spase.security.filter.SpaseAuthenticationFilter;
import com.soterianetworks.spase.security.support.UserDetailsService;
import com.soterianetworks.spase.security.support.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsServiceImpl() {
        return new UserDetailsServiceImpl();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/", "/health", "/info", "/favicon.ico", "/error");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(new SpaseAuthenticationFilter(userDetailsServiceImpl()),
                             BasicAuthenticationFilter.class);

        http.csrf().disable();

        http.authorizeRequests().anyRequest().authenticated()
            .and()
            .formLogin().disable();
    }

}
