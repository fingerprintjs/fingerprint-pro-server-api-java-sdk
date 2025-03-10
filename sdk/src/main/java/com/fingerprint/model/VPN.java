package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.VPNConfidence;
import com.fingerprint.model.VPNMethods;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * VPN
 */


@JsonPropertyOrder({
  VPN.JSON_PROPERTY_RESULT,
  VPN.JSON_PROPERTY_CONFIDENCE,
  VPN.JSON_PROPERTY_ORIGIN_TIMEZONE,
  VPN.JSON_PROPERTY_ORIGIN_COUNTRY,
  VPN.JSON_PROPERTY_METHODS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class VPN {
  public static final String JSON_PROPERTY_RESULT = "result";
  private Boolean result;

  public static final String JSON_PROPERTY_CONFIDENCE = "confidence";
  private VPNConfidence confidence;

  public static final String JSON_PROPERTY_ORIGIN_TIMEZONE = "originTimezone";
  private String originTimezone;

  public static final String JSON_PROPERTY_ORIGIN_COUNTRY = "originCountry";
  private String originCountry;

  public static final String JSON_PROPERTY_METHODS = "methods";
  private VPNMethods methods;

  public VPN() {
  }

  public VPN result(Boolean result) {
    this.result = result;
    return this;
  }

   /**
   * VPN or other anonymizing service has been used when sending the request.
   * @return result
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "VPN or other anonymizing service has been used when sending the request.")
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


  public VPN confidence(VPNConfidence confidence) {
    this.confidence = confidence;
    return this;
  }

   /**
   * Get confidence
   * @return confidence
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_CONFIDENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public VPNConfidence getConfidence() {
    return confidence;
  }


  @JsonProperty(JSON_PROPERTY_CONFIDENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setConfidence(VPNConfidence confidence) {
    this.confidence = confidence;
  }


  public VPN originTimezone(String originTimezone) {
    this.originTimezone = originTimezone;
    return this;
  }

   /**
   * Local timezone which is used in timezoneMismatch method.
   * @return originTimezone
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "Local timezone which is used in timezoneMismatch method.")
  @JsonProperty(JSON_PROPERTY_ORIGIN_TIMEZONE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getOriginTimezone() {
    return originTimezone;
  }


  @JsonProperty(JSON_PROPERTY_ORIGIN_TIMEZONE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setOriginTimezone(String originTimezone) {
    this.originTimezone = originTimezone;
  }


  public VPN originCountry(String originCountry) {
    this.originCountry = originCountry;
    return this;
  }

   /**
   * Country of the request (only for Android SDK version >= 2.4.0, ISO 3166 format or unknown).
   * @return originCountry
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "Country of the request (only for Android SDK version >= 2.4.0, ISO 3166 format or unknown).")
  @JsonProperty(JSON_PROPERTY_ORIGIN_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getOriginCountry() {
    return originCountry;
  }


  @JsonProperty(JSON_PROPERTY_ORIGIN_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setOriginCountry(String originCountry) {
    this.originCountry = originCountry;
  }


  public VPN methods(VPNMethods methods) {
    this.methods = methods;
    return this;
  }

   /**
   * Get methods
   * @return methods
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_METHODS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public VPNMethods getMethods() {
    return methods;
  }


  @JsonProperty(JSON_PROPERTY_METHODS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMethods(VPNMethods methods) {
    this.methods = methods;
  }


  /**
   * Return true if this VPN object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VPN VPN = (VPN) o;
    return Objects.equals(this.result, VPN.result) &&
        Objects.equals(this.confidence, VPN.confidence) &&
        Objects.equals(this.originTimezone, VPN.originTimezone) &&
        Objects.equals(this.originCountry, VPN.originCountry) &&
        Objects.equals(this.methods, VPN.methods);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, confidence, originTimezone, originCountry, methods);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VPN {\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    confidence: ").append(toIndentedString(confidence)).append("\n");
    sb.append("    originTimezone: ").append(toIndentedString(originTimezone)).append("\n");
    sb.append("    originCountry: ").append(toIndentedString(originCountry)).append("\n");
    sb.append("    methods: ").append(toIndentedString(methods)).append("\n");
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

