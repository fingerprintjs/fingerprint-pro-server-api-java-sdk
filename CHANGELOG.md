# Fingerprint Pro Server Java SDK

## 7.3.0-develop.1

### Minor Changes

- **events-search**: Add 'pagination_key' parameter ([22dd46a](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/22dd46ae3c266427f289568276be7da90a1a5cc9))

### Patch Changes

- **events-search**: Improve parameter descriptions for `bot`, `suspect` ([cfacdcf](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/cfacdcfa6c8752f08b9974295da3f423ca1f285b))

## 7.3.0-develop.0

### Minor Changes

- **events-search**: Add a new `events/search` API endpoint. Allow users to search for identification events matching one or more search criteria, for example, visitor ID, IP address, bot detection result, etc. ([a276c75](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/a276c75ded03addd8cffd602587c37447ace2e3a))

## 7.2.0

### Minor Changes

- Add Related Visitors API ([e49248a](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/e49248a8337df05f5eb573ddc5f74f88e8f17fed))

### Patch Changes

- Fix invalid phrasing for methods that append to lists in the models ([5d1431e](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/5d1431e256e418d7c1de3261260f8c875026ce10))

## 7.1.0

### Minor Changes

- Add `relay` detection method to the VPN Detection Smart Signal ([3b6d78f](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/3b6d78f162d06b3d3e633fce9227c7ee734e8722))
- **events**: Add a `suspect` field to the `identification` product schema ([3b6d78f](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/3b6d78f162d06b3d3e633fce9227c7ee734e8722))

## 7.0.0

### Major Changes

The underlying Server API hasn’t changed, but we made SDK type and class generation more precise, resulting in small breaking changes for the SDK itself. This change should make the SDK API a lot more stable going forward

- Rename `Webhook` class to `WebhookValidation`.
  Right now, `Webhook` class points to the actual data model. ([817b444](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/817b4443db7d9eea45ac36d3843335762ead01b5))
- - Remove the `BrowserDetails` field `botProbability`.
  - Update the `IdentificationConfidence` field `score` type format: `float` -> `double`.
  - Make the `RawDeviceAttributeError` field `name` **optional** .
  - Make the `RawDeviceAttributeError` field `message` **optional** .
  - **events**: Remove the `EventsResponse` field `error`.
    - [note]: The errors are represented by `ErrorResponse` model.
  - **events**: Update the `HighActivity` field `dailyRequests` type format: `number` -> `int64`.
  - **events**: Specify the `Tampering` field `anomalyScore` type format: `double`.
  - **webhook**: Make the `Webhook` fields **optional**: `visitorId`, `visitorFound`, `firstSeenAt`, `lastSeenAt`, `browserDetails`, `incognito`.
  - **webhook**: Make the `WebhookClonedApp` field `result` **optional**.
  - **webhook**: Make the `WebhookDeveloperTools` field `result` **optional**.
  - **webhook**: Make the `WebhookEmulator` field `result` **optional**.
  - **webhook**: Make the `WebhookFactoryReset` fields `time` and `timestamp` **optional**.
  - **webhook**: Make the `WebhookFrida` field `result` **optional**.
  - **webhook**: Update the `WebhookHighActivity` field `dailyRequests` type format: `number` -> `int64`.
  - **webhook**: Make the `WebhookIPBlocklist` fields `result` and `details` **optional**.
  - **webhook**: Make the `WebhookJailbroken` field `result` **optional**.
  - **webhook**: Make the `WebhookLocationSpoofing` field `result` **optional**.
  - **webhook**: Make the `WebhookPrivacySettings` field `result` **optional**.
  - **webhook**: Make the `WebhookProxy` field `result` **optional**.
  - **webhook**: Make the `WebhookRemoteControl` field `result` **optional**.
  - **webhook**: Make the `WebhookRootApps` field `result` **optional**.
  - **webhook**: Make the `WebhookSuspectScore` field `result` **optional**.
  - **webhook**: Make the `WebhookTampering` fields `result`, `anomalyScore` and `antiDetectBrowser` **optional**.
  - **webhook**: Specify the `WebhookTampering` field `anomalyScore` type format: `double`.
  - **webhook**: Make the `WebhookTor` field `result` **optional**.
  - **webhook**: Make the `WebhookVelocity` fields **optional**: `distinctIp`, `distinctLinkedId`, `distinctCountry`, `events`, `ipEvents`, `distinctIpByLinkedId`, `distinctVisitorIdByLinkedId`.
  - **webhook**: Make the `WebhookVirtualMachine` field `result` **optional**.
  - **webhook**: Make the `WebhookVPN` fields **optional**: `result`, `confidence`, `originTimezone`, `methods`. ([a09ca88](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/a09ca889b294900929a6aaab567a4f3a019f3e73))
