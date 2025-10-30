

# Proximity

Proximity ID represents a fixed geographical zone in a discrete global grid within which the device is observed. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | A stable privacy-preserving identifier for a given proximity zone.  |  |
|**precisionRadius** | [**PrecisionRadiusEnum**](#PrecisionRadiusEnum) | The radius of the proximity zone’s precision level, in meters.  |  |
|**confidence** | **Float** | A value between &#x60;0&#x60; and &#x60;1&#x60; representing the likelihood that the true device location lies within the mapped proximity zone.   * Scores closer to &#x60;1&#x60; indicate high confidence that the location is inside the mapped proximity zone.   * Scores closer to &#x60;0&#x60; indicate lower confidence, suggesting the true location may fall in an adjacent zone.  |  |



## Enum: PrecisionRadiusEnum

| Name | Value |
|---- | -----|
| NUMBER_10 | 10 |
| NUMBER_25 | 25 |
| NUMBER_65 | 65 |
| NUMBER_175 | 175 |
| NUMBER_450 | 450 |
| NUMBER_1200 | 1200 |
| NUMBER_3300 | 3300 |
| NUMBER_8500 | 8500 |
| NUMBER_22500 | 22500 |



