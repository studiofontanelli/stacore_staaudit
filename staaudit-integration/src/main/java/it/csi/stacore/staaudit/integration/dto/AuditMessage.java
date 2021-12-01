package it.csi.stacore.staaudit.integration.dto;

import java.io.Serializable;

public class AuditMessage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4672553880736570054L;
	
	private String componente;
	private String lineaCLiente;
	
	
	public String getComponente() {
		return componente;
	}
	public void setComponente(String componente) {
		this.componente = componente;
	}
	public String getLineaCLiente() {
		return lineaCLiente;
	}
	public void setLineaCLiente(String lineaCLiente) {
		this.lineaCLiente = lineaCLiente;
	}
	
	
	
	

}
