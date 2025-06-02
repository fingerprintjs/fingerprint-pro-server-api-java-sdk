package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Confidence level of the proxy detection. If a proxy is not detected, confidence is \"high\". If it's detected, can be \"low\", \"medium\", or \"high\". 
 */
public enum ProxyConfidence {
  
  LOW("low"),
  
  MEDIUM("medium"),
  
  HIGH("high");

  private String value;

  ProxyConfidence(String value) {
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
  public static ProxyConfidence fromValue(String value) {
    for (ProxyConfidence b : ProxyConfidence.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    return null;
  }
}

