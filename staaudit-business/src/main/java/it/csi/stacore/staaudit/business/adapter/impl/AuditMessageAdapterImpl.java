package it.csi.stacore.staaudit.business.adapter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import it.csi.stacore.staaudit.business.adapter.AuditMessageAdapter;
import it.csi.stacore.staaudit.business.dto.AuditMessageDto;
import it.csi.stacore.staaudit.integration.dto.AuditMessage;
import it.csi.stacore.staaudit.util.adapter.CommonDtoAdapter;

@Component
public class AuditMessageAdapterImpl extends CommonDtoAdapter<AuditMessageDto, AuditMessage> implements  AuditMessageAdapter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	

}
