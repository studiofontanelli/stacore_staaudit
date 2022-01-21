package it.csi.stacore.staaudit.spring.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * rappresenta il dettaglio errore restituito in caso di errori di validazione sui campi di input
 */
@ApiModel(description = "rappresenta il dettaglio errore restituito in caso di errori di validazione sui campi di input")
@Validated

public class ErrorDetail  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("field")
  private String field = null;

  @JsonProperty("error")
  private String error = null;

  @JsonProperty("description")
  private String description = null;

  public ErrorDetail field(String field) {
    this.field = field;
    return this;
  }

  /**
   * il nome del campo per cui è falita la validazione
   * @return field
  **/
  @ApiModelProperty(example = "name, surname", value = "il nome del campo per cui è falita la validazione")


  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public ErrorDetail error(String error) {
    this.error = error;
    return this;
  }

  /**
   * l'errore di validazione effettivo
   * @return error
  **/
  @ApiModelProperty(example = "campo obbligatorio, ecc", value = "l'errore di validazione effettivo")


  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public ErrorDetail description(String description) {
    this.description = description;
    return this;
  }

  /**
   * la descrizione dell'errore
   * @return description
  **/
  @ApiModelProperty(example = "Internal server error, ecc", value = "la descrizione dell'errore")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorDetail errorDetail = (ErrorDetail) o;
    return Objects.equals(this.field, errorDetail.field) &&
        Objects.equals(this.error, errorDetail.error) &&
        Objects.equals(this.description, errorDetail.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field, error, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorDetail {\n");
    
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

