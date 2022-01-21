package it.csi.stacore.staaudit.spring.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import it.csi.stacore.staaudit.spring.api.dto.Operazione;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * è la richiesta di salvataggio di un&#39;operazione
 */
@ApiModel(description = "è la richiesta di salvataggio di un'operazione")
@Validated

public class RequestSalvaOperazione  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("operazione")
  private Operazione operazione = null;

  @JsonProperty("utente")
  private String utente = null;

  @JsonProperty("ipAddress")
  private String ipAddress = null;

  @JsonProperty("codiceUnitaInstallazione")
  private String codiceUnitaInstallazione = null;

  public RequestSalvaOperazione operazione(Operazione operazione) {
    this.operazione = operazione;
    return this;
  }

  /**
   * l'operazione da salvare
   * @return operazione
  **/
  @ApiModelProperty(required = true, value = "l'operazione da salvare")
  @NotNull

  @Valid

  public Operazione getOperazione() {
    return operazione;
  }

  public void setOperazione(Operazione operazione) {
    this.operazione = operazione;
  }

  public RequestSalvaOperazione utente(String utente) {
    this.utente = utente;
    return this;
  }

  /**
   * identificativo utente
   * @return utente
  **/
  @ApiModelProperty(example = "Il codice fiscale dell'utente", required = true, value = "identificativo utente")
  @NotNull


  public String getUtente() {
    return utente;
  }

  public void setUtente(String utente) {
    this.utente = utente;
  }

  public RequestSalvaOperazione ipAddress(String ipAddress) {
    this.ipAddress = ipAddress;
    return this;
  }

  /**
   * indiririzzo IP utente collegato
   * @return ipAddress
  **/
  @ApiModelProperty(value = "indiririzzo IP utente collegato")


  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  public RequestSalvaOperazione codiceUnitaInstallazione(String codiceUnitaInstallazione) {
    this.codiceUnitaInstallazione = codiceUnitaInstallazione;
    return this;
  }

  /**
   * il codice della UI che effettua la chiamata. Il codice deve essere censito nella base dati della STAAUDIT. N.B. la unità di installazione può non coincidere con la componente
   * @return codiceUnitaInstallazione
  **/
  @ApiModelProperty(example = "staonjb, staonjbbch, stadoc, ecc", required = true, value = "il codice della UI che effettua la chiamata. Il codice deve essere censito nella base dati della STAAUDIT. N.B. la unità di installazione può non coincidere con la componente")
  @NotNull


  public String getCodiceUnitaInstallazione() {
    return codiceUnitaInstallazione;
  }

  public void setCodiceUnitaInstallazione(String codiceUnitaInstallazione) {
    this.codiceUnitaInstallazione = codiceUnitaInstallazione;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestSalvaOperazione requestSalvaOperazione = (RequestSalvaOperazione) o;
    return Objects.equals(this.operazione, requestSalvaOperazione.operazione) &&
        Objects.equals(this.utente, requestSalvaOperazione.utente) &&
        Objects.equals(this.ipAddress, requestSalvaOperazione.ipAddress) &&
        Objects.equals(this.codiceUnitaInstallazione, requestSalvaOperazione.codiceUnitaInstallazione);
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

