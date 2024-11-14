package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.BotdBot;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Contains all the information from Bot Detection product
 */

@Schema(description = "Contains all the information from Bot Detection product")
@JsonPropertyOrder({
  Botd.JSON_PROPERTY_BOT,
  Botd.JSON_PROPERTY_META,
  Botd.JSON_PROPERTY_LINKED_ID,
  Botd.JSON_PROPERTY_URL,
  Botd.JSON_PROPERTY_IP,
  Botd.JSON_PROPERTY_TIME,
  Botd.JSON_PROPERTY_USER_AGENT,
  Botd.JSON_PROPERTY_REQUEST_ID
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class Botd {
  public static final String JSON_PROPERTY_BOT = "bot";
  private BotdBot bot;

  public static final String JSON_PROPERTY_META = "meta";
  private Map<String, Object> meta = null;

  public static final String JSON_PROPERTY_LINKED_ID = "linkedId";
  private String linkedId;

  public static final String JSON_PROPERTY_URL = "url";
  private String url;

  public static final String JSON_PROPERTY_IP = "ip";
  private String ip;

  public static final String JSON_PROPERTY_TIME = "time";
  private OffsetDateTime time;

  public static final String JSON_PROPERTY_USER_AGENT = "userAgent";
  private String userAgent;

  public static final String JSON_PROPERTY_REQUEST_ID = "requestId";
  private String requestId;

  public Botd() {
  }

  public Botd bot(BotdBot bot) {
    this.bot = bot;
    return this;
  }

   /**
   * Get bot
   * @return bot
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_BOT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BotdBot getBot() {
    return bot;
  }


  @JsonProperty(JSON_PROPERTY_BOT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBot(BotdBot bot) {
    this.bot = bot;
  }


  public Botd meta(Map<String, Object> meta) {
    this.meta = meta;
    return this;
  }

  public Botd putmetaItem(String key, Object metaItem) {
    if (this.meta == null) {
      this.meta = new HashMap<>();
    }
    this.meta.put(key, metaItem);
    return this;
  }

   /**
   * A customer-provided value or an object that was sent with identification request.
   * @return meta
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "A customer-provided value or an object that was sent with identification request.")
  @JsonProperty(JSON_PROPERTY_META)
  @JsonInclude(content = JsonInclude.Include.ALWAYS, value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, Object> getMeta() {
    return meta;
  }


  @JsonProperty(JSON_PROPERTY_META)
  @JsonInclude(content = JsonInclude.Include.ALWAYS, value = JsonInclude.Include.USE_DEFAULTS)
  public void setMeta(Map<String, Object> meta) {
    this.meta = meta;
  }


  public Botd linkedId(String linkedId) {
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


  public Botd url(String url) {
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


  public Botd ip(String ip) {
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


  public Botd time(OffsetDateTime time) {
    this.time = time;
    return this;
  }

   /**
   * Time in UTC when the request from the JS agent was made. We recommend to treat requests that are older than 2 minutes as malicious. Otherwise, request replay attacks are possible.
   * @return time
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "Time in UTC when the request from the JS agent was made. We recommend to treat requests that are older than 2 minutes as malicious. Otherwise, request replay attacks are possible.")
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


  public Botd userAgent(String userAgent) {
    this.userAgent = userAgent;
    return this;
  }

   /**
   * Get userAgent
   * @return userAgent
  **/
  @jakarta.annotation.Nonnull
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_USER_AGENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getUserAgent() {
    return userAgent;
  }


  @JsonProperty(JSON_PROPERTY_USER_AGENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }


  public Botd requestId(String requestId) {
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


  /**
   * Return true if this Botd object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Botd botd = (Botd) o;
    return Objects.equals(this.bot, botd.bot) &&
        Objects.equals(this.meta, botd.meta) &&
        Objects.equals(this.linkedId, botd.linkedId) &&
        Objects.equals(this.url, botd.url) &&
        Objects.equals(this.ip, botd.ip) &&
        Objects.equals(this.time, botd.time) &&
        Objects.equals(this.userAgent, botd.userAgent) &&
        Objects.equals(this.requestId, botd.requestId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bot, meta, linkedId, url, ip, time, userAgent, requestId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Botd {\n");
    sb.append("    bot: ").append(toIndentedString(bot)).append("\n");
    sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
    sb.append("    linkedId: ").append(toIndentedString(linkedId)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    userAgent: ").append(toIndentedString(userAgent)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
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

