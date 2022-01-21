package it.csi.stacore.staaudit.business.helper.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.stacore.staaudit.business.exception.HelperException;
import it.csi.stacore.staaudit.business.helper.AuditHelper;
import it.csi.stacore.staaudit.integration.entity.StaDProdotto;
import it.csi.stacore.staaudit.integration.repository.StaDProdottoRepository;
import it.csi.stacore.staaudit.util.Tracer;

@Service("auditHelper")
public class AuditHelperImpl extends CommonHelperImpl implements AuditHelper {
	
	@Autowired
	private StaDProdottoRepository staDProdottoRepository;
	
	@PostConstruct
	public void init() {
		final String method = "init";
		try {
			Tracer.debug(LOG, getClass().getName(), method, "called");
			
			
			
			List <StaDProdotto> result = IterableUtils .toList(staDProdottoRepository.findAll());
			
			Tracer.info(LOG, getClass().getName(), method, "found # " + result.size() + " prodotti");

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
