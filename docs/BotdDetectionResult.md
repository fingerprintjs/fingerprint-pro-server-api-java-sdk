

# BotdDetectionResult

Stores bot detection result

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**result** | [**ResultEnum**](#ResultEnum) | Bot detection result:  * `notDetected` - the visitor is not a bot  * `good` - good bot detected, such as Google bot, Baidu Spider, AlexaBot and so on  * `bad` - bad bot detected, such as Selenium, Puppeteer, Playwright, headless browsers, and so on  |  |
|**type** | **String** |  |  [optional] |


## Enum: ResultEnum

| Name | Value |
|---- | ----- |
| NOTDETECTED | &quot;notDetected&quot; |
| GOOD | &quot;good&quot; |
| BAD | &quot;bad&quot; |



