package com;

import model.Payment;
//for REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//for JSON
import com.google.gson.*;
//for xml
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Payment")
public class PaymentService {
	Payment payObj = new Payment();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)

	public String readPay() {

		return payObj.readPay();
	}
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	//payID,payType,payAmount,payDate,payEmail,PayDesc
	public String insertPayments(@FormParam("payType") String payType, @FormParam("payAmount") String payAmount,
			@FormParam("payDate") String payDate, @FormParam("payEmail") String payEmail, @FormParam("payDesc") String payDesc) {
		String output = payObj.insertPay(payType, payAmount, payDate, payEmail, payDesc);
		return output;

	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePayments(String payData)
	{  
		//Convert the input string to an XML document  
		Document doc = Jsoup.parse(payData, "", Parser.xmlParser());     
		//Read the value from the element <payID>  
		String payID = doc.select("payID").text(); 
		 
		 String output = payObj.deletePay(payID); 
		 
		 return output; 
		 
	} 
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePayments(String payData) {
		// Convert the input string to a JSON object
		JsonObject paymentObject = new JsonParser().parse(payData).getAsJsonObject();

		// Read the values from the JSON object
		//payID,payType,payAmount,payDate,payEmail,PayDesc
		String payID = paymentObject.get("payID").getAsString();
		String payType = paymentObject.get("payType").getAsString();
		String payAmount = paymentObject.get("payAmount").getAsString();
		String payDate = paymentObject.get("payDate").getAsString();
		String payEmail = paymentObject.get("payEmail").getAsString();
		String PayDesc = paymentObject.get("payDesc").getAsString();

		String output = payObj.updatePay(payID, payType, payAmount, payDate, payEmail,PayDesc);

		return output;
	}
	
}

