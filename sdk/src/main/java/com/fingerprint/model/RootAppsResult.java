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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;


/**
 * RootAppsResult
 */
@JsonPropertyOrder({
  RootAppsResult.JSON_PROPERTY_RESULT
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class RootAppsResult {
  public static final String JSON_PROPERTY_RESULT = "result";
  private Boolean result;

  public RootAppsResult() {
  }

  public RootAppsResult result(Boolean result) {
    this.result = result;
    return this;
  }

   /**
   * Android specific root management apps detection. There are 2 values: • &#x60;true&#x60; - Root Management Apps detected (e.g. Magisk) • &#x60;false&#x60; - No Root Management Apps detected or the client isn&#39;t Android. 
   * @return result
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "false", required = true, value = "Android specific root management apps detection. There are 2 values: • `true` - Root Management Apps detected (e.g. Magisk) • `false` - No Root Management Apps detected or the client isn't Android. ")
  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getResult() {
    return result;
  }


  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setResult(Boolean result) {
    this.result = result;
  }


  /**
   * Return true if this RootAppsResult object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RootAppsResult rootAppsResult = (RootAppsResult) o;
    return Objects.equals(this.result, rootAppsResult.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RootAppsResult {\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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

