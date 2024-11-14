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
 * IdentificationSeenAt
 */


@JsonPropertyOrder({
  IdentificationSeenAt.JSON_PROPERTY_GLOBAL,
  IdentificationSeenAt.JSON_PROPERTY_SUBSCRIPTION
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class IdentificationSeenAt {
  public static final String JSON_PROPERTY_GLOBAL = "global";
  private OffsetDateTime global;

  public static final String JSON_PROPERTY_SUBSCRIPTION = "subscription";
  private OffsetDateTime subscription;

  public IdentificationSeenAt() {
  }

  public IdentificationSeenAt global(OffsetDateTime global) {
    this.global = global;
    return this;
  }

   /**
   * Get global
   * @return global
  **/
  @jakarta.annotation.Nullable
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_GLOBAL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getGlobal() {
    return global;
  }


  @JsonProperty(JSON_PROPERTY_GLOBAL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGlobal(OffsetDateTime global) {
    this.global = global;
  }


  public IdentificationSeenAt subscription(OffsetDateTime subscription) {
    this.subscription = subscription;
    return this;
  }

   /**
   * Get subscription
   * @return subscription
  **/
  @jakarta.annotation.Nullable
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_SUBSCRIPTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getSubscription() {
    return subscription;
  }


  @JsonProperty(JSON_PROPERTY_SUBSCRIPTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSubscription(OffsetDateTime subscription) {
    this.subscription = subscription;
  }


  /**
   * Return true if this IdentificationSeenAt object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdentificationSeenAt identificationSeenAt = (IdentificationSeenAt) o;
    return Objects.equals(this.global, identificationSeenAt.global) &&
        Objects.equals(this.subscription, identificationSeenAt.subscription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(global, subscription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdentificationSeenAt {\n");
    sb.append("    global: ").append(toIndentedString(global)).append("\n");
    sb.append("    subscription: ").append(toIndentedString(subscription)).append("\n");
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

