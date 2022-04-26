package org.restapi.payment.payment.models;

public class Card {
	int userId;
	int cardNumber;
	String nameOnCard;
	String type;
	String expDate;
	int securityCode;
	int paymentId;

	public Card(int userId, int cardNumber, String nameOnCard, String type, String expDate, int securityCode,
		int paymentId) {
		super();
		this.userId = userId;
		this.cardNumber = cardNumber;
		this.nameOnCard = nameOnCard;
		this.type = type;
		this.expDate = expDate;
		this.securityCode = securityCode;
		this.paymentId = paymentId;
	}

	public Card() {
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getNameOnCard() {
		return nameOnCard;
	}
	
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getExpDate() {
		return expDate;
	}
	
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	
	public int getSecurityCode() {
		return securityCode;
	}
	
	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}
	
	public int getPaymentId() {
		return paymentId;
	}
	
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	
	


}
