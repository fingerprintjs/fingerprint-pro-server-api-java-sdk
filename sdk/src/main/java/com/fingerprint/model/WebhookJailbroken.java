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
 * WebhookJailbroken
 */


@JsonPropertyOrder({
  WebhookJailbroken.JSON_PROPERTY_RESULT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class WebhookJailbroken {
  public static final String JSON_PROPERTY_RESULT = "result";
  private Boolean result;

  public WebhookJailbroken() {
  }

  public WebhookJailbroken result(Boolean result) {
    this.result = result;
    return this;
  }

   /**
   * iOS specific jailbreak detection. There are 2 values:    * `true` - Jailbreak detected.   * `false` - No signs of jailbreak or the client is not iOS. 
   * @return result
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "iOS specific jailbreak detection. There are 2 values:    * `true` - Jailbreak detected.   * `false` - No signs of jailbreak or the client is not iOS. ")
  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getResult() {
    return result;
  }


  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResult(Boolean result) {
    this.result = result;
  }


  /**
   * Return true if this WebhookJailbroken object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhookJailbroken webhookJailbroken = (WebhookJailbroken) o;
    return Objects.equals(this.result, webhookJailbroken.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhookJailbroken {\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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

