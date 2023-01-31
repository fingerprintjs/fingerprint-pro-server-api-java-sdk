> :warning: **Work in progress**: This is a beta version of the library

<p align="center">
    <a href="https://fingerprint.com">
        <picture>
            <source media="(prefers-color-scheme: dark)" srcset="https://raw.githubusercontent.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/main/.github/resources/logo_light.svg" />
            <source media="(prefers-color-scheme: light)" srcset="https://raw.githubusercontent.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/main/.github/resources/logo_dark.svg" />
            <img src="https://raw.githubusercontent.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/main/.github/resources/logo_light.svg" alt="Fingerprint logo" width="312px" />
        </picture>
    </a>
</p>
<p align="center">
    <a href="https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/actions/workflows/release.yml">
        <img src="https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/actions/workflows/release.yml/badge.svg" alt="CI badge" />
    </a>
    <a href="https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/actions/workflows/test.yml">
        <img src="https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/actions/workflows/test.yml/badge.svg" alt="CI badge" />
    </a>
    <a href="https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/actions/workflows/functional.yml">
        <img src="https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/actions/workflows/functional.yml/badge.svg" alt="CI badge" />
    </a>
    <a href="https://opensource.org/licenses/MIT">
        <img src="https://img.shields.io/:license-mit-blue.svg?style=flat"/>
    </a>
    <a href="https://discord.gg/39EpE2neBg">
        <img src="https://img.shields.io/discord/852099967190433792?style=logo&label=Discord&logo=Discord&logoColor=white" alt="Discord server">
    </a>
</p>

# Fingerprint Pro Server API Java SDK
**Fingerprint Pro Server API provides a way for validating visitors’ data issued by Fingerprint Pro.**


*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*

## Requirements

Building the API client library requires:

1. Java 1.8+
2. Maven (3.8.3+)/Gradle (7.2+)

## Installation

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.fingerprint</groupId>
  <artifactId>fingerprint-pro-server-api-sdk</artifactId>
  <version>dev-1.0.0-2</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
  repositories {
    mavenCentral()     // Needed if the 'fingerprint-pro-server-api-sdk' jar has been published to maven central.
    mavenLocal()       // Needed if the 'fingerprint-pro-server-api-sdk' jar has been published to the local maven repo.
  }

  dependencies {
     implementation "com.fingerprint:fingerprint-pro-server-api-sdk:dev-1.0.0-2"
  }
```

### Others

At first generate the JAR by executing:

```shell
./gradlew jar
```

Then manually install the following JARs:

- `target/fingerprint-pro-server-api-sdk-dev-1.0.0-2.jar`

## Usage

To add a HTTP proxy for the API client, use `ClientConfig`:
```java

import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import com.fingerprint.sdk.*;
import com.fingerprint.api.FingerprintApi;

...

ApiClient defaultClient = Configuration.getDefaultApiClient();
ClientConfig clientConfig = defaultClient.getClientConfig();
clientConfig.connectorProvider(new ApacheConnectorProvider());
clientConfig.property(ClientProperties.PROXY_URI, "http://proxy_url_here");
clientConfig.property(ClientProperties.PROXY_USERNAME, "proxy_username");
clientConfig.property(ClientProperties.PROXY_PASSWORD, "proxy_password");
defaultClient.setClientConfig(clientConfig);

FingerprintApi apiInstance = new FingerprintApi(defaultClient);

