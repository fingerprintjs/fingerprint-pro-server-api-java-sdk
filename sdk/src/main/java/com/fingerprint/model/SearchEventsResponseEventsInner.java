package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.Products;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Device intelligence results for the identification event.
 */

@Schema(description = "Device intelligence results for the identification event.")
@JsonPropertyOrder({
  SearchEventsResponseEventsInner.JSON_PROPERTY_PRODUCTS
})
@JsonTypeName("SearchEventsResponse_events_inner")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class SearchEventsResponseEventsInner {
  public static final String JSON_PROPERTY_PRODUCTS = "products";
  private Products products;

  public SearchEventsResponseEventsInner() {
  }

  public SearchEventsResponseEventsInner products(Products products) {
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

  public Products getProducts() {
    return products;
  }


  @JsonProperty(JSON_PROPERTY_PRODUCTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setProducts(Products products) {
    this.products = products;
  }


  /**
   * Return true if this SearchEventsResponse_events_inner object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchEventsResponseEventsInner searchEventsResponseEventsInner = (SearchEventsResponseEventsInner) o;
    return Objects.equals(this.products, searchEventsResponseEventsInner.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash(products);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchEventsResponseEventsInner {\n");
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
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

