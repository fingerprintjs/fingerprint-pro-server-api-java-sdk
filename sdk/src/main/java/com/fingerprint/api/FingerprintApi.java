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
  public static final String INTEGRATION_INFO = "fingerprint-pro-server-java-sdk/7.3.0-develop.0";
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
   * Request deleting all data associated with the specified visitor ID. This API is useful for compliance with privacy regulations. ### Which data is deleted? - Browser (or device) properties - Identification requests made from this browser (or device)  #### Browser (or device) properties - Represents the data that Fingerprint collected from this specific browser (or device) and everything inferred and derived from it. - Upon request to delete, this data is deleted asynchronously (typically within a few minutes) and it will no longer be used to identify this browser (or device) for your [Fingerprint Application](https://dev.fingerprint.com/docs/glossary#fingerprint-application).  #### Identification requests made from this browser (or device) - Fingerprint stores the identification requests made from a browser (or device) for up to 30 (or 90) days depending on your plan. To learn more, see [Data Retention](https://dev.fingerprint.com/docs/regions#data-retention). - Upon request to delete, the identification requests that were made by this browser   - Within the past 10 days are deleted within 24 hrs.   - Outside of 10 days are allowed to purge as per your data retention period.  ### Corollary After requesting to delete a visitor ID, - If the same browser (or device) requests to identify, it will receive a different visitor ID. - If you request [`/events` API](https://dev.fingerprint.com/reference/getevent) with a `request_id` that was made outside of the 10 days, you will still receive a valid response. - If you request [`/visitors` API](https://dev.fingerprint.com/reference/getvisits) for the deleted visitor ID, the response will include identification requests that were made outside of those 10 days.  ### Interested? Please [contact our support team](https://fingerprint.com/support/) to enable it for you. Otherwise, you will receive a 403. 
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
   * Request deleting all data associated with the specified visitor ID. This API is useful for compliance with privacy regulations. ### Which data is deleted? - Browser (or device) properties - Identification requests made from this browser (or device)  #### Browser (or device) properties - Represents the data that Fingerprint collected from this specific browser (or device) and everything inferred and derived from it. - Upon request to delete, this data is deleted asynchronously (typically within a few minutes) and it will no longer be used to identify this browser (or device) for your [Fingerprint Application](https://dev.fingerprint.com/docs/glossary#fingerprint-application).  #### Identification requests made from this browser (or device) - Fingerprint stores the identification requests made from a browser (or device) for up to 30 (or 90) days depending on your plan. To learn more, see [Data Retention](https://dev.fingerprint.com/docs/regions#data-retention). - Upon request to delete, the identification requests that were made by this browser   - Within the past 10 days are deleted within 24 hrs.   - Outside of 10 days are allowed to purge as per your data retention period.  ### Corollary After requesting to delete a visitor ID, - If the same browser (or device) requests to identify, it will receive a different visitor ID. - If you request [`/events` API](https://dev.fingerprint.com/reference/getevent) with a `request_id` that was made outside of the 10 days, you will still receive a valid response. - If you request [`/visitors` API](https://dev.fingerprint.com/reference/getvisits) for the deleted visitor ID, the response will include identification requests that were made outside of those 10 days.  ### Interested? Please [contact our support team](https://fingerprint.com/support/) to enable it for you. Otherwise, you will receive a 403. 
   * @param visitorId The [visitor ID](https://dev.fingerprint.com/reference/get-function#visitorid) you want to delete. (required)
   * @return ApiResponse&lt;Void&gt;
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
   * @return ApiResponse&lt;EventsGetResponse&gt;
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
   * @return ApiResponse&lt;RelatedVisitorsResponse&gt;
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
   * @return ApiResponse&lt;VisitorsGetResponse&gt;
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
  /**
   * Get events via search
   * Search for identification events, including Smart Signals, using multiple filtering criteria. If you don't provide `start` or `end` parameters, the default search range is the last 7 days.  Please note that events include mobile signals (e.g. `rootApps`) even if the request originated from a non-mobile platform. We recommend you **ignore** mobile signals for such requests. 
   * @param limit Limit the number of events returned.  (required)
   * @param visitorId Unique [visitor identifier](https://dev.fingerprint.com/reference/get-function#visitorid) issued by Fingerprint Pro. Filter for events matching this `visitor_id`.  (optional)
   * @param bot Filter events by the bot detection result, specifically:    - events where any kind of bot was detected.   - events where a good bot was detected.   - events where a bad bot was detected.   - events where no bot was detected.  (optional)
   * @param ipAddress Filter events by IP address range. The range can be as specific as a single IP (/32 for IPv4 or /128 for IPv6)  All ip_address filters must use CIDR notation, for example, 10.0.0.0/24, 192.168.0.1/32  (optional)
   * @param linkedId Filter events by your custom identifier.   You can use [linked IDs](https://dev.fingerprint.com/reference/get-function#linkedid) to associate identification requests with your own identifier, for example, session ID, purchase ID, or transaction ID. You can then use this `linked_id` parameter to retrieve all events associated with your custom identifier.  (optional)
   * @param start Filter events with a timestamp greater than the start time, in Unix time (milliseconds).  (optional)
   * @param end Filter events with a timestamp smaller than the end time, in Unix time (milliseconds).  (optional)
   * @param reverse Sort events in reverse timestamp order.  (optional)
   * @param suspect Filter events previously tagged as suspicious via the [Update API](https://dev.fingerprint.com/reference/updateevent).  (optional)
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
  public SearchEventsResponse searchEvents(Integer limit, String visitorId, String bot, String ipAddress, String linkedId, Long start, Long end, Boolean reverse, Boolean suspect) throws ApiException {
    return searchEventsWithHttpInfo(limit, visitorId, bot, ipAddress, linkedId, start, end, reverse, suspect).getData();
  }

  /**
   * Get events via search
   * Search for identification events, including Smart Signals, using multiple filtering criteria. If you don't provide `start` or `end` parameters, the default search range is the last 7 days.  Please note that events include mobile signals (e.g. `rootApps`) even if the request originated from a non-mobile platform. We recommend you **ignore** mobile signals for such requests. 
   * @param limit Limit the number of events returned.  (required)
   * @param visitorId Unique [visitor identifier](https://dev.fingerprint.com/reference/get-function#visitorid) issued by Fingerprint Pro. Filter for events matching this `visitor_id`.  (optional)
   * @param bot Filter events by the bot detection result, specifically:    - events where any kind of bot was detected.   - events where a good bot was detected.   - events where a bad bot was detected.   - events where no bot was detected.  (optional)
   * @param ipAddress Filter events by IP address range. The range can be as specific as a single IP (/32 for IPv4 or /128 for IPv6)  All ip_address filters must use CIDR notation, for example, 10.0.0.0/24, 192.168.0.1/32  (optional)
   * @param linkedId Filter events by your custom identifier.   You can use [linked IDs](https://dev.fingerprint.com/reference/get-function#linkedid) to associate identification requests with your own identifier, for example, session ID, purchase ID, or transaction ID. You can then use this `linked_id` parameter to retrieve all events associated with your custom identifier.  (optional)
   * @param start Filter events with a timestamp greater than the start time, in Unix time (milliseconds).  (optional)
   * @param end Filter events with a timestamp smaller than the end time, in Unix time (milliseconds).  (optional)
   * @param reverse Sort events in reverse timestamp order.  (optional)
   * @param suspect Filter events previously tagged as suspicious via the [Update API](https://dev.fingerprint.com/reference/updateevent).  (optional)
   * @return ApiResponse&lt;SearchEventsResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Events matching the filter(s). </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request. One or more supplied search parameters are invalid, or a required parameter is missing. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Access to this API is denied. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SearchEventsResponse> searchEventsWithHttpInfo(Integer limit, String visitorId, String bot, String ipAddress, String linkedId, Long start, Long end, Boolean reverse, Boolean suspect) throws ApiException {
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
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "visitor_id", visitorId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "bot", bot));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ip_address", ipAddress));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "linked_id", linkedId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "start", start));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "end", end));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "reverse", reverse));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "suspect", suspect));

    
    
    
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
   * @return ApiResponse&lt;Void&gt;
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
   * 
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
   * 
   * Fake path to describe webhook format. More information about webhooks can be found in the [documentation](https://dev.fingerprint.com/docs/webhooks)
   * @param webhook  (optional)
   * @return ApiResponse&lt;Void&gt;
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
