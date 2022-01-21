package it.csi.stacore.staaudit.api.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.spi.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import it.csi.stacore.staaudit.api.dto.ErrorDto;
import it.csi.stacore.staaudit.util.Constants;
import it.csi.stacore.staaudit.util.Tracer;
import it.csi.stacore.staaudit.util.XmlSerializer;



@Provider
public class ExceptionHandler implements ExceptionMapper<RuntimeException> {

	private Logger LOG = LoggerFactory.getLogger(Constants.LOGGER_PREFIX);


	@Override
	public Response toResponse(RuntimeException exception) {
		String method = "toResponse";

		Tracer.info(LOG, getClass().getName(), method, "Exception " + exception);

		ErrorDto e = new ErrorDto();
		e.setDescription(exception.getMessage());

		HttpStatus httpStatus = null;

		if(exception instanceof UnauthorizedException) {
			httpStatus = HttpStatus.UNAUTHORIZED;
		}


		else {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}


		e.setStatus(httpStatus.value());
		e.setCode(httpStatus.getReasonPhrase());


		Tracer.info(LOG, getClass().getName(), method, "ExceptionDto\n " + XmlSerializer.objectToXml(e));

		return Response.status(e.getStatus()).entity(e).build();
	}
}