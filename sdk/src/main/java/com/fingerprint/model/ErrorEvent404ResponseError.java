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
 * ErrorEvent404ResponseError
 */


@JsonPropertyOrder({
  ErrorEvent404ResponseError.JSON_PROPERTY_CODE,
  ErrorEvent404ResponseError.JSON_PROPERTY_MESSAGE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class ErrorEvent404ResponseError {
  /**
   * Error code:  * `RequestNotFound` - The specified request ID was not found. It never existed, expired, or it has been deleted. 
   */
  public enum CodeEnum {
    REQUEST_NOT_FOUND("RequestNotFound");

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

  public ErrorEvent404ResponseError() {
  }

  public ErrorEvent404ResponseError code(CodeEnum code) {
    this.code = code;
    return this;
  }

   /**
   * Error code:  * &#x60;RequestNotFound&#x60; - The specified request ID was not found. It never existed, expired, or it has been deleted. 
   * @return code
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "RequestNotFound", required = true, description = "Error code:  * `RequestNotFound` - The specified request ID was not found. It never existed, expired, or it has been deleted. ")
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


  public ErrorEvent404ResponseError message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Get message
   * @return message
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "request id is not found", required = true, description = "")
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
   * Return true if this ErrorEvent404ResponseError object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorEvent404ResponseError errorEvent404ResponseError = (ErrorEvent404ResponseError) o;
    return Objects.equals(this.code, errorEvent404ResponseError.code) &&
        Objects.equals(this.message, errorEvent404ResponseError.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorEvent404ResponseError {\n");
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

