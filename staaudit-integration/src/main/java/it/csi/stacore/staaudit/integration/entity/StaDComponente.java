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
@Table(name="staaudit.sta_d_componente")
@NamedQuery(name="StaDComponente.findAll", query="SELECT c FROM StaDComponente c")
public class StaDComponente {
	
	@Id
	@Column(name="id_componente")
	private int idComponente;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_prodotto", nullable=false)
	private StaDProdotto staDProdotto;
	
	@Column(name="codice_componente")
	private String codiceComponente;
	
	@Column(name="descrizione_componente")
	private String descrizioneComponente;

	public int getIdComponente() {
		return idComponente;
	}

	public void setIdComponente(int idComponente) {
		this.idComponente = idComponente;
	}

	public StaDProdotto getStaDProdotto() {
		return staDProdotto;
	}

	public void setStaDProdotto(StaDProdotto staDProdotto) {
		this.staDProdotto = staDProdotto;
	}

	public String getCodiceComponente() {
		return codiceComponente;
	}

	public void setCodiceComponente(String codiceComponente) {
		this.codiceComponente = codiceComponente;
	}

	public String getDescrizioneComponente() {
		return descrizioneComponente;
	}

	public void setDescrizioneComponente(String descrizioneComponente) {
		this.descrizioneComponente = descrizioneComponente;
	}

	
	
	
	
	
	
	

}
