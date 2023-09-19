/*
 * Fingerprint Pro Server API
 * Fingerprint Pro Server API allows you to get information about visitors and about individual events in a server environment. It can be used for data exports, decision-making, and data analysis scenarios. Server API is intended for server-side usage, it's not intended to be used from the client side, whether it's a browser or a mobile device. 
 *
 * The version of the OpenAPI document: 3
 * Contact: support@fingerprint.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.fingerprint.model;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.VpnResultMethods;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;


/**
 * VpnResult
 */
@JsonPropertyOrder({
  VpnResult.JSON_PROPERTY_RESULT,
  VpnResult.JSON_PROPERTY_METHODS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class VpnResult {
  public static final String JSON_PROPERTY_RESULT = "result";
  private Boolean result;

  public static final String JSON_PROPERTY_METHODS = "methods";
  private VpnResultMethods methods;

  public VpnResult() { 
  }

  public VpnResult result(Boolean result) {
    this.result = result;
    return this;
  }

   /**
   * VPN or other anonymizing service has been used when sending the request.
   * @return result
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "VPN or other anonymizing service has been used when sending the request.")
  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getResult() {
    return result;
  }


  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResult(Boolean result) {
    this.result = result;
  }


  public VpnResult methods(VpnResultMethods methods) {
    this.methods = methods;
    return this;
  }

   /**
   * Get methods
   * @return methods
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_METHODS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public VpnResultMethods getMethods() {
    return methods;
  }


  @JsonProperty(JSON_PROPERTY_METHODS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMethods(VpnResultMethods methods) {
    this.methods = methods;
  }


  /**
   * Return true if this VpnResult object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VpnResult vpnResult = (VpnResult) o;
    return Objects.equals(this.result, vpnResult.result) &&
        Objects.equals(this.methods, vpnResult.methods);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, methods);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VpnResult {\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    methods: ").append(toIndentedString(methods)).append("\n");
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

