

# IPLocation

This field is **deprecated** and will not return a result for **accounts created after December 18th, 2023**. Please use the [`ipInfo` Smart signal](https://dev.fingerprint.com/docs/smart-signals-overview#ip-geolocation) for geolocation information.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accuracyRadius** | **Integer** | The IP address is likely to be within this radius (in km) of the specified location. |  [optional] |
|**latitude** | **Double** |  |  [optional] |
|**longitude** | **Double** |  |  [optional] |
|**postalCode** | **String** |  |  [optional] |
|**timezone** | **String** |  |  [optional] |
|**city** | [**IPLocationCity**](IPLocationCity.md) |  |  [optional] |
|**country** | [**Location**](Location.md) |  |  [optional] |
|**continent** | [**Location**](Location.md) |  |  [optional] |
|**subdivisions** | [**List&lt;Subdivision&gt;**](Subdivision.md) |  |  [optional] |



