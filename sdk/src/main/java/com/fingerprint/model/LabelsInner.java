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
 * LabelsInner
 */


@JsonPropertyOrder({
  LabelsInner.JSON_PROPERTY_LABEL,
  LabelsInner.JSON_PROPERTY_PREDICTION,
  LabelsInner.JSON_PROPERTY_ML_SCORE
})
@JsonTypeName("Labels_inner")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class LabelsInner {
  public static final String JSON_PROPERTY_LABEL = "label";
  private String label;

  public static final String JSON_PROPERTY_PREDICTION = "prediction";
  private Boolean prediction;

  public static final String JSON_PROPERTY_ML_SCORE = "mlScore";
  private Double mlScore;

  public LabelsInner() {
  }

  public LabelsInner label(String label) {
    this.label = label;
    return this;
  }

   /**
   * Get label
   * @return label
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_LABEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLabel() {
    return label;
  }


  @JsonProperty(JSON_PROPERTY_LABEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLabel(String label) {
    this.label = label;
  }


  public LabelsInner prediction(Boolean prediction) {
    this.prediction = prediction;
    return this;
  }

   /**
   * Get prediction
   * @return prediction
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_PREDICTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getPrediction() {
    return prediction;
  }


  @JsonProperty(JSON_PROPERTY_PREDICTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrediction(Boolean prediction) {
    this.prediction = prediction;
  }


  public LabelsInner mlScore(Double mlScore) {
    this.mlScore = mlScore;
    return this;
  }

   /**
   * Get mlScore
   * minimum: 0
   * maximum: 1
   * @return mlScore
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_ML_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getMlScore() {
    return mlScore;
  }


  @JsonProperty(JSON_PROPERTY_ML_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMlScore(Double mlScore) {
    this.mlScore = mlScore;
  }


  /**
   * Return true if this Labels_inner object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LabelsInner labelsInner = (LabelsInner) o;
    return Objects.equals(this.label, labelsInner.label) &&
        Objects.equals(this.prediction, labelsInner.prediction) &&
        Objects.equals(this.mlScore, labelsInner.mlScore);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, prediction, mlScore);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LabelsInner {\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    prediction: ").append(toIndentedString(prediction)).append("\n");
    sb.append("    mlScore: ").append(toIndentedString(mlScore)).append("\n");
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

