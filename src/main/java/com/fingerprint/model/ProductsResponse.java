/*
 * Fingerprint Pro Server API
 * Fingerprint Pro Server API allows you to get information about visitors and about individual events in a server environment. It can be used for data exports, decision-making, and data analysis scenarios. Server API is intended for server-side usage, it's not intended to be used from the client side, whether it's a browser or a mobile device. 
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
import com.fingerprint.model.ProductsResponseBotd;
import com.fingerprint.model.ProductsResponseIdentification;
import com.fingerprint.model.SignalResponseClonedApp;
import com.fingerprint.model.SignalResponseEmulator;
import com.fingerprint.model.SignalResponseFactoryReset;
import com.fingerprint.model.SignalResponseFrida;
import com.fingerprint.model.SignalResponseHighActivity;
import com.fingerprint.model.SignalResponseIncognito;
import com.fingerprint.model.SignalResponseIpBlocklist;
import com.fingerprint.model.SignalResponseIpInfo;
import com.fingerprint.model.SignalResponseJailbroken;
import com.fingerprint.model.SignalResponseLocationSpoofing;
import com.fingerprint.model.SignalResponsePrivacySettings;
import com.fingerprint.model.SignalResponseProxy;
import com.fingerprint.model.SignalResponseRawDeviceAttributes;
import com.fingerprint.model.SignalResponseRootApps;
import com.fingerprint.model.SignalResponseSuspectScore;
import com.fingerprint.model.SignalResponseTampering;
import com.fingerprint.model.SignalResponseTor;
import com.fingerprint.model.SignalResponseVirtualMachine;
import com.fingerprint.model.SignalResponseVpn;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fingerprint.sdk.JSON;


/**
 * Contains all information about the request identified by `requestId`, depending on the pricing plan (Pro, Pro Plus, Enterprise)
 */
