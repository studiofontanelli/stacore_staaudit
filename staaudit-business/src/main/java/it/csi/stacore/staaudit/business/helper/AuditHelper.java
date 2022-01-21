package it.csi.stacore.staaudit.business.helper;

import it.csi.stacore.staaudit.business.dto.AuditMessage;
import it.csi.stacore.staaudit.business.exception.HelperException;

public interface AuditHelper {

	
	
	public boolean saveAuditMessage(AuditMessage auditMessage) throws HelperException;
}
