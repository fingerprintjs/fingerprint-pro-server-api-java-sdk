package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.GeolocationCity;
import com.fingerprint.model.GeolocationContinent;
import com.fingerprint.model.GeolocationCountry;
import com.fingerprint.model.GeolocationSubdivision;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * This field is **deprecated** and will not return a result for **applications created after January 23rd, 2024**.  Please use the [IP Geolocation Smart signal](https://dev.fingerprint.com/docs/smart-signals-overview#ip-geolocation) for geolocation information.
 * @deprecated
 */
@Deprecated
@Schema(description = "This field is **deprecated** and will not return a result for **applications created after January 23rd, 2024**.  Please use the [IP Geolocation Smart signal](https://dev.fingerprint.com/docs/smart-signals-overview#ip-geolocation) for geolocation information.")
@JsonPropertyOrder({
  DeprecatedGeolocation.JSON_PROPERTY_ACCURACY_RADIUS,
  DeprecatedGeolocation.JSON_PROPERTY_LATITUDE,
  DeprecatedGeolocation.JSON_PROPERTY_LONGITUDE,
  DeprecatedGeolocation.JSON_PROPERTY_POSTAL_CODE,
  DeprecatedGeolocation.JSON_PROPERTY_TIMEZONE,
  DeprecatedGeolocation.JSON_PROPERTY_CITY,
  DeprecatedGeolocation.JSON_PROPERTY_COUNTRY,
  DeprecatedGeolocation.JSON_PROPERTY_CONTINENT,
  DeprecatedGeolocation.JSON_PROPERTY_SUBDIVISIONS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class DeprecatedGeolocation {
  public static final String JSON_PROPERTY_ACCURACY_RADIUS = "accuracyRadius";
  private Integer accuracyRadius;

  public static final String JSON_PROPERTY_LATITUDE = "latitude";
  private Double latitude;

  public static final String JSON_PROPERTY_LONGITUDE = "longitude";
  private Double longitude;

  public static final String JSON_PROPERTY_POSTAL_CODE = "postalCode";
  private String postalCode;

  public static final String JSON_PROPERTY_TIMEZONE = "timezone";
  private String timezone;

  public static final String JSON_PROPERTY_CITY = "city";
  private GeolocationCity city;

  public static final String JSON_PROPERTY_COUNTRY = "country";
  private GeolocationCountry country;

  public static final String JSON_PROPERTY_CONTINENT = "continent";
  private GeolocationContinent continent;

  public static final String JSON_PROPERTY_SUBDIVISIONS = "subdivisions";
  private List<GeolocationSubdivision> subdivisions = null;

  public DeprecatedGeolocation() {
  }

  public DeprecatedGeolocation accuracyRadius(Integer accuracyRadius) {
    this.accuracyRadius = accuracyRadius;
    return this;
  }

   /**
   * The IP address is likely to be within this radius (in km) of the specified location.
   * minimum: 0
   * @return accuracyRadius
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "The IP address is likely to be within this radius (in km) of the specified location.")
  @JsonProperty(JSON_PROPERTY_ACCURACY_RADIUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getAccuracyRadius() {
    return accuracyRadius;
  }


  @JsonProperty(JSON_PROPERTY_ACCURACY_RADIUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAccuracyRadius(Integer accuracyRadius) {
    this.accuracyRadius = accuracyRadius;
  }


  public DeprecatedGeolocation latitude(Double latitude) {
    this.latitude = latitude;
    return this;
  }

   /**
   * Get latitude
   * minimum: -90
   * maximum: 90
   * @return latitude
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_LATITUDE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getLatitude() {
    return latitude;
  }


  @JsonProperty(JSON_PROPERTY_LATITUDE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }


  public DeprecatedGeolocation longitude(Double longitude) {
    this.longitude = longitude;
    return this;
  }

   /**
   * Get longitude
   * minimum: -180
   * maximum: 180
   * @return longitude
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_LONGITUDE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getLongitude() {
    return longitude;
  }


  @JsonProperty(JSON_PROPERTY_LONGITUDE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }


  public DeprecatedGeolocation postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

   /**
   * Get postalCode
   * @return postalCode
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_POSTAL_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPostalCode() {
    return postalCode;
  }


  @JsonProperty(JSON_PROPERTY_POSTAL_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }


  public DeprecatedGeolocation timezone(String timezone) {
    this.timezone = timezone;
    return this;
  }

   /**
   * Get timezone
   * @return timezone
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_TIMEZONE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTimezone() {
    return timezone;
  }


  @JsonProperty(JSON_PROPERTY_TIMEZONE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }


  public DeprecatedGeolocation city(GeolocationCity city) {
    this.city = city;
    return this;
  }

   /**
   * Get city
   * @return city
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public GeolocationCity getCity() {
    return city;
  }


  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCity(GeolocationCity city) {
    this.city = city;
  }


  public DeprecatedGeolocation country(GeolocationCountry country) {
    this.country = country;
    return this;
  }

   /**
   * Get country
   * @return country
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public GeolocationCountry getCountry() {
    return country;
  }


  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCountry(GeolocationCountry country) {
    this.country = country;
  }


  public DeprecatedGeolocation continent(GeolocationContinent continent) {
    this.continent = continent;
    return this;
  }

   /**
   * Get continent
   * @return continent
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_CONTINENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public GeolocationContinent getContinent() {
    return continent;
  }


  @JsonProperty(JSON_PROPERTY_CONTINENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setContinent(GeolocationContinent continent) {
    this.continent = continent;
  }


  public DeprecatedGeolocation subdivisions(List<GeolocationSubdivision> subdivisions) {
    this.subdivisions = subdivisions;
    return this;
  }

  public DeprecatedGeolocation addGeolocationSubdivisionItem(GeolocationSubdivision subdivisionsItem) {
    if (this.subdivisions == null) {
      this.subdivisions = new ArrayList<>();
    }
    this.subdivisions.add(subdivisionsItem);
    return this;
  }

   /**
   * Get subdivisions
   * @return subdivisions
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_SUBDIVISIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<GeolocationSubdivision> getSubdivisions() {
    return subdivisions;
  }


  @JsonProperty(JSON_PROPERTY_SUBDIVISIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSubdivisions(List<GeolocationSubdivision> subdivisions) {
    this.subdivisions = subdivisions;
  }


  /**
   * Return true if this DeprecatedGeolocation object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeprecatedGeolocation deprecatedGeolocation = (DeprecatedGeolocation) o;
    return Objects.equals(this.accuracyRadius, deprecatedGeolocation.accuracyRadius) &&
        Objects.equals(this.latitude, deprecatedGeolocation.latitude) &&
        Objects.equals(this.longitude, deprecatedGeolocation.longitude) &&
        Objects.equals(this.postalCode, deprecatedGeolocation.postalCode) &&
        Objects.equals(this.timezone, deprecatedGeolocation.timezone) &&
        Objects.equals(this.city, deprecatedGeolocation.city) &&
        Objects.equals(this.country, deprecatedGeolocation.country) &&
        Objects.equals(this.continent, deprecatedGeolocation.continent) &&
        Objects.equals(this.subdivisions, deprecatedGeolocation.subdivisions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accuracyRadius, latitude, longitude, postalCode, timezone, city, country, continent, subdivisions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeprecatedGeolocation {\n");
    sb.append("    accuracyRadius: ").append(toIndentedString(accuracyRadius)).append("\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    timezone: ").append(toIndentedString(timezone)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    continent: ").append(toIndentedString(continent)).append("\n");
    sb.append("    subdivisions: ").append(toIndentedString(subdivisions)).append("\n");
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

