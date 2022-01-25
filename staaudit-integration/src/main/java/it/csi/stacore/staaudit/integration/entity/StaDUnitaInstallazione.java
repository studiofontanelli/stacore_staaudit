package it.csi.stacore.staaudit.integration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="staaudit.sta_d_unita_installazione")
@NamedQuery(name="StaDUnitaInstallazione.findAll", query="SELECT c FROM StaDUnitaInstallazione c")
public class StaDUnitaInstallazione {
	
	@Id
	@Column(name="id_unita_installazione")
	private int idUnitaInstallazione;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_componente", nullable=false)
	private StaDComponente staDComponente;
	
	@Column(name="codice_unita_installazione")
	private String codiceUnitaInstallazione;
	
	@Column(name="descrizione_unita_installazione")
	private String descrizioneUnitaInstallazione;

	public int getIdUnitaInstallazione() {
		return idUnitaInstallazione;
	}

	public void setIdUnitaInstallazione(int idUnitaInstallazione) {
		this.idUnitaInstallazione = idUnitaInstallazione;
	}

	public StaDComponente getStaDComponente() {
		return staDComponente;
	}

	public void setStaDComponente(StaDComponente staDComponente) {
		this.staDComponente = staDComponente;
	}

	public String getCodiceUnitaInstallazione() {
		return codiceUnitaInstallazione;
	}

	public void setCodiceUnitaInstallazione(String codiceUnitaInstallazione) {
		this.codiceUnitaInstallazione = codiceUnitaInstallazione;
	}

	public String getDescrizioneUnitaInstallazione() {
		return descrizioneUnitaInstallazione;
	}

	public void setDescrizioneUnitaInstallazione(String descrizioneUnitaInstallazione) {
		this.descrizioneUnitaInstallazione = descrizioneUnitaInstallazione;
	}

	
	
	
	
	
	
	
	

}
