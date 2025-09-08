package com.fingerprint.api;

import com.fingerprint.sdk.ApiException;
import com.fingerprint.sdk.ApiClient;
import com.fingerprint.sdk.ApiResponse;
import com.fingerprint.sdk.Configuration;
import com.fingerprint.sdk.Pair;
import com.fingerprint.sdk.Region;

import jakarta.ws.rs.core.GenericType;

import com.fingerprint.model.ErrorPlainResponse;
import com.fingerprint.model.ErrorResponse;
import com.fingerprint.model.EventsGetResponse;
import com.fingerprint.model.EventsUpdateRequest;
import com.fingerprint.model.RelatedVisitorsResponse;
import com.fingerprint.model.SearchEventsResponse;
import com.fingerprint.model.VisitorsGetResponse;
import com.fingerprint.model.Webhook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class FingerprintApi {
  public static final String INTEGRATION_INFO = "fingerprint-pro-server-java-sdk/7.10.0-develop.1";
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
   * Request deleting all data associated with the specified visitor ID. This API is useful for compliance with privacy regulations. ### Which data is deleted? - Browser (or device) properties - Identification requests made from this browser (or device)  #### Browser (or device) properties - Represents the data that Fingerprint collected from this specific browser (or device) and everything inferred and derived from it. - Upon request to delete, this data is deleted asynchronously (typically within a few minutes) and it will no longer be used to identify this browser (or device) for your [Fingerprint Workspace](https://dev.fingerprint.com/docs/glossary#fingerprint-workspace).  #### Identification requests made from this browser (or device) - Fingerprint stores the identification requests made from a browser (or device) for up to 30 (or 90) days depending on your plan. To learn more, see [Data Retention](https://dev.fingerprint.com/docs/regions#data-retention). - Upon request to delete, the identification requests that were made by this browser   - Within the past 10 days are deleted within 24 hrs.   - Outside of 10 days are allowed to purge as per your data retention period.  ### Corollary After requesting to delete a visitor ID, - If the same browser (or device) requests to identify, it will receive a different visitor ID. - If you request [`/events` API](https://dev.fingerprint.com/reference/getevent) with a `request_id` that was made outside of the 10 days, you will still receive a valid response. - If you request [`/visitors` API](https://dev.fingerprint.com/reference/getvisits) for the deleted visitor ID, the response will include identification requests that were made outside of those 10 days.  ### Interested? Please [contact our support team](https://fingerprint.com/support/) to enable it for you. Otherwise, you will receive a 403. 
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
   * Request deleting all data associated with the specified visitor ID. This API is useful for compliance with privacy regulations. ### Which data is deleted? - Browser (or device) properties - Identification requests made from this browser (or device)  #### Browser (or device) properties - Represents the data that Fingerprint collected from this specific browser (or device) and everything inferred and derived from it. - Upon request to delete, this data is deleted asynchronously (typically within a few minutes) and it will no longer be used to identify this browser (or device) for your [Fingerprint Workspace](https://dev.fingerprint.com/docs/glossary#fingerprint-workspace).  #### Identification requests made from this browser (or device) - Fingerprint stores the identification requests made from a browser (or device) for up to 30 (or 90) days depending on your plan. To learn more, see [Data Retention](https://dev.fingerprint.com/docs/regions#data-retention). - Upon request to delete, the identification requests that were made by this browser   - Within the past 10 days are deleted within 24 hrs.   - Outside of 10 days are allowed to purge as per your data retention period.  ### Corollary After requesting to delete a visitor ID, - If the same browser (or device) requests to identify, it will receive a different visitor ID. - If you request [`/events` API](https://dev.fingerprint.com/reference/getevent) with a `request_id` that was made outside of the 10 days, you will still receive a valid response. - If you request [`/visitors` API](https://dev.fingerprint.com/reference/getvisits) for the deleted visitor ID, the response will include identification requests that were made outside of those 10 days.  ### Interested? Please [contact our support team](https://fingerprint.com/support/) to enable it for you. Otherwise, you will receive a 403. 
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


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "ApiKeyHeader", "ApiKeyQuery" };

    return apiClient.invokeAPI("FingerprintApi.deleteVisitorData", localVarPath, "DELETE", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get event by request ID
   * Get a detailed analysis of an individual identification event, including Smart Signals.  Please note that the response includes mobile signals (e.g. `rootApps`) even if the request originated from a non-mobile platform. It is highly recommended that you **ignore** the mobile signals for such requests.   Use `requestId` as the URL path parameter. This API method is scoped to a request, i.e. all returned information is by `requestId`. 
   * @param requestId The unique [identifier](https://dev.fingerprint.com/reference/get-function#requestid) of each identification request. (required)
   * @return EventsGetResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found. The request ID cannot be found in this application&#39;s data. </td><td>  -  </td></tr>
     </table>
   */
  public EventsGetResponse getEvent(String requestId) throws ApiException {
    return getEventWithHttpInfo(requestId).getData();
  }

  /**
   * Get event by request ID
   * Get a detailed analysis of an individual identification event, including Smart Signals.  Please note that the response includes mobile signals (e.g. `rootApps`) even if the request originated from a non-mobile platform. It is highly recommended that you **ignore** the mobile signals for such requests.   Use `requestId` as the URL path parameter. This API method is scoped to a request, i.e. all returned information is by `requestId`. 
   * @param requestId The unique [identifier](https://dev.fingerprint.com/reference/get-function#requestid) of each identification request. (required)
   * @return ApiResponse<EventsGetResponse>
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found. The request ID cannot be found in this application&#39;s data. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<EventsGetResponse> getEventWithHttpInfo(String requestId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'requestId' is set
    if (requestId == null) {
      throw new ApiException(400, "Missing the required parameter 'requestId' when calling getEvent");
    }
    
    // create path and map variables
    String localVarPath = "/events/{request_id}"
      .replaceAll("\\{" + "request_id" + "\\}", apiClient.escapeString(requestId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.add(new Pair("ii", INTEGRATION_INFO));


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "ApiKeyHeader", "ApiKeyQuery" };

    GenericType<EventsGetResponse> localVarReturnType = new GenericType<EventsGetResponse>() {};

    return apiClient.invokeAPI("FingerprintApi.getEvent", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Related Visitors
   * Related visitors API lets you link web visits and in-app browser visits that originated from the same mobile device. It searches the past 6 months of identification events to find the visitor IDs that belong to the same mobile device as the given visitor ID.  ⚠️ Please note that this API is not enabled by default and is billable separately. ⚠️  If you would like to use Related visitors API, please contact our [support team](https://fingerprint.com/support). To learn more, see [Related visitors API reference](https://dev.fingerprint.com/reference/related-visitors-api). 
   * @param visitorId The [visitor ID](https://dev.fingerprint.com/reference/get-function#visitorid) for which you want to find the other visitor IDs that originated from the same mobile device. (required)
   * @return RelatedVisitorsResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. The visitor ID parameter is missing or in the wrong format. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found. The visitor ID cannot be found in this application&#39;s data. </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too Many Requests. The request is throttled. </td><td>  -  </td></tr>
     </table>
   */
  public RelatedVisitorsResponse getRelatedVisitors(String visitorId) throws ApiException {
    return getRelatedVisitorsWithHttpInfo(visitorId).getData();
  }

  /**
   * Get Related Visitors
   * Related visitors API lets you link web visits and in-app browser visits that originated from the same mobile device. It searches the past 6 months of identification events to find the visitor IDs that belong to the same mobile device as the given visitor ID.  ⚠️ Please note that this API is not enabled by default and is billable separately. ⚠️  If you would like to use Related visitors API, please contact our [support team](https://fingerprint.com/support). To learn more, see [Related visitors API reference](https://dev.fingerprint.com/reference/related-visitors-api). 
   * @param visitorId The [visitor ID](https://dev.fingerprint.com/reference/get-function#visitorid) for which you want to find the other visitor IDs that originated from the same mobile device. (required)
   * @return ApiResponse<RelatedVisitorsResponse>
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. The visitor ID parameter is missing or in the wrong format. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found. The visitor ID cannot be found in this application&#39;s data. </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too Many Requests. The request is throttled. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<RelatedVisitorsResponse> getRelatedVisitorsWithHttpInfo(String visitorId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'visitorId' is set
    if (visitorId == null) {
      throw new ApiException(400, "Missing the required parameter 'visitorId' when calling getRelatedVisitors");
    }
    
    // create path and map variables
    String localVarPath = "/related-visitors";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.add(new Pair("ii", INTEGRATION_INFO));

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "visitor_id", visitorId));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "ApiKeyHeader", "ApiKeyQuery" };

    GenericType<RelatedVisitorsResponse> localVarReturnType = new GenericType<RelatedVisitorsResponse>() {};

    return apiClient.invokeAPI("FingerprintApi.getRelatedVisitors", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get visits by visitor ID
   * Get a history of visits (identification events) for a specific `visitorId`. Use the `visitorId` as a URL path parameter. Only information from the _Identification_ product is returned.  #### Headers  * `Retry-After` — Present in case of `429 Too many requests`. Indicates how long you should wait before making a follow-up request. The value is non-negative decimal integer indicating the seconds to delay after the response is received. 
   * @param visitorId Unique [visitor identifier](https://dev.fingerprint.com/reference/get-function#visitorid) issued by Fingerprint Pro. (required)
   * @param requestId Filter visits by `requestId`.   Every identification request has a unique identifier associated with it called `requestId`. This identifier is returned to the client in the identification [result](https://dev.fingerprint.com/reference/get-function#requestid). When you filter visits by `requestId`, only one visit will be returned.  (optional)
   * @param linkedId Filter visits by your custom identifier.   You can use [`linkedId`](https://dev.fingerprint.com/reference/get-function#linkedid) to associate identification requests with your own identifier, for example: session ID, purchase ID, or transaction ID. You can then use this `linked_id` parameter to retrieve all events associated with your custom identifier.  (optional)
   * @param limit Limit scanned results.   For performance reasons, the API first scans some number of events before filtering them. Use `limit` to specify how many events are scanned before they are filtered by `requestId` or `linkedId`. Results are always returned sorted by the timestamp (most recent first). By default, the most recent 100 visits are scanned, the maximum is 500.  (optional)
   * @param paginationKey Use `paginationKey` to get the next page of results.   When more results are available (e.g., you requested 200 results using `limit` parameter, but a total of 600 results are available), the `paginationKey` top-level attribute is added to the response. The key corresponds to the `requestId` of the last returned event. In the following request, use that value in the `paginationKey` parameter to get the next page of results:  1. First request, returning most recent 200 events: `GET api-base-url/visitors/:visitorId?limit=200` 2. Use `response.paginationKey` to get the next page of results: `GET api-base-url/visitors/:visitorId?limit=200&paginationKey=1683900801733.Ogvu1j`  Pagination happens during scanning and before filtering, so you can get less visits than the `limit` you specified with more available on the next page. When there are no more results available for scanning, the `paginationKey` attribute is not returned.  (optional)
   * @param before ⚠️ Deprecated pagination method, please use `paginationKey` instead. Timestamp (in milliseconds since epoch) used to paginate results.  (optional)
   * @return VisitorsGetResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. The visitor ID or query parameters are missing or in the wrong format. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too Many Requests. The request is throttled. </td><td>  * Retry-After - Indicates how many seconds you should wait before attempting the next request. <br>  </td></tr>
     </table>
   */
  public VisitorsGetResponse getVisits(String visitorId, String requestId, String linkedId, Integer limit, String paginationKey, Long before) throws ApiException {
    return getVisitsWithHttpInfo(visitorId, requestId, linkedId, limit, paginationKey, before).getData();
  }

  /**
   * Get visits by visitor ID
   * Get a history of visits (identification events) for a specific `visitorId`. Use the `visitorId` as a URL path parameter. Only information from the _Identification_ product is returned.  #### Headers  * `Retry-After` — Present in case of `429 Too many requests`. Indicates how long you should wait before making a follow-up request. The value is non-negative decimal integer indicating the seconds to delay after the response is received. 
   * @param visitorId Unique [visitor identifier](https://dev.fingerprint.com/reference/get-function#visitorid) issued by Fingerprint Pro. (required)
   * @param requestId Filter visits by `requestId`.   Every identification request has a unique identifier associated with it called `requestId`. This identifier is returned to the client in the identification [result](https://dev.fingerprint.com/reference/get-function#requestid). When you filter visits by `requestId`, only one visit will be returned.  (optional)
   * @param linkedId Filter visits by your custom identifier.   You can use [`linkedId`](https://dev.fingerprint.com/reference/get-function#linkedid) to associate identification requests with your own identifier, for example: session ID, purchase ID, or transaction ID. You can then use this `linked_id` parameter to retrieve all events associated with your custom identifier.  (optional)
   * @param limit Limit scanned results.   For performance reasons, the API first scans some number of events before filtering them. Use `limit` to specify how many events are scanned before they are filtered by `requestId` or `linkedId`. Results are always returned sorted by the timestamp (most recent first). By default, the most recent 100 visits are scanned, the maximum is 500.  (optional)
   * @param paginationKey Use `paginationKey` to get the next page of results.   When more results are available (e.g., you requested 200 results using `limit` parameter, but a total of 600 results are available), the `paginationKey` top-level attribute is added to the response. The key corresponds to the `requestId` of the last returned event. In the following request, use that value in the `paginationKey` parameter to get the next page of results:  1. First request, returning most recent 200 events: `GET api-base-url/visitors/:visitorId?limit=200` 2. Use `response.paginationKey` to get the next page of results: `GET api-base-url/visitors/:visitorId?limit=200&paginationKey=1683900801733.Ogvu1j`  Pagination happens during scanning and before filtering, so you can get less visits than the `limit` you specified with more available on the next page. When there are no more results available for scanning, the `paginationKey` attribute is not returned.  (optional)
   * @param before ⚠️ Deprecated pagination method, please use `paginationKey` instead. Timestamp (in milliseconds since epoch) used to paginate results.  (optional)
   * @return ApiResponse<VisitorsGetResponse>
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. The visitor ID or query parameters are missing or in the wrong format. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too Many Requests. The request is throttled. </td><td>  * Retry-After - Indicates how many seconds you should wait before attempting the next request. <br>  </td></tr>
     </table>
   */
  public ApiResponse<VisitorsGetResponse> getVisitsWithHttpInfo(String visitorId, String requestId, String linkedId, Integer limit, String paginationKey, Long before) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'visitorId' is set
    if (visitorId == null) {
      throw new ApiException(400, "Missing the required parameter 'visitorId' when calling getVisits");
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

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "request_id", requestId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "linked_id", linkedId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "paginationKey", paginationKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "before", before));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "ApiKeyHeader", "ApiKeyQuery" };

    GenericType<VisitorsGetResponse> localVarReturnType = new GenericType<VisitorsGetResponse>() {};

    return apiClient.invokeAPI("FingerprintApi.getVisits", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  public static class SearchEventsOptionalParams {
    
    private String paginationKey;
    private String visitorId;
    private String bot;
    private String ipAddress;
    private String linkedId;
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
    private Boolean ipBlocklist;
    private Boolean datacenter;
    private Boolean developerTools;
    private Boolean locationSpoofing;
    private Boolean mitmAttack;
    private Boolean proxy;
    private String sdkVersion;
    private String sdkPlatform;
    private List<String> environment;
    private String proximityId;
    private Integer proximityPrecisionRadius;

    /**
     * getter for paginationKey - Use `pagination_key` to get the next page of results.   When more results are available (e.g., you requested up to 200 results for your search using `limit`, but there are more than 200 events total matching your request), the `paginationKey` top-level attribute is added to the response. The key corresponds to the `timestamp` of the last returned event. In the following request, use that value in the `pagination_key` parameter to get the next page of results:  1. First request, returning most recent 200 events: `GET api-base-url/events/search?limit=200` 2. Use `response.paginationKey` to get the next page of results: `GET api-base-url/events/search?limit=200&pagination_key=1740815825085` 
     */
    public String getPaginationKey() {
      return paginationKey;
    }

    /**
     * setter for paginationKey - Use `pagination_key` to get the next page of results.   When more results are available (e.g., you requested up to 200 results for your search using `limit`, but there are more than 200 events total matching your request), the `paginationKey` top-level attribute is added to the response. The key corresponds to the `timestamp` of the last returned event. In the following request, use that value in the `pagination_key` parameter to get the next page of results:  1. First request, returning most recent 200 events: `GET api-base-url/events/search?limit=200` 2. Use `response.paginationKey` to get the next page of results: `GET api-base-url/events/search?limit=200&pagination_key=1740815825085` 
     */
    public SearchEventsOptionalParams setPaginationKey(String paginationKey) {
      this.paginationKey = paginationKey;
      return this;
    }

    /**
     * getter for visitorId - Unique [visitor identifier](https://dev.fingerprint.com/reference/get-function#visitorid) issued by Fingerprint Pro. Filter for events matching this `visitor_id`. 
     */
    public String getVisitorId() {
      return visitorId;
    }

    /**
     * setter for visitorId - Unique [visitor identifier](https://dev.fingerprint.com/reference/get-function#visitorid) issued by Fingerprint Pro. Filter for events matching this `visitor_id`. 
     */
    public SearchEventsOptionalParams setVisitorId(String visitorId) {
      this.visitorId = visitorId;
      return this;
    }

    /**
     * getter for bot - Filter events by the Bot Detection result, specifically:    `all` - events where any kind of bot was detected.   `good` - events where a good bot was detected.   `bad` - events where a bad bot was detected.   `none` - events where no bot was detected. > Note: When using this parameter, only events with the `products.botd.data.bot.result` property set to a valid value are returned. Events without a `products.botd` Smart Signal result are left out of the response. 
     */
    public String getBot() {
      return bot;
    }

    /**
     * setter for bot - Filter events by the Bot Detection result, specifically:    `all` - events where any kind of bot was detected.   `good` - events where a good bot was detected.   `bad` - events where a bad bot was detected.   `none` - events where no bot was detected. > Note: When using this parameter, only events with the `products.botd.data.bot.result` property set to a valid value are returned. Events without a `products.botd` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setBot(String bot) {
      this.bot = bot;
      return this;
    }

    /**
     * getter for ipAddress - Filter events by IP address range. The range can be as specific as a single IP (/32 for IPv4 or /128 for IPv6)  All ip_address filters must use CIDR notation, for example, 10.0.0.0/24, 192.168.0.1/32 
     */
    public String getIpAddress() {
      return ipAddress;
    }

    /**
     * setter for ipAddress - Filter events by IP address range. The range can be as specific as a single IP (/32 for IPv4 or /128 for IPv6)  All ip_address filters must use CIDR notation, for example, 10.0.0.0/24, 192.168.0.1/32 
     */
    public SearchEventsOptionalParams setIpAddress(String ipAddress) {
      this.ipAddress = ipAddress;
      return this;
    }

    /**
     * getter for linkedId - Filter events by your custom identifier.   You can use [linked IDs](https://dev.fingerprint.com/reference/get-function#linkedid) to associate identification requests with your own identifier, for example, session ID, purchase ID, or transaction ID. You can then use this `linked_id` parameter to retrieve all events associated with your custom identifier. 
     */
    public String getLinkedId() {
      return linkedId;
    }

    /**
     * setter for linkedId - Filter events by your custom identifier.   You can use [linked IDs](https://dev.fingerprint.com/reference/get-function#linkedid) to associate identification requests with your own identifier, for example, session ID, purchase ID, or transaction ID. You can then use this `linked_id` parameter to retrieve all events associated with your custom identifier. 
     */
    public SearchEventsOptionalParams setLinkedId(String linkedId) {
      this.linkedId = linkedId;
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
     * getter for suspect - Filter events previously tagged as suspicious via the [Update API](https://dev.fingerprint.com/reference/updateevent).  > Note: When using this parameter, only events with the `suspect` property explicitly set to `true` or `false` are returned. Events with undefined `suspect` property are left out of the response. 
     */
    public Boolean getSuspect() {
      return suspect;
    }

    /**
     * setter for suspect - Filter events previously tagged as suspicious via the [Update API](https://dev.fingerprint.com/reference/updateevent).  > Note: When using this parameter, only events with the `suspect` property explicitly set to `true` or `false` are returned. Events with undefined `suspect` property are left out of the response. 
     */
    public SearchEventsOptionalParams setSuspect(Boolean suspect) {
      this.suspect = suspect;
      return this;
    }

    /**
     * getter for vpn - Filter events by VPN Detection result.   > Note: When using this parameter, only events with the `products.vpn.data.result` property set to `true` or `false` are returned. Events without a `products.vpn` Smart Signal result are left out of the response. 
     */
    public Boolean getVpn() {
      return vpn;
    }

    /**
     * setter for vpn - Filter events by VPN Detection result.   > Note: When using this parameter, only events with the `products.vpn.data.result` property set to `true` or `false` are returned. Events without a `products.vpn` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setVpn(Boolean vpn) {
      this.vpn = vpn;
      return this;
    }

    /**
     * getter for virtualMachine - Filter events by Virtual Machine Detection result.   > Note: When using this parameter, only events with the `products.virtualMachine.data.result` property set to `true` or `false` are returned. Events without a `products.virtualMachine` Smart Signal result are left out of the response. 
     */
    public Boolean getVirtualMachine() {
      return virtualMachine;
    }

    /**
     * setter for virtualMachine - Filter events by Virtual Machine Detection result.   > Note: When using this parameter, only events with the `products.virtualMachine.data.result` property set to `true` or `false` are returned. Events without a `products.virtualMachine` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setVirtualMachine(Boolean virtualMachine) {
      this.virtualMachine = virtualMachine;
      return this;
    }

    /**
     * getter for tampering - Filter events by Tampering Detection result.   > Note: When using this parameter, only events with the `products.tampering.data.result` property set to `true` or `false` are returned. Events without a `products.tampering` Smart Signal result are left out of the response. 
     */
    public Boolean getTampering() {
      return tampering;
    }

    /**
     * setter for tampering - Filter events by Tampering Detection result.   > Note: When using this parameter, only events with the `products.tampering.data.result` property set to `true` or `false` are returned. Events without a `products.tampering` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setTampering(Boolean tampering) {
      this.tampering = tampering;
      return this;
    }

    /**
     * getter for antiDetectBrowser - Filter events by Anti-detect Browser Detection result.   > Note: When using this parameter, only events with the `products.tampering.data.antiDetectBrowser` property set to `true` or `false` are returned. Events without a `products.tampering` Smart Signal result are left out of the response. 
     */
    public Boolean getAntiDetectBrowser() {
      return antiDetectBrowser;
    }

    /**
     * setter for antiDetectBrowser - Filter events by Anti-detect Browser Detection result.   > Note: When using this parameter, only events with the `products.tampering.data.antiDetectBrowser` property set to `true` or `false` are returned. Events without a `products.tampering` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setAntiDetectBrowser(Boolean antiDetectBrowser) {
      this.antiDetectBrowser = antiDetectBrowser;
      return this;
    }

    /**
     * getter for incognito - Filter events by Browser Incognito Detection result.   > Note: When using this parameter, only events with the `products.incognito.data.result` property set to `true` or `false` are returned. Events without a `products.incognito` Smart Signal result are left out of the response. 
     */
    public Boolean getIncognito() {
      return incognito;
    }

    /**
     * setter for incognito - Filter events by Browser Incognito Detection result.   > Note: When using this parameter, only events with the `products.incognito.data.result` property set to `true` or `false` are returned. Events without a `products.incognito` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setIncognito(Boolean incognito) {
      this.incognito = incognito;
      return this;
    }

    /**
     * getter for privacySettings - Filter events by Privacy Settings Detection result.   > Note: When using this parameter, only events with the `products.privacySettings.data.result` property set to `true` or `false` are returned. Events without a `products.privacySettings` Smart Signal result are left out of the response. 
     */
    public Boolean getPrivacySettings() {
      return privacySettings;
    }

    /**
     * setter for privacySettings - Filter events by Privacy Settings Detection result.   > Note: When using this parameter, only events with the `products.privacySettings.data.result` property set to `true` or `false` are returned. Events without a `products.privacySettings` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setPrivacySettings(Boolean privacySettings) {
      this.privacySettings = privacySettings;
      return this;
    }

    /**
     * getter for jailbroken - Filter events by Jailbroken Device Detection result.   > Note: When using this parameter, only events with the `products.jailbroken.data.result` property set to `true` or `false` are returned. Events without a `products.jailbroken` Smart Signal result are left out of the response. 
     */
    public Boolean getJailbroken() {
      return jailbroken;
    }

    /**
     * setter for jailbroken - Filter events by Jailbroken Device Detection result.   > Note: When using this parameter, only events with the `products.jailbroken.data.result` property set to `true` or `false` are returned. Events without a `products.jailbroken` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setJailbroken(Boolean jailbroken) {
      this.jailbroken = jailbroken;
      return this;
    }

    /**
     * getter for frida - Filter events by Frida Detection result.   > Note: When using this parameter, only events with the `products.frida.data.result` property set to `true` or `false` are returned. Events without a `products.frida` Smart Signal result are left out of the response. 
     */
    public Boolean getFrida() {
      return frida;
    }

    /**
     * setter for frida - Filter events by Frida Detection result.   > Note: When using this parameter, only events with the `products.frida.data.result` property set to `true` or `false` are returned. Events without a `products.frida` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setFrida(Boolean frida) {
      this.frida = frida;
      return this;
    }

    /**
     * getter for factoryReset - Filter events by Factory Reset Detection result.   > Note: When using this parameter, only events with the `products.factoryReset.data.result` property set to `true` or `false` are returned. Events without a `products.factoryReset` Smart Signal result are left out of the response. 
     */
    public Boolean getFactoryReset() {
      return factoryReset;
    }

    /**
     * setter for factoryReset - Filter events by Factory Reset Detection result.   > Note: When using this parameter, only events with the `products.factoryReset.data.result` property set to `true` or `false` are returned. Events without a `products.factoryReset` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setFactoryReset(Boolean factoryReset) {
      this.factoryReset = factoryReset;
      return this;
    }

    /**
     * getter for clonedApp - Filter events by Cloned App Detection result.   > Note: When using this parameter, only events with the `products.clonedApp.data.result` property set to `true` or `false` are returned. Events without a `products.clonedApp` Smart Signal result are left out of the response. 
     */
    public Boolean getClonedApp() {
      return clonedApp;
    }

    /**
     * setter for clonedApp - Filter events by Cloned App Detection result.   > Note: When using this parameter, only events with the `products.clonedApp.data.result` property set to `true` or `false` are returned. Events without a `products.clonedApp` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setClonedApp(Boolean clonedApp) {
      this.clonedApp = clonedApp;
      return this;
    }

    /**
     * getter for emulator - Filter events by Android Emulator Detection result.   > Note: When using this parameter, only events with the `products.emulator.data.result` property set to `true` or `false` are returned. Events without a `products.emulator` Smart Signal result are left out of the response. 
     */
    public Boolean getEmulator() {
      return emulator;
    }

    /**
     * setter for emulator - Filter events by Android Emulator Detection result.   > Note: When using this parameter, only events with the `products.emulator.data.result` property set to `true` or `false` are returned. Events without a `products.emulator` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setEmulator(Boolean emulator) {
      this.emulator = emulator;
      return this;
    }

    /**
     * getter for rootApps - Filter events by Rooted Device Detection result.   > Note: When using this parameter, only events with the `products.rootApps.data.result` property set to `true` or `false` are returned. Events without a `products.rootApps` Smart Signal result are left out of the response. 
     */
    public Boolean getRootApps() {
      return rootApps;
    }

    /**
     * setter for rootApps - Filter events by Rooted Device Detection result.   > Note: When using this parameter, only events with the `products.rootApps.data.result` property set to `true` or `false` are returned. Events without a `products.rootApps` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setRootApps(Boolean rootApps) {
      this.rootApps = rootApps;
      return this;
    }

    /**
     * getter for vpnConfidence - Filter events by VPN Detection result confidence level.   `high` - events with high VPN Detection confidence. `medium` - events with medium VPN Detection confidence. `low` - events with low VPN Detection confidence. > Note: When using this parameter, only events with the `products.vpn.data.confidence` property set to a valid value are returned. Events without a `products.vpn` Smart Signal result are left out of the response. 
     */
    public String getVpnConfidence() {
      return vpnConfidence;
    }

    /**
     * setter for vpnConfidence - Filter events by VPN Detection result confidence level.   `high` - events with high VPN Detection confidence. `medium` - events with medium VPN Detection confidence. `low` - events with low VPN Detection confidence. > Note: When using this parameter, only events with the `products.vpn.data.confidence` property set to a valid value are returned. Events without a `products.vpn` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setVpnConfidence(String vpnConfidence) {
      this.vpnConfidence = vpnConfidence;
      return this;
    }

    /**
     * getter for minSuspectScore - Filter events with Suspect Score result above a provided minimum threshold. > Note: When using this parameter, only events where the `products.suspectScore.data.result` property set to a value exceeding your threshold are returned. Events without a `products.suspectScore` Smart Signal result are left out of the response. 
     */
    public Float getMinSuspectScore() {
      return minSuspectScore;
    }

    /**
     * setter for minSuspectScore - Filter events with Suspect Score result above a provided minimum threshold. > Note: When using this parameter, only events where the `products.suspectScore.data.result` property set to a value exceeding your threshold are returned. Events without a `products.suspectScore` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setMinSuspectScore(Float minSuspectScore) {
      this.minSuspectScore = minSuspectScore;
      return this;
    }

    /**
     * getter for ipBlocklist - Filter events by IP Blocklist Detection result.   > Note: When using this parameter, only events with the `products.ipBlocklist.data.result` property set to `true` or `false` are returned. Events without a `products.ipBlocklist` Smart Signal result are left out of the response. 
     */
    public Boolean getIpBlocklist() {
      return ipBlocklist;
    }

    /**
     * setter for ipBlocklist - Filter events by IP Blocklist Detection result.   > Note: When using this parameter, only events with the `products.ipBlocklist.data.result` property set to `true` or `false` are returned. Events without a `products.ipBlocklist` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setIpBlocklist(Boolean ipBlocklist) {
      this.ipBlocklist = ipBlocklist;
      return this;
    }

    /**
     * getter for datacenter - Filter events by Datacenter Detection result.   > Note: When using this parameter, only events with the `products.ipInfo.data.v4.datacenter.result` or `products.ipInfo.data.v6.datacenter.result` property set to `true` or `false` are returned. Events without a `products.ipInfo` Smart Signal result are left out of the response. 
     */
    public Boolean getDatacenter() {
      return datacenter;
    }

    /**
     * setter for datacenter - Filter events by Datacenter Detection result.   > Note: When using this parameter, only events with the `products.ipInfo.data.v4.datacenter.result` or `products.ipInfo.data.v6.datacenter.result` property set to `true` or `false` are returned. Events without a `products.ipInfo` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setDatacenter(Boolean datacenter) {
      this.datacenter = datacenter;
      return this;
    }

    /**
     * getter for developerTools - Filter events by Developer Tools detection result. > Note: When using this parameter, only events with the `products.developerTools.data.result` property set to `true` or `false` are returned. Events without a `products.developerTools` Smart Signal result are left out of the response. 
     */
    public Boolean getDeveloperTools() {
      return developerTools;
    }

    /**
     * setter for developerTools - Filter events by Developer Tools detection result. > Note: When using this parameter, only events with the `products.developerTools.data.result` property set to `true` or `false` are returned. Events without a `products.developerTools` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setDeveloperTools(Boolean developerTools) {
      this.developerTools = developerTools;
      return this;
    }

    /**
     * getter for locationSpoofing - Filter events by Location Spoofing detection result. > Note: When using this parameter, only events with the `products.locationSpoofing.data.result` property set to `true` or `false` are returned. Events without a `products.locationSpoofing` Smart Signal result are left out of the response. 
     */
    public Boolean getLocationSpoofing() {
      return locationSpoofing;
    }

    /**
     * setter for locationSpoofing - Filter events by Location Spoofing detection result. > Note: When using this parameter, only events with the `products.locationSpoofing.data.result` property set to `true` or `false` are returned. Events without a `products.locationSpoofing` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setLocationSpoofing(Boolean locationSpoofing) {
      this.locationSpoofing = locationSpoofing;
      return this;
    }

    /**
     * getter for mitmAttack - Filter events by MITM (Man-in-the-Middle) Attack detection result. > Note: When using this parameter, only events with the `products.mitmAttack.data.result` property set to `true` or `false` are returned. Events without a `products.mitmAttack` Smart Signal result are left out of the response. 
     */
    public Boolean getMitmAttack() {
      return mitmAttack;
    }

    /**
     * setter for mitmAttack - Filter events by MITM (Man-in-the-Middle) Attack detection result. > Note: When using this parameter, only events with the `products.mitmAttack.data.result` property set to `true` or `false` are returned. Events without a `products.mitmAttack` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setMitmAttack(Boolean mitmAttack) {
      this.mitmAttack = mitmAttack;
      return this;
    }

    /**
     * getter for proxy - Filter events by Proxy detection result. > Note: When using this parameter, only events with the `products.proxy.data.result` property set to `true` or `false` are returned. Events without a `products.proxy` Smart Signal result are left out of the response. 
     */
    public Boolean getProxy() {
      return proxy;
    }

    /**
     * setter for proxy - Filter events by Proxy detection result. > Note: When using this parameter, only events with the `products.proxy.data.result` property set to `true` or `false` are returned. Events without a `products.proxy` Smart Signal result are left out of the response. 
     */
    public SearchEventsOptionalParams setProxy(Boolean proxy) {
      this.proxy = proxy;
      return this;
    }

    /**
     * getter for sdkVersion - Filter events by a specific SDK version associated with the identification event. Example: `3.11.14` 
     */
    public String getSdkVersion() {
      return sdkVersion;
    }

    /**
     * setter for sdkVersion - Filter events by a specific SDK version associated with the identification event. Example: `3.11.14` 
     */
    public SearchEventsOptionalParams setSdkVersion(String sdkVersion) {
      this.sdkVersion = sdkVersion;
      return this;
    }

    /**
     * getter for sdkPlatform - Filter events by the SDK Platform associated with the identification event. `js` - JavaScript agent (Web). `ios` - Apple iOS based devices. `android` - Android based devices. 
     */
    public String getSdkPlatform() {
      return sdkPlatform;
    }

    /**
     * setter for sdkPlatform - Filter events by the SDK Platform associated with the identification event. `js` - JavaScript agent (Web). `ios` - Apple iOS based devices. `android` - Android based devices. 
     */
    public SearchEventsOptionalParams setSdkPlatform(String sdkPlatform) {
      this.sdkPlatform = sdkPlatform;
      return this;
    }

    /**
     * getter for environment - Filter for events by providing one or more environment IDs. 
     */
    public List<String> getEnvironment() {
      return environment;
    }

    /**
     * setter for environment - Filter for events by providing one or more environment IDs. 
     */
    public SearchEventsOptionalParams setEnvironment(List<String> environment) {
      this.environment = environment;
      return this;
    }

    /**
     * getter for proximityId - Filter events by the most precise Proximity ID provided by default. > Note: When using this parameter, only events with the `products.proximity.id` property matching the provided ID are returned. Events without a `products.proximity` result are left out of the response. 
     */
    public String getProximityId() {
      return proximityId;
    }

    /**
     * setter for proximityId - Filter events by the most precise Proximity ID provided by default. > Note: When using this parameter, only events with the `products.proximity.id` property matching the provided ID are returned. Events without a `products.proximity` result are left out of the response. 
     */
    public SearchEventsOptionalParams setProximityId(String proximityId) {
      this.proximityId = proximityId;
      return this;
    }

    /**
     * getter for proximityPrecisionRadius - Filter events by Proximity Radius. > Note: When using this parameter, only events with the `products.proximity.precisionRadius` property set to a valid value are returned. Events without a `products.proximity` result are left out of the response. 
     */
    public Integer getProximityPrecisionRadius() {
      return proximityPrecisionRadius;
    }

    /**
     * setter for proximityPrecisionRadius - Filter events by Proximity Radius. > Note: When using this parameter, only events with the `products.proximity.precisionRadius` property set to a valid value are returned. Events without a `products.proximity` result are left out of the response. 
     */
    public SearchEventsOptionalParams setProximityPrecisionRadius(Integer proximityPrecisionRadius) {
      this.proximityPrecisionRadius = proximityPrecisionRadius;
      return this;
    }

  }
  /**
   * Get events via search
   * Search for identification events, including Smart Signals, using multiple filtering criteria. If you don't provide `start` or `end` parameters, the default search range is the last 7 days.  Please note that events include mobile signals (e.g. `rootApps`) even if the request originated from a non-mobile platform. We recommend you **ignore** mobile signals for such requests. 
   * @param limit Limit the number of events returned.  (required)
   * @param searchEventsOptionalParams Object containing optional parameters for API method.  (optional)
   * @return SearchEventsResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Events matching the filter(s). </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. One or more supplied search parameters are invalid, or a required parameter is missing. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
     </table>
   */
  public SearchEventsResponse searchEvents(Integer limit, SearchEventsOptionalParams searchEventsOptionalParams) throws ApiException {
    return searchEventsWithHttpInfo(limit, searchEventsOptionalParams).getData();
  }

  /**
   * Get events via search
   * Search for identification events, including Smart Signals, using multiple filtering criteria. If you don't provide `start` or `end` parameters, the default search range is the last 7 days.  Please note that events include mobile signals (e.g. `rootApps`) even if the request originated from a non-mobile platform. We recommend you **ignore** mobile signals for such requests. 
   * @param limit Limit the number of events returned.  (required)
   * @param searchEventsOptionalParams Object containing optional parameters for API method.  (optional)
   * @return ApiResponse<SearchEventsResponse>
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Events matching the filter(s). </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. One or more supplied search parameters are invalid, or a required parameter is missing. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SearchEventsResponse> searchEventsWithHttpInfo(Integer limit, SearchEventsOptionalParams searchEventsOptionalParams) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'limit' is set
    if (limit == null) {
      throw new ApiException(400, "Missing the required parameter 'limit' when calling searchEvents");
    }
    
    // create path and map variables
    String localVarPath = "/events/search";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.add(new Pair("ii", INTEGRATION_INFO));

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    if (searchEventsOptionalParams != null) {
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "pagination_key", searchEventsOptionalParams.getPaginationKey()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "visitor_id", searchEventsOptionalParams.getVisitorId()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "bot", searchEventsOptionalParams.getBot()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "ip_address", searchEventsOptionalParams.getIpAddress()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "linked_id", searchEventsOptionalParams.getLinkedId()));
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
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "ip_blocklist", searchEventsOptionalParams.getIpBlocklist()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "datacenter", searchEventsOptionalParams.getDatacenter()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "developer_tools", searchEventsOptionalParams.getDeveloperTools()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "location_spoofing", searchEventsOptionalParams.getLocationSpoofing()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "mitm_attack", searchEventsOptionalParams.getMitmAttack()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "proxy", searchEventsOptionalParams.getProxy()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "sdk_version", searchEventsOptionalParams.getSdkVersion()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "sdk_platform", searchEventsOptionalParams.getSdkPlatform()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "environment", searchEventsOptionalParams.getEnvironment()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "proximity_id", searchEventsOptionalParams.getProximityId()));
      localVarQueryParams.addAll(apiClient.parameterToPairs("", "proximity_precision_radius", searchEventsOptionalParams.getProximityPrecisionRadius()));
    }

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "ApiKeyHeader", "ApiKeyQuery" };

    GenericType<SearchEventsResponse> localVarReturnType = new GenericType<SearchEventsResponse>() {};

    return apiClient.invokeAPI("FingerprintApi.searchEvents", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update an event with a given request ID
   * Change information in existing events specified by `requestId` or *flag suspicious events*.  When an event is created, it is assigned `linkedId` and `tag` submitted through the JS agent parameters. This information might not be available on the client so the Server API allows for updating the attributes after the fact.  **Warning** It's not possible to update events older than 10 days. 
   * @param requestId The unique event [identifier](https://dev.fingerprint.com/reference/get-function#requestid). (required)
   * @param eventsUpdateRequest  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. The request payload is not valid. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found. The request ID cannot be found in this application&#39;s data. </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict. The event is not mutable yet. </td><td>  -  </td></tr>
     </table>
   */
  public void updateEvent(String requestId, EventsUpdateRequest eventsUpdateRequest) throws ApiException {
    updateEventWithHttpInfo(requestId, eventsUpdateRequest);
  }

  /**
   * Update an event with a given request ID
   * Change information in existing events specified by `requestId` or *flag suspicious events*.  When an event is created, it is assigned `linkedId` and `tag` submitted through the JS agent parameters. This information might not be available on the client so the Server API allows for updating the attributes after the fact.  **Warning** It's not possible to update events older than 10 days. 
   * @param requestId The unique event [identifier](https://dev.fingerprint.com/reference/get-function#requestid). (required)
   * @param eventsUpdateRequest  (required)
   * @return ApiResponse<Void>
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. The request payload is not valid. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found. The request ID cannot be found in this application&#39;s data. </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict. The event is not mutable yet. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateEventWithHttpInfo(String requestId, EventsUpdateRequest eventsUpdateRequest) throws ApiException {
    Object localVarPostBody = eventsUpdateRequest;
    
    // verify the required parameter 'requestId' is set
    if (requestId == null) {
      throw new ApiException(400, "Missing the required parameter 'requestId' when calling updateEvent");
    }
    
    // verify the required parameter 'eventsUpdateRequest' is set
    if (eventsUpdateRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'eventsUpdateRequest' when calling updateEvent");
    }
    
    // create path and map variables
    String localVarPath = "/events/{request_id}"
      .replaceAll("\\{" + "request_id" + "\\}", apiClient.escapeString(requestId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.add(new Pair("ii", INTEGRATION_INFO));


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "ApiKeyHeader", "ApiKeyQuery" };

    return apiClient.invokeAPI("FingerprintApi.updateEvent", localVarPath, "PUT", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Dummy path to describe webhook format.
   * Fake path to describe webhook format. More information about webhooks can be found in the [documentation](https://dev.fingerprint.com/docs/webhooks)
   * @param webhook  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 0 </td><td> Dummy for the schema </td><td>  -  </td></tr>
     </table>
   */
  public void webhookTrace(Webhook webhook) throws ApiException {
    webhookTraceWithHttpInfo(webhook);
  }

  /**
   * Dummy path to describe webhook format.
   * Fake path to describe webhook format. More information about webhooks can be found in the [documentation](https://dev.fingerprint.com/docs/webhooks)
   * @param webhook  (optional)
   * @return ApiResponse<Void>
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 0 </td><td> Dummy for the schema </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> webhookTraceWithHttpInfo(Webhook webhook) throws ApiException {
    Object localVarPostBody = webhook;
    
    // create path and map variables
    String localVarPath = "/webhook";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.add(new Pair("ii", INTEGRATION_INFO));


    
    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "ApiKeyHeader", "ApiKeyQuery" };

    return apiClient.invokeAPI("FingerprintApi.webhookTrace", localVarPath, "TRACE", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
