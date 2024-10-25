package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.VelocityData;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Sums key data points for a specific `visitorId`, `ipAddress` and `linkedId` at three distinct time intervals: 5 minutes, 1 hour, and 24 hours as follows:   - Number of distinct IP addresses associated to the visitor ID. - Number of distinct linked IDs associated with the visitor ID. - Number of distinct countries associated with the visitor ID. - Number of identification events associated with the visitor ID. - Number of identification events associated with the detected IP address. - Number of distinct IP addresses associated with the provided linked ID. - Number of distinct visitor IDs associated with the provided linked ID.  The `24h` interval of `distinctIp`, `distinctLinkedId`, `distinctCountry`, `distinctIpByLinkedId` and `distinctVisitorIdByLinkedId` will be omitted  if the number of `events` for the visitor ID in the last 24 hours (`events.intervals.['24h']`) is higher than 20.000. 
 */

@Schema(description = "Sums key data points for a specific `visitorId`, `ipAddress` and `linkedId` at three distinct time intervals: 5 minutes, 1 hour, and 24 hours as follows:   - Number of distinct IP addresses associated to the visitor ID. - Number of distinct linked IDs associated with the visitor ID. - Number of distinct countries associated with the visitor ID. - Number of identification events associated with the visitor ID. - Number of identification events associated with the detected IP address. - Number of distinct IP addresses associated with the provided linked ID. - Number of distinct visitor IDs associated with the provided linked ID.  The `24h` interval of `distinctIp`, `distinctLinkedId`, `distinctCountry`, `distinctIpByLinkedId` and `distinctVisitorIdByLinkedId` will be omitted  if the number of `events` for the visitor ID in the last 24 hours (`events.intervals.['24h']`) is higher than 20.000. ")
@JsonPropertyOrder({
  Velocity.JSON_PROPERTY_DISTINCT_IP,
  Velocity.JSON_PROPERTY_DISTINCT_LINKED_ID,
  Velocity.JSON_PROPERTY_DISTINCT_COUNTRY,
  Velocity.JSON_PROPERTY_EVENTS,
  Velocity.JSON_PROPERTY_IP_EVENTS,
  Velocity.JSON_PROPERTY_DISTINCT_IP_BY_LINKED_ID,
  Velocity.JSON_PROPERTY_DISTINCT_VISITOR_ID_BY_LINKED_ID
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class Velocity {
  public static final String JSON_PROPERTY_DISTINCT_IP = "distinctIp";
  private VelocityData distinctIp;

  public static final String JSON_PROPERTY_DISTINCT_LINKED_ID = "distinctLinkedId";
  private VelocityData distinctLinkedId;

  public static final String JSON_PROPERTY_DISTINCT_COUNTRY = "distinctCountry";
  private VelocityData distinctCountry;

  public static final String JSON_PROPERTY_EVENTS = "events";
  private VelocityData events;

  public static final String JSON_PROPERTY_IP_EVENTS = "ipEvents";
  private VelocityData ipEvents;

  public static final String JSON_PROPERTY_DISTINCT_IP_BY_LINKED_ID = "distinctIpByLinkedId";
  private VelocityData distinctIpByLinkedId;

  public static final String JSON_PROPERTY_DISTINCT_VISITOR_ID_BY_LINKED_ID = "distinctVisitorIdByLinkedId";
  private VelocityData distinctVisitorIdByLinkedId;

  public Velocity() {
  }

  public Velocity distinctIp(VelocityData distinctIp) {
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

  public VelocityData getDistinctIp() {
    return distinctIp;
  }


  @JsonProperty(JSON_PROPERTY_DISTINCT_IP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDistinctIp(VelocityData distinctIp) {
    this.distinctIp = distinctIp;
  }


  public Velocity distinctLinkedId(VelocityData distinctLinkedId) {
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

  public VelocityData getDistinctLinkedId() {
    return distinctLinkedId;
  }


  @JsonProperty(JSON_PROPERTY_DISTINCT_LINKED_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDistinctLinkedId(VelocityData distinctLinkedId) {
    this.distinctLinkedId = distinctLinkedId;
  }


  public Velocity distinctCountry(VelocityData distinctCountry) {
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

  public VelocityData getDistinctCountry() {
    return distinctCountry;
  }


  @JsonProperty(JSON_PROPERTY_DISTINCT_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDistinctCountry(VelocityData distinctCountry) {
    this.distinctCountry = distinctCountry;
  }


  public Velocity events(VelocityData events) {
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

  public VelocityData getEvents() {
    return events;
  }


  @JsonProperty(JSON_PROPERTY_EVENTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEvents(VelocityData events) {
    this.events = events;
  }


  public Velocity ipEvents(VelocityData ipEvents) {
    this.ipEvents = ipEvents;
    return this;
  }

   /**
   * Get ipEvents
   * @return ipEvents
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_IP_EVENTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public VelocityData getIpEvents() {
    return ipEvents;
  }


  @JsonProperty(JSON_PROPERTY_IP_EVENTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIpEvents(VelocityData ipEvents) {
    this.ipEvents = ipEvents;
  }


  public Velocity distinctIpByLinkedId(VelocityData distinctIpByLinkedId) {
    this.distinctIpByLinkedId = distinctIpByLinkedId;
    return this;
  }

   /**
   * Get distinctIpByLinkedId
   * @return distinctIpByLinkedId
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_DISTINCT_IP_BY_LINKED_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public VelocityData getDistinctIpByLinkedId() {
    return distinctIpByLinkedId;
  }


  @JsonProperty(JSON_PROPERTY_DISTINCT_IP_BY_LINKED_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDistinctIpByLinkedId(VelocityData distinctIpByLinkedId) {
    this.distinctIpByLinkedId = distinctIpByLinkedId;
  }


  public Velocity distinctVisitorIdByLinkedId(VelocityData distinctVisitorIdByLinkedId) {
    this.distinctVisitorIdByLinkedId = distinctVisitorIdByLinkedId;
    return this;
  }

   /**
   * Get distinctVisitorIdByLinkedId
   * @return distinctVisitorIdByLinkedId
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_DISTINCT_VISITOR_ID_BY_LINKED_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public VelocityData getDistinctVisitorIdByLinkedId() {
    return distinctVisitorIdByLinkedId;
  }


  @JsonProperty(JSON_PROPERTY_DISTINCT_VISITOR_ID_BY_LINKED_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDistinctVisitorIdByLinkedId(VelocityData distinctVisitorIdByLinkedId) {
    this.distinctVisitorIdByLinkedId = distinctVisitorIdByLinkedId;
  }


  /**
   * Return true if this Velocity object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Velocity velocity = (Velocity) o;
    return Objects.equals(this.distinctIp, velocity.distinctIp) &&
        Objects.equals(this.distinctLinkedId, velocity.distinctLinkedId) &&
        Objects.equals(this.distinctCountry, velocity.distinctCountry) &&
        Objects.equals(this.events, velocity.events) &&
        Objects.equals(this.ipEvents, velocity.ipEvents) &&
        Objects.equals(this.distinctIpByLinkedId, velocity.distinctIpByLinkedId) &&
        Objects.equals(this.distinctVisitorIdByLinkedId, velocity.distinctVisitorIdByLinkedId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(distinctIp, distinctLinkedId, distinctCountry, events, ipEvents, distinctIpByLinkedId, distinctVisitorIdByLinkedId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Velocity {\n");
    sb.append("    distinctIp: ").append(toIndentedString(distinctIp)).append("\n");
    sb.append("    distinctLinkedId: ").append(toIndentedString(distinctLinkedId)).append("\n");
    sb.append("    distinctCountry: ").append(toIndentedString(distinctCountry)).append("\n");
    sb.append("    events: ").append(toIndentedString(events)).append("\n");
    sb.append("    ipEvents: ").append(toIndentedString(ipEvents)).append("\n");
    sb.append("    distinctIpByLinkedId: ").append(toIndentedString(distinctIpByLinkedId)).append("\n");
    sb.append("    distinctVisitorIdByLinkedId: ").append(toIndentedString(distinctVisitorIdByLinkedId)).append("\n");
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

