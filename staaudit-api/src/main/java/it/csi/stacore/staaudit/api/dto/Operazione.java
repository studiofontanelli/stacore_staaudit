package it.csi.stacore.staaudit.api.dto;

import java.util.Objects;
import java.util.ArrayList;
import io.swagger.annotations.ApiModel;
import java.util.Date;
import java.io.Serializable;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

@ApiModel(description="rappresenta l'operazione effettuata")

public class Operazione  implements Serializable {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [implicit-camel-case] 
  private static final long serialVersionUID = 1L;
  
  private String codice = null;
  private String entita = null;
  private String chiave = null;
  private Date data = null;

  /**
   * il codice dell&#39;operazione effettuata
   **/
  
  @ApiModelProperty(example = "Valori disponibili (LOGIN, LOGOUT, READ, INSERT, UPDATE, DELETE, PRINT)", required = true, value = "il codice dell'operazione effettuata")

  // nome originario nello yaml: codice 
  @NotNull
  public String getCodice() {
    return codice;
  }
  public void setCodice(String codice) {
    this.codice = codice;
  }

  /**
   * l&#39;entità oggetto dell&#39;operazione
   **/
  
  @ApiModelProperty(value = "l'entità oggetto dell'operazione")

  // nome originario nello yaml: entita 
  public String getEntita() {
    return entita;
  }
  public void setEntita(String entita) {
    this.entita = entita;
  }

  /**
   * la chiave (primaria/logica) dell&#39;entità per la quale si è effettuata l&#39;operazione. La chiave è obbligatoria se l&#39;entità è presente
   **/
  
  @ApiModelProperty(example = "PK, chiave logica dell'entità", value = "la chiave (primaria/logica) dell'entità per la quale si è effettuata l'operazione. La chiave è obbligatoria se l'entità è presente")

  // nome originario nello yaml: chiave 
  public String getChiave() {
    return chiave;
  }
  public void setChiave(String chiave) {
    this.chiave = chiave;
  }

  /**
   * la data operazione n formato dd/MM/yyyy HH:mm:ss
   **/
  
  @ApiModelProperty(example = "10/01/2022 15:33:00", required = true, value = "la data operazione n formato dd/MM/yyyy HH:mm:ss")

  // nome originario nello yaml: data 
  @NotNull
  public Date getData() {
    return data;
  }
  public void setData(Date data) {
    this.data = data;
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
    return Objects.equals(codice, operazione.codice) &&
        Objects.equals(entita, operazione.entita) &&
        Objects.equals(chiave, operazione.chiave) &&
        Objects.equals(data, operazione.data);
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