- - Rename `BotdResult` -> `Botd`.
  - Rename `BotdDetectionResult` -> `BotdBot`:
    - Extract `result` type as `BotdBotResult`.
  - Rename `ClonedAppResult` -> `ClonedApp`.
  - Rename `DeveloperToolsResult` -> `DeveloperTools`.
  - Rename `EmulatorResult` -> `Emulator`.
  - Refactor error models:
    - Remove `ErrorCommon403Response`, `ErrorCommon429Response`, `ErrorEvent404Response`, `TooManyRequestsResponse`, `ErrorVisits403`, `ErrorUpdateEvent400Response`, `ErrorUpdateEvent409Response`, `ErrorVisitor400Response`, `ErrorVisitor404Response`, `IdentificationError`, `ProductError`.
    - Introduce `ErrorResponse` and `ErrorPlainResponse`.
      - [note]: `ErrorPlainResponse` has a different format `{ "error": string }` and it is used only in `GET /visitors`.
    - Extract `error` type as `Error`.
    - Extract `error.code` type as `ErrorCode`.
  - Rename `EventResponse` -> `EventsGetResponse`.
  - Rename `EventUpdateRequest` -> `EventsUpdateRequest`.
  - Rename `FactoryResetResult` -> `FactoryReset`.
  - Rename `FridaResult` -> `Frida`.
  - Rename `IPLocation` -> `Geolocation`:
    - Rename `IPLocationCity` -> `GeolocationCity`.
    - Extract `subdivisions` type as `GeolocationSubdivisions`.
    - Rename `Location` -> `GeolocationContinent`:
    - Introduce a dedicated type `GeolocationCountry`.
    - Rename `Subdivision` -> `GeolocationSubdivision`.
  - Rename `HighActivityResult` -> `HighActivity`.
  - Rename `Confidence` -> `IdentificationConfidence`.
  - Rename `SeenAt` -> `IdentificationSeenAt`.
  - Rename `IncognitoResult` -> `Incognito`.
  - Rename `IpBlockListResult` -> `IPBlocklist`:
    - Extract `details` type as `IPBlocklistDetails`.
  - Rename `IpInfoResult` -> `IPInfo`:
    - Rename `IpInfoResultV4` -> `IPInfoV4`.
    - Rename `IpInfoResultV6` -> `IPInfoV6`.
    - Rename `ASN` -> `IPInfoASN`.
    - Rename `DataCenter` -> `IPInfoDataCenter`.
  - Rename `JailbrokenResult` -> `Jailbroken`.
  - Rename `LocationSpoofingResult` -> `LocationSpoofing`.
  - Rename `PrivacySettingsResult` -> `PrivacySettings`.
  - Rename `ProductsResponse` -> `Products`:
    - Rename inner types: `ProductsResponseIdentification` -> `ProductIdentification`, `ProductsResponseIdentificationData` -> `Identification`, `ProductsResponseBotd` -> `ProductBotd`, `SignalResponseRootApps` -> `ProductRootApps`, `SignalResponseEmulator` -> `ProductEmulator`, `SignalResponseIpInfo` -> `ProductIPInfo`, `SignalResponseIpBlocklist` -> `ProductIPBlocklist`, `SignalResponseTor` -> `ProductTor`, `SignalResponseVpn` -> `ProductVPN`, `SignalResponseProxy` -> `ProductProxy`, `ProxyResult` -> `Proxy`, `SignalResponseIncognito` -> `ProductIncognito`, `SignalResponseTampering` -> `ProductTampering`, `SignalResponseClonedApp` -> `ProductClonedApp`, `SignalResponseFactoryReset` -> `ProductFactoryReset`, `SignalResponseJailbroken` -> `ProductJailbroken`, `SignalResponseFrida` -> `ProductFrida`, `SignalResponsePrivacySettings` -> `ProductPrivacySettings`, `SignalResponseVirtualMachine` -> `ProductVirtualMachine`, `SignalResponseRawDeviceAttributes` -> `ProductRawDeviceAttributes`, `RawDeviceAttributesResultValue` -> `RawDeviceAttributes`, `SignalResponseHighActivity` -> `ProductHighActivity`, `SignalResponseLocationSpoofing` -> `ProductLocationSpoofing`, `SignalResponseSuspectScore` -> `ProductSuspectScore`, `SignalResponseRemoteControl` -> `ProductRemoteControl`, `SignalResponseVelocity` -> `ProductVelocity`, `SignalResponseDeveloperTools` -> `ProductDeveloperTools`.
    - Extract `identification.data` type as `Identification`.
  - Rename `RawDeviceAttributesResult` -> `RawDeviceAttributes`:
    - Extract item type as `RawDeviceAttribute`.
    - Extract `error` type as `RawDeviceAttributeError`.
  - Rename `RemoteControlResult` -> `RemoteControl`.
  - Rename `RootAppsResult` -> `RootApps`.
  - Rename `SuspectScoreResult` -> `SuspectScore`.
  - Extract new model `Tag`.
  - Rename `TamperingResult` -> `Tampering`.
  - Rename `TorResult` -> `Tor`.
  - Rename `VelocityResult` -> `Velocity`:
    - Rename `VelocityIntervals` -> `VelocityData`.
    - Rename `VelocityIntervalResult` -> `VelocityIntervals`.
  - Rename `VirtualMachineResult` -> `VirtualMachine`.
  - Rename the `Visit` field `ipLocation` type `DeprecatedIPLocation` -> `DeprecatedGeolocation`.
    - Instead of `DeprecatedIPLocationCity` use common `GeolocationCity`
  - Rename `Response` -> `VisitorsGetResponse`.
    - Omit extra inner type `ResponseVisits`
  - Rename `VpnResult` -> `VPN`.
    - Extract `confidence` type as `VPNConfidence`.
    - Extract `methods` type as `VPNMethods`.
  - Rename `WebhookVisit` -> `Webhook`.
    - Introduce new inner types: `WebhookRootApps`, `WebhookEmulator`, `WebhookIPInfo`, `WebhookIPBlocklist`, `WebhookTor`, `WebhookVPN`, `WebhookProxy`, `WebhookTampering`, `WebhookClonedApp`, `WebhookFactoryReset`, `WebhookJailbroken`, `WebhookFrida`, `WebhookPrivacySettings`, `WebhookVirtualMachine`, `WebhookRawDeviceAttributes`, `WebhookHighActivity`, `WebhookLocationSpoofing`, `WebhookSuspectScore`, `WebhookRemoteControl`, `WebhookVelocity`, `WebhookDeveloperTools`. ([a09ca88](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/a09ca889b294900929a6aaab567a4f3a019f3e73))
