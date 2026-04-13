package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * WebhookVirtualMachine
 */


@JsonPropertyOrder({
  WebhookVirtualMachine.JSON_PROPERTY_RESULT,
  WebhookVirtualMachine.JSON_PROPERTY_ML_SCORE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class WebhookVirtualMachine {
  public static final String JSON_PROPERTY_RESULT = "result";
  private Boolean result;

  public static final String JSON_PROPERTY_ML_SCORE = "mlScore";
  private Double mlScore;

  public WebhookVirtualMachine() {
  }

  public WebhookVirtualMachine result(Boolean result) {
    this.result = result;
    return this;
  }

   /**
   * `true` if the request came from a browser running inside a virtual machine (e.g. VMWare), `false` otherwise. 
   * @return result
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "`true` if the request came from a browser running inside a virtual machine (e.g. VMWare), `false` otherwise. ")
  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getResult() {
    return result;
  }


  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResult(Boolean result) {
    this.result = result;
  }


  public WebhookVirtualMachine mlScore(Double mlScore) {
    this.mlScore = mlScore;
    return this;
  }

   /**
   * Machine learning–based virtual machine score,  represented as a floating-point value between 0 and 1 (inclusive), with up to three decimal places of precision. A higher score means a higher confidence in the positive `virtual_machine` detection result 
   * minimum: 0
   * maximum: 1
   * @return mlScore
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "Machine learning–based virtual machine score,  represented as a floating-point value between 0 and 1 (inclusive), with up to three decimal places of precision. A higher score means a higher confidence in the positive `virtual_machine` detection result ")
  @JsonProperty(JSON_PROPERTY_ML_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getMlScore() {
    return mlScore;
  }


  @JsonProperty(JSON_PROPERTY_ML_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMlScore(Double mlScore) {
    this.mlScore = mlScore;
  }


  /**
   * Return true if this WebhookVirtualMachine object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhookVirtualMachine webhookVirtualMachine = (WebhookVirtualMachine) o;
    return Objects.equals(this.result, webhookVirtualMachine.result) &&
        Objects.equals(this.mlScore, webhookVirtualMachine.mlScore);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, mlScore);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhookVirtualMachine {\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    mlScore: ").append(toIndentedString(mlScore)).append("\n");
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

