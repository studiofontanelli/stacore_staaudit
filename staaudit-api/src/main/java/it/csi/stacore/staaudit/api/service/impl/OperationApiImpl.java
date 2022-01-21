package it.csi.stacore.staaudit.api.service.impl;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.stacore.staaudit.api.dto.GenericResponse;
import it.csi.stacore.staaudit.api.dto.RequestSalvaOperazione;
import it.csi.stacore.staaudit.api.service.OperationApi;
import it.csi.stacore.staaudit.business.helper.TestResourceHelper;



@Component("operationApi")
public class OperationApiImpl implements OperationApi {

	@Autowired
	private TestResourceHelper testResourceHelper;

	public Response testResources(SecurityContext securityContext, HttpHeaders httpHeaders ) {
		GenericResponse response = new GenericResponse();
		boolean testResource = testResourceHelper.testResources();
		if(testResource)
			response.setMessage("TUTTO OK");
		else
			response.setMessage("TEST RESOURCE KO");

		return Response.ok().entity(response).build();
	}

	@Override
	public Response saveOperation(RequestSalvaOperazione request, SecurityContext securityContext, HttpHeaders httpHeaders) {
	
		
		return Response.status(Response.Status.CREATED).entity("OK").build();
	}

	

}
