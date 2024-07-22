/*
 * Fingerprint Pro Server API
 * Fingerprint Pro Server API allows you to get information about visitors and about individual events in a server environment. It can be used for data exports, decision-making, and data analysis scenarios. Server API is intended for server-side usage, it's not intended to be used from the client side, whether it's a browser or a mobile device. 
 *
 * The version of the OpenAPI document: 3
 * Contact: support@fingerprint.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.fingerprint.model;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;


/**
 * HighActivityResult
 */
@JsonPropertyOrder({
  HighActivityResult.JSON_PROPERTY_RESULT,
  HighActivityResult.JSON_PROPERTY_DAILY_REQUESTS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class HighActivityResult {
  public static final String JSON_PROPERTY_RESULT = "result";
  private Boolean result;

  public static final String JSON_PROPERTY_DAILY_REQUESTS = "dailyRequests";
  private BigDecimal dailyRequests;

  public HighActivityResult() {
  }

  public HighActivityResult result(Boolean result) {
    this.result = result;
    return this;
  }

   /**
   * Flag indicating whether the request came from a high activity visitor.
   * @return result
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "false", required = true, value = "Flag indicating whether the request came from a high activity visitor.")
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


  public HighActivityResult dailyRequests(BigDecimal dailyRequests) {
    this.dailyRequests = dailyRequests;
    return this;
  }

   /**
   * Number of requests from the same visitor in the previous day.
   * minimum: 1
   * @return dailyRequests
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "10", value = "Number of requests from the same visitor in the previous day.")
  @JsonProperty(JSON_PROPERTY_DAILY_REQUESTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BigDecimal getDailyRequests() {
    return dailyRequests;
  }


  @JsonProperty(JSON_PROPERTY_DAILY_REQUESTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDailyRequests(BigDecimal dailyRequests) {
    this.dailyRequests = dailyRequests;
  }


  /**
   * Return true if this HighActivityResult object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HighActivityResult highActivityResult = (HighActivityResult) o;
    return Objects.equals(this.result, highActivityResult.result) &&
        Objects.equals(this.dailyRequests, highActivityResult.dailyRequests);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, dailyRequests);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HighActivityResult {\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    dailyRequests: ").append(toIndentedString(dailyRequests)).append("\n");
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

