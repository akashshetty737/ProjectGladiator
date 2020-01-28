package com.lti.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("card")
@Scope(scopeName="prototype")
@Entity
@Table(name="card")
public class Card implements Serializable{
	@Id
	@Column(name="card_number")
	private int cardNumber;
	@Column(name="valid_from")
	private String validFrom;
	@Column(name="valid_till")
	private String validTill;
	@Column(name="credit_used")
	private double creditUsed;
	@Column(name="card_status")
	private char cardStatus;
	@Autowired
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="card_type_id")
	private CardType cardType;
	
	
	public Card() {
	
	}
	public Card(int cardNumber, String validFrom, String validTill, double creditUsed, char cardStatus) {
		this.cardNumber = cardNumber;
		this.validFrom = validFrom;
		this.validTill = validTill;
		this.creditUsed = creditUsed;
		this.cardStatus = cardStatus;
	}


	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}
	public String getValidTill() {
		return validTill;
	}
	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}
	public double getCreditUsed() {
		return creditUsed;
	}
	public void setCreditUsed(double creditUsed) {
		this.creditUsed = creditUsed;
	}
	public char getCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(char cardStatus) {
		this.cardStatus = cardStatus;
	}
	public CardType getCardType() {
		return cardType;
	}
	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}


	@Override
	public String toString() {
		return "Card [cardNumber=" + cardNumber + ", validFrom=" + validFrom + ", validTill=" + validTill
				+ ", creditUsed=" + creditUsed + ", cardStatus=" + cardStatus + "]";
	}

	
}
