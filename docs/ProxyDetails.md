

# ProxyDetails

Proxy detection details (present if `proxy` is `true`)

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**proxyType** | [**ProxyTypeEnum**](#ProxyTypeEnum) | Residential proxies use real user IP addresses to appear as legitimate traffic,  while data center proxies are public proxies hosted in data centers  |  |
|**lastSeenAt** | **Long** | Unix millisecond timestamp with hourly resolution of when this IP was last seen as a proxy  |  [optional] |



## Enum: ProxyTypeEnum

| Name | Value |
|---- | -----|
| RESIDENTIAL | &quot;residential&quot; |
| DATA_CENTER | &quot;data_center&quot; |



