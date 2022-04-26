package org.restapi.payment.payment.resoorce;

import java.sql.SQLException;
import java.util.ArrayList;

import org.restapi.payment.payment.models.Card;
import org.restapi.payment.payment.service.Cardservice;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/card")

public class cardresource {
	Cardservice service = new Cardservice();
	
	@Path("/insertion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Card addCard(Card card) {
		 return service.insertCard(card);
		
	}
	
	@Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Card>  getCard() throws SQLException {
		 return service.getCard();
		
	}
	
	@Path("/retrieveById/{userId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Card>  getCard(@PathParam("userId") int userId) throws SQLException {
		return service.getCardById(userId);
		
	}
	
	@Path("/updateCard")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Card updateCard(Card card) {
		 return service.updatetCard(card);
		
	}
	
	@Path("/deleteUserById/{userId}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteCard(@PathParam("userId") int userId) {
		return service.deletetCard(userId);
		
	}

	

}
