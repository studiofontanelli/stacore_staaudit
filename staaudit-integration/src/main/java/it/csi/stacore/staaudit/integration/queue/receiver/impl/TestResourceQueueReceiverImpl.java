package it.csi.stacore.staaudit.integration.queue.receiver.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import it.csi.stacore.staaudit.integration.queue.receiver.TestResourceQueueReceiver;
import it.csi.stacore.staaudit.util.Constants;
import it.csi.stacore.staaudit.util.Tracer;




@Component

public class TestResourceQueueReceiverImpl implements TestResourceQueueReceiver {

	
	private static final String LOGGER_PREFIX = Constants.APPLICATION_CODE + ".business";
	protected final static Logger LOG = LoggerFactory.getLogger(LOGGER_PREFIX);
	
	@JmsListener(destination = "testResourceQueue")
	public void receiveMessage(String message) {
		final String method = "receiveMessage";
		try {
			Tracer.info(LOG, getClass().getName(), method, "received message " + message);
			
			
		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
		}
		finally {
			
		}
		
	}

	

}
