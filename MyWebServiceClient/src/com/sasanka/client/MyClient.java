package com.sasanka.client;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;

public class MyClient {

	private static String url ="https://support.apple.com/kb/index?page=agrsalesproperties&channel=APPLICATION_CONTENT&id=AP15&locale=en_US";
	
	public static void main(String[] args) {
		Client client = Client.create();
		client.getProperties().put(ClientConfig.PROPERTY_FOLLOW_REDIRECTS, true);
		client.setReadTimeout(3000);
		
		WebResource resource = client.resource(url);
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).accept("text/html").get(ClientResponse.class);
		
		System.out.println("Respone from service is : "+response.getEntity(String.class));
		
	}

}
