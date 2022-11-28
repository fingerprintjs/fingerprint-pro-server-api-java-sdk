# ProductsResponseIdentificationData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**requestId** | **String** | Unique identifier of the user&#x27;s identification request. | 
**browserDetails** | [**BrowserDetails**](BrowserDetails.md) |  | 
**incognito** | **Boolean** | Flag if user used incognito session. | 
**ip** | **String** |  | 
**ipLocation** | [**IPLocation**](IPLocation.md) |  | 
**timestamp** | **Long** | Timestamp of the event with millisecond precision in Unix time. | 
**time** | [**OffsetDateTime**](OffsetDateTime.md) | Time expressed according to ISO 8601 in UTC format. | 
**url** | **String** | Page URL from which identification request was sent. | 
**tag** | **Map&lt;String, Object&gt;** | A customer-provided value or an object that was sent with identification request. |  [optional]
**linkedId** | **String** | A customer-provided id that was sent with identification request. |  [optional]
**confidence** | [**Confidence**](Confidence.md) |  | 
**visitorFound** | **Boolean** | Attribute represents if a visitor had been identified before. | 
**firstSeenAt** | [**StSeenAt**](StSeenAt.md) |  | 
**lastSeenAt** | [**StSeenAt**](StSeenAt.md) |  | 
**visitorId** | **String** |  | 
