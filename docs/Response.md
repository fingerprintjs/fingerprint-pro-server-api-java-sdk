

# Response

Fields `lastTimestamp` and `paginationKey` added when `limit` or `before` parameter provided and there is more data to show

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**visitorId** | **String** |  |  |
|**visits** | [**List&lt;ResponseVisits&gt;**](ResponseVisits.md) |  |  |
|**lastTimestamp** | **Long** | ⚠️ Deprecated paging attribute, please use `paginationKey` instead. Timestamp of the last visit in the current page of results.  |  [optional] |
|**paginationKey** | **String** | Request ID of the last visit in the current page of results. Use this value in the following request as the `paginationKey` parameter to get the next page of results. |  [optional] |



