package org.restapi.payment.payment.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.restapi.payment.payment.models.Card;
import org.restapi.payment.payment.models.Payment;

public class Cardservice {
	Connection con;
	
	public Cardservice(){
		
		try {
			String url =String.format("jdbc:mysql://localhost:3306/electrogrid/card");
			String uname ="root";
			String pwd = "shirohana2#";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
			
		} catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
	}

	
	public Card insertCard(Card card) {
		String insert = "insert into card(cardNumber,nameOnCard,type,expDate,securityCode) values(?,?,?,?,?) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, card.getCardNumber());
			ps.setString(2, card.getNameOnCard());
			ps.setString(3, card.getType());
			ps.setString(4, card.getExpDate());
			ps.setInt(5, card.getSecurityCode());
			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return card;
		
	}
	
	public ArrayList<Card> getCard() throws SQLException{
		
		ArrayList<Card> data = new ArrayList<Card>();
		
		String select = "select * from card";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Card model = new Card();
			
			model.setCardNumber(rs.getInt("cardNumber"));
			model.setNameOnCard(rs.getString("nameOnCard"));
			model.setType(rs.getString("type"));
			model.setExpDate(rs.getString("expDate"));
			model.setSecurityCode(rs.getInt("securityCode"));
			
			data.add(model);
			
		}
		
		return data;
		
	}
	
	
	public ArrayList<Card> getCardById(int userId) throws SQLException{
		
		ArrayList<Card> data = new ArrayList<Card>();
		String select = "select * from card where userId =?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setInt(1,userId);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Card model = new Card();
			
			model.setCardNumber(rs.getInt("cardNumber"));
			model.setNameOnCard(rs.getString("nameOnCard"));
			model.setType(rs.getString("type"));
			model.setExpDate(rs.getString("expDate"));
			model.setSecurityCode(rs.getInt("securityCode"));
			
			data.add(model);		
		}		
		return data;	
	}
	
	public Card updatetCard(Card card) {
		String insert = "update card set cardNumber=? , nameOnCard=? , type=? , expDate=?, securityCode=? where userId =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, card.getCardNumber());
			ps.setString(2, card.getNameOnCard());
			ps.setString(3, card.getType());
			ps.setString(4, card.getExpDate());
			ps.setInt(5, card.getSecurityCode());
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return card;
		
	}
	

	public int deletetCard(int userId) {
		String insert = "delete from card where userId =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1,userId);
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return userId;
		
	}


}
