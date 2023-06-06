

# TamperingResult


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**result** | **Boolean** | Flag indicating whether browser tampering was detected according to our internal thresholds. |  [optional] |
|**anomalyScore** | [**BigDecimal**](BigDecimal.md) | Confidence score (`0.0 - 1.0`) for the tampering detection. Values above `0.5` suggest that we're reasonably sure there was a tampering attempt. Values below `0.5` are genuine browsers. |  [optional] |



