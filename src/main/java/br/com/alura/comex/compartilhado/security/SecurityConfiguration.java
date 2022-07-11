package br.com.alura.comex.config.security;


import br.com.alura.comex.aplicacao.user.AutenticacaoService;
import br.com.alura.comex.aplicacao.user.AutenticacaoViaTokenFilter;
import br.com.alura.comex.aplicacao.user.TokenService;
import br.com.alura.comex.infra.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Profile("dev")
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


        @Autowired
        private TokenService tokenService;

        @Autowired
        private UsuarioRepository usuarioRepository;


        @Override
        @Bean
        protected AuthenticationManager authenticationManager() throws Exception {
            return super.authenticationManager();
        }

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
            http.authorizeRequests()
                    .antMatchers(HttpMethod.GET,"/categoria/**").permitAll()
                    .antMatchers(HttpMethod.GET,"/produto/**").permitAll()
                    .antMatchers(HttpMethod.GET,"/categoria/pedidos").permitAll()
                    .antMatchers(HttpMethod.GET,"/api/**").permitAll()
                    .antMatchers(HttpMethod.POST,"/auth").permitAll()
                    .antMatchers(HttpMethod.GET,"/actuator/**").permitAll()
                    .antMatchers("/swagger-ui/**").permitAll()
                    .antMatchers("/v3/api-docs/**").permitAll()
                    .anyRequest().authenticated()
                    .and().csrf().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService,usuarioRepository), UsernamePasswordAuthenticationFilter.class);
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
        }

        @Bean
        public PasswordEncoder encoder() {
            return new BCryptPasswordEncoder();
        }

    }
