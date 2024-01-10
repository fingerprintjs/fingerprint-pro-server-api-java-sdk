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
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;


/**
 * WebhookSignalResponseFactoryReset
 */
@JsonPropertyOrder({
  WebhookSignalResponseFactoryReset.JSON_PROPERTY_TIME,
  WebhookSignalResponseFactoryReset.JSON_PROPERTY_TIMESTAMP
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class WebhookSignalResponseFactoryReset {
  public static final String JSON_PROPERTY_TIME = "time";
  private OffsetDateTime time;

  public static final String JSON_PROPERTY_TIMESTAMP = "timestamp";
  private Long timestamp;

  public WebhookSignalResponseFactoryReset() {
  }

  public WebhookSignalResponseFactoryReset time(OffsetDateTime time) {
    this.time = time;
    return this;
  }

   /**
   * Time in UTC for the Android client when recent factory reset was done.  If there is no sign of factory reset or the client isn&#39;t Android, the field will be epoch time. 
   * @return time
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-06-09T22:58:36Z", value = "Time in UTC for the Android client when recent factory reset was done.  If there is no sign of factory reset or the client isn't Android, the field will be epoch time. ")
  @JsonProperty(JSON_PROPERTY_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getTime() {
    return time;
  }


  @JsonProperty(JSON_PROPERTY_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTime(OffsetDateTime time) {
    this.time = time;
  }


  public WebhookSignalResponseFactoryReset timestamp(Long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

   /**
   * Same value as it&#39;s in the &#x60;time&#x60; field but represented in timestamp format.
   * @return timestamp
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1654815517198", value = "Same value as it's in the `time` field but represented in timestamp format.")
  @JsonProperty(JSON_PROPERTY_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getTimestamp() {
    return timestamp;
  }


  @JsonProperty(JSON_PROPERTY_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }


  /**
   * Return true if this WebhookSignalResponseFactoryReset object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhookSignalResponseFactoryReset webhookSignalResponseFactoryReset = (WebhookSignalResponseFactoryReset) o;
    return Objects.equals(this.time, webhookSignalResponseFactoryReset.time) &&
        Objects.equals(this.timestamp, webhookSignalResponseFactoryReset.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(time, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhookSignalResponseFactoryReset {\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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

