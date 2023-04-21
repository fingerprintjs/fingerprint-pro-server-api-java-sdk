

# BotdResult

Contains all the information from Bot Detection product

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**ip** | **String** | IP address of the requesting browser or bot. |  |
|**time** | [**OffsetDateTime**](OffsetDateTime.md) | Time in UTC when the request from the JS agent was made. We recommend to treat requests that are older than 2 minutes as malicious. Otherwise, request replay attacks are possible |  |
|**url** | **String** | Page URL from which identification request was sent. |  |
|**bot** | [**BotdDetectionResult**](BotdDetectionResult.md) |  |  |



