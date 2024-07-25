package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.BotdDetectionResult;
import java.time.OffsetDateTime;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Contains all the information from Bot Detection product
 */

@Schema(description = "Contains all the information from Bot Detection product")
@JsonPropertyOrder({
  BotdResult.JSON_PROPERTY_IP,
  BotdResult.JSON_PROPERTY_TIME,
  BotdResult.JSON_PROPERTY_URL,
  BotdResult.JSON_PROPERTY_USER_AGENT,
  BotdResult.JSON_PROPERTY_REQUEST_ID,
  BotdResult.JSON_PROPERTY_LINKED_ID,
  BotdResult.JSON_PROPERTY_BOT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class BotdResult {
  public static final String JSON_PROPERTY_IP = "ip";
  private String ip;

  public static final String JSON_PROPERTY_TIME = "time";
  private OffsetDateTime time;

  public static final String JSON_PROPERTY_URL = "url";
  private String url;

  public static final String JSON_PROPERTY_USER_AGENT = "userAgent";
  private String userAgent;

  public static final String JSON_PROPERTY_REQUEST_ID = "requestId";
  private String requestId;

  public static final String JSON_PROPERTY_LINKED_ID = "linkedId";
  private String linkedId;

  public static final String JSON_PROPERTY_BOT = "bot";
  private BotdDetectionResult bot;

  public BotdResult() {
  }

  public BotdResult ip(String ip) {
    this.ip = ip;
    return this;
  }

   /**
   * IP address of the requesting browser or bot.
   * @return ip
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "8.8.8.8", required = true, description = "IP address of the requesting browser or bot.")
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


  public BotdResult time(OffsetDateTime time) {
    this.time = time;
    return this;
  }

   /**
   * Time in UTC when the request from the JS agent was made. We recommend to treat requests that are older than 2 minutes as malicious. Otherwise, request replay attacks are possible
   * @return time
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "2022-06-09T22:58:36Z", required = true, description = "Time in UTC when the request from the JS agent was made. We recommend to treat requests that are older than 2 minutes as malicious. Otherwise, request replay attacks are possible")
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


  public BotdResult url(String url) {
    this.url = url;
    return this;
  }

   /**
   * Page URL from which identification request was sent.
   * @return url
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "https://example.com/login", required = true, description = "Page URL from which identification request was sent.")
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


  public BotdResult userAgent(String userAgent) {
    this.userAgent = userAgent;
    return this;
  }

   /**
   * Get userAgent
   * @return userAgent
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36", required = true, description = "")
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


  public BotdResult requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * Get requestId
   * @return requestId
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "1681392853693.lRiBBD", required = true, description = "")
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


  public BotdResult linkedId(String linkedId) {
    this.linkedId = linkedId;
    return this;
  }

   /**
   * Get linkedId
   * @return linkedId
  **/
  @jakarta.annotation.Nullable
  @Schema(example = "Automatic tests bot", description = "")
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


  public BotdResult bot(BotdDetectionResult bot) {
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

  public BotdDetectionResult getBot() {
    return bot;
  }


  @JsonProperty(JSON_PROPERTY_BOT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBot(BotdDetectionResult bot) {
    this.bot = bot;
  }


  /**
   * Return true if this BotdResult object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BotdResult botdResult = (BotdResult) o;
    return Objects.equals(this.ip, botdResult.ip) &&
        Objects.equals(this.time, botdResult.time) &&
        Objects.equals(this.url, botdResult.url) &&
        Objects.equals(this.userAgent, botdResult.userAgent) &&
        Objects.equals(this.requestId, botdResult.requestId) &&
        Objects.equals(this.linkedId, botdResult.linkedId) &&
        Objects.equals(this.bot, botdResult.bot);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ip, time, url, userAgent, requestId, linkedId, bot);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BotdResult {\n");
    sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    userAgent: ").append(toIndentedString(userAgent)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    linkedId: ").append(toIndentedString(linkedId)).append("\n");
    sb.append("    bot: ").append(toIndentedString(bot)).append("\n");
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

