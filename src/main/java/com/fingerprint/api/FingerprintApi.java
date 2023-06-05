package com.fingerprint.api;

import com.fingerprint.sdk.ApiException;
import com.fingerprint.sdk.ApiClient;
import com.fingerprint.sdk.ApiResponse;
import com.fingerprint.sdk.Configuration;
import com.fingerprint.sdk.Pair;
import com.fingerprint.sdk.Region;

import javax.ws.rs.core.GenericType;

import com.fingerprint.model.ErrorEvent403Response;
import com.fingerprint.model.ErrorEvent404Response;
import com.fingerprint.model.ErrorVisits403;
import com.fingerprint.model.EventResponse;
import com.fingerprint.model.ManyRequestsResponse;
import com.fingerprint.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class FingerprintApi {
  public static final String INTEGRATION_INFO = "fingerprint-pro-server-java-sdk/dev-2.0.0-2";
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
   * Get event by requestId
   * This endpoint allows you to retrieve an individual analysis event with all the information from each activated product (Identification, Bot Detection, and others). Products that are not activated for your application or not relevant to the event&#39;s detected platform (web, iOS, Android) are not included in the response.   Use &#x60;requestId&#x60; as the URL path parameter. This API method is scoped to a request, i.e. all returned information is by &#x60;requestId&#x60;. 
   * @param requestId The unique [identifier](https://dev.fingerprint.com/docs/js-agent#requestid) of each analysis request. (required)
   * @return EventResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
     </table>
   */
  public EventResponse getEvent(String requestId) throws ApiException {
    return getEventWithHttpInfo(requestId).getData();
  }

  /**
   * Get event by requestId
   * This endpoint allows you to retrieve an individual analysis event with all the information from each activated product (Identification, Bot Detection, and others). Products that are not activated for your application or not relevant to the event&#39;s detected platform (web, iOS, Android) are not included in the response.   Use &#x60;requestId&#x60; as the URL path parameter. This API method is scoped to a request, i.e. all returned information is by &#x60;requestId&#x60;. 
   * @param requestId The unique [identifier](https://dev.fingerprint.com/docs/js-agent#requestid) of each analysis request. (required)
   * @return ApiResponse&lt;EventResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<EventResponse> getEventWithHttpInfo(String requestId) throws ApiException {
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

    GenericType<EventResponse> localVarReturnType = new GenericType<EventResponse>() {};

    return apiClient.invokeAPI("FingerprintApi.getEvent", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get visits by visitorId
   * This endpoint allows you to get a history of visits for a specific &#x60;visitorId&#x60;. Use the &#x60;visitorId&#x60; as a URL path parameter. Only information from the _Identification_ product is returned.  #### Headers  * &#x60;Retry-After&#x60; — Present in case of &#x60;429 Too many requests&#x60;. Indicates how long you should wait before making a follow-up request. The value is non-negative decimal integer indicating the seconds to delay after the response is received. 
   * @param visitorId Unique identifier of the visitor issued by Fingerprint Pro. (required)
   * @param requestId Filter visits by &#x60;requestId&#x60;.   Every identification request has a unique identifier associated with it called &#x60;requestId&#x60;. This identifier is returned to the client in the identification [result](https://dev.fingerprint.com/docs/js-agent#requestid). When you filter visits by &#x60;requestId&#x60;, only one visit will be returned.  (optional)
   * @param linkedId Filter visits by your custom identifier.   You can use [&#x60;linkedId&#x60;](https://dev.fingerprint.com/docs/js-agent#linkedid) to associate identification requests with your own identifier, for example: session ID, purchase ID, or transaction ID. You can then use this &#x60;linked_id&#x60; parameter to retrieve all events associated with your custom identifier.  (optional)
   * @param limit Limit scanned results.   For performance reasons, the API first scans some number of events before filtering them. Use &#x60;limit&#x60; to specify how many events are scanned before they are filtered by &#x60;requestId&#x60; or &#x60;linkedId&#x60;. Results are always returned sorted by the timestamp (most recent first). By default, the most recent 100 visits are scanned, the maximum is 500.  (optional)
   * @param paginationKey Use &#x60;paginationKey&#x60; to get the next page of results.   When more results are available (e.g., you requested 200 results using &#x60;limit&#x60; parameter, but a total of 600 results are available), the &#x60;paginationKey&#x60; top-level attribute is added to the response. The key corresponds to the &#x60;requestId&#x60; of the last returned event. In the following request, use that value in the &#x60;paginationKey&#x60; parameter to get the next page of results:  1. First request, returning most recent 200 events: &#x60;GET api-base-url/visitors/:visitorId?limit&#x3D;200&#x60; 2. Use &#x60;response.paginationKey&#x60; to get the next page of results: &#x60;GET api-base-url/visitors/:visitorId?limit&#x3D;200&amp;paginationKey&#x3D;1683900801733.Ogvu1j&#x60;  Pagination happens during scanning and before filtering, so you can get less visits than the &#x60;limit&#x60; you specified with more available on the next page. When there are no more results available for scanning, the &#x60;paginationKey&#x60; attribute is not returned.  (optional)
   * @param before ⚠️ Deprecated pagination method, please use &#x60;paginationKey&#x60; instead. Timestamp (in milliseconds since epoch) used to paginate results.  (optional)
   * @return Response
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. The API Key is probably missing or incorrect. </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too Many Requests </td><td>  * Retry-After - Indicates how long you should wait before attempting the next request. <br>  </td></tr>
     </table>
   */
  public Response getVisits(String visitorId, String requestId, String linkedId, Integer limit, String paginationKey, Long before) throws ApiException {
    return getVisitsWithHttpInfo(visitorId, requestId, linkedId, limit, paginationKey, before).getData();
  }

  /**
   * Get visits by visitorId
   * This endpoint allows you to get a history of visits for a specific &#x60;visitorId&#x60;. Use the &#x60;visitorId&#x60; as a URL path parameter. Only information from the _Identification_ product is returned.  #### Headers  * &#x60;Retry-After&#x60; — Present in case of &#x60;429 Too many requests&#x60;. Indicates how long you should wait before making a follow-up request. The value is non-negative decimal integer indicating the seconds to delay after the response is received. 
   * @param visitorId Unique identifier of the visitor issued by Fingerprint Pro. (required)
   * @param requestId Filter visits by &#x60;requestId&#x60;.   Every identification request has a unique identifier associated with it called &#x60;requestId&#x60;. This identifier is returned to the client in the identification [result](https://dev.fingerprint.com/docs/js-agent#requestid). When you filter visits by &#x60;requestId&#x60;, only one visit will be returned.  (optional)
   * @param linkedId Filter visits by your custom identifier.   You can use [&#x60;linkedId&#x60;](https://dev.fingerprint.com/docs/js-agent#linkedid) to associate identification requests with your own identifier, for example: session ID, purchase ID, or transaction ID. You can then use this &#x60;linked_id&#x60; parameter to retrieve all events associated with your custom identifier.  (optional)
   * @param limit Limit scanned results.   For performance reasons, the API first scans some number of events before filtering them. Use &#x60;limit&#x60; to specify how many events are scanned before they are filtered by &#x60;requestId&#x60; or &#x60;linkedId&#x60;. Results are always returned sorted by the timestamp (most recent first). By default, the most recent 100 visits are scanned, the maximum is 500.  (optional)
   * @param paginationKey Use &#x60;paginationKey&#x60; to get the next page of results.   When more results are available (e.g., you requested 200 results using &#x60;limit&#x60; parameter, but a total of 600 results are available), the &#x60;paginationKey&#x60; top-level attribute is added to the response. The key corresponds to the &#x60;requestId&#x60; of the last returned event. In the following request, use that value in the &#x60;paginationKey&#x60; parameter to get the next page of results:  1. First request, returning most recent 200 events: &#x60;GET api-base-url/visitors/:visitorId?limit&#x3D;200&#x60; 2. Use &#x60;response.paginationKey&#x60; to get the next page of results: &#x60;GET api-base-url/visitors/:visitorId?limit&#x3D;200&amp;paginationKey&#x3D;1683900801733.Ogvu1j&#x60;  Pagination happens during scanning and before filtering, so you can get less visits than the &#x60;limit&#x60; you specified with more available on the next page. When there are no more results available for scanning, the &#x60;paginationKey&#x60; attribute is not returned.  (optional)
   * @param before ⚠️ Deprecated pagination method, please use &#x60;paginationKey&#x60; instead. Timestamp (in milliseconds since epoch) used to paginate results.  (optional)
   * @return ApiResponse&lt;Response&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. The API Key is probably missing or incorrect. </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too Many Requests </td><td>  * Retry-After - Indicates how long you should wait before attempting the next request. <br>  </td></tr>
     </table>
   */
  public ApiResponse<Response> getVisitsWithHttpInfo(String visitorId, String requestId, String linkedId, Integer limit, String paginationKey, Long before) throws ApiException {
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

    GenericType<Response> localVarReturnType = new GenericType<Response>() {};

    return apiClient.invokeAPI("FingerprintApi.getVisits", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Fake path to describe webhook format. More information about webhooks can be found in the [documentation](https://dev.fingerprint.com/docs/webhooks)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 0 </td><td> Dummy for the schema </td><td>  -  </td></tr>
     </table>
   */
  public void webhookTrace() throws ApiException {
    webhookTraceWithHttpInfo();
  }

  /**
   * 
   * Fake path to describe webhook format. More information about webhooks can be found in the [documentation](https://dev.fingerprint.com/docs/webhooks)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 0 </td><td> Dummy for the schema </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> webhookTraceWithHttpInfo() throws ApiException {
    Object localVarPostBody = null;
    
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
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "ApiKeyHeader", "ApiKeyQuery" };

    return apiClient.invokeAPI("FingerprintApi.webhookTrace", localVarPath, "TRACE", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
