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
 * MitMAttack
 */


@JsonPropertyOrder({
  MitMAttack.JSON_PROPERTY_RESULT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class MitMAttack {
  public static final String JSON_PROPERTY_RESULT = "result";
  private Boolean result;

  public MitMAttack() {
  }

  public MitMAttack result(Boolean result) {
    this.result = result;
    return this;
  }

   /**
   * * `true` - When requests made from your users' mobile devices to Fingerprint servers have been intercepted and potentially modified.  * `false` - Otherwise or when the request originated from a browser. See [MitM Attack Detection](https://dev.fingerprint.com/docs/smart-signals-reference#mitm-attack-detection) to learn more about this Smart Signal. 
   * @return result
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "* `true` - When requests made from your users' mobile devices to Fingerprint servers have been intercepted and potentially modified.  * `false` - Otherwise or when the request originated from a browser. See [MitM Attack Detection](https://dev.fingerprint.com/docs/smart-signals-reference#mitm-attack-detection) to learn more about this Smart Signal. ")
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
   * Return true if this MitMAttack object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MitMAttack mitMAttack = (MitMAttack) o;
    return Objects.equals(this.result, mitMAttack.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MitMAttack {\n");
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