- Rename `IsValidWebhookSignature` to `isSignatureValid` in `WebhookValidation` ([f49c1c2](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/f49c1c2cd754af8e1f763559886d30ce69567a39))

### Minor Changes

- Added new `ipEvents`, `distinctIpByLinkedId`, and `distinctVisitorIdByLinkedId` fields to the `velocity` Smart Signal. ([a09ca88](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/a09ca889b294900929a6aaab567a4f3a019f3e73))
- - Make the `GeolocationCity` field `name` **required**.
  - Make the `GeolocationSubdivision` field `isoCode` **required**.
  - Make the `GeolocationSubdivision` field `name` **required**.
  - Make the `IPInfoASN` field `name` **required** .
  - Make the `IPInfoDataCenter` field `name` **required**.
  - Add **optional** `IdentificationConfidence` field `comment`.
  - **events**: Add **optional** `Botd` field `meta`.
  - **events**: Add **optional** `Identification` field `components`.
  - **events**: Make the `VPN` field `originCountry` **required**.
  - **visitors**: Add **optional** `Visit` field `components`.
  - **webhook**: Add **optional** `Webhook` field `components`. ([a09ca88](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/a09ca889b294900929a6aaab567a4f3a019f3e73))
- Remove `ipv4` format from `ip` field in `Botd`, `Identification`, `Visit` and `Webhook` models. ([d608cfe](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/d608cfeb3d0007fff9f6742255f8110a5f4ae3e1))
- **events**: Add `antiDetectBrowser` detection method to the `tampering` Smart Signal. ([a09ca88](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/a09ca889b294900929a6aaab567a4f3a019f3e73))

