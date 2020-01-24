package com.lti.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Emi {
	@Id
	@Column(name="emi_id")
	private int emiId;
	@Column(name="emi_start_date")
	private String emiStartDate;
	@Column(name="emi_end_date")
	private String emiEndDate;
	@Column(name="total_amount_paid")
	private double totalAmountPaid;
	@Column(name="emi_balance_remaining")
	private double emiBalanceRemaining;
	@Column(name="amount_each_month")
	private int amountEachMonth;
	@Column(name="emi_active_status")
	private char emiActiveStatus;
	
	
	@OneToMany
	private List<Customer> customers;
	@OneToOne
	private Product product;
	
	
	public Emi() {
	
	}
	public Emi(int emiId, String emiStartDate, String emiEndDate, double totalAmountPaid, double emiBalanceRemaining,
			int amountEachMonth, char emiActiveStatus) {
		this.emiId = emiId;
		this.emiStartDate = emiStartDate;
		this.emiEndDate = emiEndDate;
		this.totalAmountPaid = totalAmountPaid;
		this.emiBalanceRemaining = emiBalanceRemaining;
		this.amountEachMonth = amountEachMonth;
		this.emiActiveStatus = emiActiveStatus;
	}


	public int getEmiId() {
		return emiId;
	}
	public void setEmiId(int emiId) {
		this.emiId = emiId;
	}
	public String getEmiStartDate() {
		return emiStartDate;
	}
	public void setEmiStartDate(String emiStartDate) {
		this.emiStartDate = emiStartDate;
	}
	public String getEmiEndDate() {
		return emiEndDate;
	}
	public void setEmiEndDate(String emiEndDate) {
		this.emiEndDate = emiEndDate;
	}
	public double getTotalAmountPaid() {
		return totalAmountPaid;
	}
	public void setTotalAmountPaid(double totalAmountPaid) {
		this.totalAmountPaid = totalAmountPaid;
	}
	public double getEmiBalanceRemaining() {
		return emiBalanceRemaining;
	}
	public void setEmiBalanceRemaining(double emiBalanceRemaining) {
		this.emiBalanceRemaining = emiBalanceRemaining;
	}
	public int getAmountEachMonth() {
		return amountEachMonth;
	}
	public void setAmountEachMonth(int amountEachMonth) {
		this.amountEachMonth = amountEachMonth;
	}
	public char getEmiActiveStatus() {
		return emiActiveStatus;
	}
	public void setEmiActiveStatus(char emiActiveStatus) {
		this.emiActiveStatus = emiActiveStatus;
	}
	
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}


	@Override
	public String toString() {
		return "EMI [emiId=" + emiId + ", emiStartDate=" + emiStartDate + ", emiEndDate=" + emiEndDate
				+ ", totalAmountPaid=" + totalAmountPaid + ", emiBalanceRemaining=" + emiBalanceRemaining
				+ ", amountEachMonth=" + amountEachMonth + ", emiActiveStatus=" + emiActiveStatus + "]";
	}
	
	
}
