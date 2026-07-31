

# RareDevice

Rare device details (present if the device is considered rare)
> This Smart Signal is currently in beta and only available to select customers. If you are interested, please [contact our support team](https://fingerprint.com/support/).


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**result** | **Boolean** | `true` if the device is considered rare based on its combination of hardware and software attributes. A device is classified as rare if it falls within the top 99.9 percentile (lowest-frequency segment) of observed traffic, or if its configuration has not been previously seen (`not_seen`).  |  [optional] |
|**percentileBucket** | [**PercentileBucketEnum**](#PercentileBucketEnum) | The rarity percentile bucket of the device, indicating how uncommon the device configuration is compared to all observed devices.  |  [optional] |


## Enum: PercentileBucketEnum

| Name | Value |
|---- | ----- |
| _P95 | &quot;&lt;p95&quot; |
| P95_P99 | &quot;p95-p99&quot; |
| P99_P99_5 | &quot;p99-p99.5&quot; |
| P99_5_P99_9 | &quot;p99.5-p99.9&quot; |
| P99_9_ | &quot;p99.9+&quot; |
| NOT_SEEN | &quot;not_seen&quot; |



