package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.FactoryResetResult;
import com.fingerprint.model.ProductError;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * SignalResponseFactoryReset
 */


@JsonPropertyOrder({
  SignalResponseFactoryReset.JSON_PROPERTY_DATA,
  SignalResponseFactoryReset.JSON_PROPERTY_ERROR
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class SignalResponseFactoryReset {
  public static final String JSON_PROPERTY_DATA = "data";
  private FactoryResetResult data;

  public static final String JSON_PROPERTY_ERROR = "error";
  private ProductError error;

  public SignalResponseFactoryReset() {
  }

  public SignalResponseFactoryReset data(FactoryResetResult data) {
    this.data = data;
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public FactoryResetResult getData() {
    return data;
  }


  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setData(FactoryResetResult data) {
    this.data = data;
  }


  public SignalResponseFactoryReset error(ProductError error) {
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

  public ProductError getError() {
    return error;
  }


  @JsonProperty(JSON_PROPERTY_ERROR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setError(ProductError error) {
    this.error = error;
  }


  /**
   * Return true if this SignalResponseFactoryReset object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignalResponseFactoryReset signalResponseFactoryReset = (SignalResponseFactoryReset) o;
    return Objects.equals(this.data, signalResponseFactoryReset.data) &&
        Objects.equals(this.error, signalResponseFactoryReset.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignalResponseFactoryReset {\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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

