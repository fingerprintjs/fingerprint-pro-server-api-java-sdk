/*
 * Fingerprint Pro Server API
 * Fingerprint Pro Server API allows you to get information about visitors and about individual events in a server environment. This API can be used for data exports, decision-making, and data analysis scenarios.
 *
 * OpenAPI spec version: 3
 * Contact: support@fingerprint.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.fingerprint.models;

import java.util.Objects;
import java.util.Arrays;
import com.fingerprint.models.BotdDetectionResult;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import org.threeten.bp.OffsetDateTime;
/**
 * Contains all the information from Bot Detection product
 */
@ApiModel(description = "Contains all the information from Bot Detection product")
public class BotdResult {
  @SerializedName("ip")
  private String ip = null;

  @SerializedName("time")
  private OffsetDateTime time = null;

  @SerializedName("url")
  private String url = null;

  @SerializedName("bot")
  private BotdDetectionResult bot = null;

  public BotdResult ip(String ip) {
    this.ip = ip;
    return this;
  }

   /**
   * IP address of the requesting browser or bot.
   * @return ip
  **/
  @ApiModelProperty(example = "8.8.8.8", required = true, value = "IP address of the requesting browser or bot.")
  public String getIp() {
    return ip;
  }

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
  @ApiModelProperty(example = "2022-06-09T22:58:36Z", required = true, value = "Time in UTC when the request from the JS agent was made. We recommend to treat requests that are older than 2 minutes as malicious. Otherwise, request replay attacks are possible")
  public OffsetDateTime getTime() {
    return time;
  }

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
  @ApiModelProperty(example = "https://example.com/login", required = true, value = "Page URL from which identification request was sent.")
  public String getUrl() {
    return url;
  }

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
  @ApiModelProperty(required = true, value = "")
  public BotdDetectionResult getBot() {
    return bot;
  }

  public void setBot(BotdDetectionResult bot) {
    this.bot = bot;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
