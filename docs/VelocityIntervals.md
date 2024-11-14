

# VelocityIntervals

Is absent if the velocity data could not be generated for the visitor ID. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**_5m** | **Integer** |  |  |
|**_1h** | **Integer** |  |  |
|**_24h** | **Integer** | The `24h` interval of `distinctIp`, `distinctLinkedId`, `distinctCountry`, `distinctIpByLinkedId` and `distinctVisitorIdByLinkedId` will be omitted if the number of `events`` for the visitor ID in the last 24 hours (`events.intervals.['24h']`) is higher than 20.000.  |  [optional] |



