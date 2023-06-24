package com.springsecurity.signupdao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springsecurity.dto.Customer;

@Repository
public class CustomerDAOImpl implements ICustomerDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Customer> findCustomerByCustomerName(String name) {
		String selectSql = "SELECT * FROM CUSTOMERS WHERE USERNAME = ?";
		Object[] args = { name };
//		Customer customer = jdbcTemplate.queryForObject(selectSql, args, new BeanPropertyRowMapper<Customer>(Customer.class));
		
		List<Customer> customers = jdbcTemplate.query(selectSql, args, new BeanPropertyRowMapper<Customer>(Customer.class));
		
		return customers;
	}

}
