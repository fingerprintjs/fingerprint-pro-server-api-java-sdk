

# WebhookVPN


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**result** | **Boolean** | VPN or other anonymizing service has been used when sending the request. |  [optional] |
|**confidence** | [**VPNConfidence**](VPNConfidence.md) |  |  [optional] |
|**originTimezone** | **String** | Local timezone which is used in timezoneMismatch method. |  [optional] |
|**originCountry** | **String** | Country of the request (only for Android SDK version >= 2.4.0, ISO 3166 format or unknown). |  [optional] |
|**methods** | [**VPNMethods**](VPNMethods.md) |  |  [optional] |



