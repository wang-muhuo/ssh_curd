package com.shiep.dao;

import java.util.List;

import com.shiep.pojo.Customer;
import com.shiep.pojo.Login;
import com.shiep.pojo.QueryVo;

public interface CustomerDao {

	public List<Customer> customerList(QueryVo queryVo);
	public  Customer selectCustomerById(long id);
	public void updateCustomerById(Customer customer);
	public void deleteCustomerById(long id);
	public void saveCustomer(Customer customer);
	public Login find(Login vo);
	
}
