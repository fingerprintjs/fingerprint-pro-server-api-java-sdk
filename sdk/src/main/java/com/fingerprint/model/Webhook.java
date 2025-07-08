package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.BotdBot;
import com.fingerprint.model.BrowserDetails;
import com.fingerprint.model.DeprecatedGeolocation;
import com.fingerprint.model.IdentificationConfidence;
import com.fingerprint.model.IdentificationSeenAt;
import com.fingerprint.model.RawDeviceAttribute;
import com.fingerprint.model.WebhookClonedApp;
import com.fingerprint.model.WebhookDeveloperTools;
import com.fingerprint.model.WebhookEmulator;
import com.fingerprint.model.WebhookFactoryReset;
import com.fingerprint.model.WebhookFrida;
import com.fingerprint.model.WebhookHighActivity;
import com.fingerprint.model.WebhookIPBlocklist;
import com.fingerprint.model.WebhookIPInfo;
import com.fingerprint.model.WebhookJailbroken;
import com.fingerprint.model.WebhookLocationSpoofing;
import com.fingerprint.model.WebhookMitMAttack;
import com.fingerprint.model.WebhookPrivacySettings;
import com.fingerprint.model.WebhookProxy;
import com.fingerprint.model.WebhookRemoteControl;
import com.fingerprint.model.WebhookRootApps;
import com.fingerprint.model.WebhookSuspectScore;
import com.fingerprint.model.WebhookTampering;
import com.fingerprint.model.WebhookTor;
import com.fingerprint.model.WebhookVPN;
import com.fingerprint.model.WebhookVelocity;
import com.fingerprint.model.WebhookVirtualMachine;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Webhook
 */


