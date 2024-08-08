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
 * Confidence
 */


@JsonPropertyOrder({
  Confidence.JSON_PROPERTY_SCORE,
  Confidence.JSON_PROPERTY_REVISION
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class Confidence {
  public static final String JSON_PROPERTY_SCORE = "score";
  private Float score;

  public static final String JSON_PROPERTY_REVISION = "revision";
  private String revision;

  public Confidence() {
  }

  public Confidence score(Float score) {
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

  public Float getScore() {
    return score;
  }


  @JsonProperty(JSON_PROPERTY_SCORE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setScore(Float score) {
    this.score = score;
  }


  public Confidence revision(String revision) {
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


  /**
   * Return true if this Confidence object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Confidence confidence = (Confidence) o;
    return Objects.equals(this.score, confidence.score) &&
        Objects.equals(this.revision, confidence.revision);
  }

  @Override
  public int hashCode() {
    return Objects.hash(score, revision);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Confidence {\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
    sb.append("    revision: ").append(toIndentedString(revision)).append("\n");
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

