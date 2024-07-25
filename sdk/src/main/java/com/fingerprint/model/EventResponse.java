package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.ProductError;
import com.fingerprint.model.ProductsResponse;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Contains results from all activated products - Fingerprint Pro, Bot Detection, and others.
 */

@Schema(description = "Contains results from all activated products - Fingerprint Pro, Bot Detection, and others.")
@JsonPropertyOrder({
  EventResponse.JSON_PROPERTY_PRODUCTS,
  EventResponse.JSON_PROPERTY_ERROR
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class EventResponse {
  public static final String JSON_PROPERTY_PRODUCTS = "products";
  private ProductsResponse products;

  public static final String JSON_PROPERTY_ERROR = "error";
  private ProductError error;

  public EventResponse() {
  }

  public EventResponse products(ProductsResponse products) {
    this.products = products;
    return this;
  }

   /**
   * Get products
   * @return products
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_PRODUCTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ProductsResponse getProducts() {
    return products;
  }


  @JsonProperty(JSON_PROPERTY_PRODUCTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setProducts(ProductsResponse products) {
    this.products = products;
  }


  public EventResponse error(ProductError error) {
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

  public ProductError getError() {
    return error;
  }


  @JsonProperty(JSON_PROPERTY_ERROR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setError(ProductError error) {
    this.error = error;
  }


  /**
   * Return true if this EventResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventResponse eventResponse = (EventResponse) o;
    return Objects.equals(this.products, eventResponse.products) &&
        Objects.equals(this.error, eventResponse.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(products, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventResponse {\n");
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
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

