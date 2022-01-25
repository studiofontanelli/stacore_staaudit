package it.csi.stacore.staaudit.integration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="staaudit.sta_d_operazione")
@NamedQuery(name="StaDOperazione.findAll", query="SELECT c FROM StaDOperazione c")
public class StaDOperazione {
	
	@Id
	@Column(name="id_operazione")
	private int idOperazione;
	
	@Column(name="codice_operazione")
	private String codiceOperazione;
	
	@Column(name="descrizione_operazione")
	private String descrizioneOperazione;

	
	
	
	
	
	
	

}
