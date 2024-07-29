package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.BrowserDetails;
import com.fingerprint.model.Confidence;
import com.fingerprint.model.DeprecatedIPLocation;
import com.fingerprint.model.SeenAt;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

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
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
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
  @jakarta.annotation.Nonnull
  @Schema(example = "1654815516083.OX6kx8", required = true, description = "Unique identifier of the user's identification request.")
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
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
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
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "Flag if user used incognito session.")
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
  @jakarta.annotation.Nonnull
  @Schema(example = "8.8.8.8", required = true, description = "")
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
  @jakarta.annotation.Nullable
  @Schema(description = "")
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
  @jakarta.annotation.Nonnull
  @Schema(example = "1654815516086", required = true, description = "Timestamp of the event with millisecond precision in Unix time.")
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
  @jakarta.annotation.Nonnull
  @Schema(example = "2022-06-09T22:58:36Z", required = true, description = "Time expressed according to ISO 8601 in UTC format.")
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
  @jakarta.annotation.Nonnull
  @Schema(example = "https://some.website/path?query=params", required = true, description = "Page URL from which the identification request was sent.")
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

  public ProductsResponseIdentificationData puttagItem(String key, Object tagItem) {
    this.tag.put(key, tagItem);
    return this;
  }

   /**
   * A customer-provided value or an object that was sent with identification request.
   * @return tag
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "A customer-provided value or an object that was sent with identification request.")
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
  @jakarta.annotation.Nullable
  @Schema(example = "someID", description = "A customer-provided id that was sent with identification request.")
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
  @jakarta.annotation.Nullable
  @Schema(description = "")
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
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "Attribute represents if a visitor had been identified before.")
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
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
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
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
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
  @jakarta.annotation.Nonnull
  @Schema(example = "[\"Ibk1527CUFmcnjLwIs4A\"]", required = true, description = "String of 20 characters that uniquely identifies the visitor's browser. ")
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

