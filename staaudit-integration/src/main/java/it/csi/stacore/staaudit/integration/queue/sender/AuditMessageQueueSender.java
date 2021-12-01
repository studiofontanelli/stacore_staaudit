package it.csi.stacore.staaudit.integration.queue.sender;

import it.csi.stacore.staaudit.integration.dto.AuditMessage;

public interface AuditMessageQueueSender {
	
	
	
	public void sendMessage(AuditMessage message);
	
	
	public void sendDLQ(AuditMessage message);

}
