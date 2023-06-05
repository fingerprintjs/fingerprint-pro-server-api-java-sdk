

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
|**rootApps** | [**WebhookSignalResponseRootApps**](WebhookSignalResponseRootApps.md) |  |  [optional] |
|**emulator** | [**WebhookSignalResponseEmulator**](WebhookSignalResponseEmulator.md) |  |  [optional] |
|**ipBlocklist** | [**IpBlockListResult**](IpBlockListResult.md) |  |  [optional] |
|**tor** | [**WebhookSignalResponseTor**](WebhookSignalResponseTor.md) |  |  [optional] |
|**vpn** | [**VpnResult**](VpnResult.md) |  |  [optional] |
|**proxy** | [**WebhookSignalResponseProxy**](WebhookSignalResponseProxy.md) |  |  [optional] |
|**tampering** | [**TamperingResult**](TamperingResult.md) |  |  [optional] |
|**requestId** | **String** | Unique identifier of the user's identification request. |  |
|**browserDetails** | [**BrowserDetails**](BrowserDetails.md) |  |  |
|**ip** | **String** |  |  |
|**ipLocation** | [**IPLocation**](IPLocation.md) |  |  [optional] |
|**timestamp** | **Long** | Timestamp of the event with millisecond precision in Unix time. |  |
|**time** | **OffsetDateTime** | Time expressed according to ISO 8601 in UTC format. |  |
|**url** | **URI** | Page URL from which identification request was sent. |  |
|**tag** | **Map&lt;String, Object&gt;** | A customer-provided value or an object that was sent with identification request. |  [optional] |
|**linkedId** | **String** | A customer-provided id that was sent with identification request. |  [optional] |
|**confidence** | [**Confidence**](Confidence.md) |  |  |
|**visitorFound** | **Boolean** | Attribute represents if a visitor had been identified before. |  |
|**firstSeenAt** | [**SeenAt**](SeenAt.md) |  |  |
|**lastSeenAt** | [**SeenAt**](SeenAt.md) |  |  |



