package it.csi.stacore.staaudit.integration.queue.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ErrorHandler;

import it.csi.stacore.staaudit.integration.exception.AuditMessageException;
import it.csi.stacore.staaudit.integration.queue.sender.AuditMessageQueueSender;
import it.csi.stacore.staaudit.util.Constants;
import it.csi.stacore.staaudit.util.Tracer;

public class JmsErrorHandler implements ErrorHandler{
	
	private static final String LOGGER_PREFIX = Constants.APPLICATION_CODE + ".handler";
	protected final static Logger LOG = LoggerFactory.getLogger(LOGGER_PREFIX);

	
	@Autowired
	private AuditMessageQueueSender auditMessageQueueSender;
	
	@Override
	public void handleError(Throwable t) {
		String method = "handleError";
		Tracer.warn(LOG, getClass().getName(), method, "handling " + t);
		Tracer.warn(LOG, getClass().getName(), method, "Error message " + t.getMessage());
		Tracer.warn(LOG, getClass().getName(), method, "CAUSE: " + t.getCause());
		
		
		if(t.getCause() instanceof AuditMessageException) {
			Tracer.info(LOG, getClass().getName(), method, "sending DQL");
			
			AuditMessageException ex = (AuditMessageException)t.getCause();
			
			auditMessageQueueSender.sendDLQ(ex.getAuditMessage());
			
		}
		
		
		
	}

}