### Patch Changes

- - Fix descriptions formatting:
    - Remove extra line breaks.
    - Fix block styles.
  - Fix links in descriptions. ([a09ca88](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/a09ca889b294900929a6aaab567a4f3a019f3e73))
- - Replace GET /events TooManyRequests examples with a single `get_event_200_too_many_requests_error.json`.
  - Update `products.identification.error.message` in `get_event_200_<...>.json` examples.
  - Rename GET /visitors example files. ([a09ca88](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/a09ca889b294900929a6aaab567a4f3a019f3e73))

## 7.0.0-develop.0

### Major Changes

- - Remove the `BrowserDetails` field `botProbability`.
  - Update the `IdentificationConfidence` field `score` type format: `float` -> `double`.
  - Make the `RawDeviceAttributeError` field `name` **optional** .
  - Make the `RawDeviceAttributeError` field `message` **optional** .
  - **events**: Remove the `EventsResponse` field `error`.
    - [note]: The errors are represented by `ErrorResponse` model.
  - **events**: Update the `HighActivity` field `dailyRequests` type format: `number` -> `int64`.
  - **events**: Specify the `Tampering` field `anomalyScore` type format: `double`.
  - **webhook**: Make the `Webhook` fields **optional**: `visitorId`, `visitorFound`, `firstSeenAt`, `lastSeenAt`, `browserDetails`, `incognito`.
  - **webhook**: Make the `WebhookClonedApp` field `result` **optional**.
  - **webhook**: Make the `WebhookDeveloperTools` field `result` **optional**.
  - **webhook**: Make the `WebhookEmulator` field `result` **optional**.
  - **webhook**: Make the `WebhookFactoryReset` fields `time` and `timestamp` **optional**.
  - **webhook**: Make the `WebhookFrida` field `result` **optional**.
  - **webhook**: Update the `WebhookHighActivity` field `dailyRequests` type format: `number` -> `int64`.
  - **webhook**: Make the `WebhookIPBlocklist` fields `result` and `details` **optional**.
  - **webhook**: Make the `WebhookJailbroken` field `result` **optional**.
  - **webhook**: Make the `WebhookLocationSpoofing` field `result` **optional**.
  - **webhook**: Make the `WebhookPrivacySettings` field `result` **optional**.
  - **webhook**: Make the `WebhookProxy` field `result` **optional**.
  - **webhook**: Make the `WebhookRemoteControl` field `result` **optional**.
  - **webhook**: Make the `WebhookRootApps` field `result` **optional**.
  - **webhook**: Make the `WebhookSuspectScore` field `result` **optional**.
  - **webhook**: Make the `WebhookTampering` fields `result`, `anomalyScore` and `antiDetectBrowser` **optional**.
  - **webhook**: Specify the `WebhookTampering` field `anomalyScore` type format: `double`.
  - **webhook**: Make the `WebhookTor` field `result` **optional**.
  - **webhook**: Make the `WebhookVelocity` fields **optional**: `distinctIp`, `distinctLinkedId`, `distinctCountry`, `events`, `ipEvents`, `distinctIpByLinkedId`, `distinctVisitorIdByLinkedId`.
  - **webhook**: Make the `WebhookVirtualMachine` field `result` **optional**.
  - **webhook**: Make the `WebhookVPN` fields **optional**: `result`, `confidence`, `originTimezone`, `methods`. ([a09ca88](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/a09ca889b294900929a6aaab567a4f3a019f3e73))
