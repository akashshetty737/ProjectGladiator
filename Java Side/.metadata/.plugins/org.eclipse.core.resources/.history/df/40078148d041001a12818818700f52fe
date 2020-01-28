package com.lti.dao;

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
	public Login viewUser(String username) {
		String jpql = "Select l From Login l where l.username = :username";
		TypedQuery<Login> tQuery = entityManager.createQuery(jpql, Login.class);
		tQuery.setParameter("username", username);
		Login login = tQuery.getSingleResult();
		System.out.println(login);
		return login;
	}

}
