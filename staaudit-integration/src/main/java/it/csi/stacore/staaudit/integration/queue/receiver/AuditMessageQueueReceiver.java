package it.csi.stacore.staaudit.integration.queue.receiver;

import javax.jms.JMSException;

import it.csi.stacore.staaudit.integration.dto.AuditMessage;
import it.csi.stacore.staaudit.integration.exception.AuditMessageException;

public interface AuditMessageQueueReceiver {
	
	
	
	public void receiveMessage(AuditMessage message) throws JMSException, AuditMessageException;
	
	public void receiveDLQ(AuditMessage message) throws JMSException, AuditMessageException;

}
