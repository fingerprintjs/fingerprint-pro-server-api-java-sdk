# Response

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**visitorId** | **String** |  | 
**visits** | [**List&lt;ResponseVisits&gt;**](ResponseVisits.md) |  | 
**lastTimestamp** | **Long** | When more results are available (e.g., you scanned 200 results using &#x60;limit&#x60; parameter, but a total of 600 results are available), a special &#x60;lastTimestamp&#x60; top-level attribute is added to the response. If you want to paginate the results further in the past, you should use the value of this attribute. |  [optional]
**paginationKey** | **String** | Visit&#x27;s &#x60;requestId&#x60; of the last visit in the current page. |  [optional]
