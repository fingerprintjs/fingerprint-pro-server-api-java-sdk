package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.SupplementaryID;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Other identities that have been established for a given Visitor.
 */

@Schema(description = "Other identities that have been established for a given Visitor.")
@JsonPropertyOrder({
  WebhookSupplementaryIDs.JSON_PROPERTY_STANDARD,
  WebhookSupplementaryIDs.JSON_PROPERTY_HIGH_RECALL
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class WebhookSupplementaryIDs {
  public static final String JSON_PROPERTY_STANDARD = "standard";
  private SupplementaryID standard;

  public static final String JSON_PROPERTY_HIGH_RECALL = "highRecall";
  private SupplementaryID highRecall;

  public WebhookSupplementaryIDs() {
  }

  public WebhookSupplementaryIDs standard(SupplementaryID standard) {
    this.standard = standard;
    return this;
  }

   /**
   * Get standard
   * @return standard
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_STANDARD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public SupplementaryID getStandard() {
    return standard;
  }


  @JsonProperty(JSON_PROPERTY_STANDARD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStandard(SupplementaryID standard) {
    this.standard = standard;
  }


  public WebhookSupplementaryIDs highRecall(SupplementaryID highRecall) {
    this.highRecall = highRecall;
    return this;
  }

   /**
   * Get highRecall
   * @return highRecall
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_HIGH_RECALL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public SupplementaryID getHighRecall() {
    return highRecall;
  }


  @JsonProperty(JSON_PROPERTY_HIGH_RECALL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setHighRecall(SupplementaryID highRecall) {
    this.highRecall = highRecall;
  }


  /**
   * Return true if this WebhookSupplementaryIDs object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhookSupplementaryIDs webhookSupplementaryIDs = (WebhookSupplementaryIDs) o;
    return Objects.equals(this.standard, webhookSupplementaryIDs.standard) &&
        Objects.equals(this.highRecall, webhookSupplementaryIDs.highRecall);
  }

  @Override
  public int hashCode() {
    return Objects.hash(standard, highRecall);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhookSupplementaryIDs {\n");
    sb.append("    standard: ").append(toIndentedString(standard)).append("\n");
    sb.append("    highRecall: ").append(toIndentedString(highRecall)).append("\n");
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

