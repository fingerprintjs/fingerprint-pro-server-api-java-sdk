package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.IPInfoV4;
import com.fingerprint.model.IPInfoV6;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Details about the request IP address. Has separate fields for v4 and v6 IP address versions.
 */

@Schema(description = "Details about the request IP address. Has separate fields for v4 and v6 IP address versions.")
@JsonPropertyOrder({
  WebhookIPInfo.JSON_PROPERTY_V4,
  WebhookIPInfo.JSON_PROPERTY_V6
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class WebhookIPInfo {
  public static final String JSON_PROPERTY_V4 = "v4";
  private IPInfoV4 v4;

  public static final String JSON_PROPERTY_V6 = "v6";
  private IPInfoV6 v6;

  public WebhookIPInfo() {
  }

  public WebhookIPInfo v4(IPInfoV4 v4) {
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

  public IPInfoV4 getV4() {
    return v4;
  }


  @JsonProperty(JSON_PROPERTY_V4)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setV4(IPInfoV4 v4) {
    this.v4 = v4;
  }


  public WebhookIPInfo v6(IPInfoV6 v6) {
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

  public IPInfoV6 getV6() {
    return v6;
  }


  @JsonProperty(JSON_PROPERTY_V6)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setV6(IPInfoV6 v6) {
    this.v6 = v6;
  }


  /**
   * Return true if this WebhookIPInfo object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhookIPInfo webhookIPInfo = (WebhookIPInfo) o;
    return Objects.equals(this.v4, webhookIPInfo.v4) &&
        Objects.equals(this.v6, webhookIPInfo.v6);
  }

  @Override
  public int hashCode() {
    return Objects.hash(v4, v6);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhookIPInfo {\n");
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

