# CountriesApi

All URIs are relative to *https://api.mastercard.com/locations/merchants*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCountries**](CountriesApi.md#getCountries) | **GET** /countries | Get a list of countries
[**getCountrySubdivisions**](CountriesApi.md#getCountrySubdivisions) | **GET** /country-subdivisions | Get a list of country subdivisions


<a name="getCountries"></a>
# **getCountries**
> Countries getCountries()

Get a list of countries

Returns a list of countries

### Example
```java
// Import classes:
import com.mastercard.api.merchants.ApiClient;
import com.mastercard.api.merchants.ApiException;
import com.mastercard.api.merchants.Configuration;
import com.mastercard.api.merchants.models.*;
import com.mastercard.api.merchants.client.CountriesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mastercard.com/locations/merchants");

    CountriesApi apiInstance = new CountriesApi(defaultClient);
    try {
      Countries result = apiInstance.getCountries();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CountriesApi#getCountries");
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

[**Countries**](Countries.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | List of Countries |  -  |
**401** | Authentication information was missing or invalid. |  -  |
**403** | Insufficient permissions for interacting with the resource. |  -  |

<a name="getCountrySubdivisions"></a>
# **getCountrySubdivisions**
> CountrySubdivisions getCountrySubdivisions(countryCode)

Get a list of country subdivisions

Returns a list of country subdivisions for a given country

### Example
```java
// Import classes:
import com.mastercard.api.merchants.ApiClient;
import com.mastercard.api.merchants.ApiException;
import com.mastercard.api.merchants.Configuration;
import com.mastercard.api.merchants.models.*;
import com.mastercard.api.merchants.client.CountriesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mastercard.com/locations/merchants");

    CountriesApi apiInstance = new CountriesApi(defaultClient);
    String countryCode = "USA"; // String | Country Code
    try {
      CountrySubdivisions result = apiInstance.getCountrySubdivisions(countryCode);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CountriesApi#getCountrySubdivisions");
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
 **countryCode** | **String**| Country Code |

### Return type

[**CountrySubdivisions**](CountrySubdivisions.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | List of Country Subdivisions |  -  |
**400** | Something was wrong with the request. |  -  |
**401** | Authentication information was missing or invalid. |  -  |
**403** | Insufficient permissions for interacting with the resource. |  -  |

