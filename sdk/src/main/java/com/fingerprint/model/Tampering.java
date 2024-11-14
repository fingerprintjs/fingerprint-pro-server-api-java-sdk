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
 * Tampering
 */


@JsonPropertyOrder({
  Tampering.JSON_PROPERTY_RESULT,
  Tampering.JSON_PROPERTY_ANOMALY_SCORE,
  Tampering.JSON_PROPERTY_ANTI_DETECT_BROWSER
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class Tampering {
  public static final String JSON_PROPERTY_RESULT = "result";
  private Boolean result;

  public static final String JSON_PROPERTY_ANOMALY_SCORE = "anomalyScore";
  private Double anomalyScore;

  public static final String JSON_PROPERTY_ANTI_DETECT_BROWSER = "antiDetectBrowser";
  private Boolean antiDetectBrowser;

  public Tampering() {
  }

  public Tampering result(Boolean result) {
    this.result = result;
    return this;
  }

   /**
   * Flag indicating browser tampering was detected. This happens when either of these conditions is true:   * There are inconsistencies in the browser configuration that cross our internal tampering thresholds (indicated by &#x60;anomalyScore&#x60;).   * The browser signature resembles one of \&quot;anti-detect\&quot; browsers specifically designed to evade identification and fingerprinting, for example, Incognition (indicated by &#x60;antiDetectBrowser&#x60;). 
   * @return result
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "Flag indicating browser tampering was detected. This happens when either of these conditions is true:   * There are inconsistencies in the browser configuration that cross our internal tampering thresholds (indicated by `anomalyScore`).   * The browser signature resembles one of \"anti-detect\" browsers specifically designed to evade identification and fingerprinting, for example, Incognition (indicated by `antiDetectBrowser`). ")
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


  public Tampering anomalyScore(Double anomalyScore) {
    this.anomalyScore = anomalyScore;
    return this;
  }

   /**
   * Confidence score (&#x60;0.0 - 1.0&#x60;) for tampering detection:   * Values above &#x60;0.5&#x60; indicate that there was a tampering attempt.    * Values below &#x60;0.5&#x60; indicate genuine browsers. 
   * minimum: 0
   * maximum: 1
   * @return anomalyScore
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "Confidence score (`0.0 - 1.0`) for tampering detection:   * Values above `0.5` indicate that there was a tampering attempt.    * Values below `0.5` indicate genuine browsers. ")
  @JsonProperty(JSON_PROPERTY_ANOMALY_SCORE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Double getAnomalyScore() {
    return anomalyScore;
  }


  @JsonProperty(JSON_PROPERTY_ANOMALY_SCORE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAnomalyScore(Double anomalyScore) {
    this.anomalyScore = anomalyScore;
  }


  public Tampering antiDetectBrowser(Boolean antiDetectBrowser) {
    this.antiDetectBrowser = antiDetectBrowser;
    return this;
  }

   /**
   * Is &#x60;true&#x60; if the identified browser resembles one of \&quot;anti-detect\&quot; browsers, for example, Incognition.  Anti-detect browsers try to evade identification by masking or manipulating their fingerprint to imitate legitimate browser configurations.
   * @return antiDetectBrowser
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "Is `true` if the identified browser resembles one of \"anti-detect\" browsers, for example, Incognition.  Anti-detect browsers try to evade identification by masking or manipulating their fingerprint to imitate legitimate browser configurations.")
  @JsonProperty(JSON_PROPERTY_ANTI_DETECT_BROWSER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getAntiDetectBrowser() {
    return antiDetectBrowser;
  }


  @JsonProperty(JSON_PROPERTY_ANTI_DETECT_BROWSER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAntiDetectBrowser(Boolean antiDetectBrowser) {
    this.antiDetectBrowser = antiDetectBrowser;
  }


  /**
   * Return true if this Tampering object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tampering tampering = (Tampering) o;
    return Objects.equals(this.result, tampering.result) &&
        Objects.equals(this.anomalyScore, tampering.anomalyScore) &&
        Objects.equals(this.antiDetectBrowser, tampering.antiDetectBrowser);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, anomalyScore, antiDetectBrowser);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tampering {\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    anomalyScore: ").append(toIndentedString(anomalyScore)).append("\n");
    sb.append("    antiDetectBrowser: ").append(toIndentedString(antiDetectBrowser)).append("\n");
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

