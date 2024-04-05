# CategoriesApi

All URIs are relative to *https://api.mastercard.com/locations/merchants*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMerchantCategories**](CategoriesApi.md#getMerchantCategories) | **GET** /categories | Get a list of merchant categories


<a name="getMerchantCategories"></a>
# **getMerchantCategories**
> Categories getMerchantCategories()

Get a list of merchant categories

Returns a list of merchant categories

### Example
```java
// Import classes:
import com.mastercard.api.merchants.ApiClient;
import com.mastercard.api.merchants.ApiException;
import com.mastercard.api.merchants.Configuration;
import com.mastercard.api.merchants.models.*;
import com.mastercard.api.merchants.client.CategoriesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mastercard.com/locations/merchants");

    CategoriesApi apiInstance = new CategoriesApi(defaultClient);
    try {
      Categories result = apiInstance.getMerchantCategories();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CategoriesApi#getMerchantCategories");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Categories**](Categories.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | List of Merchant Categories |  -  |
**401** | Authentication information was missing or invalid. |  -  |
**403** | Insufficient permissions for interacting with the resource. |  -  |

