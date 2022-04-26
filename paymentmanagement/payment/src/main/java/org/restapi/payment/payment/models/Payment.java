package org.restapi.payment.payment.models;

public class Payment {
		int paymentId;
		int cardNumber;
		Float amount;
		String date;
		double time;
		
		public Payment(int paymentId, int cardNumber, Float amount, String date, double time) {
			super();
			this.paymentId = paymentId;
			this.cardNumber = cardNumber;
			this.amount = amount;
			this.date = date;
			this.time = time;
		}
	
		public Payment() {
			// TODO Auto-generated constructor stub
		}

		public int getPaymentId() {
			return paymentId;
		}
	
		public void setPaymentId(int paymentId) {
			this.paymentId = paymentId;
		}
	
		public int getCardNumber() {
			return cardNumber;
		}
	
		public void setCardNumber(int cardNumber) {
			this.cardNumber = cardNumber;
		}
	
		public Float getAmount() {
			return amount;
		}
	
		public void setAmount(Float amount) {
			this.amount = amount;
		}
	
		public String getDate() {
			return date;
		}
	
		public void setDate(String date) {
			this.date = date;
		}
	
		public double getTime() {
			return time;
		}
	
		public void setTime(double time) {
			this.time = time;
		}
	
}


