

# Velocity

Sums key data points for a specific `visitor_id`, `ip_address` and `linked_id` at three distinct time intervals: 5 minutes, 1 hour, and 24 hours as follows:   - Number of distinct IP addresses associated to the visitor Id. - Number of distinct linked Ids associated with the visitor Id. - Number of distinct countries associated with the visitor Id. - Number of identification events associated with the visitor Id. - Number of identification events associated with the detected IP address. - Number of distinct IP addresses associated with the provided linked Id. - Number of distinct visitor Ids associated with the provided linked Id.  The `24h` interval of `distinct_ip`, `distinct_linked_id`, `distinct_country`, `distinct_ip_by_linked_id` and `distinct_visitor_id_by_linked_id` will be omitted  if the number of `events` for the visitor Id in the last 24 hours (`events.['24h']`) is higher than 20.000.  All will not necessarily be returned in a response, some may be omitted if the  associated event does not have the required data, such as a linked_id. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**distinctIp** | [**VelocityData**](VelocityData.md) |  |  [optional] |
|**distinctLinkedId** | [**VelocityData**](VelocityData.md) |  |  [optional] |
|**distinctCountry** | [**VelocityData**](VelocityData.md) |  |  [optional] |
|**events** | [**VelocityData**](VelocityData.md) |  |  [optional] |
|**ipEvents** | [**VelocityData**](VelocityData.md) |  |  [optional] |
|**distinctIpByLinkedId** | [**VelocityData**](VelocityData.md) |  |  [optional] |
|**distinctVisitorIdByLinkedId** | [**VelocityData**](VelocityData.md) |  |  [optional] |



