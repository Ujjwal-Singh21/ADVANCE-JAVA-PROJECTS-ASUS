package com.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.dto.Customer;
import com.springsecurity.dto.MySecurityUser;
import com.springsecurity.signupdao.ICustomerDAO;

@Service
public class CustomerUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ICustomerDAO customerDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<Customer> customers = customerDao.findCustomerByCustomerName(username);
		
		System.out.println(customers);

		if (customers.isEmpty()) {
			throw new UsernameNotFoundException(username + " is not there in the database");
		}

		/*ArrayList<GrantedAuthority> rolesList = new ArrayList<>();
		SimpleGrantedAuthority role = new SimpleGrantedAuthority(customers.get(0).getRoles());
		rolesList.add(role);
		return new User(customers.get(0).getUsername(), customers.get(0).getPassword(), rolesList);*/
		
		/*UserDetails userDetailsObj = User.withUsername(customers.get(0).getUsername())
			.password(customers.get(0).getPassword())
			.roles(customers.get(0).getRoles())
			.build();
		return userDetailsObj; */
		
		return new MySecurityUser(customers.get(0).getUsername(), customers.get(0).getPassword(), customers.get(0).getRoles());
	}

}
