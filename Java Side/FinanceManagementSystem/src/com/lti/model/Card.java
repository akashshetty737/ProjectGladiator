package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Card {
	@Id
	@Column(name="card_number")
	private int cardNumber;
	@Column(name="valid_from")
	private String validFrom;
	@Column(name="valid_till")
	private String validTill;
	@Column(name="credit_used")
	private int creditUsed;
	@Column(name="card_status")
	private char cardStatus;
	
	public Card() {
	
	}
	
	
	
	public Card(int cardNumber, String validFrom, String validTill, int creditUsed, char cardStatus) {
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
	public int getCreditUsed() {
		return creditUsed;
	}
	public void setCreditUsed(int creditUsed) {
		this.creditUsed = creditUsed;
	}
	public char getCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(char cardStatus) {
		this.cardStatus = cardStatus;
	}
	@Override
	public String toString() {
		return "Card [cardNumber=" + cardNumber + ", validFrom=" + validFrom + ", validTill=" + validTill
				+ ", creditUsed=" + creditUsed + ", cardStatus=" + cardStatus + "]";
	}
	
	
	
	
	
}
