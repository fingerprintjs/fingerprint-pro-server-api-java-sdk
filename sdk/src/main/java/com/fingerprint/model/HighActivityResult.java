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
 * HighActivityResult
 */


@JsonPropertyOrder({
  HighActivityResult.JSON_PROPERTY_RESULT,
  HighActivityResult.JSON_PROPERTY_DAILY_REQUESTS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
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
  @jakarta.annotation.Nonnull
  @Schema(example = "false", required = true, description = "Flag indicating whether the request came from a high activity visitor.")
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
  @jakarta.annotation.Nullable
  @Schema(example = "10", description = "Number of requests from the same visitor in the previous day.")
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

