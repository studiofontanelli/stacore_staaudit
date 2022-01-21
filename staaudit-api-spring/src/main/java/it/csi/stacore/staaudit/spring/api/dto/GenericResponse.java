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
 * Risposta di un servizio generico
 */
@ApiModel(description = "Risposta di un servizio generico")
@Validated

public class GenericResponse  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("message")
  private String message = null;

  public GenericResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Contiene il messaggio eventuale del servizio chiamato
   * @return message
  **/
  @ApiModelProperty(example = "Servizio ha risposto correttamente", value = "Contiene il messaggio eventuale del servizio chiamato")


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenericResponse genericResponse = (GenericResponse) o;
    return Objects.equals(this.message, genericResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenericResponse {\n");
    
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

