package it.csi.stacore.staaudit.business.helper;

import it.csi.stacore.staaudit.business.dto.AuditMessageDto;
import it.csi.stacore.staaudit.business.exception.HelperException;

public interface AuditHelper {

	
	
	
	public void saveAuditMessage(AuditMessageDto auditMessage) throws HelperException;
	
	
	
	
}
