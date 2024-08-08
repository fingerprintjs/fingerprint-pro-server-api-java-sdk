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
 * Sums key data points for a specific `visitorId` at three distinct time intervals: 5 minutes, 1 hour, and 24 hours as follows:  - Number of identification events attributed to the visitor ID - Number of distinct IP addresses associated to the visitor ID. - Number of distinct countries associated with the visitor ID. - Number of distinct `linkedId`s associated with the visitor ID. The `24h` interval of `distinctIp`, `distinctLinkedId`, and `distinctCountry` will be omitted if the number of `events` for the visitor ID in the last 24 hours (`events.intervals.['24h']`) is higher than 20.000. 
 */

@Schema(description = "Sums key data points for a specific `visitorId` at three distinct time intervals: 5 minutes, 1 hour, and 24 hours as follows:  - Number of identification events attributed to the visitor ID - Number of distinct IP addresses associated to the visitor ID. - Number of distinct countries associated with the visitor ID. - Number of distinct `linkedId`s associated with the visitor ID. The `24h` interval of `distinctIp`, `distinctLinkedId`, and `distinctCountry` will be omitted if the number of `events` for the visitor ID in the last 24 hours (`events.intervals.['24h']`) is higher than 20.000. ")
@JsonPropertyOrder({
  VelocityResult.JSON_PROPERTY_DISTINCT_IP,
  VelocityResult.JSON_PROPERTY_DISTINCT_LINKED_ID,
  VelocityResult.JSON_PROPERTY_DISTINCT_COUNTRY,
  VelocityResult.JSON_PROPERTY_EVENTS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class VelocityResult {
  public static final String JSON_PROPERTY_DISTINCT_IP = "distinctIp";
  private VelocityIntervals distinctIp;

  public static final String JSON_PROPERTY_DISTINCT_LINKED_ID = "distinctLinkedId";
  private VelocityIntervals distinctLinkedId;

  public static final String JSON_PROPERTY_DISTINCT_COUNTRY = "distinctCountry";
  private VelocityIntervals distinctCountry;

  public static final String JSON_PROPERTY_EVENTS = "events";
  private VelocityIntervals events;

  public VelocityResult() {
  }

  public VelocityResult distinctIp(VelocityIntervals distinctIp) {
    this.distinctIp = distinctIp;
    return this;
  }

   /**
   * Get distinctIp
   * @return distinctIp
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_DISTINCT_IP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public VelocityIntervals getDistinctIp() {
    return distinctIp;
  }


  @JsonProperty(JSON_PROPERTY_DISTINCT_IP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDistinctIp(VelocityIntervals distinctIp) {
    this.distinctIp = distinctIp;
  }


  public VelocityResult distinctLinkedId(VelocityIntervals distinctLinkedId) {
    this.distinctLinkedId = distinctLinkedId;
    return this;
  }

   /**
   * Get distinctLinkedId
   * @return distinctLinkedId
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_DISTINCT_LINKED_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public VelocityIntervals getDistinctLinkedId() {
    return distinctLinkedId;
  }


  @JsonProperty(JSON_PROPERTY_DISTINCT_LINKED_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDistinctLinkedId(VelocityIntervals distinctLinkedId) {
    this.distinctLinkedId = distinctLinkedId;
  }


  public VelocityResult distinctCountry(VelocityIntervals distinctCountry) {
    this.distinctCountry = distinctCountry;
    return this;
  }

   /**
   * Get distinctCountry
   * @return distinctCountry
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_DISTINCT_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public VelocityIntervals getDistinctCountry() {
    return distinctCountry;
  }


  @JsonProperty(JSON_PROPERTY_DISTINCT_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDistinctCountry(VelocityIntervals distinctCountry) {
    this.distinctCountry = distinctCountry;
  }


  public VelocityResult events(VelocityIntervals events) {
    this.events = events;
    return this;
  }

   /**
   * Get events
   * @return events
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_EVENTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public VelocityIntervals getEvents() {
    return events;
  }


  @JsonProperty(JSON_PROPERTY_EVENTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEvents(VelocityIntervals events) {
    this.events = events;
  }


  /**
   * Return true if this VelocityResult object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VelocityResult velocityResult = (VelocityResult) o;
    return Objects.equals(this.distinctIp, velocityResult.distinctIp) &&
        Objects.equals(this.distinctLinkedId, velocityResult.distinctLinkedId) &&
        Objects.equals(this.distinctCountry, velocityResult.distinctCountry) &&
        Objects.equals(this.events, velocityResult.events);
  }

  @Override
  public int hashCode() {
    return Objects.hash(distinctIp, distinctLinkedId, distinctCountry, events);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VelocityResult {\n");
    sb.append("    distinctIp: ").append(toIndentedString(distinctIp)).append("\n");
    sb.append("    distinctLinkedId: ").append(toIndentedString(distinctLinkedId)).append("\n");
    sb.append("    distinctCountry: ").append(toIndentedString(distinctCountry)).append("\n");
    sb.append("    events: ").append(toIndentedString(events)).append("\n");
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

