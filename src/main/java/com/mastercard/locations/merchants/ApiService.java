package com.mastercard.locations.merchants;

import com.mastercard.developer.interceptors.OkHttpOAuth1Interceptor;
import com.mastercard.developer.utils.AuthenticationUtils;
import okhttp3.logging.HttpLoggingInterceptor;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.api.CategoriesApi;
import org.openapitools.client.api.CountriesApi;
import org.openapitools.client.api.MerchantsApi;
import org.openapitools.client.model.Categories;
import org.openapitools.client.model.Countries;
import org.openapitools.client.model.CountrySubdivisions;
import org.openapitools.client.model.MerchantSearch;
import org.openapitools.client.model.Merchants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

public class ApiService {
    private static final String API_BASE_PATH = "https://sandbox.api.mastercard.com/locations/merchants";

    //Below properties will be required for authentication of API calls.
    private static final String CONSUMER_KEY = "Your consumer key"; // This refers to your consumer key. Copy it from "Keys" section on your project page in [Mastercard Developers](https://developer.mastercard.com/dashboard)
    private static final String SIGNING_KEY_ALIAS = "your key alias"; // This is the default value of key alias. If it is modified, use the updated one from keys section in [Mastercard Developers](https://developer.mastercard.com/dashboard).
    private static final String SIGNING_KEY_FILE_PATH = "path to your.p12 private key file"; // This refers to .p12 file found in the signing key. Please place .p12 file at src\main\resources in the project folder and add classpath for .p12 file.
    private static final String SIGNING_KEY_PASSWORD = "your password"; // This is the default value of key alias. If it is modified, use the updated one from keys section in [Mastercard Developers](https://developer.mastercard.com/dashboard).

    private final MerchantsApi merchantsApi;
    private final CategoriesApi categoriesApi;
    private final CountriesApi countriesApi;

    private static final Logger logger = LoggerFactory.getLogger(ApiService.class);

    public ApiService() throws CertificateException, UnrecoverableKeyException, NoSuchAlgorithmException, IOException, KeyStoreException, NoSuchProviderException {

        ApiClient client = new ApiClient();
        client.setBasePath(API_BASE_PATH);
        client.setDebugging(true);

        PrivateKey signingKey = AuthenticationUtils.loadSigningKey(SIGNING_KEY_FILE_PATH, SIGNING_KEY_ALIAS, SIGNING_KEY_PASSWORD);

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(logger::info);
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BASIC);
        client.setHttpClient(
                client.getHttpClient()
                        .newBuilder()
                        .addInterceptor(new OkHttpOAuth1Interceptor(CONSUMER_KEY, signingKey))
                        .addInterceptor(loggingInterceptor)
                        .build()
        );

        // Merchants API
        merchantsApi = new MerchantsApi(client);

        // Categories API
        categoriesApi = new CategoriesApi(client);

        // Countries Code API
        countriesApi = new CountriesApi(client);

    }

    public Merchants getMerchants(MerchantSearch merchantSearch, Integer limit, Integer offset, Integer distance, String distanceUnit) throws ApiException {
        return merchantsApi.getMerchants(merchantSearch, limit, offset, distance, distanceUnit);
    }

    public Categories getCategories() throws ApiException {
        return categoriesApi.getMerchantCategories();
    }

    public Countries getCountries() throws ApiException {
        return countriesApi.getCountries();
    }

    public CountrySubdivisions getCountrySubdivisions(String countryCode) throws ApiException {
        return countriesApi.getCountrySubdivisions(countryCode);
    }
}
