package com.fingerprint.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fingerprint.model.ProductBotd;
import com.fingerprint.model.ProductClonedApp;
import com.fingerprint.model.ProductDeveloperTools;
import com.fingerprint.model.ProductEmulator;
import com.fingerprint.model.ProductFactoryReset;
import com.fingerprint.model.ProductFrida;
import com.fingerprint.model.ProductHighActivity;
import com.fingerprint.model.ProductIPBlocklist;
import com.fingerprint.model.ProductIPInfo;
import com.fingerprint.model.ProductIdentification;
import com.fingerprint.model.ProductIncognito;
import com.fingerprint.model.ProductJailbroken;
import com.fingerprint.model.ProductLocationSpoofing;
import com.fingerprint.model.ProductPrivacySettings;
import com.fingerprint.model.ProductProxy;
import com.fingerprint.model.ProductRawDeviceAttributes;
import com.fingerprint.model.ProductRemoteControl;
import com.fingerprint.model.ProductRootApps;
import com.fingerprint.model.ProductSuspectScore;
import com.fingerprint.model.ProductTampering;
import com.fingerprint.model.ProductTor;
import com.fingerprint.model.ProductVPN;
import com.fingerprint.model.ProductVelocity;
import com.fingerprint.model.ProductVirtualMachine;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Contains all information about the request identified by `requestId`, depending on the pricing plan (Pro, Pro Plus, Enterprise)
 */

