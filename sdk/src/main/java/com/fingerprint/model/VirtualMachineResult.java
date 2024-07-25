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
 * VirtualMachineResult
 */


@JsonPropertyOrder({
  VirtualMachineResult.JSON_PROPERTY_RESULT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class VirtualMachineResult {
  public static final String JSON_PROPERTY_RESULT = "result";
  private Boolean result;

  public VirtualMachineResult() {
  }

  public VirtualMachineResult result(Boolean result) {
    this.result = result;
    return this;
  }

   /**
   * &#x60;true&#x60; if the request came from a browser running inside a virtual machine (e.g. VMWare), &#x60;false&#x60; otherwise. 
   * @return result
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "false", required = true, description = "`true` if the request came from a browser running inside a virtual machine (e.g. VMWare), `false` otherwise. ")
  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getResult() {
    return result;
  }


  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setResult(Boolean result) {
    this.result = result;
  }


  /**
   * Return true if this VirtualMachineResult object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VirtualMachineResult virtualMachineResult = (VirtualMachineResult) o;
    return Objects.equals(this.result, virtualMachineResult.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VirtualMachineResult {\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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

