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
 * HighActivity
 */


@JsonPropertyOrder({
  HighActivity.JSON_PROPERTY_RESULT,
  HighActivity.JSON_PROPERTY_DAILY_REQUESTS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class HighActivity {
  public static final String JSON_PROPERTY_RESULT = "result";
  private Boolean result;

  public static final String JSON_PROPERTY_DAILY_REQUESTS = "dailyRequests";
  private Long dailyRequests;

  public HighActivity() {
  }

  public HighActivity result(Boolean result) {
    this.result = result;
    return this;
  }

   /**
   * Flag indicating if the request came from a high-activity visitor.
   * @return result
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "Flag indicating if the request came from a high-activity visitor.")
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


  public HighActivity dailyRequests(Long dailyRequests) {
    this.dailyRequests = dailyRequests;
    return this;
  }

   /**
   * Number of requests from the same visitor in the previous day.
   * minimum: 1
   * @return dailyRequests
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "Number of requests from the same visitor in the previous day.")
  @JsonProperty(JSON_PROPERTY_DAILY_REQUESTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getDailyRequests() {
    return dailyRequests;
  }


  @JsonProperty(JSON_PROPERTY_DAILY_REQUESTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDailyRequests(Long dailyRequests) {
    this.dailyRequests = dailyRequests;
  }


  /**
   * Return true if this HighActivity object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HighActivity highActivity = (HighActivity) o;
    return Objects.equals(this.result, highActivity.result) &&
        Objects.equals(this.dailyRequests, highActivity.dailyRequests);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, dailyRequests);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HighActivity {\n");
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

