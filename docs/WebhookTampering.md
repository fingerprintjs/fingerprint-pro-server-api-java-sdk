

# WebhookTampering


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**result** | **Boolean** | Flag indicating browser tampering was detected. This happens when either of these conditions is true:   * There are inconsistencies in the browser configuration that cross our internal tampering thresholds (indicated by `anomalyScore`).   * The browser signature resembles one of \"anti-detect\" browsers specifically designed to evade identification and fingerprinting, for example, Incognition (indicated by `antiDetectBrowser`).  |  [optional] |
|**anomalyScore** | **Double** | Confidence score (`0.0 - 1.0`) for tampering detection:   * Values above `0.5` indicate that there was a tampering attempt   * Values below `0.5` indicate genuine browsers.  |  [optional] |
|**antiDetectBrowser** | **Boolean** | Is `true` if the identified browser resembles one of \"anti-detect\" browsers, for example, Incognition. Anti-detect browsers try to evade identification by masking or manipulating their fingerprint to imitate legitimate browser configurations. |  [optional] |



