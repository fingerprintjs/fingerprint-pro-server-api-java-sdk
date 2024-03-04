

# WebhookVisit


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**visitorId** | **String** |  |  |
|**clientReferrer** | **String** |  |  [optional] |
|**userAgent** | **String** |  |  [optional] |
|**bot** | [**BotdDetectionResult**](BotdDetectionResult.md) |  |  [optional] |
|**ipInfo** | [**IpInfoResult**](IpInfoResult.md) |  |  [optional] |
|**incognito** | **Boolean** | Flag if user used incognito session. |  |
|**rootApps** | [**RootAppsResult**](RootAppsResult.md) |  |  [optional] |
|**emulator** | [**EmulatorResult**](EmulatorResult.md) |  |  [optional] |
|**clonedApp** | [**ClonedAppResult**](ClonedAppResult.md) |  |  [optional] |
|**factoryReset** | [**FactoryResetResult**](FactoryResetResult.md) |  |  [optional] |
|**jailbroken** | [**JailbrokenResult**](JailbrokenResult.md) |  |  [optional] |
|**frida** | [**FridaResult**](FridaResult.md) |  |  [optional] |
|**ipBlocklist** | [**IpBlockListResult**](IpBlockListResult.md) |  |  [optional] |
|**tor** | [**TorResult**](TorResult.md) |  |  [optional] |
|**privacySettings** | [**PrivacySettingsResult**](PrivacySettingsResult.md) |  |  [optional] |
|**virtualMachine** | [**VirtualMachineResult**](VirtualMachineResult.md) |  |  [optional] |
|**vpn** | [**VpnResult**](VpnResult.md) |  |  [optional] |
|**proxy** | [**ProxyResult**](ProxyResult.md) |  |  [optional] |
|**tampering** | [**TamperingResult**](TamperingResult.md) |  |  [optional] |
|**rawDeviceAttributes** | [**Map&lt;String, RawDeviceAttributesResultValue&gt;**](RawDeviceAttributesResultValue.md) | It includes 35+ raw browser identification attributes to provide Fingerprint users with even more information than our standard visitor ID provides. This enables Fingerprint users to not have to run our open-source product in conjunction with Fingerprint Pro Plus and Enterprise to get those additional attributes. Warning: The raw signals data can change at any moment as we improve the product. We cannot guarantee the internal shape of raw device attributes to be stable, so typical semantic versioning rules do not apply here. Use this data with caution without assuming a specific structure beyond the generic type provided here.  |  [optional] |
|**highActivity** | [**HighActivityResult**](HighActivityResult.md) |  |  [optional] |
|**locationSpoofing** | [**LocationSpoofingResult**](LocationSpoofingResult.md) |  |  [optional] |
|**suspectScore** | [**SuspectScoreResult**](SuspectScoreResult.md) |  |  [optional] |
|**requestId** | **String** | Unique identifier of the user's identification request. |  |
|**browserDetails** | [**BrowserDetails**](BrowserDetails.md) |  |  |
|**ip** | **String** |  |  |
|**ipLocation** | [**DeprecatedIPLocation**](DeprecatedIPLocation.md) |  |  [optional] |
|**timestamp** | **Long** | Timestamp of the event with millisecond precision in Unix time. |  |
|**time** | **OffsetDateTime** | Time expressed according to ISO 8601 in UTC format. |  |
|**url** | **String** | Page URL from which the identification request was sent. |  |
|**tag** | **Map&lt;String, Object&gt;** | A customer-provided value or an object that was sent with identification request. |  |
|**linkedId** | **String** | A customer-provided id that was sent with identification request. |  [optional] |
|**confidence** | [**Confidence**](Confidence.md) |  |  [optional] |
|**visitorFound** | **Boolean** | Attribute represents if a visitor had been identified before. |  |
|**firstSeenAt** | [**SeenAt**](SeenAt.md) |  |  |
|**lastSeenAt** | [**SeenAt**](SeenAt.md) |  |  |



