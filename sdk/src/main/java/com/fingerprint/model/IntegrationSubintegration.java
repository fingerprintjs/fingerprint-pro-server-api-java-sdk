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
 * IntegrationSubintegration
 */


@JsonPropertyOrder({
  IntegrationSubintegration.JSON_PROPERTY_NAME,
  IntegrationSubintegration.JSON_PROPERTY_VERSION
})
@JsonTypeName("Integration_subintegration")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class IntegrationSubintegration {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_VERSION = "version";
  private String version;

  public IntegrationSubintegration() {
  }

  public IntegrationSubintegration name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the specific subintegration, e.g. \"preact\".
   * @return name
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "The name of the specific subintegration, e.g. \"preact\".")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(String name) {
    this.name = name;
  }


  public IntegrationSubintegration version(String version) {
    this.version = version;
    return this;
  }

   /**
   * The version of the specific subintegration, e.g. \"10.21.0\".
   * @return version
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "The version of the specific subintegration, e.g. \"10.21.0\".")
  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getVersion() {
    return version;
  }


  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVersion(String version) {
    this.version = version;
  }


  /**
   * Return true if this Integration_subintegration object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IntegrationSubintegration integrationSubintegration = (IntegrationSubintegration) o;
    return Objects.equals(this.name, integrationSubintegration.name) &&
        Objects.equals(this.version, integrationSubintegration.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IntegrationSubintegration {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

