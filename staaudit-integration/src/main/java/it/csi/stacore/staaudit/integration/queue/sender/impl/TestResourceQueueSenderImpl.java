package it.csi.stacore.staaudit.integration.queue.sender.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Repository;

import it.csi.stacore.staaudit.integration.queue.sender.TestResourceQueueSender;
import it.csi.stacore.staaudit.util.Constants;
import it.csi.stacore.staaudit.util.Tracer;






@Repository("testResourceQueueSender")
public class TestResourceQueueSenderImpl implements TestResourceQueueSender {


	private static final String LOGGER_PREFIX = Constants.APPLICATION_CODE + ".business";
	protected final static Logger LOG = LoggerFactory.getLogger(LOGGER_PREFIX);

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	@Qualifier("testResourceQueue")
	private Queue queue;


	@Override
	public void sendMessage(String message) {
		final String method = "sendMessage";
		try {
			Tracer.debug(LOG, getClass().getName(), method, "sending message " + message);

			jmsTemplate.convertAndSend("testResourceQueue", message);
			
			/*
			jmsTemplate.send(this.queue, new MessageCreator() {
				public Message createMessage(Session session) throws JMSException {
					Tracer.info(LOG, getClass().getName(), method, ".... sending message " + message);
					return session.createTextMessage(message);
				}
			});
			*/
			Tracer.info(LOG, getClass().getName(), method, "message sent correctly");

		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
		}
		finally {

		}

	}



}
