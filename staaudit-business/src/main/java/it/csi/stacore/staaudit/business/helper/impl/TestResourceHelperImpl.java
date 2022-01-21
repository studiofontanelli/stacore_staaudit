package it.csi.stacore.staaudit.business.helper.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.collections4.IterableUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.stacore.staaudit.business.exception.HelperException;
import it.csi.stacore.staaudit.business.helper.TestResourceHelper;
import it.csi.stacore.staaudit.integration.dto.AuditMessage;
import it.csi.stacore.staaudit.integration.entity.StaDProdotto;
import it.csi.stacore.staaudit.integration.queue.sender.AuditMessageQueueSender;
import it.csi.stacore.staaudit.integration.queue.sender.TestResourceQueueSender;
import it.csi.stacore.staaudit.integration.repository.StaDProdottoRepository;
import it.csi.stacore.staaudit.util.Constants;
import it.csi.stacore.staaudit.util.Tracer;

@Service("testResourceHelper")
public class TestResourceHelperImpl extends CommonHelperImpl implements TestResourceHelper {
	
	
	
	@Autowired
	private TestResourceQueueSender testResourceQueueSender;
	
	@Autowired
	private AuditMessageQueueSender auditMessageQueueSender;
	
	
	@Autowired
	private StaDProdottoRepository staDProdottoRepository;
	
	@PostConstruct
	public void init() {
		final String method = "init";
		try {
			Tracer.debug(LOG, getClass().getName(), method, "called");
			
			boolean testResource = testResources();
			
			
			Tracer.debug(LOG, getClass().getName(), method, "testResource= " + testResource);
			
		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception "  +e);
		}
		finally {
			
		}
		
	}

	@Override
	public boolean testResources() throws HelperException {
		final String method = "testResources";
		try {
			Tracer.debug(LOG, getClass().getName(), method, "called");
			
			testResourceQueueSender.sendMessage("Hello queue");
			
			AuditMessage am = new AuditMessage();
			am.setComponente("staon");
			am.setLineaCLiente("tst-rp-01");
			
			auditMessageQueueSender.sendMessage(am);
			
			
			Tracer.info(LOG, getClass().getName(), method, "TRY JPA....");
			List <StaDProdotto> result = IterableUtils .toList(staDProdottoRepository.findAll());
			
			Tracer.info(LOG, getClass().getName(), method, "found # " + result.size() + " prodotti");
			
			return true;
		}
		finally {
			
		}
		
	}

	

}
