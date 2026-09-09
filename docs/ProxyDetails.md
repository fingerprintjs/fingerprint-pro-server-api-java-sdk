

# ProxyDetails

Proxy detection details (present if proxy is detected)

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**proxyType** | [**ProxyTypeEnum**](#ProxyTypeEnum) | Proxy type:  * `residential` - proxies that route through residential and telecom IP addresses to appear as legitimate traffic  * `data_center` - proxies which route through data centers  * `unknown` - reported when a proxy is detected solely by the ML model and the IP sources did not determine a specific type  |  |
|**lastSeenAt** | **OffsetDateTime** | ISO 8601 formatted timestamp in UTC with hourly resolution of when this IP was last seen as a proxy when available.  |  [optional] |


## Enum: ProxyTypeEnum

| Name | Value |
|---- | ----- |
| RESIDENTIAL | &quot;residential&quot; |
| DATA_CENTER | &quot;data_center&quot; |
| UNKNOWN | &quot;unknown&quot; |



