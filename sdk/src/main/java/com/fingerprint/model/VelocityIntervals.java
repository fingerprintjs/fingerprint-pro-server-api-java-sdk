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
 * Is absent if the velocity data could not be generated for the visitor ID. 
 */

@Schema(description = "Is absent if the velocity data could not be generated for the visitor ID. ")
@JsonPropertyOrder({
  VelocityIntervals.JSON_PROPERTY_5M,
  VelocityIntervals.JSON_PROPERTY_1H,
  VelocityIntervals.JSON_PROPERTY_24H
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class VelocityIntervals {
  public static final String JSON_PROPERTY_5M = "5m";
  private Integer _5m;

  public static final String JSON_PROPERTY_1H = "1h";
  private Integer _1h;

  public static final String JSON_PROPERTY_24H = "24h";
  private Integer _24h;

  public VelocityIntervals() {
  }

  public VelocityIntervals _5m(Integer _5m) {
    this._5m = _5m;
    return this;
  }

   /**
   * Get _5m
   * @return _5m
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_5M)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer get5m() {
    return _5m;
  }


  @JsonProperty(JSON_PROPERTY_5M)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void set5m(Integer _5m) {
    this._5m = _5m;
  }


  public VelocityIntervals _1h(Integer _1h) {
    this._1h = _1h;
    return this;
  }

   /**
   * Get _1h
   * @return _1h
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_1H)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer get1h() {
    return _1h;
  }


  @JsonProperty(JSON_PROPERTY_1H)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void set1h(Integer _1h) {
    this._1h = _1h;
  }


  public VelocityIntervals _24h(Integer _24h) {
    this._24h = _24h;
    return this;
  }

   /**
   * The &#x60;24h&#x60; interval of &#x60;distinctIp&#x60;, &#x60;distinctLinkedId&#x60;, &#x60;distinctCountry&#x60;, &#x60;distinctIpByLinkedId&#x60; and &#x60;distinctVisitorIdByLinkedId&#x60; will be omitted if the number of &#x60;events&#x60;&#x60; for the visitor ID in the last 24 hours (&#x60;events.intervals.[&#39;24h&#39;]&#x60;) is higher than 20.000. 
   * @return _24h
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "The `24h` interval of `distinctIp`, `distinctLinkedId`, `distinctCountry`, `distinctIpByLinkedId` and `distinctVisitorIdByLinkedId` will be omitted if the number of `events`` for the visitor ID in the last 24 hours (`events.intervals.['24h']`) is higher than 20.000. ")
  @JsonProperty(JSON_PROPERTY_24H)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer get24h() {
    return _24h;
  }


  @JsonProperty(JSON_PROPERTY_24H)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void set24h(Integer _24h) {
    this._24h = _24h;
  }


  /**
   * Return true if this VelocityIntervals object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VelocityIntervals velocityIntervals = (VelocityIntervals) o;
    return Objects.equals(this._5m, velocityIntervals._5m) &&
        Objects.equals(this._1h, velocityIntervals._1h) &&
        Objects.equals(this._24h, velocityIntervals._24h);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_5m, _1h, _24h);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VelocityIntervals {\n");
    sb.append("    _5m: ").append(toIndentedString(_5m)).append("\n");
    sb.append("    _1h: ").append(toIndentedString(_1h)).append("\n");
    sb.append("    _24h: ").append(toIndentedString(_24h)).append("\n");
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

