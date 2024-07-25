package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.math.BigDecimal;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * TamperingResult
 */


@JsonPropertyOrder({
  TamperingResult.JSON_PROPERTY_RESULT,
  TamperingResult.JSON_PROPERTY_ANOMALY_SCORE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class TamperingResult {
  public static final String JSON_PROPERTY_RESULT = "result";
  private Boolean result;

  public static final String JSON_PROPERTY_ANOMALY_SCORE = "anomalyScore";
  private BigDecimal anomalyScore;

  public TamperingResult() {
  }

  public TamperingResult result(Boolean result) {
    this.result = result;
    return this;
  }

   /**
   * Flag indicating whether browser tampering was detected according to our internal thresholds.
   * @return result
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "false", required = true, description = "Flag indicating whether browser tampering was detected according to our internal thresholds.")
  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getResult() {
    return result;
  }


  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setResult(Boolean result) {
    this.result = result;
  }


  public TamperingResult anomalyScore(BigDecimal anomalyScore) {
    this.anomalyScore = anomalyScore;
    return this;
  }

   /**
   * Confidence score (&#x60;0.0 - 1.0&#x60;) for the tampering detection. Values above &#x60;0.5&#x60; suggest that we&#39;re reasonably sure there was a tampering attempt. Values below &#x60;0.5&#x60; are genuine browsers.
   * minimum: 0
   * maximum: 1
   * @return anomalyScore
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "0", required = true, description = "Confidence score (`0.0 - 1.0`) for the tampering detection. Values above `0.5` suggest that we're reasonably sure there was a tampering attempt. Values below `0.5` are genuine browsers.")
  @JsonProperty(JSON_PROPERTY_ANOMALY_SCORE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BigDecimal getAnomalyScore() {
    return anomalyScore;
  }


  @JsonProperty(JSON_PROPERTY_ANOMALY_SCORE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAnomalyScore(BigDecimal anomalyScore) {
    this.anomalyScore = anomalyScore;
  }


  /**
   * Return true if this TamperingResult object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TamperingResult tamperingResult = (TamperingResult) o;
    return Objects.equals(this.result, tamperingResult.result) &&
        Objects.equals(this.anomalyScore, tamperingResult.anomalyScore);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, anomalyScore);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TamperingResult {\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    anomalyScore: ").append(toIndentedString(anomalyScore)).append("\n");
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

