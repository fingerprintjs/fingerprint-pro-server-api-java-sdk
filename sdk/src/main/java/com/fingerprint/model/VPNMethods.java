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
 * VPNMethods
 */


@JsonPropertyOrder({
  VPNMethods.JSON_PROPERTY_TIMEZONE_MISMATCH,
  VPNMethods.JSON_PROPERTY_PUBLIC_V_P_N,
  VPNMethods.JSON_PROPERTY_AUXILIARY_MOBILE,
  VPNMethods.JSON_PROPERTY_OS_MISMATCH
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class VPNMethods {
  public static final String JSON_PROPERTY_TIMEZONE_MISMATCH = "timezoneMismatch";
  private Boolean timezoneMismatch;

  public static final String JSON_PROPERTY_PUBLIC_V_P_N = "publicVPN";
  private Boolean publicVPN;

  public static final String JSON_PROPERTY_AUXILIARY_MOBILE = "auxiliaryMobile";
  private Boolean auxiliaryMobile;

  public static final String JSON_PROPERTY_OS_MISMATCH = "osMismatch";
  private Boolean osMismatch;

  public VPNMethods() {
  }

  public VPNMethods timezoneMismatch(Boolean timezoneMismatch) {
    this.timezoneMismatch = timezoneMismatch;
    return this;
  }

   /**
   * The browser timezone doesn&#39;t match the timezone inferred from the request IP address.
   * @return timezoneMismatch
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "The browser timezone doesn't match the timezone inferred from the request IP address.")
  @JsonProperty(JSON_PROPERTY_TIMEZONE_MISMATCH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getTimezoneMismatch() {
    return timezoneMismatch;
  }


  @JsonProperty(JSON_PROPERTY_TIMEZONE_MISMATCH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTimezoneMismatch(Boolean timezoneMismatch) {
    this.timezoneMismatch = timezoneMismatch;
  }


  public VPNMethods publicVPN(Boolean publicVPN) {
    this.publicVPN = publicVPN;
    return this;
  }

   /**
   * Request IP address is owned and used by a public VPN service provider.
   * @return publicVPN
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "Request IP address is owned and used by a public VPN service provider.")
  @JsonProperty(JSON_PROPERTY_PUBLIC_V_P_N)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getPublicVPN() {
    return publicVPN;
  }


  @JsonProperty(JSON_PROPERTY_PUBLIC_V_P_N)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPublicVPN(Boolean publicVPN) {
    this.publicVPN = publicVPN;
  }


  public VPNMethods auxiliaryMobile(Boolean auxiliaryMobile) {
    this.auxiliaryMobile = auxiliaryMobile;
    return this;
  }

   /**
   * This method applies to mobile devices only. Indicates the result of additional methods used to detect a VPN in mobile devices.
   * @return auxiliaryMobile
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "This method applies to mobile devices only. Indicates the result of additional methods used to detect a VPN in mobile devices.")
  @JsonProperty(JSON_PROPERTY_AUXILIARY_MOBILE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getAuxiliaryMobile() {
    return auxiliaryMobile;
  }


  @JsonProperty(JSON_PROPERTY_AUXILIARY_MOBILE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAuxiliaryMobile(Boolean auxiliaryMobile) {
    this.auxiliaryMobile = auxiliaryMobile;
  }


  public VPNMethods osMismatch(Boolean osMismatch) {
    this.osMismatch = osMismatch;
    return this;
  }

   /**
   * The browser runs on a different operating system than the operating system inferred from the request network signature.
   * @return osMismatch
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "The browser runs on a different operating system than the operating system inferred from the request network signature.")
  @JsonProperty(JSON_PROPERTY_OS_MISMATCH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getOsMismatch() {
    return osMismatch;
  }


  @JsonProperty(JSON_PROPERTY_OS_MISMATCH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setOsMismatch(Boolean osMismatch) {
    this.osMismatch = osMismatch;
  }


  /**
   * Return true if this VPNMethods object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VPNMethods vpNMethods = (VPNMethods) o;
    return Objects.equals(this.timezoneMismatch, vpNMethods.timezoneMismatch) &&
        Objects.equals(this.publicVPN, vpNMethods.publicVPN) &&
        Objects.equals(this.auxiliaryMobile, vpNMethods.auxiliaryMobile) &&
        Objects.equals(this.osMismatch, vpNMethods.osMismatch);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timezoneMismatch, publicVPN, auxiliaryMobile, osMismatch);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VPNMethods {\n");
    sb.append("    timezoneMismatch: ").append(toIndentedString(timezoneMismatch)).append("\n");
    sb.append("    publicVPN: ").append(toIndentedString(publicVPN)).append("\n");
    sb.append("    auxiliaryMobile: ").append(toIndentedString(auxiliaryMobile)).append("\n");
    sb.append("    osMismatch: ").append(toIndentedString(osMismatch)).append("\n");
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

