package com.fingerprint.api;

import com.fingerprint.sdk.ApiException;
import com.fingerprint.sdk.ApiClient;
import com.fingerprint.sdk.ApiResponse;
import com.fingerprint.sdk.Configuration;
import com.fingerprint.sdk.Pair;
import com.fingerprint.sdk.Region;

import jakarta.ws.rs.core.GenericType;

import com.fingerprint.model.ErrorResponse;
import com.fingerprint.model.Event;
import com.fingerprint.model.EventSearch;
import com.fingerprint.model.EventUpdate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.16.0")public class FingerprintApi {
  public static final String INTEGRATION_INFO = "fingerprint-pro-server-java-sdk/7.10.0";
  private ApiClient apiClient;

  public FingerprintApi() {
    this(Configuration.getDefaultApiClient());
  }

  public FingerprintApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public FingerprintApi(String apiKey) {
    this(Configuration.getDefaultApiClient(apiKey));
  }

  public FingerprintApi(String apiKey, Region region) {
    this(Configuration.getDefaultApiClient(apiKey, region));
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
   * Request deleting all data associated with the specified visitor ID. This API is useful for compliance with privacy regulations.  ### Which data is deleted? - Browser (or device) properties - Identification requests made from this browser (or device)  #### Browser (or device) properties - Represents the data that Fingerprint collected from this specific browser (or device) and everything inferred and derived from it. - Upon request to delete, this data is deleted asynchronously (typically within a few minutes) and it will no longer be used to identify this browser (or device) for your [Fingerprint Workspace](https://dev.fingerprint.com/docs/glossary#fingerprint-workspace).  #### Identification requests made from this browser (or device) - Fingerprint stores the identification requests made from a browser (or device) for up to 30 (or 90) days depending on your plan. To learn more, see [Data Retention](https://dev.fingerprint.com/docs/regions#data-retention). - Upon request to delete, the identification requests that were made by this browser   - Within the past 10 days are deleted within 24 hrs.   - Outside of 10 days are allowed to purge as per your data retention period.  ### Corollary After requesting to delete a visitor ID, - If the same browser (or device) requests to identify, it will receive a different visitor ID. - If you request [`/v4/events` API](https://dev.fingerprint.com/reference/getevent) with an `event_id` that was made outside of the 10 days, you will still receive a valid response.  ### Interested? Please [contact our support team](https://fingerprint.com/support/) to enable it for you. Otherwise, you will receive a 403. 
   * @param visitorId The [visitor ID](https://dev.fingerprint.com/reference/get-function#visitorid) you want to delete. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK. The visitor ID is scheduled for deletion. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. The visitor ID parameter is missing or in the wrong format. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found. The visitor ID cannot be found in this application&#39;s data. </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too Many Requests. The request is throttled. </td><td>  -  </td></tr>
     </table>
   */
  public void deleteVisitorData(String visitorId) throws ApiException {
    deleteVisitorDataWithHttpInfo(visitorId);
  }

  /**
   * Delete data by visitor ID
   * Request deleting all data associated with the specified visitor ID. This API is useful for compliance with privacy regulations.  ### Which data is deleted? - Browser (or device) properties - Identification requests made from this browser (or device)  #### Browser (or device) properties - Represents the data that Fingerprint collected from this specific browser (or device) and everything inferred and derived from it. - Upon request to delete, this data is deleted asynchronously (typically within a few minutes) and it will no longer be used to identify this browser (or device) for your [Fingerprint Workspace](https://dev.fingerprint.com/docs/glossary#fingerprint-workspace).  #### Identification requests made from this browser (or device) - Fingerprint stores the identification requests made from a browser (or device) for up to 30 (or 90) days depending on your plan. To learn more, see [Data Retention](https://dev.fingerprint.com/docs/regions#data-retention). - Upon request to delete, the identification requests that were made by this browser   - Within the past 10 days are deleted within 24 hrs.   - Outside of 10 days are allowed to purge as per your data retention period.  ### Corollary After requesting to delete a visitor ID, - If the same browser (or device) requests to identify, it will receive a different visitor ID. - If you request [`/v4/events` API](https://dev.fingerprint.com/reference/getevent) with an `event_id` that was made outside of the 10 days, you will still receive a valid response.  ### Interested? Please [contact our support team](https://fingerprint.com/support/) to enable it for you. Otherwise, you will receive a 403. 
   * @param visitorId The [visitor ID](https://dev.fingerprint.com/reference/get-function#visitorid) you want to delete. (required)
   * @return ApiResponse<Void>
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK. The visitor ID is scheduled for deletion. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. The visitor ID parameter is missing or in the wrong format. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found. The visitor ID cannot be found in this application&#39;s data. </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too Many Requests. The request is throttled. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteVisitorDataWithHttpInfo(String visitorId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'visitorId' is set
    if (visitorId == null) {
      throw new ApiException(400, "Missing the required parameter 'visitorId' when calling deleteVisitorData");
    }
    
    // create path and map variables
    String localVarPath = "/visitors/{visitor_id}"
      .replaceAll("\\{" + "visitor_id" + "\\}", apiClient.escapeString(visitorId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.add(new Pair("ii", INTEGRATION_INFO));

    final String localVarAccept = apiClient.selectHeaderAccept("application/json");
    final String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] { "bearerAuth" };

    return apiClient.invokeAPI("FingerprintApi.deleteVisitorData", localVarPath, "DELETE", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get an event by event ID
   * Get a detailed analysis of an individual identification event, including Smart Signals.  Use `event_id` as the URL path parameter. This API method is scoped to a request, i.e. all returned information is by `event_id`. 
   * @param eventId The unique [identifier](https://dev.fingerprint.com/reference/get-function#requestid) of each identification request (`requestId` can be used in its place). (required)
   * @return Event
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. The event Id provided is not valid. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found. The event Id cannot be found in this application&#39;s data. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Application error. </td><td>  -  </td></tr>
     </table>
   */
  public Event getEvent(String eventId) throws ApiException {
    return getEventWithHttpInfo(eventId).getData();
  }

  /**
   * Get an event by event ID
   * Get a detailed analysis of an individual identification event, including Smart Signals.  Use `event_id` as the URL path parameter. This API method is scoped to a request, i.e. all returned information is by `event_id`. 
   * @param eventId The unique [identifier](https://dev.fingerprint.com/reference/get-function#requestid) of each identification request (`requestId` can be used in its place). (required)
   * @return ApiResponse<Event>
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. The event Id provided is not valid. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found. The event Id cannot be found in this application&#39;s data. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Application error. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Event> getEventWithHttpInfo(String eventId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'eventId' is set
    if (eventId == null) {
      throw new ApiException(400, "Missing the required parameter 'eventId' when calling getEvent");
    }
    
    // create path and map variables
    String localVarPath = "/events/{event_id}"
      .replaceAll("\\{" + "event_id" + "\\}", apiClient.escapeString(eventId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.add(new Pair("ii", INTEGRATION_INFO));

    final String localVarAccept = apiClient.selectHeaderAccept("application/json");
    final String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] { "bearerAuth" };

    GenericType<Event> localVarReturnType = new GenericType<Event>() {};

    return apiClient.invokeAPI("FingerprintApi.getEvent", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  public static class SearchEventsOptionalParams {
    private Integer limit;
    private String paginationKey;
    private String visitorId;
    private String bot;
    private String ipAddress;
    private String linkedId;
    private String url;
    private String origin;
    private Long start;
    private Long end;
    private Boolean reverse;
    private Boolean suspect;
    private Boolean vpn;
    private Boolean virtualMachine;
    private Boolean tampering;
    private Boolean antiDetectBrowser;
    private Boolean incognito;
    private Boolean privacySettings;
    private Boolean jailbroken;
    private Boolean frida;
    private Boolean factoryReset;
    private Boolean clonedApp;
    private Boolean emulator;
    private Boolean rootApps;
    private String vpnConfidence;
    private Float minSuspectScore;
    private Boolean developerTools;
    private Boolean locationSpoofing;
    private Boolean mitmAttack;
    private Boolean proxy;
    private String sdkVersion;
    private String sdkPlatform;
    private List<String> environment;
    private Long totalHits;

    /**
     * getter for limit - Limit the number of events returned. 
     */
    public Integer getLimit() {
      return limit;
    }

    /**
     * setter for limit - Limit the number of events returned. 
     */
    public SearchEventsOptionalParams setLimit(Integer limit) {
      this.limit = limit;
      return this;
    }

    /**
     * getter for paginationKey - Use `pagination_key` to get the next page of results.  When more results are available (e.g., you requested up to 100 results for your query using `limit`, but there are more than 100 events total matching your request), the `pagination_key` field is added to the response. The key corresponds to the `timestamp` of the last returned event. In the following request, use that value in the `pagination_key` parameter to get the next page of results:  1. First request, returning most recent 200 events: `GET api-base-url/events?limit=100` 2. Use `response.pagination_key` to get the next page of results: `GET api-base-url/events?limit=100&pagination_key=1740815825085` 
     */
    public String getPaginationKey() {
      return paginationKey;
    }

    /**
     * setter for paginationKey - Use `pagination_key` to get the next page of results.  When more results are available (e.g., you requested up to 100 results for your query using `limit`, but there are more than 100 events total matching your request), the `pagination_key` field is added to the response. The key corresponds to the `timestamp` of the last returned event. In the following request, use that value in the `pagination_key` parameter to get the next page of results:  1. First request, returning most recent 200 events: `GET api-base-url/events?limit=100` 2. Use `response.pagination_key` to get the next page of results: `GET api-base-url/events?limit=100&pagination_key=1740815825085` 
     */
    public SearchEventsOptionalParams setPaginationKey(String paginationKey) {
      this.paginationKey = paginationKey;
      return this;
    }

    /**
     * getter for visitorId - Unique [visitor identifier](https://dev.fingerprint.com/reference/get-function#visitorid) issued by Fingerprint Identification and all active Smart Signals. Filter for events matching this `visitor_id`. 
     */
    public String getVisitorId() {
      return visitorId;
    }

    /**
     * setter for visitorId - Unique [visitor identifier](https://dev.fingerprint.com/reference/get-function#visitorid) issued by Fingerprint Identification and all active Smart Signals. Filter for events matching this `visitor_id`. 
     */
    public SearchEventsOptionalParams setVisitorId(String visitorId) {
      this.visitorId = visitorId;
      return this;
    }

    /**
     * getter for bot - Filter events by the Bot Detection result, specifically:   `all` - events where any kind of bot was detected.   `good` - events where a good bot was detected.   `bad` - events where a bad bot was detected.   `none` - events where no bot was detected. > Note: When using this parameter, only events with the `botd.bot` property set to a valid value are returned. Events without a `botd` Smart Signal result are left out of the response. 
     */
    public String getBot() {
      return bot;
    }

    /**
     * setter for bot - Filter events by the Bot Detection result, specifically:   `all` - events where any kind of bot was detected.   `good` - events where a good bot was detected.   `bad` - events where a bad bot was detected.   `none` - events where no bot was detected. > Note: When using this parameter, only events with the `botd.bot` property set to a valid value are returned. Events without a `botd` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setBot(String bot) {
      this.bot = bot;
      return this;
    }

    /**
     * getter for ipAddress - Filter events by IP address or IP range (if CIDR notation is used). If CIDR notation is not used, a /32 for IPv4 or /128 for IPv6 is assumed. Examples of range based queries: 10.0.0.0/24, 192.168.0.1/32 
     */
    public String getIpAddress() {
      return ipAddress;
    }

    /**
     * setter for ipAddress - Filter events by IP address or IP range (if CIDR notation is used). If CIDR notation is not used, a /32 for IPv4 or /128 for IPv6 is assumed. Examples of range based queries: 10.0.0.0/24, 192.168.0.1/32 
     */
    public SearchEventsOptionalParams setIpAddress(String ipAddress) {
      this.ipAddress = ipAddress;
      return this;
    }

    /**
     * getter for linkedId - Filter events by your custom identifier.  You can use [linked Ids](https://dev.fingerprint.com/reference/get-function#linkedid) to associate identification requests with your own identifier, for example, session Id, purchase Id, or transaction Id. You can then use this `linked_id` parameter to retrieve all events associated with your custom identifier. 
     */
    public String getLinkedId() {
      return linkedId;
    }

    /**
     * setter for linkedId - Filter events by your custom identifier.  You can use [linked Ids](https://dev.fingerprint.com/reference/get-function#linkedid) to associate identification requests with your own identifier, for example, session Id, purchase Id, or transaction Id. You can then use this `linked_id` parameter to retrieve all events associated with your custom identifier. 
     */
    public SearchEventsOptionalParams setLinkedId(String linkedId) {
      this.linkedId = linkedId;
      return this;
    }

    /**
     * getter for url - Filter events by the URL (`url` property) associated with the event. 
     */
    public String getUrl() {
      return url;
    }

    /**
     * setter for url - Filter events by the URL (`url` property) associated with the event. 
     */
    public SearchEventsOptionalParams setUrl(String url) {
      this.url = url;
      return this;
    }

    /**
     * getter for origin - Filter events by the origin field of the event. Origin could be the website domain or mobile app bundle ID (eg: com.foo.bar) 
     */
    public String getOrigin() {
      return origin;
    }

    /**
     * setter for origin - Filter events by the origin field of the event. Origin could be the website domain or mobile app bundle ID (eg: com.foo.bar) 
     */
    public SearchEventsOptionalParams setOrigin(String origin) {
      this.origin = origin;
      return this;
    }

    /**
     * getter for start - Filter events with a timestamp greater than the start time, in Unix time (milliseconds). 
     */
    public Long getStart() {
      return start;
    }

    /**
     * setter for start - Filter events with a timestamp greater than the start time, in Unix time (milliseconds). 
     */
    public SearchEventsOptionalParams setStart(Long start) {
      this.start = start;
      return this;
    }

    /**
     * getter for end - Filter events with a timestamp smaller than the end time, in Unix time (milliseconds). 
     */
    public Long getEnd() {
      return end;
    }

    /**
     * setter for end - Filter events with a timestamp smaller than the end time, in Unix time (milliseconds). 
     */
    public SearchEventsOptionalParams setEnd(Long end) {
      this.end = end;
      return this;
    }

    /**
     * getter for reverse - Sort events in reverse timestamp order. 
     */
    public Boolean getReverse() {
      return reverse;
    }

    /**
     * setter for reverse - Sort events in reverse timestamp order. 
     */
    public SearchEventsOptionalParams setReverse(Boolean reverse) {
      this.reverse = reverse;
      return this;
    }

    /**
     * getter for suspect - Filter events previously tagged as suspicious via the [Update API](https://dev.fingerprint.com/reference/updateevent). > Note: When using this parameter, only events with the `suspect` property explicitly set to `true` or `false` are returned. Events with undefined `suspect` property are left out of the response. 
     */
    public Boolean getSuspect() {
      return suspect;
    }

    /**
     * setter for suspect - Filter events previously tagged as suspicious via the [Update API](https://dev.fingerprint.com/reference/updateevent). > Note: When using this parameter, only events with the `suspect` property explicitly set to `true` or `false` are returned. Events with undefined `suspect` property are left out of the response. 
     */
    public SearchEventsOptionalParams setSuspect(Boolean suspect) {
      this.suspect = suspect;
      return this;
    }

    /**
     * getter for vpn - Filter events by VPN Detection result. > Note: When using this parameter, only events with the `vpn` property set to `true` or `false` are returned. Events without a `vpn` Smart Signal result are left out of the response. 
     */
    public Boolean getVpn() {
      return vpn;
    }

    /**
     * setter for vpn - Filter events by VPN Detection result. > Note: When using this parameter, only events with the `vpn` property set to `true` or `false` are returned. Events without a `vpn` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setVpn(Boolean vpn) {
      this.vpn = vpn;
      return this;
    }

    /**
     * getter for virtualMachine - Filter events by Virtual Machine Detection result. > Note: When using this parameter, only events with the `virtual_machine` property set to `true` or `false` are returned. Events without a `virtual_machine` Smart Signal result are left out of the response. 
     */
    public Boolean getVirtualMachine() {
      return virtualMachine;
    }

    /**
     * setter for virtualMachine - Filter events by Virtual Machine Detection result. > Note: When using this parameter, only events with the `virtual_machine` property set to `true` or `false` are returned. Events without a `virtual_machine` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setVirtualMachine(Boolean virtualMachine) {
      this.virtualMachine = virtualMachine;
      return this;
    }

    /**
     * getter for tampering - Filter events by Browser Tampering Detection result. > Note: When using this parameter, only events with the `tampering.result` property set to `true` or `false` are returned. Events without a `tampering` Smart Signal result are left out of the response. 
     */
    public Boolean getTampering() {
      return tampering;
    }

    /**
     * setter for tampering - Filter events by Browser Tampering Detection result. > Note: When using this parameter, only events with the `tampering.result` property set to `true` or `false` are returned. Events without a `tampering` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setTampering(Boolean tampering) {
      this.tampering = tampering;
      return this;
    }

    /**
     * getter for antiDetectBrowser - Filter events by Anti-detect Browser Detection result. > Note: When using this parameter, only events with the `tampering.anti_detect_browser` property set to `true` or `false` are returned. Events without a `tampering` Smart Signal result are left out of the response. 
     */
    public Boolean getAntiDetectBrowser() {
      return antiDetectBrowser;
    }

    /**
     * setter for antiDetectBrowser - Filter events by Anti-detect Browser Detection result. > Note: When using this parameter, only events with the `tampering.anti_detect_browser` property set to `true` or `false` are returned. Events without a `tampering` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setAntiDetectBrowser(Boolean antiDetectBrowser) {
      this.antiDetectBrowser = antiDetectBrowser;
      return this;
    }

    /**
     * getter for incognito - Filter events by Browser Incognito Detection result. > Note: When using this parameter, only events with the `incognito` property set to `true` or `false` are returned. Events without an `incognito` Smart Signal result are left out of the response. 
     */
    public Boolean getIncognito() {
      return incognito;
    }

    /**
     * setter for incognito - Filter events by Browser Incognito Detection result. > Note: When using this parameter, only events with the `incognito` property set to `true` or `false` are returned. Events without an `incognito` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setIncognito(Boolean incognito) {
      this.incognito = incognito;
      return this;
    }

    /**
     * getter for privacySettings - Filter events by Privacy Settings Detection result. > Note: When using this parameter, only events with the `privacy_settings` property set to `true` or `false` are returned. Events without a `privacy_settings` Smart Signal result are left out of the response. 
     */
    public Boolean getPrivacySettings() {
      return privacySettings;
    }

    /**
     * setter for privacySettings - Filter events by Privacy Settings Detection result. > Note: When using this parameter, only events with the `privacy_settings` property set to `true` or `false` are returned. Events without a `privacy_settings` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setPrivacySettings(Boolean privacySettings) {
      this.privacySettings = privacySettings;
      return this;
    }

    /**
     * getter for jailbroken - Filter events by Jailbroken Device Detection result. > Note: When using this parameter, only events with the `jailbroken` property set to `true` or `false` are returned. Events without a `jailbroken` Smart Signal result are left out of the response. 
     */
    public Boolean getJailbroken() {
      return jailbroken;
    }

    /**
     * setter for jailbroken - Filter events by Jailbroken Device Detection result. > Note: When using this parameter, only events with the `jailbroken` property set to `true` or `false` are returned. Events without a `jailbroken` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setJailbroken(Boolean jailbroken) {
      this.jailbroken = jailbroken;
      return this;
    }

    /**
     * getter for frida - Filter events by Frida Detection result. > Note: When using this parameter, only events with the `frida` property set to `true` or `false` are returned. Events without a `frida` Smart Signal result are left out of the response. 
     */
    public Boolean getFrida() {
      return frida;
    }

    /**
     * setter for frida - Filter events by Frida Detection result. > Note: When using this parameter, only events with the `frida` property set to `true` or `false` are returned. Events without a `frida` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setFrida(Boolean frida) {
      this.frida = frida;
      return this;
    }

    /**
     * getter for factoryReset - Filter events by Factory Reset Detection result. > Note: When using this parameter, only events with a `factory_reset` time. Events without a `factory_reset` Smart Signal result are left out of the response. 
     */
    public Boolean getFactoryReset() {
      return factoryReset;
    }

    /**
     * setter for factoryReset - Filter events by Factory Reset Detection result. > Note: When using this parameter, only events with a `factory_reset` time. Events without a `factory_reset` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setFactoryReset(Boolean factoryReset) {
      this.factoryReset = factoryReset;
      return this;
    }

    /**
     * getter for clonedApp - Filter events by Cloned App Detection result. > Note: When using this parameter, only events with the `cloned_app` property set to `true` or `false` are returned. Events without a `cloned_app` Smart Signal result are left out of the response. 
     */
    public Boolean getClonedApp() {
      return clonedApp;
    }

    /**
     * setter for clonedApp - Filter events by Cloned App Detection result. > Note: When using this parameter, only events with the `cloned_app` property set to `true` or `false` are returned. Events without a `cloned_app` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setClonedApp(Boolean clonedApp) {
      this.clonedApp = clonedApp;
      return this;
    }

    /**
     * getter for emulator - Filter events by Android Emulator Detection result. > Note: When using this parameter, only events with the `emulator` property set to `true` or `false` are returned. Events without an `emulator` Smart Signal result are left out of the response. 
     */
    public Boolean getEmulator() {
      return emulator;
    }

    /**
     * setter for emulator - Filter events by Android Emulator Detection result. > Note: When using this parameter, only events with the `emulator` property set to `true` or `false` are returned. Events without an `emulator` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setEmulator(Boolean emulator) {
      this.emulator = emulator;
      return this;
    }

    /**
     * getter for rootApps - Filter events by Rooted Device Detection result. > Note: When using this parameter, only events with the `root_apps` property set to `true` or `false` are returned. Events without a `root_apps` Smart Signal result are left out of the response. 
     */
    public Boolean getRootApps() {
      return rootApps;
    }

    /**
     * setter for rootApps - Filter events by Rooted Device Detection result. > Note: When using this parameter, only events with the `root_apps` property set to `true` or `false` are returned. Events without a `root_apps` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setRootApps(Boolean rootApps) {
      this.rootApps = rootApps;
      return this;
    }

    /**
     * getter for vpnConfidence - Filter events by VPN Detection result confidence level. `high` - events with high VPN Detection confidence. `medium` - events with medium VPN Detection confidence. `low` - events with low VPN Detection confidence. > Note: When using this parameter, only events with the `vpn.confidence` property set to a valid value are returned. Events without a `vpn` Smart Signal result are left out of the response. 
     */
    public String getVpnConfidence() {
      return vpnConfidence;
    }

    /**
     * setter for vpnConfidence - Filter events by VPN Detection result confidence level. `high` - events with high VPN Detection confidence. `medium` - events with medium VPN Detection confidence. `low` - events with low VPN Detection confidence. > Note: When using this parameter, only events with the `vpn.confidence` property set to a valid value are returned. Events without a `vpn` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setVpnConfidence(String vpnConfidence) {
      this.vpnConfidence = vpnConfidence;
      return this;
    }

    /**
     * getter for minSuspectScore - Filter events with Suspect Score result above a provided minimum threshold. > Note: When using this parameter, only events where the `suspect_score` property set to a value exceeding your threshold are returned. Events without a `suspect_score` Smart Signal result are left out of the response. 
     */
    public Float getMinSuspectScore() {
      return minSuspectScore;
    }

    /**
     * setter for minSuspectScore - Filter events with Suspect Score result above a provided minimum threshold. > Note: When using this parameter, only events where the `suspect_score` property set to a value exceeding your threshold are returned. Events without a `suspect_score` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setMinSuspectScore(Float minSuspectScore) {
      this.minSuspectScore = minSuspectScore;
      return this;
    }

    /**
     * getter for developerTools - Filter events by Developer Tools detection result. > Note: When using this parameter, only events with the `developer_tools` property set to `true` or `false` are returned. Events without a `developer_tools` Smart Signal result are left out of the response. 
     */
    public Boolean getDeveloperTools() {
      return developerTools;
    }

    /**
     * setter for developerTools - Filter events by Developer Tools detection result. > Note: When using this parameter, only events with the `developer_tools` property set to `true` or `false` are returned. Events without a `developer_tools` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setDeveloperTools(Boolean developerTools) {
      this.developerTools = developerTools;
      return this;
    }

    /**
     * getter for locationSpoofing - Filter events by Location Spoofing detection result. > Note: When using this parameter, only events with the `location_spoofing` property set to `true` or `false` are returned. Events without a `location_spoofing` Smart Signal result are left out of the response. 
     */
    public Boolean getLocationSpoofing() {
      return locationSpoofing;
    }

    /**
     * setter for locationSpoofing - Filter events by Location Spoofing detection result. > Note: When using this parameter, only events with the `location_spoofing` property set to `true` or `false` are returned. Events without a `location_spoofing` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setLocationSpoofing(Boolean locationSpoofing) {
      this.locationSpoofing = locationSpoofing;
      return this;
    }

    /**
     * getter for mitmAttack - Filter events by MITM (Man-in-the-Middle) Attack detection result. > Note: When using this parameter, only events with the `mitm_attack` property set to `true` or `false` are returned. Events without a `mitm_attack` Smart Signal result are left out of the response. 
     */
    public Boolean getMitmAttack() {
      return mitmAttack;
    }

    /**
     * setter for mitmAttack - Filter events by MITM (Man-in-the-Middle) Attack detection result. > Note: When using this parameter, only events with the `mitm_attack` property set to `true` or `false` are returned. Events without a `mitm_attack` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setMitmAttack(Boolean mitmAttack) {
      this.mitmAttack = mitmAttack;
      return this;
    }

    /**
     * getter for proxy - Filter events by Proxy detection result. > Note: When using this parameter, only events with the `proxy` property set to `true` or `false` are returned. Events without a `proxy` Smart Signal result are left out of the response. 
     */
    public Boolean getProxy() {
      return proxy;
    }

    /**
     * setter for proxy - Filter events by Proxy detection result. > Note: When using this parameter, only events with the `proxy` property set to `true` or `false` are returned. Events without a `proxy` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setProxy(Boolean proxy) {
      this.proxy = proxy;
      return this;
    }

    /**
     * getter for sdkVersion - Filter events by a specific SDK version associated with the identification event (`sdk.version` property). Example: `3.11.14` 
     */
    public String getSdkVersion() {
      return sdkVersion;
    }

    /**
     * setter for sdkVersion - Filter events by a specific SDK version associated with the identification event (`sdk.version` property). Example: `3.11.14` 
     */
    public SearchEventsOptionalParams setSdkVersion(String sdkVersion) {
      this.sdkVersion = sdkVersion;
      return this;
    }

    /**
     * getter for sdkPlatform - Filter events by the SDK Platform associated with the identification event (`sdk.platform` property) . `js` - Javascript agent (Web). `ios` - Apple iOS based devices. `android` - Android based devices. 
     */
    public String getSdkPlatform() {
      return sdkPlatform;
    }

    /**
     * setter for sdkPlatform - Filter events by the SDK Platform associated with the identification event (`sdk.platform` property) . `js` - Javascript agent (Web). `ios` - Apple iOS based devices. `android` - Android based devices. 
     */
    public SearchEventsOptionalParams setSdkPlatform(String sdkPlatform) {
      this.sdkPlatform = sdkPlatform;
      return this;
    }

    /**
     * getter for environment - Filter for events by providing one or more environment IDs (`environment_id` property). 
     */
    public List<String> getEnvironment() {
      return environment;
    }

    /**
     * setter for environment - Filter for events by providing one or more environment IDs (`environment_id` property). 
     */
    public SearchEventsOptionalParams setEnvironment(List<String> environment) {
      this.environment = environment;
      return this;
    }

    /**
     * getter for totalHits - When set, the response will include a `total_hits` property with a count of total query matches across all pages, up to the specified limit. 
     */
    public Long getTotalHits() {
      return totalHits;
    }

    /**
     * setter for totalHits - When set, the response will include a `total_hits` property with a count of total query matches across all pages, up to the specified limit. 
     */
    public SearchEventsOptionalParams setTotalHits(Long totalHits) {
      this.totalHits = totalHits;
      return this;
    }

  }
  /**
   * Search events
   * ## Search  The `/v4/events` endpoint provides a convenient way to search for past events based on specific parameters. Typical use cases and queries include:  - Searching for events associated with a single `visitor_id` within a time range to get historical behavior of a visitor. - Searching for events associated with a single `linked_id` within a time range to get all events associated with your internal account identifier. - Excluding all bot traffic from the query (`good` and `bad` bots)  If you don't provide `start` or `end` parameters, the default search range is the **last 7 days**.  ### Filtering events with the`suspect` flag  The `/v4/events` endpoint unlocks a powerful method for fraud protection analytics. The `suspect` flag is exposed in all events where it was previously set by the update API.  You can also apply the `suspect` query parameter as a filter to find all potentially fraudulent activity that you previously marked as `suspect`. This helps identify patterns of fraudulent behavior.  ### Environment scoping  If you use a secret key that is scoped to an environment, you will only get events associated with the same environment. With a workspace-scoped environment, you will get events from all environments.  Smart Signals not activated for your workspace or are not included in the response. 
   * @param searchEventsOptionalParams Object containing optional parameters for API method.  (optional)
   * @return EventSearch
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Events matching the filter(s). </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. One or more supplied search parameters are invalid, or a required parameter is missing. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Application error. </td><td>  -  </td></tr>
     </table>
   */
  public EventSearch searchEvents(SearchEventsOptionalParams searchEventsOptionalParams) throws ApiException {
    return searchEventsWithHttpInfo(searchEventsOptionalParams).getData();
  }

  /**
   * Search events
   * ## Search  The `/v4/events` endpoint provides a convenient way to search for past events based on specific parameters. Typical use cases and queries include:  - Searching for events associated with a single `visitor_id` within a time range to get historical behavior of a visitor. - Searching for events associated with a single `linked_id` within a time range to get all events associated with your internal account identifier. - Excluding all bot traffic from the query (`good` and `bad` bots)  If you don't provide `start` or `end` parameters, the default search range is the **last 7 days**.  ### Filtering events with the`suspect` flag  The `/v4/events` endpoint unlocks a powerful method for fraud protection analytics. The `suspect` flag is exposed in all events where it was previously set by the update API.  You can also apply the `suspect` query parameter as a filter to find all potentially fraudulent activity that you previously marked as `suspect`. This helps identify patterns of fraudulent behavior.  ### Environment scoping  If you use a secret key that is scoped to an environment, you will only get events associated with the same environment. With a workspace-scoped environment, you will get events from all environments.  Smart Signals not activated for your workspace or are not included in the response. 
   * @param searchEventsOptionalParams Object containing optional parameters for API method.  (optional)
   * @return ApiResponse<EventSearch>
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Events matching the filter(s). </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. One or more supplied search parameters are invalid, or a required parameter is missing. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Application error. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<EventSearch> searchEventsWithHttpInfo(SearchEventsOptionalParams searchEventsOptionalParams) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/events";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.add(new Pair("ii", INTEGRATION_INFO));
    if (searchEventsOptionalParams != null) {
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", searchEventsOptionalParams.getLimit()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "pagination_key", searchEventsOptionalParams.getPaginationKey()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "visitor_id", searchEventsOptionalParams.getVisitorId()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "bot", searchEventsOptionalParams.getBot()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "ip_address", searchEventsOptionalParams.getIpAddress()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "linked_id", searchEventsOptionalParams.getLinkedId()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "url", searchEventsOptionalParams.getUrl()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "origin", searchEventsOptionalParams.getOrigin()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "start", searchEventsOptionalParams.getStart()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "end", searchEventsOptionalParams.getEnd()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "reverse", searchEventsOptionalParams.getReverse()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "suspect", searchEventsOptionalParams.getSuspect()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "vpn", searchEventsOptionalParams.getVpn()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "virtual_machine", searchEventsOptionalParams.getVirtualMachine()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "tampering", searchEventsOptionalParams.getTampering()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "anti_detect_browser", searchEventsOptionalParams.getAntiDetectBrowser()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "incognito", searchEventsOptionalParams.getIncognito()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "privacy_settings", searchEventsOptionalParams.getPrivacySettings()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "jailbroken", searchEventsOptionalParams.getJailbroken()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "frida", searchEventsOptionalParams.getFrida()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "factory_reset", searchEventsOptionalParams.getFactoryReset()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "cloned_app", searchEventsOptionalParams.getClonedApp()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "emulator", searchEventsOptionalParams.getEmulator()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "root_apps", searchEventsOptionalParams.getRootApps()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "vpn_confidence", searchEventsOptionalParams.getVpnConfidence()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "min_suspect_score", searchEventsOptionalParams.getMinSuspectScore()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "developer_tools", searchEventsOptionalParams.getDeveloperTools()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "location_spoofing", searchEventsOptionalParams.getLocationSpoofing()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "mitm_attack", searchEventsOptionalParams.getMitmAttack()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "proxy", searchEventsOptionalParams.getProxy()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "sdk_version", searchEventsOptionalParams.getSdkVersion()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "sdk_platform", searchEventsOptionalParams.getSdkPlatform()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "environment", searchEventsOptionalParams.getEnvironment()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "total_hits", searchEventsOptionalParams.getTotalHits()));
    }

    final String localVarAccept = apiClient.selectHeaderAccept("application/json");
    final String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] { "bearerAuth" };

    GenericType<EventSearch> localVarReturnType = new GenericType<EventSearch>() {};

    return apiClient.invokeAPI("FingerprintApi.searchEvents", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update an event
   * Change information in existing events specified by `event_id` or *flag suspicious events*.  When an event is created, it can be assigned `linked_id` and `tags` submitted through the JS agent parameters.  This information might not have been available on the client initially, so the Server API permits updating these attributes after the fact.  **Warning** It's not possible to update events older than one month.   **Warning** Trying to update an event immediately after creation may temporarily result in an  error (HTTP 409 Conflict. The event is not mutable yet.) as the event is fully propagated across our systems. In such a case, simply retry the request. 
   * @param eventId The unique event [identifier](https://dev.fingerprint.com/reference/get-function#event_id). (required)
   * @param eventUpdate  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. The request payload is not valid. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found. The event Id cannot be found in this application&#39;s data. </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict. The event is not mutable yet. </td><td>  -  </td></tr>
     </table>
   */
  public void updateEvent(String eventId, EventUpdate eventUpdate) throws ApiException {
    updateEventWithHttpInfo(eventId, eventUpdate);
  }

  /**
   * Update an event
   * Change information in existing events specified by `event_id` or *flag suspicious events*.  When an event is created, it can be assigned `linked_id` and `tags` submitted through the JS agent parameters.  This information might not have been available on the client initially, so the Server API permits updating these attributes after the fact.  **Warning** It's not possible to update events older than one month.   **Warning** Trying to update an event immediately after creation may temporarily result in an  error (HTTP 409 Conflict. The event is not mutable yet.) as the event is fully propagated across our systems. In such a case, simply retry the request. 
   * @param eventId The unique event [identifier](https://dev.fingerprint.com/reference/get-function#event_id). (required)
   * @param eventUpdate  (required)
   * @return ApiResponse<Void>
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. The request payload is not valid. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found. The event Id cannot be found in this application&#39;s data. </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict. The event is not mutable yet. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateEventWithHttpInfo(String eventId, EventUpdate eventUpdate) throws ApiException {
    Object localVarPostBody = eventUpdate;
    
    // verify the required parameter 'eventId' is set
    if (eventId == null) {
      throw new ApiException(400, "Missing the required parameter 'eventId' when calling updateEvent");
    }
    
    // verify the required parameter 'eventUpdate' is set
    if (eventUpdate == null) {
      throw new ApiException(400, "Missing the required parameter 'eventUpdate' when calling updateEvent");
    }
    
    // create path and map variables
    String localVarPath = "/events/{event_id}"
      .replaceAll("\\{" + "event_id" + "\\}", apiClient.escapeString(eventId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.add(new Pair("ii", INTEGRATION_INFO));

    final String localVarAccept = apiClient.selectHeaderAccept("application/json");
    final String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] { "bearerAuth" };

    return apiClient.invokeAPI("FingerprintApi.updateEvent", localVarPath, "PATCH", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
