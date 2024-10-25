package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.VelocityIntervals;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * VelocityData
 */


@JsonPropertyOrder({
  VelocityData.JSON_PROPERTY_INTERVALS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class VelocityData {
  public static final String JSON_PROPERTY_INTERVALS = "intervals";
  private VelocityIntervals intervals;

  public VelocityData() {
  }

  public VelocityData intervals(VelocityIntervals intervals) {
    this.intervals = intervals;
    return this;
  }

   /**
   * Get intervals
   * @return intervals
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_INTERVALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public VelocityIntervals getIntervals() {
    return intervals;
  }


  @JsonProperty(JSON_PROPERTY_INTERVALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIntervals(VelocityIntervals intervals) {
    this.intervals = intervals;
  }


  /**
   * Return true if this VelocityData object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VelocityData velocityData = (VelocityData) o;
    return Objects.equals(this.intervals, velocityData.intervals);
  }

  @Override
  public int hashCode() {
    return Objects.hash(intervals);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VelocityData {\n");
    sb.append("    intervals: ").append(toIndentedString(intervals)).append("\n");
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

