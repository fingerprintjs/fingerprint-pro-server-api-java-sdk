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
 * Stores bot detection result
 */

@Schema(description = "Stores bot detection result")
@JsonPropertyOrder({
  BotdDetectionResult.JSON_PROPERTY_RESULT,
  BotdDetectionResult.JSON_PROPERTY_TYPE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class BotdDetectionResult {
  /**
   * Bot detection result:  * `notDetected` - the visitor is not a bot  * `good` - good bot detected, such as Google bot, Baidu Spider, AlexaBot and so on  * `bad` - bad bot detected, such as Selenium, Puppeteer, Playwright, headless browsers, and so on 
   */
  public enum ResultEnum {
    NOT_DETECTED("notDetected"),
    
    GOOD("good"),
    
    BAD("bad");

    private String value;

    ResultEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ResultEnum fromValue(String value) {
      for (ResultEnum b : ResultEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  public static final String JSON_PROPERTY_RESULT = "result";
  private ResultEnum result;

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public BotdDetectionResult() {
  }

  public BotdDetectionResult result(ResultEnum result) {
    this.result = result;
    return this;
  }

   /**
   * Bot detection result:  * &#x60;notDetected&#x60; - the visitor is not a bot  * &#x60;good&#x60; - good bot detected, such as Google bot, Baidu Spider, AlexaBot and so on  * &#x60;bad&#x60; - bad bot detected, such as Selenium, Puppeteer, Playwright, headless browsers, and so on 
   * @return result
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "bad", required = true, description = "Bot detection result:  * `notDetected` - the visitor is not a bot  * `good` - good bot detected, such as Google bot, Baidu Spider, AlexaBot and so on  * `bad` - bad bot detected, such as Selenium, Puppeteer, Playwright, headless browsers, and so on ")
  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ResultEnum getResult() {
    return result;
  }


  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setResult(ResultEnum result) {
    this.result = result;
  }


  public BotdDetectionResult type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @jakarta.annotation.Nullable
  @Schema(example = "selenium", description = "")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(String type) {
    this.type = type;
  }


  /**
   * Return true if this BotdDetectionResult object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BotdDetectionResult botdDetectionResult = (BotdDetectionResult) o;
    return Objects.equals(this.result, botdDetectionResult.result) &&
        Objects.equals(this.type, botdDetectionResult.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BotdDetectionResult {\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