- - Rename `BotdResult` -> `Botd`.
  - Rename `BotdDetectionResult` -> `BotdBot`:
    - Extract `result` type as `BotdBotResult`.
  - Rename `ClonedAppResult` -> `ClonedApp`.
  - Rename `DeveloperToolsResult` -> `DeveloperTools`.
  - Rename `EmulatorResult` -> `Emulator`.
  - Refactor error models:
    - Remove `ErrorCommon403Response`, `ErrorCommon429Response`, `ErrorEvent404Response`, `TooManyRequestsResponse`, `ErrorVisits403`, `ErrorUpdateEvent400Response`, `ErrorUpdateEvent409Response`, `ErrorVisitor400Response`, `ErrorVisitor404Response`, `IdentificationError`, `ProductError`.
    - Introduce `ErrorResponse` and `ErrorPlainResponse`.
      - [note]: `ErrorPlainResponse` has a different format `{ "error": string }` and it is used only in `GET /visitors`.
    - Extract `error` type as `Error`.
    - Extract `error.code` type as `ErrorCode`.
  - Rename `EventResponse` -> `EventsGetResponse`.
  - Rename `EventUpdateRequest` -> `EventsUpdateRequest`.
  - Rename `FactoryResetResult` -> `FactoryReset`.
  - Rename `FridaResult` -> `Frida`.
  - Rename `IPLocation` -> `Geolocation`:
    - Rename `IPLocationCity` -> `GeolocationCity`.
    - Extract `subdivisions` type as `GeolocationSubdivisions`.
    - Rename `Location` -> `GeolocationContinent`:
    - Introduce a dedicated type `GeolocationCountry`.
    - Rename `Subdivision` -> `GeolocationSubdivision`.
  - Rename `HighActivityResult` -> `HighActivity`.
  - Rename `Confidence` -> `IdentificationConfidence`.
  - Rename `SeenAt` -> `IdentificationSeenAt`.
  - Rename `IncognitoResult` -> `Incognito`.
  - Rename `IpBlockListResult` -> `IPBlocklist`:
    - Extract `details` type as `IPBlocklistDetails`.
  - Rename `IpInfoResult` -> `IPInfo`:
    - Rename `IpInfoResultV4` -> `IPInfoV4`.
    - Rename `IpInfoResultV6` -> `IPInfoV6`.
    - Rename `ASN` -> `IPInfoASN`.
    - Rename `DataCenter` -> `IPInfoDataCenter`.
  - Rename `JailbrokenResult` -> `Jailbroken`.
  - Rename `LocationSpoofingResult` -> `LocationSpoofing`.
  - Rename `PrivacySettingsResult` -> `PrivacySettings`.
  - Rename `ProductsResponse` -> `Products`:
    - Rename inner types: `ProductsResponseIdentification` -> `ProductIdentification`, `ProductsResponseIdentificationData` -> `Identification`, `ProductsResponseBotd` -> `ProductBotd`, `SignalResponseRootApps` -> `ProductRootApps`, `SignalResponseEmulator` -> `ProductEmulator`, `SignalResponseIpInfo` -> `ProductIPInfo`, `SignalResponseIpBlocklist` -> `ProductIPBlocklist`, `SignalResponseTor` -> `ProductTor`, `SignalResponseVpn` -> `ProductVPN`, `SignalResponseProxy` -> `ProductProxy`, `ProxyResult` -> `Proxy`, `SignalResponseIncognito` -> `ProductIncognito`, `SignalResponseTampering` -> `ProductTampering`, `SignalResponseClonedApp` -> `ProductClonedApp`, `SignalResponseFactoryReset` -> `ProductFactoryReset`, `SignalResponseJailbroken` -> `ProductJailbroken`, `SignalResponseFrida` -> `ProductFrida`, `SignalResponsePrivacySettings` -> `ProductPrivacySettings`, `SignalResponseVirtualMachine` -> `ProductVirtualMachine`, `SignalResponseRawDeviceAttributes` -> `ProductRawDeviceAttributes`, `RawDeviceAttributesResultValue` -> `RawDeviceAttributes`, `SignalResponseHighActivity` -> `ProductHighActivity`, `SignalResponseLocationSpoofing` -> `ProductLocationSpoofing`, `SignalResponseSuspectScore` -> `ProductSuspectScore`, `SignalResponseRemoteControl` -> `ProductRemoteControl`, `SignalResponseVelocity` -> `ProductVelocity`, `SignalResponseDeveloperTools` -> `ProductDeveloperTools`.
    - Extract `identification.data` type as `Identification`.
  - Rename `RawDeviceAttributesResult` -> `RawDeviceAttributes`:
    - Extract item type as `RawDeviceAttribute`.
    - Extract `error` type as `RawDeviceAttributeError`.
  - Rename `RemoteControlResult` -> `RemoteControl`.
  - Rename `RootAppsResult` -> `RootApps`.
  - Rename `SuspectScoreResult` -> `SuspectScore`.
  - Extract new model `Tag`.
  - Rename `TamperingResult` -> `Tampering`.
  - Rename `TorResult` -> `Tor`.
  - Rename `VelocityResult` -> `Velocity`:
    - Rename `VelocityIntervals` -> `VelocityData`.
    - Rename `VelocityIntervalResult` -> `VelocityIntervals`.
  - Rename `VirtualMachineResult` -> `VirtualMachine`.
  - Rename the `Visit` field `ipLocation` type `DeprecatedIPLocation` -> `DeprecatedGeolocation`.
    - Instead of `DeprecatedIPLocationCity` use common `GeolocationCity`
  - Rename `Response` -> `VisitorsGetResponse`.
    - Omit extra inner type `ResponseVisits`
  - Rename `VpnResult` -> `VPN`.
    - Extract `confidence` type as `VPNConfidence`.
    - Extract `methods` type as `VPNMethods`.
  - Rename `WebhookVisit` -> `Webhook`.
    - Introduce new inner types: `WebhookRootApps`, `WebhookEmulator`, `WebhookIPInfo`, `WebhookIPBlocklist`, `WebhookTor`, `WebhookVPN`, `WebhookProxy`, `WebhookTampering`, `WebhookClonedApp`, `WebhookFactoryReset`, `WebhookJailbroken`, `WebhookFrida`, `WebhookPrivacySettings`, `WebhookVirtualMachine`, `WebhookRawDeviceAttributes`, `WebhookHighActivity`, `WebhookLocationSpoofing`, `WebhookSuspectScore`, `WebhookRemoteControl`, `WebhookVelocity`, `WebhookDeveloperTools`. ([a09ca88](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/a09ca889b294900929a6aaab567a4f3a019f3e73))

