package it.csi.stacore.staaudit.business.helper.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import it.csi.stacore.staaudit.business.exception.HelperException;
import it.csi.stacore.staaudit.business.helper.AuditHelper;
import it.csi.stacore.staaudit.util.Tracer;

@Service("auditHelper")
public class AuditHelperImpl extends CommonHelperImpl implements AuditHelper {
	
	
	
	
	@PostConstruct
	public void init() {
		final String method = "init";
		try {
			Tracer.debug(LOG, getClass().getName(), method, "called");
			
			
			
			
			org.springframework.cache.ehcache.EhCacheManagerFactoryBean ff;

		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception "  +e);
		}
		finally {
			
		}
		
	}

	@Override
	public boolean saveAuditMessage(it.csi.stacore.staaudit.business.dto.AuditMessage auditMessage)
			throws HelperException {
		// TODO Auto-generated method stub
		return false;
	}

	

}
