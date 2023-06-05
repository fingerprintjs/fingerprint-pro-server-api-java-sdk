/*
 * Fingerprint Pro Server API
 * Fingerprint Pro Server API allows you to get information about visitors and about individual events in a server environment. This API can be used for data exports, decision-making, and data analysis scenarios.
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
 * WebhookSignalResponseEmulator
 */
@JsonPropertyOrder({
  WebhookSignalResponseEmulator.JSON_PROPERTY_RESULT
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class WebhookSignalResponseEmulator {
  public static final String JSON_PROPERTY_RESULT = "result";
  private Boolean result;

  public WebhookSignalResponseEmulator() { 
  }

  public WebhookSignalResponseEmulator result(Boolean result) {
    this.result = result;
    return this;
  }

   /**
   * Android specific emulator detection. There are 2 values: • &#x60;true&#x60; - Emulated environment detected (e.g. launch inside of AVD) • &#x60;false&#x60; - No signs of emulated environment detected Available only for events from Android client. The field will not be present for a browser or iOS event. 
   * @return result
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "Android specific emulator detection. There are 2 values: • `true` - Emulated environment detected (e.g. launch inside of AVD) • `false` - No signs of emulated environment detected Available only for events from Android client. The field will not be present for a browser or iOS event. ")
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


  /**
   * Return true if this WebhookSignalResponseEmulator object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhookSignalResponseEmulator webhookSignalResponseEmulator = (WebhookSignalResponseEmulator) o;
    return Objects.equals(this.result, webhookSignalResponseEmulator.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhookSignalResponseEmulator {\n");
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
