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
 * ErrorVisitor400ResponseError
 */


@JsonPropertyOrder({
  ErrorVisitor400ResponseError.JSON_PROPERTY_CODE,
  ErrorVisitor400ResponseError.JSON_PROPERTY_MESSAGE
})
@JsonTypeName("ErrorVisitor400Response_error")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class ErrorVisitor400ResponseError {
  /**
   * Error code: * `RequestCannotBeParsed` - The visitor ID parameter is missing or in the wrong format. 
   */
  public enum CodeEnum {
    REQUEST_CANNOT_BE_PARSED("RequestCannotBeParsed");

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

  public ErrorVisitor400ResponseError() {
  }

  public ErrorVisitor400ResponseError code(CodeEnum code) {
    this.code = code;
    return this;
  }

   /**
   * Error code: * &#x60;RequestCannotBeParsed&#x60; - The visitor ID parameter is missing or in the wrong format. 
   * @return code
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "RequestCannotBeParsed", required = true, description = "Error code: * `RequestCannotBeParsed` - The visitor ID parameter is missing or in the wrong format. ")
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


  public ErrorVisitor400ResponseError message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Get message
   * @return message
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "invalid visitor id", required = true, description = "")
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
   * Return true if this ErrorVisitor400Response_error object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorVisitor400ResponseError errorVisitor400ResponseError = (ErrorVisitor400ResponseError) o;
    return Objects.equals(this.code, errorVisitor400ResponseError.code) &&
        Objects.equals(this.message, errorVisitor400ResponseError.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorVisitor400ResponseError {\n");
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

