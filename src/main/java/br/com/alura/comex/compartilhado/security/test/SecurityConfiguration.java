package br.com.alura.comex.config.test;


import br.com.alura.comex.aplicacao.user.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private AutenticacaoService autenticacaoService;



    @Bean
    protected AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration, ApplicationContext context, ObjectPostProcessor<Object> objectPostProcessor) throws Exception {
        authenticationConfiguration.authenticationManagerBuilder(objectPostProcessor, context)
                .userDetailsService(autenticacaoService)
                .passwordEncoder(new BCryptPasswordEncoder());
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizedRequests -> authorizedRequests
                        .antMatchers( "/**").permitAll()
                        .anyRequest().authenticated())
                .csrf().disable();
    }



}
