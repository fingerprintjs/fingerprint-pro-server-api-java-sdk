package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.IntegrationSubintegration;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Integration
 */


@JsonPropertyOrder({
  Integration.JSON_PROPERTY_NAME,
  Integration.JSON_PROPERTY_VERSION,
  Integration.JSON_PROPERTY_SUBINTEGRATION
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class Integration {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_VERSION = "version";
  private String version;

  public static final String JSON_PROPERTY_SUBINTEGRATION = "subintegration";
  private IntegrationSubintegration subintegration;

  public Integration() {
  }

  public Integration name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the specific integration, e.g. \"fingerprint-pro-react\".
   * @return name
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "The name of the specific integration, e.g. \"fingerprint-pro-react\".")
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


  public Integration version(String version) {
    this.version = version;
    return this;
  }

   /**
   * The version of the specific integration, e.g. \"3.11.10\".
   * @return version
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "The version of the specific integration, e.g. \"3.11.10\".")
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


  public Integration subintegration(IntegrationSubintegration subintegration) {
    this.subintegration = subintegration;
    return this;
  }

   /**
   * Get subintegration
   * @return subintegration
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_SUBINTEGRATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public IntegrationSubintegration getSubintegration() {
    return subintegration;
  }


  @JsonProperty(JSON_PROPERTY_SUBINTEGRATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSubintegration(IntegrationSubintegration subintegration) {
    this.subintegration = subintegration;
  }


  /**
   * Return true if this Integration object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Integration integration = (Integration) o;
    return Objects.equals(this.name, integration.name) &&
        Objects.equals(this.version, integration.version) &&
        Objects.equals(this.subintegration, integration.subintegration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, version, subintegration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Integration {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    subintegration: ").append(toIndentedString(subintegration)).append("\n");
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

