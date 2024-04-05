package com.mastercard.api.merchants;

import com.mastercard.api.merchants.client.CategoriesApi;
import com.mastercard.api.merchants.client.CountriesApi;
import com.mastercard.api.merchants.client.MerchantsApi;
import com.mastercard.api.merchants.model.Categories;
import com.mastercard.api.merchants.model.Countries;
import com.mastercard.api.merchants.model.CountrySubdivisions;
import com.mastercard.api.merchants.model.MerchantSearch;
import com.mastercard.api.merchants.model.Merchants;
import com.mastercard.developer.interceptors.OkHttpOAuth1Interceptor;
import com.mastercard.developer.utils.AuthenticationUtils;

import java.security.PrivateKey;

public class Main {

  private static final String BASE_URL = "https://sandbox.api.mastercard.com/locations/merchants";
  private static final String CONSUMER_KEY = "yourconsumerkeystring";
  private static final String PKCS_12_KEY_FILE_PATH = "./path/to/your/signing-key.p12";
  private static final String SIGNIN_KEY_ALIAS = "yourkeyalias";
  private static final String SIGNIN_KEY_PASSWORD = "yourpassword";

  public static void main(String[] args) throws Exception  {

    try {

      PrivateKey signingKey = AuthenticationUtils.loadSigningKey(PKCS_12_KEY_FILE_PATH, SIGNIN_KEY_ALIAS, SIGNIN_KEY_PASSWORD);

      ApiClient client = new ApiClient();
      client.setBasePath(BASE_URL);
      client.setConnectTimeout(60);
      client.setDebugging(false);
      client.setHttpClient(client
        .getHttpClient()
        .newBuilder()
        .addInterceptor(new OkHttpOAuth1Interceptor(CONSUMER_KEY, signingKey))
        .build()
      );

      MerchantsApi apiInstance = new MerchantsApi(client);

      System.out.println("-------------------------------------------------------------- " );
      System.out.println("Test #1 : Searching for Merchants at Latitude:38.79516  Longitude:-90.575499 " );
      MerchantSearch merchantSearch = new MerchantSearch();
      merchantSearch.merchantType("paypass");
      merchantSearch.setLatitude("38.795264");
      merchantSearch.setLongitude("-90.568085");
      Merchants response = apiInstance.getMerchants(merchantSearch, 25, 0, 5, "MILE");
      System.out.println("Test #1 : Result structure: ");
      System.out.println(response);

      System.out.println("-------------------------------------------------------------- " );
      System.out.println("Test #2 : Get Countries " );
      CountriesApi apiCountriesInstance = new CountriesApi(client);
      Countries countriesResponse = apiCountriesInstance.getCountries();
      System.out.println("Test #2 : Result structure: ");
      System.out.println(countriesResponse);


      System.out.println("-------------------------------------------------------------- " );
      System.out.println("Test #3 : Get Country Subdivisions " );
      CountrySubdivisions countrySubdivisions = apiCountriesInstance.getCountrySubdivisions("USA");
      System.out.println("Test #3 : Result structure: ");
      System.out.println(countrySubdivisions);

      System.out.println("-------------------------------------------------------------- " );
      System.out.println("Test #4 : Get Categories " );
      CategoriesApi apiCategoriesApi = new CategoriesApi(client);
      Categories categories = apiCategoriesApi.getMerchantCategories();
      System.out.println("Test #4 : Result structure: ");
      System.out.println(categories);

    } catch (ApiException e) {
      System.err.println("Exception when calling Apis");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }

}