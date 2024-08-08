package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.IpInfoResultV4;
import com.fingerprint.model.IpInfoResultV6;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Details about the request IP address. Has separate fields for v4 and v6 IP address versions.
 */

@Schema(description = "Details about the request IP address. Has separate fields for v4 and v6 IP address versions.")
@JsonPropertyOrder({
  IpInfoResult.JSON_PROPERTY_V4,
  IpInfoResult.JSON_PROPERTY_V6
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class IpInfoResult {
  public static final String JSON_PROPERTY_V4 = "v4";
  private IpInfoResultV4 v4;

  public static final String JSON_PROPERTY_V6 = "v6";
  private IpInfoResultV6 v6;

  public IpInfoResult() {
  }

  public IpInfoResult v4(IpInfoResultV4 v4) {
    this.v4 = v4;
    return this;
  }

   /**
   * Get v4
   * @return v4
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_V4)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public IpInfoResultV4 getV4() {
    return v4;
  }


  @JsonProperty(JSON_PROPERTY_V4)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setV4(IpInfoResultV4 v4) {
    this.v4 = v4;
  }


  public IpInfoResult v6(IpInfoResultV6 v6) {
    this.v6 = v6;
    return this;
  }

   /**
   * Get v6
   * @return v6
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_V6)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public IpInfoResultV6 getV6() {
    return v6;
  }


  @JsonProperty(JSON_PROPERTY_V6)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setV6(IpInfoResultV6 v6) {
    this.v6 = v6;
  }


  /**
   * Return true if this IpInfoResult object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IpInfoResult ipInfoResult = (IpInfoResult) o;
    return Objects.equals(this.v4, ipInfoResult.v4) &&
        Objects.equals(this.v6, ipInfoResult.v6);
  }

  @Override
  public int hashCode() {
    return Objects.hash(v4, v6);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IpInfoResult {\n");
    sb.append("    v4: ").append(toIndentedString(v4)).append("\n");
    sb.append("    v6: ").append(toIndentedString(v6)).append("\n");
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

