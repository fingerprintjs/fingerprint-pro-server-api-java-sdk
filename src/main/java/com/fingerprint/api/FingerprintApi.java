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
  public static final String INTEGRATION_INFO = "fingerprint-pro-server-java-sdk/dev-1.0.0-2";
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
   * This endpoint allows you to get events with all the information from each activated product (Fingerprint Pro or Bot Detection). Use the requestId as a URL path :request_id parameter. This API method is scoped to a request, i.e. all returned information is by requestId.
   * @param requestId requestId is the unique identifier of each request (required)
   * @return EventResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
   */
  public EventResponse getEvent(String requestId) throws ApiException {
    return getEventWithHttpInfo(requestId).getData();
  }

  /**
   * Get event by requestId
   * This endpoint allows you to get events with all the information from each activated product (Fingerprint Pro or Bot Detection). Use the requestId as a URL path :request_id parameter. This API method is scoped to a request, i.e. all returned information is by requestId.
   * @param requestId requestId is the unique identifier of each request (required)
   * @return ApiResponse&lt;EventResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Bad Request </td><td>  -  </td></tr>
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
   * This endpoint allows you to get a history of visits with all available information. Use the visitorId as a URL path parameter. This API method is scoped to a visitor, i.e. all returned information is by visitorId.
   * @param visitorId  (required)
   * @param requestId Filter visits by requestId (optional)
   * @param linkedId Filter visits by custom identifier (optional)
   * @param limit Limit scanned results (optional)
   * @param before Used to paginate results (optional)
   * @return Response
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Probably ApiKey is missed or provided the wrong one. </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too Many Requests </td><td>  * Retry-After - Indicates how long the user should wait before attempting the next request. <br>  </td></tr>
     </table>
   */
  public Response getVisits(String visitorId, String requestId, String linkedId, Integer limit, Integer before) throws ApiException {
    return getVisitsWithHttpInfo(visitorId, requestId, linkedId, limit, before).getData();
  }

  /**
   * Get visits by visitorId
   * This endpoint allows you to get a history of visits with all available information. Use the visitorId as a URL path parameter. This API method is scoped to a visitor, i.e. all returned information is by visitorId.
   * @param visitorId  (required)
   * @param requestId Filter visits by requestId (optional)
   * @param linkedId Filter visits by custom identifier (optional)
   * @param limit Limit scanned results (optional)
   * @param before Used to paginate results (optional)
   * @return ApiResponse&lt;Response&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden. Probably ApiKey is missed or provided the wrong one. </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too Many Requests </td><td>  * Retry-After - Indicates how long the user should wait before attempting the next request. <br>  </td></tr>
     </table>
   */
  public ApiResponse<Response> getVisitsWithHttpInfo(String visitorId, String requestId, String linkedId, Integer limit, Integer before) throws ApiException {
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
   */
  public void webhookTrace() throws ApiException {
    webhookTraceWithHttpInfo();
  }

  /**
   * 
   * Fake path to describe webhook format. More information about webhooks can be found in the [documentation](https://dev.fingerprint.com/docs/webhooks)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
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
