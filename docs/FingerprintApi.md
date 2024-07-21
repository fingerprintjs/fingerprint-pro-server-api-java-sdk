# FingerprintApi

All URIs are relative to *https://api.fpjs.io*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteVisitorData**](FingerprintApi.md#deleteVisitorData) | **DELETE** /visitors/{visitor_id} | Delete data by visitor ID |
| [**getEvent**](FingerprintApi.md#getEvent) | **GET** /events/{request_id} | Get event by request ID |
| [**getVisits**](FingerprintApi.md#getVisits) | **GET** /visitors/{visitor_id} | Get visits by visitor ID |
| [**webhookTrace**](FingerprintApi.md#webhookTrace) | **TRACE** /webhook |  |



## deleteVisitorData

> deleteVisitorData(visitorId)

Delete data by visitor ID

Request deleting all data associated with the specified visitor ID. This API is useful for compliance with privacy regulations.
All delete requests are queued: 

* Recent data (10 days or newer) belonging to the specified visitor will be deleted within 24 hours.
* Data from older (11 days or more) identification events  will be deleted after 90 days.

If you are interested in using this API, please [contact our support team](https://fingerprint.com/support/) to activate it for you. Otherwise, you will receive a 403.


### Example

```java
// Import classes:
import com.fingerprint.sdk.ApiClient;
import com.fingerprint.sdk.ApiException;
import com.fingerprint.sdk.Configuration;
import com.fingerprint.sdk.auth.*;
import com.fingerprint.sdk.model.*;
import com.fingerprint.api.FingerprintApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.fpjs.io");
        
        // Configure API key authorization: ApiKeyHeader
        ApiKeyAuth ApiKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyHeader");
        ApiKeyHeader.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKeyHeader.setApiKeyPrefix("Token");

        // Configure API key authorization: ApiKeyQuery
        ApiKeyAuth ApiKeyQuery = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyQuery");
        ApiKeyQuery.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKeyQuery.setApiKeyPrefix("Token");

        FingerprintApi apiInstance = new FingerprintApi(defaultClient);
        String visitorId = "visitorId_example"; // String | The [visitor ID](https://dev.fingerprint.com/docs/js-agent#visitorid) you want to delete.
        try {
            apiInstance.deleteVisitorData(visitorId);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi#deleteVisitorData");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **visitorId** | **String**| The [visitor ID](https://dev.fingerprint.com/docs/js-agent#visitorid) you want to delete. | |

### Return type

null (empty response body)

### Authorization

[ApiKeyHeader](../README.md#ApiKeyHeader), [ApiKeyQuery](../README.md#ApiKeyQuery)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK. The visitor ID is scheduled for deletion. |  -  |
| **400** | Bad request. The visitor ID parameter is missing or in the wrong format. |  -  |
| **403** | Forbidden. Access to this API is denied. |  -  |
| **404** | Not found. The visitor ID cannot be found in this application&#39;s data. |  -  |
| **429** | Too Many Requests. The request is throttled. |  -  |


## getEvent

> EventResponse getEvent(requestId)

Get event by request ID

Get a detailed analysis of an individual identification event, including Smart Signals. 
**Only for Enterprise customers:** Please note that the response includes mobile signals (e.g. `rootApps`) even if the request originated from a non-mobile platform.
It is highly recommended that you **ignore** the mobile signals for such requests. 

Use `requestId` as the URL path parameter. This API method is scoped to a request, i.e. all returned information is by `requestId`.


### Example

```java
// Import classes:
import com.fingerprint.sdk.ApiClient;
import com.fingerprint.sdk.ApiException;
import com.fingerprint.sdk.Configuration;
import com.fingerprint.sdk.auth.*;
import com.fingerprint.sdk.model.*;
import com.fingerprint.api.FingerprintApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.fpjs.io");
        
        // Configure API key authorization: ApiKeyHeader
        ApiKeyAuth ApiKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyHeader");
        ApiKeyHeader.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKeyHeader.setApiKeyPrefix("Token");

        // Configure API key authorization: ApiKeyQuery
        ApiKeyAuth ApiKeyQuery = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyQuery");
        ApiKeyQuery.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKeyQuery.setApiKeyPrefix("Token");

        FingerprintApi apiInstance = new FingerprintApi(defaultClient);
        String requestId = "requestId_example"; // String | The unique [identifier](https://dev.fingerprint.com/docs/js-agent#requestid) of each identification request.
        try {
            EventResponse result = apiInstance.getEvent(requestId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi#getEvent");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **requestId** | **String**| The unique [identifier](https://dev.fingerprint.com/docs/js-agent#requestid) of each identification request. | |

### Return type

[**EventResponse**](EventResponse.md)

### Authorization

[ApiKeyHeader](../README.md#ApiKeyHeader), [ApiKeyQuery](../README.md#ApiKeyQuery)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **403** | Forbidden |  -  |
| **404** | Not found |  -  |


## getVisits

> Response getVisits(visitorId, requestId, linkedId, limit, paginationKey, before)

Get visits by visitor ID

Get a history of visits (identification events) for a specific `visitorId`. Use the `visitorId` as a URL path parameter.
Only information from the _Identification_ product is returned.

#### Headers

* `Retry-After` — Present in case of `429 Too many requests`. Indicates how long you should wait before making a follow-up request. The value is non-negative decimal integer indicating the seconds to delay after the response is received.


### Example

```java
// Import classes:
import com.fingerprint.sdk.ApiClient;
import com.fingerprint.sdk.ApiException;
import com.fingerprint.sdk.Configuration;
import com.fingerprint.sdk.auth.*;
import com.fingerprint.sdk.model.*;
import com.fingerprint.api.FingerprintApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.fpjs.io");
        
        // Configure API key authorization: ApiKeyHeader
        ApiKeyAuth ApiKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyHeader");
        ApiKeyHeader.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKeyHeader.setApiKeyPrefix("Token");

        // Configure API key authorization: ApiKeyQuery
        ApiKeyAuth ApiKeyQuery = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyQuery");
        ApiKeyQuery.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKeyQuery.setApiKeyPrefix("Token");

        FingerprintApi apiInstance = new FingerprintApi(defaultClient);
        String visitorId = "uYIm7Ksp5rf00SllPhFp"; // String | Unique [visitor identifier](https://dev.fingerprint.com/docs/js-agent#visitorid) issued by Fingerprint Pro.
        String requestId = "requestId_example"; // String | Filter visits by `requestId`.   Every identification request has a unique identifier associated with it called `requestId`. This identifier is returned to the client in the identification [result](https://dev.fingerprint.com/docs/js-agent#requestid). When you filter visits by `requestId`, only one visit will be returned. 
        String linkedId = "linkedId_example"; // String | Filter visits by your custom identifier.   You can use [`linkedId`](https://dev.fingerprint.com/docs/js-agent#linkedid) to associate identification requests with your own identifier, for example: session ID, purchase ID, or transaction ID. You can then use this `linked_id` parameter to retrieve all events associated with your custom identifier. 
        Integer limit = 56; // Integer | Limit scanned results.   For performance reasons, the API first scans some number of events before filtering them. Use `limit` to specify how many events are scanned before they are filtered by `requestId` or `linkedId`. Results are always returned sorted by the timestamp (most recent first). By default, the most recent 100 visits are scanned, the maximum is 500. 
        String paginationKey = "paginationKey_example"; // String | Use `paginationKey` to get the next page of results.   When more results are available (e.g., you requested 200 results using `limit` parameter, but a total of 600 results are available), the `paginationKey` top-level attribute is added to the response. The key corresponds to the `requestId` of the last returned event. In the following request, use that value in the `paginationKey` parameter to get the next page of results:  1. First request, returning most recent 200 events: `GET api-base-url/visitors/:visitorId?limit=200` 2. Use `response.paginationKey` to get the next page of results: `GET api-base-url/visitors/:visitorId?limit=200&paginationKey=1683900801733.Ogvu1j`  Pagination happens during scanning and before filtering, so you can get less visits than the `limit` you specified with more available on the next page. When there are no more results available for scanning, the `paginationKey` attribute is not returned. 
        Long before = 56L; // Long | ⚠️ Deprecated pagination method, please use `paginationKey` instead. Timestamp (in milliseconds since epoch) used to paginate results. 
        try {
            Response result = apiInstance.getVisits(visitorId, requestId, linkedId, limit, paginationKey, before);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi#getVisits");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **visitorId** | **String**| Unique [visitor identifier](https://dev.fingerprint.com/docs/js-agent#visitorid) issued by Fingerprint Pro. | |
| **requestId** | **String**| Filter visits by &#x60;requestId&#x60;.   Every identification request has a unique identifier associated with it called &#x60;requestId&#x60;. This identifier is returned to the client in the identification [result](https://dev.fingerprint.com/docs/js-agent#requestid). When you filter visits by &#x60;requestId&#x60;, only one visit will be returned.  | [optional] |
| **linkedId** | **String**| Filter visits by your custom identifier.   You can use [&#x60;linkedId&#x60;](https://dev.fingerprint.com/docs/js-agent#linkedid) to associate identification requests with your own identifier, for example: session ID, purchase ID, or transaction ID. You can then use this &#x60;linked_id&#x60; parameter to retrieve all events associated with your custom identifier.  | [optional] |
| **limit** | **Integer**| Limit scanned results.   For performance reasons, the API first scans some number of events before filtering them. Use &#x60;limit&#x60; to specify how many events are scanned before they are filtered by &#x60;requestId&#x60; or &#x60;linkedId&#x60;. Results are always returned sorted by the timestamp (most recent first). By default, the most recent 100 visits are scanned, the maximum is 500.  | [optional] |
| **paginationKey** | **String**| Use &#x60;paginationKey&#x60; to get the next page of results.   When more results are available (e.g., you requested 200 results using &#x60;limit&#x60; parameter, but a total of 600 results are available), the &#x60;paginationKey&#x60; top-level attribute is added to the response. The key corresponds to the &#x60;requestId&#x60; of the last returned event. In the following request, use that value in the &#x60;paginationKey&#x60; parameter to get the next page of results:  1. First request, returning most recent 200 events: &#x60;GET api-base-url/visitors/:visitorId?limit&#x3D;200&#x60; 2. Use &#x60;response.paginationKey&#x60; to get the next page of results: &#x60;GET api-base-url/visitors/:visitorId?limit&#x3D;200&amp;paginationKey&#x3D;1683900801733.Ogvu1j&#x60;  Pagination happens during scanning and before filtering, so you can get less visits than the &#x60;limit&#x60; you specified with more available on the next page. When there are no more results available for scanning, the &#x60;paginationKey&#x60; attribute is not returned.  | [optional] |
| **before** | **Long**| ⚠️ Deprecated pagination method, please use &#x60;paginationKey&#x60; instead. Timestamp (in milliseconds since epoch) used to paginate results.  | [optional] |

### Return type

[**Response**](Response.md)

### Authorization

[ApiKeyHeader](../README.md#ApiKeyHeader), [ApiKeyQuery](../README.md#ApiKeyQuery)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **403** | Forbidden. The API Key is probably missing or incorrect. |  -  |
| **429** | Too Many Requests |  * Retry-After - Indicates how many seconds you should wait before attempting the next request. <br>  |


## webhookTrace

> webhookTrace()



Fake path to describe webhook format. More information about webhooks can be found in the [documentation](https://dev.fingerprint.com/docs/webhooks)

### Example

```java
// Import classes:
import com.fingerprint.sdk.ApiClient;
import com.fingerprint.sdk.ApiException;
import com.fingerprint.sdk.Configuration;
import com.fingerprint.sdk.auth.*;
import com.fingerprint.sdk.model.*;
import com.fingerprint.api.FingerprintApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.fpjs.io");
        
        // Configure API key authorization: ApiKeyHeader
        ApiKeyAuth ApiKeyHeader = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyHeader");
        ApiKeyHeader.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKeyHeader.setApiKeyPrefix("Token");

        // Configure API key authorization: ApiKeyQuery
        ApiKeyAuth ApiKeyQuery = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyQuery");
        ApiKeyQuery.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKeyQuery.setApiKeyPrefix("Token");

        FingerprintApi apiInstance = new FingerprintApi(defaultClient);
        try {
            apiInstance.webhookTrace();
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi#webhookTrace");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[ApiKeyHeader](../README.md#ApiKeyHeader), [ApiKeyQuery](../README.md#ApiKeyQuery)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **0** | Dummy for the schema |  -  |

