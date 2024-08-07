package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.BotdDetectionResult;
import com.fingerprint.model.BrowserDetails;
import com.fingerprint.model.ClonedAppResult;
import com.fingerprint.model.Confidence;
import com.fingerprint.model.DeprecatedIPLocation;
import com.fingerprint.model.DeveloperToolsResult;
import com.fingerprint.model.EmulatorResult;
import com.fingerprint.model.FactoryResetResult;
import com.fingerprint.model.FridaResult;
import com.fingerprint.model.HighActivityResult;
import com.fingerprint.model.IpBlockListResult;
import com.fingerprint.model.IpInfoResult;
import com.fingerprint.model.JailbrokenResult;
import com.fingerprint.model.LocationSpoofingResult;
import com.fingerprint.model.PrivacySettingsResult;
import com.fingerprint.model.ProxyResult;
import com.fingerprint.model.RawDeviceAttributesResultValue;
import com.fingerprint.model.RemoteControlResult;
import com.fingerprint.model.RootAppsResult;
import com.fingerprint.model.SeenAt;
import com.fingerprint.model.SuspectScoreResult;
import com.fingerprint.model.TamperingResult;
import com.fingerprint.model.TorResult;
import com.fingerprint.model.VelocityResult;
import com.fingerprint.model.VirtualMachineResult;
import com.fingerprint.model.VpnResult;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * WebhookVisit
 */


