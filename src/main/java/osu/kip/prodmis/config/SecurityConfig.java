package osu.kip.prodmis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
                .antMatchers("/", "/login", "/logout", "/403", "/public/**", "/img/**").permitAll()
                .antMatchers("/userlogins").hasAuthority("admin")
                .antMatchers("/userlogins/create-form").hasAuthority("admin")
                .requestMatchers(new EditFormMatcher()).denyAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll()
                .and()
            .logout()
                .invalidateHttpSession(true)
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                .and()
            .exceptionHandling()
                .accessDeniedPage("/403")
                .and()
            .csrf().disable();
	} 
  
  @Autowired
  @Qualifier("userDetailsService")
  UserDetailsService usersDetailsService;
  
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(usersDetailsService).passwordEncoder(passwordEncoder());  
	}	
 
  @Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}


  
  
} 