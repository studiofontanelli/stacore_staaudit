package it.csi.stacore.staaudit.integration.queue.sender.impl;

import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Repository;

import it.csi.stacore.staaudit.integration.dto.AuditMessage;
import it.csi.stacore.staaudit.integration.queue.sender.AuditMessageQueueSender;
import it.csi.stacore.staaudit.util.Constants;
import it.csi.stacore.staaudit.util.Tracer;






@Repository("auditMessageQueueSender")
public class AuditMessageQueueSenderImpl implements AuditMessageQueueSender {


	private static final String LOGGER_PREFIX = Constants.APPLICATION_CODE + ".business";
	protected final static Logger LOG = LoggerFactory.getLogger(LOGGER_PREFIX);

	@Autowired
	private JmsTemplate jmsTemplate;

	private final static String QUEUE = "auditMessageQueue";
	
	private final static String QUEUE_DLQ = "auditMessageDLQ";
	
	@Override
	public void sendMessage(AuditMessage message) {
		final String method = "sendMessage";
		try {
			Tracer.debug(LOG, getClass().getName(), method, "sending message " + message);

			jmsTemplate.convertAndSend(QUEUE, message);
			
			Tracer.info(LOG, getClass().getName(), method, "message sent correctly");
			HibernateException c;
		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
		}
		finally {

		}

	}

	@Override
	public void sendDLQ(AuditMessage message) {
		final String method = "sendDLQ";
		try {
			jmsTemplate.convertAndSend(QUEUE_DLQ, message);
			
			Tracer.info(LOG, getClass().getName(), method, "message sent correctly");

		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
		}
		finally {

		}
		
	}



}
