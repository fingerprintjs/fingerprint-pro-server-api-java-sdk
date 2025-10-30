

# Event

Contains results from Fingerprint Identification and all active Smart Signals.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**eventId** | **String** | Unique identifier of the user&#39;s request. The first portion of the event_id is a unix epoch milliseconds timestamp For example: &#x60;1758130560902.8tRtrH&#x60;  |  [optional] |
|**timestamp** | **Long** | Timestamp of the event with millisecond precision in Unix time. |  [optional] |
|**linkedId** | **String** | A customer-provided id that was sent with the request. |  [optional] |
|**environmentId** | **String** | Environment Id of the event. For example: &#x60;ae_47abaca3db2c7c43&#x60;  |  [optional] |
|**suspect** | **Boolean** | Field is &#x60;true&#x60; if you have previously set the &#x60;suspect&#x60; flag for this event using the [Server API Update event endpoint](https://dev.fingerprint.com/reference/updateevent). |  [optional] |
|**sdk** | [**SDK**](SDK.md) |  |  [optional] |
|**replayed** | **Boolean** | &#x60;true&#x60; if we determined that this payload was replayed, &#x60;false&#x60; otherwise.  |  [optional] |
|**identification** | [**Identification**](Identification.md) |  |  [optional] |
|**supplementaryIdHighRecall** | [**SupplementaryIDHighRecall**](SupplementaryIDHighRecall.md) |  |  [optional] |
|**tags** | **Object** | A customer-provided value or an object that was sent with the identification request or updated later. |  [optional] |
|**url** | **String** | Page URL from which the request was sent. For example &#x60;https://example.com/&#x60;  |  [optional] |
|**bundleId** | **String** | Bundle Id of the iOS application integrated with the Fingerprint SDK for the event. For example: &#x60;com.foo.app&#x60;  |  [optional] |
|**packageName** | **String** | Package name of the Android application integrated with the Fingerprint SDK for the event. For example: &#x60;com.foo.app&#x60;  |  [optional] |
|**ipAddress** | **String** | IP address of the requesting browser or bot. |  [optional] |
|**userAgent** | **String** | User Agent of the client, for example: &#x60;Mozilla/5.0 (Windows NT 6.1; Win64; x64) ....&#x60;  |  [optional] |
|**browserDetails** | [**BrowserDetails**](BrowserDetails.md) |  |  [optional] |
|**proximity** | [**Proximity**](Proximity.md) |  |  [optional] |
|**bot** | **BotResult** |  |  [optional] |
|**botType** | **String** | Additional classification of the bot type if detected.  |  [optional] |
|**clonedApp** | **Boolean** | Android specific cloned application detection. There are 2 values:  * &#x60;true&#x60; - Presence of app cloners work detected (e.g. fully cloned application found or launch of it inside of a not main working profile detected). * &#x60;false&#x60; - No signs of cloned application detected or the client is not Android.  |  [optional] |
|**developerTools** | **Boolean** | &#x60;true&#x60; if the browser is Chrome with DevTools open or Firefox with Developer Tools open, &#x60;false&#x60; otherwise.  |  [optional] |
|**emulator** | **Boolean** | Android specific emulator detection. There are 2 values:  * &#x60;true&#x60; - Emulated environment detected (e.g. launch inside of AVD).  * &#x60;false&#x60; - No signs of emulated environment detected or the client is not Android.  |  [optional] |
|**factoryResetTimestamp** | **Long** | The time of the most recent factory reset that happened on the **mobile device** is expressed as Unix epoch time. When a factory reset cannot be detected on the mobile device or when the request is initiated from a browser,  this field will correspond to the *epoch* time (i.e 1 Jan 1970 UTC) as a value of 0. See [Factory Reset Detection](https://dev.fingerprint.com/docs/smart-signals-overview#factory-reset-detection) to learn more about this Smart Signal.  |  [optional] |
|**frida** | **Boolean** | [Frida](https://frida.re/docs/) detection for Android and iOS devices. There are 2 values: * &#x60;true&#x60; - Frida detected * &#x60;false&#x60; - No signs of Frida or the client is not a mobile device.  |  [optional] |
|**ipBlocklist** | [**IPBlockList**](IPBlockList.md) |  |  [optional] |
|**ipInfo** | [**IPInfo**](IPInfo.md) |  |  [optional] |
|**proxy** | **Boolean** | IP address was used by a public proxy provider or belonged to a known recent residential proxy  |  [optional] |
|**proxyConfidence** | **ProxyConfidence** |  |  [optional] |
|**proxyDetails** | [**ProxyDetails**](ProxyDetails.md) |  |  [optional] |
|**incognito** | **Boolean** | &#x60;true&#x60; if we detected incognito mode used in the browser, &#x60;false&#x60; otherwise.  |  [optional] |
|**jailbroken** | **Boolean** | iOS specific jailbreak detection. There are 2 values:  * &#x60;true&#x60; - Jailbreak detected. * &#x60;false&#x60; - No signs of jailbreak or the client is not iOS.  |  [optional] |
|**locationSpoofing** | **Boolean** | Flag indicating whether the request came from a mobile device with location spoofing enabled. |  [optional] |
|**mitmAttack** | **Boolean** | * &#x60;true&#x60; - When requests made from your users&#39; mobile devices to Fingerprint servers have been intercepted and potentially modified.  * &#x60;false&#x60; - Otherwise or when the request originated from a browser. See [MitM Attack Detection](https://dev.fingerprint.com/docs/smart-signals-reference#mitm-attack-detection) to learn more about this Smart Signal.  |  [optional] |
|**privacySettings** | **Boolean** | &#x60;true&#x60; if the request is from a privacy aware browser (e.g. Tor) or from a browser in which fingerprinting is blocked. Otherwise &#x60;false&#x60;.  |  [optional] |
|**rootApps** | **Boolean** | Android specific root management apps detection. There are 2 values:  * &#x60;true&#x60; - Root Management Apps detected (e.g. Magisk). * &#x60;false&#x60; - No Root Management Apps detected or the client isn&#39;t Android.  |  [optional] |
|**suspectScore** | **Integer** | Suspect Score is an easy way to integrate Smart Signals into your fraud protection work flow.  It is a weighted representation of all Smart Signals present in the payload that helps identify suspicious activity. The value range is [0; S] where S is sum of all Smart Signals weights.  See more details here: https://dev.fingerprint.com/docs/suspect-score  |  [optional] |
|**tampering** | **Boolean** | Flag indicating browser tampering was detected. This happens when either:   * There are inconsistencies in the browser configuration that cross internal tampering thresholds (see &#x60;tampering_details.anomaly_score&#x60;).   * The browser signature resembles an \&quot;anti-detect\&quot; browser specifically designed to evade fingerprinting (see &#x60;tampering_details.anti_detect_browser&#x60;).  |  [optional] |
|**tamperingDetails** | [**TamperingDetails**](TamperingDetails.md) |  |  [optional] |
|**velocity** | [**Velocity**](Velocity.md) |  |  [optional] |
|**virtualMachine** | **Boolean** | &#x60;true&#x60; if the request came from a browser running inside a virtual machine (e.g. VMWare), &#x60;false&#x60; otherwise.  |  [optional] |
|**vpn** | **Boolean** | VPN or other anonymizing service has been used when sending the request.  |  [optional] |
|**vpnConfidence** | **VpnConfidence** |  |  [optional] |
|**vpnOriginTimezone** | **String** | Local timezone which is used in timezone_mismatch method.  |  [optional] |
|**vpnOriginCountry** | **String** | Country of the request (only for Android SDK version &gt;&#x3D; 2.4.0, ISO 3166 format or unknown).  |  [optional] |
|**vpnMethods** | [**VpnMethods**](VpnMethods.md) |  |  [optional] |



