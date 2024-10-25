package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * IPBlocklistDetails
 */


@JsonPropertyOrder({
  IPBlocklistDetails.JSON_PROPERTY_EMAIL_SPAM,
  IPBlocklistDetails.JSON_PROPERTY_ATTACK_SOURCE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class IPBlocklistDetails {
  public static final String JSON_PROPERTY_EMAIL_SPAM = "emailSpam";
  private Boolean emailSpam;

  public static final String JSON_PROPERTY_ATTACK_SOURCE = "attackSource";
  private Boolean attackSource;

  public IPBlocklistDetails() {
  }

  public IPBlocklistDetails emailSpam(Boolean emailSpam) {
    this.emailSpam = emailSpam;
    return this;
  }

   /**
   * IP address was part of a known email spam attack (SMTP).
   * @return emailSpam
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "IP address was part of a known email spam attack (SMTP).")
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


  public IPBlocklistDetails attackSource(Boolean attackSource) {
    this.attackSource = attackSource;
    return this;
  }

   /**
   * IP address was part of a known network attack (SSH/HTTPS).
   * @return attackSource
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "IP address was part of a known network attack (SSH/HTTPS).")
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
   * Return true if this IPBlocklistDetails object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IPBlocklistDetails ipBlocklistDetails = (IPBlocklistDetails) o;
    return Objects.equals(this.emailSpam, ipBlocklistDetails.emailSpam) &&
        Objects.equals(this.attackSource, ipBlocklistDetails.attackSource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(emailSpam, attackSource);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IPBlocklistDetails {\n");
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

