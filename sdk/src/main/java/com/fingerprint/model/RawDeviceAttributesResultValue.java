package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.Error;
import java.util.Arrays;
import org.openapitools.jackson.nullable.JsonNullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * RawDeviceAttributesResultValue
 */


@JsonPropertyOrder({
  RawDeviceAttributesResultValue.JSON_PROPERTY_ERROR,
  RawDeviceAttributesResultValue.JSON_PROPERTY_VALUE
})
@JsonTypeName("RawDeviceAttributesResult_value")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class RawDeviceAttributesResultValue {
  public static final String JSON_PROPERTY_ERROR = "error";
  private Error error;

  public static final String JSON_PROPERTY_VALUE = "value";
  private JsonNullable<Object> value = JsonNullable.<Object>of(null);

  public RawDeviceAttributesResultValue() {
  }

  public RawDeviceAttributesResultValue error(Error error) {
    this.error = error;
    return this;
  }

   /**
   * Get error
   * @return error
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_ERROR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Error getError() {
    return error;
  }


  @JsonProperty(JSON_PROPERTY_ERROR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setError(Error error) {
    this.error = error;
  }


  public RawDeviceAttributesResultValue value(Object value) {
    this.value = JsonNullable.<Object>of(value);
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonIgnore

  public Object getValue() {
        return value.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Object> getValue_JsonNullable() {
    return value;
  }
  
  @JsonProperty(JSON_PROPERTY_VALUE)
  public void setValue_JsonNullable(JsonNullable<Object> value) {
    this.value = value;
  }

  public void setValue(Object value) {
    this.value = JsonNullable.<Object>of(value);
  }


  /**
   * Return true if this RawDeviceAttributesResult_value object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RawDeviceAttributesResultValue rawDeviceAttributesResultValue = (RawDeviceAttributesResultValue) o;
    return Objects.equals(this.error, rawDeviceAttributesResultValue.error) &&
        equalsNullable(this.value, rawDeviceAttributesResultValue.value);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(error, hashCodeNullable(value));
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RawDeviceAttributesResultValue {\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

