package org.restapi.payment.payment.resoorce;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.restapi.payment.payment.models.Payment;
import org.restapi.payment.payment.service.paymentservice;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/payments")

public class paymentresource {
	paymentservice service = new paymentservice();

	@Path("/insertion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Payment addPayment(Payment payment) {
		 return service.insertPayment(payment);
		
	}
	
	@Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Payment>  getPayment() throws SQLException {
		 return service.getPayment();
		
	}
	
	@Path("/deletePaymentById/{paymentId}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deletePayment(@PathParam("paymentId") int paymentId) {
		return service.deletetPayment(paymentId);
		
	}
	
	
	
}
