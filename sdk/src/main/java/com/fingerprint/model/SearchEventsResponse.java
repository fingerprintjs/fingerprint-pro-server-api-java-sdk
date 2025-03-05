package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.SearchEventsResponseEventsInner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Contains a list of all identification events matching the specified search criteria.
 */

@Schema(description = "Contains a list of all identification events matching the specified search criteria.")
@JsonPropertyOrder({
  SearchEventsResponse.JSON_PROPERTY_EVENTS,
  SearchEventsResponse.JSON_PROPERTY_PAGINATION_KEY
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class SearchEventsResponse {
  public static final String JSON_PROPERTY_EVENTS = "events";
  private List<SearchEventsResponseEventsInner> events = null;

  public static final String JSON_PROPERTY_PAGINATION_KEY = "paginationKey";
  private String paginationKey;

  public SearchEventsResponse() {
  }

  public SearchEventsResponse events(List<SearchEventsResponseEventsInner> events) {
    this.events = events;
    return this;
  }

  public SearchEventsResponse addSearchEventsResponseEventsInnerItem(SearchEventsResponseEventsInner eventsItem) {
    if (this.events == null) {
      this.events = new ArrayList<>();
    }
    this.events.add(eventsItem);
    return this;
  }

   /**
   * Get events
   * @return events
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_EVENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<SearchEventsResponseEventsInner> getEvents() {
    return events;
  }


  @JsonProperty(JSON_PROPERTY_EVENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEvents(List<SearchEventsResponseEventsInner> events) {
    this.events = events;
  }


  public SearchEventsResponse paginationKey(String paginationKey) {
    this.paginationKey = paginationKey;
    return this;
  }

   /**
   * Use this value in the &#x60;pagination_key&#x60; parameter to request the next page of search results.
   * @return paginationKey
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "Use this value in the `pagination_key` parameter to request the next page of search results.")
  @JsonProperty(JSON_PROPERTY_PAGINATION_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPaginationKey() {
    return paginationKey;
  }


  @JsonProperty(JSON_PROPERTY_PAGINATION_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPaginationKey(String paginationKey) {
    this.paginationKey = paginationKey;
  }


  /**
   * Return true if this SearchEventsResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchEventsResponse searchEventsResponse = (SearchEventsResponse) o;
    return Objects.equals(this.events, searchEventsResponse.events) &&
        Objects.equals(this.paginationKey, searchEventsResponse.paginationKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(events, paginationKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchEventsResponse {\n");
    sb.append("    events: ").append(toIndentedString(events)).append("\n");
    sb.append("    paginationKey: ").append(toIndentedString(paginationKey)).append("\n");
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

