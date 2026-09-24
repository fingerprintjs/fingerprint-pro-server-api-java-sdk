---
"fingerprint-pro-server-api-java-sdk": patch
---

**sdk**: `getEvent`, `updateEvent`, `getVisits`, and `deleteVisitorData` now validate their ID path parameter and throw an `ApiException` without sending a request when the value is not a valid identifier.
