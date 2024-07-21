

# TamperingResult


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**result** | **Boolean** | Flag indicating whether browser tampering was detected according to our internal thresholds. |  |
|**anomalyScore** | **BigDecimal** | Confidence score (&#x60;0.0 - 1.0&#x60;) for the tampering detection. Values above &#x60;0.5&#x60; suggest that we&#39;re reasonably sure there was a tampering attempt. Values below &#x60;0.5&#x60; are genuine browsers. |  |



