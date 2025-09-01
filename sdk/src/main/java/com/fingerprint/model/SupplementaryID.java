package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.IdentificationConfidence;
import com.fingerprint.model.IdentificationSeenAt;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * SupplementaryID
 */


@JsonPropertyOrder({
  SupplementaryID.JSON_PROPERTY_VISITOR_ID,
  SupplementaryID.JSON_PROPERTY_VISITOR_FOUND,
  SupplementaryID.JSON_PROPERTY_CONFIDENCE,
  SupplementaryID.JSON_PROPERTY_FIRST_SEEN_AT,
  SupplementaryID.JSON_PROPERTY_LAST_SEEN_AT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class SupplementaryID {
  public static final String JSON_PROPERTY_VISITOR_ID = "visitorId";
  private String visitorId;

  public static final String JSON_PROPERTY_VISITOR_FOUND = "visitorFound";
  private Boolean visitorFound;

  public static final String JSON_PROPERTY_CONFIDENCE = "confidence";
  private IdentificationConfidence confidence;

  public static final String JSON_PROPERTY_FIRST_SEEN_AT = "firstSeenAt";
  private IdentificationSeenAt firstSeenAt;

  public static final String JSON_PROPERTY_LAST_SEEN_AT = "lastSeenAt";
  private IdentificationSeenAt lastSeenAt;

  public SupplementaryID() {
  }

  public SupplementaryID visitorId(String visitorId) {
    this.visitorId = visitorId;
    return this;
  }

   /**
   * String of 20 characters that uniquely identifies the visitor's browser or mobile device.
   * @return visitorId
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "String of 20 characters that uniquely identifies the visitor's browser or mobile device.")
  @JsonProperty(JSON_PROPERTY_VISITOR_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getVisitorId() {
    return visitorId;
  }


  @JsonProperty(JSON_PROPERTY_VISITOR_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVisitorId(String visitorId) {
    this.visitorId = visitorId;
  }


  public SupplementaryID visitorFound(Boolean visitorFound) {
    this.visitorFound = visitorFound;
    return this;
  }

   /**
   * Attribute represents if a visitor had been identified before.
   * @return visitorFound
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "Attribute represents if a visitor had been identified before.")
  @JsonProperty(JSON_PROPERTY_VISITOR_FOUND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getVisitorFound() {
    return visitorFound;
  }


  @JsonProperty(JSON_PROPERTY_VISITOR_FOUND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVisitorFound(Boolean visitorFound) {
    this.visitorFound = visitorFound;
  }


  public SupplementaryID confidence(IdentificationConfidence confidence) {
    this.confidence = confidence;
    return this;
  }

   /**
   * Get confidence
   * @return confidence
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_CONFIDENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public IdentificationConfidence getConfidence() {
    return confidence;
  }


  @JsonProperty(JSON_PROPERTY_CONFIDENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setConfidence(IdentificationConfidence confidence) {
    this.confidence = confidence;
  }


  public SupplementaryID firstSeenAt(IdentificationSeenAt firstSeenAt) {
    this.firstSeenAt = firstSeenAt;
    return this;
  }

   /**
   * Get firstSeenAt
   * @return firstSeenAt
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_FIRST_SEEN_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public IdentificationSeenAt getFirstSeenAt() {
    return firstSeenAt;
  }


  @JsonProperty(JSON_PROPERTY_FIRST_SEEN_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFirstSeenAt(IdentificationSeenAt firstSeenAt) {
    this.firstSeenAt = firstSeenAt;
  }


  public SupplementaryID lastSeenAt(IdentificationSeenAt lastSeenAt) {
    this.lastSeenAt = lastSeenAt;
    return this;
  }

   /**
   * Get lastSeenAt
   * @return lastSeenAt
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_LAST_SEEN_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public IdentificationSeenAt getLastSeenAt() {
    return lastSeenAt;
  }


  @JsonProperty(JSON_PROPERTY_LAST_SEEN_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLastSeenAt(IdentificationSeenAt lastSeenAt) {
    this.lastSeenAt = lastSeenAt;
  }


  /**
   * Return true if this SupplementaryID object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SupplementaryID supplementaryID = (SupplementaryID) o;
    return Objects.equals(this.visitorId, supplementaryID.visitorId) &&
        Objects.equals(this.visitorFound, supplementaryID.visitorFound) &&
        Objects.equals(this.confidence, supplementaryID.confidence) &&
        Objects.equals(this.firstSeenAt, supplementaryID.firstSeenAt) &&
        Objects.equals(this.lastSeenAt, supplementaryID.lastSeenAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(visitorId, visitorFound, confidence, firstSeenAt, lastSeenAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SupplementaryID {\n");
    sb.append("    visitorId: ").append(toIndentedString(visitorId)).append("\n");
    sb.append("    visitorFound: ").append(toIndentedString(visitorFound)).append("\n");
    sb.append("    confidence: ").append(toIndentedString(confidence)).append("\n");
    sb.append("    firstSeenAt: ").append(toIndentedString(firstSeenAt)).append("\n");
    sb.append("    lastSeenAt: ").append(toIndentedString(lastSeenAt)).append("\n");
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

