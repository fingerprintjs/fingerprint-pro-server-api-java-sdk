/*
 * Fingerprint Pro Server API
 * Fingerprint Pro Server API allows you to get information about visitors and about individual events in a server environment. This API can be used for data exports, decision-making, and data analysis scenarios.
 *
 * The version of the OpenAPI document: 3
 * Contact: support@fingerprint.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.fingerprint.sdk;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-24T04:06:37.641076+03:00[Europe/Istanbul]")
public class Configuration {
    private static ApiClient defaultApiClient = new ApiClient();

    /**
     * Get the default API client, which would be used when creating API
     * instances without providing an API client.
     *
     * @return Default API client
     */
    public static ApiClient getDefaultApiClient() {
        return defaultApiClient;
    }

    public static ApiClient getDefaultApiClient(String apiKey, Region region) {
        defaultApiClient.setApiKey(apiKey);
        defaultApiClient.setBasePath(region.toString());
        return defaultApiClient;
    }

    public static ApiClient getDefaultApiClient(String apiKey, String regionStr) {
        switch (regionStr) {
            case "eu":
            case "EU":
            case "EUROPE":
            case "europe":
                defaultApiClient.setBasePath(Region.EUROPE.toString());
                break;
            case "global":
            case "GLOBAL":
            case "us":
            case "US":
            case "usa":
            case "USA":
            case "America":
            case "america":
            case "AMERICA":
                defaultApiClient.setBasePath(Region.GLOBAL.toString());
                break;
            case "asia":
            case "Asia":
            case "as":
            case "AS":
                defaultApiClient.setBasePath(Region.ASIA.toString());
                break;
            default:
                defaultApiClient.setBasePath(regionStr);
        }
        defaultApiClient.setApiKey(apiKey);
        return defaultApiClient;
    }

    public static ApiClient getDefaultApiClient(String apiKey) {
        defaultApiClient.setApiKey(apiKey);
        defaultApiClient.setBasePath(Region.GLOBAL.toString());
        return defaultApiClient;
    }

    /**
     * Set the default API client, which would be used when creating API
     * instances without providing an API client.
     *
     * @param apiClient API client
     */
    public static void setDefaultApiClient(ApiClient apiClient) {
        defaultApiClient = apiClient;
    }
}