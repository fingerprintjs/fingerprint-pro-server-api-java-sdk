

# Webhook


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**requestId** | **String** | Unique identifier of the user's request. |  |
|**url** | **String** | Page URL from which the request was sent. |  |
|**ip** | **String** | IP address of the requesting browser or bot. |  |
|**environmentId** | **String** | Environment ID of the event. |  [optional] |
|**tag** | **Map&lt;String, Object&gt;** | A customer-provided value or an object that was sent with identification request. |  [optional] |
|**time** | **OffsetDateTime** | Time expressed according to ISO 8601 in UTC format, when the request from the JS agent was made. We recommend to treat requests that are older than 2 minutes as malicious. Otherwise, request replay attacks are possible. |  |
|**timestamp** | **Long** | Timestamp of the event with millisecond precision in Unix time. |  |
|**ipLocation** | [**DeprecatedGeolocation**](DeprecatedGeolocation.md) |  |  [optional] |
|**linkedId** | **String** | A customer-provided id that was sent with the request. |  [optional] |
|**visitorId** | **String** | String of 20 characters that uniquely identifies the visitor's browser. |  [optional] |
|**visitorFound** | **Boolean** | Attribute represents if a visitor had been identified before. |  [optional] |
|**confidence** | [**IdentificationConfidence**](IdentificationConfidence.md) |  |  [optional] |
|**firstSeenAt** | [**IdentificationSeenAt**](IdentificationSeenAt.md) |  |  [optional] |
|**lastSeenAt** | [**IdentificationSeenAt**](IdentificationSeenAt.md) |  |  [optional] |
|**browserDetails** | [**BrowserDetails**](BrowserDetails.md) |  |  [optional] |
|**incognito** | **Boolean** | Flag if user used incognito session. |  [optional] |
|**clientReferrer** | **String** |  |  [optional] |
|**components** | [**Map&lt;String, RawDeviceAttribute&gt;**](RawDeviceAttribute.md) | It includes 35+ raw browser identification attributes to provide Fingerprint users with even more information than our standard visitor ID provides. This enables Fingerprint users to not have to run our open-source product in conjunction with Fingerprint Pro Plus and Enterprise to get those additional attributes. Warning: The raw signals data can change at any moment as we improve the product. We cannot guarantee the internal shape of raw device attributes to be stable, so typical semantic versioning rules do not apply here. Use this data with caution without assuming a specific structure beyond the generic type provided here.  |  [optional] |
|**bot** | [**BotdBot**](BotdBot.md) |  |  [optional] |
|**userAgent** | **String** |  |  [optional] |
|**rootApps** | [**WebhookRootApps**](WebhookRootApps.md) |  |  [optional] |
|**emulator** | [**WebhookEmulator**](WebhookEmulator.md) |  |  [optional] |
|**ipInfo** | [**WebhookIPInfo**](WebhookIPInfo.md) |  |  [optional] |
|**ipBlocklist** | [**WebhookIPBlocklist**](WebhookIPBlocklist.md) |  |  [optional] |
|**tor** | [**WebhookTor**](WebhookTor.md) |  |  [optional] |
|**vpn** | [**WebhookVPN**](WebhookVPN.md) |  |  [optional] |
|**proxy** | [**WebhookProxy**](WebhookProxy.md) |  |  [optional] |
|**tampering** | [**WebhookTampering**](WebhookTampering.md) |  |  [optional] |
|**clonedApp** | [**WebhookClonedApp**](WebhookClonedApp.md) |  |  [optional] |
|**factoryReset** | [**WebhookFactoryReset**](WebhookFactoryReset.md) |  |  [optional] |
|**jailbroken** | [**WebhookJailbroken**](WebhookJailbroken.md) |  |  [optional] |
|**frida** | [**WebhookFrida**](WebhookFrida.md) |  |  [optional] |
|**privacySettings** | [**WebhookPrivacySettings**](WebhookPrivacySettings.md) |  |  [optional] |
|**virtualMachine** | [**WebhookVirtualMachine**](WebhookVirtualMachine.md) |  |  [optional] |
|**rawDeviceAttributes** | [**Map&lt;String, RawDeviceAttribute&gt;**](RawDeviceAttribute.md) | It includes 35+ raw browser identification attributes to provide Fingerprint users with even more information than our standard visitor ID provides. This enables Fingerprint users to not have to run our open-source product in conjunction with Fingerprint Pro Plus and Enterprise to get those additional attributes. Warning: The raw signals data can change at any moment as we improve the product. We cannot guarantee the internal shape of raw device attributes to be stable, so typical semantic versioning rules do not apply here. Use this data with caution without assuming a specific structure beyond the generic type provided here.  |  [optional] |
|**highActivity** | [**WebhookHighActivity**](WebhookHighActivity.md) |  |  [optional] |
|**locationSpoofing** | [**WebhookLocationSpoofing**](WebhookLocationSpoofing.md) |  |  [optional] |
|**suspectScore** | [**WebhookSuspectScore**](WebhookSuspectScore.md) |  |  [optional] |
|**remoteControl** | [**WebhookRemoteControl**](WebhookRemoteControl.md) |  |  [optional] |
|**velocity** | [**WebhookVelocity**](WebhookVelocity.md) |  |  [optional] |
|**developerTools** | [**WebhookDeveloperTools**](WebhookDeveloperTools.md) |  |  [optional] |
|**mitmAttack** | [**WebhookMitMAttack**](WebhookMitMAttack.md) |  |  [optional] |



