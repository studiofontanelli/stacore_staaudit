package it.csi.stacore.staaudit.api.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;

import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.logging.Logger;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

import it.csi.stacore.staaudit.api.dto.Operazione;
import it.csi.stacore.staaudit.util.Constants;
import it.csi.stacore.staaudit.util.Tracer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/spring-api-junit.xml")
public class TestOperationApi {
	
	
	protected final Logger LOG = Logger.getLogger(Constants.LOGGER_PREFIX);
		
	@Value("${api_endpoint_url}")
	private String apiEndpoint;
	
	@Value("${uri_save_operation}")
	private String uriSaveOperation;
	
	public String getUriSaveOperation() {
		return uriSaveOperation;
	}

	public void setUriSaveOperation(String uriSaveOperation) {
		this.uriSaveOperation = uriSaveOperation;
	}

	public String getApiEndpoint() {
		return apiEndpoint;
	}

	public void setApiEndpoint(String apiEndpoint) {
		this.apiEndpoint = apiEndpoint;
	}

	public File createTmpDir(){
		String dirPath= System.getProperty("user.home") +  "/junit/";
		File dir = new File(dirPath);
		if(!dir.exists())
			dir.mkdir();
		return dir;
	}
	
	@Before
	public void setUp() throws Exception {
		String method = "setUp";
		try {
			System.out.println("****** SETUP ********");
			Log4jConfigurer.initLogging("classpath:log4j.properties");
			Tracer.debug(LOG, getClass().getName(), method, "setting application context");
			
			//org.jboss.logging.Log4jLoggerProvider mm;
		}
		
		catch(FileNotFoundException e) { 
			throw new Exception(e.getLocalizedMessage()); 
		}
		finally {

		}

	}
	
	
	
	private String getUri() {
		return getApiEndpoint() + getUriSaveOperation();
	}
	@Test
	public final void testSaveOperationErroreValidazione() {
		final String method = "testSaveOperation";
		Tracer.debug(LOG, getClass().getName(), method, "BEGIN");
		try {
			
			System.out.println("ENDPOINT= " + getApiEndpoint());
			System.out.println("URI SAVE OPERATION= " + getUriSaveOperation());
			System.out.println("URI= " + getUri());
			
			Operazione operazione = new Operazione();
			
			ObjectMapper objectMapper = new ObjectMapper();
			String body = 	objectMapper.writeValueAsString(operazione);

			ClientRequest  request = new ClientRequest(getUri());
			request.accept("application/json");
			request.body("application/json", body);
			

			ClientResponse<String> response = request.post(String.class);

			Tracer.debug(LOG, getClass().getName(), method, "STATUS RESPONSE= "+response.getStatus());
			Tracer.debug(LOG, getClass().getName(), method, "entity= " + response.getEntity());
			
			
			/*

			if(response.getStatus() == HttpStatus.SC_CREATED) {
				ObjectMapper mapper = new ObjectMapper();
				ResponseSaveDocument responseSaveDocument = mapper.readValue(response.getEntity(), ResponseSaveDocument.class);
				Tracer.debug(LOG, getClass().getName(), method, "response \n " + XmlSerializer.objectToXml(responseSaveDocument));
			}
			*/
			
			
			assertEquals(response.getStatus(),  HttpStatus.UNPROCESSABLE_ENTITY.value());
			
			
			
			
		} catch (Exception e) {
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception: " + e);
			fail();
		}
		finally {
			Tracer.debug(LOG, getClass().getName(), method, "END");
		}
	}

	@Test
	public final void testSaveOperation() {
		final String method = "testSaveOperation";
		Tracer.debug(LOG, getClass().getName(), method, "BEGIN");
		try {
			
			System.out.println("ENDPOINT= " + getApiEndpoint());
			System.out.println("URI SAVE OPERATION= " + getUriSaveOperation());
			System.out.println("URI= " + getUri());
			
			Operazione operazione = new Operazione();
			
			
			operazione.setCodiceOperazione("LOGIN");
			operazione.setCodiceUnitaInstallazione("STAONJB");
			operazione.setUtente("CICILLO_CACACE");
			
			
			ObjectMapper objectMapper = new ObjectMapper();
			String body = 	objectMapper.writeValueAsString(operazione);
			
			
			Tracer.debug(LOG, getClass().getName(), method, "body\n  "+ body);

			ClientRequest  request = new ClientRequest(getUri());
			request.accept("application/json");
			request.body("application/json", body);
			

			ClientResponse<String> response = request.post(String.class);

			Tracer.debug(LOG, getClass().getName(), method, "STATUS RESPONSE= "+response.getStatus());
			Tracer.debug(LOG, getClass().getName(), method, "entity= " + response.getEntity());
			
		

			/*

			if(response.getStatus() == HttpStatus.SC_CREATED) {
				ObjectMapper mapper = new ObjectMapper();
				ResponseSaveDocument responseSaveDocument = mapper.readValue(response.getEntity(), ResponseSaveDocument.class);
				Tracer.debug(LOG, getClass().getName(), method, "response \n " + XmlSerializer.objectToXml(responseSaveDocument));
			}
			*/
			
			
			assertEquals(HttpStatus.CREATED.value(), response.getStatus());
			
			
			
			
		} catch (Exception e) {
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception: " + e);
			fail();
		}
		finally {
			Tracer.debug(LOG, getClass().getName(), method, "END");
		}
	}

	

}
