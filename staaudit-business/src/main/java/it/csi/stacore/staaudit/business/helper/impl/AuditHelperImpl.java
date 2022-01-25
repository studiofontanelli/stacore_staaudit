package it.csi.stacore.staaudit.business.helper.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.stacore.staaudit.business.adapter.AuditMessageAdapter;
import it.csi.stacore.staaudit.business.dto.AuditMessageDto;
import it.csi.stacore.staaudit.business.exception.HelperException;
import it.csi.stacore.staaudit.business.helper.AuditHelper;
import it.csi.stacore.staaudit.integration.entity.StaDComponente;
import it.csi.stacore.staaudit.integration.entity.StaDProdotto;
import it.csi.stacore.staaudit.integration.queue.sender.AuditMessageQueueSender;
import it.csi.stacore.staaudit.integration.repository.StaDComponenteRepository;
import it.csi.stacore.staaudit.integration.repository.StaDProdottoRepository;
import it.csi.stacore.staaudit.util.Tracer;

@Service("auditHelper")
public class AuditHelperImpl extends CommonHelperImpl implements AuditHelper {
	
	@Autowired
	private StaDProdottoRepository staDProdottoRepository;
	
	@Autowired
	private StaDComponenteRepository staDComponenteRepository;
	
	@Autowired
	private AuditMessageQueueSender auditMessageQueueSender;
	
	@Autowired
	private AuditMessageAdapter auditMessageAdapter;
	
	@PostConstruct
	public void init() {
		final String method = "init";
		try {
			Tracer.debug(LOG, getClass().getName(), method, "called");
			
			
			List <StaDProdotto> result = IterableUtils .toList(staDProdottoRepository.findAll());
			
			Tracer.info(LOG, getClass().getName(), method, "found # " + result.size() + " prodotti");
			
			List <StaDComponente> componentList = IterableUtils .toList(staDComponenteRepository.findAll());
			
			Tracer.info(LOG, getClass().getName(), method, "found # " + componentList.size() + " componentList");	
			

		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception "  +e);
		}
		finally {
			
		}
		
	}

	@Override
	public void saveAuditMessage(AuditMessageDto auditMessageDto) throws HelperException {
		final String method = "saveAuditMessage";
		try {
			Tracer.debug(LOG, getClass().getName(), method, "BEGIN");
			
			auditMessageQueueSender.sendMessage(auditMessageAdapter.convertTo(auditMessageDto));
			
		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception "  +e);
			throw e;
		}
		finally {
			Tracer.debug(LOG, getClass().getName(), method, "END");
		}
	}

	

}
