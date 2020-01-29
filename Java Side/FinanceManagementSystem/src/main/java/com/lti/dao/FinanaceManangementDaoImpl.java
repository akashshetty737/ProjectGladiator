package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Customer;
import com.lti.model.Emi;
import com.lti.model.EmiPayment;
import com.lti.model.Login;
import com.lti.model.Product;

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


	@Override
	public Product viewProduct(String productName) {
		String jpql = "From Product p where productName = :productName";
		TypedQuery<Product> tQuery = entityManager.createQuery(jpql, Product.class);
		tQuery.setParameter("productName", productName);
		return tQuery.getSingleResult();
	}

	@Override
	@Transactional
	public int insertNewEmi(Emi emi) {
		entityManager.persist(emi);
		Customer updateCustomer = entityManager.find(Customer.class, emi.getCustomer().getCustomerId());
		
		double creditUsed = updateCustomer.getCustomerCard().getCreditUsed() - (emi.getProduct().getProductPrice() + emi.getProduct().getProductProcessingFees());
		updateCustomer.getCustomerCard().setCreditUsed(creditUsed);
		
		entityManager.merge(updateCustomer);
		
		Product updateProduct = entityManager.find(Product.class, emi.getProduct().getProductId());
		int stockUpdate = updateProduct.getProductUnitsInStock() - 1;
		updateProduct.setProductUnitsInStock(stockUpdate);
		
		entityManager.merge(updateProduct);
		
		
		return 1;
	}

	@Override
	public List<Product> viewAllProduct() {
		String jpql = "Select p From Product p";
		
	Query query = entityManager.createQuery(jpql,Product.class);
	List<Product> list = query.getResultList();
		return list;
	}

	@Override
	public List<Customer> viewAllCustomer() {
		String jpql="From Customer c";
		Query query=entityManager.createQuery(jpql,Customer.class);
		List<Customer> list=query.getResultList();
		return list;
	}

	@Override
	public List<Emi> viewAllEmiForCustomer(int customerId) {
	
		String jpql = "SELECT e From Emi e JOIN e.customer c where c.customerId = :customerId ";
		Query tQuery = entityManager.createQuery(jpql);
		tQuery.setParameter("customerId", customerId);
		return tQuery.getResultList();
	}



	@Override
	@Transactional
	public int insertPayment(EmiPayment emiPayment) {
		entityManager.persist(emiPayment);
		
		Emi updateEmi = entityManager.find(Emi.class, emiPayment.getEmi().getEmiId());
		
		double totalAmountPaid = (updateEmi.getTotalAmountPaid()) + (emiPayment.getEmiPaymentReceived());

		updateEmi.setTotalAmountPaid(totalAmountPaid);
		
		entityManager.merge(updateEmi);
		
		return 1;
		
	}

	
	



}
