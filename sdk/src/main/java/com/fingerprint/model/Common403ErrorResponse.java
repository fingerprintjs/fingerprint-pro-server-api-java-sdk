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
 * Common403ErrorResponse
 */


@JsonPropertyOrder({
  Common403ErrorResponse.JSON_PROPERTY_CODE,
  Common403ErrorResponse.JSON_PROPERTY_MESSAGE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class Common403ErrorResponse {
  /**
   * Error code:  * `TokenRequired` - `Auth-API-Key` header is missing or empty  * `TokenNotFound` - No Fingerprint application found for specified secret key  * `SubscriptionNotActive` - Fingerprint application is not active  * `WrongRegion` - server and application region differ  * `FeatureNotEnabled` - this feature (for example, Delete API) is not enabled for your application 
   */
  public enum CodeEnum {
    TOKEN_REQUIRED("TokenRequired"),
    
    TOKEN_NOT_FOUND("TokenNotFound"),
    
    SUBSCRIPTION_NOT_ACTIVE("SubscriptionNotActive"),
    
    WRONG_REGION("WrongRegion"),
    
    FEATURE_NOT_ENABLED("FeatureNotEnabled");

    private String value;

    CodeEnum(String value) {
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
    public static CodeEnum fromValue(String value) {
      for (CodeEnum b : CodeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  public static final String JSON_PROPERTY_CODE = "code";
  private CodeEnum code;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  private String message;

  public Common403ErrorResponse() {
  }

  public Common403ErrorResponse code(CodeEnum code) {
    this.code = code;
    return this;
  }

   /**
   * Error code:  * &#x60;TokenRequired&#x60; - &#x60;Auth-API-Key&#x60; header is missing or empty  * &#x60;TokenNotFound&#x60; - No Fingerprint application found for specified secret key  * &#x60;SubscriptionNotActive&#x60; - Fingerprint application is not active  * &#x60;WrongRegion&#x60; - server and application region differ  * &#x60;FeatureNotEnabled&#x60; - this feature (for example, Delete API) is not enabled for your application 
   * @return code
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "TokenRequired", required = true, description = "Error code:  * `TokenRequired` - `Auth-API-Key` header is missing or empty  * `TokenNotFound` - No Fingerprint application found for specified secret key  * `SubscriptionNotActive` - Fingerprint application is not active  * `WrongRegion` - server and application region differ  * `FeatureNotEnabled` - this feature (for example, Delete API) is not enabled for your application ")
  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public CodeEnum getCode() {
    return code;
  }


  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCode(CodeEnum code) {
    this.code = code;
  }


  public Common403ErrorResponse message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Get message
   * @return message
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "secret key is required", required = true, description = "")
  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getMessage() {
    return message;
  }


  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMessage(String message) {
    this.message = message;
  }


  /**
   * Return true if this Common403ErrorResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Common403ErrorResponse common403ErrorResponse = (Common403ErrorResponse) o;
    return Objects.equals(this.code, common403ErrorResponse.code) &&
        Objects.equals(this.message, common403ErrorResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Common403ErrorResponse {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

