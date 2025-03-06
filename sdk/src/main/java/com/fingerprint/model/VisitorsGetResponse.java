package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.Visit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Pagination-related fields `lastTimestamp` and `paginationKey` are included if you use a pagination parameter like `limit` or `before` and there is more data available on the next page.
 */

@Schema(description = "Pagination-related fields `lastTimestamp` and `paginationKey` are included if you use a pagination parameter like `limit` or `before` and there is more data available on the next page.")
@JsonPropertyOrder({
  VisitorsGetResponse.JSON_PROPERTY_VISITOR_ID,
  VisitorsGetResponse.JSON_PROPERTY_VISITS,
  VisitorsGetResponse.JSON_PROPERTY_LAST_TIMESTAMP,
  VisitorsGetResponse.JSON_PROPERTY_PAGINATION_KEY
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class VisitorsGetResponse {
  public static final String JSON_PROPERTY_VISITOR_ID = "visitorId";
  private String visitorId;

  public static final String JSON_PROPERTY_VISITS = "visits";
  private List<Visit> visits = new ArrayList<>();

  public static final String JSON_PROPERTY_LAST_TIMESTAMP = "lastTimestamp";
  private Long lastTimestamp;

  public static final String JSON_PROPERTY_PAGINATION_KEY = "paginationKey";
  private String paginationKey;

  public VisitorsGetResponse() {
  }

  public VisitorsGetResponse visitorId(String visitorId) {
    this.visitorId = visitorId;
    return this;
  }

   /**
   * Get visitorId
   * @return visitorId
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_VISITOR_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getVisitorId() {
    return visitorId;
  }


  @JsonProperty(JSON_PROPERTY_VISITOR_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setVisitorId(String visitorId) {
    this.visitorId = visitorId;
  }


  public VisitorsGetResponse visits(List<Visit> visits) {
    this.visits = visits;
    return this;
  }

  public VisitorsGetResponse addVisitItem(Visit visitsItem) {
    this.visits.add(visitsItem);
    return this;
  }

   /**
   * Get visits
   * @return visits
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_VISITS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<Visit> getVisits() {
    return visits;
  }


  @JsonProperty(JSON_PROPERTY_VISITS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setVisits(List<Visit> visits) {
    this.visits = visits;
  }


  public VisitorsGetResponse lastTimestamp(Long lastTimestamp) {
    this.lastTimestamp = lastTimestamp;
    return this;
  }

   /**
   * ⚠️ Deprecated paging attribute, please use `paginationKey` instead. Timestamp of the last visit in the current page of results. 
   * @return lastTimestamp
   * @deprecated
  **/
  @Deprecated
  @jakarta.annotation.Nullable
  @Schema(description = "⚠️ Deprecated paging attribute, please use `paginationKey` instead. Timestamp of the last visit in the current page of results. ")
  @JsonProperty(JSON_PROPERTY_LAST_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getLastTimestamp() {
    return lastTimestamp;
  }


  @JsonProperty(JSON_PROPERTY_LAST_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLastTimestamp(Long lastTimestamp) {
    this.lastTimestamp = lastTimestamp;
  }


  public VisitorsGetResponse paginationKey(String paginationKey) {
    this.paginationKey = paginationKey;
    return this;
  }

   /**
   * Request ID of the last visit in the current page of results. Use this value in the following request as the `paginationKey` parameter to get the next page of results.
   * @return paginationKey
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "Request ID of the last visit in the current page of results. Use this value in the following request as the `paginationKey` parameter to get the next page of results.")
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
   * Return true if this VisitorsGetResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VisitorsGetResponse visitorsGetResponse = (VisitorsGetResponse) o;
    return Objects.equals(this.visitorId, visitorsGetResponse.visitorId) &&
        Objects.equals(this.visits, visitorsGetResponse.visits) &&
        Objects.equals(this.lastTimestamp, visitorsGetResponse.lastTimestamp) &&
        Objects.equals(this.paginationKey, visitorsGetResponse.paginationKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(visitorId, visits, lastTimestamp, paginationKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VisitorsGetResponse {\n");
    sb.append("    visitorId: ").append(toIndentedString(visitorId)).append("\n");
    sb.append("    visits: ").append(toIndentedString(visits)).append("\n");
    sb.append("    lastTimestamp: ").append(toIndentedString(lastTimestamp)).append("\n");
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

