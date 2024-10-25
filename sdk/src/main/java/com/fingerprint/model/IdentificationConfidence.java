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
 * IdentificationConfidence
 */


@JsonPropertyOrder({
  IdentificationConfidence.JSON_PROPERTY_SCORE,
  IdentificationConfidence.JSON_PROPERTY_REVISION,
  IdentificationConfidence.JSON_PROPERTY_COMMENT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class IdentificationConfidence {
  public static final String JSON_PROPERTY_SCORE = "score";
  private Double score;

  public static final String JSON_PROPERTY_REVISION = "revision";
  private String revision;

  public static final String JSON_PROPERTY_COMMENT = "comment";
  private String comment;

  public IdentificationConfidence() {
  }

  public IdentificationConfidence score(Double score) {
    this.score = score;
    return this;
  }

   /**
   * The confidence score is a floating-point number between 0 and 1 that represents the probability of accurate identification.
   * minimum: 0
   * maximum: 1
   * @return score
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "The confidence score is a floating-point number between 0 and 1 that represents the probability of accurate identification.")
  @JsonProperty(JSON_PROPERTY_SCORE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Double getScore() {
    return score;
  }


  @JsonProperty(JSON_PROPERTY_SCORE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setScore(Double score) {
    this.score = score;
  }


  public IdentificationConfidence revision(String revision) {
    this.revision = revision;
    return this;
  }

   /**
   * The revision name of the method used to calculate the Confidence score. This field is only present for customers who opted in to an alternative calculation method.
   * @return revision
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "The revision name of the method used to calculate the Confidence score. This field is only present for customers who opted in to an alternative calculation method.")
  @JsonProperty(JSON_PROPERTY_REVISION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRevision() {
    return revision;
  }


  @JsonProperty(JSON_PROPERTY_REVISION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRevision(String revision) {
    this.revision = revision;
  }


  public IdentificationConfidence comment(String comment) {
    this.comment = comment;
    return this;
  }

   /**
   * Get comment
   * @return comment
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_COMMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getComment() {
    return comment;
  }


  @JsonProperty(JSON_PROPERTY_COMMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setComment(String comment) {
    this.comment = comment;
  }


  /**
   * Return true if this IdentificationConfidence object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdentificationConfidence identificationConfidence = (IdentificationConfidence) o;
    return Objects.equals(this.score, identificationConfidence.score) &&
        Objects.equals(this.revision, identificationConfidence.revision) &&
        Objects.equals(this.comment, identificationConfidence.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(score, revision, comment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdentificationConfidence {\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
    sb.append("    revision: ").append(toIndentedString(revision)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
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

