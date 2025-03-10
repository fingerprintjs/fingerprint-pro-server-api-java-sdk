package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * WebhookFactoryReset
 */


@JsonPropertyOrder({
  WebhookFactoryReset.JSON_PROPERTY_TIME,
  WebhookFactoryReset.JSON_PROPERTY_TIMESTAMP
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class WebhookFactoryReset {
  public static final String JSON_PROPERTY_TIME = "time";
  private OffsetDateTime time;

  public static final String JSON_PROPERTY_TIMESTAMP = "timestamp";
  private Long timestamp;

  public WebhookFactoryReset() {
  }

  public WebhookFactoryReset time(OffsetDateTime time) {
    this.time = time;
    return this;
  }

   /**
   * Indicates the time (in UTC) of the most recent factory reset that happened on the **mobile device**.  When a factory reset cannot be detected on the mobile device or when the request is initiated from a browser,  this field will correspond to the *epoch* time (i.e 1 Jan 1970 UTC). See [Factory Reset Detection](https://dev.fingerprint.com/docs/smart-signals-overview#factory-reset-detection) to learn more about this Smart Signal. 
   * @return time
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "Indicates the time (in UTC) of the most recent factory reset that happened on the **mobile device**.  When a factory reset cannot be detected on the mobile device or when the request is initiated from a browser,  this field will correspond to the *epoch* time (i.e 1 Jan 1970 UTC). See [Factory Reset Detection](https://dev.fingerprint.com/docs/smart-signals-overview#factory-reset-detection) to learn more about this Smart Signal. ")
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


  public WebhookFactoryReset timestamp(Long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

   /**
   * This field is just another representation of the value in the `time` field. The time of the most recent factory reset that happened on the **mobile device** is expressed as Unix epoch time.        
   * @return timestamp
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "This field is just another representation of the value in the `time` field. The time of the most recent factory reset that happened on the **mobile device** is expressed as Unix epoch time.        ")
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
   * Return true if this WebhookFactoryReset object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhookFactoryReset webhookFactoryReset = (WebhookFactoryReset) o;
    return Objects.equals(this.time, webhookFactoryReset.time) &&
        Objects.equals(this.timestamp, webhookFactoryReset.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(time, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhookFactoryReset {\n");
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

