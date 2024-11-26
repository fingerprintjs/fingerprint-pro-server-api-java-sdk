

# Identification


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**visitorId** | **String** | String of 20 characters that uniquely identifies the visitor's browser. |  |
|**requestId** | **String** | Unique identifier of the user's request. |  |
|**browserDetails** | [**BrowserDetails**](BrowserDetails.md) |  |  |
|**incognito** | **Boolean** | Flag if user used incognito session. |  |
|**ip** | **String** | IP address of the requesting browser or bot. |  |
|**ipLocation** | [**DeprecatedGeolocation**](DeprecatedGeolocation.md) |  |  [optional] |
|**linkedId** | **String** | A customer-provided id that was sent with the request. |  [optional] |
|**suspect** | **Boolean** | Field is `true` if you have previously set the `suspect` flag for this event using the [Server API Update event endpoint](https://dev.fingerprint.com/reference/updateevent). |  [optional] |
|**timestamp** | **Long** | Timestamp of the event with millisecond precision in Unix time. |  |
|**time** | **OffsetDateTime** | Time expressed according to ISO 8601 in UTC format, when the request from the JS agent was made. We recommend to treat requests that are older than 2 minutes as malicious. Otherwise, request replay attacks are possible. |  |
|**url** | **String** | Page URL from which the request was sent. |  |
|**tag** | **Map&lt;String, Object&gt;** | A customer-provided value or an object that was sent with identification request. |  |
|**confidence** | [**IdentificationConfidence**](IdentificationConfidence.md) |  |  [optional] |
|**visitorFound** | **Boolean** | Attribute represents if a visitor had been identified before. |  |
|**firstSeenAt** | [**IdentificationSeenAt**](IdentificationSeenAt.md) |  |  |
|**lastSeenAt** | [**IdentificationSeenAt**](IdentificationSeenAt.md) |  |  |
|**components** | [**Map&lt;String, RawDeviceAttribute&gt;**](RawDeviceAttribute.md) | It includes 35+ raw browser identification attributes to provide Fingerprint users with even more information than our standard visitor ID provides. This enables Fingerprint users to not have to run our open-source product in conjunction with Fingerprint Pro Plus and Enterprise to get those additional attributes. Warning: The raw signals data can change at any moment as we improve the product. We cannot guarantee the internal shape of raw device attributes to be stable, so typical semantic versioning rules do not apply here. Use this data with caution without assuming a specific structure beyond the generic type provided here.  |  [optional] |



