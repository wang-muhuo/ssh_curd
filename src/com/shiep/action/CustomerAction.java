package com.shiep.action;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shiep.pojo.Customer;
import com.shiep.pojo.Login;
import com.shiep.pojo.QueryVo;
import com.shiep.service.CustomerService;

@Controller("customerAction")
@Scope("prototype")
public class CustomerAction {
	/**
	 * 
	 */
	private Customer customer;
	private long cust_id;
	private Login vo;
	private QueryVo queryVo;



	@Resource(name="customerService")
	private CustomerService customerService;
	public String list(){
	
     
		List<Customer> list = customerService.selectAll(this.getQueryVo());
		ActionContext.getContext().put("listAll",list);
		return "list";
		
	}
	
	public String edit(){ 
	
		Customer customer = customerService.selectCustomerById(this.getCust_id());
		ActionContext.getContext().put("customer",customer);
//		this.setCustomer(customer);
		return "edit";
				
	}
	public String update_(){
		customerService.updateCustomerById(customer);
		return "update";
	
	}
	
	public String delete(){
		customerService.deleteCustomerById(this.getCust_id());
		return "delete";
		
	}
	
	public String save(){
		customerService.saveCustomer(customer);
		return "save";
		
	}
	public String login(){
		Login login = customerService.findLogin(this.getVo());
	
		if (login!=null) {
			return "login";
			
		}
		return "error";
		
	}


	
	
	
	
	
	
	
	
	public QueryVo getQueryVo() {
		return queryVo;
	}
	
	public void setQueryVo(QueryVo queryVo) {
		this.queryVo = queryVo;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Login getVo() {
		return vo;
	}
	
	public void setVo(Login vo) {
		this.vo = vo;
	}

	public long getCust_id() {
		return cust_id;
	}

	public void setCust_id(long cust_id) {
		this.cust_id = cust_id;
	}
	

	}
