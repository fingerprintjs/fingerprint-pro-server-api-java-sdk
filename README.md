<p align="center">
    <a href="https://fingerprint.com">
        <picture>
            <source media="(prefers-color-scheme: dark)" srcset="https://fingerprintjs.github.io/home/resources/logo_light.svg" />
            <source media="(prefers-color-scheme: light)" srcset="https://fingerprintjs.github.io/home/resources/logo_dark.svg" />
            <img src="https://fingerprintjs.github.io/home/resources/logo_light.svg" alt="Fingerprint logo" width="312px" />
        </picture>
    </a>
</p>
<p align="center">
    <a href="https://jitpack.io/#fingerprintjs/fingerprint-pro-server-api-java-sdk"><img src="https://jitpack.io/v/fingerprintjs/fingerprint-pro-server-api-java-sdk.svg" alt="Jitpack Release" /></a>
    <a href="https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/actions/workflows/release.yml"><img src="https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/actions/workflows/release.yml/badge.svg" alt="CI badge" /></a>
    <a href="https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/actions/workflows/test.yml"><img src="https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/actions/workflows/test.yml/badge.svg" alt="CI badge" /></a>
    <a href="https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/actions/workflows/functional.yml"><img src="https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/actions/workflows/functional.yml/badge.svg" alt="CI badge" /></a>
    <a href="https://opensource.org/licenses/MIT"><img src="https://img.shields.io/:license-mit-blue.svg?style=flat"/></a>
    <a href="https://discord.gg/39EpE2neBg"><img src="https://img.shields.io/discord/852099967190433792?style=logo&label=Discord&logo=Discord&logoColor=white" alt="Discord server"></a>
</p>

# Fingerprint Pro Server API Java SDK

[Fingerprint](https://fingerprint.com/) is a device intelligence platform offering 99.5% accurate visitor identification. The Fingerprint Server Java SDK is an easy way to interact with the Fingerprint [Server API](https://dev.fingerprint.com/reference/pro-server-api) from your Java application. You can retrieve visitor history or individual identification events.


*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*

## Requirements

The following versions of Gradle/Maven are supported

- Maven (3.8.3+)
- Gradle (7.2+)

The following versions of Java are supported

- Java 1.8
- Java 11
- Java 17
- Java 21

## Installation

### Maven users

Add this dependency to your project's POM:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

```xml
<dependency>
  <groupId>com.github.fingerprintjs</groupId>
  <artifactId>fingerprint-pro-server-api-java-sdk</artifactId>
  <version>v5.1.1</version>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
  repositories {
     maven { url 'https://jitpack.io' }
  }

  dependencies {
     implementation "com.github.fingerprintjs:fingerprint-pro-server-api-java-sdk:v5.1.1"
  }
```

### Others

At first generate the JAR by executing:

```shell
./gradlew jar
```

Then manually install the following JARs:

- `target/fingerprint-pro-server-api-sdk-5.1.1.jar`

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
    private static final String PAGINATION_KEY = "1683900801733.Ogvu1j";

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
            Response response = api.getVisits(FPJS_VISITOR_ID, null, null, LIMIT, null, null);
            System.out.println(response.getVisits().toString());
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getVisits:" + e.getMessage());
        }

        // Get a specific visitor's all visits with a linkedId
        try {
            // Fetch all visits with a given visitorId, with a page limit, skipping the first visit
            Response response = api.getVisits(FPJS_VISITOR_ID, null, FPJS_LINKED_ID, LIMIT, PAGINATION_KEY, null);
            System.out.println(response.getVisits().toString());
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getVisits:" + e.getMessage());
        }

        // Use all the parameters on getVisits
        try {
            // Fetch the visitor's all visits with a given requestId and linkedId with a page limit while skipping the first visit
            Response response = api.getVisits(FPJS_VISITOR_ID, FPJS_REQUEST_ID, FPJS_LINKED_ID, LIMIT, PAGINATION_KEY, null);
            System.out.println(response.getVisits().toString());
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getVisits:" + e.getMessage());
        }
    }
}
```

## Sealed results

This SDK provides utility methods for decoding [sealed results](https://dev.fingerprint.com/docs/sealed-client-results).
```java
package com.fingerprint.example;

import com.fingerprint.Sealed;
import com.fingerprint.model.EventResponse;

import java.util.Base64;

public class SealedResults {
    public static void main(String... args) throws Exception {
        // Sealed result from the frontend.
        String SEALED_RESULT = System.getenv("BASE64_SEALED_RESULT");

        // Base64 encoded key generated in the dashboard.
        String SEALED_KEY = System.getenv("BASE64_KEY");

        final EventResponse event = Sealed.unsealEventResponse(
                Base64.getDecoder().decode(SEALED_RESULT),
                // You can provide more than one key to support key rotation. The SDK will try to decrypt the result with each key.
                new Sealed.DecryptionKey[]{
                        new Sealed.DecryptionKey(
                                Base64.getDecoder().decode(SEALED_KEY),
                                Sealed.DecryptionAlgorithm.AES_256_GCM
                        )
                }
        );

        // Do something with unsealed response, e.g: send it back to the frontend.
    }
}

