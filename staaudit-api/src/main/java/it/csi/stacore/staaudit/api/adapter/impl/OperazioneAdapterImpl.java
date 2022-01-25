package it.csi.stacore.staaudit.api.adapter.impl;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import it.csi.stacore.staaudit.api.adapter.OperazioneAdapter;
import it.csi.stacore.staaudit.api.dto.Operazione;
import it.csi.stacore.staaudit.business.dto.AuditMessageDto;
import it.csi.stacore.staaudit.business.exception.ValidationException;
import it.csi.stacore.staaudit.util.Tracer;
import it.csi.stacore.staaudit.util.XmlSerializer;
import it.csi.stacore.staaudit.util.adapter.CommonDtoAdapter;
import it.csi.stacore.staaudit.util.adapter.exception.DtoConversionException;

@Component
public class OperazioneAdapterImpl  extends CommonDtoAdapter<Operazione, AuditMessageDto> implements OperazioneAdapter{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7579717607001588057L;
	
	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public AuditMessageDto convertTo(Operazione t) throws DtoConversionException {
		final String method = "convertTo";
		Tracer.debug(LOG, getClass().getName(), method, "BEGIN");
		AuditMessageDto result = super.convertTo(t);
		try {
			Tracer.debug(LOG, getClass().getName(), method, " " + XmlSerializer.objectToXml(t));
			
			if(t == null)
				throw new ValidationException("Operazione non valorizzata");
			if(StringUtils.isBlank(t.getUtente()))
				throw new ValidationException("Utente non valorizzato");
			if(StringUtils.isBlank(t.getCodiceOperazione()))
				throw new ValidationException("Codice operazione non valorizzata");
			if(StringUtils.isBlank(t.getCodiceUnitaInstallazione()))
				throw new ValidationException("Codice unita installazione non valorizzata");
			
			result.setDataOperazione(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));

		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw e;
		}
		finally {
			Tracer.debug(LOG, getClass().getName(), method, "END");
		}
		return result;
	}

	
	
	

}
