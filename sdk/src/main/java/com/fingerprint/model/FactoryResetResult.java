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
 * FactoryResetResult
 */


@JsonPropertyOrder({
  FactoryResetResult.JSON_PROPERTY_TIME,
  FactoryResetResult.JSON_PROPERTY_TIMESTAMP
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class FactoryResetResult {
  public static final String JSON_PROPERTY_TIME = "time";
  private OffsetDateTime time;

  public static final String JSON_PROPERTY_TIMESTAMP = "timestamp";
  private Long timestamp;

  public FactoryResetResult() {
  }

  public FactoryResetResult time(OffsetDateTime time) {
    this.time = time;
    return this;
  }

   /**
   * Time in UTC when the most recent factory reset of the Android or iOS device was done.  If there is no sign of factory reset or the client is not a mobile device, the field will contain the epoch time (1 January 1970) in UTC. 
   * @return time
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "2022-06-09T22:58:36Z", required = true, description = "Time in UTC when the most recent factory reset of the Android or iOS device was done.  If there is no sign of factory reset or the client is not a mobile device, the field will contain the epoch time (1 January 1970) in UTC. ")
  @JsonProperty(JSON_PROPERTY_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getTime() {
    return time;
  }


  @JsonProperty(JSON_PROPERTY_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTime(OffsetDateTime time) {
    this.time = time;
  }


  public FactoryResetResult timestamp(Long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

   /**
   * Same value as it&#39;s in the &#x60;time&#x60; field but represented in timestamp format.
   * @return timestamp
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "1654815517198", required = true, description = "Same value as it's in the `time` field but represented in timestamp format.")
  @JsonProperty(JSON_PROPERTY_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getTimestamp() {
    return timestamp;
  }


  @JsonProperty(JSON_PROPERTY_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }


  /**
   * Return true if this FactoryResetResult object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FactoryResetResult factoryResetResult = (FactoryResetResult) o;
    return Objects.equals(this.time, factoryResetResult.time) &&
        Objects.equals(this.timestamp, factoryResetResult.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(time, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FactoryResetResult {\n");
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

