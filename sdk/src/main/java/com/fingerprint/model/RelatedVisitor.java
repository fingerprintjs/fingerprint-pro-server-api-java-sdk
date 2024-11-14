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
 * RelatedVisitor
 */


@JsonPropertyOrder({
  RelatedVisitor.JSON_PROPERTY_VISITOR_ID
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class RelatedVisitor {
  public static final String JSON_PROPERTY_VISITOR_ID = "visitorId";
  private String visitorId;

  public RelatedVisitor() {
  }

  public RelatedVisitor visitorId(String visitorId) {
    this.visitorId = visitorId;
    return this;
  }

   /**
   * Visitor ID of a browser that originates from the same mobile device as the input visitor ID.
   * @return visitorId
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "Visitor ID of a browser that originates from the same mobile device as the input visitor ID.")
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


  /**
   * Return true if this RelatedVisitor object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RelatedVisitor relatedVisitor = (RelatedVisitor) o;
    return Objects.equals(this.visitorId, relatedVisitor.visitorId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(visitorId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelatedVisitor {\n");
    sb.append("    visitorId: ").append(toIndentedString(visitorId)).append("\n");
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

