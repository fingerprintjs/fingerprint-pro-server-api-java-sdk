

# ErrorUpdateEvent409ResponseError


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**code** | [**CodeEnum**](#CodeEnum) | Error code: * `StateNotReady` - The event specified with request id is not ready for updates yet. Try again. This error happens in rare cases when update API is called immediately after receiving the request id on the client. In case you need to send information right away, we recommend using the JS agent API instead.  |  |
|**message** | **String** |  |  |


## Enum: CodeEnum

| Name | Value |
|---- | ----- |
| STATE_NOT_READY | &quot;StateNotReady&quot; |



