package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * EventsUpdateRequest
 */


@JsonPropertyOrder({
  EventsUpdateRequest.JSON_PROPERTY_LINKED_ID,
  EventsUpdateRequest.JSON_PROPERTY_TAG,
  EventsUpdateRequest.JSON_PROPERTY_SUSPECT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class EventsUpdateRequest {
  public static final String JSON_PROPERTY_LINKED_ID = "linkedId";
  private String linkedId;

  public static final String JSON_PROPERTY_TAG = "tag";
  private Map<String, Object> tag = null;

  public static final String JSON_PROPERTY_SUSPECT = "suspect";
  private Boolean suspect;

  public EventsUpdateRequest() {
  }

  public EventsUpdateRequest linkedId(String linkedId) {
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


  public EventsUpdateRequest tag(Map<String, Object> tag) {
    this.tag = tag;
    return this;
  }

  public EventsUpdateRequest puttagItem(String key, Object tagItem) {
    if (this.tag == null) {
      this.tag = new HashMap<>();
    }
    this.tag.put(key, tagItem);
    return this;
  }

   /**
   * A customer-provided value or an object that was sent with identification request.
   * @return tag
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "A customer-provided value or an object that was sent with identification request.")
  @JsonProperty(JSON_PROPERTY_TAG)
  @JsonInclude(content = JsonInclude.Include.ALWAYS, value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, Object> getTag() {
    return tag;
  }


  @JsonProperty(JSON_PROPERTY_TAG)
  @JsonInclude(content = JsonInclude.Include.ALWAYS, value = JsonInclude.Include.USE_DEFAULTS)
  public void setTag(Map<String, Object> tag) {
    this.tag = tag;
  }


  public EventsUpdateRequest suspect(Boolean suspect) {
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
   * Return true if this EventsUpdateRequest object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventsUpdateRequest eventsUpdateRequest = (EventsUpdateRequest) o;
    return Objects.equals(this.linkedId, eventsUpdateRequest.linkedId) &&
        Objects.equals(this.tag, eventsUpdateRequest.tag) &&
        Objects.equals(this.suspect, eventsUpdateRequest.suspect);
  }

  @Override
  public int hashCode() {
    return Objects.hash(linkedId, tag, suspect);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventsUpdateRequest {\n");
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

