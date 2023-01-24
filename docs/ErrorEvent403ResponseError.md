

# ErrorEvent403ResponseError


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**code** | [**CodeEnum**](#CodeEnum) | Error code:  * &#x60;TokenRequired&#x60; - &#x60;Auth-API-Key&#x60; header is missing or empty  * &#x60;TokenNotFound&#x60; - subscription not found for specified secret key  * &#x60;SubscriptionNotActive&#x60; - subscription is not active  * &#x60;WrongRegion&#x60; - server and subscription region differ  |  |
|**message** | **String** |  |  |



## Enum: CodeEnum

| Name | Value |
|---- | -----|
| TOKENREQUIRED | &quot;TokenRequired&quot; |
| TOKENNOTFOUND | &quot;TokenNotFound&quot; |
| SUBSCRIPTIONNOTACTIVE | &quot;SubscriptionNotActive&quot; |
| WRONGREGION | &quot;WrongRegion&quot; |



