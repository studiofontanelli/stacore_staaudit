package it.csi.stacore.staaudit.api.service.impl;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.stacore.staaudit.api.adapter.OperazioneAdapter;
import it.csi.stacore.staaudit.api.dto.GenericResponse;
import it.csi.stacore.staaudit.api.dto.Operazione;
import it.csi.stacore.staaudit.api.service.OperationApi;
import it.csi.stacore.staaudit.business.helper.AuditHelper;
import it.csi.stacore.staaudit.business.helper.TestResourceHelper;
import it.csi.stacore.staaudit.util.Constants;
import it.csi.stacore.staaudit.util.Tracer;
import it.csi.stacore.staaudit.util.XmlSerializer;



@Component("operationApi")
public class OperationApiImpl implements OperationApi {
	
	private static final String LOGGER_PREFIX = Constants.APPLICATION_CODE + ".api";
	protected final static Logger LOG = LoggerFactory.getLogger(LOGGER_PREFIX);

	@Autowired
	private TestResourceHelper testResourceHelper;

	@Autowired
	private AuditHelper auditHelper;

	@Autowired
	private OperazioneAdapter operazioneMessageAuditDtoAdapter;

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
	public Response saveOperation(Operazione request, SecurityContext securityContext, HttpHeaders httpHeaders) {
		final String method = "saveOperation";
		Tracer.debug(LOG, getClass().getName(), method, "called");
		Tracer.debug(LOG, getClass().getName(), method, "request\n " + XmlSerializer.objectToXml(request));
		
		
		auditHelper.saveAuditMessage(operazioneMessageAuditDtoAdapter.convertTo(request));
		
		return Response.status(Response.Status.CREATED).entity("OK").build();
	}



}
