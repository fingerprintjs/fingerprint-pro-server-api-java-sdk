package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A confidence rating for the VPN detection result — \"low\", \"medium\", or \"high\". Depends on the combination of results returned from all VPN detection methods.
 */
public enum VPNConfidence {
  
  LOW("low"),
  
  MEDIUM("medium"),
  
  HIGH("high");

  private String value;

  VPNConfidence(String value) {
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
  public static VPNConfidence fromValue(String value) {
    for (VPNConfidence b : VPNConfidence.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    return null;
  }
}

