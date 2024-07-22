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
 * IpBlockListResultDetails
 */
@JsonPropertyOrder({
  IpBlockListResultDetails.JSON_PROPERTY_EMAIL_SPAM,
  IpBlockListResultDetails.JSON_PROPERTY_ATTACK_SOURCE
})
@JsonTypeName("IpBlockListResult_details")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class IpBlockListResultDetails {
  public static final String JSON_PROPERTY_EMAIL_SPAM = "emailSpam";
  private Boolean emailSpam;

  public static final String JSON_PROPERTY_ATTACK_SOURCE = "attackSource";
  private Boolean attackSource;

  public IpBlockListResultDetails() {
  }

  public IpBlockListResultDetails emailSpam(Boolean emailSpam) {
    this.emailSpam = emailSpam;
    return this;
  }

   /**
   * IP address was part of a known email spam attack (SMTP).
   * @return emailSpam
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "false", required = true, value = "IP address was part of a known email spam attack (SMTP).")
  @JsonProperty(JSON_PROPERTY_EMAIL_SPAM)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getEmailSpam() {
    return emailSpam;
  }


  @JsonProperty(JSON_PROPERTY_EMAIL_SPAM)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEmailSpam(Boolean emailSpam) {
    this.emailSpam = emailSpam;
  }


  public IpBlockListResultDetails attackSource(Boolean attackSource) {
    this.attackSource = attackSource;
    return this;
  }

   /**
   * IP address was part of a known network attack (SSH/HTTPS).
   * @return attackSource
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "false", required = true, value = "IP address was part of a known network attack (SSH/HTTPS).")
  @JsonProperty(JSON_PROPERTY_ATTACK_SOURCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getAttackSource() {
    return attackSource;
  }


  @JsonProperty(JSON_PROPERTY_ATTACK_SOURCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAttackSource(Boolean attackSource) {
    this.attackSource = attackSource;
  }


  /**
   * Return true if this IpBlockListResult_details object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IpBlockListResultDetails ipBlockListResultDetails = (IpBlockListResultDetails) o;
    return Objects.equals(this.emailSpam, ipBlockListResultDetails.emailSpam) &&
        Objects.equals(this.attackSource, ipBlockListResultDetails.attackSource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(emailSpam, attackSource);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IpBlockListResultDetails {\n");
    sb.append("    emailSpam: ").append(toIndentedString(emailSpam)).append("\n");
    sb.append("    attackSource: ").append(toIndentedString(attackSource)).append("\n");
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

