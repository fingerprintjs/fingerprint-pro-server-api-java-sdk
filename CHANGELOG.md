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
