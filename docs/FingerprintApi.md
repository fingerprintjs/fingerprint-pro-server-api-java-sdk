# FingerprintApi

All URIs are relative to *https://api.fpjs.io*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteVisitorData**](FingerprintApi.md#deleteVisitorData) | **DELETE** /visitors/{visitor_id} | Delete data by visitor ID |
| [**getEvent**](FingerprintApi.md#getEvent) | **GET** /events/{request_id} | Get event by request ID |
| [**getRelatedVisitors**](FingerprintApi.md#getRelatedVisitors) | **GET** /related-visitors | Get Related Visitors |
| [**getVisits**](FingerprintApi.md#getVisits) | **GET** /visitors/{visitor_id} | Get visits by visitor ID |
| [**searchEvents**](FingerprintApi.md#searchEvents) | **GET** /events/search | Get events via search |
| [**updateEvent**](FingerprintApi.md#updateEvent) | **PUT** /events/{request_id} | Update an event with a given request ID |
| [**webhookTrace**](FingerprintApi.md#webhookTrace) | **TRACE** /webhook |  |



## deleteVisitorData

> deleteVisitorData(visitorId)

Delete data by visitor ID

Request deleting all data associated with the specified visitor ID. This API is useful for compliance with privacy regulations.
### Which data is deleted?
- Browser (or device) properties
- Identification requests made from this browser (or device)

#### Browser (or device) properties
- Represents the data that Fingerprint collected from this specific browser (or device) and everything inferred and derived from it.
- Upon request to delete, this data is deleted asynchronously (typically within a few minutes) and it will no longer be used to identify this browser (or device) for your [Fingerprint Application](https://dev.fingerprint.com/docs/glossary#fingerprint-application).

#### Identification requests made from this browser (or device)
- Fingerprint stores the identification requests made from a browser (or device) for up to 30 (or 90) days depending on your plan. To learn more, see [Data Retention](https://dev.fingerprint.com/docs/regions#data-retention).
- Upon request to delete, the identification requests that were made by this browser
  - Within the past 10 days are deleted within 24 hrs.
  - Outside of 10 days are allowed to purge as per your data retention period.

### Corollary
After requesting to delete a visitor ID,
- If the same browser (or device) requests to identify, it will receive a different visitor ID.
- If you request [`/events` API](https://dev.fingerprint.com/reference/getevent) with a `request_id` that was made outside of the 10 days, you will still receive a valid response.
- If you request [`/visitors` API](https://dev.fingerprint.com/reference/getvisits) for the deleted visitor ID, the response will include identification requests that were made outside of those 10 days.

### Interested?
Please [contact our support team](https://fingerprint.com/support/) to enable it for you. Otherwise, you will receive a 403.


### Example

```java
package main;

import com.fingerprint.api.FingerprintApi;
import com.fingerprint.model.EventsGetResponse;
import com.fingerprint.model.EventsUpdateRequest;
import com.fingerprint.model.VisitorsGetResponse;
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
        String visitorId = "visitorId_example"; // String | The [visitor ID](https://dev.fingerprint.com/reference/get-function#visitorid) you want to delete.
        try {
            apiInstance.deleteVisitorData(visitorId);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.deleteVisitorData:" + e.getMessage());
        }
    }
}
```


### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **visitorId** | **String**| The [visitor ID](https://dev.fingerprint.com/reference/get-function#visitorid) you want to delete. | |

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

> EventsGetResponse getEvent(requestId)

Get event by request ID

Get a detailed analysis of an individual identification event, including Smart Signals. 
Please note that the response includes mobile signals (e.g. `rootApps`) even if the request originated from a non-mobile platform.
It is highly recommended that you **ignore** the mobile signals for such requests. 

Use `requestId` as the URL path parameter. This API method is scoped to a request, i.e. all returned information is by `requestId`.


### Example

```java
package main;

import com.fingerprint.api.FingerprintApi;
import com.fingerprint.model.EventsGetResponse;
import com.fingerprint.model.EventsUpdateRequest;
import com.fingerprint.model.VisitorsGetResponse;
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
        String requestId = "requestId_example"; // String | The unique [identifier](https://dev.fingerprint.com/reference/get-function#requestid) of each identification request.
        try {
            EventsGetResponse result = apiInstance.getEvent(requestId);
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
| **requestId** | **String**| The unique [identifier](https://dev.fingerprint.com/reference/get-function#requestid) of each identification request. | |

### Return type

[**EventsGetResponse**](EventsGetResponse.md)

### Authorization

[ApiKeyHeader](../README.md#ApiKeyHeader), [ApiKeyQuery](../README.md#ApiKeyQuery)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK. |  -  |
| **403** | Forbidden. Access to this API is denied. |  -  |
| **404** | Not found. The request ID cannot be found in this application&#39;s data. |  -  |


## getRelatedVisitors

> RelatedVisitorsResponse getRelatedVisitors(visitorId)

Get Related Visitors

Related visitors API lets you link web visits and in-app browser visits that originated from the same mobile device.
It searches the past 6 months of identification events to find the visitor IDs that belong to the same mobile device as the given visitor ID.

⚠️ Please note that this API is not enabled by default and is billable separately. ⚠️

If you would like to use Related visitors API, please contact our [support team](https://fingerprint.com/support).
To learn more, see [Related visitors API reference](https://dev.fingerprint.com/reference/related-visitors-api).


### Example

```java
package main;

import com.fingerprint.api.FingerprintApi;
import com.fingerprint.model.EventsGetResponse;
import com.fingerprint.model.EventsUpdateRequest;
import com.fingerprint.model.VisitorsGetResponse;
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
        String visitorId = "visitorId_example"; // String | The [visitor ID](https://dev.fingerprint.com/reference/get-function#visitorid) for which you want to find the other visitor IDs that originated from the same mobile device.
        try {
            RelatedVisitorsResponse result = apiInstance.getRelatedVisitors(visitorId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getRelatedVisitors:" + e.getMessage());
        }
    }
}
```


### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **visitorId** | **String**| The [visitor ID](https://dev.fingerprint.com/reference/get-function#visitorid) for which you want to find the other visitor IDs that originated from the same mobile device. | |

### Return type

[**RelatedVisitorsResponse**](RelatedVisitorsResponse.md)

### Authorization

[ApiKeyHeader](../README.md#ApiKeyHeader), [ApiKeyQuery](../README.md#ApiKeyQuery)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK. |  -  |
| **400** | Bad request. The visitor ID parameter is missing or in the wrong format. |  -  |
| **403** | Forbidden. Access to this API is denied. |  -  |
| **404** | Not found. The visitor ID cannot be found in this application&#39;s data. |  -  |
| **429** | Too Many Requests. The request is throttled. |  -  |


## getVisits

> VisitorsGetResponse getVisits(visitorId, requestId, linkedId, limit, paginationKey, before)

Get visits by visitor ID

Get a history of visits (identification events) for a specific `visitorId`. Use the `visitorId` as a URL path parameter.
Only information from the _Identification_ product is returned.

#### Headers

* `Retry-After` — Present in case of `429 Too many requests`. Indicates how long you should wait before making a follow-up request. The value is non-negative decimal integer indicating the seconds to delay after the response is received.


### Example

```java
package main;

import com.fingerprint.api.FingerprintApi;
import com.fingerprint.model.EventsGetResponse;
import com.fingerprint.model.EventsUpdateRequest;
import com.fingerprint.model.VisitorsGetResponse;
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
        String visitorId = "visitorId_example"; // String | Unique [visitor identifier](https://dev.fingerprint.com/reference/get-function#visitorid) issued by Fingerprint Pro.
        String requestId = "requestId_example"; // String | Filter visits by `requestId`.   Every identification request has a unique identifier associated with it called `requestId`. This identifier is returned to the client in the identification [result](https://dev.fingerprint.com/reference/get-function#requestid). When you filter visits by `requestId`, only one visit will be returned. 
        String linkedId = "linkedId_example"; // String | Filter visits by your custom identifier.   You can use [`linkedId`](https://dev.fingerprint.com/reference/get-function#linkedid) to associate identification requests with your own identifier, for example: session ID, purchase ID, or transaction ID. You can then use this `linked_id` parameter to retrieve all events associated with your custom identifier. 
        Integer limit = 56; // Integer | Limit scanned results.   For performance reasons, the API first scans some number of events before filtering them. Use `limit` to specify how many events are scanned before they are filtered by `requestId` or `linkedId`. Results are always returned sorted by the timestamp (most recent first). By default, the most recent 100 visits are scanned, the maximum is 500. 
        String paginationKey = "paginationKey_example"; // String | Use `paginationKey` to get the next page of results.   When more results are available (e.g., you requested 200 results using `limit` parameter, but a total of 600 results are available), the `paginationKey` top-level attribute is added to the response. The key corresponds to the `requestId` of the last returned event. In the following request, use that value in the `paginationKey` parameter to get the next page of results:  1. First request, returning most recent 200 events: `GET api-base-url/visitors/:visitorId?limit=200` 2. Use `response.paginationKey` to get the next page of results: `GET api-base-url/visitors/:visitorId?limit=200&paginationKey=1683900801733.Ogvu1j`  Pagination happens during scanning and before filtering, so you can get less visits than the `limit` you specified with more available on the next page. When there are no more results available for scanning, the `paginationKey` attribute is not returned. 
        Long before = 56L; // Long | ⚠️ Deprecated pagination method, please use `paginationKey` instead. Timestamp (in milliseconds since epoch) used to paginate results. 
        try {
            VisitorsGetResponse result = apiInstance.getVisits(visitorId, requestId, linkedId, limit, paginationKey, before);
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
| **visitorId** | **String**| Unique [visitor identifier](https://dev.fingerprint.com/reference/get-function#visitorid) issued by Fingerprint Pro. | |
| **requestId** | **String**| Filter visits by `requestId`.   Every identification request has a unique identifier associated with it called `requestId`. This identifier is returned to the client in the identification [result](https://dev.fingerprint.com/reference/get-function#requestid). When you filter visits by `requestId`, only one visit will be returned.  | [optional] |
| **linkedId** | **String**| Filter visits by your custom identifier.   You can use [`linkedId`](https://dev.fingerprint.com/reference/get-function#linkedid) to associate identification requests with your own identifier, for example: session ID, purchase ID, or transaction ID. You can then use this `linked_id` parameter to retrieve all events associated with your custom identifier.  | [optional] |
| **limit** | **Integer**| Limit scanned results.   For performance reasons, the API first scans some number of events before filtering them. Use `limit` to specify how many events are scanned before they are filtered by `requestId` or `linkedId`. Results are always returned sorted by the timestamp (most recent first). By default, the most recent 100 visits are scanned, the maximum is 500.  | [optional] |
| **paginationKey** | **String**| Use `paginationKey` to get the next page of results.   When more results are available (e.g., you requested 200 results using `limit` parameter, but a total of 600 results are available), the `paginationKey` top-level attribute is added to the response. The key corresponds to the `requestId` of the last returned event. In the following request, use that value in the `paginationKey` parameter to get the next page of results:  1. First request, returning most recent 200 events: `GET api-base-url/visitors/:visitorId?limit=200` 2. Use `response.paginationKey` to get the next page of results: `GET api-base-url/visitors/:visitorId?limit=200&paginationKey=1683900801733.Ogvu1j`  Pagination happens during scanning and before filtering, so you can get less visits than the `limit` you specified with more available on the next page. When there are no more results available for scanning, the `paginationKey` attribute is not returned.  | [optional] |
| **before** | **Long**| ⚠️ Deprecated pagination method, please use `paginationKey` instead. Timestamp (in milliseconds since epoch) used to paginate results.  | [optional] |

### Return type

[**VisitorsGetResponse**](VisitorsGetResponse.md)

### Authorization

[ApiKeyHeader](../README.md#ApiKeyHeader), [ApiKeyQuery](../README.md#ApiKeyQuery)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK. |  -  |
| **400** | Bad request. The visitor ID or query parameters are missing or in the wrong format. |  -  |
| **403** | Forbidden. Access to this API is denied. |  -  |
| **429** | Too Many Requests. The request is throttled. |  * Retry-After - Indicates how many seconds you should wait before attempting the next request. <br>  |


## searchEvents

> SearchEventsResponse searchEvents(limit, paginationKey, visitorId, bot, ipAddress, linkedId, start, end, reverse, suspect)

Get events via search

Search for identification events, including Smart Signals, using multiple filtering criteria. If you don't provide `start` or `end` parameters, the default search range is the last 7 days.

Please note that events include mobile signals (e.g. `rootApps`) even if the request originated from a non-mobile platform. We recommend you **ignore** mobile signals for such requests.


### Example

```java
package main;

import com.fingerprint.api.FingerprintApi;
import com.fingerprint.model.EventsGetResponse;
import com.fingerprint.model.EventsUpdateRequest;
import com.fingerprint.model.VisitorsGetResponse;
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
        Integer limit = 10; // Integer | Limit the number of events returned. 
        String paginationKey = "paginationKey_example"; // String | Use `pagination_key` to get the next page of results.   When more results are available (e.g., you requested up to 200 results for your search using `limit`, but there are more than 200 events total matching your request), the `paginationKey` top-level attribute is added to the response. The key corresponds to the `timestamp` of the last returned event. In the following request, use that value in the `pagination_key` parameter to get the next page of results:  1. First request, returning most recent 200 events: `GET api-base-url/events/search?limit=200` 2. Use `response.paginationKey` to get the next page of results: `GET api-base-url/events/search?limit=200&pagination_key=1740815825085` 
        String visitorId = "visitorId_example"; // String | Unique [visitor identifier](https://dev.fingerprint.com/reference/get-function#visitorid) issued by Fingerprint Pro. Filter for events matching this `visitor_id`. 
        String bot = "all"; // String | Filter events by the bot detection result, specifically:    `all` - events where any kind of bot was detected.   `good` - events where a good bot was detected.   `bad` - events where a bad bot was detected.   `none` - events where no bot was detected. 
        String ipAddress = "ipAddress_example"; // String | Filter events by IP address range. The range can be as specific as a single IP (/32 for IPv4 or /128 for IPv6)  All ip_address filters must use CIDR notation, for example, 10.0.0.0/24, 192.168.0.1/32 
        String linkedId = "linkedId_example"; // String | Filter events by your custom identifier.   You can use [linked IDs](https://dev.fingerprint.com/reference/get-function#linkedid) to associate identification requests with your own identifier, for example, session ID, purchase ID, or transaction ID. You can then use this `linked_id` parameter to retrieve all events associated with your custom identifier. 
        Long start = 56L; // Long | Filter events with a timestamp greater than the start time, in Unix time (milliseconds). 
        Long end = 56L; // Long | Filter events with a timestamp smaller than the end time, in Unix time (milliseconds). 
        Boolean reverse = true; // Boolean | Sort events in reverse timestamp order. 
        Boolean suspect = true; // Boolean | Filter events previously tagged as suspicious via the [Update API](https://dev.fingerprint.com/reference/updateevent).  > Note: When using this parameter, only events with the `suspect` property explicitly set to `true` or `false` are returned. Events with undefined `suspect` property are left out of the response. 
        try {
            SearchEventsResponse result = apiInstance.searchEvents(limit, new FingerprintApi.SearchEventsFilter()
                .setPaginationKey(paginationKey)
                .setVisitorId(visitorId)
                .setBot(bot)
                .setIpAddress(ipAddress)
                .setLinkedId(linkedId)
                .setStart(start)
                .setEnd(end)
                .setReverse(reverse)
                .setSuspect(suspect));
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.searchEvents:" + e.getMessage());
        }
    }
}
```


### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **limit** | **Integer**| Limit the number of events returned.  | |
| **searchEventsFilter** | [**FingerprintApi.SearchEventsFilter**](#fingerprintapisearcheventsfilter) | | [optional] |

#### FingerprintApi.SearchEventsFilter

Filter object containing optional parameters for specifying search criteria. Supports a fluent interface for convenient method chaining.

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **paginationKey** | **String**| Use `pagination_key` to get the next page of results.   When more results are available (e.g., you requested up to 200 results for your search using `limit`, but there are more than 200 events total matching your request), the `paginationKey` top-level attribute is added to the response. The key corresponds to the `timestamp` of the last returned event. In the following request, use that value in the `pagination_key` parameter to get the next page of results:  1. First request, returning most recent 200 events: `GET api-base-url/events/search?limit=200` 2. Use `response.paginationKey` to get the next page of results: `GET api-base-url/events/search?limit=200&pagination_key=1740815825085`  | [optional] |
| **visitorId** | **String**| Unique [visitor identifier](https://dev.fingerprint.com/reference/get-function#visitorid) issued by Fingerprint Pro. Filter for events matching this `visitor_id`.  | [optional] |
| **bot** | **String**| Filter events by the bot detection result, specifically:    `all` - events where any kind of bot was detected.   `good` - events where a good bot was detected.   `bad` - events where a bad bot was detected.   `none` - events where no bot was detected.  | [optional] [enum: all, good, bad, none] |
| **ipAddress** | **String**| Filter events by IP address range. The range can be as specific as a single IP (/32 for IPv4 or /128 for IPv6)  All ip_address filters must use CIDR notation, for example, 10.0.0.0/24, 192.168.0.1/32  | [optional] |
| **linkedId** | **String**| Filter events by your custom identifier.   You can use [linked IDs](https://dev.fingerprint.com/reference/get-function#linkedid) to associate identification requests with your own identifier, for example, session ID, purchase ID, or transaction ID. You can then use this `linked_id` parameter to retrieve all events associated with your custom identifier.  | [optional] |
| **start** | **Long**| Filter events with a timestamp greater than the start time, in Unix time (milliseconds).  | [optional] |
| **end** | **Long**| Filter events with a timestamp smaller than the end time, in Unix time (milliseconds).  | [optional] |
| **reverse** | **Boolean**| Sort events in reverse timestamp order.  | [optional] |
| **suspect** | **Boolean**| Filter events previously tagged as suspicious via the [Update API](https://dev.fingerprint.com/reference/updateevent).  > Note: When using this parameter, only events with the `suspect` property explicitly set to `true` or `false` are returned. Events with undefined `suspect` property are left out of the response.  | [optional] |

### Return type

[**SearchEventsResponse**](SearchEventsResponse.md)

### Authorization

[ApiKeyHeader](../README.md#ApiKeyHeader), [ApiKeyQuery](../README.md#ApiKeyQuery)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Events matching the filter(s). |  -  |
| **400** | Bad request. One or more supplied search parameters are invalid, or a required parameter is missing. |  -  |
| **403** | Forbidden. Access to this API is denied. |  -  |


## updateEvent

> updateEvent(requestId, eventsUpdateRequest)

Update an event with a given request ID

Change information in existing events specified by `requestId` or *flag suspicious events*.

When an event is created, it is assigned `linkedId` and `tag` submitted through the JS agent parameters. This information might not be available on the client so the Server API allows for updating the attributes after the fact.

**Warning** It's not possible to update events older than 10 days.


### Example

```java
package main;

import com.fingerprint.api.FingerprintApi;
import com.fingerprint.model.EventsGetResponse;
import com.fingerprint.model.EventsUpdateRequest;
import com.fingerprint.model.VisitorsGetResponse;
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
        String requestId = "requestId_example"; // String | The unique event [identifier](https://dev.fingerprint.com/reference/get-function#requestid).
        EventsUpdateRequest eventsUpdateRequest = new EventsUpdateRequest(); // EventsUpdateRequest | 
        try {
            apiInstance.updateEvent(requestId, eventsUpdateRequest);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.updateEvent:" + e.getMessage());
        }
    }
}
```


### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **requestId** | **String**| The unique event [identifier](https://dev.fingerprint.com/reference/get-function#requestid). | |
| **eventsUpdateRequest** | [**EventsUpdateRequest**](EventsUpdateRequest.md)|  | |

### Return type

null (empty response body)

### Authorization

[ApiKeyHeader](../README.md#ApiKeyHeader), [ApiKeyQuery](../README.md#ApiKeyQuery)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK. |  -  |
| **400** | Bad request. The request payload is not valid. |  -  |
| **403** | Forbidden. Access to this API is denied. |  -  |
| **404** | Not found. The request ID cannot be found in this application&#39;s data. |  -  |
| **409** | Conflict. The event is not mutable yet. |  -  |


## webhookTrace

> webhookTrace(webhook)



Fake path to describe webhook format. More information about webhooks can be found in the [documentation](https://dev.fingerprint.com/docs/webhooks)

### Example

```java
package main;

import com.fingerprint.api.FingerprintApi;
import com.fingerprint.model.EventsGetResponse;
import com.fingerprint.model.EventsUpdateRequest;
import com.fingerprint.model.VisitorsGetResponse;
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
        Webhook webhook = new Webhook(); // Webhook | 
        try {
            apiInstance.webhookTrace(webhook);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.webhookTrace:" + e.getMessage());
        }
    }
}
```


### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **webhook** | [**Webhook**](Webhook.md)|  | [optional] |

### Return type

null (empty response body)

### Authorization

[ApiKeyHeader](../README.md#ApiKeyHeader), [ApiKeyQuery](../README.md#ApiKeyQuery)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **0** | Dummy for the schema |  -  |

