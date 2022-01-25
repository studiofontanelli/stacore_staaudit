package it.csi.stacore.staaudit.integration.adapter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import it.csi.stacore.staaudit.integration.adapter.StaTAuditAdapter;
import it.csi.stacore.staaudit.integration.dto.AuditMessage;
import it.csi.stacore.staaudit.integration.entity.StaDOperazione;
import it.csi.stacore.staaudit.integration.entity.StaDUnitaInstallazione;
import it.csi.stacore.staaudit.integration.entity.StaTAudit;
import it.csi.stacore.staaudit.integration.repository.StaDOperazioneRepository;
import it.csi.stacore.staaudit.integration.repository.StaDUnitaInstallazioneRepository;
import it.csi.stacore.staaudit.util.Tracer;
import it.csi.stacore.staaudit.util.XmlSerializer;
import it.csi.stacore.staaudit.util.adapter.CommonDtoAdapter;
import it.csi.stacore.staaudit.util.adapter.exception.DtoConversionException;


@Component
public class StaTAuditAdapterImpl extends CommonDtoAdapter<AuditMessage, StaTAudit> implements StaTAuditAdapter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2894452695199248089L;
	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	
	@Autowired
	private StaDUnitaInstallazioneRepository staDUnitaInstallazioneRepository;
	
	@Autowired
	private StaDOperazioneRepository staDOperazioneRepository;

	@Override
	public StaTAudit convertTo(AuditMessage t) throws DtoConversionException {
		final String method = "convertTo";
		Tracer.debug(LOG, getClass().getName(), method, "BEGIN");
		try {
		
			StaTAudit result = super.convertTo(t);
			
			Tracer.debug(LOG, getClass().getName(), method, "result\n " + XmlSerializer.objectToXml(t));
			
			result.setDataOperazione(t.getDataOperazione());
			result.setIpAddress(t.getIndirizzoIp());
			result.setKeyOperazione(t.getChiaveOperazione());
			result.setOggOperazione(t.getOggettoOperazione());
			
			StaDUnitaInstallazione staDUnitaInstallazione = staDUnitaInstallazioneRepository.findByCodiceUnitaInstallazione(t.getCodiceUnitaInstallazione());
			
			StaDOperazione staDOperazione = staDOperazioneRepository.findByCodiceOperazione(t.getCodiceOperazione());
			
			result.setStaDUnitaInstallazione(staDUnitaInstallazione);
			result.setStaDOperazione(staDOperazione);
			
			
			return result;
		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw e;
		}
		finally {
			Tracer.debug(LOG, getClass().getName(), method, "END");
		}
		
	}

	

}
