package it.csi.stacore.staaudit.api.dto;

import java.util.Objects;
import java.util.ArrayList;
import io.swagger.annotations.ApiModel;
import it.csi.stacore.staaudit.api.dto.Operazione;
import java.io.Serializable;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

@ApiModel(description="è la richiesta di salvataggio di un'operazione")

public class RequestSalvaOperazione  implements Serializable {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [implicit-camel-case] 
  private static final long serialVersionUID = 1L;
  
  private Operazione operazione = null;
  private String utente = null;
  private String ipAddress = null;
  private String codiceUnitaInstallazione = null;

  /**
   * l&#39;operazione da salvare
   **/
  
  @ApiModelProperty(required = true, value = "l'operazione da salvare")

  // nome originario nello yaml: operazione 
  @NotNull
  public Operazione getOperazione() {
    return operazione;
  }
  public void setOperazione(Operazione operazione) {
    this.operazione = operazione;
  }

  /**
   * identificativo utente
   **/
  
  @ApiModelProperty(example = "Il codice fiscale dell'utente", required = true, value = "identificativo utente")

  // nome originario nello yaml: utente 
  @NotNull
  public String getUtente() {
    return utente;
  }
  public void setUtente(String utente) {
    this.utente = utente;
  }

  /**
   * indiririzzo IP utente collegato
   **/
  
  @ApiModelProperty(value = "indiririzzo IP utente collegato")

  // nome originario nello yaml: ipAddress 
  public String getIpAddress() {
    return ipAddress;
  }
  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestSalvaOperazione requestSalvaOperazione = (RequestSalvaOperazione) o;
    return Objects.equals(operazione, requestSalvaOperazione.operazione) &&
        Objects.equals(utente, requestSalvaOperazione.utente) &&
        Objects.equals(ipAddress, requestSalvaOperazione.ipAddress) &&
        Objects.equals(codiceUnitaInstallazione, requestSalvaOperazione.codiceUnitaInstallazione);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operazione, utente, ipAddress, codiceUnitaInstallazione);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestSalvaOperazione {\n");
    
    sb.append("    operazione: ").append(toIndentedString(operazione)).append("\n");
    sb.append("    utente: ").append(toIndentedString(utente)).append("\n");
    sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
    sb.append("    codiceUnitaInstallazione: ").append(toIndentedString(codiceUnitaInstallazione)).append("\n");
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

