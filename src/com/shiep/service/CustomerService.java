package com.shiep.service;

import java.util.List;

import com.shiep.pojo.Customer;
import com.shiep.pojo.Login;
import com.shiep.pojo.QueryVo;

public interface CustomerService {
	public List<Customer> selectAll(QueryVo queryVo);
	public  Customer selectCustomerById(long cust_id);
	public void updateCustomerById(Customer customer);
	public void deleteCustomerById(long cust_id);
	public void saveCustomer(Customer customer);
	public Login findLogin(Login vo);
		
}
