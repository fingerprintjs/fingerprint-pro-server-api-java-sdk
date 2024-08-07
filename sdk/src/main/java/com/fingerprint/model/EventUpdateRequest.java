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
 * EventUpdateRequest
 */


@JsonPropertyOrder({
  EventUpdateRequest.JSON_PROPERTY_LINKED_ID,
  EventUpdateRequest.JSON_PROPERTY_TAG,
  EventUpdateRequest.JSON_PROPERTY_SUSPECT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class EventUpdateRequest {
  public static final String JSON_PROPERTY_LINKED_ID = "linkedId";
  private String linkedId;

  public static final String JSON_PROPERTY_TAG = "tag";
  private Object tag;

  public static final String JSON_PROPERTY_SUSPECT = "suspect";
  private Boolean suspect;

  public EventUpdateRequest() {
  }

  public EventUpdateRequest linkedId(String linkedId) {
    this.linkedId = linkedId;
    return this;
  }

   /**
   * LinkedID value to assign to the existing event
   * @return linkedId
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "LinkedID value to assign to the existing event")
  @JsonProperty(JSON_PROPERTY_LINKED_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLinkedId() {
    return linkedId;
  }


  @JsonProperty(JSON_PROPERTY_LINKED_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLinkedId(String linkedId) {
    this.linkedId = linkedId;
  }


  public EventUpdateRequest tag(Object tag) {
    this.tag = tag;
    return this;
  }

   /**
   * Full &#x60;tag&#x60; value to be set to the existing event. Replaces any existing &#x60;tag&#x60; payload completely.
   * @return tag
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "Full `tag` value to be set to the existing event. Replaces any existing `tag` payload completely.")
  @JsonProperty(JSON_PROPERTY_TAG)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getTag() {
    return tag;
  }


  @JsonProperty(JSON_PROPERTY_TAG)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTag(Object tag) {
    this.tag = tag;
  }


  public EventUpdateRequest suspect(Boolean suspect) {
    this.suspect = suspect;
    return this;
  }

   /**
   * Suspect flag indicating observed suspicious or fraudulent event
   * @return suspect
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "Suspect flag indicating observed suspicious or fraudulent event")
  @JsonProperty(JSON_PROPERTY_SUSPECT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getSuspect() {
    return suspect;
  }


  @JsonProperty(JSON_PROPERTY_SUSPECT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSuspect(Boolean suspect) {
    this.suspect = suspect;
  }


  /**
   * Return true if this EventUpdateRequest object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventUpdateRequest eventUpdateRequest = (EventUpdateRequest) o;
    return Objects.equals(this.linkedId, eventUpdateRequest.linkedId) &&
        Objects.equals(this.tag, eventUpdateRequest.tag) &&
        Objects.equals(this.suspect, eventUpdateRequest.suspect);
  }

  @Override
  public int hashCode() {
    return Objects.hash(linkedId, tag, suspect);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventUpdateRequest {\n");
    sb.append("    linkedId: ").append(toIndentedString(linkedId)).append("\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
    sb.append("    suspect: ").append(toIndentedString(suspect)).append("\n");
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

