

# MerchantSearch

Merchant Search Request Info

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**addressLine1** | **String** | Line 1 of the street address for the merchant location. Usually includes the street number and name. This parameter is ignored if latitude and longitude are provided. If you provide this parameter you must also provide the Country parameter and either City parameter or PostalCode parameter. |  [optional]
**addressLine2** | **String** | Line 2 of the street address usually an apartment number or suite number. This parameter is used rarely and is ignored if latitude and longitude are provided. If you provide this parameter you must also provide the Country parameter and either City parameter or PostalCode parameter. |  [optional]
**city** | **String** | The name of the city for a merchant location. This parameter is ignored if latitude and longitude are provided. If you provide this parameter you must also provide the Country parameter. |  [optional]
**countryCode** | **String** | Any two digit country code for an Merchant location. Valid values are two digit alpha country code. This parameter is ignored if latitude and longitude are provided. This parameter is required if any other address information is provided including AddressLine1 AddressLine2 City PostalCode or CountrySubdivision. |  [optional]
**countrySubdivisionCode** | **String** | The state or province for a merchant location (only supported for US and Canada locations). This parameter is ignored if latitude and longitude are provided. If you provide this parameter you must also provide the Country parameter. |  [optional]
**latitude** | **String** | The latitude of a merchant location. If latitude is provided longitude must also be provided. |  [optional]
**longitude** | **String** | The longitude of a merchant location. If longitude is provided latitude must also be provided. |  [optional]
**merchantCategory** | **String** | Category Id of the merchant location. See the Categories resource for a list of valid categories.  Input may be a comma delimited list of category ids. |  [optional]
**merchantType** | **String** | Type of merchant location. Options are &#39;paypass&#39; &#39;repower&#39; &#39;easysavings&#39; and &#39;cashback&#39;. |  [optional]
**offerMerchantId** | **String** | Unique identifier that represents the merchant sponsor of an offer. Any valid merchant ID. |  [optional]
**postalCode** | **String** | The zip code or postal code for an Merchant location. This parameter is ignored if latitude and longitude are provided. If you provide this parameter you must also provide the Country parameter. |  [optional]