```
To learn more, refer to example located in [src/examples/java/com/fingerprint/example/SealedResults.java](src/examples/java/com/fingerprint/example/SealedResults.java).

## Documentation for API Endpoints

All URIs are relative to *https://api.fpjs.io*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*FingerprintApi* | [**getEvent**](docs/FingerprintApi.md#getEvent) | **GET** /events/{request_id} | Get event by requestId
*FingerprintApi* | [**getVisits**](docs/FingerprintApi.md#getVisits) | **GET** /visitors/{visitor_id} | Get visits by visitorId
*FingerprintApi* | [**webhookTrace**](docs/FingerprintApi.md#webhookTrace) | **TRACE** /webhook | 


## Documentation for Models

 - [ASN](docs/ASN.md)
 - [BotdDetectionResult](docs/BotdDetectionResult.md)
 - [BotdResult](docs/BotdResult.md)
 - [BrowserDetails](docs/BrowserDetails.md)
 - [ClonedAppResult](docs/ClonedAppResult.md)
 - [Confidence](docs/Confidence.md)
 - [DataCenter](docs/DataCenter.md)
 - [DeprecatedIPLocation](docs/DeprecatedIPLocation.md)
 - [DeprecatedIPLocationCity](docs/DeprecatedIPLocationCity.md)
 - [EmulatorResult](docs/EmulatorResult.md)
 - [Error](docs/Error.md)
 - [ErrorEvent403Response](docs/ErrorEvent403Response.md)
 - [ErrorEvent403ResponseError](docs/ErrorEvent403ResponseError.md)
 - [ErrorEvent404Response](docs/ErrorEvent404Response.md)
 - [ErrorEvent404ResponseError](docs/ErrorEvent404ResponseError.md)
 - [ErrorVisits403](docs/ErrorVisits403.md)
 - [EventResponse](docs/EventResponse.md)
 - [FactoryResetResult](docs/FactoryResetResult.md)
 - [FridaResult](docs/FridaResult.md)
 - [HighActivityResult](docs/HighActivityResult.md)
 - [IPLocation](docs/IPLocation.md)
 - [IPLocationCity](docs/IPLocationCity.md)
 - [IdentificationError](docs/IdentificationError.md)
 - [IncognitoResult](docs/IncognitoResult.md)
 - [IpBlockListResult](docs/IpBlockListResult.md)
 - [IpBlockListResultDetails](docs/IpBlockListResultDetails.md)
 - [IpInfoResult](docs/IpInfoResult.md)
 - [IpInfoResultV4](docs/IpInfoResultV4.md)
 - [IpInfoResultV6](docs/IpInfoResultV6.md)
 - [JailbrokenResult](docs/JailbrokenResult.md)
 - [Location](docs/Location.md)
 - [LocationSpoofingResult](docs/LocationSpoofingResult.md)
 - [ManyRequestsResponse](docs/ManyRequestsResponse.md)
 - [PrivacySettingsResult](docs/PrivacySettingsResult.md)
 - [ProductError](docs/ProductError.md)
 - [ProductsResponse](docs/ProductsResponse.md)
 - [ProductsResponseBotd](docs/ProductsResponseBotd.md)
 - [ProductsResponseIdentification](docs/ProductsResponseIdentification.md)
 - [ProductsResponseIdentificationData](docs/ProductsResponseIdentificationData.md)
 - [ProxyResult](docs/ProxyResult.md)
 - [RawDeviceAttributesResultValue](docs/RawDeviceAttributesResultValue.md)
 - [Response](docs/Response.md)
 - [ResponseVisits](docs/ResponseVisits.md)
 - [RootAppsResult](docs/RootAppsResult.md)
 - [SeenAt](docs/SeenAt.md)
 - [SignalResponseClonedApp](docs/SignalResponseClonedApp.md)
 - [SignalResponseEmulator](docs/SignalResponseEmulator.md)
 - [SignalResponseFactoryReset](docs/SignalResponseFactoryReset.md)
 - [SignalResponseFrida](docs/SignalResponseFrida.md)
 - [SignalResponseHighActivity](docs/SignalResponseHighActivity.md)
 - [SignalResponseIncognito](docs/SignalResponseIncognito.md)
 - [SignalResponseIpBlocklist](docs/SignalResponseIpBlocklist.md)
 - [SignalResponseIpInfo](docs/SignalResponseIpInfo.md)
 - [SignalResponseJailbroken](docs/SignalResponseJailbroken.md)
 - [SignalResponseLocationSpoofing](docs/SignalResponseLocationSpoofing.md)
 - [SignalResponsePrivacySettings](docs/SignalResponsePrivacySettings.md)
 - [SignalResponseProxy](docs/SignalResponseProxy.md)
 - [SignalResponseRawDeviceAttributes](docs/SignalResponseRawDeviceAttributes.md)
 - [SignalResponseRootApps](docs/SignalResponseRootApps.md)
 - [SignalResponseSuspectScore](docs/SignalResponseSuspectScore.md)
 - [SignalResponseTampering](docs/SignalResponseTampering.md)
 - [SignalResponseTor](docs/SignalResponseTor.md)
 - [SignalResponseVirtualMachine](docs/SignalResponseVirtualMachine.md)
 - [SignalResponseVpn](docs/SignalResponseVpn.md)
 - [Subdivision](docs/Subdivision.md)
 - [SuspectScoreResult](docs/SuspectScoreResult.md)
 - [TamperingResult](docs/TamperingResult.md)
 - [TorResult](docs/TorResult.md)
 - [VirtualMachineResult](docs/VirtualMachineResult.md)
 - [Visit](docs/Visit.md)
 - [VpnResult](docs/VpnResult.md)
 - [VpnResultMethods](docs/VpnResultMethods.md)
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


## Documentation for sealed results

- [Sealed](docs/Sealed.md)
- [DecryptionKey](docs/DecryptionKey.md)

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Support

To report problems, ask questions or provide feedback, please use [Issues](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/issues).
If you need private support, you can email us at [oss-support@fingerprint.com](mailto:oss-support@fingerprint.com).


## License

This project is licensed under the [MIT License](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/blob/main/LICENSE).