@JsonPropertyOrder({
  Webhook.JSON_PROPERTY_REQUEST_ID,
  Webhook.JSON_PROPERTY_URL,
  Webhook.JSON_PROPERTY_IP,
  Webhook.JSON_PROPERTY_ENVIRONMENT_ID,
  Webhook.JSON_PROPERTY_TAG,
  Webhook.JSON_PROPERTY_TIME,
  Webhook.JSON_PROPERTY_TIMESTAMP,
  Webhook.JSON_PROPERTY_IP_LOCATION,
  Webhook.JSON_PROPERTY_LINKED_ID,
  Webhook.JSON_PROPERTY_VISITOR_ID,
  Webhook.JSON_PROPERTY_VISITOR_FOUND,
  Webhook.JSON_PROPERTY_CONFIDENCE,
  Webhook.JSON_PROPERTY_FIRST_SEEN_AT,
  Webhook.JSON_PROPERTY_LAST_SEEN_AT,
  Webhook.JSON_PROPERTY_BROWSER_DETAILS,
  Webhook.JSON_PROPERTY_INCOGNITO,
  Webhook.JSON_PROPERTY_CLIENT_REFERRER,
  Webhook.JSON_PROPERTY_COMPONENTS,
  Webhook.JSON_PROPERTY_BOT,
  Webhook.JSON_PROPERTY_USER_AGENT,
  Webhook.JSON_PROPERTY_ROOT_APPS,
  Webhook.JSON_PROPERTY_EMULATOR,
  Webhook.JSON_PROPERTY_IP_INFO,
  Webhook.JSON_PROPERTY_IP_BLOCKLIST,
  Webhook.JSON_PROPERTY_TOR,
  Webhook.JSON_PROPERTY_VPN,
  Webhook.JSON_PROPERTY_PROXY,
  Webhook.JSON_PROPERTY_TAMPERING,
  Webhook.JSON_PROPERTY_CLONED_APP,
  Webhook.JSON_PROPERTY_FACTORY_RESET,
  Webhook.JSON_PROPERTY_JAILBROKEN,
  Webhook.JSON_PROPERTY_FRIDA,
  Webhook.JSON_PROPERTY_PRIVACY_SETTINGS,
  Webhook.JSON_PROPERTY_VIRTUAL_MACHINE,
  Webhook.JSON_PROPERTY_RAW_DEVICE_ATTRIBUTES,
  Webhook.JSON_PROPERTY_HIGH_ACTIVITY,
  Webhook.JSON_PROPERTY_LOCATION_SPOOFING,
  Webhook.JSON_PROPERTY_SUSPECT_SCORE,
  Webhook.JSON_PROPERTY_REMOTE_CONTROL,
  Webhook.JSON_PROPERTY_VELOCITY,
  Webhook.JSON_PROPERTY_DEVELOPER_TOOLS,
  Webhook.JSON_PROPERTY_MITM_ATTACK,
  Webhook.JSON_PROPERTY_REPLAYED
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class Webhook {
  public static final String JSON_PROPERTY_REQUEST_ID = "requestId";
  private String requestId;

  public static final String JSON_PROPERTY_URL = "url";
  private String url;

  public static final String JSON_PROPERTY_IP = "ip";
  private String ip;

  public static final String JSON_PROPERTY_ENVIRONMENT_ID = "environmentId";
  private String environmentId;

  public static final String JSON_PROPERTY_TAG = "tag";
  private Map<String, Object> tag = null;

  public static final String JSON_PROPERTY_TIME = "time";
  private OffsetDateTime time;

  public static final String JSON_PROPERTY_TIMESTAMP = "timestamp";
  private Long timestamp;

  public static final String JSON_PROPERTY_IP_LOCATION = "ipLocation";
  private DeprecatedGeolocation ipLocation;

  public static final String JSON_PROPERTY_LINKED_ID = "linkedId";
  private String linkedId;

  public static final String JSON_PROPERTY_VISITOR_ID = "visitorId";
  private String visitorId;

  public static final String JSON_PROPERTY_VISITOR_FOUND = "visitorFound";
  private Boolean visitorFound;

  public static final String JSON_PROPERTY_CONFIDENCE = "confidence";
  private IdentificationConfidence confidence;

  public static final String JSON_PROPERTY_FIRST_SEEN_AT = "firstSeenAt";
  private IdentificationSeenAt firstSeenAt;

  public static final String JSON_PROPERTY_LAST_SEEN_AT = "lastSeenAt";
  private IdentificationSeenAt lastSeenAt;

  public static final String JSON_PROPERTY_BROWSER_DETAILS = "browserDetails";
  private BrowserDetails browserDetails;

  public static final String JSON_PROPERTY_INCOGNITO = "incognito";
  private Boolean incognito;

  public static final String JSON_PROPERTY_CLIENT_REFERRER = "clientReferrer";
  private String clientReferrer;

  public static final String JSON_PROPERTY_COMPONENTS = "components";
  private Map<String, RawDeviceAttribute> components = null;

  public static final String JSON_PROPERTY_BOT = "bot";
  private BotdBot bot;

  public static final String JSON_PROPERTY_USER_AGENT = "userAgent";
  private String userAgent;

  public static final String JSON_PROPERTY_ROOT_APPS = "rootApps";
  private WebhookRootApps rootApps;

  public static final String JSON_PROPERTY_EMULATOR = "emulator";
  private WebhookEmulator emulator;

  public static final String JSON_PROPERTY_IP_INFO = "ipInfo";
  private WebhookIPInfo ipInfo;

  public static final String JSON_PROPERTY_IP_BLOCKLIST = "ipBlocklist";
  private WebhookIPBlocklist ipBlocklist;

  public static final String JSON_PROPERTY_TOR = "tor";
  private WebhookTor tor;

  public static final String JSON_PROPERTY_VPN = "vpn";
  private WebhookVPN vpn;

  public static final String JSON_PROPERTY_PROXY = "proxy";
  private WebhookProxy proxy;

  public static final String JSON_PROPERTY_TAMPERING = "tampering";
  private WebhookTampering tampering;

  public static final String JSON_PROPERTY_CLONED_APP = "clonedApp";
  private WebhookClonedApp clonedApp;

  public static final String JSON_PROPERTY_FACTORY_RESET = "factoryReset";
  private WebhookFactoryReset factoryReset;

  public static final String JSON_PROPERTY_JAILBROKEN = "jailbroken";
  private WebhookJailbroken jailbroken;

  public static final String JSON_PROPERTY_FRIDA = "frida";
  private WebhookFrida frida;

  public static final String JSON_PROPERTY_PRIVACY_SETTINGS = "privacySettings";
  private WebhookPrivacySettings privacySettings;

  public static final String JSON_PROPERTY_VIRTUAL_MACHINE = "virtualMachine";
  private WebhookVirtualMachine virtualMachine;

  public static final String JSON_PROPERTY_RAW_DEVICE_ATTRIBUTES = "rawDeviceAttributes";
  private Map<String, RawDeviceAttribute> rawDeviceAttributes = null;

  public static final String JSON_PROPERTY_HIGH_ACTIVITY = "highActivity";
  private WebhookHighActivity highActivity;

  public static final String JSON_PROPERTY_LOCATION_SPOOFING = "locationSpoofing";
  private WebhookLocationSpoofing locationSpoofing;

  public static final String JSON_PROPERTY_SUSPECT_SCORE = "suspectScore";
  private WebhookSuspectScore suspectScore;

  public static final String JSON_PROPERTY_REMOTE_CONTROL = "remoteControl";
  private WebhookRemoteControl remoteControl;

  public static final String JSON_PROPERTY_VELOCITY = "velocity";
  private WebhookVelocity velocity;

  public static final String JSON_PROPERTY_DEVELOPER_TOOLS = "developerTools";
  private WebhookDeveloperTools developerTools;

  public static final String JSON_PROPERTY_MITM_ATTACK = "mitmAttack";
  private WebhookMitMAttack mitmAttack;

  public static final String JSON_PROPERTY_REPLAYED = "replayed";
  private Boolean replayed;

  public Webhook() {
  }

  public Webhook requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * Unique identifier of the user's request.
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


  public Webhook url(String url) {
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


  public Webhook ip(String ip) {
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


  public Webhook environmentId(String environmentId) {
    this.environmentId = environmentId;
    return this;
  }

   /**
   * Environment ID of the event.
   * @return environmentId
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "Environment ID of the event.")
  @JsonProperty(JSON_PROPERTY_ENVIRONMENT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEnvironmentId() {
    return environmentId;
  }


  @JsonProperty(JSON_PROPERTY_ENVIRONMENT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEnvironmentId(String environmentId) {
    this.environmentId = environmentId;
  }


  public Webhook tag(Map<String, Object> tag) {
    this.tag = tag;
    return this;
  }

  public Webhook puttagItem(String key, Object tagItem) {
    if (this.tag == null) {
      this.tag = new HashMap<>();
    }
    this.tag.put(key, tagItem);
    return this;
  }

   /**
   * A customer-provided value or an object that was sent with identification request.
   * @return tag
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "A customer-provided value or an object that was sent with identification request.")
  @JsonProperty(JSON_PROPERTY_TAG)
  @JsonInclude(content = JsonInclude.Include.ALWAYS, value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, Object> getTag() {
    return tag;
  }


  @JsonProperty(JSON_PROPERTY_TAG)
  @JsonInclude(content = JsonInclude.Include.ALWAYS, value = JsonInclude.Include.USE_DEFAULTS)
  public void setTag(Map<String, Object> tag) {
    this.tag = tag;
  }


  public Webhook time(OffsetDateTime time) {
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


  public Webhook timestamp(Long timestamp) {
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


  public Webhook ipLocation(DeprecatedGeolocation ipLocation) {
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


  public Webhook linkedId(String linkedId) {
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


  public Webhook visitorId(String visitorId) {
    this.visitorId = visitorId;
    return this;
  }

   /**
   * String of 20 characters that uniquely identifies the visitor's browser.
   * @return visitorId
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "String of 20 characters that uniquely identifies the visitor's browser.")
  @JsonProperty(JSON_PROPERTY_VISITOR_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getVisitorId() {
    return visitorId;
  }


  @JsonProperty(JSON_PROPERTY_VISITOR_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVisitorId(String visitorId) {
    this.visitorId = visitorId;
  }


  public Webhook visitorFound(Boolean visitorFound) {
    this.visitorFound = visitorFound;
    return this;
  }

   /**
   * Attribute represents if a visitor had been identified before.
   * @return visitorFound
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "Attribute represents if a visitor had been identified before.")
  @JsonProperty(JSON_PROPERTY_VISITOR_FOUND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getVisitorFound() {
    return visitorFound;
  }


  @JsonProperty(JSON_PROPERTY_VISITOR_FOUND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVisitorFound(Boolean visitorFound) {
    this.visitorFound = visitorFound;
  }


  public Webhook confidence(IdentificationConfidence confidence) {
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


  public Webhook firstSeenAt(IdentificationSeenAt firstSeenAt) {
    this.firstSeenAt = firstSeenAt;
    return this;
  }

   /**
   * Get firstSeenAt
   * @return firstSeenAt
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_FIRST_SEEN_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public IdentificationSeenAt getFirstSeenAt() {
    return firstSeenAt;
  }


  @JsonProperty(JSON_PROPERTY_FIRST_SEEN_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFirstSeenAt(IdentificationSeenAt firstSeenAt) {
    this.firstSeenAt = firstSeenAt;
  }


  public Webhook lastSeenAt(IdentificationSeenAt lastSeenAt) {
    this.lastSeenAt = lastSeenAt;
    return this;
  }

   /**
   * Get lastSeenAt
   * @return lastSeenAt
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_LAST_SEEN_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public IdentificationSeenAt getLastSeenAt() {
    return lastSeenAt;
  }


  @JsonProperty(JSON_PROPERTY_LAST_SEEN_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLastSeenAt(IdentificationSeenAt lastSeenAt) {
    this.lastSeenAt = lastSeenAt;
  }


  public Webhook browserDetails(BrowserDetails browserDetails) {
    this.browserDetails = browserDetails;
    return this;
  }

   /**
   * Get browserDetails
   * @return browserDetails
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_BROWSER_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BrowserDetails getBrowserDetails() {
    return browserDetails;
  }


  @JsonProperty(JSON_PROPERTY_BROWSER_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBrowserDetails(BrowserDetails browserDetails) {
    this.browserDetails = browserDetails;
  }


  public Webhook incognito(Boolean incognito) {
    this.incognito = incognito;
    return this;
  }

   /**
   * Flag if user used incognito session.
   * @return incognito
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "Flag if user used incognito session.")
  @JsonProperty(JSON_PROPERTY_INCOGNITO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getIncognito() {
    return incognito;
  }


  @JsonProperty(JSON_PROPERTY_INCOGNITO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIncognito(Boolean incognito) {
    this.incognito = incognito;
  }


  public Webhook clientReferrer(String clientReferrer) {
    this.clientReferrer = clientReferrer;
    return this;
  }

   /**
   * Get clientReferrer
   * @return clientReferrer
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_CLIENT_REFERRER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getClientReferrer() {
    return clientReferrer;
  }


  @JsonProperty(JSON_PROPERTY_CLIENT_REFERRER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setClientReferrer(String clientReferrer) {
    this.clientReferrer = clientReferrer;
  }


  public Webhook components(Map<String, RawDeviceAttribute> components) {
    this.components = components;
    return this;
  }

  public Webhook putcomponentsItem(String key, RawDeviceAttribute componentsItem) {
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


  public Webhook bot(BotdBot bot) {
    this.bot = bot;
    return this;
  }

   /**
   * Get bot
   * @return bot
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_BOT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BotdBot getBot() {
    return bot;
  }


  @JsonProperty(JSON_PROPERTY_BOT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBot(BotdBot bot) {
    this.bot = bot;
  }


  public Webhook userAgent(String userAgent) {
    this.userAgent = userAgent;
    return this;
  }

   /**
   * Get userAgent
   * @return userAgent
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_USER_AGENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getUserAgent() {
    return userAgent;
  }


  @JsonProperty(JSON_PROPERTY_USER_AGENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }


  public Webhook rootApps(WebhookRootApps rootApps) {
    this.rootApps = rootApps;
    return this;
  }

   /**
   * Get rootApps
   * @return rootApps
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_ROOT_APPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WebhookRootApps getRootApps() {
    return rootApps;
  }


  @JsonProperty(JSON_PROPERTY_ROOT_APPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRootApps(WebhookRootApps rootApps) {
    this.rootApps = rootApps;
  }


  public Webhook emulator(WebhookEmulator emulator) {
    this.emulator = emulator;
    return this;
  }

   /**
   * Get emulator
   * @return emulator
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_EMULATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WebhookEmulator getEmulator() {
    return emulator;
  }


  @JsonProperty(JSON_PROPERTY_EMULATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEmulator(WebhookEmulator emulator) {
    this.emulator = emulator;
  }


  public Webhook ipInfo(WebhookIPInfo ipInfo) {
    this.ipInfo = ipInfo;
    return this;
  }

   /**
   * Get ipInfo
   * @return ipInfo
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_IP_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WebhookIPInfo getIpInfo() {
    return ipInfo;
  }


  @JsonProperty(JSON_PROPERTY_IP_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIpInfo(WebhookIPInfo ipInfo) {
    this.ipInfo = ipInfo;
  }


  public Webhook ipBlocklist(WebhookIPBlocklist ipBlocklist) {
    this.ipBlocklist = ipBlocklist;
    return this;
  }

   /**
   * Get ipBlocklist
   * @return ipBlocklist
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_IP_BLOCKLIST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WebhookIPBlocklist getIpBlocklist() {
    return ipBlocklist;
  }


  @JsonProperty(JSON_PROPERTY_IP_BLOCKLIST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIpBlocklist(WebhookIPBlocklist ipBlocklist) {
    this.ipBlocklist = ipBlocklist;
  }


  public Webhook tor(WebhookTor tor) {
    this.tor = tor;
    return this;
  }

   /**
   * Get tor
   * @return tor
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_TOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WebhookTor getTor() {
    return tor;
  }


  @JsonProperty(JSON_PROPERTY_TOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTor(WebhookTor tor) {
    this.tor = tor;
  }


  public Webhook vpn(WebhookVPN vpn) {
    this.vpn = vpn;
    return this;
  }

   /**
   * Get vpn
   * @return vpn
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_VPN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WebhookVPN getVpn() {
    return vpn;
  }


  @JsonProperty(JSON_PROPERTY_VPN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVpn(WebhookVPN vpn) {
    this.vpn = vpn;
  }


  public Webhook proxy(WebhookProxy proxy) {
    this.proxy = proxy;
    return this;
  }

   /**
   * Get proxy
   * @return proxy
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_PROXY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WebhookProxy getProxy() {
    return proxy;
  }


  @JsonProperty(JSON_PROPERTY_PROXY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProxy(WebhookProxy proxy) {
    this.proxy = proxy;
  }


  public Webhook tampering(WebhookTampering tampering) {
    this.tampering = tampering;
    return this;
  }

   /**
   * Get tampering
   * @return tampering
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_TAMPERING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WebhookTampering getTampering() {
    return tampering;
  }


  @JsonProperty(JSON_PROPERTY_TAMPERING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTampering(WebhookTampering tampering) {
    this.tampering = tampering;
  }


  public Webhook clonedApp(WebhookClonedApp clonedApp) {
    this.clonedApp = clonedApp;
    return this;
  }

   /**
   * Get clonedApp
   * @return clonedApp
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_CLONED_APP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WebhookClonedApp getClonedApp() {
    return clonedApp;
  }


  @JsonProperty(JSON_PROPERTY_CLONED_APP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setClonedApp(WebhookClonedApp clonedApp) {
    this.clonedApp = clonedApp;
  }


  public Webhook factoryReset(WebhookFactoryReset factoryReset) {
    this.factoryReset = factoryReset;
    return this;
  }

   /**
   * Get factoryReset
   * @return factoryReset
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_FACTORY_RESET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WebhookFactoryReset getFactoryReset() {
    return factoryReset;
  }


  @JsonProperty(JSON_PROPERTY_FACTORY_RESET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFactoryReset(WebhookFactoryReset factoryReset) {
    this.factoryReset = factoryReset;
  }


  public Webhook jailbroken(WebhookJailbroken jailbroken) {
    this.jailbroken = jailbroken;
    return this;
  }

   /**
   * Get jailbroken
   * @return jailbroken
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_JAILBROKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WebhookJailbroken getJailbroken() {
    return jailbroken;
  }


  @JsonProperty(JSON_PROPERTY_JAILBROKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setJailbroken(WebhookJailbroken jailbroken) {
    this.jailbroken = jailbroken;
  }


  public Webhook frida(WebhookFrida frida) {
    this.frida = frida;
    return this;
  }

   /**
   * Get frida
   * @return frida
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_FRIDA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WebhookFrida getFrida() {
    return frida;
  }


  @JsonProperty(JSON_PROPERTY_FRIDA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFrida(WebhookFrida frida) {
    this.frida = frida;
  }


  public Webhook privacySettings(WebhookPrivacySettings privacySettings) {
    this.privacySettings = privacySettings;
    return this;
  }

   /**
   * Get privacySettings
   * @return privacySettings
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_PRIVACY_SETTINGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WebhookPrivacySettings getPrivacySettings() {
    return privacySettings;
  }


  @JsonProperty(JSON_PROPERTY_PRIVACY_SETTINGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrivacySettings(WebhookPrivacySettings privacySettings) {
    this.privacySettings = privacySettings;
  }


  public Webhook virtualMachine(WebhookVirtualMachine virtualMachine) {
    this.virtualMachine = virtualMachine;
    return this;
  }

   /**
   * Get virtualMachine
   * @return virtualMachine
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_VIRTUAL_MACHINE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WebhookVirtualMachine getVirtualMachine() {
    return virtualMachine;
  }


  @JsonProperty(JSON_PROPERTY_VIRTUAL_MACHINE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVirtualMachine(WebhookVirtualMachine virtualMachine) {
    this.virtualMachine = virtualMachine;
  }


  public Webhook rawDeviceAttributes(Map<String, RawDeviceAttribute> rawDeviceAttributes) {
    this.rawDeviceAttributes = rawDeviceAttributes;
    return this;
  }

  public Webhook putrawDeviceAttributesItem(String key, RawDeviceAttribute rawDeviceAttributesItem) {
    if (this.rawDeviceAttributes == null) {
      this.rawDeviceAttributes = new HashMap<>();
    }
    this.rawDeviceAttributes.put(key, rawDeviceAttributesItem);
    return this;
  }

   /**
   * It includes 35+ raw browser identification attributes to provide Fingerprint users with even more information than our standard visitor ID provides. This enables Fingerprint users to not have to run our open-source product in conjunction with Fingerprint Pro Plus and Enterprise to get those additional attributes. Warning: The raw signals data can change at any moment as we improve the product. We cannot guarantee the internal shape of raw device attributes to be stable, so typical semantic versioning rules do not apply here. Use this data with caution without assuming a specific structure beyond the generic type provided here. 
   * @return rawDeviceAttributes
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "It includes 35+ raw browser identification attributes to provide Fingerprint users with even more information than our standard visitor ID provides. This enables Fingerprint users to not have to run our open-source product in conjunction with Fingerprint Pro Plus and Enterprise to get those additional attributes. Warning: The raw signals data can change at any moment as we improve the product. We cannot guarantee the internal shape of raw device attributes to be stable, so typical semantic versioning rules do not apply here. Use this data with caution without assuming a specific structure beyond the generic type provided here. ")
  @JsonProperty(JSON_PROPERTY_RAW_DEVICE_ATTRIBUTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, RawDeviceAttribute> getRawDeviceAttributes() {
    return rawDeviceAttributes;
  }


  @JsonProperty(JSON_PROPERTY_RAW_DEVICE_ATTRIBUTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRawDeviceAttributes(Map<String, RawDeviceAttribute> rawDeviceAttributes) {
    this.rawDeviceAttributes = rawDeviceAttributes;
  }


  public Webhook highActivity(WebhookHighActivity highActivity) {
    this.highActivity = highActivity;
    return this;
  }

   /**
   * Get highActivity
   * @return highActivity
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_HIGH_ACTIVITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WebhookHighActivity getHighActivity() {
    return highActivity;
  }


  @JsonProperty(JSON_PROPERTY_HIGH_ACTIVITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHighActivity(WebhookHighActivity highActivity) {
    this.highActivity = highActivity;
  }


  public Webhook locationSpoofing(WebhookLocationSpoofing locationSpoofing) {
    this.locationSpoofing = locationSpoofing;
    return this;
  }

   /**
   * Get locationSpoofing
   * @return locationSpoofing
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_LOCATION_SPOOFING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WebhookLocationSpoofing getLocationSpoofing() {
    return locationSpoofing;
  }


  @JsonProperty(JSON_PROPERTY_LOCATION_SPOOFING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLocationSpoofing(WebhookLocationSpoofing locationSpoofing) {
    this.locationSpoofing = locationSpoofing;
  }


  public Webhook suspectScore(WebhookSuspectScore suspectScore) {
    this.suspectScore = suspectScore;
    return this;
  }

   /**
   * Get suspectScore
   * @return suspectScore
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_SUSPECT_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WebhookSuspectScore getSuspectScore() {
    return suspectScore;
  }


  @JsonProperty(JSON_PROPERTY_SUSPECT_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSuspectScore(WebhookSuspectScore suspectScore) {
    this.suspectScore = suspectScore;
  }


  public Webhook remoteControl(WebhookRemoteControl remoteControl) {
    this.remoteControl = remoteControl;
    return this;
  }

   /**
   * Get remoteControl
   * @return remoteControl
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_REMOTE_CONTROL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WebhookRemoteControl getRemoteControl() {
    return remoteControl;
  }


  @JsonProperty(JSON_PROPERTY_REMOTE_CONTROL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRemoteControl(WebhookRemoteControl remoteControl) {
    this.remoteControl = remoteControl;
  }


  public Webhook velocity(WebhookVelocity velocity) {
    this.velocity = velocity;
    return this;
  }

   /**
   * Get velocity
   * @return velocity
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_VELOCITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WebhookVelocity getVelocity() {
    return velocity;
  }


  @JsonProperty(JSON_PROPERTY_VELOCITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVelocity(WebhookVelocity velocity) {
    this.velocity = velocity;
  }


  public Webhook developerTools(WebhookDeveloperTools developerTools) {
    this.developerTools = developerTools;
    return this;
  }

   /**
   * Get developerTools
   * @return developerTools
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_DEVELOPER_TOOLS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WebhookDeveloperTools getDeveloperTools() {
    return developerTools;
  }


  @JsonProperty(JSON_PROPERTY_DEVELOPER_TOOLS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDeveloperTools(WebhookDeveloperTools developerTools) {
    this.developerTools = developerTools;
  }


  public Webhook mitmAttack(WebhookMitMAttack mitmAttack) {
    this.mitmAttack = mitmAttack;
    return this;
  }

   /**
   * Get mitmAttack
   * @return mitmAttack
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_MITM_ATTACK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WebhookMitMAttack getMitmAttack() {
    return mitmAttack;
  }


  @JsonProperty(JSON_PROPERTY_MITM_ATTACK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMitmAttack(WebhookMitMAttack mitmAttack) {
    this.mitmAttack = mitmAttack;
  }


  public Webhook replayed(Boolean replayed) {
    this.replayed = replayed;
    return this;
  }

   /**
   * `true` if we determined that this payload was replayed, `false` otherwise. 
   * @return replayed
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "`true` if we determined that this payload was replayed, `false` otherwise. ")
  @JsonProperty(JSON_PROPERTY_REPLAYED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getReplayed() {
    return replayed;
  }


  @JsonProperty(JSON_PROPERTY_REPLAYED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReplayed(Boolean replayed) {
    this.replayed = replayed;
  }


  /**
   * Return true if this Webhook object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Webhook webhook = (Webhook) o;
    return Objects.equals(this.requestId, webhook.requestId) &&
        Objects.equals(this.url, webhook.url) &&
        Objects.equals(this.ip, webhook.ip) &&
        Objects.equals(this.environmentId, webhook.environmentId) &&
        Objects.equals(this.tag, webhook.tag) &&
        Objects.equals(this.time, webhook.time) &&
        Objects.equals(this.timestamp, webhook.timestamp) &&
        Objects.equals(this.ipLocation, webhook.ipLocation) &&
        Objects.equals(this.linkedId, webhook.linkedId) &&
        Objects.equals(this.visitorId, webhook.visitorId) &&
        Objects.equals(this.visitorFound, webhook.visitorFound) &&
        Objects.equals(this.confidence, webhook.confidence) &&
        Objects.equals(this.firstSeenAt, webhook.firstSeenAt) &&
        Objects.equals(this.lastSeenAt, webhook.lastSeenAt) &&
        Objects.equals(this.browserDetails, webhook.browserDetails) &&
        Objects.equals(this.incognito, webhook.incognito) &&
        Objects.equals(this.clientReferrer, webhook.clientReferrer) &&
        Objects.equals(this.components, webhook.components) &&
        Objects.equals(this.bot, webhook.bot) &&
        Objects.equals(this.userAgent, webhook.userAgent) &&
        Objects.equals(this.rootApps, webhook.rootApps) &&
        Objects.equals(this.emulator, webhook.emulator) &&
        Objects.equals(this.ipInfo, webhook.ipInfo) &&
        Objects.equals(this.ipBlocklist, webhook.ipBlocklist) &&
        Objects.equals(this.tor, webhook.tor) &&
        Objects.equals(this.vpn, webhook.vpn) &&
        Objects.equals(this.proxy, webhook.proxy) &&
        Objects.equals(this.tampering, webhook.tampering) &&
        Objects.equals(this.clonedApp, webhook.clonedApp) &&
        Objects.equals(this.factoryReset, webhook.factoryReset) &&
        Objects.equals(this.jailbroken, webhook.jailbroken) &&
        Objects.equals(this.frida, webhook.frida) &&
        Objects.equals(this.privacySettings, webhook.privacySettings) &&
        Objects.equals(this.virtualMachine, webhook.virtualMachine) &&
        Objects.equals(this.rawDeviceAttributes, webhook.rawDeviceAttributes) &&
        Objects.equals(this.highActivity, webhook.highActivity) &&
        Objects.equals(this.locationSpoofing, webhook.locationSpoofing) &&
        Objects.equals(this.suspectScore, webhook.suspectScore) &&
        Objects.equals(this.remoteControl, webhook.remoteControl) &&
        Objects.equals(this.velocity, webhook.velocity) &&
        Objects.equals(this.developerTools, webhook.developerTools) &&
        Objects.equals(this.mitmAttack, webhook.mitmAttack) &&
        Objects.equals(this.replayed, webhook.replayed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestId, url, ip, environmentId, tag, time, timestamp, ipLocation, linkedId, visitorId, visitorFound, confidence, firstSeenAt, lastSeenAt, browserDetails, incognito, clientReferrer, components, bot, userAgent, rootApps, emulator, ipInfo, ipBlocklist, tor, vpn, proxy, tampering, clonedApp, factoryReset, jailbroken, frida, privacySettings, virtualMachine, rawDeviceAttributes, highActivity, locationSpoofing, suspectScore, remoteControl, velocity, developerTools, mitmAttack, replayed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Webhook {\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
    sb.append("    environmentId: ").append(toIndentedString(environmentId)).append("\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    ipLocation: ").append(toIndentedString(ipLocation)).append("\n");
    sb.append("    linkedId: ").append(toIndentedString(linkedId)).append("\n");
    sb.append("    visitorId: ").append(toIndentedString(visitorId)).append("\n");
    sb.append("    visitorFound: ").append(toIndentedString(visitorFound)).append("\n");
    sb.append("    confidence: ").append(toIndentedString(confidence)).append("\n");
    sb.append("    firstSeenAt: ").append(toIndentedString(firstSeenAt)).append("\n");
    sb.append("    lastSeenAt: ").append(toIndentedString(lastSeenAt)).append("\n");
    sb.append("    browserDetails: ").append(toIndentedString(browserDetails)).append("\n");
    sb.append("    incognito: ").append(toIndentedString(incognito)).append("\n");
    sb.append("    clientReferrer: ").append(toIndentedString(clientReferrer)).append("\n");
    sb.append("    components: ").append(toIndentedString(components)).append("\n");
    sb.append("    bot: ").append(toIndentedString(bot)).append("\n");
    sb.append("    userAgent: ").append(toIndentedString(userAgent)).append("\n");
    sb.append("    rootApps: ").append(toIndentedString(rootApps)).append("\n");
    sb.append("    emulator: ").append(toIndentedString(emulator)).append("\n");
    sb.append("    ipInfo: ").append(toIndentedString(ipInfo)).append("\n");
    sb.append("    ipBlocklist: ").append(toIndentedString(ipBlocklist)).append("\n");
    sb.append("    tor: ").append(toIndentedString(tor)).append("\n");
    sb.append("    vpn: ").append(toIndentedString(vpn)).append("\n");
    sb.append("    proxy: ").append(toIndentedString(proxy)).append("\n");
    sb.append("    tampering: ").append(toIndentedString(tampering)).append("\n");
    sb.append("    clonedApp: ").append(toIndentedString(clonedApp)).append("\n");
    sb.append("    factoryReset: ").append(toIndentedString(factoryReset)).append("\n");
    sb.append("    jailbroken: ").append(toIndentedString(jailbroken)).append("\n");
    sb.append("    frida: ").append(toIndentedString(frida)).append("\n");
    sb.append("    privacySettings: ").append(toIndentedString(privacySettings)).append("\n");
    sb.append("    virtualMachine: ").append(toIndentedString(virtualMachine)).append("\n");
    sb.append("    rawDeviceAttributes: ").append(toIndentedString(rawDeviceAttributes)).append("\n");
    sb.append("    highActivity: ").append(toIndentedString(highActivity)).append("\n");
    sb.append("    locationSpoofing: ").append(toIndentedString(locationSpoofing)).append("\n");
    sb.append("    suspectScore: ").append(toIndentedString(suspectScore)).append("\n");
    sb.append("    remoteControl: ").append(toIndentedString(remoteControl)).append("\n");
    sb.append("    velocity: ").append(toIndentedString(velocity)).append("\n");
    sb.append("    developerTools: ").append(toIndentedString(developerTools)).append("\n");
    sb.append("    mitmAttack: ").append(toIndentedString(mitmAttack)).append("\n");
    sb.append("    replayed: ").append(toIndentedString(replayed)).append("\n");
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

