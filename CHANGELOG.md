## [6.0.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v5.1.1...v6.0.0) (2024-08-08)


### ⚠ BREAKING CHANGES

* use Jakarta EE 9
* use java 11 as minimal supported version

### Features

* add `remoteControl`, `velocity` and `developerTools` signals ([5648a7f](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/5648a7faf93ee046f877a91c6b3400cf95b2401f))
* add `Webhook.IsValidWebhookSignature` function for validating webhook signature ([033a98f](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/033a98f0a770fe7665ca2268e09b9d6292e07f47))
* add DELETE API ([db4832f](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/db4832f724a76b0259c5a1144b0ab78692675ea0))


### Continuous Integration

* update jakarta annotation api to 2.0.0 ([ac41c7a](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/ac41c7afa5673ce252eb74c07fdd902ef358a9dc))
* use java 11 for release build ([b9e9a00](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/b9e9a001adf152186525142e5052aaa80cb7a3fe))

## [5.1.1](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v5.1.0...v5.1.1) (2024-06-27)


### Bug Fixes

* assemble the jar as a library not a fat jar ([b2a33d4](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/b2a33d46228b9082435f05c9f67bd8586500b95b))

## [5.1.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v5.0.0...v5.1.0) (2024-03-27)


### Features

* support java versions 17 and 21 ([6398cfc](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/6398cfc001cd59a188f867094fbaadf78e0881ce))

## [5.0.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v4.0.0...v5.0.0) (2024-03-04)


### ⚠ BREAKING CHANGES

* change `url` field type from URI to String

### Features

* change `url` field format to String ([700fa96](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/700fa96e179be9f005466606887c8f8a6d832fc9))

## [4.0.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v3.1.0...v4.0.0) (2024-02-29)


### ⚠ BREAKING CHANGES

* change models for the most smart signals
* make identification field `confidence` optional
* deprecated `ipLocation` field uses `DeprecatedIpLocation` model

### Features

* add `linkedId` field to the `BotdResult` type ([044109e](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/044109e37b77b37c9be489e457af874f79bd8a31))
* add `SuspectScore` smart signal support ([c66373e](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/c66373e5ff3ee194d1fea05329ab10f1c21544cf))
* add missed errors structures ([efb8fd6](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/efb8fd65ceb210b0b9113f38ef99e20e731078c6))
* fix `ipLocation` deprecation ([f61a78d](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/f61a78d61e69b8abaf3f92f0c8174bc857ec1c81))
* make identification field `tag` required ([069d9c5](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/069d9c506311e1bd0bd835ba46a4809658b107ab))
* update `originCountry` field to the `vpn` signal ([1a7451b](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/1a7451b872d2725b0fe16a788f3f665e70c2c10b))
* use shared structures for webhooks and event ([69bfd84](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/69bfd84b6d834c9957a584d7e6b1151172fa1930))


### Bug Fixes

* make fields required according to real API response ([a94fd56](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/a94fd56417f5de340215f15eb0806006e157e4e6))

## [3.1.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v3.0.0...v3.1.0) (2024-02-14)


### Features

* add method for decoding sealed results ([04986dc](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/04986dc77ef730de9163415065535061ed5dbc04))

## [3.0.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v2.2.0...v3.0.0) (2024-01-12)


### ⚠ BREAKING CHANGES

* `IpInfo` field `dataCenter` renamed to `datacenter`

### Features

* mark `IPLocation` as deprecated ([51bcc21](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/51bcc21388320a5af91dcfb0fff39db587bd21fc))
* use `datacenter` instead of the wrong `dataCenter` ([33f7336](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/33f733677cabe7b2ec94a6aad5f5b786070576f9))

## [2.2.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v2.1.1...v2.2.0) (2023-11-27)


### Features

* add `highActivity` and `locationSpoofing` signals, support `originTimezone` for `vpn` signal ([1d0e19d](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/1d0e19df7a7e511f7490d48580b922f076f731fb))

## [2.1.1](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v2.1.0...v2.1.1) (2023-09-19)


### Bug Fixes

* update OpenAPI Schema with `asn` and `dataCenter` signals ([9fd2591](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/9fd2591a20fd8ad8e451624b0e880a94dd715b21))
* update OpenAPI Schema with `auxiliaryMobile` method for VPN signal ([15ca8db](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/15ca8db508448fcfc0cee90a18f7c513b3ccde4e))

## [2.1.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v2.0.0...v2.1.0) (2023-07-31)


### Features

* add RawDeviceAttributes signal ([ae12318](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/ae12318beb679f4e5cbe4fa857fc007c295e3b8b))
* add smart signals support ([adaceb6](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/adaceb69ef86b65eed0cb0f2ab2c2b4af218cdf8))

## [2.1.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v2.0.0...v2.1.0) (2023-07-31)


### Features

* add RawDeviceAttributes signal ([ae12318](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/ae12318beb679f4e5cbe4fa857fc007c295e3b8b))
* add smart signals support ([adaceb6](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/adaceb69ef86b65eed0cb0f2ab2c2b4af218cdf8))

## [2.0.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v1.1.0...v2.0.0) (2023-06-06)


### ⚠ BREAKING CHANGES

* `IpLocation` and it's fields are optional now.
For `getVisits` method `before` argument is deprecated, use `paginationKey` instead.

### Features

* update schema with correct IpLocation format and doc updates ([1c9b895](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/1c9b895c341340a299c612d01438d79ffa6fe49f))


### Bug Fixes

* fix backtick problem in comments and documentation ([10ade24](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/10ade24eb537ac8b1bc435aefdac7308b2adaea3))

## [1.1.0](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v1.0.0...v1.1.0) (2023-05-16)


### Features

* update schema and add more signals ([c48bd62](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/c48bd62812198a4dcdf0a42b8a98f7d8abc6a307))


### Bug Fixes

* remove wrong documentation links (swagger-codegen bug) ([ae5b376](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/ae5b3765bd30b8273b7eb0f0da2e70c12c6b9aa4))
* **types:** don't fail on unknown fields ([5d66f12](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/5d66f12988e9fa5a953518f638c9df75774b5232))
* update schema ([d4d1504](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/d4d15042a8547136d47302b4ee86e6f5909b64fc))
* update schema ([7dd69c4](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/7dd69c4b1a8d2d2c7e506632b8892553eebd86e7))
* update schema with correct Webhook Signals description ([6a0c48d](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/6a0c48d1463e5e6671a944aaa45533063fbc4617))

## 1.0.0 (2023-02-17)


### Features

* **version:** initial version ([4c651e5](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/4c651e5b70a943f367572dd433a6fd9d1b8aad96))