@JsonPropertyOrder({
  WebhookVisit.JSON_PROPERTY_VISITOR_ID,
  WebhookVisit.JSON_PROPERTY_CLIENT_REFERRER,
  WebhookVisit.JSON_PROPERTY_USER_AGENT,
  WebhookVisit.JSON_PROPERTY_BOT,
  WebhookVisit.JSON_PROPERTY_IP_INFO,
  WebhookVisit.JSON_PROPERTY_INCOGNITO,
  WebhookVisit.JSON_PROPERTY_ROOT_APPS,
  WebhookVisit.JSON_PROPERTY_EMULATOR,
  WebhookVisit.JSON_PROPERTY_CLONED_APP,
  WebhookVisit.JSON_PROPERTY_FACTORY_RESET,
  WebhookVisit.JSON_PROPERTY_JAILBROKEN,
  WebhookVisit.JSON_PROPERTY_FRIDA,
  WebhookVisit.JSON_PROPERTY_IP_BLOCKLIST,
  WebhookVisit.JSON_PROPERTY_TOR,
  WebhookVisit.JSON_PROPERTY_PRIVACY_SETTINGS,
  WebhookVisit.JSON_PROPERTY_VIRTUAL_MACHINE,
  WebhookVisit.JSON_PROPERTY_VPN,
  WebhookVisit.JSON_PROPERTY_PROXY,
  WebhookVisit.JSON_PROPERTY_TAMPERING,
  WebhookVisit.JSON_PROPERTY_RAW_DEVICE_ATTRIBUTES,
  WebhookVisit.JSON_PROPERTY_HIGH_ACTIVITY,
  WebhookVisit.JSON_PROPERTY_LOCATION_SPOOFING,
  WebhookVisit.JSON_PROPERTY_SUSPECT_SCORE,
  WebhookVisit.JSON_PROPERTY_REMOTE_CONTROL,
  WebhookVisit.JSON_PROPERTY_VELOCITY,
  WebhookVisit.JSON_PROPERTY_DEVELOPER_TOOLS,
  WebhookVisit.JSON_PROPERTY_REQUEST_ID,
  WebhookVisit.JSON_PROPERTY_BROWSER_DETAILS,
  WebhookVisit.JSON_PROPERTY_IP,
  WebhookVisit.JSON_PROPERTY_IP_LOCATION,
  WebhookVisit.JSON_PROPERTY_TIMESTAMP,
  WebhookVisit.JSON_PROPERTY_TIME,
  WebhookVisit.JSON_PROPERTY_URL,
  WebhookVisit.JSON_PROPERTY_TAG,
  WebhookVisit.JSON_PROPERTY_LINKED_ID,
  WebhookVisit.JSON_PROPERTY_CONFIDENCE,
  WebhookVisit.JSON_PROPERTY_VISITOR_FOUND,
  WebhookVisit.JSON_PROPERTY_FIRST_SEEN_AT,
  WebhookVisit.JSON_PROPERTY_LAST_SEEN_AT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class WebhookVisit {
  public static final String JSON_PROPERTY_VISITOR_ID = "visitorId";
  private String visitorId;

  public static final String JSON_PROPERTY_CLIENT_REFERRER = "clientReferrer";
  private String clientReferrer;

  public static final String JSON_PROPERTY_USER_AGENT = "userAgent";
  private String userAgent;

  public static final String JSON_PROPERTY_BOT = "bot";
  private BotdDetectionResult bot;

  public static final String JSON_PROPERTY_IP_INFO = "ipInfo";
  private IpInfoResult ipInfo;

  public static final String JSON_PROPERTY_INCOGNITO = "incognito";
  private Boolean incognito;

  public static final String JSON_PROPERTY_ROOT_APPS = "rootApps";
  private RootAppsResult rootApps;

  public static final String JSON_PROPERTY_EMULATOR = "emulator";
  private EmulatorResult emulator;

  public static final String JSON_PROPERTY_CLONED_APP = "clonedApp";
  private ClonedAppResult clonedApp;

  public static final String JSON_PROPERTY_FACTORY_RESET = "factoryReset";
  private FactoryResetResult factoryReset;

  public static final String JSON_PROPERTY_JAILBROKEN = "jailbroken";
  private JailbrokenResult jailbroken;

  public static final String JSON_PROPERTY_FRIDA = "frida";
  private FridaResult frida;

  public static final String JSON_PROPERTY_IP_BLOCKLIST = "ipBlocklist";
  private IpBlockListResult ipBlocklist;

  public static final String JSON_PROPERTY_TOR = "tor";
  private TorResult tor;

  public static final String JSON_PROPERTY_PRIVACY_SETTINGS = "privacySettings";
  private PrivacySettingsResult privacySettings;

  public static final String JSON_PROPERTY_VIRTUAL_MACHINE = "virtualMachine";
  private VirtualMachineResult virtualMachine;

  public static final String JSON_PROPERTY_VPN = "vpn";
  private VpnResult vpn;

  public static final String JSON_PROPERTY_PROXY = "proxy";
  private ProxyResult proxy;

  public static final String JSON_PROPERTY_TAMPERING = "tampering";
  private TamperingResult tampering;

  public static final String JSON_PROPERTY_RAW_DEVICE_ATTRIBUTES = "rawDeviceAttributes";
  private Map<String, RawDeviceAttributesResultValue> rawDeviceAttributes = null;

  public static final String JSON_PROPERTY_HIGH_ACTIVITY = "highActivity";
  private HighActivityResult highActivity;

  public static final String JSON_PROPERTY_LOCATION_SPOOFING = "locationSpoofing";
  private LocationSpoofingResult locationSpoofing;

  public static final String JSON_PROPERTY_SUSPECT_SCORE = "suspectScore";
  private SuspectScoreResult suspectScore;

  public static final String JSON_PROPERTY_REMOTE_CONTROL = "remoteControl";
  private RemoteControlResult remoteControl;

  public static final String JSON_PROPERTY_VELOCITY = "velocity";
  private VelocityResult velocity;

  public static final String JSON_PROPERTY_DEVELOPER_TOOLS = "developerTools";
  private DeveloperToolsResult developerTools;

  public static final String JSON_PROPERTY_REQUEST_ID = "requestId";
  private String requestId;

  public static final String JSON_PROPERTY_BROWSER_DETAILS = "browserDetails";
  private BrowserDetails browserDetails;

  public static final String JSON_PROPERTY_IP = "ip";
  private String ip;

  public static final String JSON_PROPERTY_IP_LOCATION = "ipLocation";
  private DeprecatedIPLocation ipLocation;

  public static final String JSON_PROPERTY_TIMESTAMP = "timestamp";
  private Long timestamp;

  public static final String JSON_PROPERTY_TIME = "time";
  private OffsetDateTime time;

  public static final String JSON_PROPERTY_URL = "url";
  private String url;

  public static final String JSON_PROPERTY_TAG = "tag";
  private Map<String, Object> tag = null;

  public static final String JSON_PROPERTY_LINKED_ID = "linkedId";
  private String linkedId;

  public static final String JSON_PROPERTY_CONFIDENCE = "confidence";
  private Confidence confidence;

  public static final String JSON_PROPERTY_VISITOR_FOUND = "visitorFound";
  private Boolean visitorFound;

  public static final String JSON_PROPERTY_FIRST_SEEN_AT = "firstSeenAt";
  private SeenAt firstSeenAt;

  public static final String JSON_PROPERTY_LAST_SEEN_AT = "lastSeenAt";
  private SeenAt lastSeenAt;

  public WebhookVisit() {
  }

  public WebhookVisit visitorId(String visitorId) {
    this.visitorId = visitorId;
    return this;
  }

   /**
   * Get visitorId
   * @return visitorId
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "3HNey93AkBW6CRbxV6xP", required = true, description = "")
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


  public WebhookVisit clientReferrer(String clientReferrer) {
    this.clientReferrer = clientReferrer;
    return this;
  }

   /**
   * Get clientReferrer
   * @return clientReferrer
  **/
  @jakarta.annotation.Nullable
  @Schema(example = "https://google.com?search=banking+services", description = "")
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


  public WebhookVisit userAgent(String userAgent) {
    this.userAgent = userAgent;
    return this;
  }

   /**
   * Get userAgent
   * @return userAgent
  **/
  @jakarta.annotation.Nullable
  @Schema(example = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36", description = "")
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


  public WebhookVisit bot(BotdDetectionResult bot) {
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

  public BotdDetectionResult getBot() {
    return bot;
  }


  @JsonProperty(JSON_PROPERTY_BOT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBot(BotdDetectionResult bot) {
    this.bot = bot;
  }


  public WebhookVisit ipInfo(IpInfoResult ipInfo) {
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

  public IpInfoResult getIpInfo() {
    return ipInfo;
  }


  @JsonProperty(JSON_PROPERTY_IP_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIpInfo(IpInfoResult ipInfo) {
    this.ipInfo = ipInfo;
  }


  public WebhookVisit incognito(Boolean incognito) {
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


  public WebhookVisit rootApps(RootAppsResult rootApps) {
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

  public RootAppsResult getRootApps() {
    return rootApps;
  }


  @JsonProperty(JSON_PROPERTY_ROOT_APPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRootApps(RootAppsResult rootApps) {
    this.rootApps = rootApps;
  }


  public WebhookVisit emulator(EmulatorResult emulator) {
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

  public EmulatorResult getEmulator() {
    return emulator;
  }


  @JsonProperty(JSON_PROPERTY_EMULATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEmulator(EmulatorResult emulator) {
    this.emulator = emulator;
  }


  public WebhookVisit clonedApp(ClonedAppResult clonedApp) {
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

  public ClonedAppResult getClonedApp() {
    return clonedApp;
  }


  @JsonProperty(JSON_PROPERTY_CLONED_APP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setClonedApp(ClonedAppResult clonedApp) {
    this.clonedApp = clonedApp;
  }


  public WebhookVisit factoryReset(FactoryResetResult factoryReset) {
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

  public FactoryResetResult getFactoryReset() {
    return factoryReset;
  }


  @JsonProperty(JSON_PROPERTY_FACTORY_RESET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFactoryReset(FactoryResetResult factoryReset) {
    this.factoryReset = factoryReset;
  }


  public WebhookVisit jailbroken(JailbrokenResult jailbroken) {
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

  public JailbrokenResult getJailbroken() {
    return jailbroken;
  }


  @JsonProperty(JSON_PROPERTY_JAILBROKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setJailbroken(JailbrokenResult jailbroken) {
    this.jailbroken = jailbroken;
  }


  public WebhookVisit frida(FridaResult frida) {
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

  public FridaResult getFrida() {
    return frida;
  }


  @JsonProperty(JSON_PROPERTY_FRIDA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFrida(FridaResult frida) {
    this.frida = frida;
  }


  public WebhookVisit ipBlocklist(IpBlockListResult ipBlocklist) {
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

  public IpBlockListResult getIpBlocklist() {
    return ipBlocklist;
  }


  @JsonProperty(JSON_PROPERTY_IP_BLOCKLIST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIpBlocklist(IpBlockListResult ipBlocklist) {
    this.ipBlocklist = ipBlocklist;
  }


  public WebhookVisit tor(TorResult tor) {
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

  public TorResult getTor() {
    return tor;
  }


  @JsonProperty(JSON_PROPERTY_TOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTor(TorResult tor) {
    this.tor = tor;
  }


  public WebhookVisit privacySettings(PrivacySettingsResult privacySettings) {
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

  public PrivacySettingsResult getPrivacySettings() {
    return privacySettings;
  }


  @JsonProperty(JSON_PROPERTY_PRIVACY_SETTINGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrivacySettings(PrivacySettingsResult privacySettings) {
    this.privacySettings = privacySettings;
  }


  public WebhookVisit virtualMachine(VirtualMachineResult virtualMachine) {
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

  public VirtualMachineResult getVirtualMachine() {
    return virtualMachine;
  }


  @JsonProperty(JSON_PROPERTY_VIRTUAL_MACHINE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVirtualMachine(VirtualMachineResult virtualMachine) {
    this.virtualMachine = virtualMachine;
  }


  public WebhookVisit vpn(VpnResult vpn) {
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

  public VpnResult getVpn() {
    return vpn;
  }


  @JsonProperty(JSON_PROPERTY_VPN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVpn(VpnResult vpn) {
    this.vpn = vpn;
  }


  public WebhookVisit proxy(ProxyResult proxy) {
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

  public ProxyResult getProxy() {
    return proxy;
  }


  @JsonProperty(JSON_PROPERTY_PROXY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProxy(ProxyResult proxy) {
    this.proxy = proxy;
  }


  public WebhookVisit tampering(TamperingResult tampering) {
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

  public TamperingResult getTampering() {
    return tampering;
  }


  @JsonProperty(JSON_PROPERTY_TAMPERING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTampering(TamperingResult tampering) {
    this.tampering = tampering;
  }


  public WebhookVisit rawDeviceAttributes(Map<String, RawDeviceAttributesResultValue> rawDeviceAttributes) {
    this.rawDeviceAttributes = rawDeviceAttributes;
    return this;
  }

  public WebhookVisit putrawDeviceAttributesItem(String key, RawDeviceAttributesResultValue rawDeviceAttributesItem) {
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

  public Map<String, RawDeviceAttributesResultValue> getRawDeviceAttributes() {
    return rawDeviceAttributes;
  }


  @JsonProperty(JSON_PROPERTY_RAW_DEVICE_ATTRIBUTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRawDeviceAttributes(Map<String, RawDeviceAttributesResultValue> rawDeviceAttributes) {
    this.rawDeviceAttributes = rawDeviceAttributes;
  }


  public WebhookVisit highActivity(HighActivityResult highActivity) {
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

  public HighActivityResult getHighActivity() {
    return highActivity;
  }


  @JsonProperty(JSON_PROPERTY_HIGH_ACTIVITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHighActivity(HighActivityResult highActivity) {
    this.highActivity = highActivity;
  }


  public WebhookVisit locationSpoofing(LocationSpoofingResult locationSpoofing) {
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

  public LocationSpoofingResult getLocationSpoofing() {
    return locationSpoofing;
  }


  @JsonProperty(JSON_PROPERTY_LOCATION_SPOOFING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLocationSpoofing(LocationSpoofingResult locationSpoofing) {
    this.locationSpoofing = locationSpoofing;
  }


  public WebhookVisit suspectScore(SuspectScoreResult suspectScore) {
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

  public SuspectScoreResult getSuspectScore() {
    return suspectScore;
  }


  @JsonProperty(JSON_PROPERTY_SUSPECT_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSuspectScore(SuspectScoreResult suspectScore) {
    this.suspectScore = suspectScore;
  }


  public WebhookVisit remoteControl(RemoteControlResult remoteControl) {
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

  public RemoteControlResult getRemoteControl() {
    return remoteControl;
  }


  @JsonProperty(JSON_PROPERTY_REMOTE_CONTROL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRemoteControl(RemoteControlResult remoteControl) {
    this.remoteControl = remoteControl;
  }


  public WebhookVisit velocity(VelocityResult velocity) {
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

  public VelocityResult getVelocity() {
    return velocity;
  }


  @JsonProperty(JSON_PROPERTY_VELOCITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVelocity(VelocityResult velocity) {
    this.velocity = velocity;
  }


  public WebhookVisit developerTools(DeveloperToolsResult developerTools) {
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

  public DeveloperToolsResult getDeveloperTools() {
    return developerTools;
  }


  @JsonProperty(JSON_PROPERTY_DEVELOPER_TOOLS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDeveloperTools(DeveloperToolsResult developerTools) {
    this.developerTools = developerTools;
  }


  public WebhookVisit requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * Unique identifier of the user&#39;s identification request.
   * @return requestId
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "1654815516083.OX6kx8", required = true, description = "Unique identifier of the user's identification request.")
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


  public WebhookVisit browserDetails(BrowserDetails browserDetails) {
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


  public WebhookVisit ip(String ip) {
    this.ip = ip;
    return this;
  }

   /**
   * Get ip
   * @return ip
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "8.8.8.8", required = true, description = "")
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


  public WebhookVisit ipLocation(DeprecatedIPLocation ipLocation) {
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

  public DeprecatedIPLocation getIpLocation() {
    return ipLocation;
  }


  @JsonProperty(JSON_PROPERTY_IP_LOCATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIpLocation(DeprecatedIPLocation ipLocation) {
    this.ipLocation = ipLocation;
  }


  public WebhookVisit timestamp(Long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

   /**
   * Timestamp of the event with millisecond precision in Unix time.
   * @return timestamp
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "1654815516086", required = true, description = "Timestamp of the event with millisecond precision in Unix time.")
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


  public WebhookVisit time(OffsetDateTime time) {
    this.time = time;
    return this;
  }

   /**
   * Time expressed according to ISO 8601 in UTC format.
   * @return time
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "2022-06-09T22:58:36Z", required = true, description = "Time expressed according to ISO 8601 in UTC format.")
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


  public WebhookVisit url(String url) {
    this.url = url;
    return this;
  }

   /**
   * Page URL from which the identification request was sent.
   * @return url
  **/
  @jakarta.annotation.Nonnull
  @Schema(example = "https://some.website/path?query=params", required = true, description = "Page URL from which the identification request was sent.")
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


  public WebhookVisit tag(Map<String, Object> tag) {
    this.tag = tag;
    return this;
  }

  public WebhookVisit puttagItem(String key, Object tagItem) {
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


  public WebhookVisit linkedId(String linkedId) {
    this.linkedId = linkedId;
    return this;
  }

   /**
   * A customer-provided id that was sent with identification request.
   * @return linkedId
  **/
  @jakarta.annotation.Nullable
  @Schema(example = "someID", description = "A customer-provided id that was sent with identification request.")
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


  public WebhookVisit confidence(Confidence confidence) {
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

  public Confidence getConfidence() {
    return confidence;
  }


  @JsonProperty(JSON_PROPERTY_CONFIDENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setConfidence(Confidence confidence) {
    this.confidence = confidence;
  }


  public WebhookVisit visitorFound(Boolean visitorFound) {
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


  public WebhookVisit firstSeenAt(SeenAt firstSeenAt) {
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

  public SeenAt getFirstSeenAt() {
    return firstSeenAt;
  }


  @JsonProperty(JSON_PROPERTY_FIRST_SEEN_AT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFirstSeenAt(SeenAt firstSeenAt) {
    this.firstSeenAt = firstSeenAt;
  }


  public WebhookVisit lastSeenAt(SeenAt lastSeenAt) {
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

  public SeenAt getLastSeenAt() {
    return lastSeenAt;
  }


  @JsonProperty(JSON_PROPERTY_LAST_SEEN_AT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLastSeenAt(SeenAt lastSeenAt) {
    this.lastSeenAt = lastSeenAt;
  }


  /**
   * Return true if this WebhookVisit object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhookVisit webhookVisit = (WebhookVisit) o;
    return Objects.equals(this.visitorId, webhookVisit.visitorId) &&
        Objects.equals(this.clientReferrer, webhookVisit.clientReferrer) &&
        Objects.equals(this.userAgent, webhookVisit.userAgent) &&
        Objects.equals(this.bot, webhookVisit.bot) &&
        Objects.equals(this.ipInfo, webhookVisit.ipInfo) &&
        Objects.equals(this.incognito, webhookVisit.incognito) &&
        Objects.equals(this.rootApps, webhookVisit.rootApps) &&
        Objects.equals(this.emulator, webhookVisit.emulator) &&
        Objects.equals(this.clonedApp, webhookVisit.clonedApp) &&
        Objects.equals(this.factoryReset, webhookVisit.factoryReset) &&
        Objects.equals(this.jailbroken, webhookVisit.jailbroken) &&
        Objects.equals(this.frida, webhookVisit.frida) &&
        Objects.equals(this.ipBlocklist, webhookVisit.ipBlocklist) &&
        Objects.equals(this.tor, webhookVisit.tor) &&
        Objects.equals(this.privacySettings, webhookVisit.privacySettings) &&
        Objects.equals(this.virtualMachine, webhookVisit.virtualMachine) &&
        Objects.equals(this.vpn, webhookVisit.vpn) &&
        Objects.equals(this.proxy, webhookVisit.proxy) &&
        Objects.equals(this.tampering, webhookVisit.tampering) &&
        Objects.equals(this.rawDeviceAttributes, webhookVisit.rawDeviceAttributes) &&
        Objects.equals(this.highActivity, webhookVisit.highActivity) &&
        Objects.equals(this.locationSpoofing, webhookVisit.locationSpoofing) &&
        Objects.equals(this.suspectScore, webhookVisit.suspectScore) &&
        Objects.equals(this.remoteControl, webhookVisit.remoteControl) &&
        Objects.equals(this.velocity, webhookVisit.velocity) &&
        Objects.equals(this.developerTools, webhookVisit.developerTools) &&
        Objects.equals(this.requestId, webhookVisit.requestId) &&
        Objects.equals(this.browserDetails, webhookVisit.browserDetails) &&
        Objects.equals(this.ip, webhookVisit.ip) &&
        Objects.equals(this.ipLocation, webhookVisit.ipLocation) &&
        Objects.equals(this.timestamp, webhookVisit.timestamp) &&
        Objects.equals(this.time, webhookVisit.time) &&
        Objects.equals(this.url, webhookVisit.url) &&
        Objects.equals(this.tag, webhookVisit.tag) &&
        Objects.equals(this.linkedId, webhookVisit.linkedId) &&
        Objects.equals(this.confidence, webhookVisit.confidence) &&
        Objects.equals(this.visitorFound, webhookVisit.visitorFound) &&
        Objects.equals(this.firstSeenAt, webhookVisit.firstSeenAt) &&
        Objects.equals(this.lastSeenAt, webhookVisit.lastSeenAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(visitorId, clientReferrer, userAgent, bot, ipInfo, incognito, rootApps, emulator, clonedApp, factoryReset, jailbroken, frida, ipBlocklist, tor, privacySettings, virtualMachine, vpn, proxy, tampering, rawDeviceAttributes, highActivity, locationSpoofing, suspectScore, remoteControl, velocity, developerTools, requestId, browserDetails, ip, ipLocation, timestamp, time, url, tag, linkedId, confidence, visitorFound, firstSeenAt, lastSeenAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhookVisit {\n");
    sb.append("    visitorId: ").append(toIndentedString(visitorId)).append("\n");
    sb.append("    clientReferrer: ").append(toIndentedString(clientReferrer)).append("\n");
    sb.append("    userAgent: ").append(toIndentedString(userAgent)).append("\n");
    sb.append("    bot: ").append(toIndentedString(bot)).append("\n");
    sb.append("    ipInfo: ").append(toIndentedString(ipInfo)).append("\n");
    sb.append("    incognito: ").append(toIndentedString(incognito)).append("\n");
    sb.append("    rootApps: ").append(toIndentedString(rootApps)).append("\n");
    sb.append("    emulator: ").append(toIndentedString(emulator)).append("\n");
    sb.append("    clonedApp: ").append(toIndentedString(clonedApp)).append("\n");
    sb.append("    factoryReset: ").append(toIndentedString(factoryReset)).append("\n");
    sb.append("    jailbroken: ").append(toIndentedString(jailbroken)).append("\n");
    sb.append("    frida: ").append(toIndentedString(frida)).append("\n");
    sb.append("    ipBlocklist: ").append(toIndentedString(ipBlocklist)).append("\n");
    sb.append("    tor: ").append(toIndentedString(tor)).append("\n");
    sb.append("    privacySettings: ").append(toIndentedString(privacySettings)).append("\n");
    sb.append("    virtualMachine: ").append(toIndentedString(virtualMachine)).append("\n");
    sb.append("    vpn: ").append(toIndentedString(vpn)).append("\n");
    sb.append("    proxy: ").append(toIndentedString(proxy)).append("\n");
    sb.append("    tampering: ").append(toIndentedString(tampering)).append("\n");
    sb.append("    rawDeviceAttributes: ").append(toIndentedString(rawDeviceAttributes)).append("\n");
    sb.append("    highActivity: ").append(toIndentedString(highActivity)).append("\n");
    sb.append("    locationSpoofing: ").append(toIndentedString(locationSpoofing)).append("\n");
    sb.append("    suspectScore: ").append(toIndentedString(suspectScore)).append("\n");
    sb.append("    remoteControl: ").append(toIndentedString(remoteControl)).append("\n");
    sb.append("    velocity: ").append(toIndentedString(velocity)).append("\n");
    sb.append("    developerTools: ").append(toIndentedString(developerTools)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    browserDetails: ").append(toIndentedString(browserDetails)).append("\n");
    sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
    sb.append("    ipLocation: ").append(toIndentedString(ipLocation)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
    sb.append("    linkedId: ").append(toIndentedString(linkedId)).append("\n");
    sb.append("    confidence: ").append(toIndentedString(confidence)).append("\n");
    sb.append("    visitorFound: ").append(toIndentedString(visitorFound)).append("\n");
    sb.append("    firstSeenAt: ").append(toIndentedString(firstSeenAt)).append("\n");
    sb.append("    lastSeenAt: ").append(toIndentedString(lastSeenAt)).append("\n");
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

