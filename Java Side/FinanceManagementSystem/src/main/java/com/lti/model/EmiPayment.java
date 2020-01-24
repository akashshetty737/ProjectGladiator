package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EmiPayment {
	
	@Id
	@Column(name="emi_payment_id")
	private int emiPaymentId;
	@Column(name="emi_payment_received")
	private double emiPaymentReceived;
	@Column(name="emi_payment_receive_date")
	private String emiPaymentReceiveDate;
	@Column(name="emi_payment_ontime")
	private char emiPaymentOntime;
	@ManyToOne
	private Emi emi;
	
	
	public EmiPayment() {
		
	}
	public EmiPayment(int emiPaymentId, double emiPaymentReceived, String emiPaymentReceiveDate,
			char emiPaymentOntime) {
		super();
		this.emiPaymentId = emiPaymentId;
		this.emiPaymentReceived = emiPaymentReceived;
		this.emiPaymentReceiveDate = emiPaymentReceiveDate;
		this.emiPaymentOntime = emiPaymentOntime;
	}


	public int getEmiPaymentId() {
		return emiPaymentId;
	}
	public void setEmiPaymentId(int emiPaymentId) {
		this.emiPaymentId = emiPaymentId;
	}
	public double getEmiPaymentReceived() {
		return emiPaymentReceived;
	}
	public void setEmiPaymentReceived(double emiPaymentReceived) {
		this.emiPaymentReceived = emiPaymentReceived;
	}
	public String getEmiPaymentReceiveDate() {
		return emiPaymentReceiveDate;
	}
	public void setEmiPaymentReceiveDate(String emiPaymentReceiveDate) {
		this.emiPaymentReceiveDate = emiPaymentReceiveDate;
	}
	public char getEmiPaymentOntime() {
		return emiPaymentOntime;
	}
	public void setEmiPaymentOntime(char emiPaymentOntime) {
		this.emiPaymentOntime = emiPaymentOntime;
	}
	public Emi getEmi() {
		return emi;
	}
	public void setEmi(Emi emi) {
		this.emi = emi;
	}


	@Override
	public String toString() {
		return "EmiPayment [emiPaymentId=" + emiPaymentId + ", emiPaymentReceived=" + emiPaymentReceived
				+ ", emiPaymentReceiveDate=" + emiPaymentReceiveDate + ", emiPaymentOntime=" + emiPaymentOntime + "]";
	}
	
	
}