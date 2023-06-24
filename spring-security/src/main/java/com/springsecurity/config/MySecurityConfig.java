package com.springsecurity.config;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springsecurity.authenticationproviders.MyCustomFormAuthenticationProvider;
import com.springsecurity.filters.MyAuthenticationLoggerFilter;
import com.springsecurity.service.CustomerUserDetailsServiceImpl;

@EnableWebSecurity(debug = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomerUserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private MyCustomFormAuthenticationProvider customAuthProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// IN SERVER MEMORY
		//-----------------
		/*auth
		.inMemoryAuthentication()
		.withUser("ujjwal")
//		.password("ujjwal123")
//		.password("{noop}ujjwal123") // in this case no need to write PasswordEncoder @Bean in config class
		.password("$2y$10$D87ERiBsdWtW5xjIKdBJo.PtlCiOUpalLct/W0Gzq5LDUdxBpHpTq")
//		.password("{bcrypt}$2y$10$D87ERiBsdWtW5xjIKdBJo.PtlCiOUpalLct/W0Gzq5LDUdxBpHpTq")
		.roles("admin")
		.and()
		 .withUser("amit")
		 .password("$2a$12$bXU8v8BhCHiejohC6fpCS.N6l9YDxXAf3Pbq9.luBt4n2SiykBU/y") // amit123
		 .roles("user");*/
		
		
		// LOADING FROM DATABASE
		//----------------------
		// internally uses loadUserByUsername() method from UserDetailsService(I)/UserDetailsManager(I)
//		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder);
		
		// LOADING DATA FROM DATABASE WHEN CUSTOM SCHEMA & TABLE IS USED INSTEAD OF SPRING SECURITY DEFAULT SCHEMA
		/*auth
		.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username, password, enabled from customers where username = ?")
		.authoritiesByUsernameQuery("select username, roles from customers where username = ?")
		.passwordEncoder(passwordEncoder);*/
		
		// Custom UserDetailsService(I) Impl class loading and linking
		//------------------------------------------------------------
//		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
		
		// Custom AuthenticationProvider loading/linking
		auth.authenticationProvider(customAuthProvider);
	}
	
	// OVERRIDING above configure() method freshly for learning SPRING SECURITY INTERNALS AND ARCHITECTURE
	//-----------------------------------------------------------------------------------------------------
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// 1st way to create a User object
		//--------------------------------
		
		ArrayList<GrantedAuthority> roles = new ArrayList<>();
		
		// SimpleGrantedAuthority(c) <-- GrantedAuthority(I)
		SimpleGrantedAuthority role1 = new SimpleGrantedAuthority("ADMIN");
		SimpleGrantedAuthority role2 = new SimpleGrantedAuthority("USER");
		
		roles.add(role1);
		roles.add(role2);
		
		// UserDetails(I) <-- User(C)
		User user1 = new User("ujjwal", "ujjwal123", roles);

		
		// 2nd another way to create a User object in simple way
		//-------------------------------------------------------
	
	     // UserDetailsManager(I) it manages the created user object <-- InMemoryUserDetailsManager(C) 
	    //----------------------------------------------------------------------------------------
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
		
		UserDetails user1 = User.withUsername("ujjwal").password("ujjwal123").roles("USER", "ADMIN").build();
		UserDetails user2 = User.withUsername("amit").password("amit123").roles("USER").build();
		
		inMemoryUserDetailsManager.createUser(user1);
		inMemoryUserDetailsManager.createUser(user2);
		
//		auth.userDetailsService(inMemoryUserDetailsManager);
	}*/
	
	// 2) overriding another overloaded configure method to enable/disable FORM AUTHENTICATION
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/*http
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic()
		.and()
		.formLogin();*/
		
		// securing "/hello" and "/bye" and un-securing "/helloWorld"
		//-----------------------------------------------------------
		/*http
		.authorizeRequests()
		.antMatchers("/hello").authenticated()
		.antMatchers("/bye").authenticated()
//		.antMatchers("/helloWorld").permitAll()
		.antMatchers("/helloWorld").authenticated()
		.and()
		.formLogin().loginPage("/myCustomLoginPage").loginProcessingUrl("/process-login").permitAll()
		.and()
		.httpBasic()
		.and().logout();*/
		
		// ROLE BASED AUTHENTICATION
		//--------------------------
		http
		.addFilterAfter(new MyAuthenticationLoggerFilter(), UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests()
//		.anyRequest().authenticated()
		.antMatchers("/coder").hasAuthority("Coder")
		.antMatchers("/trainer").hasAuthority("Trainer")
		.antMatchers("/", "/hello", "/bye").authenticated()
		.and().formLogin().loginPage("/myCustomLoginPage").loginProcessingUrl("/process-login").permitAll()
		    .usernameParameter("myUsername")
		    .passwordParameter("myPassword")
		.and().httpBasic()
		.and().logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/access-denied");
	}

}
