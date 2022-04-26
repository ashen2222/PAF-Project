package com.project.feedback1.feedback1.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.feedback1.feedback1.model.feedback1model;
	
public class feedback1service {
	
	Connection con;
	
	
	public feedback1service(){
		
		try {
			String url =String.format("jdbc:mysql://localhost:3306/feedback1");
			String uname ="root";
			String pwd = "";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
			
		} catch(Exception e) {
			System.out.println(e +"data insert unsucess");
		}
	
	
}
	public feedback1model insertfeedback(feedback1model feedback) {
		String insert = "insert into feedback11(code,name,contact,description) values(?,?,?,?) ";
	
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, feedback.getCode());
			ps.setString(2, feedback.getName());
			ps.setString(3, feedback.getContact());
			ps.setString(4, feedback.getDescription());
			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return feedback;
		
	}
public ArrayList<feedback1model> getfeedback() throws SQLException{
		
		ArrayList<feedback1model> data = new ArrayList<feedback1model>();
		
		String select = "select * from feedback1";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			feedback1model model = new feedback1model();
			
			model.setCode(rs.getString("code")); 
			model.setName(rs.getString("name"));
			model.setContact(rs.getString("contact")); 
			model.setDescription(rs.getString("description"));
			
			data.add(model);
			
		}
		
		return data;
		
	}
public ArrayList<feedback1model> getfeedbackById(int id) throws SQLException{
	
	ArrayList<feedback1model> data = new ArrayList<feedbackmodel>();
	String select = "select * from feedback11 where id =?";
	PreparedStatement ps = con.prepareStatement(select);
	ps.setInt(1,id);
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()) {
		feedback1model model = new feedback1model();
		
		model.setCode(rs.getString("code"));
		model.setName(rs.getString("name"));
		model.setContact(rs.getString("contact"));		
		model.setDescription(rs.getString("description"));
		data.add(model);		
	}		
	return data;	
}
public feedback1model updatetFeedback(feedback1model feedback) {
	String insert = "update feedback11 set code=? , name=? , contact=? , description=?where id =?";
	
	try {
		PreparedStatement ps = con.prepareStatement(insert);
		ps.setInt(1, feedback.getId());
		ps.setString(2, feedback.getCode());
		ps.setString(3, feedback.getName());
		ps.setString(4, feedback.getContact());
		ps.setString(5, feedback.getDescription());
		
		
		
		ps.executeUpdate();
	}catch(Exception e) {
		System.out.println(e +"data insert unsuccess.");
	}
	
	return feedback;
	
}
public int deletetFeedback(int id) {
	String insert = "delete from feedback11 where id =?";
	
	try {
		PreparedStatement ps = con.prepareStatement(insert);
		ps.setInt(1,id);
		
		ps.executeUpdate();
	}catch(Exception e) {
		System.out.println(e +"data insert unsuccess.");
	}
	
	return id;
	
}

			
		}

