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
 * WebhookIPBlocklist
 */


@JsonPropertyOrder({
  WebhookIPBlocklist.JSON_PROPERTY_RESULT,
  WebhookIPBlocklist.JSON_PROPERTY_DETAILS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class WebhookIPBlocklist {
  public static final String JSON_PROPERTY_RESULT = "result";
  private Boolean result;

  public static final String JSON_PROPERTY_DETAILS = "details";
  private IPBlocklistDetails details;

  public WebhookIPBlocklist() {
  }

  public WebhookIPBlocklist result(Boolean result) {
    this.result = result;
    return this;
  }

   /**
   * `true` if request IP address is part of any database that we use to search for known malicious actors, `false` otherwise. 
   * @return result
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "`true` if request IP address is part of any database that we use to search for known malicious actors, `false` otherwise. ")
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


  public WebhookIPBlocklist details(IPBlocklistDetails details) {
    this.details = details;
    return this;
  }

   /**
   * Get details
   * @return details
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public IPBlocklistDetails getDetails() {
    return details;
  }


  @JsonProperty(JSON_PROPERTY_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDetails(IPBlocklistDetails details) {
    this.details = details;
  }


  /**
   * Return true if this WebhookIPBlocklist object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhookIPBlocklist webhookIPBlocklist = (WebhookIPBlocklist) o;
    return Objects.equals(this.result, webhookIPBlocklist.result) &&
        Objects.equals(this.details, webhookIPBlocklist.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhookIPBlocklist {\n");
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

