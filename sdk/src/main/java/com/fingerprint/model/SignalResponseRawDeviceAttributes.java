package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.IdentificationError;
import com.fingerprint.model.RawDeviceAttributesResultValue;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * SignalResponseRawDeviceAttributes
 */


@JsonPropertyOrder({
  SignalResponseRawDeviceAttributes.JSON_PROPERTY_DATA,
  SignalResponseRawDeviceAttributes.JSON_PROPERTY_ERROR
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class SignalResponseRawDeviceAttributes {
  public static final String JSON_PROPERTY_DATA = "data";
  private Map<String, RawDeviceAttributesResultValue> data = null;

  public static final String JSON_PROPERTY_ERROR = "error";
  private IdentificationError error;

  public SignalResponseRawDeviceAttributes() {
  }

  public SignalResponseRawDeviceAttributes data(Map<String, RawDeviceAttributesResultValue> data) {
    this.data = data;
    return this;
  }

  public SignalResponseRawDeviceAttributes putdataItem(String key, RawDeviceAttributesResultValue dataItem) {
    if (this.data == null) {
      this.data = new HashMap<>();
    }
    this.data.put(key, dataItem);
    return this;
  }

   /**
   * It includes 35+ raw browser identification attributes to provide Fingerprint users with even more information than our standard visitor ID provides. This enables Fingerprint users to not have to run our open-source product in conjunction with Fingerprint Pro Plus and Enterprise to get those additional attributes. Warning: The raw signals data can change at any moment as we improve the product. We cannot guarantee the internal shape of raw device attributes to be stable, so typical semantic versioning rules do not apply here. Use this data with caution without assuming a specific structure beyond the generic type provided here. 
   * @return data
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "It includes 35+ raw browser identification attributes to provide Fingerprint users with even more information than our standard visitor ID provides. This enables Fingerprint users to not have to run our open-source product in conjunction with Fingerprint Pro Plus and Enterprise to get those additional attributes. Warning: The raw signals data can change at any moment as we improve the product. We cannot guarantee the internal shape of raw device attributes to be stable, so typical semantic versioning rules do not apply here. Use this data with caution without assuming a specific structure beyond the generic type provided here. ")
  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, RawDeviceAttributesResultValue> getData() {
    return data;
  }


  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setData(Map<String, RawDeviceAttributesResultValue> data) {
    this.data = data;
  }


  public SignalResponseRawDeviceAttributes error(IdentificationError error) {
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

  public IdentificationError getError() {
    return error;
  }


  @JsonProperty(JSON_PROPERTY_ERROR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setError(IdentificationError error) {
    this.error = error;
  }


  /**
   * Return true if this SignalResponseRawDeviceAttributes object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignalResponseRawDeviceAttributes signalResponseRawDeviceAttributes = (SignalResponseRawDeviceAttributes) o;
    return Objects.equals(this.data, signalResponseRawDeviceAttributes.data) &&
        Objects.equals(this.error, signalResponseRawDeviceAttributes.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignalResponseRawDeviceAttributes {\n");
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

