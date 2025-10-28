# FingerprintApi

All URIs are relative to *https://api.fpjs.io/v4*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteVisitorData**](FingerprintApi.md#deleteVisitorData) | **DELETE** /visitors/{visitor_id} | Delete data by visitor ID |
| [**getEvent**](FingerprintApi.md#getEvent) | **GET** /events/{event_id} | Get an event by event ID |
| [**searchEvents**](FingerprintApi.md#searchEvents) | **GET** /events | Search events |
| [**updateEvent**](FingerprintApi.md#updateEvent) | **PATCH** /events/{event_id} | Update an event |



## deleteVisitorData

> deleteVisitorData(visitorId)

Delete data by visitor ID

Request deleting all data associated with the specified visitor ID. This API is useful for compliance with privacy regulations.

### Which data is deleted?
- Browser (or device) properties
- Identification requests made from this browser (or device)

#### Browser (or device) properties
- Represents the data that Fingerprint collected from this specific browser (or device) and everything inferred and derived from it.
- Upon request to delete, this data is deleted asynchronously (typically within a few minutes) and it will no longer be used to identify this browser (or device) for your [Fingerprint Workspace](https://dev.fingerprint.com/docs/glossary#fingerprint-workspace).

#### Identification requests made from this browser (or device)
- Fingerprint stores the identification requests made from a browser (or device) for up to 30 (or 90) days depending on your plan. To learn more, see [Data Retention](https://dev.fingerprint.com/docs/regions#data-retention).
- Upon request to delete, the identification requests that were made by this browser
  - Within the past 10 days are deleted within 24 hrs.
  - Outside of 10 days are allowed to purge as per your data retention period.

### Corollary
After requesting to delete a visitor ID,
- If the same browser (or device) requests to identify, it will receive a different visitor ID.
- If you request [`/v4/events` API](https://dev.fingerprint.com/reference/getevent) with an `event_id` that was made outside of the 10 days, you will still receive a valid response.

### Interested?
Please [contact our support team](https://fingerprint.com/support/) to enable it for you. Otherwise, you will receive a 403.


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
        defaultClient.setBasePath("https://api.fpjs.io/v4");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        FingerprintApi apiInstance = new FingerprintApi(defaultClient);
        String visitorId = "visitorId_example"; // String | The [visitor ID](https://dev.fingerprint.com/reference/get-function#visitorid) you want to delete.
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
| **visitorId** | **String**| The [visitor ID](https://dev.fingerprint.com/reference/get-function#visitorid) you want to delete. | |

### Return type

null (empty response body)

### Authorization

[bearerAuth](../README.md#bearerAuth)

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

> Event getEvent(eventId)

Get an event by event ID

Get a detailed analysis of an individual identification event, including Smart Signals.

Use `event_id` as the URL path parameter. This API method is scoped to a request, i.e. all returned information is by `event_id`.


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
        defaultClient.setBasePath("https://api.fpjs.io/v4");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        FingerprintApi apiInstance = new FingerprintApi(defaultClient);
        String eventId = "eventId_example"; // String | The unique [identifier](https://dev.fingerprint.com/reference/get-function#requestid) of each identification request (`requestId` can be used in its place).
        try {
            Event result = apiInstance.getEvent(eventId);
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
| **eventId** | **String**| The unique [identifier](https://dev.fingerprint.com/reference/get-function#requestid) of each identification request (&#x60;requestId&#x60; can be used in its place). | |

### Return type

[**Event**](Event.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK. |  -  |
| **400** | Bad request. The event Id provided is not valid. |  -  |
| **403** | Forbidden. Access to this API is denied. |  -  |
| **404** | Not found. The event Id cannot be found in this application&#39;s data. |  -  |
| **500** | Application error. |  -  |


## searchEvents

> EventSearch searchEvents(limit, paginationKey, visitorId, bot, ipAddress, linkedId, url, origin, start, end, reverse, suspect, vpn, virtualMachine, tampering, antiDetectBrowser, incognito, privacySettings, jailbroken, frida, factoryReset, clonedApp, emulator, rootApps, vpnConfidence, minSuspectScore, developerTools, locationSpoofing, mitmAttack, proxy, sdkVersion, sdkPlatform, environment, totalHits)

Search events

## Search

The `/v4/events` endpoint provides a convenient way to search for past events based on specific parameters. Typical use cases and queries include:

- Searching for events associated with a single `visitor_id` within a time range to get historical behavior of a visitor.
- Searching for events associated with a single `linked_id` within a time range to get all events associated with your internal account identifier.
- Excluding all bot traffic from the query (`good` and `bad` bots)

If you don't provide `start` or `end` parameters, the default search range is the **last 7 days**.

### Filtering events with the`suspect` flag

The `/v4/events` endpoint unlocks a powerful method for fraud protection analytics. The `suspect` flag is exposed in all events where it was previously set by the update API.

You can also apply the `suspect` query parameter as a filter to find all potentially fraudulent activity that you previously marked as `suspect`. This helps identify patterns of fraudulent behavior.

### Environment scoping

If you use a secret key that is scoped to an environment, you will only get events associated with the same environment. With a workspace-scoped environment, you will get events from all environments.

Smart Signals not activated for your workspace or are not included in the response.


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
        defaultClient.setBasePath("https://api.fpjs.io/v4");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        FingerprintApi apiInstance = new FingerprintApi(defaultClient);
        Integer limit = 10; // Integer | Limit the number of events returned. 
        String paginationKey = "paginationKey_example"; // String | Use `pagination_key` to get the next page of results.  When more results are available (e.g., you requested up to 100 results for your query using `limit`, but there are more than 100 events total matching your request), the `pagination_key` field is added to the response. The key corresponds to the `timestamp` of the last returned event. In the following request, use that value in the `pagination_key` parameter to get the next page of results:  1. First request, returning most recent 200 events: `GET api-base-url/events?limit=100` 2. Use `response.pagination_key` to get the next page of results: `GET api-base-url/events?limit=100&pagination_key=1740815825085` 
        String visitorId = "visitorId_example"; // String | Unique [visitor identifier](https://dev.fingerprint.com/reference/get-function#visitorid) issued by Fingerprint Identification and all active Smart Signals. Filter for events matching this `visitor_id`. 
        String bot = "all"; // String | Filter events by the Bot Detection result, specifically:   `all` - events where any kind of bot was detected.   `good` - events where a good bot was detected.   `bad` - events where a bad bot was detected.   `none` - events where no bot was detected. > Note: When using this parameter, only events with the `botd.bot` property set to a valid value are returned. Events without a `botd` Smart Signal result are left out of the response. 
        String ipAddress = "ipAddress_example"; // String | Filter events by IP address or IP range (if CIDR notation is used). If CIDR notation is not used, a /32 for IPv4 or /128 for IPv6 is assumed. Examples of range based queries: 10.0.0.0/24, 192.168.0.1/32 
        String linkedId = "linkedId_example"; // String | Filter events by your custom identifier.  You can use [linked Ids](https://dev.fingerprint.com/reference/get-function#linkedid) to associate identification requests with your own identifier, for example, session Id, purchase Id, or transaction Id. You can then use this `linked_id` parameter to retrieve all events associated with your custom identifier. 
        String url = "url_example"; // String | Filter events by the URL (`url` property) associated with the event. 
        String origin = "origin_example"; // String | Filter events by the origin field of the event. Origin could be the website domain or mobile app bundle ID (eg: com.foo.bar) 
        Long start = 56L; // Long | Filter events with a timestamp greater than the start time, in Unix time (milliseconds). 
        Long end = 56L; // Long | Filter events with a timestamp smaller than the end time, in Unix time (milliseconds). 
        Boolean reverse = true; // Boolean | Sort events in reverse timestamp order. 
        Boolean suspect = true; // Boolean | Filter events previously tagged as suspicious via the [Update API](https://dev.fingerprint.com/reference/updateevent). > Note: When using this parameter, only events with the `suspect` property explicitly set to `true` or `false` are returned. Events with undefined `suspect` property are left out of the response. 
        Boolean vpn = true; // Boolean | Filter events by VPN Detection result. > Note: When using this parameter, only events with the `vpn` property set to `true` or `false` are returned. Events without a `vpn` Smart Signal result are left out of the response. 
        Boolean virtualMachine = true; // Boolean | Filter events by Virtual Machine Detection result. > Note: When using this parameter, only events with the `virtual_machine` property set to `true` or `false` are returned. Events without a `virtual_machine` Smart Signal result are left out of the response. 
        Boolean tampering = true; // Boolean | Filter events by Browser Tampering Detection result. > Note: When using this parameter, only events with the `tampering.result` property set to `true` or `false` are returned. Events without a `tampering` Smart Signal result are left out of the response. 
        Boolean antiDetectBrowser = true; // Boolean | Filter events by Anti-detect Browser Detection result. > Note: When using this parameter, only events with the `tampering.anti_detect_browser` property set to `true` or `false` are returned. Events without a `tampering` Smart Signal result are left out of the response. 
        Boolean incognito = true; // Boolean | Filter events by Browser Incognito Detection result. > Note: When using this parameter, only events with the `incognito` property set to `true` or `false` are returned. Events without an `incognito` Smart Signal result are left out of the response. 
        Boolean privacySettings = true; // Boolean | Filter events by Privacy Settings Detection result. > Note: When using this parameter, only events with the `privacy_settings` property set to `true` or `false` are returned. Events without a `privacy_settings` Smart Signal result are left out of the response. 
        Boolean jailbroken = true; // Boolean | Filter events by Jailbroken Device Detection result. > Note: When using this parameter, only events with the `jailbroken` property set to `true` or `false` are returned. Events without a `jailbroken` Smart Signal result are left out of the response. 
        Boolean frida = true; // Boolean | Filter events by Frida Detection result. > Note: When using this parameter, only events with the `frida` property set to `true` or `false` are returned. Events without a `frida` Smart Signal result are left out of the response. 
        Boolean factoryReset = true; // Boolean | Filter events by Factory Reset Detection result. > Note: When using this parameter, only events with a `factory_reset` time. Events without a `factory_reset` Smart Signal result are left out of the response. 
        Boolean clonedApp = true; // Boolean | Filter events by Cloned App Detection result. > Note: When using this parameter, only events with the `cloned_app` property set to `true` or `false` are returned. Events without a `cloned_app` Smart Signal result are left out of the response. 
        Boolean emulator = true; // Boolean | Filter events by Android Emulator Detection result. > Note: When using this parameter, only events with the `emulator` property set to `true` or `false` are returned. Events without an `emulator` Smart Signal result are left out of the response. 
        Boolean rootApps = true; // Boolean | Filter events by Rooted Device Detection result. > Note: When using this parameter, only events with the `root_apps` property set to `true` or `false` are returned. Events without a `root_apps` Smart Signal result are left out of the response. 
        String vpnConfidence = "high,"; // String | Filter events by VPN Detection result confidence level. `high` - events with high VPN Detection confidence. `medium` - events with medium VPN Detection confidence. `low` - events with low VPN Detection confidence. > Note: When using this parameter, only events with the `vpn.confidence` property set to a valid value are returned. Events without a `vpn` Smart Signal result are left out of the response. 
        Float minSuspectScore = 3.4F; // Float | Filter events with Suspect Score result above a provided minimum threshold. > Note: When using this parameter, only events where the `suspect_score` property set to a value exceeding your threshold are returned. Events without a `suspect_score` Smart Signal result are left out of the response. 
        Boolean developerTools = true; // Boolean | Filter events by Developer Tools detection result. > Note: When using this parameter, only events with the `developer_tools` property set to `true` or `false` are returned. Events without a `developer_tools` Smart Signal result are left out of the response. 
        Boolean locationSpoofing = true; // Boolean | Filter events by Location Spoofing detection result. > Note: When using this parameter, only events with the `location_spoofing` property set to `true` or `false` are returned. Events without a `location_spoofing` Smart Signal result are left out of the response. 
        Boolean mitmAttack = true; // Boolean | Filter events by MITM (Man-in-the-Middle) Attack detection result. > Note: When using this parameter, only events with the `mitm_attack` property set to `true` or `false` are returned. Events without a `mitm_attack` Smart Signal result are left out of the response. 
        Boolean proxy = true; // Boolean | Filter events by Proxy detection result. > Note: When using this parameter, only events with the `proxy` property set to `true` or `false` are returned. Events without a `proxy` Smart Signal result are left out of the response. 
        String sdkVersion = "sdkVersion_example"; // String | Filter events by a specific SDK version associated with the identification event (`sdk.version` property). Example: `3.11.14` 
        String sdkPlatform = "js"; // String | Filter events by the SDK Platform associated with the identification event (`sdk.platform` property) . `js` - Javascript agent (Web). `ios` - Apple iOS based devices. `android` - Android based devices. 
        List<String> environment = Arrays.asList(); // List<String> | Filter for events by providing one or more environment IDs (`environment_id` property). 
        Long totalHits = 56L; // Long | When set, the response will include a `total_hits` property with a count of total query matches across all pages, up to the specified limit. 
        try {
            EventSearch result = apiInstance.searchEvents(limit, paginationKey, visitorId, bot, ipAddress, linkedId, url, origin, start, end, reverse, suspect, vpn, virtualMachine, tampering, antiDetectBrowser, incognito, privacySettings, jailbroken, frida, factoryReset, clonedApp, emulator, rootApps, vpnConfidence, minSuspectScore, developerTools, locationSpoofing, mitmAttack, proxy, sdkVersion, sdkPlatform, environment, totalHits);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi#searchEvents");
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
| **limit** | **Integer**| Limit the number of events returned.  | [optional] [default to 10] |
| **paginationKey** | **String**| Use &#x60;pagination_key&#x60; to get the next page of results.  When more results are available (e.g., you requested up to 100 results for your query using &#x60;limit&#x60;, but there are more than 100 events total matching your request), the &#x60;pagination_key&#x60; field is added to the response. The key corresponds to the &#x60;timestamp&#x60; of the last returned event. In the following request, use that value in the &#x60;pagination_key&#x60; parameter to get the next page of results:  1. First request, returning most recent 200 events: &#x60;GET api-base-url/events?limit&#x3D;100&#x60; 2. Use &#x60;response.pagination_key&#x60; to get the next page of results: &#x60;GET api-base-url/events?limit&#x3D;100&amp;pagination_key&#x3D;1740815825085&#x60;  | [optional] |
| **visitorId** | **String**| Unique [visitor identifier](https://dev.fingerprint.com/reference/get-function#visitorid) issued by Fingerprint Identification and all active Smart Signals. Filter for events matching this &#x60;visitor_id&#x60;.  | [optional] |
| **bot** | **String**| Filter events by the Bot Detection result, specifically:   &#x60;all&#x60; - events where any kind of bot was detected.   &#x60;good&#x60; - events where a good bot was detected.   &#x60;bad&#x60; - events where a bad bot was detected.   &#x60;none&#x60; - events where no bot was detected. &gt; Note: When using this parameter, only events with the &#x60;botd.bot&#x60; property set to a valid value are returned. Events without a &#x60;botd&#x60; Smart Signal result are left out of the response.  | [optional] [enum: all, good, bad, none] |
| **ipAddress** | **String**| Filter events by IP address or IP range (if CIDR notation is used). If CIDR notation is not used, a /32 for IPv4 or /128 for IPv6 is assumed. Examples of range based queries: 10.0.0.0/24, 192.168.0.1/32  | [optional] |
| **linkedId** | **String**| Filter events by your custom identifier.  You can use [linked Ids](https://dev.fingerprint.com/reference/get-function#linkedid) to associate identification requests with your own identifier, for example, session Id, purchase Id, or transaction Id. You can then use this &#x60;linked_id&#x60; parameter to retrieve all events associated with your custom identifier.  | [optional] |
| **url** | **String**| Filter events by the URL (&#x60;url&#x60; property) associated with the event.  | [optional] |
| **origin** | **String**| Filter events by the origin field of the event. Origin could be the website domain or mobile app bundle ID (eg: com.foo.bar)  | [optional] |
| **start** | **Long**| Filter events with a timestamp greater than the start time, in Unix time (milliseconds).  | [optional] |
| **end** | **Long**| Filter events with a timestamp smaller than the end time, in Unix time (milliseconds).  | [optional] |
| **reverse** | **Boolean**| Sort events in reverse timestamp order.  | [optional] |
| **suspect** | **Boolean**| Filter events previously tagged as suspicious via the [Update API](https://dev.fingerprint.com/reference/updateevent). &gt; Note: When using this parameter, only events with the &#x60;suspect&#x60; property explicitly set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events with undefined &#x60;suspect&#x60; property are left out of the response.  | [optional] |
| **vpn** | **Boolean**| Filter events by VPN Detection result. &gt; Note: When using this parameter, only events with the &#x60;vpn&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;vpn&#x60; Smart Signal result are left out of the response.  | [optional] |
| **virtualMachine** | **Boolean**| Filter events by Virtual Machine Detection result. &gt; Note: When using this parameter, only events with the &#x60;virtual_machine&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;virtual_machine&#x60; Smart Signal result are left out of the response.  | [optional] |
| **tampering** | **Boolean**| Filter events by Browser Tampering Detection result. &gt; Note: When using this parameter, only events with the &#x60;tampering.result&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;tampering&#x60; Smart Signal result are left out of the response.  | [optional] |
| **antiDetectBrowser** | **Boolean**| Filter events by Anti-detect Browser Detection result. &gt; Note: When using this parameter, only events with the &#x60;tampering.anti_detect_browser&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;tampering&#x60; Smart Signal result are left out of the response.  | [optional] |
| **incognito** | **Boolean**| Filter events by Browser Incognito Detection result. &gt; Note: When using this parameter, only events with the &#x60;incognito&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without an &#x60;incognito&#x60; Smart Signal result are left out of the response.  | [optional] |
| **privacySettings** | **Boolean**| Filter events by Privacy Settings Detection result. &gt; Note: When using this parameter, only events with the &#x60;privacy_settings&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;privacy_settings&#x60; Smart Signal result are left out of the response.  | [optional] |
| **jailbroken** | **Boolean**| Filter events by Jailbroken Device Detection result. &gt; Note: When using this parameter, only events with the &#x60;jailbroken&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;jailbroken&#x60; Smart Signal result are left out of the response.  | [optional] |
| **frida** | **Boolean**| Filter events by Frida Detection result. &gt; Note: When using this parameter, only events with the &#x60;frida&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;frida&#x60; Smart Signal result are left out of the response.  | [optional] |
| **factoryReset** | **Boolean**| Filter events by Factory Reset Detection result. &gt; Note: When using this parameter, only events with a &#x60;factory_reset&#x60; time. Events without a &#x60;factory_reset&#x60; Smart Signal result are left out of the response.  | [optional] |
| **clonedApp** | **Boolean**| Filter events by Cloned App Detection result. &gt; Note: When using this parameter, only events with the &#x60;cloned_app&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;cloned_app&#x60; Smart Signal result are left out of the response.  | [optional] |
| **emulator** | **Boolean**| Filter events by Android Emulator Detection result. &gt; Note: When using this parameter, only events with the &#x60;emulator&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without an &#x60;emulator&#x60; Smart Signal result are left out of the response.  | [optional] |
| **rootApps** | **Boolean**| Filter events by Rooted Device Detection result. &gt; Note: When using this parameter, only events with the &#x60;root_apps&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;root_apps&#x60; Smart Signal result are left out of the response.  | [optional] |
| **vpnConfidence** | **String**| Filter events by VPN Detection result confidence level. &#x60;high&#x60; - events with high VPN Detection confidence. &#x60;medium&#x60; - events with medium VPN Detection confidence. &#x60;low&#x60; - events with low VPN Detection confidence. &gt; Note: When using this parameter, only events with the &#x60;vpn.confidence&#x60; property set to a valid value are returned. Events without a &#x60;vpn&#x60; Smart Signal result are left out of the response.  | [optional] [enum: high,, medium, low] |
| **minSuspectScore** | **Float**| Filter events with Suspect Score result above a provided minimum threshold. &gt; Note: When using this parameter, only events where the &#x60;suspect_score&#x60; property set to a value exceeding your threshold are returned. Events without a &#x60;suspect_score&#x60; Smart Signal result are left out of the response.  | [optional] |
| **developerTools** | **Boolean**| Filter events by Developer Tools detection result. &gt; Note: When using this parameter, only events with the &#x60;developer_tools&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;developer_tools&#x60; Smart Signal result are left out of the response.  | [optional] |
| **locationSpoofing** | **Boolean**| Filter events by Location Spoofing detection result. &gt; Note: When using this parameter, only events with the &#x60;location_spoofing&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;location_spoofing&#x60; Smart Signal result are left out of the response.  | [optional] |
| **mitmAttack** | **Boolean**| Filter events by MITM (Man-in-the-Middle) Attack detection result. &gt; Note: When using this parameter, only events with the &#x60;mitm_attack&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;mitm_attack&#x60; Smart Signal result are left out of the response.  | [optional] |
| **proxy** | **Boolean**| Filter events by Proxy detection result. &gt; Note: When using this parameter, only events with the &#x60;proxy&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;proxy&#x60; Smart Signal result are left out of the response.  | [optional] |
| **sdkVersion** | **String**| Filter events by a specific SDK version associated with the identification event (&#x60;sdk.version&#x60; property). Example: &#x60;3.11.14&#x60;  | [optional] |
| **sdkPlatform** | **String**| Filter events by the SDK Platform associated with the identification event (&#x60;sdk.platform&#x60; property) . &#x60;js&#x60; - Javascript agent (Web). &#x60;ios&#x60; - Apple iOS based devices. &#x60;android&#x60; - Android based devices.  | [optional] [enum: js, android, ios] |
| **environment** | **List&lt;String&gt;**| Filter for events by providing one or more environment IDs (&#x60;environment_id&#x60; property).  | [optional] |
| **totalHits** | **Long**| When set, the response will include a &#x60;total_hits&#x60; property with a count of total query matches across all pages, up to the specified limit.  | [optional] |

### Return type

[**EventSearch**](EventSearch.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Events matching the filter(s). |  -  |
| **400** | Bad request. One or more supplied search parameters are invalid, or a required parameter is missing. |  -  |
| **403** | Forbidden. Access to this API is denied. |  -  |
| **500** | Application error. |  -  |


## updateEvent

> updateEvent(eventId, eventUpdate)

Update an event

Change information in existing events specified by `event_id` or *flag suspicious events*.

When an event is created, it can be assigned `linked_id` and `tags` submitted through the JS agent parameters. 
This information might not have been available on the client initially, so the Server API permits updating these attributes after the fact.

**Warning** It's not possible to update events older than one month. 

**Warning** Trying to update an event immediately after creation may temporarily result in an 
error (HTTP 409 Conflict. The event is not mutable yet.) as the event is fully propagated across our systems. In such a case, simply retry the request.


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
        defaultClient.setBasePath("https://api.fpjs.io/v4");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        FingerprintApi apiInstance = new FingerprintApi(defaultClient);
        String eventId = "eventId_example"; // String | The unique event [identifier](https://dev.fingerprint.com/reference/get-function#event_id).
        EventUpdate eventUpdate = new EventUpdate(); // EventUpdate | 
        try {
            apiInstance.updateEvent(eventId, eventUpdate);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi#updateEvent");
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
| **eventId** | **String**| The unique event [identifier](https://dev.fingerprint.com/reference/get-function#event_id). | |
| **eventUpdate** | [**EventUpdate**](EventUpdate.md)|  | |

### Return type

null (empty response body)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK. |  -  |
| **400** | Bad request. The request payload is not valid. |  -  |
| **403** | Forbidden. Access to this API is denied. |  -  |
| **404** | Not found. The event Id cannot be found in this application&#39;s data. |  -  |
| **409** | Conflict. The event is not mutable yet. |  -  |

