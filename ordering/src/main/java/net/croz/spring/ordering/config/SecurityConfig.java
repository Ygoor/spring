package net.croz.spring.ordering.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http
//			.csrf().disable()
//			.cors().disable()	
//			.logout()//default logout handling
//				.permitAll()//allow all as it will be accessed when user is not logged in anymore
//				.clearAuthentication(true)
//				.logoutUrl("logout")
//				.logoutSuccessUrl("http://www.index.hr")
//			.and()
			.authorizeRequests()
				.antMatchers("/styles/**").permitAll()
				.antMatchers("/proizvod").hasRole("EDIT")			
				.antMatchers("/dohvatiProizvode").hasAnyRole("EDIT","VIEW")			
	        	.anyRequest()//allow all urls
	        	.authenticated()//all URLs are allowed by any authenticated user, no role restrictions.
			.and()
			.exceptionHandling()
				.accessDeniedPage("/denied")
			.and()	
			.formLogin()//enable form based authentication
				.loginPage("/login")//use a custom login URI
	         	.permitAll(true)//login URI can be accessed by anyone
	         	.defaultSuccessUrl("/dohvatiProizvode");

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("a").password("{noop}a").roles("ADMIN")
		.and()
		.withUser("e").password("{noop}e").roles("EDIT")
		.and()
		.withUser("v").password("{noop}v").roles("VIEW");

	}
	
	
}
