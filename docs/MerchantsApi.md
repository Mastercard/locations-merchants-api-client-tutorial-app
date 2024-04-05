# MerchantsApi

All URIs are relative to *https://api.mastercard.com/locations/merchants*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMerchants**](MerchantsApi.md#getMerchants) | **POST** /searches | Get a list of merchant details


<a name="getMerchants"></a>
# **getMerchants**
> Merchants getMerchants(merchantSearch, limit, offset, distance, distanceUnit)

Get a list of merchant details

Returns detailed information on merchants based on the provided query parameters

### Example
```java
// Import classes:
import com.mastercard.api.merchants.ApiClient;
import com.mastercard.api.merchants.ApiException;
import com.mastercard.api.merchants.Configuration;
import com.mastercard.api.merchants.models.*;
import com.mastercard.api.merchants.client.MerchantsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mastercard.com/locations/merchants");

    MerchantsApi apiInstance = new MerchantsApi(defaultClient);
    MerchantSearch merchantSearch = new MerchantSearch(); // MerchantSearch | A JSON object containing item data
    Integer limit = 25; // Integer | The number of items to be retrieved
    Integer offset = 1; // Integer | The page offset used for the query
    Integer distance = 5; // Integer | Distance measurement for calculating the radius search. Optional The length of distance from the centroid point. Value string(<25). The default will be 5 units
    String distanceUnit = "MILE"; // String | Unit of measurement for calculating the radius search. Optional. Measurement of distance unit in miles or kilometers. Value string (MILE or KM)
    try {
      Merchants result = apiInstance.getMerchants(merchantSearch, limit, offset, distance, distanceUnit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MerchantsApi#getMerchants");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **merchantSearch** | [**MerchantSearch**](MerchantSearch.md)| A JSON object containing item data |
 **limit** | **Integer**| The number of items to be retrieved | [optional]
 **offset** | **Integer**| The page offset used for the query | [optional]
 **distance** | **Integer**| Distance measurement for calculating the radius search. Optional The length of distance from the centroid point. Value string(&lt;25). The default will be 5 units | [optional]
 **distanceUnit** | **String**| Unit of measurement for calculating the radius search. Optional. Measurement of distance unit in miles or kilometers. Value string (MILE or KM) | [optional] [enum: MILE, KM]

### Return type

[**Merchants**](Merchants.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | List of Merchant details |  -  |
**400** | Something was wrong with the request. |  -  |
**401** | Authentication information was missing or invalid. |  -  |
**403** | Insufficient permissions for interacting with the resource. |  -  |

