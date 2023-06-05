

# ErrorEvent403ResponseError


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**code** | [**CodeEnum**](#CodeEnum) | Error code:  * `TokenRequired` - `Auth-API-Key` header is missing or empty  * `TokenNotFound` - subscription not found for specified secret key  * `SubscriptionNotActive` - subscription is not active  * `WrongRegion` - server and subscription region differ  |  |
|**message** | **String** |  |  |


## Enum: CodeEnum

| Name | Value |
|---- | ----- |
| TOKENREQUIRED | &quot;TokenRequired&quot; |
| TOKENNOTFOUND | &quot;TokenNotFound&quot; |
| SUBSCRIPTIONNOTACTIVE | &quot;SubscriptionNotActive&quot; |
| WRONGREGION | &quot;WrongRegion&quot; |