### Minor Changes

- Added new `ipEvents`, `distinctIpByLinkedId`, and `distinctVisitorIdByLinkedId` fields to the `velocity` Smart Signal. ([a09ca88](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/a09ca889b294900929a6aaab567a4f3a019f3e73))
- - Make the `GeolocationCity` field `name` **required**.
  - Make the `GeolocationSubdivision` field `isoCode` **required**.
  - Make the `GeolocationSubdivision` field `name` **required**.
  - Make the `IPInfoASN` field `name` **required** .
  - Make the `IPInfoDataCenter` field `name` **required**.
  - Add **optional** `IdentificationConfidence` field `comment`.
  - **events**: Add **optional** `Botd` field `meta`.
  - **events**: Add **optional** `Identification` field `components`.
  - **events**: Make the `VPN` field `originCountry` **required**.
  - **visitors**: Add **optional** `Visit` field `components`.
  - **webhook**: Add **optional** `Webhook` field `components`. ([a09ca88](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/a09ca889b294900929a6aaab567a4f3a019f3e73))
- Remove `ipv4` format from `ip` field in `Botd`, `Identification`, `Visit` and `Webhook` models. ([d608cfe](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/d608cfeb3d0007fff9f6742255f8110a5f4ae3e1))
- **events**: Add `antiDetectBrowser` detection method to the `tampering` Smart Signal. ([a09ca88](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/a09ca889b294900929a6aaab567a4f3a019f3e73))

### Patch Changes

- - Fix descriptions formatting:
    - Remove extra line breaks.
    - Fix block styles.
  - Fix links in descriptions. ([a09ca88](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/a09ca889b294900929a6aaab567a4f3a019f3e73))
