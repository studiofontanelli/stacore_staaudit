package it.csi.stacore.staaudit.integration.exception;

import it.csi.stacore.staaudit.integration.dto.AuditMessage;

public class AuditMessageException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6117430820090926803L;

	private AuditMessage auditMessage;

	public AuditMessageException(AuditMessage auditMessage, String message) {
		super(message);
		this.auditMessage = auditMessage;
		
	}

	public AuditMessage getAuditMessage() {
		return auditMessage;
	}

}
