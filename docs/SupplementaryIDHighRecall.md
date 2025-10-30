

# SupplementaryIDHighRecall

A supplementary browser identifier that prioritizes coverage over precision. The High Recall ID algorithm matches more generously, i.e., this identifier will remain the same even when there are subtle differences between two requests. This algorithm does not create as many new visitor IDs as the standard algorithms do, but there could be an increase in false-positive identification.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**visitorId** | **String** | String of 20 characters that uniquely identifies the visitor&#39;s browser or mobile device. |  |
|**visitorFound** | **Boolean** | Attribute represents if a visitor had been identified before. |  |
|**confidence** | [**IdentificationConfidence**](IdentificationConfidence.md) |  |  [optional] |
|**firstSeenAt** | **Long** | Unix epoch time milliseconds timestamp indicating the time at which this ID was first seen. example: &#x60;1758069706642&#x60; - Corresponding to Wed Sep 17 2025 00:41:46 GMT+0000  |  [optional] |
|**lastSeenAt** | **Long** | Unix epoch time milliseconds timestamp indicating the time at which this ID was last seen. example: &#x60;1758069706642&#x60; - Corresponding to Wed Sep 17 2025 00:41:46 GMT+0000  |  [optional] |