- - Replace GET /events TooManyRequests examples with a single `get_event_200_too_many_requests_error.json`.
  - Update `products.identification.error.message` in `get_event_200_<...>.json` examples.
  - Rename GET /visitors example files. ([a09ca88](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/a09ca889b294900929a6aaab567a4f3a019f3e73))

## 6.2.0

### Minor Changes

- **visitors**: Add the confidence field to the VPN Detection Smart Signal ([aec1770](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/aec1770034f91bef7fcd0775b99eb6baa74241de))

## 6.2.0-develop.0

### Minor Changes

- **visitors**: Add the confidence field to the VPN Detection Smart Signal ([aec1770](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/aec1770034f91bef7fcd0775b99eb6baa74241de))

## [6.1.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v6.0.2...v6.1.0) (2024-09-11)

### Features

- don't use `jackson-databind-nullable` to fix serialization problems with `Jackson` default configuration ([979b800](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/979b800c89d6ff9a44325043f99ec7fb7040f94a))

## [6.0.2](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v6.0.1...v6.0.2) (2024-09-09)

### Bug Fixes

- for `Sealed` use same `ObjectMapper` as for `FingerprintApi` ([7343655](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/734365587dbc52a504d17c051ef03cd85f6c2d34))

## [6.0.1](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v6.0.0...v6.0.1) (2024-08-20)

### Bug Fixes

- fix supported Java versions in the readme ([f889f03](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/f889f03918f26df3e83767a70f00bf147869875e))

## [6.0.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v5.1.1...v6.0.0) (2024-08-08)

### ⚠ BREAKING CHANGES

- use Jakarta EE 9
- use java 11 as minimal supported version

### Features

