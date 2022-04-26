package org.restapi.payment.payment.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.restapi.payment.payment.models.*;

public class paymentservice {
	Connection con;
	
		
		public paymentservice(){
			
			try {
				String url =String.format("jdbc:mysql://localhost:3306/electrogrid/payment");
				String uname ="root";
				String pwd = "shirohana2#";
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url,uname,pwd);
				
			} catch(Exception e) {
				System.out.println(e +"data insert unsuccess.");
			}
		}
	
		
		public Payment insertPayment(Payment payment) {
			String insert = "insert into payment(cardNumber,amount,date,time) values(?,?,?,?) ";
			
			try {
				PreparedStatement ps = con.prepareStatement(insert);
				ps.setInt(1, payment.getCardNumber());
				ps.setFloat(2, payment.getAmount());
				ps.setString(3, payment.getDate());
				ps.setDouble(4, payment.getTime());
				
				ps.execute();
			}catch(Exception e) {
				System.out.println(e +"data insert unsuccess.");
			}
			
			return payment;
			
		}
		
		public ArrayList<Payment> getPayment() throws SQLException{
			
			ArrayList<Payment> data = new ArrayList<Payment>();
			
			String select = "select * from payment";
			PreparedStatement ps = con.prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Payment model = new Payment();
				
				model.setCardNumber(rs.getInt("cardNumber")); // column name
				model.setAmount(rs.getFloat("amount"));
				model.setDate(rs.getString("date"));
				model.setTime(rs.getDouble("time"));
				
				data.add(model);
				
			}
			
			return data;
			
		}	
	
		public int deletetPayment(int paymentId) {
			String insert = "delete from payment where paymentId =?";
			
			try {
				PreparedStatement ps = con.prepareStatement(insert);
				ps.setInt(1,paymentId);
				
				ps.executeUpdate();
			}catch(Exception e) {
				System.out.println(e +"data insert unsuccess.");
			}
			
			return paymentId;
			
		}
		
		
}
