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
 * BrowserDetails
 */


@JsonPropertyOrder({
  BrowserDetails.JSON_PROPERTY_BROWSER_NAME,
  BrowserDetails.JSON_PROPERTY_BROWSER_MAJOR_VERSION,
  BrowserDetails.JSON_PROPERTY_BROWSER_FULL_VERSION,
  BrowserDetails.JSON_PROPERTY_OS,
  BrowserDetails.JSON_PROPERTY_OS_VERSION,
  BrowserDetails.JSON_PROPERTY_DEVICE,
  BrowserDetails.JSON_PROPERTY_USER_AGENT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class BrowserDetails {
  public static final String JSON_PROPERTY_BROWSER_NAME = "browserName";
  private String browserName;

  public static final String JSON_PROPERTY_BROWSER_MAJOR_VERSION = "browserMajorVersion";
  private String browserMajorVersion;

  public static final String JSON_PROPERTY_BROWSER_FULL_VERSION = "browserFullVersion";
  private String browserFullVersion;

  public static final String JSON_PROPERTY_OS = "os";
  private String os;

  public static final String JSON_PROPERTY_OS_VERSION = "osVersion";
  private String osVersion;

  public static final String JSON_PROPERTY_DEVICE = "device";
  private String device;

  public static final String JSON_PROPERTY_USER_AGENT = "userAgent";
  private String userAgent;

  public BrowserDetails() {
  }

  public BrowserDetails browserName(String browserName) {
    this.browserName = browserName;
    return this;
  }

   /**
   * Get browserName
   * @return browserName
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_BROWSER_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getBrowserName() {
    return browserName;
  }


  @JsonProperty(JSON_PROPERTY_BROWSER_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBrowserName(String browserName) {
    this.browserName = browserName;
  }


  public BrowserDetails browserMajorVersion(String browserMajorVersion) {
    this.browserMajorVersion = browserMajorVersion;
    return this;
  }

   /**
   * Get browserMajorVersion
   * @return browserMajorVersion
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_BROWSER_MAJOR_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getBrowserMajorVersion() {
    return browserMajorVersion;
  }


  @JsonProperty(JSON_PROPERTY_BROWSER_MAJOR_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBrowserMajorVersion(String browserMajorVersion) {
    this.browserMajorVersion = browserMajorVersion;
  }


  public BrowserDetails browserFullVersion(String browserFullVersion) {
    this.browserFullVersion = browserFullVersion;
    return this;
  }

   /**
   * Get browserFullVersion
   * @return browserFullVersion
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_BROWSER_FULL_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getBrowserFullVersion() {
    return browserFullVersion;
  }


  @JsonProperty(JSON_PROPERTY_BROWSER_FULL_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBrowserFullVersion(String browserFullVersion) {
    this.browserFullVersion = browserFullVersion;
  }


  public BrowserDetails os(String os) {
    this.os = os;
    return this;
  }

   /**
   * Get os
   * @return os
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_OS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getOs() {
    return os;
  }


  @JsonProperty(JSON_PROPERTY_OS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setOs(String os) {
    this.os = os;
  }


  public BrowserDetails osVersion(String osVersion) {
    this.osVersion = osVersion;
    return this;
  }

   /**
   * Get osVersion
   * @return osVersion
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_OS_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getOsVersion() {
    return osVersion;
  }


  @JsonProperty(JSON_PROPERTY_OS_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setOsVersion(String osVersion) {
    this.osVersion = osVersion;
  }


  public BrowserDetails device(String device) {
    this.device = device;
    return this;
  }

   /**
   * Get device
   * @return device
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_DEVICE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDevice() {
    return device;
  }


  @JsonProperty(JSON_PROPERTY_DEVICE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDevice(String device) {
    this.device = device;
  }


  public BrowserDetails userAgent(String userAgent) {
    this.userAgent = userAgent;
    return this;
  }

   /**
   * Get userAgent
   * @return userAgent
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_USER_AGENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getUserAgent() {
    return userAgent;
  }


  @JsonProperty(JSON_PROPERTY_USER_AGENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }


  /**
   * Return true if this BrowserDetails object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BrowserDetails browserDetails = (BrowserDetails) o;
    return Objects.equals(this.browserName, browserDetails.browserName) &&
        Objects.equals(this.browserMajorVersion, browserDetails.browserMajorVersion) &&
        Objects.equals(this.browserFullVersion, browserDetails.browserFullVersion) &&
        Objects.equals(this.os, browserDetails.os) &&
        Objects.equals(this.osVersion, browserDetails.osVersion) &&
        Objects.equals(this.device, browserDetails.device) &&
        Objects.equals(this.userAgent, browserDetails.userAgent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(browserName, browserMajorVersion, browserFullVersion, os, osVersion, device, userAgent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BrowserDetails {\n");
    sb.append("    browserName: ").append(toIndentedString(browserName)).append("\n");
    sb.append("    browserMajorVersion: ").append(toIndentedString(browserMajorVersion)).append("\n");
    sb.append("    browserFullVersion: ").append(toIndentedString(browserFullVersion)).append("\n");
    sb.append("    os: ").append(toIndentedString(os)).append("\n");
    sb.append("    osVersion: ").append(toIndentedString(osVersion)).append("\n");
    sb.append("    device: ").append(toIndentedString(device)).append("\n");
    sb.append("    userAgent: ").append(toIndentedString(userAgent)).append("\n");
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

