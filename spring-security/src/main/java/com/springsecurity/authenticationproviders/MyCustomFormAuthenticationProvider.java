package com.springsecurity.authenticationproviders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.springsecurity.dto.Customer;
import com.springsecurity.signupdao.ICustomerDAO;

@Component
public class MyCustomFormAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private ICustomerDAO customerDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		System.out.println("*******************************************************");

		// write your authentication logic to authenticate an user
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		// look inside your database if the given uses exits or not
		List<Customer> customerFromDb = customerDao.findCustomerByCustomerName(username);

		if (customerFromDb.size() > 0) {

			Customer customer = customerFromDb.get(0);

			// validate the password
			boolean matches = passwordEncoder.matches(password, customer.getPassword());

			if (matches) {

				// grant him/her the right roles and create an authentication object and return it
				String role = customer.getRoles();
				
				ArrayList<GrantedAuthority> authorities = new ArrayList<>();
				SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role);
				authorities.add(simpleGrantedAuthority);

				return new UsernamePasswordAuthenticationToken(username, password, authorities);

			} else {
				throw new BadCredentialsException("Invalid Username/password");
			}

		} else {
			throw new BadCredentialsException("User does not exits");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
