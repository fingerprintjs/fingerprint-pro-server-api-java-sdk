

# Botd

Contains all the information from Bot Detection product

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**bot** | [**BotdBot**](BotdBot.md) |  |  |
|**meta** | **Map&lt;String, Object&gt;** | A customer-provided value or an object that was sent with identification request. |  [optional] |
|**linkedId** | **String** | A customer-provided id that was sent with the request. |  [optional] |
|**url** | **String** | Page URL from which the request was sent. |  |
|**ip** | **String** | IP address of the requesting browser or bot. |  |
|**time** | **OffsetDateTime** | Time in UTC when the request from the JS agent was made. We recommend to treat requests that are older than 2 minutes as malicious. Otherwise, request replay attacks are possible. |  |
|**userAgent** | **String** |  |  |
|**requestId** | **String** | Unique identifier of the user's request. |  |



