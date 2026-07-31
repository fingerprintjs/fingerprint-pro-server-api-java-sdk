

# WebhookVPN


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**result** | **Boolean** | VPN or other anonymizing service has been used when sending the request. |  [optional] |
|**confidence** | [**VPNConfidence**](VPNConfidence.md) |  |  [optional] |
|**mlScore** | **Double** | Machine learning–based VPN score, represented as a floating-point value between 0 and 1 (inclusive), with up to three decimal places of precision. A higher score means a higher confidence in the positive `vpn` detection result. This Smart Signal is currently in beta and only available to select customers. If you are interested, please [contact our support team](https://fingerprint.com/support/).  |  [optional] |
|**originTimezone** | **String** | Local timezone which is used in timezoneMismatch method. |  [optional] |
|**originCountry** | **String** | Country of the request (only for Android SDK version >= 2.4.0, ISO 3166 format or unknown). |  [optional] |
|**methods** | [**VPNMethods**](VPNMethods.md) |  |  [optional] |



