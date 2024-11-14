

# VisitorsGetResponse

Pagination-related fields `lastTimestamp` and `paginationKey` are included if you use a pagination parameter like `limit` or `before` and there is more data available on the next page.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**visitorId** | **String** |  |  |
|**visits** | [**List&lt;Visit&gt;**](Visit.md) |  |  |
|**lastTimestamp** | **Long** | ⚠️ Deprecated paging attribute, please use `paginationKey` instead. Timestamp of the last visit in the current page of results.  |  [optional] |
|**paginationKey** | **String** | Request ID of the last visit in the current page of results. Use this value in the following request as the `paginationKey` parameter to get the next page of results. |  [optional] |



