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
  <version>v7.4.0</version>
</dependency>
```

### Gradle users

Add this dependency to your project's build file (`build.gradle` or `build.gradle.kts`):

```groovy
// build.gradle
repositories {
  maven { url 'https://jitpack.io' }
}

dependencies {
  implementation "com.github.fingerprintjs:fingerprint-pro-server-api-java-sdk:v7.4.0"
}
```


```kotlin
// build.gradle.kts

repositories {
  maven {
    url = uri("https://jitpack.io")
  }
}

dependencies {
  implementation("com.github.fingerprintjs:fingerprint-pro-server-api-java-sdk:v7.4.0")
}
```

### Others

At first generate the JAR by executing:

```shell
./gradlew jar
```

Then manually install the following JARs:

- `target/fingerprint-pro-server-api-sdk-7.4.0.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java
package main;

import com.fingerprint.api.FingerprintApi;
import com.fingerprint.model.EventsGetResponse;
import com.fingerprint.model.EventsUpdateRequest;
import com.fingerprint.model.VisitorsGetResponse;
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
            EventsGetResponse response = api.getEvent(FPJS_REQUEST_ID);
            System.out.println(response.getProducts().toString());
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getEvent:" + e.getMessage());
        }

        // Search events with custom filters
        try {
            // By visitorId
            SearchEventsResponse response = api.searchEvents(LIMIT, new FingerprintApi.SearchEventsOptionalParams().setVisitorId(FPJS_VISITOR_ID));
            // Next page
            // SearchEventsResponse response = api.searchEvents(LIMIT, new FingerprintApi.SearchEventsOptionalParams().setPaginationKey(response.getPaginationKey()).setVisitorId(FPJS_VISITOR_ID));
            // Bad bot
            // SearchEventsResponse response = api.searchEvents(LIMIT, new FingerprintApi.SearchEventsOptionalParams().setBot("bad"));
            // Filtered by IP
            // SearchEventsResponse response = api.searchEvents(LIMIT, new FingerprintApi.SearchEventsOptionalParams().setIpAddress("192.168.0.1/32"));
            System.out.println(response.getEvents().toString());
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.searchEvents:" + e.getMessage());
        }

        // Update an event with a given requestId
        try {
            EventsUpdateRequest request = new EventsUpdateRequest();
            request.setLinkedId("myNewLinkedId");
            api.updateEvent(FPJS_REQUEST_ID, request);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.updateEvent:" + e.getMessage());
        }

        // Get a specific visitor's all visits
        try {
            // Fetch all visits with a given visitorId, with a page limit
            VisitorsGetResponse response = api.getVisits(FPJS_VISITOR_ID, null, null, LIMIT, null, null);
            System.out.println(response.getVisits().toString());
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getVisits:" + e.getMessage());
        }

        // Get a specific visitor's all visits with a linkedId
        try {
            // Fetch all visits with a given visitorId, with a page limit, skipping the first visit
            VisitorsGetResponse response = api.getVisits(FPJS_VISITOR_ID, null, FPJS_LINKED_ID, LIMIT, PAGINATION_KEY, null);
            System.out.println(response.getVisits().toString());
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getVisits:" + e.getMessage());
        }

        // Use all the parameters on getVisits
        try {
            // Fetch the visitor's all visits with a given requestId and linkedId with a page limit while skipping the first visit
            VisitorsGetResponse response = api.getVisits(FPJS_VISITOR_ID, FPJS_REQUEST_ID, FPJS_LINKED_ID, LIMIT, PAGINATION_KEY, null);
            System.out.println(response.getVisits().toString());
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getVisits:" + e.getMessage());
        }

        // Delete visitor data with a given visitorID
        try {
            api.deleteVisitorData(FPJS_VISITOR_ID);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.deleteVisitorData:" + e.getMessage());
        }
    }
}
```

## Sealed results

This SDK provides utility methods for decoding [sealed results](https://dev.fingerprint.com/docs/sealed-client-results).
```java
package com.fingerprint.example;

import com.fingerprint.Sealed;
import com.fingerprint.model.EventsGetResponse;

import java.util.Base64;

