package it.csi.stacore.staaudit.spring.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * rappresenta l&#39;operazione effettuata
 */
@ApiModel(description = "rappresenta l'operazione effettuata")
@Validated

public class Operazione  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("codice")
  private String codice = null;

  @JsonProperty("entita")
  private String entita = null;

  @JsonProperty("chiave")
  private String chiave = null;

  @JsonProperty("data")
  private OffsetDateTime data = null;

  public Operazione codice(String codice) {
    this.codice = codice;
    return this;
  }

  /**
   * il codice dell'operazione effettuata
   * @return codice
  **/
  @ApiModelProperty(example = "Valori disponibili (LOGIN, LOGOUT, READ, INSERT, UPDATE, DELETE, PRINT)", required = true, value = "il codice dell'operazione effettuata")
  @NotNull


  public String getCodice() {
    return codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public Operazione entita(String entita) {
    this.entita = entita;
    return this;
  }

  /**
   * l'entità oggetto dell'operazione
   * @return entita
  **/
  @ApiModelProperty(value = "l'entità oggetto dell'operazione")


  public String getEntita() {
    return entita;
  }

  public void setEntita(String entita) {
    this.entita = entita;
  }

  public Operazione chiave(String chiave) {
    this.chiave = chiave;
    return this;
  }

  /**
   * la chiave (primaria/logica) dell'entità per la quale si è effettuata l'operazione. La chiave è obbligatoria se l'entità è presente
   * @return chiave
  **/
  @ApiModelProperty(example = "PK, chiave logica dell'entità", value = "la chiave (primaria/logica) dell'entità per la quale si è effettuata l'operazione. La chiave è obbligatoria se l'entità è presente")


  public String getChiave() {
    return chiave;
  }

  public void setChiave(String chiave) {
    this.chiave = chiave;
  }

  public Operazione data(OffsetDateTime data) {
    this.data = data;
    return this;
  }

  /**
   * la data operazione n formato dd/MM/yyyy HH:mm:ss
   * @return data
  **/
  @ApiModelProperty(example = "10/01/2022 15:33:00", required = true, value = "la data operazione n formato dd/MM/yyyy HH:mm:ss")
  @NotNull

  @Valid

  public OffsetDateTime getData() {
    return data;
  }

  public void setData(OffsetDateTime data) {
    this.data = data;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Operazione operazione = (Operazione) o;
    return Objects.equals(this.codice, operazione.codice) &&
        Objects.equals(this.entita, operazione.entita) &&
        Objects.equals(this.chiave, operazione.chiave) &&
        Objects.equals(this.data, operazione.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codice, entita, chiave, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Operazione {\n");
    
    sb.append("    codice: ").append(toIndentedString(codice)).append("\n");
    sb.append("    entita: ").append(toIndentedString(entita)).append("\n");
    sb.append("    chiave: ").append(toIndentedString(chiave)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

