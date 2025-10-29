

# ErrorCode
Error code:
* `request_cannot_be_parsed` - The query parameters or JSON payload contains some errors
  that prevented us from parsing it (wrong type/surpassed limits).
* `secret_api_key_required` - secret API key in header is missing or empty.
* `secret_api_key_not_found` - No Fingerprint application found for specified secret API key.
* `public_api_key_required` - public API key in header is missing or empty.
* `public_api_key_not_found` - No Fingerprint application found for specified public API key.
* `subscription_not_active` - Fingerprint application is not active.
* `wrong_region` - Server and application region differ.
* `feature_not_enabled` - This feature (for example, Delete API) is not enabled for your application.
* `request_not_found` - The specified event ID was not found. It never existed, expired, or it has been deleted.
* `visitor_not_found` - The specified visitor ID was not found. It never existed or it may have already been deleted.
* `too_many_requests` - The limit on secret API key requests per second has been exceeded.
* `state_not_ready` - The event specified with event ID is
  not ready for updates yet. Try again.
  This error happens in rare cases when update API is called immediately
  after receiving the event ID on the client. In case you need to send
  information right away, we recommend using the JS agent API instead.
* `failed` - Internal server error.
* `event_not_found` - The specified event ID was not found. It never existed, expired, or it has been deleted.
* `missing_module` - The request is invalid because it is missing a required module.
* `payload_too_large` - The request payload is too large and cannot be processed.


## Enum


* `REQUEST_CANNOT_BE_PARSED` (value: `"request_cannot_be_parsed"`)

* `SECRET_API_KEY_REQUIRED` (value: `"secret_api_key_required"`)

* `SECRET_API_KEY_NOT_FOUND` (value: `"secret_api_key_not_found"`)

* `PUBLIC_API_KEY_REQUIRED` (value: `"public_api_key_required"`)

* `PUBLIC_API_KEY_NOT_FOUND` (value: `"public_api_key_not_found"`)

* `SUBSCRIPTION_NOT_ACTIVE` (value: `"subscription_not_active"`)

* `WRONG_REGION` (value: `"wrong_region"`)

* `FEATURE_NOT_ENABLED` (value: `"feature_not_enabled"`)

* `REQUEST_NOT_FOUND` (value: `"request_not_found"`)

* `VISITOR_NOT_FOUND` (value: `"visitor_not_found"`)

* `TOO_MANY_REQUESTS` (value: `"too_many_requests"`)

* `STATE_NOT_READY` (value: `"state_not_ready"`)

* `FAILED` (value: `"failed"`)

* `EVENT_NOT_FOUND` (value: `"event_not_found"`)

* `MISSING_MODULE` (value: `"missing_module"`)

* `PAYLOAD_TOO_LARGE` (value: `"payload_too_large"`)



