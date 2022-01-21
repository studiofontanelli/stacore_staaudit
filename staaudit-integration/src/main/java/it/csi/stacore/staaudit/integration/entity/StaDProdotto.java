package it.csi.stacore.staaudit.integration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="staaudit.sta_d_prodotto")
@NamedQuery(name="StaDProdotto.findAll", query="SELECT c FROM StaDProdotto c")
public class StaDProdotto {
	
	
	@Id
	@Column(name="id_prodotto")
	private int idProdotto;
	
	@Column(name="codice_prodotto")
	private String codiceProdotto;
	
	@Column(name="descrizione_prodotto")
	private String descrizioneProdotto;

	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getCodiceProdotto() {
		return codiceProdotto;
	}

	public void setCodiceProdotto(String codiceProdotto) {
		this.codiceProdotto = codiceProdotto;
	}

	public String getDescrizioneProdotto() {
		return descrizioneProdotto;
	}

	public void setDescrizioneProdotto(String descrizioneProdotto) {
		this.descrizioneProdotto = descrizioneProdotto;
	}
	
	
	
	
	
	

}
