package com.fingerprint.api;

import com.fingerprint.sdk.ApiException;
import com.fingerprint.sdk.ApiClient;
import com.fingerprint.sdk.ApiResponse;
import com.fingerprint.sdk.Configuration;
import com.fingerprint.sdk.Pair;

import jakarta.ws.rs.core.GenericType;

import com.fingerprint.model.ErrorResponse;
import com.fingerprint.model.Event;
import com.fingerprint.model.EventSearch;
import com.fingerprint.model.EventUpdate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.16.0")
public class FingerprintApi {
  private ApiClient apiClient;

  public FingerprintApi() {
    this(Configuration.getDefaultApiClient());
  }

  public FingerprintApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Get the API client
   *
   * @return API client
   */
  public ApiClient getApiClient() {
    return apiClient;
  }

  /**
   * Set the API client
   *
   * @param apiClient an instance of API client
   */
  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Delete data by visitor ID
   * Request deleting all data associated with the specified visitor ID. This API is useful for compliance with privacy regulations.  ### Which data is deleted? - Browser (or device) properties - Identification requests made from this browser (or device)  #### Browser (or device) properties - Represents the data that Fingerprint collected from this specific browser (or device) and everything inferred and derived from it. - Upon request to delete, this data is deleted asynchronously (typically within a few minutes) and it will no longer be used to identify this browser (or device) for your [Fingerprint Workspace](https://dev.fingerprint.com/docs/glossary#fingerprint-workspace).  #### Identification requests made from this browser (or device) - Fingerprint stores the identification requests made from a browser (or device) for up to 30 (or 90) days depending on your plan. To learn more, see [Data Retention](https://dev.fingerprint.com/docs/regions#data-retention). - Upon request to delete, the identification requests that were made by this browser   - Within the past 10 days are deleted within 24 hrs.   - Outside of 10 days are allowed to purge as per your data retention period.  ### Corollary After requesting to delete a visitor ID, - If the same browser (or device) requests to identify, it will receive a different visitor ID. - If you request [&#x60;/v4/events&#x60; API](https://dev.fingerprint.com/reference/getevent) with an &#x60;event_id&#x60; that was made outside of the 10 days, you will still receive a valid response.  ### Interested? Please [contact our support team](https://fingerprint.com/support/) to enable it for you. Otherwise, you will receive a 403. 
   * @param visitorId The [visitor ID](https://dev.fingerprint.com/reference/get-function#visitorid) you want to delete. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK. The visitor ID is scheduled for deletion. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. The visitor ID parameter is missing or in the wrong format. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found. The visitor ID cannot be found in this application&#39;s data. </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too Many Requests. The request is throttled. </td><td>  -  </td></tr>
     </table>
   */
  public void deleteVisitorData(@jakarta.annotation.Nonnull String visitorId) throws ApiException {
    deleteVisitorDataWithHttpInfo(visitorId);
  }

  /**
   * Delete data by visitor ID
   * Request deleting all data associated with the specified visitor ID. This API is useful for compliance with privacy regulations.  ### Which data is deleted? - Browser (or device) properties - Identification requests made from this browser (or device)  #### Browser (or device) properties - Represents the data that Fingerprint collected from this specific browser (or device) and everything inferred and derived from it. - Upon request to delete, this data is deleted asynchronously (typically within a few minutes) and it will no longer be used to identify this browser (or device) for your [Fingerprint Workspace](https://dev.fingerprint.com/docs/glossary#fingerprint-workspace).  #### Identification requests made from this browser (or device) - Fingerprint stores the identification requests made from a browser (or device) for up to 30 (or 90) days depending on your plan. To learn more, see [Data Retention](https://dev.fingerprint.com/docs/regions#data-retention). - Upon request to delete, the identification requests that were made by this browser   - Within the past 10 days are deleted within 24 hrs.   - Outside of 10 days are allowed to purge as per your data retention period.  ### Corollary After requesting to delete a visitor ID, - If the same browser (or device) requests to identify, it will receive a different visitor ID. - If you request [&#x60;/v4/events&#x60; API](https://dev.fingerprint.com/reference/getevent) with an &#x60;event_id&#x60; that was made outside of the 10 days, you will still receive a valid response.  ### Interested? Please [contact our support team](https://fingerprint.com/support/) to enable it for you. Otherwise, you will receive a 403. 
   * @param visitorId The [visitor ID](https://dev.fingerprint.com/reference/get-function#visitorid) you want to delete. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK. The visitor ID is scheduled for deletion. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. The visitor ID parameter is missing or in the wrong format. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found. The visitor ID cannot be found in this application&#39;s data. </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too Many Requests. The request is throttled. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteVisitorDataWithHttpInfo(@jakarta.annotation.Nonnull String visitorId) throws ApiException {
    // Check required parameters
    if (visitorId == null) {
      throw new ApiException(400, "Missing the required parameter 'visitorId' when calling deleteVisitorData");
    }

    // Path parameters
    String localVarPath = "/visitors/{visitor_id}"
            .replaceAll("\\{visitor_id}", apiClient.escapeString(visitorId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    return apiClient.invokeAPI("FingerprintApi.deleteVisitorData", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get an event by event ID
   * Get a detailed analysis of an individual identification event, including Smart Signals.  Use &#x60;event_id&#x60; as the URL path parameter. This API method is scoped to a request, i.e. all returned information is by &#x60;event_id&#x60;. 
   * @param eventId The unique [identifier](https://dev.fingerprint.com/reference/get-function#requestid) of each identification request (&#x60;requestId&#x60; can be used in its place). (required)
   * @return Event
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. The event Id provided is not valid. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found. The event Id cannot be found in this application&#39;s data. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Application error. </td><td>  -  </td></tr>
     </table>
   */
  public Event getEvent(@jakarta.annotation.Nonnull String eventId) throws ApiException {
    return getEventWithHttpInfo(eventId).getData();
  }

  /**
   * Get an event by event ID
   * Get a detailed analysis of an individual identification event, including Smart Signals.  Use &#x60;event_id&#x60; as the URL path parameter. This API method is scoped to a request, i.e. all returned information is by &#x60;event_id&#x60;. 
   * @param eventId The unique [identifier](https://dev.fingerprint.com/reference/get-function#requestid) of each identification request (&#x60;requestId&#x60; can be used in its place). (required)
   * @return ApiResponse&lt;Event&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. The event Id provided is not valid. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found. The event Id cannot be found in this application&#39;s data. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Application error. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Event> getEventWithHttpInfo(@jakarta.annotation.Nonnull String eventId) throws ApiException {
    // Check required parameters
    if (eventId == null) {
      throw new ApiException(400, "Missing the required parameter 'eventId' when calling getEvent");
    }

    // Path parameters
    String localVarPath = "/events/{event_id}"
            .replaceAll("\\{event_id}", apiClient.escapeString(eventId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<Event> localVarReturnType = new GenericType<Event>() {};
    return apiClient.invokeAPI("FingerprintApi.getEvent", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Search events
   * ## Search  The &#x60;/v4/events&#x60; endpoint provides a convenient way to search for past events based on specific parameters. Typical use cases and queries include:  - Searching for events associated with a single &#x60;visitor_id&#x60; within a time range to get historical behavior of a visitor. - Searching for events associated with a single &#x60;linked_id&#x60; within a time range to get all events associated with your internal account identifier. - Excluding all bot traffic from the query (&#x60;good&#x60; and &#x60;bad&#x60; bots)  If you don&#39;t provide &#x60;start&#x60; or &#x60;end&#x60; parameters, the default search range is the **last 7 days**.  ### Filtering events with the&#x60;suspect&#x60; flag  The &#x60;/v4/events&#x60; endpoint unlocks a powerful method for fraud protection analytics. The &#x60;suspect&#x60; flag is exposed in all events where it was previously set by the update API.  You can also apply the &#x60;suspect&#x60; query parameter as a filter to find all potentially fraudulent activity that you previously marked as &#x60;suspect&#x60;. This helps identify patterns of fraudulent behavior.  ### Environment scoping  If you use a secret key that is scoped to an environment, you will only get events associated with the same environment. With a workspace-scoped environment, you will get events from all environments.  Smart Signals not activated for your workspace or are not included in the response. 
   * @param limit Limit the number of events returned.  (optional, default to 10)
   * @param paginationKey Use &#x60;pagination_key&#x60; to get the next page of results.  When more results are available (e.g., you requested up to 100 results for your query using &#x60;limit&#x60;, but there are more than 100 events total matching your request), the &#x60;pagination_key&#x60; field is added to the response. The key corresponds to the &#x60;timestamp&#x60; of the last returned event. In the following request, use that value in the &#x60;pagination_key&#x60; parameter to get the next page of results:  1. First request, returning most recent 200 events: &#x60;GET api-base-url/events?limit&#x3D;100&#x60; 2. Use &#x60;response.pagination_key&#x60; to get the next page of results: &#x60;GET api-base-url/events?limit&#x3D;100&amp;pagination_key&#x3D;1740815825085&#x60;  (optional)
   * @param visitorId Unique [visitor identifier](https://dev.fingerprint.com/reference/get-function#visitorid) issued by Fingerprint Identification and all active Smart Signals. Filter for events matching this &#x60;visitor_id&#x60;.  (optional)
   * @param bot Filter events by the Bot Detection result, specifically:   &#x60;all&#x60; - events where any kind of bot was detected.   &#x60;good&#x60; - events where a good bot was detected.   &#x60;bad&#x60; - events where a bad bot was detected.   &#x60;none&#x60; - events where no bot was detected. &gt; Note: When using this parameter, only events with the &#x60;botd.bot&#x60; property set to a valid value are returned. Events without a &#x60;botd&#x60; Smart Signal result are left out of the response.  (optional)
   * @param ipAddress Filter events by IP address or IP range (if CIDR notation is used). If CIDR notation is not used, a /32 for IPv4 or /128 for IPv6 is assumed. Examples of range based queries: 10.0.0.0/24, 192.168.0.1/32  (optional)
   * @param linkedId Filter events by your custom identifier.  You can use [linked Ids](https://dev.fingerprint.com/reference/get-function#linkedid) to associate identification requests with your own identifier, for example, session Id, purchase Id, or transaction Id. You can then use this &#x60;linked_id&#x60; parameter to retrieve all events associated with your custom identifier.  (optional)
   * @param url Filter events by the URL (&#x60;url&#x60; property) associated with the event.  (optional)
   * @param origin Filter events by the origin field of the event. Origin could be the website domain or mobile app bundle ID (eg: com.foo.bar)  (optional)
   * @param start Filter events with a timestamp greater than the start time, in Unix time (milliseconds).  (optional)
   * @param end Filter events with a timestamp smaller than the end time, in Unix time (milliseconds).  (optional)
   * @param reverse Sort events in reverse timestamp order.  (optional)
   * @param suspect Filter events previously tagged as suspicious via the [Update API](https://dev.fingerprint.com/reference/updateevent). &gt; Note: When using this parameter, only events with the &#x60;suspect&#x60; property explicitly set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events with undefined &#x60;suspect&#x60; property are left out of the response.  (optional)
   * @param vpn Filter events by VPN Detection result. &gt; Note: When using this parameter, only events with the &#x60;vpn&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;vpn&#x60; Smart Signal result are left out of the response.  (optional)
   * @param virtualMachine Filter events by Virtual Machine Detection result. &gt; Note: When using this parameter, only events with the &#x60;virtual_machine&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;virtual_machine&#x60; Smart Signal result are left out of the response.  (optional)
   * @param tampering Filter events by Browser Tampering Detection result. &gt; Note: When using this parameter, only events with the &#x60;tampering.result&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;tampering&#x60; Smart Signal result are left out of the response.  (optional)
   * @param antiDetectBrowser Filter events by Anti-detect Browser Detection result. &gt; Note: When using this parameter, only events with the &#x60;tampering.anti_detect_browser&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;tampering&#x60; Smart Signal result are left out of the response.  (optional)
   * @param incognito Filter events by Browser Incognito Detection result. &gt; Note: When using this parameter, only events with the &#x60;incognito&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without an &#x60;incognito&#x60; Smart Signal result are left out of the response.  (optional)
   * @param privacySettings Filter events by Privacy Settings Detection result. &gt; Note: When using this parameter, only events with the &#x60;privacy_settings&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;privacy_settings&#x60; Smart Signal result are left out of the response.  (optional)
   * @param jailbroken Filter events by Jailbroken Device Detection result. &gt; Note: When using this parameter, only events with the &#x60;jailbroken&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;jailbroken&#x60; Smart Signal result are left out of the response.  (optional)
   * @param frida Filter events by Frida Detection result. &gt; Note: When using this parameter, only events with the &#x60;frida&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;frida&#x60; Smart Signal result are left out of the response.  (optional)
   * @param factoryReset Filter events by Factory Reset Detection result. &gt; Note: When using this parameter, only events with a &#x60;factory_reset&#x60; time. Events without a &#x60;factory_reset&#x60; Smart Signal result are left out of the response.  (optional)
   * @param clonedApp Filter events by Cloned App Detection result. &gt; Note: When using this parameter, only events with the &#x60;cloned_app&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;cloned_app&#x60; Smart Signal result are left out of the response.  (optional)
   * @param emulator Filter events by Android Emulator Detection result. &gt; Note: When using this parameter, only events with the &#x60;emulator&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without an &#x60;emulator&#x60; Smart Signal result are left out of the response.  (optional)
   * @param rootApps Filter events by Rooted Device Detection result. &gt; Note: When using this parameter, only events with the &#x60;root_apps&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;root_apps&#x60; Smart Signal result are left out of the response.  (optional)
   * @param vpnConfidence Filter events by VPN Detection result confidence level. &#x60;high&#x60; - events with high VPN Detection confidence. &#x60;medium&#x60; - events with medium VPN Detection confidence. &#x60;low&#x60; - events with low VPN Detection confidence. &gt; Note: When using this parameter, only events with the &#x60;vpn.confidence&#x60; property set to a valid value are returned. Events without a &#x60;vpn&#x60; Smart Signal result are left out of the response.  (optional)
   * @param minSuspectScore Filter events with Suspect Score result above a provided minimum threshold. &gt; Note: When using this parameter, only events where the &#x60;suspect_score&#x60; property set to a value exceeding your threshold are returned. Events without a &#x60;suspect_score&#x60; Smart Signal result are left out of the response.  (optional)
   * @param developerTools Filter events by Developer Tools detection result. &gt; Note: When using this parameter, only events with the &#x60;developer_tools&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;developer_tools&#x60; Smart Signal result are left out of the response.  (optional)
   * @param locationSpoofing Filter events by Location Spoofing detection result. &gt; Note: When using this parameter, only events with the &#x60;location_spoofing&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;location_spoofing&#x60; Smart Signal result are left out of the response.  (optional)
   * @param mitmAttack Filter events by MITM (Man-in-the-Middle) Attack detection result. &gt; Note: When using this parameter, only events with the &#x60;mitm_attack&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;mitm_attack&#x60; Smart Signal result are left out of the response.  (optional)
   * @param proxy Filter events by Proxy detection result. &gt; Note: When using this parameter, only events with the &#x60;proxy&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;proxy&#x60; Smart Signal result are left out of the response.  (optional)
   * @param sdkVersion Filter events by a specific SDK version associated with the identification event (&#x60;sdk.version&#x60; property). Example: &#x60;3.11.14&#x60;  (optional)
   * @param sdkPlatform Filter events by the SDK Platform associated with the identification event (&#x60;sdk.platform&#x60; property) . &#x60;js&#x60; - Javascript agent (Web). &#x60;ios&#x60; - Apple iOS based devices. &#x60;android&#x60; - Android based devices.  (optional)
   * @param environment Filter for events by providing one or more environment IDs (&#x60;environment_id&#x60; property).  (optional)
   * @param totalHits When set, the response will include a &#x60;total_hits&#x60; property with a count of total query matches across all pages, up to the specified limit.  (optional)
   * @return EventSearch
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Events matching the filter(s). </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. One or more supplied search parameters are invalid, or a required parameter is missing. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Application error. </td><td>  -  </td></tr>
     </table>
   */
  public EventSearch searchEvents(@jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable String paginationKey, @jakarta.annotation.Nullable String visitorId, @jakarta.annotation.Nullable String bot, @jakarta.annotation.Nullable String ipAddress, @jakarta.annotation.Nullable String linkedId, @jakarta.annotation.Nullable String url, @jakarta.annotation.Nullable String origin, @jakarta.annotation.Nullable Long start, @jakarta.annotation.Nullable Long end, @jakarta.annotation.Nullable Boolean reverse, @jakarta.annotation.Nullable Boolean suspect, @jakarta.annotation.Nullable Boolean vpn, @jakarta.annotation.Nullable Boolean virtualMachine, @jakarta.annotation.Nullable Boolean tampering, @jakarta.annotation.Nullable Boolean antiDetectBrowser, @jakarta.annotation.Nullable Boolean incognito, @jakarta.annotation.Nullable Boolean privacySettings, @jakarta.annotation.Nullable Boolean jailbroken, @jakarta.annotation.Nullable Boolean frida, @jakarta.annotation.Nullable Boolean factoryReset, @jakarta.annotation.Nullable Boolean clonedApp, @jakarta.annotation.Nullable Boolean emulator, @jakarta.annotation.Nullable Boolean rootApps, @jakarta.annotation.Nullable String vpnConfidence, @jakarta.annotation.Nullable Float minSuspectScore, @jakarta.annotation.Nullable Boolean developerTools, @jakarta.annotation.Nullable Boolean locationSpoofing, @jakarta.annotation.Nullable Boolean mitmAttack, @jakarta.annotation.Nullable Boolean proxy, @jakarta.annotation.Nullable String sdkVersion, @jakarta.annotation.Nullable String sdkPlatform, @jakarta.annotation.Nullable List<String> environment, @jakarta.annotation.Nullable Long totalHits) throws ApiException {
    return searchEventsWithHttpInfo(limit, paginationKey, visitorId, bot, ipAddress, linkedId, url, origin, start, end, reverse, suspect, vpn, virtualMachine, tampering, antiDetectBrowser, incognito, privacySettings, jailbroken, frida, factoryReset, clonedApp, emulator, rootApps, vpnConfidence, minSuspectScore, developerTools, locationSpoofing, mitmAttack, proxy, sdkVersion, sdkPlatform, environment, totalHits).getData();
  }

  /**
   * Search events
   * ## Search  The &#x60;/v4/events&#x60; endpoint provides a convenient way to search for past events based on specific parameters. Typical use cases and queries include:  - Searching for events associated with a single &#x60;visitor_id&#x60; within a time range to get historical behavior of a visitor. - Searching for events associated with a single &#x60;linked_id&#x60; within a time range to get all events associated with your internal account identifier. - Excluding all bot traffic from the query (&#x60;good&#x60; and &#x60;bad&#x60; bots)  If you don&#39;t provide &#x60;start&#x60; or &#x60;end&#x60; parameters, the default search range is the **last 7 days**.  ### Filtering events with the&#x60;suspect&#x60; flag  The &#x60;/v4/events&#x60; endpoint unlocks a powerful method for fraud protection analytics. The &#x60;suspect&#x60; flag is exposed in all events where it was previously set by the update API.  You can also apply the &#x60;suspect&#x60; query parameter as a filter to find all potentially fraudulent activity that you previously marked as &#x60;suspect&#x60;. This helps identify patterns of fraudulent behavior.  ### Environment scoping  If you use a secret key that is scoped to an environment, you will only get events associated with the same environment. With a workspace-scoped environment, you will get events from all environments.  Smart Signals not activated for your workspace or are not included in the response. 
   * @param limit Limit the number of events returned.  (optional, default to 10)
   * @param paginationKey Use &#x60;pagination_key&#x60; to get the next page of results.  When more results are available (e.g., you requested up to 100 results for your query using &#x60;limit&#x60;, but there are more than 100 events total matching your request), the &#x60;pagination_key&#x60; field is added to the response. The key corresponds to the &#x60;timestamp&#x60; of the last returned event. In the following request, use that value in the &#x60;pagination_key&#x60; parameter to get the next page of results:  1. First request, returning most recent 200 events: &#x60;GET api-base-url/events?limit&#x3D;100&#x60; 2. Use &#x60;response.pagination_key&#x60; to get the next page of results: &#x60;GET api-base-url/events?limit&#x3D;100&amp;pagination_key&#x3D;1740815825085&#x60;  (optional)
   * @param visitorId Unique [visitor identifier](https://dev.fingerprint.com/reference/get-function#visitorid) issued by Fingerprint Identification and all active Smart Signals. Filter for events matching this &#x60;visitor_id&#x60;.  (optional)
   * @param bot Filter events by the Bot Detection result, specifically:   &#x60;all&#x60; - events where any kind of bot was detected.   &#x60;good&#x60; - events where a good bot was detected.   &#x60;bad&#x60; - events where a bad bot was detected.   &#x60;none&#x60; - events where no bot was detected. &gt; Note: When using this parameter, only events with the &#x60;botd.bot&#x60; property set to a valid value are returned. Events without a &#x60;botd&#x60; Smart Signal result are left out of the response.  (optional)
   * @param ipAddress Filter events by IP address or IP range (if CIDR notation is used). If CIDR notation is not used, a /32 for IPv4 or /128 for IPv6 is assumed. Examples of range based queries: 10.0.0.0/24, 192.168.0.1/32  (optional)
   * @param linkedId Filter events by your custom identifier.  You can use [linked Ids](https://dev.fingerprint.com/reference/get-function#linkedid) to associate identification requests with your own identifier, for example, session Id, purchase Id, or transaction Id. You can then use this &#x60;linked_id&#x60; parameter to retrieve all events associated with your custom identifier.  (optional)
   * @param url Filter events by the URL (&#x60;url&#x60; property) associated with the event.  (optional)
   * @param origin Filter events by the origin field of the event. Origin could be the website domain or mobile app bundle ID (eg: com.foo.bar)  (optional)
   * @param start Filter events with a timestamp greater than the start time, in Unix time (milliseconds).  (optional)
   * @param end Filter events with a timestamp smaller than the end time, in Unix time (milliseconds).  (optional)
   * @param reverse Sort events in reverse timestamp order.  (optional)
   * @param suspect Filter events previously tagged as suspicious via the [Update API](https://dev.fingerprint.com/reference/updateevent). &gt; Note: When using this parameter, only events with the &#x60;suspect&#x60; property explicitly set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events with undefined &#x60;suspect&#x60; property are left out of the response.  (optional)
   * @param vpn Filter events by VPN Detection result. &gt; Note: When using this parameter, only events with the &#x60;vpn&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;vpn&#x60; Smart Signal result are left out of the response.  (optional)
   * @param virtualMachine Filter events by Virtual Machine Detection result. &gt; Note: When using this parameter, only events with the &#x60;virtual_machine&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;virtual_machine&#x60; Smart Signal result are left out of the response.  (optional)
   * @param tampering Filter events by Browser Tampering Detection result. &gt; Note: When using this parameter, only events with the &#x60;tampering.result&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;tampering&#x60; Smart Signal result are left out of the response.  (optional)
   * @param antiDetectBrowser Filter events by Anti-detect Browser Detection result. &gt; Note: When using this parameter, only events with the &#x60;tampering.anti_detect_browser&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;tampering&#x60; Smart Signal result are left out of the response.  (optional)
   * @param incognito Filter events by Browser Incognito Detection result. &gt; Note: When using this parameter, only events with the &#x60;incognito&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without an &#x60;incognito&#x60; Smart Signal result are left out of the response.  (optional)
   * @param privacySettings Filter events by Privacy Settings Detection result. &gt; Note: When using this parameter, only events with the &#x60;privacy_settings&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;privacy_settings&#x60; Smart Signal result are left out of the response.  (optional)
   * @param jailbroken Filter events by Jailbroken Device Detection result. &gt; Note: When using this parameter, only events with the &#x60;jailbroken&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;jailbroken&#x60; Smart Signal result are left out of the response.  (optional)
   * @param frida Filter events by Frida Detection result. &gt; Note: When using this parameter, only events with the &#x60;frida&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;frida&#x60; Smart Signal result are left out of the response.  (optional)
   * @param factoryReset Filter events by Factory Reset Detection result. &gt; Note: When using this parameter, only events with a &#x60;factory_reset&#x60; time. Events without a &#x60;factory_reset&#x60; Smart Signal result are left out of the response.  (optional)
   * @param clonedApp Filter events by Cloned App Detection result. &gt; Note: When using this parameter, only events with the &#x60;cloned_app&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;cloned_app&#x60; Smart Signal result are left out of the response.  (optional)
   * @param emulator Filter events by Android Emulator Detection result. &gt; Note: When using this parameter, only events with the &#x60;emulator&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without an &#x60;emulator&#x60; Smart Signal result are left out of the response.  (optional)
   * @param rootApps Filter events by Rooted Device Detection result. &gt; Note: When using this parameter, only events with the &#x60;root_apps&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;root_apps&#x60; Smart Signal result are left out of the response.  (optional)
   * @param vpnConfidence Filter events by VPN Detection result confidence level. &#x60;high&#x60; - events with high VPN Detection confidence. &#x60;medium&#x60; - events with medium VPN Detection confidence. &#x60;low&#x60; - events with low VPN Detection confidence. &gt; Note: When using this parameter, only events with the &#x60;vpn.confidence&#x60; property set to a valid value are returned. Events without a &#x60;vpn&#x60; Smart Signal result are left out of the response.  (optional)
   * @param minSuspectScore Filter events with Suspect Score result above a provided minimum threshold. &gt; Note: When using this parameter, only events where the &#x60;suspect_score&#x60; property set to a value exceeding your threshold are returned. Events without a &#x60;suspect_score&#x60; Smart Signal result are left out of the response.  (optional)
   * @param developerTools Filter events by Developer Tools detection result. &gt; Note: When using this parameter, only events with the &#x60;developer_tools&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;developer_tools&#x60; Smart Signal result are left out of the response.  (optional)
   * @param locationSpoofing Filter events by Location Spoofing detection result. &gt; Note: When using this parameter, only events with the &#x60;location_spoofing&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;location_spoofing&#x60; Smart Signal result are left out of the response.  (optional)
   * @param mitmAttack Filter events by MITM (Man-in-the-Middle) Attack detection result. &gt; Note: When using this parameter, only events with the &#x60;mitm_attack&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;mitm_attack&#x60; Smart Signal result are left out of the response.  (optional)
   * @param proxy Filter events by Proxy detection result. &gt; Note: When using this parameter, only events with the &#x60;proxy&#x60; property set to &#x60;true&#x60; or &#x60;false&#x60; are returned. Events without a &#x60;proxy&#x60; Smart Signal result are left out of the response.  (optional)
   * @param sdkVersion Filter events by a specific SDK version associated with the identification event (&#x60;sdk.version&#x60; property). Example: &#x60;3.11.14&#x60;  (optional)
   * @param sdkPlatform Filter events by the SDK Platform associated with the identification event (&#x60;sdk.platform&#x60; property) . &#x60;js&#x60; - Javascript agent (Web). &#x60;ios&#x60; - Apple iOS based devices. &#x60;android&#x60; - Android based devices.  (optional)
   * @param environment Filter for events by providing one or more environment IDs (&#x60;environment_id&#x60; property).  (optional)
   * @param totalHits When set, the response will include a &#x60;total_hits&#x60; property with a count of total query matches across all pages, up to the specified limit.  (optional)
   * @return ApiResponse&lt;EventSearch&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Events matching the filter(s). </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. One or more supplied search parameters are invalid, or a required parameter is missing. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Application error. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<EventSearch> searchEventsWithHttpInfo(@jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable String paginationKey, @jakarta.annotation.Nullable String visitorId, @jakarta.annotation.Nullable String bot, @jakarta.annotation.Nullable String ipAddress, @jakarta.annotation.Nullable String linkedId, @jakarta.annotation.Nullable String url, @jakarta.annotation.Nullable String origin, @jakarta.annotation.Nullable Long start, @jakarta.annotation.Nullable Long end, @jakarta.annotation.Nullable Boolean reverse, @jakarta.annotation.Nullable Boolean suspect, @jakarta.annotation.Nullable Boolean vpn, @jakarta.annotation.Nullable Boolean virtualMachine, @jakarta.annotation.Nullable Boolean tampering, @jakarta.annotation.Nullable Boolean antiDetectBrowser, @jakarta.annotation.Nullable Boolean incognito, @jakarta.annotation.Nullable Boolean privacySettings, @jakarta.annotation.Nullable Boolean jailbroken, @jakarta.annotation.Nullable Boolean frida, @jakarta.annotation.Nullable Boolean factoryReset, @jakarta.annotation.Nullable Boolean clonedApp, @jakarta.annotation.Nullable Boolean emulator, @jakarta.annotation.Nullable Boolean rootApps, @jakarta.annotation.Nullable String vpnConfidence, @jakarta.annotation.Nullable Float minSuspectScore, @jakarta.annotation.Nullable Boolean developerTools, @jakarta.annotation.Nullable Boolean locationSpoofing, @jakarta.annotation.Nullable Boolean mitmAttack, @jakarta.annotation.Nullable Boolean proxy, @jakarta.annotation.Nullable String sdkVersion, @jakarta.annotation.Nullable String sdkPlatform, @jakarta.annotation.Nullable List<String> environment, @jakarta.annotation.Nullable Long totalHits) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "limit", limit)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "pagination_key", paginationKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "visitor_id", visitorId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "bot", bot));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ip_address", ipAddress));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "linked_id", linkedId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "url", url));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "origin", origin));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "start", start));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "end", end));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "reverse", reverse));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "suspect", suspect));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "vpn", vpn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "virtual_machine", virtualMachine));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "tampering", tampering));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "anti_detect_browser", antiDetectBrowser));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incognito", incognito));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "privacy_settings", privacySettings));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "jailbroken", jailbroken));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "frida", frida));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "factory_reset", factoryReset));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "cloned_app", clonedApp));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "emulator", emulator));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "root_apps", rootApps));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "vpn_confidence", vpnConfidence));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "min_suspect_score", minSuspectScore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "developer_tools", developerTools));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "location_spoofing", locationSpoofing));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "mitm_attack", mitmAttack));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "proxy", proxy));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sdk_version", sdkVersion));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sdk_platform", sdkPlatform));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "environment", environment));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "total_hits", totalHits));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<EventSearch> localVarReturnType = new GenericType<EventSearch>() {};
    return apiClient.invokeAPI("FingerprintApi.searchEvents", "/events", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update an event
   * Change information in existing events specified by &#x60;event_id&#x60; or *flag suspicious events*.  When an event is created, it can be assigned &#x60;linked_id&#x60; and &#x60;tags&#x60; submitted through the JS agent parameters.  This information might not have been available on the client initially, so the Server API permits updating these attributes after the fact.  **Warning** It&#39;s not possible to update events older than one month.   **Warning** Trying to update an event immediately after creation may temporarily result in an  error (HTTP 409 Conflict. The event is not mutable yet.) as the event is fully propagated across our systems. In such a case, simply retry the request. 
   * @param eventId The unique event [identifier](https://dev.fingerprint.com/reference/get-function#event_id). (required)
   * @param eventUpdate  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. The request payload is not valid. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found. The event Id cannot be found in this application&#39;s data. </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict. The event is not mutable yet. </td><td>  -  </td></tr>
     </table>
   */
  public void updateEvent(@jakarta.annotation.Nonnull String eventId, @jakarta.annotation.Nonnull EventUpdate eventUpdate) throws ApiException {
    updateEventWithHttpInfo(eventId, eventUpdate);
  }

  /**
   * Update an event
   * Change information in existing events specified by &#x60;event_id&#x60; or *flag suspicious events*.  When an event is created, it can be assigned &#x60;linked_id&#x60; and &#x60;tags&#x60; submitted through the JS agent parameters.  This information might not have been available on the client initially, so the Server API permits updating these attributes after the fact.  **Warning** It&#39;s not possible to update events older than one month.   **Warning** Trying to update an event immediately after creation may temporarily result in an  error (HTTP 409 Conflict. The event is not mutable yet.) as the event is fully propagated across our systems. In such a case, simply retry the request. 
   * @param eventId The unique event [identifier](https://dev.fingerprint.com/reference/get-function#event_id). (required)
   * @param eventUpdate  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. The request payload is not valid. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found. The event Id cannot be found in this application&#39;s data. </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict. The event is not mutable yet. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateEventWithHttpInfo(@jakarta.annotation.Nonnull String eventId, @jakarta.annotation.Nonnull EventUpdate eventUpdate) throws ApiException {
    // Check required parameters
    if (eventId == null) {
      throw new ApiException(400, "Missing the required parameter 'eventId' when calling updateEvent");
    }
    if (eventUpdate == null) {
      throw new ApiException(400, "Missing the required parameter 'eventUpdate' when calling updateEvent");
    }

    // Path parameters
    String localVarPath = "/events/{event_id}"
            .replaceAll("\\{event_id}", apiClient.escapeString(eventId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    return apiClient.invokeAPI("FingerprintApi.updateEvent", localVarPath, "PATCH", new ArrayList<>(), eventUpdate,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
