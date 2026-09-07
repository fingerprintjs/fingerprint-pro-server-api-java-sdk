

# VisitorsGetResponse

Deprecated response shape for `GET /visitors/{visitor_id}`. The `visits` array currently contains at most one item. Use `GET /events/search` for multi-event history and filtering.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**visitorId** | **String** |  |  |
|**visits** | [**List&lt;Visit&gt;**](Visit.md) |  |  |
|**lastTimestamp** | **Long** | ⚠️ Deprecated paging attribute, please use `paginationKey` instead. Timestamp of the last visit in the current page of results.  |  [optional] |
|**paginationKey** | **String** | Use this value in the following request as the `paginationKey` parameter to get the next result. |  [optional] |



