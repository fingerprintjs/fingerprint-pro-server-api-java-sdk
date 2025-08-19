package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.ProxyConfidence;
import com.fingerprint.model.ProxyDetails;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * WebhookProxy
 */


@JsonPropertyOrder({
  WebhookProxy.JSON_PROPERTY_RESULT,
  WebhookProxy.JSON_PROPERTY_CONFIDENCE,
  WebhookProxy.JSON_PROPERTY_DETAILS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class WebhookProxy {
  public static final String JSON_PROPERTY_RESULT = "result";
  private Boolean result;

  public static final String JSON_PROPERTY_CONFIDENCE = "confidence";
  private ProxyConfidence confidence;

  public static final String JSON_PROPERTY_DETAILS = "details";
  private ProxyDetails details;

  public WebhookProxy() {
  }

  public WebhookProxy result(Boolean result) {
    this.result = result;
    return this;
  }

   /**
   * IP address was used by a public proxy provider or belonged to a known recent residential proxy 
   * @return result
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "IP address was used by a public proxy provider or belonged to a known recent residential proxy ")
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


  public WebhookProxy confidence(ProxyConfidence confidence) {
    this.confidence = confidence;
    return this;
  }

   /**
   * Get confidence
   * @return confidence
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_CONFIDENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ProxyConfidence getConfidence() {
    return confidence;
  }


  @JsonProperty(JSON_PROPERTY_CONFIDENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setConfidence(ProxyConfidence confidence) {
    this.confidence = confidence;
  }


  public WebhookProxy details(ProxyDetails details) {
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

  public ProxyDetails getDetails() {
    return details;
  }


  @JsonProperty(JSON_PROPERTY_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDetails(ProxyDetails details) {
    this.details = details;
  }


  /**
   * Return true if this WebhookProxy object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhookProxy webhookProxy = (WebhookProxy) o;
    return Objects.equals(this.result, webhookProxy.result) &&
        Objects.equals(this.confidence, webhookProxy.confidence) &&
        Objects.equals(this.details, webhookProxy.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, confidence, details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhookProxy {\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    confidence: ").append(toIndentedString(confidence)).append("\n");
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

