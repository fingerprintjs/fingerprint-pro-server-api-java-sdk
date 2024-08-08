package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.ASN;
import com.fingerprint.model.DataCenter;
import com.fingerprint.model.IPLocation;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * IpInfoResultV6
 */


@JsonPropertyOrder({
  IpInfoResultV6.JSON_PROPERTY_ADDRESS,
  IpInfoResultV6.JSON_PROPERTY_GEOLOCATION,
  IpInfoResultV6.JSON_PROPERTY_ASN,
  IpInfoResultV6.JSON_PROPERTY_DATACENTER
})
@JsonTypeName("IpInfoResult_v6")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class IpInfoResultV6 {
  public static final String JSON_PROPERTY_ADDRESS = "address";
  private String address;

  public static final String JSON_PROPERTY_GEOLOCATION = "geolocation";
  private IPLocation geolocation;

  public static final String JSON_PROPERTY_ASN = "asn";
  private ASN asn;

  public static final String JSON_PROPERTY_DATACENTER = "datacenter";
  private DataCenter datacenter;

  public IpInfoResultV6() {
  }

  public IpInfoResultV6 address(String address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "2001:0db8:85a3:0000:0000:8a2e:0370:7334", required = true, description = "")
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


  public IpInfoResultV6 geolocation(IPLocation geolocation) {
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

  public IPLocation getGeolocation() {
    return geolocation;
  }


  @JsonProperty(JSON_PROPERTY_GEOLOCATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGeolocation(IPLocation geolocation) {
    this.geolocation = geolocation;
  }


  public IpInfoResultV6 asn(ASN asn) {
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

  public ASN getAsn() {
    return asn;
  }


  @JsonProperty(JSON_PROPERTY_ASN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAsn(ASN asn) {
    this.asn = asn;
  }


  public IpInfoResultV6 datacenter(DataCenter datacenter) {
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

  public DataCenter getDatacenter() {
    return datacenter;
  }


  @JsonProperty(JSON_PROPERTY_DATACENTER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDatacenter(DataCenter datacenter) {
    this.datacenter = datacenter;
  }


  /**
   * Return true if this IpInfoResult_v6 object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IpInfoResultV6 ipInfoResultV6 = (IpInfoResultV6) o;
    return Objects.equals(this.address, ipInfoResultV6.address) &&
        Objects.equals(this.geolocation, ipInfoResultV6.geolocation) &&
        Objects.equals(this.asn, ipInfoResultV6.asn) &&
        Objects.equals(this.datacenter, ipInfoResultV6.datacenter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, geolocation, asn, datacenter);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IpInfoResultV6 {\n");
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

