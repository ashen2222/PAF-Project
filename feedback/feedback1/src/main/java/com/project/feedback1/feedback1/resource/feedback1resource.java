package com.project.feedback1.feedback1.resource;


import java.sql.SQLException;
import java.util.ArrayList;

import com.project.feedback1.feedback1.model.feedback1model;
import com.project.feedback1.feedback1.service.feedback1service;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/feedback1")
public class feedback1resource {

	feedback1service service = new feedback1service();
	
	@Path("/insertion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public feedback1model addFeedback(feedback1model feedback) {
			return service.insertfeedback(feedback);
	}
	
	@Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<feedback1model>  getFeedback() throws SQLException {
		 return service.getfeedback();
		
	}
	
	@Path("/retrieveById/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<feedback1model>  getFeedback(@PathParam("id") int id) throws SQLException {
		return service.getfeedbackById(id);
		
	}
	@Path("/updateFeedback")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public feedback1model updateFeedback(feedback1model feedback) {
		 return service.updatetFeedback(feedback);
		
	}

	@Path("/deleteFeedbackById/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteFeedback(@PathParam("id") int id) {
		return service.deletetFeedback(id);
		
	}
}
