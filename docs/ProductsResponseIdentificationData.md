

# ProductsResponseIdentificationData


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**requestId** | **String** | Unique identifier of the user's identification request. |  |
|**browserDetails** | [**BrowserDetails**](BrowserDetails.md) |  |  |
|**incognito** | **Boolean** | Flag if user used incognito session. |  |
|**ip** | **String** |  |  |
|**ipLocation** | [**DeprecatedIPLocation**](DeprecatedIPLocation.md) |  |  [optional] |
|**timestamp** | **Long** | Timestamp of the event with millisecond precision in Unix time. |  |
|**time** | [**OffsetDateTime**](OffsetDateTime.md) | Time expressed according to ISO 8601 in UTC format. |  |
|**url** | **String** | Page URL from which the identification request was sent. |  |
|**tag** | **Map&lt;String, Object&gt;** | A customer-provided value or an object that was sent with identification request. |  |
|**linkedId** | **String** | A customer-provided id that was sent with identification request. |  [optional] |
|**confidence** | [**Confidence**](Confidence.md) |  |  [optional] |
|**visitorFound** | **Boolean** | Attribute represents if a visitor had been identified before. |  |
|**firstSeenAt** | [**SeenAt**](SeenAt.md) |  |  |
|**lastSeenAt** | [**SeenAt**](SeenAt.md) |  |  |
|**visitorId** | **String** | String of 20 characters that uniquely identifies the visitor's browser.  |  |



