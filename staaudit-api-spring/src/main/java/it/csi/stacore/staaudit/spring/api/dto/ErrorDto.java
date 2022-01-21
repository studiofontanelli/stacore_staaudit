package it.csi.stacore.staaudit.spring.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import it.csi.stacore.staaudit.spring.api.dto.ErrorDetail;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Rappresenta l&#39;errore restituito da servizio
 */
@ApiModel(description = "Rappresenta l'errore restituito da servizio")
@Validated

public class ErrorDto  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("errorDetails")
  @Valid
  private List<ErrorDetail> errorDetails = null;

  public ErrorDto status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * status http restituito
   * @return status
  **/
  @ApiModelProperty(example = "500, 400, ecc", value = "status http restituito")


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public ErrorDto code(String code) {
    this.code = code;
    return this;
  }

  /**
   * code http restituito
   * @return code
  **/
  @ApiModelProperty(example = "Internal server error, ecc", value = "code http restituito")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ErrorDto description(String description) {
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

  public ErrorDto errorDetails(List<ErrorDetail> errorDetails) {
    this.errorDetails = errorDetails;
    return this;
  }

  public ErrorDto addErrorDetailsItem(ErrorDetail errorDetailsItem) {
    if (this.errorDetails == null) {
      this.errorDetails = new ArrayList<>();
    }
    this.errorDetails.add(errorDetailsItem);
    return this;
  }

  /**
   * i dettagli errore
   * @return errorDetails
  **/
  @ApiModelProperty(value = "i dettagli errore")

  @Valid

  public List<ErrorDetail> getErrorDetails() {
    return errorDetails;
  }

  public void setErrorDetails(List<ErrorDetail> errorDetails) {
    this.errorDetails = errorDetails;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorDto errorDto = (ErrorDto) o;
    return Objects.equals(this.status, errorDto.status) &&
        Objects.equals(this.code, errorDto.code) &&
        Objects.equals(this.description, errorDto.description) &&
        Objects.equals(this.errorDetails, errorDto.errorDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, code, description, errorDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorDto {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    errorDetails: ").append(toIndentedString(errorDetails)).append("\n");
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

