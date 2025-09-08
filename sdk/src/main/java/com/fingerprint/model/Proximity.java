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
 * Proximity ID represents a fixed geographical zone in a discrete global grid within which the device is observed. 
 */

@Schema(description = "Proximity ID represents a fixed geographical zone in a discrete global grid within which the device is observed. ")
@JsonPropertyOrder({
  Proximity.JSON_PROPERTY_ID,
  Proximity.JSON_PROPERTY_PRECISION_RADIUS,
  Proximity.JSON_PROPERTY_CONFIDENCE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class Proximity {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  /**
   * The radius of the proximity zone’s precision level, in meters. 
   */
  public enum PrecisionRadiusEnum {
    NUMBER_10(10),
    
    NUMBER_25(25),
    
    NUMBER_65(65),
    
    NUMBER_175(175),
    
    NUMBER_450(450),
    
    NUMBER_1200(1200),
    
    NUMBER_3300(3300),
    
    NUMBER_8500(8500),
    
    NUMBER_22500(22500);

    private Integer value;

    PrecisionRadiusEnum(Integer value) {
      this.value = value;
    }

    @JsonValue
    public Integer getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PrecisionRadiusEnum fromValue(Integer value) {
      for (PrecisionRadiusEnum b : PrecisionRadiusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  public static final String JSON_PROPERTY_PRECISION_RADIUS = "precisionRadius";
  private PrecisionRadiusEnum precisionRadius;

  public static final String JSON_PROPERTY_CONFIDENCE = "confidence";
  private Float confidence;

  public Proximity() {
  }

  public Proximity id(String id) {
    this.id = id;
    return this;
  }

   /**
   * A stable privacy-preserving identifier for a given proximity zone. 
   * @return id
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "A stable privacy-preserving identifier for a given proximity zone. ")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setId(String id) {
    this.id = id;
  }


  public Proximity precisionRadius(PrecisionRadiusEnum precisionRadius) {
    this.precisionRadius = precisionRadius;
    return this;
  }

   /**
   * The radius of the proximity zone’s precision level, in meters. 
   * @return precisionRadius
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "The radius of the proximity zone’s precision level, in meters. ")
  @JsonProperty(JSON_PROPERTY_PRECISION_RADIUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public PrecisionRadiusEnum getPrecisionRadius() {
    return precisionRadius;
  }


  @JsonProperty(JSON_PROPERTY_PRECISION_RADIUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPrecisionRadius(PrecisionRadiusEnum precisionRadius) {
    this.precisionRadius = precisionRadius;
  }


  public Proximity confidence(Float confidence) {
    this.confidence = confidence;
    return this;
  }

   /**
   * A value between `0` and `1` representing the likelihood that the true device location lies within the mapped proximity zone.   * Scores closer to `1` indicate high confidence that the location is inside the mapped proximity zone.   * Scores closer to `0` indicate lower confidence, suggesting the true location may fall in an adjacent zone. 
   * minimum: 0
   * maximum: 1
   * @return confidence
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "A value between `0` and `1` representing the likelihood that the true device location lies within the mapped proximity zone.   * Scores closer to `1` indicate high confidence that the location is inside the mapped proximity zone.   * Scores closer to `0` indicate lower confidence, suggesting the true location may fall in an adjacent zone. ")
  @JsonProperty(JSON_PROPERTY_CONFIDENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Float getConfidence() {
    return confidence;
  }


  @JsonProperty(JSON_PROPERTY_CONFIDENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setConfidence(Float confidence) {
    this.confidence = confidence;
  }


  /**
   * Return true if this Proximity object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Proximity proximity = (Proximity) o;
    return Objects.equals(this.id, proximity.id) &&
        Objects.equals(this.precisionRadius, proximity.precisionRadius) &&
        Objects.equals(this.confidence, proximity.confidence);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, precisionRadius, confidence);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Proximity {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    precisionRadius: ").append(toIndentedString(precisionRadius)).append("\n");
    sb.append("    confidence: ").append(toIndentedString(confidence)).append("\n");
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

