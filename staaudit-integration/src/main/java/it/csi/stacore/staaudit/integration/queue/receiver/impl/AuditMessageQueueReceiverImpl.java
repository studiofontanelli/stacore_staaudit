package it.csi.stacore.staaudit.integration.queue.receiver.impl;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import it.csi.stacore.staaudit.integration.dto.AuditMessage;
import it.csi.stacore.staaudit.integration.exception.AuditMessageException;
import it.csi.stacore.staaudit.integration.queue.receiver.AuditMessageQueueReceiver;
import it.csi.stacore.staaudit.util.Constants;
import it.csi.stacore.staaudit.util.Tracer;




@Component
public class AuditMessageQueueReceiverImpl implements AuditMessageQueueReceiver {

	
	private static final String LOGGER_PREFIX = Constants.APPLICATION_CODE + ".business";
	protected final static Logger LOG = LoggerFactory.getLogger(LOGGER_PREFIX);
	
	@JmsListener(destination = "auditMessageQueue")
	public void receiveMessage(AuditMessage message)throws JMSException, AuditMessageException {
		final String method = "receiveMessage";
		try {
			Tracer.info(LOG, getClass().getName(), method, "received message " + message);
			
			long i =  System.currentTimeMillis();
			
			Tracer.debug(LOG, getClass().getName(), method, "i " + i);
			
			if(i % 2 == 0) {
				Tracer.info(LOG, getClass().getName(), method, "GETTO ECCEZIONE ");
				throw new Exception("BUTTO ECCEZIONE");
			}
			
		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw new AuditMessageException(message, "Si e' verificato un errore " + e);
		}
		finally {
			
		}
		
	}

	@Override
	@JmsListener(destination = "auditMessageDLQ")
	public void receiveDLQ(AuditMessage message) throws JMSException, AuditMessageException {
		final String method = "receiveDLQ";
		try {
			Tracer.info(LOG, getClass().getName(), method, "received message DLQ" + message);
			
			
			Tracer.info(LOG, getClass().getName(), method, "STORICIZZO IL DATO PER RIPROCESSARLO PIU' AVANTI");
		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw new AuditMessageException(message, "Si e' verificato un errore " + e);
		}
		finally {
			
		}
		
	}

	

}
