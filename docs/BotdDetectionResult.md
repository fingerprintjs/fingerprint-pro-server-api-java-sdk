

# BotdDetectionResult

Stores bot detection result

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**result** | [**ResultEnum**](#ResultEnum) | Bot detection result:  * &#x60;notDetected&#x60; - the visitor is not a bot  * &#x60;good&#x60; - good bot detected, such as Google bot, Baidu Spider, AlexaBot and so on  * &#x60;bad&#x60; - bad bot detected, such as Selenium, Puppeteer, Playwright, headless browsers, and so on  |  |


## Enum: ResultEnum

| Name | Value |
|---- | ----- |
| NOTDETECTED | &quot;notDetected&quot; |
| GOOD | &quot;good&quot; |
| BAD | &quot;bad&quot; |



