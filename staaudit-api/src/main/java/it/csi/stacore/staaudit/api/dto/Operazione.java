package it.csi.stacore.staaudit.api.dto;

import java.util.Objects;
import java.util.ArrayList;
import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

@ApiModel(description="rappresenta l'operazione da salvare")

public class Operazione  implements Serializable {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [implicit-camel-case] 
  private static final long serialVersionUID = 1L;
  
  private String utente = null;
  private String indirizzoIp = null;
  private String codiceOperazione = null;
  private String codiceUnitaInstallazione = null;
  private String oggettoOperazione = null;
  private String chiaveOperazione = null;

  /**
   * Identificativo Utente che effettua l&#39;operazione
   **/
  
  @ApiModelProperty(example = "Codice Fiscale Utente", required = true, value = "Identificativo Utente che effettua l'operazione")

  // nome originario nello yaml: utente 
  @NotNull
  public String getUtente() {
    return utente;
  }
  public void setUtente(String utente) {
    this.utente = utente;
  }

  /**
   * Indirizzo IP dell&#39;utente che effettua l&#39;operazione
   **/
  
  @ApiModelProperty(example = "Codice Fiscale Utente", value = "Indirizzo IP dell'utente che effettua l'operazione")

  // nome originario nello yaml: indirizzoIp 
  public String getIndirizzoIp() {
    return indirizzoIp;
  }
  public void setIndirizzoIp(String indirizzoIp) {
    this.indirizzoIp = indirizzoIp;
  }

  /**
   * il codice dell&#39;operazione effettuata
   **/
  
  @ApiModelProperty(example = "Valori disponibili (LOGIN, LOGOUT, READ, INSERT, UPDATE, DELETE, PRINT)", required = true, value = "il codice dell'operazione effettuata")

  // nome originario nello yaml: codiceOperazione 
  @NotNull
  public String getCodiceOperazione() {
    return codiceOperazione;
  }
  public void setCodiceOperazione(String codiceOperazione) {
    this.codiceOperazione = codiceOperazione;
  }

  /**
   * il codice della UI che effettua la chiamata. Il codice deve essere censito nella base dati della STAAUDIT. N.B. la unità di installazione può non coincidere con la componente
   **/
  
  @ApiModelProperty(example = "staonjb, staonjbbch, stadoc, ecc", required = true, value = "il codice della UI che effettua la chiamata. Il codice deve essere censito nella base dati della STAAUDIT. N.B. la unità di installazione può non coincidere con la componente")

  // nome originario nello yaml: codiceUnitaInstallazione 
  @NotNull
  public String getCodiceUnitaInstallazione() {
    return codiceUnitaInstallazione;
  }
  public void setCodiceUnitaInstallazione(String codiceUnitaInstallazione) {
    this.codiceUnitaInstallazione = codiceUnitaInstallazione;
  }

  /**
   * l&#39;entità oggetto dell&#39;operazione
   **/
  
  @ApiModelProperty(value = "l'entità oggetto dell'operazione")

  // nome originario nello yaml: oggettoOperazione 
  public String getOggettoOperazione() {
    return oggettoOperazione;
  }
  public void setOggettoOperazione(String oggettoOperazione) {
    this.oggettoOperazione = oggettoOperazione;
  }

  /**
   * la chiave (primaria/logica) dell&#39;entità per la quale si è effettuata l&#39;operazione. La chiave è obbligatoria se l&#39;entità è presente
   **/
  
  @ApiModelProperty(example = "PK, chiave logica dell'entità", value = "la chiave (primaria/logica) dell'entità per la quale si è effettuata l'operazione. La chiave è obbligatoria se l'entità è presente")

  // nome originario nello yaml: chiaveOperazione 
  public String getChiaveOperazione() {
    return chiaveOperazione;
  }
  public void setChiaveOperazione(String chiaveOperazione) {
    this.chiaveOperazione = chiaveOperazione;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Operazione operazione = (Operazione) o;
    return Objects.equals(utente, operazione.utente) &&
        Objects.equals(indirizzoIp, operazione.indirizzoIp) &&
        Objects.equals(codiceOperazione, operazione.codiceOperazione) &&
        Objects.equals(codiceUnitaInstallazione, operazione.codiceUnitaInstallazione) &&
        Objects.equals(oggettoOperazione, operazione.oggettoOperazione) &&
        Objects.equals(chiaveOperazione, operazione.chiaveOperazione);
  }

  @Override
  public int hashCode() {
    return Objects.hash(utente, indirizzoIp, codiceOperazione, codiceUnitaInstallazione, oggettoOperazione, chiaveOperazione);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Operazione {\n");
    
    sb.append("    utente: ").append(toIndentedString(utente)).append("\n");
    sb.append("    indirizzoIp: ").append(toIndentedString(indirizzoIp)).append("\n");
    sb.append("    codiceOperazione: ").append(toIndentedString(codiceOperazione)).append("\n");
    sb.append("    codiceUnitaInstallazione: ").append(toIndentedString(codiceUnitaInstallazione)).append("\n");
    sb.append("    oggettoOperazione: ").append(toIndentedString(oggettoOperazione)).append("\n");
    sb.append("    chiaveOperazione: ").append(toIndentedString(chiaveOperazione)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

