package com.shiep.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shiep.dao.CustomerDao;
import com.shiep.pojo.Customer;
import com.shiep.pojo.Login;
import com.shiep.pojo.QueryVo;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Resource(name="customerDao")
	private CustomerDao customerDao;

		@Override
		public Customer selectCustomerById(long cust_id) {
			return customerDao.selectCustomerById(cust_id);
		}

		@Override
		public void updateCustomerById(Customer customer) {
			customerDao.updateCustomerById(customer);
		}

		@Override
		public void deleteCustomerById(long cust_id) {
			customerDao.deleteCustomerById(cust_id);
			
		}
		@Override
		public void saveCustomer(Customer customer) {
			customerDao.saveCustomer(customer);
			
		}
		@Override
		public List<Customer> selectAll(QueryVo queryVo) {
			
			return customerDao.customerList(queryVo);
		}

		@Override
		public Login findLogin(Login vo) {
			return customerDao.find(vo);
			
			
		}
}
	
