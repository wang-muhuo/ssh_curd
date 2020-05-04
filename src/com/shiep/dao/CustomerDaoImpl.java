package com.shiep.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.shiep.pojo.Customer;
import com.shiep.pojo.Login;
import com.shiep.pojo.QueryVo;

@SuppressWarnings("all")
@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	    public SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	    void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }

	    private Session getCurrentSession() {
	        return sessionFactory.getCurrentSession();
	    }
	    
	@Override
	public List<Customer> customerList(QueryVo queryVo) {
		Session session=null;
		List<Customer> list=null;
		try {	
		StringBuffer str=new StringBuffer(" from Customer where 1=1 ");
		if (queryVo!=null) {
			if (queryVo.getCustName().trim()!="" && queryVo.getCustName().trim()!=null) {
				str.append(" and cust_name like :cust_name ");
				}
			if (queryVo.getCustSource().trim()!="" && queryVo.getCustSource().trim()!=null) {
				str.append(" and cust_source like :cust_source ");
				}
			if (queryVo.getCustIndustry().trim()!="" && queryVo.getCustIndustry().trim()!=null) {
				str.append(" and cust_industry like :cust_industry ");
			}
			if (queryVo.getCustLevel().trim()!="" && queryVo.getCustLevel().trim()!=null) {
				str.append(" and cust_level like :cust_level");
				}
		}
			
		session = this.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query=session.createQuery(str.toString()); 
		
		if (queryVo!=null) {
			if (queryVo.getCustName().trim()!="" && queryVo.getCustName().trim()!=null ) {
				query.setParameter("cust_name","%"+queryVo.getCustName()+"%");
				}
			if (queryVo.getCustSource().trim()!="" && queryVo.getCustSource().trim()!=null) {
				query.setParameter("cust_source", "%"+queryVo.getCustSource()+"%");
				}
			if (queryVo.getCustIndustry().trim()!="" && queryVo.getCustIndustry().trim()!=null) {
				query.setParameter("cust_industry", "%"+queryVo.getCustIndustry()+"%");
			}
			if (queryVo.getCustLevel().trim()!="" && queryVo.getCustLevel().trim()!=null) {
				query.setParameter("cust_level", "%"+queryVo.getCustLevel()+"%");
				}
			}
		
		list=query.list(); 
//		tx.commit();	
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
//			session.close();
		}
		return list;
	}

	@Override
	public Customer selectCustomerById(long cust_id) {
		Session session=null;
		Customer cus=null;
		try {
		String sql="from Customer c where c.cust_id = :cust_id";
		session = this.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(sql).setParameter("cust_id", cust_id);
	    cus=(Customer) query.uniqueResult();
//		tx.commit();	
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
//			session.close();
		}
		return  cus;
	}

	@Override
	public void updateCustomerById(Customer customer) {
		Session session=null;
		try {
			session=this.getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.update(customer);
//			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally{
//			session.close();
		}
	}

	@Override
	public void deleteCustomerById(long cust_id) {
		Session session=null;
	try {
		session=getCurrentSession();
		Transaction tx = session.beginTransaction();
		Customer cus = (Customer)session.get(Customer.class, cust_id);
		session.delete(cus);
//		tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally{
//			session.close();
		}
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session=null;
	try {
		session = this.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(customer);
	//	tx.commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}finally {
//			session.close();
		}
		
	}
	@Override
	public Login find(Login vo) {
		
		Session session=null;
		Login login=null;
		try {
		String sql="from Login where username = :username and password = :password";
		session = this.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(sql);
		query.setParameter("username", vo.getUsername());
		query.setParameter("password", vo.getPassword());
	    login=(Login) query.uniqueResult();
//		tx.commit();	
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
//			session.close();
		}
		return  login;
	}
     
	
	
}