```

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java
package main;

import com.fingerprint.api.FingerprintApi;
import com.fingerprint.models.EventResponse;
import com.fingerprint.models.Response;
import com.fingerprint.sdk.ApiClient;
import com.fingerprint.sdk.ApiException;
import com.fingerprint.sdk.Configuration;
import com.fingerprint.sdk.Region;

public class FingerprintApiExample {
    // Fingerprint Pro Secret API Key
    private static final String FPJS_API_SECRET = "Fingerprint Pro Secret API Key";
    // A mandatory visitorId of a specific visitor
    private static final String FPJS_VISITOR_ID = "visitorId";
    // An optional requestId made by a specific visitor
    private static final String FPJS_REQUEST_ID = "requestId";
    // An optional linkedId of the visit
    private static final String FPJS_LINKED_ID = "linkedId";
    // An optional parameter limiting scanned results
    private static final Integer LIMIT = 10;
    // An optional parameter used to paginate results, see lastTimestamp
    private static final Integer BEFORE = 1;

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
        // Get an event with a given requestId
        try {
            // Fetch the event with a given requestId
            EventResponse response = api.getEvent(FPJS_REQUEST_ID);
            System.out.println(response.getProducts().toString());
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getEvent:" + e.getMessage());
        }
        // Get a specific visitor's all visits
        try {
            // Fetch all visits with a given visitorId, with a page limit
            Response response = api.getVisits(FPJS_VISITOR_ID, null, null, LIMIT, null);
            System.out.println(response.getVisits().toString());
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getEvent:" + e.getMessage());
        }

        // Get a specific visitor's all visits with a linkedId
        try {
            // Fetch all visits with a given visitorId, with a page limit, skipping the first visit
            Response response = api.getVisits(FPJS_VISITOR_ID, null, FPJS_LINKED_ID, LIMIT, BEFORE);
            System.out.println(response.getVisits().toString());
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getEvent:" + e.getMessage());
        }

        // Use all the parameters on getVisits
        try {
            // Fetch the visitor's all visits with a given requestId and linkedId with a page limit while skipping the first visit
            Response response = api.getVisits(FPJS_VISITOR_ID, FPJS_REQUEST_ID, FPJS_LINKED_ID, LIMIT, BEFORE);
            System.out.println(response.getVisits().toString());
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getEvent:" + e.getMessage());
        }
    }
}
```

## Documentation for API Endpoints

All URIs are relative to *https://api.fpjs.io*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*FingerprintApi* | [**getEvent**](docs/FingerprintApi.md#getEvent) | **GET** /events/{request_id} | Get event by requestId
*FingerprintApi* | [**getVisits**](docs/FingerprintApi.md#getVisits) | **GET** /visitors/{visitor_id} | Get visits by visitorId
*FingerprintApi* | [**webhookTrace**](docs/FingerprintApi.md#webhookTrace) | **TRACE** /webhook | 


## Documentation for Models

 - [BotdDetectionResult](docs/BotdDetectionResult.md)
 - [BotdError](docs/BotdError.md)
 - [BotdResult](docs/BotdResult.md)
 - [BrowserDetails](docs/BrowserDetails.md)
 - [Confidence](docs/Confidence.md)
 - [ErrorEvent403Response](docs/ErrorEvent403Response.md)
 - [ErrorEvent403ResponseError](docs/ErrorEvent403ResponseError.md)
 - [ErrorEvent404Response](docs/ErrorEvent404Response.md)
 - [ErrorEvent404ResponseError](docs/ErrorEvent404ResponseError.md)
 - [ErrorVisits403](docs/ErrorVisits403.md)
 - [EventResponse](docs/EventResponse.md)
 - [IPLocation](docs/IPLocation.md)
 - [IPLocationCity](docs/IPLocationCity.md)
 - [IdentificationError](docs/IdentificationError.md)
 - [Location](docs/Location.md)
 - [ManyRequestsResponse](docs/ManyRequestsResponse.md)
 - [ProductsResponse](docs/ProductsResponse.md)
 - [ProductsResponseBotd](docs/ProductsResponseBotd.md)
 - [ProductsResponseIdentification](docs/ProductsResponseIdentification.md)
 - [ProductsResponseIdentificationData](docs/ProductsResponseIdentificationData.md)
 - [Response](docs/Response.md)
 - [ResponseVisits](docs/ResponseVisits.md)
 - [SeenAt](docs/SeenAt.md)
 - [Subdivision](docs/Subdivision.md)
 - [Visit](docs/Visit.md)
 - [WebhookVisit](docs/WebhookVisit.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### ApiKeyHeader


- **Type**: API key
- **API key parameter name**: Auth-API-Key
- **Location**: HTTP header

### ApiKeyQuery


- **Type**: API key
- **API key parameter name**: api_key
- **Location**: URL query string


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

support@fingerprint.com

