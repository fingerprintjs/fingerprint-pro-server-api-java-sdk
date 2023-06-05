## [2.0.0-develop.3](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v2.0.0-develop.2...v2.0.0-develop.3) (2023-06-05)


### Bug Fixes

* fix release workflow for generate.sh again ([ac085ce](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/ac085cee7b8f0934d83476071bee28a554b8676b))

## [2.0.0-develop.2](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v2.0.0-develop.1...v2.0.0-develop.2) (2023-06-05)


### Bug Fixes

* fix release workflow for generate.sh ([23325be](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/23325beac93d5b839d3d336fed0f4af1336cd219))

## [2.0.0-develop.1](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/compare/v1.1.0...v2.0.0-develop.1) (2023-06-05)


### ⚠ BREAKING CHANGES

* `IpLocation` and it's fields are optional now.
For `getVisits` method `before` argument is deprecated, use `paginationKey` instead.

### Features

* update schema with correct IpLocation format and doc updates ([1c9b895](https://github.com/fingerprintjs/fingerprint-pro-server-api-java-sdk/commit/1c9b895c341340a299c612d01438d79ffa6fe49f))

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
