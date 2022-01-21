package it.csi.stacore.staaudit.business.helper.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.stacore.staaudit.business.exception.HelperException;
import it.csi.stacore.staaudit.business.helper.TestResourceHelper;
import it.csi.stacore.staaudit.integration.dto.AuditMessage;
import it.csi.stacore.staaudit.integration.queue.sender.AuditMessageQueueSender;
import it.csi.stacore.staaudit.integration.queue.sender.TestResourceQueueSender;
import it.csi.stacore.staaudit.util.Constants;
import it.csi.stacore.staaudit.util.Tracer;

@Service("testResourceHelper")
public class TestResourceHelperImpl extends CommonHelperImpl implements TestResourceHelper {
	
	
	
	@Autowired
	private TestResourceQueueSender testResourceQueueSender;
	
	@Autowired
	private AuditMessageQueueSender auditMessageQueueSender;
	
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
			
			return true;
		}
		finally {
			
		}
		
	}

	

}
