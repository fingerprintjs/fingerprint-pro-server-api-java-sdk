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
 * ErrorCommon429ResponseError
 */


@JsonPropertyOrder({
  ErrorCommon429ResponseError.JSON_PROPERTY_CODE,
  ErrorCommon429ResponseError.JSON_PROPERTY_MESSAGE
})
@JsonTypeName("ErrorCommon429Response_error")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class ErrorCommon429ResponseError {
  /**
   * Error code: * `TooManyRequests` - The request is throttled. 
   */
  public enum CodeEnum {
    TOO_MANY_REQUESTS("TooManyRequests");

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

  public ErrorCommon429ResponseError() {
  }

  public ErrorCommon429ResponseError code(CodeEnum code) {
    this.code = code;
    return this;
  }

   /**
   * Error code: * &#x60;TooManyRequests&#x60; - The request is throttled. 
   * @return code
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "TooManyRequests", required = true, description = "Error code: * `TooManyRequests` - The request is throttled. ")
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


  public ErrorCommon429ResponseError message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Get message
   * @return message
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "request throttled", required = true, description = "")
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
   * Return true if this ErrorCommon429Response_error object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorCommon429ResponseError errorCommon429ResponseError = (ErrorCommon429ResponseError) o;
    return Objects.equals(this.code, errorCommon429ResponseError.code) &&
        Objects.equals(this.message, errorCommon429ResponseError.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorCommon429ResponseError {\n");
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