@Schema(description = "Contains all information about the request identified by `requestId`, depending on the pricing plan (Pro, Pro Plus, Enterprise)")
@JsonPropertyOrder({
  Products.JSON_PROPERTY_IDENTIFICATION,
  Products.JSON_PROPERTY_BOTD,
  Products.JSON_PROPERTY_ROOT_APPS,
  Products.JSON_PROPERTY_EMULATOR,
  Products.JSON_PROPERTY_IP_INFO,
  Products.JSON_PROPERTY_IP_BLOCKLIST,
  Products.JSON_PROPERTY_TOR,
  Products.JSON_PROPERTY_VPN,
  Products.JSON_PROPERTY_PROXY,
  Products.JSON_PROPERTY_INCOGNITO,
  Products.JSON_PROPERTY_TAMPERING,
  Products.JSON_PROPERTY_CLONED_APP,
  Products.JSON_PROPERTY_FACTORY_RESET,
  Products.JSON_PROPERTY_JAILBROKEN,
  Products.JSON_PROPERTY_FRIDA,
  Products.JSON_PROPERTY_PRIVACY_SETTINGS,
  Products.JSON_PROPERTY_VIRTUAL_MACHINE,
  Products.JSON_PROPERTY_RAW_DEVICE_ATTRIBUTES,
  Products.JSON_PROPERTY_HIGH_ACTIVITY,
  Products.JSON_PROPERTY_LOCATION_SPOOFING,
  Products.JSON_PROPERTY_SUSPECT_SCORE,
  Products.JSON_PROPERTY_REMOTE_CONTROL,
  Products.JSON_PROPERTY_VELOCITY,
  Products.JSON_PROPERTY_DEVELOPER_TOOLS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class Products {
  public static final String JSON_PROPERTY_IDENTIFICATION = "identification";
  private ProductIdentification identification;

  public static final String JSON_PROPERTY_BOTD = "botd";
  private ProductBotd botd;

  public static final String JSON_PROPERTY_ROOT_APPS = "rootApps";
  private ProductRootApps rootApps;

  public static final String JSON_PROPERTY_EMULATOR = "emulator";
  private ProductEmulator emulator;

  public static final String JSON_PROPERTY_IP_INFO = "ipInfo";
  private ProductIPInfo ipInfo;

  public static final String JSON_PROPERTY_IP_BLOCKLIST = "ipBlocklist";
  private ProductIPBlocklist ipBlocklist;

  public static final String JSON_PROPERTY_TOR = "tor";
  private ProductTor tor;

  public static final String JSON_PROPERTY_VPN = "vpn";
  private ProductVPN vpn;

  public static final String JSON_PROPERTY_PROXY = "proxy";
  private ProductProxy proxy;

  public static final String JSON_PROPERTY_INCOGNITO = "incognito";
  private ProductIncognito incognito;

  public static final String JSON_PROPERTY_TAMPERING = "tampering";
  private ProductTampering tampering;

  public static final String JSON_PROPERTY_CLONED_APP = "clonedApp";
  private ProductClonedApp clonedApp;

  public static final String JSON_PROPERTY_FACTORY_RESET = "factoryReset";
  private ProductFactoryReset factoryReset;

  public static final String JSON_PROPERTY_JAILBROKEN = "jailbroken";
  private ProductJailbroken jailbroken;

  public static final String JSON_PROPERTY_FRIDA = "frida";
  private ProductFrida frida;

  public static final String JSON_PROPERTY_PRIVACY_SETTINGS = "privacySettings";
  private ProductPrivacySettings privacySettings;

  public static final String JSON_PROPERTY_VIRTUAL_MACHINE = "virtualMachine";
  private ProductVirtualMachine virtualMachine;

  public static final String JSON_PROPERTY_RAW_DEVICE_ATTRIBUTES = "rawDeviceAttributes";
  private ProductRawDeviceAttributes rawDeviceAttributes;

  public static final String JSON_PROPERTY_HIGH_ACTIVITY = "highActivity";
  private ProductHighActivity highActivity;

  public static final String JSON_PROPERTY_LOCATION_SPOOFING = "locationSpoofing";
  private ProductLocationSpoofing locationSpoofing;

  public static final String JSON_PROPERTY_SUSPECT_SCORE = "suspectScore";
  private ProductSuspectScore suspectScore;

  public static final String JSON_PROPERTY_REMOTE_CONTROL = "remoteControl";
  private ProductRemoteControl remoteControl;

  public static final String JSON_PROPERTY_VELOCITY = "velocity";
  private ProductVelocity velocity;

  public static final String JSON_PROPERTY_DEVELOPER_TOOLS = "developerTools";
  private ProductDeveloperTools developerTools;

  public Products() {
  }

  public Products identification(ProductIdentification identification) {
    this.identification = identification;
    return this;
  }

   /**
   * Get identification
   * @return identification
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_IDENTIFICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ProductIdentification getIdentification() {
    return identification;
  }


  @JsonProperty(JSON_PROPERTY_IDENTIFICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIdentification(ProductIdentification identification) {
    this.identification = identification;
  }


  public Products botd(ProductBotd botd) {
    this.botd = botd;
    return this;
  }

   /**
   * Get botd
   * @return botd
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_BOTD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ProductBotd getBotd() {
    return botd;
  }


  @JsonProperty(JSON_PROPERTY_BOTD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBotd(ProductBotd botd) {
    this.botd = botd;
  }


  public Products rootApps(ProductRootApps rootApps) {
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

  public ProductRootApps getRootApps() {
    return rootApps;
  }


  @JsonProperty(JSON_PROPERTY_ROOT_APPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRootApps(ProductRootApps rootApps) {
    this.rootApps = rootApps;
  }


  public Products emulator(ProductEmulator emulator) {
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

  public ProductEmulator getEmulator() {
    return emulator;
  }


  @JsonProperty(JSON_PROPERTY_EMULATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEmulator(ProductEmulator emulator) {
    this.emulator = emulator;
  }


  public Products ipInfo(ProductIPInfo ipInfo) {
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

  public ProductIPInfo getIpInfo() {
    return ipInfo;
  }


  @JsonProperty(JSON_PROPERTY_IP_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIpInfo(ProductIPInfo ipInfo) {
    this.ipInfo = ipInfo;
  }


  public Products ipBlocklist(ProductIPBlocklist ipBlocklist) {
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

  public ProductIPBlocklist getIpBlocklist() {
    return ipBlocklist;
  }


  @JsonProperty(JSON_PROPERTY_IP_BLOCKLIST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIpBlocklist(ProductIPBlocklist ipBlocklist) {
    this.ipBlocklist = ipBlocklist;
  }


  public Products tor(ProductTor tor) {
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

  public ProductTor getTor() {
    return tor;
  }


  @JsonProperty(JSON_PROPERTY_TOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTor(ProductTor tor) {
    this.tor = tor;
  }


  public Products vpn(ProductVPN vpn) {
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

  public ProductVPN getVpn() {
    return vpn;
  }


  @JsonProperty(JSON_PROPERTY_VPN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVpn(ProductVPN vpn) {
    this.vpn = vpn;
  }


  public Products proxy(ProductProxy proxy) {
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

  public ProductProxy getProxy() {
    return proxy;
  }


  @JsonProperty(JSON_PROPERTY_PROXY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProxy(ProductProxy proxy) {
    this.proxy = proxy;
  }


  public Products incognito(ProductIncognito incognito) {
    this.incognito = incognito;
    return this;
  }

   /**
   * Get incognito
   * @return incognito
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_INCOGNITO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ProductIncognito getIncognito() {
    return incognito;
  }


  @JsonProperty(JSON_PROPERTY_INCOGNITO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIncognito(ProductIncognito incognito) {
    this.incognito = incognito;
  }


  public Products tampering(ProductTampering tampering) {
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

  public ProductTampering getTampering() {
    return tampering;
  }


  @JsonProperty(JSON_PROPERTY_TAMPERING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTampering(ProductTampering tampering) {
    this.tampering = tampering;
  }


  public Products clonedApp(ProductClonedApp clonedApp) {
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

  public ProductClonedApp getClonedApp() {
    return clonedApp;
  }


  @JsonProperty(JSON_PROPERTY_CLONED_APP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setClonedApp(ProductClonedApp clonedApp) {
    this.clonedApp = clonedApp;
  }


  public Products factoryReset(ProductFactoryReset factoryReset) {
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

  public ProductFactoryReset getFactoryReset() {
    return factoryReset;
  }


  @JsonProperty(JSON_PROPERTY_FACTORY_RESET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFactoryReset(ProductFactoryReset factoryReset) {
    this.factoryReset = factoryReset;
  }


  public Products jailbroken(ProductJailbroken jailbroken) {
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

  public ProductJailbroken getJailbroken() {
    return jailbroken;
  }


  @JsonProperty(JSON_PROPERTY_JAILBROKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setJailbroken(ProductJailbroken jailbroken) {
    this.jailbroken = jailbroken;
  }


  public Products frida(ProductFrida frida) {
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

  public ProductFrida getFrida() {
    return frida;
  }


  @JsonProperty(JSON_PROPERTY_FRIDA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFrida(ProductFrida frida) {
    this.frida = frida;
  }


  public Products privacySettings(ProductPrivacySettings privacySettings) {
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

  public ProductPrivacySettings getPrivacySettings() {
    return privacySettings;
  }


  @JsonProperty(JSON_PROPERTY_PRIVACY_SETTINGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrivacySettings(ProductPrivacySettings privacySettings) {
    this.privacySettings = privacySettings;
  }


  public Products virtualMachine(ProductVirtualMachine virtualMachine) {
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

  public ProductVirtualMachine getVirtualMachine() {
    return virtualMachine;
  }


  @JsonProperty(JSON_PROPERTY_VIRTUAL_MACHINE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVirtualMachine(ProductVirtualMachine virtualMachine) {
    this.virtualMachine = virtualMachine;
  }


  public Products rawDeviceAttributes(ProductRawDeviceAttributes rawDeviceAttributes) {
    this.rawDeviceAttributes = rawDeviceAttributes;
    return this;
  }

   /**
   * Get rawDeviceAttributes
   * @return rawDeviceAttributes
  **/
  @jakarta.annotation.Nullable
  @Schema(description = "")
  @JsonProperty(JSON_PROPERTY_RAW_DEVICE_ATTRIBUTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ProductRawDeviceAttributes getRawDeviceAttributes() {
    return rawDeviceAttributes;
  }


  @JsonProperty(JSON_PROPERTY_RAW_DEVICE_ATTRIBUTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRawDeviceAttributes(ProductRawDeviceAttributes rawDeviceAttributes) {
    this.rawDeviceAttributes = rawDeviceAttributes;
  }


  public Products highActivity(ProductHighActivity highActivity) {
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

  public ProductHighActivity getHighActivity() {
    return highActivity;
  }


  @JsonProperty(JSON_PROPERTY_HIGH_ACTIVITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHighActivity(ProductHighActivity highActivity) {
    this.highActivity = highActivity;
  }


  public Products locationSpoofing(ProductLocationSpoofing locationSpoofing) {
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

  public ProductLocationSpoofing getLocationSpoofing() {
    return locationSpoofing;
  }


  @JsonProperty(JSON_PROPERTY_LOCATION_SPOOFING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLocationSpoofing(ProductLocationSpoofing locationSpoofing) {
    this.locationSpoofing = locationSpoofing;
  }


  public Products suspectScore(ProductSuspectScore suspectScore) {
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

  public ProductSuspectScore getSuspectScore() {
    return suspectScore;
  }


  @JsonProperty(JSON_PROPERTY_SUSPECT_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSuspectScore(ProductSuspectScore suspectScore) {
    this.suspectScore = suspectScore;
  }


  public Products remoteControl(ProductRemoteControl remoteControl) {
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

  public ProductRemoteControl getRemoteControl() {
    return remoteControl;
  }


  @JsonProperty(JSON_PROPERTY_REMOTE_CONTROL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRemoteControl(ProductRemoteControl remoteControl) {
    this.remoteControl = remoteControl;
  }


  public Products velocity(ProductVelocity velocity) {
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

  public ProductVelocity getVelocity() {
    return velocity;
  }


  @JsonProperty(JSON_PROPERTY_VELOCITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVelocity(ProductVelocity velocity) {
    this.velocity = velocity;
  }


  public Products developerTools(ProductDeveloperTools developerTools) {
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

  public ProductDeveloperTools getDeveloperTools() {
    return developerTools;
  }


  @JsonProperty(JSON_PROPERTY_DEVELOPER_TOOLS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDeveloperTools(ProductDeveloperTools developerTools) {
    this.developerTools = developerTools;
  }


  /**
   * Return true if this Products object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Products products = (Products) o;
    return Objects.equals(this.identification, products.identification) &&
        Objects.equals(this.botd, products.botd) &&
        Objects.equals(this.rootApps, products.rootApps) &&
        Objects.equals(this.emulator, products.emulator) &&
        Objects.equals(this.ipInfo, products.ipInfo) &&
        Objects.equals(this.ipBlocklist, products.ipBlocklist) &&
        Objects.equals(this.tor, products.tor) &&
        Objects.equals(this.vpn, products.vpn) &&
        Objects.equals(this.proxy, products.proxy) &&
        Objects.equals(this.incognito, products.incognito) &&
        Objects.equals(this.tampering, products.tampering) &&
        Objects.equals(this.clonedApp, products.clonedApp) &&
        Objects.equals(this.factoryReset, products.factoryReset) &&
        Objects.equals(this.jailbroken, products.jailbroken) &&
        Objects.equals(this.frida, products.frida) &&
        Objects.equals(this.privacySettings, products.privacySettings) &&
        Objects.equals(this.virtualMachine, products.virtualMachine) &&
        Objects.equals(this.rawDeviceAttributes, products.rawDeviceAttributes) &&
        Objects.equals(this.highActivity, products.highActivity) &&
        Objects.equals(this.locationSpoofing, products.locationSpoofing) &&
        Objects.equals(this.suspectScore, products.suspectScore) &&
        Objects.equals(this.remoteControl, products.remoteControl) &&
        Objects.equals(this.velocity, products.velocity) &&
        Objects.equals(this.developerTools, products.developerTools);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identification, botd, rootApps, emulator, ipInfo, ipBlocklist, tor, vpn, proxy, incognito, tampering, clonedApp, factoryReset, jailbroken, frida, privacySettings, virtualMachine, rawDeviceAttributes, highActivity, locationSpoofing, suspectScore, remoteControl, velocity, developerTools);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Products {\n");
    sb.append("    identification: ").append(toIndentedString(identification)).append("\n");
    sb.append("    botd: ").append(toIndentedString(botd)).append("\n");
    sb.append("    rootApps: ").append(toIndentedString(rootApps)).append("\n");
    sb.append("    emulator: ").append(toIndentedString(emulator)).append("\n");
    sb.append("    ipInfo: ").append(toIndentedString(ipInfo)).append("\n");
    sb.append("    ipBlocklist: ").append(toIndentedString(ipBlocklist)).append("\n");
    sb.append("    tor: ").append(toIndentedString(tor)).append("\n");
    sb.append("    vpn: ").append(toIndentedString(vpn)).append("\n");
    sb.append("    proxy: ").append(toIndentedString(proxy)).append("\n");
    sb.append("    incognito: ").append(toIndentedString(incognito)).append("\n");
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

