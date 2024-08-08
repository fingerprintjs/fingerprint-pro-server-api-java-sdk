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
 * ErrorUpdateEvent409ResponseError
 */


@JsonPropertyOrder({
  ErrorUpdateEvent409ResponseError.JSON_PROPERTY_CODE,
  ErrorUpdateEvent409ResponseError.JSON_PROPERTY_MESSAGE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class ErrorUpdateEvent409ResponseError {
  /**
   * Error code: * `StateNotReady` - The event specified with request id is not ready for updates yet. Try again. This error happens in rare cases when update API is called immediately after receiving the request id on the client. In case you need to send information right away, we recommend using the JS agent API instead. 
   */
  public enum CodeEnum {
    STATE_NOT_READY("StateNotReady");

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

  public ErrorUpdateEvent409ResponseError() {
  }

  public ErrorUpdateEvent409ResponseError code(CodeEnum code) {
    this.code = code;
    return this;
  }

   /**
   * Error code: * &#x60;StateNotReady&#x60; - The event specified with request id is not ready for updates yet. Try again. This error happens in rare cases when update API is called immediately after receiving the request id on the client. In case you need to send information right away, we recommend using the JS agent API instead. 
   * @return code
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "StateNotReady", required = true, description = "Error code: * `StateNotReady` - The event specified with request id is not ready for updates yet. Try again. This error happens in rare cases when update API is called immediately after receiving the request id on the client. In case you need to send information right away, we recommend using the JS agent API instead. ")
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


  public ErrorUpdateEvent409ResponseError message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Get message
   * @return message
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "resource is not mutable yet, try again", required = true, description = "")
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
   * Return true if this ErrorUpdateEvent409ResponseError object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorUpdateEvent409ResponseError errorUpdateEvent409ResponseError = (ErrorUpdateEvent409ResponseError) o;
    return Objects.equals(this.code, errorUpdateEvent409ResponseError.code) &&
        Objects.equals(this.message, errorUpdateEvent409ResponseError.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorUpdateEvent409ResponseError {\n");
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

