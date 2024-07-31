

# ErrorUpdateEvent400ResponseError


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**code** | [**CodeEnum**](#CodeEnum) | Error code: * `RequestCannotBeParsed` - the JSON content of the request contains some errors that prevented us from parsing it (wrong type/surpassed limits) * `Failed` - the event is more than 10 days old and cannot be updated  |  |
|**message** | **String** | Details about the underlying issue with the input payload |  |


## Enum: CodeEnum

| Name | Value |
|---- | ----- |
| REQUEST_CANNOT_BE_PARSED | &quot;RequestCannotBeParsed&quot; |
| FAILED | &quot;Failed&quot; |



