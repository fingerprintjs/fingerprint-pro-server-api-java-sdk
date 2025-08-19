package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Proxy detection details (present if proxy is detected)
 */

@Schema(description = "Proxy detection details (present if proxy is detected)")
@JsonPropertyOrder({
  ProxyDetails.JSON_PROPERTY_PROXY_TYPE,
  ProxyDetails.JSON_PROPERTY_LAST_SEEN_AT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class ProxyDetails {
  /**
   * Residential proxies use real user IP addresses to appear as legitimate traffic,  while data center proxies are public proxies hosted in data centers 
   */
  public enum ProxyTypeEnum {
    RESIDENTIAL("residential"),
    
    DATA_CENTER("data_center");

    private String value;

    ProxyTypeEnum(String value) {
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
    public static ProxyTypeEnum fromValue(String value) {
      for (ProxyTypeEnum b : ProxyTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  public static final String JSON_PROPERTY_PROXY_TYPE = "proxyType";
  private ProxyTypeEnum proxyType;

  public static final String JSON_PROPERTY_LAST_SEEN_AT = "lastSeenAt";
  private OffsetDateTime lastSeenAt;

  public ProxyDetails() {
  }

  public ProxyDetails proxyType(ProxyTypeEnum proxyType) {
    this.proxyType = proxyType;
    return this;
  }

   /**
   * Residential proxies use real user IP addresses to appear as legitimate traffic,  while data center proxies are public proxies hosted in data centers 
   * @return proxyType
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "Residential proxies use real user IP addresses to appear as legitimate traffic,  while data center proxies are public proxies hosted in data centers ")
  @JsonProperty(JSON_PROPERTY_PROXY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ProxyTypeEnum getProxyType() {
    return proxyType;
  }


  @JsonProperty(JSON_PROPERTY_PROXY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setProxyType(ProxyTypeEnum proxyType) {
    this.proxyType = proxyType;
  }


  public ProxyDetails lastSeenAt(OffsetDateTime lastSeenAt) {
    this.lastSeenAt = lastSeenAt;
    return this;
  }

   /**
   * ISO 8601 formatted timestamp in UTC with hourly resolution of when this IP was last seen as a proxy when available. 
   * @return lastSeenAt
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "ISO 8601 formatted timestamp in UTC with hourly resolution of when this IP was last seen as a proxy when available. ")
  @JsonProperty(JSON_PROPERTY_LAST_SEEN_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getLastSeenAt() {
    return lastSeenAt;
  }


  @JsonProperty(JSON_PROPERTY_LAST_SEEN_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLastSeenAt(OffsetDateTime lastSeenAt) {
    this.lastSeenAt = lastSeenAt;
  }


  /**
   * Return true if this ProxyDetails object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProxyDetails proxyDetails = (ProxyDetails) o;
    return Objects.equals(this.proxyType, proxyDetails.proxyType) &&
        Objects.equals(this.lastSeenAt, proxyDetails.lastSeenAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(proxyType, lastSeenAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProxyDetails {\n");
    sb.append("    proxyType: ").append(toIndentedString(proxyType)).append("\n");
    sb.append("    lastSeenAt: ").append(toIndentedString(lastSeenAt)).append("\n");
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

