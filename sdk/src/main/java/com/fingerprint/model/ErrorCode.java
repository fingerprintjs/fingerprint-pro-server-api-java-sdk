package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Error code:  * `RequestCannotBeParsed` - the query parameters or JSON payload contains some errors            that prevented us from parsing it (wrong type/surpassed limits).  * `TokenRequired` - `Auth-API-Key` header is missing or empty.  * `TokenNotFound` - no Fingerprint application found for specified secret key.  * `SubscriptionNotActive` - Fingerprint application is not active.  * `WrongRegion` - server and application region differ.  * `FeatureNotEnabled` - this feature (for example, Delete API) is not enabled for your application.  * `RequestNotFound` - the specified request ID was not found. It never existed, expired, or it has been deleted.  * `VisitorNotFound` - The specified visitor ID was not found. It never existed or it may have already been deleted.  * `TooManyRequests` - the limit on secret API key requests per second has been exceeded.  * `429 Too Many Requests` - the limit on secret API key requests per second has been exceeded.  * `StateNotReady` - The event specified with request id is           not ready for updates yet. Try again.           This error happens in rare cases when update API is called immediately           after receiving the request id on the client. In case you need to send           information right away, we recommend using the JS agent API instead.  * `Failed` - internal server error. 
 */
public enum ErrorCode {
  
  REQUEST_CANNOT_BE_PARSED("RequestCannotBeParsed"),
  
  TOKEN_REQUIRED("TokenRequired"),
  
  TOKEN_NOT_FOUND("TokenNotFound"),
  
  SUBSCRIPTION_NOT_ACTIVE("SubscriptionNotActive"),
  
  WRONG_REGION("WrongRegion"),
  
  FEATURE_NOT_ENABLED("FeatureNotEnabled"),
  
  REQUEST_NOT_FOUND("RequestNotFound"),
  
  VISITOR_NOT_FOUND("VisitorNotFound"),
  
  TOO_MANY_REQUESTS("TooManyRequests"),
  
  _429_TOO_MANY_REQUESTS("429 Too Many Requests"),
  
  STATE_NOT_READY("StateNotReady"),
  
  FAILED("Failed");

  private String value;

  ErrorCode(String value) {
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
  public static ErrorCode fromValue(String value) {
    for (ErrorCode b : ErrorCode.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    return null;
  }
}

