# FingerprintApi

All URIs are relative to *https://api.fpjs.io*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getEvent**](FingerprintApi.md#getEvent) | **GET** /events/{request_id} | Get event by requestId |
| [**getVisits**](FingerprintApi.md#getVisits) | **GET** /visitors/{visitor_id} | Get visits by visitorId |
| [**webhookTrace**](FingerprintApi.md#webhookTrace) | **TRACE** /webhook |  |



## getEvent

> EventResponse getEvent(requestId)

Get event by requestId

This endpoint allows you to get a detailed analysis of an individual request. 
**Only for Enterprise customers:** Please note that the response includes mobile signals (e.g. `rootApps`) even if the request originated from a non-mobile platform.
It is highly recommended that you **ignore** the mobile signals for such requests. 

Use `requestId` as the URL path parameter. This API method is scoped to a request, i.e. all returned information is by `requestId`.


### Example

```java
package main;

import com.fingerprint.api.FingerprintApi;
import com.fingerprint.model.EventResponse;
import com.fingerprint.model.Response;
import com.fingerprint.sdk.ApiClient;
import com.fingerprint.sdk.ApiException;
import com.fingerprint.sdk.Configuration;
import com.fingerprint.sdk.Region;

public class FingerprintApiExample {
    // Fingerprint Pro Secret API Key
    private static final String FPJS_API_SECRET = "Fingerprint Pro Secret API Key";
    public static void main(String... args) {
        // Create a new api client instance from Configuration with your Fingerprint Pro Server API Key and your Fingerprint Pro Server API Region.
        /*
        You can specify a region on getDefaultApiClient function's second parameter
        If you leave the second parameter empty, then Region.GLOBAL will be used as a default region
        Options for regions are:
        Region.GLOBAL
        Region.EUROPE
        Region.ASIA
        */
        ApiClient client = Configuration.getDefaultApiClient(FPJS_API_SECRET, Region.EUROPE);
        FingerprintApi api = new FingerprintApi(client);
        String requestId = "requestId_example"; // String | The unique [identifier](https://dev.fingerprint.com/docs/js-agent#requestid) of each analysis request.
        try {
            EventResponse result = apiInstance.getEvent(requestId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getEvent:" + e.getMessage());
        }
    }
}
```


### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **requestId** | **String**| The unique [identifier](https://dev.fingerprint.com/docs/js-agent#requestid) of each analysis request. | |

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

Get visits by visitorId

This endpoint allows you to get a history of visits for a specific `visitorId`. Use the `visitorId` as a URL path parameter.
Only information from the _Identification_ product is returned.

#### Headers

* `Retry-After` — Present in case of `429 Too many requests`. Indicates how long you should wait before making a follow-up request. The value is non-negative decimal integer indicating the seconds to delay after the response is received.


### Example

```java
package main;

import com.fingerprint.api.FingerprintApi;
import com.fingerprint.model.EventResponse;
import com.fingerprint.model.Response;
import com.fingerprint.sdk.ApiClient;
import com.fingerprint.sdk.ApiException;
import com.fingerprint.sdk.Configuration;
import com.fingerprint.sdk.Region;

public class FingerprintApiExample {
    // Fingerprint Pro Secret API Key
    private static final String FPJS_API_SECRET = "Fingerprint Pro Secret API Key";
    public static void main(String... args) {
        // Create a new api client instance from Configuration with your Fingerprint Pro Server API Key and your Fingerprint Pro Server API Region.
        /*
        You can specify a region on getDefaultApiClient function's second parameter
        If you leave the second parameter empty, then Region.GLOBAL will be used as a default region
        Options for regions are:
        Region.GLOBAL
        Region.EUROPE
        Region.ASIA
        */
        ApiClient client = Configuration.getDefaultApiClient(FPJS_API_SECRET, Region.EUROPE);
        FingerprintApi api = new FingerprintApi(client);
        String visitorId = "uYIm7Ksp5rf00SllPhFp"; // String | Unique identifier of the visitor issued by Fingerprint Pro.
        String requestId = "requestId_example"; // String | Filter visits by `requestId`.   Every identification request has a unique identifier associated with it called `requestId`. This identifier is returned to the client in the identification [result](https://dev.fingerprint.com/docs/js-agent#requestid). When you filter visits by `requestId`, only one visit will be returned. 
        String linkedId = "linkedId_example"; // String | Filter visits by your custom identifier.   You can use [`linkedId`](https://dev.fingerprint.com/docs/js-agent#linkedid) to associate identification requests with your own identifier, for example: session ID, purchase ID, or transaction ID. You can then use this `linked_id` parameter to retrieve all events associated with your custom identifier. 
        Integer limit = 56; // Integer | Limit scanned results.   For performance reasons, the API first scans some number of events before filtering them. Use `limit` to specify how many events are scanned before they are filtered by `requestId` or `linkedId`. Results are always returned sorted by the timestamp (most recent first). By default, the most recent 100 visits are scanned, the maximum is 500. 
        String paginationKey = "paginationKey_example"; // String | Use `paginationKey` to get the next page of results.   When more results are available (e.g., you requested 200 results using `limit` parameter, but a total of 600 results are available), the `paginationKey` top-level attribute is added to the response. The key corresponds to the `requestId` of the last returned event. In the following request, use that value in the `paginationKey` parameter to get the next page of results:  1. First request, returning most recent 200 events: `GET api-base-url/visitors/:visitorId?limit=200` 2. Use `response.paginationKey` to get the next page of results: `GET api-base-url/visitors/:visitorId?limit=200&paginationKey=1683900801733.Ogvu1j`  Pagination happens during scanning and before filtering, so you can get less visits than the `limit` you specified with more available on the next page. When there are no more results available for scanning, the `paginationKey` attribute is not returned. 
        Long before = 56L; // Long | ⚠️ Deprecated pagination method, please use `paginationKey` instead. Timestamp (in milliseconds since epoch) used to paginate results. 
        try {
            Response result = apiInstance.getVisits(visitorIdrequestIdlinkedIdlimitpaginationKeybefore);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getVisits:" + e.getMessage());
        }
    }
}
```


### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **visitorId** | **String**| Unique identifier of the visitor issued by Fingerprint Pro. | |
| **requestId** | **String**| Filter visits by `requestId`.   Every identification request has a unique identifier associated with it called `requestId`. This identifier is returned to the client in the identification [result](https://dev.fingerprint.com/docs/js-agent#requestid). When you filter visits by `requestId`, only one visit will be returned.  | [optional] |
| **linkedId** | **String**| Filter visits by your custom identifier.   You can use [`linkedId`](https://dev.fingerprint.com/docs/js-agent#linkedid) to associate identification requests with your own identifier, for example: session ID, purchase ID, or transaction ID. You can then use this `linked_id` parameter to retrieve all events associated with your custom identifier.  | [optional] |
| **limit** | **Integer**| Limit scanned results.   For performance reasons, the API first scans some number of events before filtering them. Use `limit` to specify how many events are scanned before they are filtered by `requestId` or `linkedId`. Results are always returned sorted by the timestamp (most recent first). By default, the most recent 100 visits are scanned, the maximum is 500.  | [optional] |
| **paginationKey** | **String**| Use `paginationKey` to get the next page of results.   When more results are available (e.g., you requested 200 results using `limit` parameter, but a total of 600 results are available), the `paginationKey` top-level attribute is added to the response. The key corresponds to the `requestId` of the last returned event. In the following request, use that value in the `paginationKey` parameter to get the next page of results:  1. First request, returning most recent 200 events: `GET api-base-url/visitors/:visitorId?limit=200` 2. Use `response.paginationKey` to get the next page of results: `GET api-base-url/visitors/:visitorId?limit=200&paginationKey=1683900801733.Ogvu1j`  Pagination happens during scanning and before filtering, so you can get less visits than the `limit` you specified with more available on the next page. When there are no more results available for scanning, the `paginationKey` attribute is not returned.  | [optional] |
| **before** | **Long**| ⚠️ Deprecated pagination method, please use `paginationKey` instead. Timestamp (in milliseconds since epoch) used to paginate results.  | [optional] |

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
| **429** | Too Many Requests |  * Retry-After - Indicates how long you should wait before attempting the next request. <br>  |


## webhookTrace

> webhookTrace()



Fake path to describe webhook format. More information about webhooks can be found in the [documentation](https://dev.fingerprint.com/docs/webhooks)

### Example

```java
package main;

import com.fingerprint.api.FingerprintApi;
import com.fingerprint.model.EventResponse;
import com.fingerprint.model.Response;
import com.fingerprint.sdk.ApiClient;
import com.fingerprint.sdk.ApiException;
import com.fingerprint.sdk.Configuration;
import com.fingerprint.sdk.Region;

public class FingerprintApiExample {
    // Fingerprint Pro Secret API Key
    private static final String FPJS_API_SECRET = "Fingerprint Pro Secret API Key";
    public static void main(String... args) {
        // Create a new api client instance from Configuration with your Fingerprint Pro Server API Key and your Fingerprint Pro Server API Region.
        /*
        You can specify a region on getDefaultApiClient function's second parameter
        If you leave the second parameter empty, then Region.GLOBAL will be used as a default region
        Options for regions are:
        Region.GLOBAL
        Region.EUROPE
        Region.ASIA
        */
        ApiClient client = Configuration.getDefaultApiClient(FPJS_API_SECRET, Region.EUROPE);
        FingerprintApi api = new FingerprintApi(client);
        try {
            apiInstance.webhookTrace();
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.webhookTrace:" + e.getMessage());
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

