package com.fingerprint.sdk;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.client.HttpUrlConnectorProvider;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import java.io.IOException;
import java.io.InputStream;

import java.net.URI;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.glassfish.jersey.logging.LoggingFeature;
import java.util.AbstractMap.SimpleEntry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.OffsetDateTime;

import java.net.URLEncoder;

import java.io.File;
import java.io.UnsupportedEncodingException;

import java.text.DateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fingerprint.sdk.auth.Authentication;
import com.fingerprint.sdk.auth.HttpBasicAuth;
import com.fingerprint.sdk.auth.HttpBearerAuth;
import com.fingerprint.sdk.auth.ApiKeyAuth;

/**
 * <p>ApiClient class.</p>
 */
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class ApiClient extends JavaTimeFormatter {
  private static final Pattern JSON_MIME_PATTERN = Pattern.compile("(?i)^(application/json|[^;/ \t]+/[^;/ \t]+[+]json)[ \t]*(;.*)?$");

  protected Map<String, String> defaultHeaderMap = new HashMap<>();
  protected Map<String, String> defaultCookieMap = new HashMap<>();
  protected String basePath = "https://api.fpjs.io";
  protected String userAgent;
  private static final Logger log = Logger.getLogger(ApiClient.class.getName());

  protected List<ServerConfiguration> servers = new ArrayList<>(Arrays.asList(
          new ServerConfiguration(
                  "https://api.fpjs.io",
                  "Global",
                  new LinkedHashMap<>()
          ),
          new ServerConfiguration(
                  "https://eu.api.fpjs.io",
                  "EU",
                  new LinkedHashMap<>()
          ),
          new ServerConfiguration(
                  "https://ap.api.fpjs.io",
                  "Asia (Mumbai)",
                  new LinkedHashMap<>()
          )
  ));
  protected Integer serverIndex = 0;
  protected Map<String, String> serverVariables = null;
  protected Map<String, List<ServerConfiguration>> operationServers = new HashMap<>();
  protected Map<String, Integer> operationServerIndex = new HashMap<>();
  protected Map<String, Map<String, String>> operationServerVariables = new HashMap<>();
  protected boolean debugging = false;
  protected ClientConfig clientConfig;
  protected int connectionTimeout = 0;
  private int readTimeout = 0;

  protected Client httpClient;
  protected JSON json;
  protected String tempFolderPath = null;

  protected Map<String, Authentication> authentications;
  protected Map<String, String> authenticationLookup;

  protected DateFormat dateFormat;

  /**
   * Constructs a new ApiClient with default parameters.
   */
  public ApiClient() {
    this(null);
  }

  /**
   * Constructs a new ApiClient with the specified authentication parameters.
   *
   * @param authMap A hash map containing authentication parameters.
   */
  public ApiClient(Map<String, Authentication> authMap) {
    json = new JSON();
    httpClient = buildHttpClient();

    this.dateFormat = new RFC3339DateFormat();

    // Set default User-Agent.
    setUserAgent("OpenAPI-Generator/7.8.0/java");

    // Setup authentications (key: authentication name, value: authentication).
    authentications = new HashMap<>();
    Authentication auth = null;
    if (authMap != null) {
      auth = authMap.get("ApiKeyHeader");
    }
    if (auth instanceof ApiKeyAuth) {
      authentications.put("ApiKeyHeader", auth);
    } else {
      authentications.put("ApiKeyHeader", new ApiKeyAuth("header", "Auth-API-Key"));
    }
    if (authMap != null) {
      auth = authMap.get("ApiKeyQuery");
    }
    if (auth instanceof ApiKeyAuth) {
      authentications.put("ApiKeyQuery", auth);
    } else {
      authentications.put("ApiKeyQuery", new ApiKeyAuth("query", "api_key"));
    }
    // Prevent the authentications from being modified.
    authentications = Collections.unmodifiableMap(authentications);

    // Setup authentication lookup (key: authentication alias, value: authentication name)
    authenticationLookup = new HashMap<>();
  }

  /**
   * Gets the JSON instance to do JSON serialization and deserialization.
   *
   * @return JSON
   */
  public JSON getJSON() {
    return json;
  }

  /**
   * <p>Getter for the field <code>httpClient</code>.</p>
   *
   * @return a {@link jakarta.ws.rs.client.Client} object.
   */
  public Client getHttpClient() {
    return httpClient;
  }

  /**
   * <p>Setter for the field <code>httpClient</code>.</p>
   *
   * @param httpClient a {@link jakarta.ws.rs.client.Client} object.
   * @return a {@link org.openapitools.client.ApiClient} object.
   */
  public ApiClient setHttpClient(Client httpClient) {
    this.httpClient = httpClient;
    return this;
  }

  /**
   * Returns the base URL to the location where the OpenAPI document is being served.
   *
   * @return The base URL to the target host.
   */
  public String getBasePath() {
    return basePath;
  }

  /**
   * Sets the base URL to the location where the OpenAPI document is being served.
   *
   * @param basePath The base URL to the target host.
   * @return a {@link org.openapitools.client.ApiClient} object.
   */
  public ApiClient setBasePath(String basePath) {
    this.basePath = basePath;
    return this;
  }

  /**
   * <p>Getter for the field <code>servers</code>.</p>
   *
   * @return a {@link java.util.List} of servers.
   */
  public List<ServerConfiguration> getServers() {
    return servers;
  }

  /**
   * <p>Setter for the field <code>servers</code>.</p>
   *
   * @param servers a {@link java.util.List} of servers.
   * @return a {@link org.openapitools.client.ApiClient} object.
   */
  public ApiClient setServers(List<ServerConfiguration> servers) {
    this.servers = servers;
    updateBasePath();
    return this;
  }

  /**
   * <p>Getter for the field <code>serverIndex</code>.</p>
   *
   * @return a {@link java.lang.Integer} object.
   */
  public Integer getServerIndex() {
    return serverIndex;
  }

  /**
   * <p>Setter for the field <code>serverIndex</code>.</p>
   *
   * @param serverIndex the server index
   * @return a {@link org.openapitools.client.ApiClient} object.
   */
  public ApiClient setServerIndex(Integer serverIndex) {
    this.serverIndex = serverIndex;
    updateBasePath();
    return this;
  }

  /**
   * <p>Getter for the field <code>serverVariables</code>.</p>
   *
   * @return a {@link java.util.Map} of server variables.
   */
  public Map<String, String> getServerVariables() {
    return serverVariables;
  }

  /**
   * <p>Setter for the field <code>serverVariables</code>.</p>
   *
   * @param serverVariables a {@link java.util.Map} of server variables.
   * @return a {@link org.openapitools.client.ApiClient} object.
   */
  public ApiClient setServerVariables(Map<String, String> serverVariables) {
    this.serverVariables = serverVariables;
    updateBasePath();
    return this;
  }

  private void updateBasePath() {
    if (serverIndex != null) {
        setBasePath(servers.get(serverIndex).URL(serverVariables));
    }
  }

  /**
   * Get authentications (key: authentication name, value: authentication).
   *
   * @return Map of authentication object
   */
  public Map<String, Authentication> getAuthentications() {
    return authentications;
  }

  /**
   * Get authentication for the given name.
   *
   * @param authName The authentication name
   * @return The authentication, null if not found
   */
  public Authentication getAuthentication(String authName) {
    return authentications.get(authName);
  }

  /**
   * Helper method to set username for the first HTTP basic authentication.
   *
   * @param username Username
   * @return a {@link org.openapitools.client.ApiClient} object.
   */
  public ApiClient setUsername(String username) {
    for (Authentication auth : authentications.values()) {
      if (auth instanceof HttpBasicAuth) {
        ((HttpBasicAuth) auth).setUsername(username);
        return this;
      }
    }
    throw new RuntimeException("No HTTP basic authentication configured!");
  }

  /**
   * Helper method to set password for the first HTTP basic authentication.
   *
   * @param password Password
   * @return a {@link org.openapitools.client.ApiClient} object.
   */
  public ApiClient setPassword(String password) {
    for (Authentication auth : authentications.values()) {
      if (auth instanceof HttpBasicAuth) {
        ((HttpBasicAuth) auth).setPassword(password);
        return this;
      }
    }
    throw new RuntimeException("No HTTP basic authentication configured!");
  }

  /**
   * Helper method to set API key value for the first API key authentication.
   *
   * @param apiKey API key
   * @return a {@link org.openapitools.client.ApiClient} object.
   */
  public ApiClient setApiKey(String apiKey) {
    for (Authentication auth : authentications.values()) {
      if (auth instanceof ApiKeyAuth) {
        ((ApiKeyAuth) auth).setApiKey(apiKey);
        return this;
      }
    }
    throw new RuntimeException("No API key authentication configured!");
  }

  /**
   * Helper method to configure authentications which respects aliases of API keys.
   *
   * @param secrets Hash map from authentication name to its secret.
   * @return a {@link org.openapitools.client.ApiClient} object.
   */
  public ApiClient configureApiKeys(Map<String, String> secrets) {
    for (Map.Entry<String, Authentication> authEntry : authentications.entrySet()) {
      Authentication auth = authEntry.getValue();
      if (auth instanceof ApiKeyAuth) {
        String name = authEntry.getKey();
        // respect x-auth-id-alias property
        name = authenticationLookup.getOrDefault(name, name);
        String secret = secrets.get(name);
        if (secret != null) {
          ((ApiKeyAuth) auth).setApiKey(secret);
        }
      }
    }
    return this;
  }

  /**
   * Helper method to set API key prefix for the first API key authentication.
   *
   * @param apiKeyPrefix API key prefix
   * @return a {@link org.openapitools.client.ApiClient} object.
   */
  public ApiClient setApiKeyPrefix(String apiKeyPrefix) {
    for (Authentication auth : authentications.values()) {
      if (auth instanceof ApiKeyAuth) {
        ((ApiKeyAuth) auth).setApiKeyPrefix(apiKeyPrefix);
        return this;
      }
    }
    throw new RuntimeException("No API key authentication configured!");
  }

  /**
   * Helper method to set bearer token for the first Bearer authentication.
   *
   * @param bearerToken Bearer token
   * @return a {@link org.openapitools.client.ApiClient} object.
   */
  public ApiClient setBearerToken(String bearerToken) {
    for (Authentication auth : authentications.values()) {
      if (auth instanceof HttpBearerAuth) {
        ((HttpBearerAuth) auth).setBearerToken(bearerToken);
        return this;
      }
    }
    throw new RuntimeException("No Bearer authentication configured!");
  }

  /**
   * Set the User-Agent header's value (by adding to the default header map).
   *
   * @param userAgent Http user agent
   * @return a {@link org.openapitools.client.ApiClient} object.
   */
  public ApiClient setUserAgent(String userAgent) {
    this.userAgent = userAgent;
    addDefaultHeader("User-Agent", userAgent);
    return this;
  }

  /**
   * Get the User-Agent header's value.
   *
   * @return User-Agent string
   */
  public String getUserAgent(){
    return userAgent;
  }

  /**
   * Add a default header.
   *
   * @param key The header's key
   * @param value The header's value
   * @return a {@link org.openapitools.client.ApiClient} object.
   */
  public ApiClient addDefaultHeader(String key, String value) {
    defaultHeaderMap.put(key, value);
    return this;
  }

  /**
   * Add a default cookie.
   *
   * @param key The cookie's key
   * @param value The cookie's value
   * @return a {@link org.openapitools.client.ApiClient} object.
   */
  public ApiClient addDefaultCookie(String key, String value) {
    defaultCookieMap.put(key, value);
    return this;
  }

  /**
   * Gets the client config.
   *
   * @return Client config
   */
  public ClientConfig getClientConfig() {
    return clientConfig;
  }

  /**
   * Set the client config.
   *
   * @param clientConfig Set the client config
   * @return a {@link org.openapitools.client.ApiClient} object.
   */
  public ApiClient setClientConfig(ClientConfig clientConfig) {
    this.clientConfig = clientConfig;
    // Rebuild HTTP Client according to the new "clientConfig" value.
    this.httpClient = buildHttpClient();
    return this;
  }

  /**
   * Check that whether debugging is enabled for this API client.
   *
   * @return True if debugging is switched on
   */
  public boolean isDebugging() {
    return debugging;
  }

  /**
   * Enable/disable debugging for this API client.
   *
   * @param debugging To enable (true) or disable (false) debugging
   * @return a {@link org.openapitools.client.ApiClient} object.
   */
  public ApiClient setDebugging(boolean debugging) {
    this.debugging = debugging;
    // Rebuild HTTP Client according to the new "debugging" value.
    this.httpClient = buildHttpClient();
    return this;
  }

  /**
   * The path of temporary folder used to store downloaded files from endpoints
   * with file response. The default value is <code>null</code>, i.e. using
   * the system's default temporary folder.
   *
   * @return Temp folder path
   */
  public String getTempFolderPath() {
    return tempFolderPath;
  }

  /**
   * Set temp folder path
   *
   * @param tempFolderPath Temp folder path
   * @return a {@link org.openapitools.client.ApiClient} object.
   */
  public ApiClient setTempFolderPath(String tempFolderPath) {
    this.tempFolderPath = tempFolderPath;
    return this;
  }

  /**
   * Connect timeout (in milliseconds).
   *
   * @return Connection timeout
   */
  public int getConnectTimeout() {
    return connectionTimeout;
  }

  /**
   * Set the connect timeout (in milliseconds).
   * A value of 0 means no timeout, otherwise values must be between 1 and
   * {@link Integer#MAX_VALUE}.
   *
   * @param connectionTimeout Connection timeout in milliseconds
   * @return a {@link org.openapitools.client.ApiClient} object.
   */
  public ApiClient setConnectTimeout(int connectionTimeout) {
    this.connectionTimeout = connectionTimeout;
    httpClient.property(ClientProperties.CONNECT_TIMEOUT, connectionTimeout);
    return this;
  }

  /**
   * read timeout (in milliseconds).
   *
   * @return Read timeout
   */
  public int getReadTimeout() {
    return readTimeout;
  }

  /**
   * Set the read timeout (in milliseconds).
   * A value of 0 means no timeout, otherwise values must be between 1 and
   * {@link Integer#MAX_VALUE}.
   *
   * @param readTimeout Read timeout in milliseconds
   * @return a {@link org.openapitools.client.ApiClient} object.
   */
  public ApiClient setReadTimeout(int readTimeout) {
    this.readTimeout = readTimeout;
    httpClient.property(ClientProperties.READ_TIMEOUT, readTimeout);
    return this;
  }

  /**
   * Get the date format used to parse/format date parameters.
   *
   * @return Date format
   */
  public DateFormat getDateFormat() {
    return dateFormat;
  }

  /**
   * Set the date format used to parse/format date parameters.
   *
   * @param dateFormat Date format
   * @return a {@link org.openapitools.client.ApiClient} object.
   */
  public ApiClient setDateFormat(DateFormat dateFormat) {
    this.dateFormat = dateFormat;
    // also set the date format for model (de)serialization with Date properties
    this.json.setDateFormat((DateFormat) dateFormat.clone());
    return this;
  }

  /**
   * Parse the given string into Date object.
   *
   * @param str String
   * @return Date
   */
  public Date parseDate(String str) {
    try {
      return dateFormat.parse(str);
    } catch (java.text.ParseException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Format the given Date object into string.
   *
   * @param date Date
   * @return Date in string format
   */
  public String formatDate(Date date) {
    return dateFormat.format(date);
  }

  /**
   * Format the given parameter object into string.
   *
   * @param param Object
   * @return Object in string format
   */
  public String parameterToString(Object param) {
    if (param == null) {
      return "";
    } else if (param instanceof Date) {
      return formatDate((Date) param);
    } else if (param instanceof OffsetDateTime) {
      return formatOffsetDateTime((OffsetDateTime) param);
    } else if (param instanceof Collection<?>) {
      StringBuilder b = new StringBuilder();
      for(Object o : (Collection<?>)param) {
        if(b.length() > 0) {
          b.append(',');
        }
        b.append(String.valueOf(o));
      }
      return b.toString();
    } else {
      return String.valueOf(param);
    }
  }

  /*
   * Format to {@code Pair} objects.
   *
   * @param collectionFormat Collection format
   * @param name Name
   * @param value Value
   * @return List of pairs
   */
  public List<Pair> parameterToPairs(String collectionFormat, String name, Object value){
    List<Pair> params = new ArrayList<>();

    // preconditions
    if (name == null || name.isEmpty() || value == null) return params;

    Collection<?> valueCollection;
    if (value instanceof Collection<?>) {
      valueCollection = (Collection<?>) value;
    } else {
      params.add(new Pair(name, parameterToString(value)));
      return params;
    }

    if (valueCollection.isEmpty()){
      return params;
    }

    // get the collection format (default: csv)
    String format = (collectionFormat == null || collectionFormat.isEmpty() ? "csv" : collectionFormat);

    // create the params based on the collection format
    if ("multi".equals(format)) {
      for (Object item : valueCollection) {
        params.add(new Pair(name, parameterToString(item)));
      }

      return params;
    }

    String delimiter = ",";

    if ("csv".equals(format)) {
      delimiter = ",";
    } else if ("ssv".equals(format)) {
      delimiter = " ";
    } else if ("tsv".equals(format)) {
      delimiter = "\t";
    } else if ("pipes".equals(format)) {
      delimiter = "|";
    }

    StringBuilder sb = new StringBuilder() ;
    for (Object item : valueCollection) {
      sb.append(delimiter);
      sb.append(parameterToString(item));
    }

    params.add(new Pair(name, sb.substring(1)));

    return params;
  }

  /**
   * Check if the given MIME is a JSON MIME.
   * JSON MIME examples:
   *   application/json
   *   application/json; charset=UTF8
   *   APPLICATION/JSON
   *   application/vnd.company+json
   * "*{@literal /}*" is also considered JSON by this method.
   *
   * @param mime MIME
   * @return True if the MIME type is JSON
   */
  public boolean isJsonMime(String mime) {
    return mime != null && (mime.equals("*/*") || JSON_MIME_PATTERN.matcher(mime).matches());
  }

  /**
   * Select the Accept header's value from the given accepts array:
   *   if JSON exists in the given array, use it;
   *   otherwise use all of them (joining into a string)
   *
   * @param accepts The accepts array to select from
   * @return The Accept header to use. If the given array is empty,
   *   null will be returned (not to set the Accept header explicitly).
   */
  public String selectHeaderAccept(String... accepts) {
    if (accepts == null || accepts.length == 0) {
      return null;
    }
    for (String accept : accepts) {
      if (isJsonMime(accept)) {
        return accept;
      }
    }
    return StringUtil.join(accepts, ",");
  }

  /**
   * Select the Content-Type header's value from the given array:
   *   if JSON exists in the given array, use it;
   *   otherwise use the first one of the array.
   *
   * @param contentTypes The Content-Type array to select from
   * @return The Content-Type header to use. If the given array is empty,
   *   JSON will be used.
   */
  public String selectHeaderContentType(String... contentTypes) {
    if (contentTypes == null || contentTypes.length == 0) {
      return "application/json";
    }
    for (String contentType : contentTypes) {
      if (isJsonMime(contentType)) {
        return contentType;
      }
    }
    return contentTypes[0];
  }

  /**
   * Escape the given string to be used as URL query value.
   *
   * @param str String
   * @return Escaped string
   */
  public String escapeString(String str) {
    try {
      return URLEncoder.encode(str, "utf8").replaceAll("\\+", "%20");
    } catch (UnsupportedEncodingException e) {
      return str;
    }
  }

  /**
   * Serialize the given Java object into string entity according the given
   * Content-Type (only JSON is supported for now).
   *
   * @param obj Object
   * @param formParams Form parameters
   * @param contentType Context type
   * @return Entity
   * @throws ApiException API exception
   */
  public Entity<?> serialize(Object obj, Map<String, Object> formParams, String contentType, boolean isBodyNullable) throws ApiException {
    Entity<?> entity;
    if (contentType.startsWith("multipart/form-data")) {
      MultiPart multiPart = new MultiPart();
      for (Entry<String, Object> param: formParams.entrySet()) {
        if (param.getValue() instanceof File) {
          File file = (File) param.getValue();
          FormDataContentDisposition contentDisp = FormDataContentDisposition.name(param.getKey())
              .fileName(file.getName()).size(file.length()).build();

          // Attempt to probe the content type for the file so that the form part is more correctly
          // and precisely identified, but fall back to application/octet-stream if that fails.
          MediaType type;
          try {
            type = MediaType.valueOf(Files.probeContentType(file.toPath()));
          } catch (IOException | IllegalArgumentException e) {
            type = MediaType.APPLICATION_OCTET_STREAM_TYPE;
          }

          multiPart.bodyPart(new FormDataBodyPart(contentDisp, file, type));
        } else {
          FormDataContentDisposition contentDisp = FormDataContentDisposition.name(param.getKey()).build();
          multiPart.bodyPart(new FormDataBodyPart(contentDisp, parameterToString(param.getValue())));
        }
      }
      entity = Entity.entity(multiPart, MediaType.MULTIPART_FORM_DATA_TYPE);
    } else if (contentType.startsWith("application/x-www-form-urlencoded")) {
      Form form = new Form();
      for (Entry<String, Object> param: formParams.entrySet()) {
        form.param(param.getKey(), parameterToString(param.getValue()));
      }
      entity = Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE);
    } else {
      // We let jersey handle the serialization
      if (isBodyNullable) { // payload is nullable
        if (obj instanceof String) {
          entity = Entity.entity(obj == null ? "null" : "\"" + ((String)obj).replaceAll("\"", Matcher.quoteReplacement("\\\"")) + "\"", contentType);
        } else {
          entity = Entity.entity(obj == null ? "null" : obj, contentType);
        }
      } else {
        if (obj instanceof String) {
          entity = Entity.entity(obj == null ? "" : "\"" + ((String)obj).replaceAll("\"", Matcher.quoteReplacement("\\\"")) + "\"", contentType);
        } else {
          entity = Entity.entity(obj == null ? "" : obj, contentType);
        }
      }
    }
    return entity;
  }

  /**
   * Serialize the given Java object into string according the given
   * Content-Type (only JSON, HTTP form is supported for now).
   *
   * @param obj Object
   * @param formParams Form parameters
   * @param contentType Context type
   * @param isBodyNullable True if the body is nullable
   * @return String
   * @throws ApiException API exception
   */
  public String serializeToString(Object obj, Map<String, Object> formParams, String contentType, boolean isBodyNullable) throws ApiException {
    try {
      if (contentType.startsWith("multipart/form-data")) {
        throw new ApiException("multipart/form-data not yet supported for serializeToString (http signature authentication)");
      } else if (contentType.startsWith("application/x-www-form-urlencoded")) {
        String formString = "";
        for (Entry<String, Object> param : formParams.entrySet()) {
          formString = param.getKey() + "=" + URLEncoder.encode(parameterToString(param.getValue()), "UTF-8") + "&";
        }

        if (formString.length() == 0) { // empty string
          return formString;
        } else {
          return formString.substring(0, formString.length() - 1);
        }
      } else {
        if (isBodyNullable) {
          return obj == null ? "null" : json.getMapper().writeValueAsString(obj);
        } else {
          return obj == null ? "" : json.getMapper().writeValueAsString(obj);
        }
      }
    } catch (Exception ex) {
      throw new ApiException("Failed to perform serializeToString: " + ex.toString());
    }
  }

  /**
   * Deserialize response body to Java object according to the Content-Type.
   *
   * @param <T> Type
   * @param response Response
   * @param returnType Return type
   * @return Deserialize object
   * @throws ApiException API exception
   */
  @SuppressWarnings("unchecked")
  public <T> T deserialize(Response response, GenericType<T> returnType) throws ApiException {
    if (response == null || returnType == null) {
      return null;
    }

    if ("byte[]".equals(returnType.toString())) {
      // Handle binary response (byte array).
      return (T) response.readEntity(byte[].class);
    } else if (returnType.getRawType() == File.class) {
      // Handle file downloading.
      T file = (T) downloadFileFromResponse(response);
      return file;
    }

    // read the entity stream multiple times
    response.bufferEntity();

    return response.readEntity(returnType);
  }

  /**
   * Download file from the given response.
   *
   * @param response Response
   * @return File
   * @throws ApiException If fail to read file content from response and write to disk
   */
  public File downloadFileFromResponse(Response response) throws ApiException {
    try {
      File file = prepareDownloadFile(response);
      Files.copy(response.readEntity(InputStream.class), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
      return file;
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

  /**
   * <p>Prepare the file for download from the response.</p>
   *
   * @param response a {@link jakarta.ws.rs.core.Response} object.
   * @return a {@link java.io.File} object.
   * @throws java.io.IOException if any.
   */
  public File prepareDownloadFile(Response response) throws IOException {
    String filename = null;
    String contentDisposition = (String) response.getHeaders().getFirst("Content-Disposition");
    if (contentDisposition != null && !"".equals(contentDisposition)) {
      // Get filename from the Content-Disposition header.
      Pattern pattern = Pattern.compile("filename=['\"]?([^'\"\\s]+)['\"]?");
      Matcher matcher = pattern.matcher(contentDisposition);
      if (matcher.find())
        filename = matcher.group(1);
    }

    String prefix;
    String suffix = null;
    if (filename == null) {
      prefix = "download-";
      suffix = "";
    } else {
      int pos = filename.lastIndexOf('.');
      if (pos == -1) {
        prefix = filename + "-";
      } else {
        prefix = filename.substring(0, pos) + "-";
        suffix = filename.substring(pos);
      }
      // Files.createTempFile requires the prefix to be at least three characters long
      if (prefix.length() < 3)
        prefix = "download-";
    }

    if (tempFolderPath == null)
      return Files.createTempFile(prefix, suffix).toFile();
    else
      return Files.createTempFile(Paths.get(tempFolderPath), prefix, suffix).toFile();
  }

  /**
   * Invoke API by sending HTTP request with the given options.
   *
   * @param <T> Type
   * @param operation The qualified name of the operation
   * @param path The sub-path of the HTTP URL
   * @param method The request method, one of "GET", "POST", "PUT", "HEAD" and "DELETE"
   * @param queryParams The query parameters
   * @param body The request body object
   * @param headerParams The header parameters
   * @param cookieParams The cookie parameters
   * @param formParams The form parameters
   * @param accept The request's Accept header
   * @param contentType The request's Content-Type header
   * @param authNames The authentications to apply
   * @param returnType The return type into which to deserialize the response
   * @param isBodyNullable True if the body is nullable
   * @return The response body in type of string
   * @throws ApiException API exception
   */
  public <T> ApiResponse<T> invokeAPI(
      String operation,
      String path,
      String method,
      List<Pair> queryParams,
      Object body,
      Map<String, String> headerParams,
      Map<String, String> cookieParams,
      Map<String, Object> formParams,
      String accept,
      String contentType,
      String[] authNames,
      GenericType<T> returnType,
      boolean isBodyNullable)
      throws ApiException {

    String targetURL;
    List<ServerConfiguration> serverConfigurations;
    if (serverIndex != null && (serverConfigurations = operationServers.get(operation)) != null) {
      int index = operationServerIndex.getOrDefault(operation, serverIndex).intValue();
      Map<String, String> variables = operationServerVariables.getOrDefault(operation, serverVariables);
      if (index < 0 || index >= serverConfigurations.size()) {
        throw new ArrayIndexOutOfBoundsException(
            String.format(
                "Invalid index %d when selecting the host settings. Must be less than %d",
                index, serverConfigurations.size()));
      }
      targetURL = serverConfigurations.get(index).URL(variables) + path;
    } else {
      targetURL = this.basePath + path;
    }
    // Not using `.target(targetURL).path(path)` below,
    // to support (constant) query string in `path`, e.g. "/posts?draft=1"
    WebTarget target = httpClient.target(targetURL);

    if (queryParams != null) {
      for (Pair queryParam : queryParams) {
        if (queryParam.getValue() != null) {
          target = target.queryParam(queryParam.getName(), escapeString(queryParam.getValue()));
        }
      }
    }

    Invocation.Builder invocationBuilder = target.request();

    if (accept != null) {
      invocationBuilder = invocationBuilder.accept(accept);
    }

    for (Entry<String, String> entry : cookieParams.entrySet()) {
      String value = entry.getValue();
      if (value != null) {
        invocationBuilder = invocationBuilder.cookie(entry.getKey(), value);
      }
    }

    for (Entry<String, String> entry : defaultCookieMap.entrySet()) {
      String value = entry.getValue();
      if (value != null) {
        invocationBuilder = invocationBuilder.cookie(entry.getKey(), value);
      }
    }

    Entity<?> entity = serialize(body, formParams, contentType, isBodyNullable);

    // put all headers in one place
    Map<String, String> allHeaderParams = new HashMap<>(defaultHeaderMap);
    allHeaderParams.putAll(headerParams);

    if (authNames != null) {
      // update different parameters (e.g. headers) for authentication
      updateParamsForAuth(
          authNames,
          queryParams,
          allHeaderParams,
          cookieParams,
          null,
          method,
          target.getUri());
    }

    for (Entry<String, String> entry : allHeaderParams.entrySet()) {
      String value = entry.getValue();
      if (value != null) {
        invocationBuilder = invocationBuilder.header(entry.getKey(), value);
      }
    }

    Response response = null;

    try {
      response = sendRequest(method, invocationBuilder, entity);

      final int statusCode = response.getStatusInfo().getStatusCode();

      Map<String, List<String>> responseHeaders = buildResponseHeaders(response);

      if (statusCode == Status.NO_CONTENT.getStatusCode()) {
        return new ApiResponse<T>(statusCode, responseHeaders);
      } else if (response.getStatusInfo().getFamily() == Status.Family.SUCCESSFUL) {
        if (returnType == null) {
          return new ApiResponse<T>(statusCode, responseHeaders);
        } else {
          return new ApiResponse<T>(statusCode, responseHeaders, deserialize(response, returnType));
        }
      } else {
        String message = "error";
        String respBody = null;
        if (response.hasEntity()) {
          try {
            respBody = String.valueOf(response.readEntity(String.class));
            message = respBody;
          } catch (RuntimeException e) {
            // e.printStackTrace();
          }
        }
        throw new ApiException(
            response.getStatus(), message, buildResponseHeaders(response), respBody);
      }
    } finally {
      try {
        response.close();
      } catch (Exception e) {
        // it's not critical, since the response object is local in method invokeAPI; that's fine,
        // just continue
      }
    }
  }

  private Response sendRequest(String method, Invocation.Builder invocationBuilder, Entity<?> entity) {
    Response response;
    if ("POST".equals(method)) {
      response = invocationBuilder.post(entity);
    } else if ("PUT".equals(method)) {
      response = invocationBuilder.put(entity);
    } else if ("DELETE".equals(method)) {
      response = invocationBuilder.method("DELETE", entity);
    } else if ("PATCH".equals(method)) {
      response = invocationBuilder.method("PATCH", entity);
    } else {
      response = invocationBuilder.method(method);
    }
    return response;
  }

  /**
   * @deprecated Add qualified name of the operation as a first parameter.
   */
  @Deprecated
  public <T> ApiResponse<T> invokeAPI(String path, String method, List<Pair> queryParams, Object body, Map<String, String> headerParams, Map<String, String> cookieParams, Map<String, Object> formParams, String accept, String contentType, String[] authNames, GenericType<T> returnType, boolean isBodyNullable) throws ApiException {
    return invokeAPI(null, path, method, queryParams, body, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType, isBodyNullable);
  }

  /**
   * Build the Client used to make HTTP requests.
   *
   * @return Client
   */
  protected Client buildHttpClient() {
    // recreate the client config to pickup changes
    clientConfig = getDefaultClientConfig();

    ClientBuilder clientBuilder = ClientBuilder.newBuilder();
    clientBuilder = clientBuilder.withConfig(clientConfig);
    customizeClientBuilder(clientBuilder);
    return clientBuilder.build();
  }

  /**
   * Get the default client config.
   *
   * @return Client config
   */
  public ClientConfig getDefaultClientConfig() {
    ClientConfig clientConfig = new ClientConfig();
    clientConfig.register(MultiPartFeature.class);
    clientConfig.register(json);
    clientConfig.register(JacksonFeature.class);
    clientConfig.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
    // turn off compliance validation to be able to send payloads with DELETE calls
    clientConfig.property(ClientProperties.SUPPRESS_HTTP_COMPLIANCE_VALIDATION, true);
    if (debugging) {
      clientConfig.register(new LoggingFeature(java.util.logging.Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), java.util.logging.Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, 1024*50 /* Log payloads up to 50K */));
      clientConfig.property(LoggingFeature.LOGGING_FEATURE_VERBOSITY, LoggingFeature.Verbosity.PAYLOAD_ANY);
      // Set logger to ALL
      java.util.logging.Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME).setLevel(java.util.logging.Level.ALL);
    } else {
      // suppress warnings for payloads with DELETE calls:
      java.util.logging.Logger.getLogger("org.glassfish.jersey.client").setLevel(java.util.logging.Level.SEVERE);
    }

    return clientConfig;
  }

  /**
   * Customize the client builder.
   *
   * This method can be overridden to customize the API client. For example, this can be used to:
   * 1. Set the hostname verifier to be used by the client to verify the endpoint's hostname
   *    against its identification information.
   * 2. Set the client-side key store.
   * 3. Set the SSL context that will be used when creating secured transport connections to
   *    server endpoints from web targets created by the client instance that is using this SSL context.
   * 4. Set the client-side trust store.
   *
   * To completely disable certificate validation (at your own risk), you can
   * override this method and invoke disableCertificateValidation(clientBuilder).
   *
   * @param clientBuilder a {@link jakarta.ws.rs.client.ClientBuilder} object.
   */
  protected void customizeClientBuilder(ClientBuilder clientBuilder) {
    // No-op extension point
  }

  /**
   * Disable X.509 certificate validation in TLS connections.
   *
   * Please note that trusting all certificates is extremely risky.
   * This may be useful in a development environment with self-signed certificates.
   *
   * @param clientBuilder a {@link jakarta.ws.rs.client.ClientBuilder} object.
   * @throws java.security.KeyManagementException if any.
   * @throws java.security.NoSuchAlgorithmException if any.
   */
  protected void disableCertificateValidation(ClientBuilder clientBuilder) throws KeyManagementException, NoSuchAlgorithmException {
    TrustManager[] trustAllCerts = new X509TrustManager[] {
      new X509TrustManager() {
        @Override
        public X509Certificate[] getAcceptedIssuers() {
          return null;
        }
        @Override
        public void checkClientTrusted(X509Certificate[] certs, String authType) {
        }
        @Override
        public void checkServerTrusted(X509Certificate[] certs, String authType) {
        }
      }
    };
    SSLContext sslContext = SSLContext.getInstance("TLS");
    sslContext.init(null, trustAllCerts, new SecureRandom());
    clientBuilder.sslContext(sslContext);
  }

  /**
   * <p>Build the response headers.</p>
   *
   * @param response a {@link jakarta.ws.rs.core.Response} object.
   * @return a {@link java.util.Map} of response headers.
   */
  protected Map<String, List<String>> buildResponseHeaders(Response response) {
    Map<String, List<String>> responseHeaders = new HashMap<>();
    for (Entry<String, List<Object>> entry: response.getHeaders().entrySet()) {
      List<Object> values = entry.getValue();
      List<String> headers = new ArrayList<>();
      for (Object o : values) {
        headers.add(String.valueOf(o));
      }
      responseHeaders.put(entry.getKey(), headers);
    }
    return responseHeaders;
  }

  /**
   * Update query and header parameters based on authentication settings.
   *
   * @param authNames The authentications to apply
   * @param queryParams List of query parameters
   * @param headerParams Map of header parameters
   * @param cookieParams Map of cookie parameters
   * @param method HTTP method (e.g. POST)
   * @param uri HTTP URI
   */
  protected void updateParamsForAuth(String[] authNames, List<Pair> queryParams, Map<String, String> headerParams,
                                     Map<String, String> cookieParams, String payload, String method, URI uri) throws ApiException {
    for (String authName : authNames) {
      Authentication auth = authentications.get(authName);
      if (auth == null) {
        continue;
      }
      auth.applyToParams(queryParams, headerParams, cookieParams, payload, method, uri);
    }
  }
}
