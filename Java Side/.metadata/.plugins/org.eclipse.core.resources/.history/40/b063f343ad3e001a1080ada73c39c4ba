package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Customer;
import com.lti.model.Login;

@Repository("dao")
public class FinanaceManangementDaoImpl implements FinanaceManagementDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	@Transactional
	public int createCustomer(Login login) {
		entityManager.persist(login);
		return 1;
	}

	@Override
	public List<Customer> viewAllCustomer() {
		String jpql = "From Customer c";
		TypedQuery<Customer> tQuery = entityManager.createQuery(jpql, Customer.class);
		
		return tQuery.getResultList();
	}

}
