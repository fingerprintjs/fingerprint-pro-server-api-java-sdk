

# VpnMethods


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**timezoneMismatch** | **Boolean** | The browser timezone doesn&#39;t match the timezone inferred from the request IP address. |  [optional] |
|**publicVpn** | **Boolean** | Request IP address is owned and used by a public VPN service provider. |  [optional] |
|**auxiliaryMobile** | **Boolean** | This method applies to mobile devices only. Indicates the result of additional methods used to detect a VPN in mobile devices. |  [optional] |
|**osMismatch** | **Boolean** | The browser runs on a different operating system than the operating system inferred from the request network signature. |  [optional] |
|**relay** | **Boolean** | Request IP address belongs to a relay service provider, indicating the use of relay services like [Apple Private relay](https://support.apple.com/en-us/102602) or [Cloudflare Warp](https://developers.cloudflare.com/warp-client/).  * Like VPNs, relay services anonymize the visitor&#39;s true IP address. * Unlike traditional VPNs, relay services don&#39;t let visitors spoof their location by choosing an exit node in a different country.  This field allows you to differentiate VPN users and relay service users in your fraud prevention logic.  |  [optional] |



