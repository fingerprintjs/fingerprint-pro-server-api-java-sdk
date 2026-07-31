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
 * WebhookRareDevice
 */


@JsonPropertyOrder({
  WebhookRareDevice.JSON_PROPERTY_RESULT,
  WebhookRareDevice.JSON_PROPERTY_PERCENTILE_BUCKET
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class WebhookRareDevice {
  public static final String JSON_PROPERTY_RESULT = "result";
  private Boolean result;

  /**
   * The rarity percentile bucket of the device, indicating how uncommon the device configuration is compared to all observed devices. 
   */
  public enum PercentileBucketEnum {
    _P95("<p95"),
    
    P95_P99("p95-p99"),
    
    P99_P99_5("p99-p99.5"),
    
    P99_5_P99_9("p99.5-p99.9"),
    
    P99_9_("p99.9+"),
    
    NOT_SEEN("not_seen");

    private String value;

    PercentileBucketEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PercentileBucketEnum fromValue(String value) {
      for (PercentileBucketEnum b : PercentileBucketEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  public static final String JSON_PROPERTY_PERCENTILE_BUCKET = "percentileBucket";
  private PercentileBucketEnum percentileBucket;

  public WebhookRareDevice() {
  }

  public WebhookRareDevice result(Boolean result) {
    this.result = result;
    return this;
  }

   /**
   * `true` if the device is considered rare based on its combination of hardware and software attributes.  A device is classified as rare if it falls within the top 99.9 percentile (lowest-frequency segment) of observed traffic,  or if its configuration has not been previously seen (`not_seen`). > This Smart Signal is currently in beta and only available to select customers. If you are interested, please [contact our support team](https://fingerprint.com/support/). 
   * @return result
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "`true` if the device is considered rare based on its combination of hardware and software attributes.  A device is classified as rare if it falls within the top 99.9 percentile (lowest-frequency segment) of observed traffic,  or if its configuration has not been previously seen (`not_seen`). > This Smart Signal is currently in beta and only available to select customers. If you are interested, please [contact our support team](https://fingerprint.com/support/). ")
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


  public WebhookRareDevice percentileBucket(PercentileBucketEnum percentileBucket) {
    this.percentileBucket = percentileBucket;
    return this;
  }

   /**
   * The rarity percentile bucket of the device, indicating how uncommon the device configuration is compared to all observed devices. 
   * @return percentileBucket
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "The rarity percentile bucket of the device, indicating how uncommon the device configuration is compared to all observed devices. ")
  @JsonProperty(JSON_PROPERTY_PERCENTILE_BUCKET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PercentileBucketEnum getPercentileBucket() {
    return percentileBucket;
  }


  @JsonProperty(JSON_PROPERTY_PERCENTILE_BUCKET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPercentileBucket(PercentileBucketEnum percentileBucket) {
    this.percentileBucket = percentileBucket;
  }


  /**
   * Return true if this WebhookRareDevice object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhookRareDevice webhookRareDevice = (WebhookRareDevice) o;
    return Objects.equals(this.result, webhookRareDevice.result) &&
        Objects.equals(this.percentileBucket, webhookRareDevice.percentileBucket);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, percentileBucket);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhookRareDevice {\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    percentileBucket: ").append(toIndentedString(percentileBucket)).append("\n");
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

