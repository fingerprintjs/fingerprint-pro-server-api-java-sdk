/*
 * Fingerprint Pro Server API
 * Fingerprint Pro Server API allows you to get information about visitors and about individual events in a server environment. It can be used for data exports, decision-making, and data analysis scenarios. Server API is intended for server-side usage, it's not intended to be used from the client side, whether it's a browser or a mobile device. 
 *
 * The version of the OpenAPI document: 3
 * Contact: support@fingerprint.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.fingerprint.model;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.BrowserDetails;
import com.fingerprint.model.Confidence;
import com.fingerprint.model.DeprecatedIPLocation;
import com.fingerprint.model.SeenAt;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;


/**
 * ProductsResponseIdentificationData
 */
@JsonPropertyOrder({
  ProductsResponseIdentificationData.JSON_PROPERTY_REQUEST_ID,
  ProductsResponseIdentificationData.JSON_PROPERTY_BROWSER_DETAILS,
  ProductsResponseIdentificationData.JSON_PROPERTY_INCOGNITO,
  ProductsResponseIdentificationData.JSON_PROPERTY_IP,
  ProductsResponseIdentificationData.JSON_PROPERTY_IP_LOCATION,
  ProductsResponseIdentificationData.JSON_PROPERTY_TIMESTAMP,
  ProductsResponseIdentificationData.JSON_PROPERTY_TIME,
  ProductsResponseIdentificationData.JSON_PROPERTY_URL,
  ProductsResponseIdentificationData.JSON_PROPERTY_TAG,
  ProductsResponseIdentificationData.JSON_PROPERTY_LINKED_ID,
  ProductsResponseIdentificationData.JSON_PROPERTY_CONFIDENCE,
  ProductsResponseIdentificationData.JSON_PROPERTY_VISITOR_FOUND,
  ProductsResponseIdentificationData.JSON_PROPERTY_FIRST_SEEN_AT,
  ProductsResponseIdentificationData.JSON_PROPERTY_LAST_SEEN_AT,
  ProductsResponseIdentificationData.JSON_PROPERTY_VISITOR_ID
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ProductsResponseIdentificationData {
  public static final String JSON_PROPERTY_REQUEST_ID = "requestId";
  private String requestId;

  public static final String JSON_PROPERTY_BROWSER_DETAILS = "browserDetails";
  private BrowserDetails browserDetails;

  public static final String JSON_PROPERTY_INCOGNITO = "incognito";
  private Boolean incognito;

  public static final String JSON_PROPERTY_IP = "ip";
  private String ip;

  public static final String JSON_PROPERTY_IP_LOCATION = "ipLocation";
  private DeprecatedIPLocation ipLocation;

  public static final String JSON_PROPERTY_TIMESTAMP = "timestamp";
  private Long timestamp;

  public static final String JSON_PROPERTY_TIME = "time";
  private OffsetDateTime time;

  public static final String JSON_PROPERTY_URL = "url";
  private String url;

  public static final String JSON_PROPERTY_TAG = "tag";
  private Map<String, Object> tag = new HashMap<>();

  public static final String JSON_PROPERTY_LINKED_ID = "linkedId";
  private String linkedId;

  public static final String JSON_PROPERTY_CONFIDENCE = "confidence";
  private Confidence confidence;

  public static final String JSON_PROPERTY_VISITOR_FOUND = "visitorFound";
  private Boolean visitorFound;

  public static final String JSON_PROPERTY_FIRST_SEEN_AT = "firstSeenAt";
  private SeenAt firstSeenAt;

  public static final String JSON_PROPERTY_LAST_SEEN_AT = "lastSeenAt";
  private SeenAt lastSeenAt;

  public static final String JSON_PROPERTY_VISITOR_ID = "visitorId";
  private String visitorId;

  public ProductsResponseIdentificationData() {
  }

  public ProductsResponseIdentificationData requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * Unique identifier of the user&#39;s identification request.
   * @return requestId
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "1654815516083.OX6kx8", required = true, value = "Unique identifier of the user's identification request.")
  @JsonProperty(JSON_PROPERTY_REQUEST_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getRequestId() {
    return requestId;
  }


  @JsonProperty(JSON_PROPERTY_REQUEST_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }


  public ProductsResponseIdentificationData browserDetails(BrowserDetails browserDetails) {
    this.browserDetails = browserDetails;
    return this;
  }

   /**
   * Get browserDetails
   * @return browserDetails
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_BROWSER_DETAILS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BrowserDetails getBrowserDetails() {
    return browserDetails;
  }


  @JsonProperty(JSON_PROPERTY_BROWSER_DETAILS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBrowserDetails(BrowserDetails browserDetails) {
    this.browserDetails = browserDetails;
  }


  public ProductsResponseIdentificationData incognito(Boolean incognito) {
    this.incognito = incognito;
    return this;
  }

   /**
   * Flag if user used incognito session.
   * @return incognito
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Flag if user used incognito session.")
  @JsonProperty(JSON_PROPERTY_INCOGNITO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getIncognito() {
    return incognito;
  }


  @JsonProperty(JSON_PROPERTY_INCOGNITO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIncognito(Boolean incognito) {
    this.incognito = incognito;
  }


  public ProductsResponseIdentificationData ip(String ip) {
    this.ip = ip;
    return this;
  }

   /**
   * Get ip
   * @return ip
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "8.8.8.8", required = true, value = "")
  @JsonProperty(JSON_PROPERTY_IP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getIp() {
    return ip;
  }


  @JsonProperty(JSON_PROPERTY_IP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIp(String ip) {
    this.ip = ip;
  }


  public ProductsResponseIdentificationData ipLocation(DeprecatedIPLocation ipLocation) {
    this.ipLocation = ipLocation;
    return this;
  }

   /**
   * Get ipLocation
   * @return ipLocation
   * @deprecated
  **/
  @Deprecated
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_IP_LOCATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public DeprecatedIPLocation getIpLocation() {
    return ipLocation;
  }


  @JsonProperty(JSON_PROPERTY_IP_LOCATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIpLocation(DeprecatedIPLocation ipLocation) {
    this.ipLocation = ipLocation;
  }


  public ProductsResponseIdentificationData timestamp(Long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

   /**
   * Timestamp of the event with millisecond precision in Unix time.
   * @return timestamp
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "1654815516086", required = true, value = "Timestamp of the event with millisecond precision in Unix time.")
  @JsonProperty(JSON_PROPERTY_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getTimestamp() {
    return timestamp;
  }


  @JsonProperty(JSON_PROPERTY_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }


  public ProductsResponseIdentificationData time(OffsetDateTime time) {
    this.time = time;
    return this;
  }

   /**
   * Time expressed according to ISO 8601 in UTC format.
   * @return time
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "2022-06-09T22:58:36Z", required = true, value = "Time expressed according to ISO 8601 in UTC format.")
  @JsonProperty(JSON_PROPERTY_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getTime() {
    return time;
  }


  @JsonProperty(JSON_PROPERTY_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTime(OffsetDateTime time) {
    this.time = time;
  }


  public ProductsResponseIdentificationData url(String url) {
    this.url = url;
    return this;
  }

   /**
   * Page URL from which the identification request was sent.
   * @return url
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "https://some.website/path?query=params", required = true, value = "Page URL from which the identification request was sent.")
  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getUrl() {
    return url;
  }


  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUrl(String url) {
    this.url = url;
  }


  public ProductsResponseIdentificationData tag(Map<String, Object> tag) {
    this.tag = tag;
    return this;
  }

  public ProductsResponseIdentificationData putTagItem(String key, Object tagItem) {
    this.tag.put(key, tagItem);
    return this;
  }

   /**
   * A customer-provided value or an object that was sent with identification request.
   * @return tag
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A customer-provided value or an object that was sent with identification request.")
  @JsonProperty(JSON_PROPERTY_TAG)
  @JsonInclude(content = JsonInclude.Include.ALWAYS, value = JsonInclude.Include.ALWAYS)

  public Map<String, Object> getTag() {
    return tag;
  }


  @JsonProperty(JSON_PROPERTY_TAG)
  @JsonInclude(content = JsonInclude.Include.ALWAYS, value = JsonInclude.Include.ALWAYS)
  public void setTag(Map<String, Object> tag) {
    this.tag = tag;
  }


  public ProductsResponseIdentificationData linkedId(String linkedId) {
    this.linkedId = linkedId;
    return this;
  }

   /**
   * A customer-provided id that was sent with identification request.
   * @return linkedId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "someID", value = "A customer-provided id that was sent with identification request.")
  @JsonProperty(JSON_PROPERTY_LINKED_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLinkedId() {
    return linkedId;
  }


  @JsonProperty(JSON_PROPERTY_LINKED_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLinkedId(String linkedId) {
    this.linkedId = linkedId;
  }


  public ProductsResponseIdentificationData confidence(Confidence confidence) {
    this.confidence = confidence;
    return this;
  }

   /**
   * Get confidence
   * @return confidence
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CONFIDENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Confidence getConfidence() {
    return confidence;
  }


  @JsonProperty(JSON_PROPERTY_CONFIDENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setConfidence(Confidence confidence) {
    this.confidence = confidence;
  }


  public ProductsResponseIdentificationData visitorFound(Boolean visitorFound) {
    this.visitorFound = visitorFound;
    return this;
  }

   /**
   * Attribute represents if a visitor had been identified before.
   * @return visitorFound
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Attribute represents if a visitor had been identified before.")
  @JsonProperty(JSON_PROPERTY_VISITOR_FOUND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getVisitorFound() {
    return visitorFound;
  }


  @JsonProperty(JSON_PROPERTY_VISITOR_FOUND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setVisitorFound(Boolean visitorFound) {
    this.visitorFound = visitorFound;
  }


  public ProductsResponseIdentificationData firstSeenAt(SeenAt firstSeenAt) {
    this.firstSeenAt = firstSeenAt;
    return this;
  }

   /**
   * Get firstSeenAt
   * @return firstSeenAt
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_FIRST_SEEN_AT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public SeenAt getFirstSeenAt() {
    return firstSeenAt;
  }


  @JsonProperty(JSON_PROPERTY_FIRST_SEEN_AT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFirstSeenAt(SeenAt firstSeenAt) {
    this.firstSeenAt = firstSeenAt;
  }


  public ProductsResponseIdentificationData lastSeenAt(SeenAt lastSeenAt) {
    this.lastSeenAt = lastSeenAt;
    return this;
  }

   /**
   * Get lastSeenAt
   * @return lastSeenAt
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_LAST_SEEN_AT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public SeenAt getLastSeenAt() {
    return lastSeenAt;
  }


  @JsonProperty(JSON_PROPERTY_LAST_SEEN_AT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLastSeenAt(SeenAt lastSeenAt) {
    this.lastSeenAt = lastSeenAt;
  }


  public ProductsResponseIdentificationData visitorId(String visitorId) {
    this.visitorId = visitorId;
    return this;
  }

   /**
   * String of 20 characters that uniquely identifies the visitor&#39;s browser. 
   * @return visitorId
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "[\"Ibk1527CUFmcnjLwIs4A\"]", required = true, value = "String of 20 characters that uniquely identifies the visitor's browser. ")
  @JsonProperty(JSON_PROPERTY_VISITOR_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getVisitorId() {
    return visitorId;
  }


  @JsonProperty(JSON_PROPERTY_VISITOR_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setVisitorId(String visitorId) {
    this.visitorId = visitorId;
  }


  /**
   * Return true if this ProductsResponseIdentificationData object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductsResponseIdentificationData productsResponseIdentificationData = (ProductsResponseIdentificationData) o;
    return Objects.equals(this.requestId, productsResponseIdentificationData.requestId) &&
        Objects.equals(this.browserDetails, productsResponseIdentificationData.browserDetails) &&
        Objects.equals(this.incognito, productsResponseIdentificationData.incognito) &&
        Objects.equals(this.ip, productsResponseIdentificationData.ip) &&
        Objects.equals(this.ipLocation, productsResponseIdentificationData.ipLocation) &&
        Objects.equals(this.timestamp, productsResponseIdentificationData.timestamp) &&
        Objects.equals(this.time, productsResponseIdentificationData.time) &&
        Objects.equals(this.url, productsResponseIdentificationData.url) &&
        Objects.equals(this.tag, productsResponseIdentificationData.tag) &&
        Objects.equals(this.linkedId, productsResponseIdentificationData.linkedId) &&
        Objects.equals(this.confidence, productsResponseIdentificationData.confidence) &&
        Objects.equals(this.visitorFound, productsResponseIdentificationData.visitorFound) &&
        Objects.equals(this.firstSeenAt, productsResponseIdentificationData.firstSeenAt) &&
        Objects.equals(this.lastSeenAt, productsResponseIdentificationData.lastSeenAt) &&
        Objects.equals(this.visitorId, productsResponseIdentificationData.visitorId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestId, browserDetails, incognito, ip, ipLocation, timestamp, time, url, tag, linkedId, confidence, visitorFound, firstSeenAt, lastSeenAt, visitorId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductsResponseIdentificationData {\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    browserDetails: ").append(toIndentedString(browserDetails)).append("\n");
    sb.append("    incognito: ").append(toIndentedString(incognito)).append("\n");
    sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
    sb.append("    ipLocation: ").append(toIndentedString(ipLocation)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
    sb.append("    linkedId: ").append(toIndentedString(linkedId)).append("\n");
    sb.append("    confidence: ").append(toIndentedString(confidence)).append("\n");
    sb.append("    visitorFound: ").append(toIndentedString(visitorFound)).append("\n");
    sb.append("    firstSeenAt: ").append(toIndentedString(firstSeenAt)).append("\n");
    sb.append("    lastSeenAt: ").append(toIndentedString(lastSeenAt)).append("\n");
    sb.append("    visitorId: ").append(toIndentedString(visitorId)).append("\n");
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