public class SealedResults {
    public static void main(String... args) throws Exception {
        // Sealed result from the frontend.
        String SEALED_RESULT = System.getenv("BASE64_SEALED_RESULT");

        // Base64 encoded key generated in the dashboard.
        String SEALED_KEY = System.getenv("BASE64_KEY");

        final EventsGetResponse event = Sealed.unsealEventResponse(
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
To learn more, see the [Sealed results example](/examples/src/main/java/com/fingerprint/example/SealedResults.java).

## Webhook signature validation
This SDK provides utility method for verifying the HMAC signature of the incoming webhook request.

Here is an example implementation using Spring Boot:
```java
import com.fingerprint.sdk.WebhookValidation;

@RestController
class WebhookController {

    @PostMapping("/api/webhook")
    public ResponseEntity<String> webhookHandler(@RequestBody byte[] webhook, @RequestHeader HttpHeaders headers) {
        final String secret = System.getenv("WEBHOOK_SIGNATURE_SECRET");
        if (secret == null || secret.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Secret key is not configured");
        }

        final String signature = headers.getFirst("fpjs-event-signature");
        if (signature == null || signature.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing fpjs-event-signature header");
        }

        final boolean isValidSignature = WebhookValidation.isSignatureValid(signature, webhook, secret);
        if (!isValidSignature) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Webhook signature is not valid");
        }

        return ResponseEntity.ok("Webhook received");
    }
}
```

## Documentation for API Endpoints

All URIs are relative to *https://api.fpjs.io*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*FingerprintApi* | [**deleteVisitorData**](docs/FingerprintApi.md#deleteVisitorData) | **DELETE** /visitors/{visitor_id} | Delete data by visitor ID
*FingerprintApi* | [**getEvent**](docs/FingerprintApi.md#getEvent) | **GET** /events/{request_id} | Get event by request ID
*FingerprintApi* | [**getRelatedVisitors**](docs/FingerprintApi.md#getRelatedVisitors) | **GET** /related-visitors | Get Related Visitors
*FingerprintApi* | [**getVisits**](docs/FingerprintApi.md#getVisits) | **GET** /visitors/{visitor_id} | Get visits by visitor ID
*FingerprintApi* | [**searchEvents**](docs/FingerprintApi.md#searchEvents) | **GET** /events/search | Get events via search
*FingerprintApi* | [**updateEvent**](docs/FingerprintApi.md#updateEvent) | **PUT** /events/{request_id} | Update an event with a given request ID
*FingerprintApi* | [**webhookTrace**](docs/FingerprintApi.md#webhookTrace) | **TRACE** /webhook | 


## Documentation for Models

 - [Botd](docs/Botd.md)
 - [BotdBot](docs/BotdBot.md)
 - [BotdBotResult](docs/BotdBotResult.md)
 - [BrowserDetails](docs/BrowserDetails.md)
 - [ClonedApp](docs/ClonedApp.md)
 - [DeprecatedGeolocation](docs/DeprecatedGeolocation.md)
 - [DeveloperTools](docs/DeveloperTools.md)
 - [Emulator](docs/Emulator.md)
 - [Error](docs/Error.md)
 - [ErrorCode](docs/ErrorCode.md)
 - [ErrorPlainResponse](docs/ErrorPlainResponse.md)
 - [ErrorResponse](docs/ErrorResponse.md)
 - [EventsGetResponse](docs/EventsGetResponse.md)
 - [EventsUpdateRequest](docs/EventsUpdateRequest.md)
 - [FactoryReset](docs/FactoryReset.md)
 - [Frida](docs/Frida.md)
 - [Geolocation](docs/Geolocation.md)
 - [GeolocationCity](docs/GeolocationCity.md)
 - [GeolocationContinent](docs/GeolocationContinent.md)
 - [GeolocationCountry](docs/GeolocationCountry.md)
 - [GeolocationSubdivision](docs/GeolocationSubdivision.md)
 - [HighActivity](docs/HighActivity.md)
 - [IPBlocklist](docs/IPBlocklist.md)
 - [IPBlocklistDetails](docs/IPBlocklistDetails.md)
 - [IPInfo](docs/IPInfo.md)
 - [IPInfoASN](docs/IPInfoASN.md)
 - [IPInfoDataCenter](docs/IPInfoDataCenter.md)
 - [IPInfoV4](docs/IPInfoV4.md)
 - [IPInfoV6](docs/IPInfoV6.md)
 - [Identification](docs/Identification.md)
 - [IdentificationConfidence](docs/IdentificationConfidence.md)
 - [IdentificationSeenAt](docs/IdentificationSeenAt.md)
 - [Incognito](docs/Incognito.md)
 - [Jailbroken](docs/Jailbroken.md)
 - [LocationSpoofing](docs/LocationSpoofing.md)
 - [MitMAttack](docs/MitMAttack.md)
 - [PrivacySettings](docs/PrivacySettings.md)
 - [ProductBotd](docs/ProductBotd.md)
 - [ProductClonedApp](docs/ProductClonedApp.md)
 - [ProductDeveloperTools](docs/ProductDeveloperTools.md)
 - [ProductEmulator](docs/ProductEmulator.md)
 - [ProductFactoryReset](docs/ProductFactoryReset.md)
 - [ProductFrida](docs/ProductFrida.md)
 - [ProductHighActivity](docs/ProductHighActivity.md)
 - [ProductIPBlocklist](docs/ProductIPBlocklist.md)
 - [ProductIPInfo](docs/ProductIPInfo.md)
 - [ProductIdentification](docs/ProductIdentification.md)
 - [ProductIncognito](docs/ProductIncognito.md)
 - [ProductJailbroken](docs/ProductJailbroken.md)
 - [ProductLocationSpoofing](docs/ProductLocationSpoofing.md)
 - [ProductMitMAttack](docs/ProductMitMAttack.md)
 - [ProductPrivacySettings](docs/ProductPrivacySettings.md)
 - [ProductProxy](docs/ProductProxy.md)
 - [ProductRawDeviceAttributes](docs/ProductRawDeviceAttributes.md)
 - [ProductRemoteControl](docs/ProductRemoteControl.md)
 - [ProductRootApps](docs/ProductRootApps.md)
 - [ProductSuspectScore](docs/ProductSuspectScore.md)
 - [ProductTampering](docs/ProductTampering.md)
 - [ProductTor](docs/ProductTor.md)
 - [ProductVPN](docs/ProductVPN.md)
 - [ProductVelocity](docs/ProductVelocity.md)
 - [ProductVirtualMachine](docs/ProductVirtualMachine.md)
 - [Products](docs/Products.md)
 - [Proxy](docs/Proxy.md)
 - [RawDeviceAttribute](docs/RawDeviceAttribute.md)
 - [RawDeviceAttributeError](docs/RawDeviceAttributeError.md)
 - [RelatedVisitor](docs/RelatedVisitor.md)
 - [RelatedVisitorsResponse](docs/RelatedVisitorsResponse.md)
 - [RemoteControl](docs/RemoteControl.md)
 - [RootApps](docs/RootApps.md)
 - [SearchEventsResponse](docs/SearchEventsResponse.md)
 - [SearchEventsResponseEventsInner](docs/SearchEventsResponseEventsInner.md)
 - [SuspectScore](docs/SuspectScore.md)
 - [Tampering](docs/Tampering.md)
 - [Tor](docs/Tor.md)
 - [VPN](docs/VPN.md)
 - [VPNConfidence](docs/VPNConfidence.md)
 - [VPNMethods](docs/VPNMethods.md)
 - [Velocity](docs/Velocity.md)
 - [VelocityData](docs/VelocityData.md)
 - [VelocityIntervals](docs/VelocityIntervals.md)
 - [VirtualMachine](docs/VirtualMachine.md)
 - [Visit](docs/Visit.md)
 - [VisitorsGetResponse](docs/VisitorsGetResponse.md)
 - [Webhook](docs/Webhook.md)
 - [WebhookClonedApp](docs/WebhookClonedApp.md)
 - [WebhookDeveloperTools](docs/WebhookDeveloperTools.md)
 - [WebhookEmulator](docs/WebhookEmulator.md)
 - [WebhookFactoryReset](docs/WebhookFactoryReset.md)
 - [WebhookFrida](docs/WebhookFrida.md)
 - [WebhookHighActivity](docs/WebhookHighActivity.md)
 - [WebhookIPBlocklist](docs/WebhookIPBlocklist.md)
 - [WebhookIPInfo](docs/WebhookIPInfo.md)
 - [WebhookJailbroken](docs/WebhookJailbroken.md)
 - [WebhookLocationSpoofing](docs/WebhookLocationSpoofing.md)
 - [WebhookMitMAttack](docs/WebhookMitMAttack.md)
 - [WebhookPrivacySettings](docs/WebhookPrivacySettings.md)
 - [WebhookProxy](docs/WebhookProxy.md)
 - [WebhookRemoteControl](docs/WebhookRemoteControl.md)
 - [WebhookRootApps](docs/WebhookRootApps.md)
 - [WebhookSuspectScore](docs/WebhookSuspectScore.md)
 - [WebhookTampering](docs/WebhookTampering.md)
 - [WebhookTor](docs/WebhookTor.md)
 - [WebhookVPN](docs/WebhookVPN.md)
 - [WebhookVelocity](docs/WebhookVelocity.md)
 - [WebhookVirtualMachine](docs/WebhookVirtualMachine.md)


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
