package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.RelatedVisitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * RelatedVisitorsResponse
 */


@JsonPropertyOrder({
  RelatedVisitorsResponse.JSON_PROPERTY_RELATED_VISITORS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class RelatedVisitorsResponse {
  public static final String JSON_PROPERTY_RELATED_VISITORS = "relatedVisitors";
  private List<RelatedVisitor> relatedVisitors = new ArrayList<>();

  public RelatedVisitorsResponse() {
  }

  public RelatedVisitorsResponse relatedVisitors(List<RelatedVisitor> relatedVisitors) {
    this.relatedVisitors = relatedVisitors;
    return this;
  }

  public RelatedVisitorsResponse addRelatedVisitorItem(RelatedVisitor relatedVisitorsItem) {
    this.relatedVisitors.add(relatedVisitorsItem);
    return this;
  }

   /**
   * Get relatedVisitors
   * @return relatedVisitors
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_RELATED_VISITORS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<RelatedVisitor> getRelatedVisitors() {
    return relatedVisitors;
  }


  @JsonProperty(JSON_PROPERTY_RELATED_VISITORS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRelatedVisitors(List<RelatedVisitor> relatedVisitors) {
    this.relatedVisitors = relatedVisitors;
  }


  /**
   * Return true if this RelatedVisitorsResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RelatedVisitorsResponse relatedVisitorsResponse = (RelatedVisitorsResponse) o;
    return Objects.equals(this.relatedVisitors, relatedVisitorsResponse.relatedVisitors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(relatedVisitors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelatedVisitorsResponse {\n");
    sb.append("    relatedVisitors: ").append(toIndentedString(relatedVisitors)).append("\n");
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

