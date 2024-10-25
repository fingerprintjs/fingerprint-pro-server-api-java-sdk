package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.IPBlocklistDetails;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * IPBlocklist
 */


@JsonPropertyOrder({
  IPBlocklist.JSON_PROPERTY_RESULT,
  IPBlocklist.JSON_PROPERTY_DETAILS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class IPBlocklist {
  public static final String JSON_PROPERTY_RESULT = "result";
  private Boolean result;

  public static final String JSON_PROPERTY_DETAILS = "details";
  private IPBlocklistDetails details;

  public IPBlocklist() {
  }

  public IPBlocklist result(Boolean result) {
    this.result = result;
    return this;
  }

   /**
   * &#x60;true&#x60; if request IP address is part of any database that we use to search for known malicious actors, &#x60;false&#x60; otherwise. 
   * @return result
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "`true` if request IP address is part of any database that we use to search for known malicious actors, `false` otherwise. ")
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


  public IPBlocklist details(IPBlocklistDetails details) {
    this.details = details;
    return this;
  }

   /**
   * Get details
   * @return details
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_DETAILS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public IPBlocklistDetails getDetails() {
    return details;
  }


  @JsonProperty(JSON_PROPERTY_DETAILS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDetails(IPBlocklistDetails details) {
    this.details = details;
  }


  /**
   * Return true if this IPBlocklist object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IPBlocklist ipBlocklist = (IPBlocklist) o;
    return Objects.equals(this.result, ipBlocklist.result) &&
        Objects.equals(this.details, ipBlocklist.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IPBlocklist {\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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

