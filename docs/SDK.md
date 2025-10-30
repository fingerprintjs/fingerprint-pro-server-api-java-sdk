

# SDK

Contains information about the SDK used to perform the request.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**platform** | [**PlatformEnum**](#PlatformEnum) | Platform of the SDK used for the identification request. |  |
|**version** | **String** | Version string of the SDK used for the identification request. For example: &#x60;\&quot;3.12.1\&quot;&#x60;  |  |
|**integrations** | [**List&lt;Integration&gt;**](Integration.md) |  |  [optional] |



## Enum: PlatformEnum

| Name | Value |
|---- | -----|
| JS | &quot;js&quot; |
| ANDROID | &quot;android&quot; |
| IOS | &quot;ios&quot; |
| UNKNOWN | &quot;unknown&quot; |



