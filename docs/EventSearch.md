

# EventSearch

Contains a list of all identification events matching the specified search criteria.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**events** | [**List&lt;Event&gt;**](Event.md) |  |  |
|**paginationKey** | **String** | Use this value in the &#x60;pagination_key&#x60; parameter to request the next page of search results. |  [optional] |
|**totalHits** | **Long** | This value represents the total number of events matching the search query, up to the limit provided in the &#x60;total_hits&#x60; query parameter. Only present if the &#x60;total_hits&#x60; query parameter was provided. |  [optional] |



