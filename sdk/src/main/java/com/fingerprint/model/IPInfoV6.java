package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.Geolocation;
import com.fingerprint.model.IPInfoASN;
import com.fingerprint.model.IPInfoDataCenter;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * IPInfoV6
 */


@JsonPropertyOrder({
  IPInfoV6.JSON_PROPERTY_ADDRESS,
  IPInfoV6.JSON_PROPERTY_GEOLOCATION,
  IPInfoV6.JSON_PROPERTY_ASN,
  IPInfoV6.JSON_PROPERTY_DATACENTER
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class IPInfoV6 {
  public static final String JSON_PROPERTY_ADDRESS = "address";
  private String address;

  public static final String JSON_PROPERTY_GEOLOCATION = "geolocation";
  private Geolocation geolocation;

  public static final String JSON_PROPERTY_ASN = "asn";
  private IPInfoASN asn;

  public static final String JSON_PROPERTY_DATACENTER = "datacenter";
  private IPInfoDataCenter datacenter;

  public IPInfoV6() {
  }

  public IPInfoV6 address(String address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getAddress() {
    return address;
  }


  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAddress(String address) {
    this.address = address;
  }


  public IPInfoV6 geolocation(Geolocation geolocation) {
    this.geolocation = geolocation;
    return this;
  }

   /**
   * Get geolocation
   * @return geolocation
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_GEOLOCATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Geolocation getGeolocation() {
    return geolocation;
  }


  @JsonProperty(JSON_PROPERTY_GEOLOCATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGeolocation(Geolocation geolocation) {
    this.geolocation = geolocation;
  }


  public IPInfoV6 asn(IPInfoASN asn) {
    this.asn = asn;
    return this;
  }

   /**
   * Get asn
   * @return asn
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_ASN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public IPInfoASN getAsn() {
    return asn;
  }


  @JsonProperty(JSON_PROPERTY_ASN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAsn(IPInfoASN asn) {
    this.asn = asn;
  }


  public IPInfoV6 datacenter(IPInfoDataCenter datacenter) {
    this.datacenter = datacenter;
    return this;
  }

   /**
   * Get datacenter
   * @return datacenter
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_DATACENTER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public IPInfoDataCenter getDatacenter() {
    return datacenter;
  }


  @JsonProperty(JSON_PROPERTY_DATACENTER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDatacenter(IPInfoDataCenter datacenter) {
    this.datacenter = datacenter;
  }


  /**
   * Return true if this IPInfoV6 object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IPInfoV6 ipInfoV6 = (IPInfoV6) o;
    return Objects.equals(this.address, ipInfoV6.address) &&
        Objects.equals(this.geolocation, ipInfoV6.geolocation) &&
        Objects.equals(this.asn, ipInfoV6.asn) &&
        Objects.equals(this.datacenter, ipInfoV6.datacenter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, geolocation, asn, datacenter);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IPInfoV6 {\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    geolocation: ").append(toIndentedString(geolocation)).append("\n");
    sb.append("    asn: ").append(toIndentedString(asn)).append("\n");
    sb.append("    datacenter: ").append(toIndentedString(datacenter)).append("\n");
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