- add [Confidence Score v1.1](https://dev.fingerprint.com/docs/understanding-your-confidence-score-v11)
- add `remoteControl`, `velocity` and `developerTools` signals ([5648a7f](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/5648a7faf93ee046f877a91c6b3400cf95b2401f))
- add `Webhook.IsValidWebhookSignature` function for validating webhook signature ([033a98f](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/033a98f0a770fe7665ca2268e09b9d6292e07f47))
- add DELETE API ([db4832f](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/db4832f724a76b0259c5a1144b0ab78692675ea0))

### Continuous Integration

- update jakarta annotation api to 2.0.0 ([ac41c7a](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/ac41c7afa5673ce252eb74c07fdd902ef358a9dc))
- use java 11 for release build ([b9e9a00](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/b9e9a001adf152186525142e5052aaa80cb7a3fe))

## [5.1.1](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v5.1.0...v5.1.1) (2024-06-27)

### Bug Fixes

- assemble the jar as a library not a fat jar ([b2a33d4](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/b2a33d46228b9082435f05c9f67bd8586500b95b))

## [5.1.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v5.0.0...v5.1.0) (2024-03-27)

### Features

- support java versions 17 and 21 ([6398cfc](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/6398cfc001cd59a188f867094fbaadf78e0881ce))

## [5.0.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v4.0.0...v5.0.0) (2024-03-04)

### ⚠ BREAKING CHANGES

- change `url` field type from URI to String

### Features

- change `url` field format to String ([700fa96](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/700fa96e179be9f005466606887c8f8a6d832fc9))

## [4.0.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v3.1.0...v4.0.0) (2024-02-29)

### ⚠ BREAKING CHANGES

- change models for the most smart signals
- make identification field `confidence` optional
- deprecated `ipLocation` field uses `DeprecatedIpLocation` model

### Features

- add `linkedId` field to the `BotdResult` type ([044109e](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/044109e37b77b37c9be489e457af874f79bd8a31))
- add `SuspectScore` smart signal support ([c66373e](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/c66373e5ff3ee194d1fea05329ab10f1c21544cf))
- add missed errors structures ([efb8fd6](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/efb8fd65ceb210b0b9113f38ef99e20e731078c6))
- fix `ipLocation` deprecation ([f61a78d](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/f61a78d61e69b8abaf3f92f0c8174bc857ec1c81))
- make identification field `tag` required ([069d9c5](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/069d9c506311e1bd0bd835ba46a4809658b107ab))
- update `originCountry` field to the `vpn` signal ([1a7451b](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/1a7451b872d2725b0fe16a788f3f665e70c2c10b))
- use shared structures for webhooks and event ([69bfd84](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/69bfd84b6d834c9957a584d7e6b1151172fa1930))

### Bug Fixes

- make fields required according to real API response ([a94fd56](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/a94fd56417f5de340215f15eb0806006e157e4e6))

## [3.1.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v3.0.0...v3.1.0) (2024-02-14)

### Features

- add method for decoding sealed results ([04986dc](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/04986dc77ef730de9163415065535061ed5dbc04))

## [3.0.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v2.2.0...v3.0.0) (2024-01-12)

### ⚠ BREAKING CHANGES

- `IpInfo` field `dataCenter` renamed to `datacenter`

### Features

- mark `IPLocation` as deprecated ([51bcc21](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/51bcc21388320a5af91dcfb0fff39db587bd21fc))
- use `datacenter` instead of the wrong `dataCenter` ([33f7336](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/33f733677cabe7b2ec94a6aad5f5b786070576f9))

## [2.2.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v2.1.1...v2.2.0) (2023-11-27)

### Features

- add `highActivity` and `locationSpoofing` signals, support `originTimezone` for `vpn` signal ([1d0e19d](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/1d0e19df7a7e511f7490d48580b922f076f731fb))

## [2.1.1](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v2.1.0...v2.1.1) (2023-09-19)

### Bug Fixes

- update OpenAPI Schema with `asn` and `dataCenter` signals ([9fd2591](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/9fd2591a20fd8ad8e451624b0e880a94dd715b21))
- update OpenAPI Schema with `auxiliaryMobile` method for VPN signal ([15ca8db](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/15ca8db508448fcfc0cee90a18f7c513b3ccde4e))

## [2.1.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v2.0.0...v2.1.0) (2023-07-31)

### Features

- add RawDeviceAttributes signal ([ae12318](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/ae12318beb679f4e5cbe4fa857fc007c295e3b8b))
- add smart signals support ([adaceb6](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/adaceb69ef86b65eed0cb0f2ab2c2b4af218cdf8))

## [2.1.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v2.0.0...v2.1.0) (2023-07-31)

### Features

- add RawDeviceAttributes signal ([ae12318](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/ae12318beb679f4e5cbe4fa857fc007c295e3b8b))
- add smart signals support ([adaceb6](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/adaceb69ef86b65eed0cb0f2ab2c2b4af218cdf8))

## [2.0.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v1.1.0...v2.0.0) (2023-06-06)

### ⚠ BREAKING CHANGES

- `IpLocation` and it's fields are optional now.
  For `getVisits` method `before` argument is deprecated, use `paginationKey` instead.

### Features

- update schema with correct IpLocation format and doc updates ([1c9b895](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/1c9b895c341340a299c612d01438d79ffa6fe49f))

### Bug Fixes

- fix backtick problem in comments and documentation ([10ade24](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/10ade24eb537ac8b1bc435aefdac7308b2adaea3))

## [1.1.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v1.0.0...v1.1.0) (2023-05-16)

### Features

- update schema and add more signals ([c48bd62](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/c48bd62812198a4dcdf0a42b8a98f7d8abc6a307))

### Bug Fixes

- remove wrong documentation links (swagger-codegen bug) ([ae5b376](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/ae5b3765bd30b8273b7eb0f0da2e70c12c6b9aa4))
- **types:** don't fail on unknown fields ([5d66f12](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/5d66f12988e9fa5a953518f638c9df75774b5232))
- update schema ([d4d1504](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/d4d15042a8547136d47302b4ee86e6f5909b64fc))
- update schema ([7dd69c4](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/7dd69c4b1a8d2d2c7e506632b8892553eebd86e7))
- update schema with correct Webhook Signals description ([6a0c48d](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/6a0c48d1463e5e6671a944aaa45533063fbc4617))

## 1.0.0 (2023-02-17)

### Features

- **version:** initial version ([4c651e5](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/4c651e5b70a943f367572dd433a6fd9d1b8aad96))
