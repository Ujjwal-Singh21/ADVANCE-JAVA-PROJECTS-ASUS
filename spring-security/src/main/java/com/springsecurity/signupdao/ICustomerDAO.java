package com.springsecurity.signupdao;

import java.util.List;

import com.springsecurity.dto.Customer;

public interface ICustomerDAO {

	List<Customer> findCustomerByCustomerName(String name);

}
