

# Common403ErrorResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**code** | [**CodeEnum**](#CodeEnum) | Error code:  * &#x60;TokenRequired&#x60; - &#x60;Auth-API-Key&#x60; header is missing or empty  * &#x60;TokenNotFound&#x60; - No Fingerprint application found for specified secret key  * &#x60;SubscriptionNotActive&#x60; - Fingerprint application is not active  * &#x60;WrongRegion&#x60; - server and application region differ  * &#x60;FeatureNotEnabled&#x60; - this feature (for example, Delete API) is not enabled for your application  |  |
|**message** | **String** |  |  |



## Enum: CodeEnum

| Name | Value |
|---- | -----|
| TOKENREQUIRED | &quot;TokenRequired&quot; |
| TOKENNOTFOUND | &quot;TokenNotFound&quot; |
| SUBSCRIPTIONNOTACTIVE | &quot;SubscriptionNotActive&quot; |
| WRONGREGION | &quot;WrongRegion&quot; |
| FEATURENOTENABLED | &quot;FeatureNotEnabled&quot; |



