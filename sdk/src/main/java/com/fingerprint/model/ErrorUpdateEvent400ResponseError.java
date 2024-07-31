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
 * ErrorUpdateEvent400ResponseError
 */


@JsonPropertyOrder({
  ErrorUpdateEvent400ResponseError.JSON_PROPERTY_CODE,
  ErrorUpdateEvent400ResponseError.JSON_PROPERTY_MESSAGE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class ErrorUpdateEvent400ResponseError {
  /**
   * Error code: * `RequestCannotBeParsed` - the JSON content of the request contains some errors that prevented us from parsing it (wrong type/surpassed limits) * `Failed` - the event is more than 10 days old and cannot be updated 
   */
  public enum CodeEnum {
    REQUEST_CANNOT_BE_PARSED("RequestCannotBeParsed"),
    
    FAILED("Failed");

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

  public ErrorUpdateEvent400ResponseError() {
  }

  public ErrorUpdateEvent400ResponseError code(CodeEnum code) {
    this.code = code;
    return this;
  }

   /**
   * Error code: * &#x60;RequestCannotBeParsed&#x60; - the JSON content of the request contains some errors that prevented us from parsing it (wrong type/surpassed limits) * &#x60;Failed&#x60; - the event is more than 10 days old and cannot be updated 
   * @return code
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "RequestCannotBeParsed", required = true, description = "Error code: * `RequestCannotBeParsed` - the JSON content of the request contains some errors that prevented us from parsing it (wrong type/surpassed limits) * `Failed` - the event is more than 10 days old and cannot be updated ")
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


  public ErrorUpdateEvent400ResponseError message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Details about the underlying issue with the input payload
   * @return message
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "suspect flag must be a boolean", required = true, description = "Details about the underlying issue with the input payload")
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
   * Return true if this ErrorUpdateEvent400ResponseError object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorUpdateEvent400ResponseError errorUpdateEvent400ResponseError = (ErrorUpdateEvent400ResponseError) o;
    return Objects.equals(this.code, errorUpdateEvent400ResponseError.code) &&
        Objects.equals(this.message, errorUpdateEvent400ResponseError.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorUpdateEvent400ResponseError {\n");
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

