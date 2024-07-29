

# Common403ErrorResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**code** | [**CodeEnum**](#CodeEnum) | Error code:  * `TokenRequired` - `Auth-API-Key` header is missing or empty  * `TokenNotFound` - No Fingerprint application found for specified secret key  * `SubscriptionNotActive` - Fingerprint application is not active  * `WrongRegion` - server and application region differ  * `FeatureNotEnabled` - this feature (for example, Delete API) is not enabled for your application  |  |
|**message** | **String** |  |  |


## Enum: CodeEnum

| Name | Value |
|---- | ----- |
| TOKEN_REQUIRED | &quot;TokenRequired&quot; |
| TOKEN_NOT_FOUND | &quot;TokenNotFound&quot; |
| SUBSCRIPTION_NOT_ACTIVE | &quot;SubscriptionNotActive&quot; |
| WRONG_REGION | &quot;WrongRegion&quot; |
| FEATURE_NOT_ENABLED | &quot;FeatureNotEnabled&quot; |



