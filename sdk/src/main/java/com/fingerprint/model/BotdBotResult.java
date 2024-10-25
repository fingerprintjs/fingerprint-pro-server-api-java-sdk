package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Bot detection result:  * `notDetected` - the visitor is not a bot  * `good` - good bot detected, such as Google bot, Baidu Spider, AlexaBot and so on  * `bad` - bad bot detected, such as Selenium, Puppeteer, Playwright, headless browsers, and so on 
 */
public enum BotdBotResult {
  
  NOT_DETECTED("notDetected"),
  
  GOOD("good"),
  
  BAD("bad");

  private String value;

  BotdBotResult(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static BotdBotResult fromValue(String value) {
    for (BotdBotResult b : BotdBotResult.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    return null;
  }
}

