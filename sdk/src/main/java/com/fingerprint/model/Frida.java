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
 * Frida
 */


@JsonPropertyOrder({
  Frida.JSON_PROPERTY_RESULT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class Frida {
  public static final String JSON_PROPERTY_RESULT = "result";
  private Boolean result;

  public Frida() {
  }

  public Frida result(Boolean result) {
    this.result = result;
    return this;
  }

   /**
   * [Frida](https://frida.re/docs/) detection for Android and iOS devices. There are 2 values:   * `true` - Frida detected   * `false` - No signs of Frida or the client is not a mobile device. 
   * @return result
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "[Frida](https://frida.re/docs/) detection for Android and iOS devices. There are 2 values:   * `true` - Frida detected   * `false` - No signs of Frida or the client is not a mobile device. ")
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
   * Return true if this Frida object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Frida frida = (Frida) o;
    return Objects.equals(this.result, frida.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Frida {\n");
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