@ApiModel(description = "Contains all information about the request identified by `requestId`, depending on the pricing plan (Pro, Pro Plus, Enterprise)")
@JsonPropertyOrder({
  ProductsResponse.JSON_PROPERTY_IDENTIFICATION,
  ProductsResponse.JSON_PROPERTY_BOTD,
  ProductsResponse.JSON_PROPERTY_IP_INFO,
  ProductsResponse.JSON_PROPERTY_INCOGNITO,
  ProductsResponse.JSON_PROPERTY_ROOT_APPS,
  ProductsResponse.JSON_PROPERTY_EMULATOR,
  ProductsResponse.JSON_PROPERTY_CLONED_APP,
  ProductsResponse.JSON_PROPERTY_FACTORY_RESET,
  ProductsResponse.JSON_PROPERTY_JAILBROKEN,
  ProductsResponse.JSON_PROPERTY_FRIDA,
  ProductsResponse.JSON_PROPERTY_IP_BLOCKLIST,
  ProductsResponse.JSON_PROPERTY_TOR,
  ProductsResponse.JSON_PROPERTY_PRIVACY_SETTINGS,
  ProductsResponse.JSON_PROPERTY_VIRTUAL_MACHINE,
  ProductsResponse.JSON_PROPERTY_VPN,
  ProductsResponse.JSON_PROPERTY_PROXY,
  ProductsResponse.JSON_PROPERTY_TAMPERING,
  ProductsResponse.JSON_PROPERTY_HIGH_ACTIVITY,
  ProductsResponse.JSON_PROPERTY_LOCATION_SPOOFING,
  ProductsResponse.JSON_PROPERTY_SUSPECT_SCORE,
  ProductsResponse.JSON_PROPERTY_RAW_DEVICE_ATTRIBUTES
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ProductsResponse {
  public static final String JSON_PROPERTY_IDENTIFICATION = "identification";
  private ProductsResponseIdentification identification;

  public static final String JSON_PROPERTY_BOTD = "botd";
  private ProductsResponseBotd botd;

  public static final String JSON_PROPERTY_IP_INFO = "ipInfo";
  private SignalResponseIpInfo ipInfo;

  public static final String JSON_PROPERTY_INCOGNITO = "incognito";
  private SignalResponseIncognito incognito;

  public static final String JSON_PROPERTY_ROOT_APPS = "rootApps";
  private SignalResponseRootApps rootApps;

  public static final String JSON_PROPERTY_EMULATOR = "emulator";
  private SignalResponseEmulator emulator;

  public static final String JSON_PROPERTY_CLONED_APP = "clonedApp";
  private SignalResponseClonedApp clonedApp;

  public static final String JSON_PROPERTY_FACTORY_RESET = "factoryReset";
  private SignalResponseFactoryReset factoryReset;

  public static final String JSON_PROPERTY_JAILBROKEN = "jailbroken";
  private SignalResponseJailbroken jailbroken;

  public static final String JSON_PROPERTY_FRIDA = "frida";
  private SignalResponseFrida frida;

  public static final String JSON_PROPERTY_IP_BLOCKLIST = "ipBlocklist";
  private SignalResponseIpBlocklist ipBlocklist;

  public static final String JSON_PROPERTY_TOR = "tor";
  private SignalResponseTor tor;

  public static final String JSON_PROPERTY_PRIVACY_SETTINGS = "privacySettings";
  private SignalResponsePrivacySettings privacySettings;

  public static final String JSON_PROPERTY_VIRTUAL_MACHINE = "virtualMachine";
  private SignalResponseVirtualMachine virtualMachine;

  public static final String JSON_PROPERTY_VPN = "vpn";
  private SignalResponseVpn vpn;

  public static final String JSON_PROPERTY_PROXY = "proxy";
  private SignalResponseProxy proxy;

  public static final String JSON_PROPERTY_TAMPERING = "tampering";
  private SignalResponseTampering tampering;

  public static final String JSON_PROPERTY_HIGH_ACTIVITY = "highActivity";
  private SignalResponseHighActivity highActivity;

  public static final String JSON_PROPERTY_LOCATION_SPOOFING = "locationSpoofing";
  private SignalResponseLocationSpoofing locationSpoofing;

  public static final String JSON_PROPERTY_SUSPECT_SCORE = "suspectScore";
  private SignalResponseSuspectScore suspectScore;

  public static final String JSON_PROPERTY_RAW_DEVICE_ATTRIBUTES = "rawDeviceAttributes";
  private SignalResponseRawDeviceAttributes rawDeviceAttributes;

  public ProductsResponse() {
  }

  public ProductsResponse identification(ProductsResponseIdentification identification) {
    this.identification = identification;
    return this;
  }

   /**
   * Get identification
   * @return identification
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_IDENTIFICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ProductsResponseIdentification getIdentification() {
    return identification;
  }


  @JsonProperty(JSON_PROPERTY_IDENTIFICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIdentification(ProductsResponseIdentification identification) {
    this.identification = identification;
  }


  public ProductsResponse botd(ProductsResponseBotd botd) {
    this.botd = botd;
    return this;
  }

   /**
   * Get botd
   * @return botd
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_BOTD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ProductsResponseBotd getBotd() {
    return botd;
  }


  @JsonProperty(JSON_PROPERTY_BOTD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBotd(ProductsResponseBotd botd) {
    this.botd = botd;
  }


  public ProductsResponse ipInfo(SignalResponseIpInfo ipInfo) {
    this.ipInfo = ipInfo;
    return this;
  }

   /**
   * Get ipInfo
   * @return ipInfo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_IP_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SignalResponseIpInfo getIpInfo() {
    return ipInfo;
  }


  @JsonProperty(JSON_PROPERTY_IP_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIpInfo(SignalResponseIpInfo ipInfo) {
    this.ipInfo = ipInfo;
  }


  public ProductsResponse incognito(SignalResponseIncognito incognito) {
    this.incognito = incognito;
    return this;
  }

   /**
   * Get incognito
   * @return incognito
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INCOGNITO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SignalResponseIncognito getIncognito() {
    return incognito;
  }


  @JsonProperty(JSON_PROPERTY_INCOGNITO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIncognito(SignalResponseIncognito incognito) {
    this.incognito = incognito;
  }


  public ProductsResponse rootApps(SignalResponseRootApps rootApps) {
    this.rootApps = rootApps;
    return this;
  }

   /**
   * Get rootApps
   * @return rootApps
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ROOT_APPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SignalResponseRootApps getRootApps() {
    return rootApps;
  }


  @JsonProperty(JSON_PROPERTY_ROOT_APPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRootApps(SignalResponseRootApps rootApps) {
    this.rootApps = rootApps;
  }


  public ProductsResponse emulator(SignalResponseEmulator emulator) {
    this.emulator = emulator;
    return this;
  }

   /**
   * Get emulator
   * @return emulator
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_EMULATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SignalResponseEmulator getEmulator() {
    return emulator;
  }


  @JsonProperty(JSON_PROPERTY_EMULATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEmulator(SignalResponseEmulator emulator) {
    this.emulator = emulator;
  }


  public ProductsResponse clonedApp(SignalResponseClonedApp clonedApp) {
    this.clonedApp = clonedApp;
    return this;
  }

   /**
   * Get clonedApp
   * @return clonedApp
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CLONED_APP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SignalResponseClonedApp getClonedApp() {
    return clonedApp;
  }


  @JsonProperty(JSON_PROPERTY_CLONED_APP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setClonedApp(SignalResponseClonedApp clonedApp) {
    this.clonedApp = clonedApp;
  }


  public ProductsResponse factoryReset(SignalResponseFactoryReset factoryReset) {
    this.factoryReset = factoryReset;
    return this;
  }

   /**
   * Get factoryReset
   * @return factoryReset
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FACTORY_RESET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SignalResponseFactoryReset getFactoryReset() {
    return factoryReset;
  }


  @JsonProperty(JSON_PROPERTY_FACTORY_RESET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFactoryReset(SignalResponseFactoryReset factoryReset) {
    this.factoryReset = factoryReset;
  }


  public ProductsResponse jailbroken(SignalResponseJailbroken jailbroken) {
    this.jailbroken = jailbroken;
    return this;
  }

   /**
   * Get jailbroken
   * @return jailbroken
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_JAILBROKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SignalResponseJailbroken getJailbroken() {
    return jailbroken;
  }


  @JsonProperty(JSON_PROPERTY_JAILBROKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setJailbroken(SignalResponseJailbroken jailbroken) {
    this.jailbroken = jailbroken;
  }


  public ProductsResponse frida(SignalResponseFrida frida) {
    this.frida = frida;
    return this;
  }

   /**
   * Get frida
   * @return frida
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FRIDA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SignalResponseFrida getFrida() {
    return frida;
  }


  @JsonProperty(JSON_PROPERTY_FRIDA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFrida(SignalResponseFrida frida) {
    this.frida = frida;
  }


  public ProductsResponse ipBlocklist(SignalResponseIpBlocklist ipBlocklist) {
    this.ipBlocklist = ipBlocklist;
    return this;
  }

   /**
   * Get ipBlocklist
   * @return ipBlocklist
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_IP_BLOCKLIST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SignalResponseIpBlocklist getIpBlocklist() {
    return ipBlocklist;
  }


  @JsonProperty(JSON_PROPERTY_IP_BLOCKLIST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIpBlocklist(SignalResponseIpBlocklist ipBlocklist) {
    this.ipBlocklist = ipBlocklist;
  }


  public ProductsResponse tor(SignalResponseTor tor) {
    this.tor = tor;
    return this;
  }

   /**
   * Get tor
   * @return tor
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SignalResponseTor getTor() {
    return tor;
  }


  @JsonProperty(JSON_PROPERTY_TOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTor(SignalResponseTor tor) {
    this.tor = tor;
  }


  public ProductsResponse privacySettings(SignalResponsePrivacySettings privacySettings) {
    this.privacySettings = privacySettings;
    return this;
  }

   /**
   * Get privacySettings
   * @return privacySettings
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PRIVACY_SETTINGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SignalResponsePrivacySettings getPrivacySettings() {
    return privacySettings;
  }


  @JsonProperty(JSON_PROPERTY_PRIVACY_SETTINGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrivacySettings(SignalResponsePrivacySettings privacySettings) {
    this.privacySettings = privacySettings;
  }


  public ProductsResponse virtualMachine(SignalResponseVirtualMachine virtualMachine) {
    this.virtualMachine = virtualMachine;
    return this;
  }

   /**
   * Get virtualMachine
   * @return virtualMachine
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_VIRTUAL_MACHINE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SignalResponseVirtualMachine getVirtualMachine() {
    return virtualMachine;
  }


  @JsonProperty(JSON_PROPERTY_VIRTUAL_MACHINE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVirtualMachine(SignalResponseVirtualMachine virtualMachine) {
    this.virtualMachine = virtualMachine;
  }


  public ProductsResponse vpn(SignalResponseVpn vpn) {
    this.vpn = vpn;
    return this;
  }

   /**
   * Get vpn
   * @return vpn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_VPN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SignalResponseVpn getVpn() {
    return vpn;
  }


  @JsonProperty(JSON_PROPERTY_VPN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVpn(SignalResponseVpn vpn) {
    this.vpn = vpn;
  }


  public ProductsResponse proxy(SignalResponseProxy proxy) {
    this.proxy = proxy;
    return this;
  }

   /**
   * Get proxy
   * @return proxy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PROXY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SignalResponseProxy getProxy() {
    return proxy;
  }


  @JsonProperty(JSON_PROPERTY_PROXY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProxy(SignalResponseProxy proxy) {
    this.proxy = proxy;
  }


  public ProductsResponse tampering(SignalResponseTampering tampering) {
    this.tampering = tampering;
    return this;
  }

   /**
   * Get tampering
   * @return tampering
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TAMPERING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SignalResponseTampering getTampering() {
    return tampering;
  }


  @JsonProperty(JSON_PROPERTY_TAMPERING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTampering(SignalResponseTampering tampering) {
    this.tampering = tampering;
  }


  public ProductsResponse highActivity(SignalResponseHighActivity highActivity) {
    this.highActivity = highActivity;
    return this;
  }

   /**
   * Get highActivity
   * @return highActivity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_HIGH_ACTIVITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SignalResponseHighActivity getHighActivity() {
    return highActivity;
  }


  @JsonProperty(JSON_PROPERTY_HIGH_ACTIVITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHighActivity(SignalResponseHighActivity highActivity) {
    this.highActivity = highActivity;
  }


  public ProductsResponse locationSpoofing(SignalResponseLocationSpoofing locationSpoofing) {
    this.locationSpoofing = locationSpoofing;
    return this;
  }

   /**
   * Get locationSpoofing
   * @return locationSpoofing
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_LOCATION_SPOOFING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SignalResponseLocationSpoofing getLocationSpoofing() {
    return locationSpoofing;
  }


  @JsonProperty(JSON_PROPERTY_LOCATION_SPOOFING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLocationSpoofing(SignalResponseLocationSpoofing locationSpoofing) {
    this.locationSpoofing = locationSpoofing;
  }


  public ProductsResponse suspectScore(SignalResponseSuspectScore suspectScore) {
    this.suspectScore = suspectScore;
    return this;
  }

   /**
   * Get suspectScore
   * @return suspectScore
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SUSPECT_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SignalResponseSuspectScore getSuspectScore() {
    return suspectScore;
  }


  @JsonProperty(JSON_PROPERTY_SUSPECT_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSuspectScore(SignalResponseSuspectScore suspectScore) {
    this.suspectScore = suspectScore;
  }


  public ProductsResponse rawDeviceAttributes(SignalResponseRawDeviceAttributes rawDeviceAttributes) {
    this.rawDeviceAttributes = rawDeviceAttributes;
    return this;
  }

   /**
   * Get rawDeviceAttributes
   * @return rawDeviceAttributes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_RAW_DEVICE_ATTRIBUTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SignalResponseRawDeviceAttributes getRawDeviceAttributes() {
    return rawDeviceAttributes;
  }


  @JsonProperty(JSON_PROPERTY_RAW_DEVICE_ATTRIBUTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRawDeviceAttributes(SignalResponseRawDeviceAttributes rawDeviceAttributes) {
    this.rawDeviceAttributes = rawDeviceAttributes;
  }


  /**
   * Return true if this ProductsResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductsResponse productsResponse = (ProductsResponse) o;
    return Objects.equals(this.identification, productsResponse.identification) &&
        Objects.equals(this.botd, productsResponse.botd) &&
        Objects.equals(this.ipInfo, productsResponse.ipInfo) &&
        Objects.equals(this.incognito, productsResponse.incognito) &&
        Objects.equals(this.rootApps, productsResponse.rootApps) &&
        Objects.equals(this.emulator, productsResponse.emulator) &&
        Objects.equals(this.clonedApp, productsResponse.clonedApp) &&
        Objects.equals(this.factoryReset, productsResponse.factoryReset) &&
        Objects.equals(this.jailbroken, productsResponse.jailbroken) &&
        Objects.equals(this.frida, productsResponse.frida) &&
        Objects.equals(this.ipBlocklist, productsResponse.ipBlocklist) &&
        Objects.equals(this.tor, productsResponse.tor) &&
        Objects.equals(this.privacySettings, productsResponse.privacySettings) &&
        Objects.equals(this.virtualMachine, productsResponse.virtualMachine) &&
        Objects.equals(this.vpn, productsResponse.vpn) &&
        Objects.equals(this.proxy, productsResponse.proxy) &&
        Objects.equals(this.tampering, productsResponse.tampering) &&
        Objects.equals(this.highActivity, productsResponse.highActivity) &&
        Objects.equals(this.locationSpoofing, productsResponse.locationSpoofing) &&
        Objects.equals(this.suspectScore, productsResponse.suspectScore) &&
        Objects.equals(this.rawDeviceAttributes, productsResponse.rawDeviceAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identification, botd, ipInfo, incognito, rootApps, emulator, clonedApp, factoryReset, jailbroken, frida, ipBlocklist, tor, privacySettings, virtualMachine, vpn, proxy, tampering, highActivity, locationSpoofing, suspectScore, rawDeviceAttributes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductsResponse {\n");
    sb.append("    identification: ").append(toIndentedString(identification)).append("\n");
    sb.append("    botd: ").append(toIndentedString(botd)).append("\n");
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
    sb.append("    highActivity: ").append(toIndentedString(highActivity)).append("\n");
    sb.append("    locationSpoofing: ").append(toIndentedString(locationSpoofing)).append("\n");
    sb.append("    suspectScore: ").append(toIndentedString(suspectScore)).append("\n");
    sb.append("    rawDeviceAttributes: ").append(toIndentedString(rawDeviceAttributes)).append("\n");
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

