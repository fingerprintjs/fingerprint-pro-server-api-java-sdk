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
 * SeenAt
 */


@JsonPropertyOrder({
  SeenAt.JSON_PROPERTY_GLOBAL,
  SeenAt.JSON_PROPERTY_SUBSCRIPTION
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class SeenAt {
  public static final String JSON_PROPERTY_GLOBAL = "global";
  private OffsetDateTime global;

  public static final String JSON_PROPERTY_SUBSCRIPTION = "subscription";
  private OffsetDateTime subscription;

  public SeenAt() {
  }

  public SeenAt global(OffsetDateTime global) {
    this.global = global;
    return this;
  }

   /**
   * Get global
   * @return global
  **/
  @jakarta.annotation.Nullable
  @Schema(example = "2022-05-05T18:28:54.535Z", required = true, description = "")
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


  public SeenAt subscription(OffsetDateTime subscription) {
    this.subscription = subscription;
    return this;
  }

   /**
   * Get subscription
   * @return subscription
  **/
  @jakarta.annotation.Nullable
  @Schema(example = "2022-06-09T22:58:05.576Z", required = true, description = "")
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
   * Return true if this SeenAt object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SeenAt seenAt = (SeenAt) o;
    return Objects.equals(this.global, seenAt.global) &&
        Objects.equals(this.subscription, seenAt.subscription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(global, subscription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SeenAt {\n");
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

