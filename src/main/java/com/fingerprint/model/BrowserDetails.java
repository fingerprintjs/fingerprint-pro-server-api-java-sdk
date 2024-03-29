/*
 * Fingerprint Pro Server API
 * Fingerprint Pro Server API allows you to get information about visitors and about individual events in a server environment. It can be used for data exports, decision-making, and data analysis scenarios. Server API is intended for server-side usage, it's not intended to be used from the client side, whether it's a browser or a mobile device. 
 *
 * The version of the OpenAPI document: 3
 * Contact: support@fingerprint.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.fingerprint.model;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;


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
  BrowserDetails.JSON_PROPERTY_USER_AGENT,
  BrowserDetails.JSON_PROPERTY_BOT_PROBABILITY
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
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

  public static final String JSON_PROPERTY_BOT_PROBABILITY = "botProbability";
  private Integer botProbability;

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
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "Chrome", required = true, value = "")
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
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "101", required = true, value = "")
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
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "101.0.4951", required = true, value = "")
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
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "Windows", required = true, value = "")
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
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "10", required = true, value = "")
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
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "Other", required = true, value = "")
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
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.41 Safari/537.36", required = true, value = "")
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


  public BrowserDetails botProbability(Integer botProbability) {
    this.botProbability = botProbability;
    return this;
  }

   /**
   * Get botProbability
   * @return botProbability
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_BOT_PROBABILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getBotProbability() {
    return botProbability;
  }


  @JsonProperty(JSON_PROPERTY_BOT_PROBABILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBotProbability(Integer botProbability) {
    this.botProbability = botProbability;
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
        Objects.equals(this.userAgent, browserDetails.userAgent) &&
        Objects.equals(this.botProbability, browserDetails.botProbability);
  }

  @Override
  public int hashCode() {
    return Objects.hash(browserName, browserMajorVersion, browserFullVersion, os, osVersion, device, userAgent, botProbability);
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
    sb.append("    botProbability: ").append(toIndentedString(botProbability)).append("\n");
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

