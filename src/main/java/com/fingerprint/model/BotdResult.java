/*
 * Fingerprint Pro Server API
 * Fingerprint Pro Server API allows you to get information about visitors and about individual events in a server environment. This API can be used for data exports, decision-making, and data analysis scenarios.
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
import com.fingerprint.model.BotdDetectionResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;


/**
 * Contains all the information from Bot Detection product
 */
@ApiModel(description = "Contains all the information from Bot Detection product")
@JsonPropertyOrder({
  BotdResult.JSON_PROPERTY_IP,
  BotdResult.JSON_PROPERTY_TIME,
  BotdResult.JSON_PROPERTY_URL,
  BotdResult.JSON_PROPERTY_BOT
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-24T04:06:37.641076+03:00[Europe/Istanbul]")
public class BotdResult {
  public static final String JSON_PROPERTY_IP = "ip";
  private String ip;

  public static final String JSON_PROPERTY_TIME = "time";
  private OffsetDateTime time;

  public static final String JSON_PROPERTY_URL = "url";
  private String url;

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
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "8.8.8.8", required = true, value = "IP address of the requesting browser or bot.")
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
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "2022-06-09T22:58:36Z", required = true, value = "Time in UTC when the request from the JS agent was made. We recommend to treat requests that are older than 2 minutes as malicious. Otherwise, request replay attacks are possible")
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
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "https://example.com/login", required = true, value = "Page URL from which identification request was sent.")
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


  public BotdResult bot(BotdDetectionResult bot) {
    this.bot = bot;
    return this;
  }

   /**
   * Get bot
   * @return bot
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
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
        Objects.equals(this.bot, botdResult.bot);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ip, time, url, bot);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BotdResult {\n");
    sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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
