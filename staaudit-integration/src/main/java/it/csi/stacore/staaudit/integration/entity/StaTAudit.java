package it.csi.stacore.staaudit.integration.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="staaudit.sta_t_audit")
@NamedQuery(name="StaTAudit.findAll", query="SELECT c FROM StaTAudit c")
public class StaTAudit {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="utente")
	private String utente;
	
	@Column(name="ip_address")
	private String ipAddress;

	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_unita_installazione", nullable=false)
	private StaDUnitaInstallazione staDUnitaInstallazione;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_operazione", nullable=false)
	private StaDOperazione staDOperazione;
	
	@Column(name="ogg_operazione")
	private String oggOperazione;
	
	@Column(name="key_operazione")
	private String keyOperazione;
	
	@Column(name="data_operazione")
	private Date dataOperazione;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUtente() {
		return utente;
	}

	public void setUtente(String utente) {
		this.utente = utente;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public StaDUnitaInstallazione getStaDUnitaInstallazione() {
		return staDUnitaInstallazione;
	}

	public void setStaDUnitaInstallazione(StaDUnitaInstallazione staDUnitaInstallazione) {
		this.staDUnitaInstallazione = staDUnitaInstallazione;
	}

	public StaDOperazione getStaDOperazione() {
		return staDOperazione;
	}

	public void setStaDOperazione(StaDOperazione staDOperazione) {
		this.staDOperazione = staDOperazione;
	}

	public String getOggOperazione() {
		return oggOperazione;
	}

	public void setOggOperazione(String oggOperazione) {
		this.oggOperazione = oggOperazione;
	}

	public String getKeyOperazione() {
		return keyOperazione;
	}

	public void setKeyOperazione(String keyOperazione) {
		this.keyOperazione = keyOperazione;
	}

	public Date getDataOperazione() {
		return dataOperazione;
	}

	public void setDataOperazione(Date dataOperazione) {
		this.dataOperazione = dataOperazione;
	}
	
	

}
