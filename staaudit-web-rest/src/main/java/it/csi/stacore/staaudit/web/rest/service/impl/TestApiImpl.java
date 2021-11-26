package it.csi.stacore.staaudit.web.rest.service.impl;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.stereotype.Component;

import it.csi.stacore.staaudit.web.rest.dto.GenericResponse;
import it.csi.stacore.staaudit.web.rest.service.TestApi;



@Component("testApi")
public class TestApiImpl implements TestApi {



	public Response testResources(SecurityContext securityContext, HttpHeaders httpHeaders ) {
		GenericResponse response = new GenericResponse();
		boolean testResource = true; //messageSenderHelper.testResource();
		if(testResource)
			response.setMessage("TUTTO OK");
		else
			response.setMessage("TEST RESOURCE KO");

		return Response.ok().entity(response).build();
	}

}
