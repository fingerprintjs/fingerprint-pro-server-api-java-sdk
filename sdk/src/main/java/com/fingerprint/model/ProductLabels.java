package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.Error;
import com.fingerprint.model.LabelsInner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * ProductLabels
 */


@JsonPropertyOrder({
  ProductLabels.JSON_PROPERTY_DATA,
  ProductLabels.JSON_PROPERTY_ERROR
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class ProductLabels {
  public static final String JSON_PROPERTY_DATA = "data";
  private List<LabelsInner> data = null;

  public static final String JSON_PROPERTY_ERROR = "error";
  private Error error;

  public ProductLabels() {
  }

  public ProductLabels data(List<LabelsInner> data) {
    this.data = data;
    return this;
  }

  public ProductLabels addLabelsInnerItem(LabelsInner dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

   /**
   * Each label returns a prediction (true or false) for a specific use case (label field) based on a machine learning score. The machine learning score is determined by a model trained on customer data for that use case. This field is in the beta phase and only available to select customers. If you are interested, please [contact our support team](https://fingerprint.com/support/). 
   * @return data
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "Each label returns a prediction (true or false) for a specific use case (label field) based on a machine learning score. The machine learning score is determined by a model trained on customer data for that use case. This field is in the beta phase and only available to select customers. If you are interested, please [contact our support team](https://fingerprint.com/support/). ")
  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<LabelsInner> getData() {
    return data;
  }


  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setData(List<LabelsInner> data) {
    this.data = data;
  }


  public ProductLabels error(Error error) {
    this.error = error;
    return this;
  }

   /**
   * Get error
   * @return error
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_ERROR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Error getError() {
    return error;
  }


  @JsonProperty(JSON_PROPERTY_ERROR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setError(Error error) {
    this.error = error;
  }


  /**
   * Return true if this ProductLabels object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductLabels productLabels = (ProductLabels) o;
    return Objects.equals(this.data, productLabels.data) &&
        Objects.equals(this.error, productLabels.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductLabels {\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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

