package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.BrowserDetails;
import com.fingerprint.model.DeprecatedGeolocation;
import com.fingerprint.model.IdentificationConfidence;
import com.fingerprint.model.IdentificationSeenAt;
import com.fingerprint.model.RawDeviceAttribute;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Identification
 */


@JsonPropertyOrder({
  Identification.JSON_PROPERTY_VISITOR_ID,
  Identification.JSON_PROPERTY_REQUEST_ID,
  Identification.JSON_PROPERTY_BROWSER_DETAILS,
  Identification.JSON_PROPERTY_INCOGNITO,
  Identification.JSON_PROPERTY_IP,
  Identification.JSON_PROPERTY_IP_LOCATION,
  Identification.JSON_PROPERTY_LINKED_ID,
  Identification.JSON_PROPERTY_SUSPECT,
  Identification.JSON_PROPERTY_TIMESTAMP,
  Identification.JSON_PROPERTY_TIME,
  Identification.JSON_PROPERTY_URL,
  Identification.JSON_PROPERTY_TAG,
  Identification.JSON_PROPERTY_CONFIDENCE,
  Identification.JSON_PROPERTY_VISITOR_FOUND,
  Identification.JSON_PROPERTY_FIRST_SEEN_AT,
  Identification.JSON_PROPERTY_LAST_SEEN_AT,
  Identification.JSON_PROPERTY_COMPONENTS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class Identification {
  public static final String JSON_PROPERTY_VISITOR_ID = "visitorId";
  private String visitorId;

  public static final String JSON_PROPERTY_REQUEST_ID = "requestId";
  private String requestId;

  public static final String JSON_PROPERTY_BROWSER_DETAILS = "browserDetails";
  private BrowserDetails browserDetails;

  public static final String JSON_PROPERTY_INCOGNITO = "incognito";
  private Boolean incognito;

  public static final String JSON_PROPERTY_IP = "ip";
  private String ip;

  public static final String JSON_PROPERTY_IP_LOCATION = "ipLocation";
  private DeprecatedGeolocation ipLocation;

  public static final String JSON_PROPERTY_LINKED_ID = "linkedId";
  private String linkedId;

  public static final String JSON_PROPERTY_SUSPECT = "suspect";
  private Boolean suspect;

  public static final String JSON_PROPERTY_TIMESTAMP = "timestamp";
  private Long timestamp;

  public static final String JSON_PROPERTY_TIME = "time";
  private OffsetDateTime time;

  public static final String JSON_PROPERTY_URL = "url";
  private String url;

  public static final String JSON_PROPERTY_TAG = "tag";
  private Map<String, Object> tag = new HashMap<>();

  public static final String JSON_PROPERTY_CONFIDENCE = "confidence";
  private IdentificationConfidence confidence;

  public static final String JSON_PROPERTY_VISITOR_FOUND = "visitorFound";
  private Boolean visitorFound;

  public static final String JSON_PROPERTY_FIRST_SEEN_AT = "firstSeenAt";
  private IdentificationSeenAt firstSeenAt;

  public static final String JSON_PROPERTY_LAST_SEEN_AT = "lastSeenAt";
  private IdentificationSeenAt lastSeenAt;

  public static final String JSON_PROPERTY_COMPONENTS = "components";
  private Map<String, RawDeviceAttribute> components = null;

  public Identification() {
  }

  public Identification visitorId(String visitorId) {
    this.visitorId = visitorId;
    return this;
  }

   /**
   * String of 20 characters that uniquely identifies the visitor&#39;s browser.
   * @return visitorId
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "String of 20 characters that uniquely identifies the visitor's browser.")
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


  public Identification requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * Unique identifier of the user&#39;s request.
   * @return requestId
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "Unique identifier of the user's request.")
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


  public Identification browserDetails(BrowserDetails browserDetails) {
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


  public Identification incognito(Boolean incognito) {
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


  public Identification ip(String ip) {
    this.ip = ip;
    return this;
  }

   /**
   * IP address of the requesting browser or bot.
   * @return ip
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "IP address of the requesting browser or bot.")
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


  public Identification ipLocation(DeprecatedGeolocation ipLocation) {
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

  public DeprecatedGeolocation getIpLocation() {
    return ipLocation;
  }


  @JsonProperty(JSON_PROPERTY_IP_LOCATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIpLocation(DeprecatedGeolocation ipLocation) {
    this.ipLocation = ipLocation;
  }


  public Identification linkedId(String linkedId) {
    this.linkedId = linkedId;
    return this;
  }

   /**
   * A customer-provided id that was sent with the request.
   * @return linkedId
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "A customer-provided id that was sent with the request.")
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


  public Identification suspect(Boolean suspect) {
    this.suspect = suspect;
    return this;
  }

   /**
   * Field is &#x60;true&#x60; if you have previously set the &#x60;suspect&#x60; flag for this event using the [Server API Update event endpoint](https://dev.fingerprint.com/reference/updateevent).
   * @return suspect
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "Field is `true` if you have previously set the `suspect` flag for this event using the [Server API Update event endpoint](https://dev.fingerprint.com/reference/updateevent).")
  @JsonProperty(JSON_PROPERTY_SUSPECT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getSuspect() {
    return suspect;
  }


  @JsonProperty(JSON_PROPERTY_SUSPECT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSuspect(Boolean suspect) {
    this.suspect = suspect;
  }


  public Identification timestamp(Long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

   /**
   * Timestamp of the event with millisecond precision in Unix time.
   * @return timestamp
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "Timestamp of the event with millisecond precision in Unix time.")
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


  public Identification time(OffsetDateTime time) {
    this.time = time;
    return this;
  }

   /**
   * Time expressed according to ISO 8601 in UTC format, when the request from the JS agent was made. We recommend to treat requests that are older than 2 minutes as malicious. Otherwise, request replay attacks are possible.
   * @return time
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "Time expressed according to ISO 8601 in UTC format, when the request from the JS agent was made. We recommend to treat requests that are older than 2 minutes as malicious. Otherwise, request replay attacks are possible.")
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


  public Identification url(String url) {
    this.url = url;
    return this;
  }

   /**
   * Page URL from which the request was sent.
   * @return url
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "Page URL from which the request was sent.")
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


  public Identification tag(Map<String, Object> tag) {
    this.tag = tag;
    return this;
  }

  public Identification puttagItem(String key, Object tagItem) {
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


  public Identification confidence(IdentificationConfidence confidence) {
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

  public IdentificationConfidence getConfidence() {
    return confidence;
  }


  @JsonProperty(JSON_PROPERTY_CONFIDENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setConfidence(IdentificationConfidence confidence) {
    this.confidence = confidence;
  }


  public Identification visitorFound(Boolean visitorFound) {
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


  public Identification firstSeenAt(IdentificationSeenAt firstSeenAt) {
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

  public IdentificationSeenAt getFirstSeenAt() {
    return firstSeenAt;
  }


  @JsonProperty(JSON_PROPERTY_FIRST_SEEN_AT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFirstSeenAt(IdentificationSeenAt firstSeenAt) {
    this.firstSeenAt = firstSeenAt;
  }


  public Identification lastSeenAt(IdentificationSeenAt lastSeenAt) {
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

  public IdentificationSeenAt getLastSeenAt() {
    return lastSeenAt;
  }


  @JsonProperty(JSON_PROPERTY_LAST_SEEN_AT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLastSeenAt(IdentificationSeenAt lastSeenAt) {
    this.lastSeenAt = lastSeenAt;
  }


  public Identification components(Map<String, RawDeviceAttribute> components) {
    this.components = components;
    return this;
  }

  public Identification putcomponentsItem(String key, RawDeviceAttribute componentsItem) {
    if (this.components == null) {
      this.components = new HashMap<>();
    }
    this.components.put(key, componentsItem);
    return this;
  }

   /**
   * It includes 35+ raw browser identification attributes to provide Fingerprint users with even more information than our standard visitor ID provides. This enables Fingerprint users to not have to run our open-source product in conjunction with Fingerprint Pro Plus and Enterprise to get those additional attributes. Warning: The raw signals data can change at any moment as we improve the product. We cannot guarantee the internal shape of raw device attributes to be stable, so typical semantic versioning rules do not apply here. Use this data with caution without assuming a specific structure beyond the generic type provided here. 
   * @return components
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "It includes 35+ raw browser identification attributes to provide Fingerprint users with even more information than our standard visitor ID provides. This enables Fingerprint users to not have to run our open-source product in conjunction with Fingerprint Pro Plus and Enterprise to get those additional attributes. Warning: The raw signals data can change at any moment as we improve the product. We cannot guarantee the internal shape of raw device attributes to be stable, so typical semantic versioning rules do not apply here. Use this data with caution without assuming a specific structure beyond the generic type provided here. ")
  @JsonProperty(JSON_PROPERTY_COMPONENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, RawDeviceAttribute> getComponents() {
    return components;
  }


  @JsonProperty(JSON_PROPERTY_COMPONENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setComponents(Map<String, RawDeviceAttribute> components) {
    this.components = components;
  }


  /**
   * Return true if this Identification object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Identification identification = (Identification) o;
    return Objects.equals(this.visitorId, identification.visitorId) &&
        Objects.equals(this.requestId, identification.requestId) &&
        Objects.equals(this.browserDetails, identification.browserDetails) &&
        Objects.equals(this.incognito, identification.incognito) &&
        Objects.equals(this.ip, identification.ip) &&
        Objects.equals(this.ipLocation, identification.ipLocation) &&
        Objects.equals(this.linkedId, identification.linkedId) &&
        Objects.equals(this.suspect, identification.suspect) &&
        Objects.equals(this.timestamp, identification.timestamp) &&
        Objects.equals(this.time, identification.time) &&
        Objects.equals(this.url, identification.url) &&
        Objects.equals(this.tag, identification.tag) &&
        Objects.equals(this.confidence, identification.confidence) &&
        Objects.equals(this.visitorFound, identification.visitorFound) &&
        Objects.equals(this.firstSeenAt, identification.firstSeenAt) &&
        Objects.equals(this.lastSeenAt, identification.lastSeenAt) &&
        Objects.equals(this.components, identification.components);
  }

  @Override
  public int hashCode() {
    return Objects.hash(visitorId, requestId, browserDetails, incognito, ip, ipLocation, linkedId, suspect, timestamp, time, url, tag, confidence, visitorFound, firstSeenAt, lastSeenAt, components);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Identification {\n");
    sb.append("    visitorId: ").append(toIndentedString(visitorId)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    browserDetails: ").append(toIndentedString(browserDetails)).append("\n");
    sb.append("    incognito: ").append(toIndentedString(incognito)).append("\n");
    sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
    sb.append("    ipLocation: ").append(toIndentedString(ipLocation)).append("\n");
    sb.append("    linkedId: ").append(toIndentedString(linkedId)).append("\n");
    sb.append("    suspect: ").append(toIndentedString(suspect)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
    sb.append("    confidence: ").append(toIndentedString(confidence)).append("\n");
    sb.append("    visitorFound: ").append(toIndentedString(visitorFound)).append("\n");
    sb.append("    firstSeenAt: ").append(toIndentedString(firstSeenAt)).append("\n");
    sb.append("    lastSeenAt: ").append(toIndentedString(lastSeenAt)).append("\n");
    sb.append("    components: ").append(toIndentedString(components)).append("\n");
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

