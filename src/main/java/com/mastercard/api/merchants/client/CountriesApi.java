/*
 * Merchants Locations API
 * Merchants Locations API
 *
 * The version of the OpenAPI document: 2.0.0
 * Contact: apisupport@mastercard.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.mastercard.api.merchants.client;

import com.mastercard.api.merchants.ApiCallback;
import com.mastercard.api.merchants.ApiClient;
import com.mastercard.api.merchants.ApiException;
import com.mastercard.api.merchants.ApiResponse;
import com.mastercard.api.merchants.Configuration;
import com.mastercard.api.merchants.Pair;
import com.mastercard.api.merchants.ProgressRequestBody;
import com.mastercard.api.merchants.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.mastercard.api.merchants.model.Countries;
import com.mastercard.api.merchants.model.CountrySubdivisions;
import com.mastercard.api.merchants.model.ErrorResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountriesApi {
    private ApiClient localVarApiClient;

    public CountriesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public CountriesApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for getCountries
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of Countries </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Authentication information was missing or invalid. </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Insufficient permissions for interacting with the resource. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCountriesCall(final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/countries";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getCountriesValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = getCountriesCall(_callback);
        return localVarCall;

    }

    /**
     * Get a list of countries
     * Returns a list of countries
     * @return Countries
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of Countries </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Authentication information was missing or invalid. </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Insufficient permissions for interacting with the resource. </td><td>  -  </td></tr>
     </table>
     */
    public Countries getCountries() throws ApiException {
        ApiResponse<Countries> localVarResp = getCountriesWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * Get a list of countries
     * Returns a list of countries
     * @return ApiResponse&lt;Countries&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of Countries </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Authentication information was missing or invalid. </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Insufficient permissions for interacting with the resource. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Countries> getCountriesWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = getCountriesValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<Countries>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get a list of countries (asynchronously)
     * Returns a list of countries
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of Countries </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Authentication information was missing or invalid. </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Insufficient permissions for interacting with the resource. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCountriesAsync(final ApiCallback<Countries> _callback) throws ApiException {

        okhttp3.Call localVarCall = getCountriesValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<Countries>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getCountrySubdivisions
     * @param countryCode Country Code (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of Country Subdivisions </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Something was wrong with the request. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Authentication information was missing or invalid. </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Insufficient permissions for interacting with the resource. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCountrySubdivisionsCall(String countryCode, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/country-subdivisions";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (countryCode != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("country_code", countryCode));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getCountrySubdivisionsValidateBeforeCall(String countryCode, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'countryCode' is set
        if (countryCode == null) {
            throw new ApiException("Missing the required parameter 'countryCode' when calling getCountrySubdivisions(Async)");
        }
        

        okhttp3.Call localVarCall = getCountrySubdivisionsCall(countryCode, _callback);
        return localVarCall;

    }

    /**
     * Get a list of country subdivisions
     * Returns a list of country subdivisions for a given country
     * @param countryCode Country Code (required)
     * @return CountrySubdivisions
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of Country Subdivisions </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Something was wrong with the request. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Authentication information was missing or invalid. </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Insufficient permissions for interacting with the resource. </td><td>  -  </td></tr>
     </table>
     */
    public CountrySubdivisions getCountrySubdivisions(String countryCode) throws ApiException {
        ApiResponse<CountrySubdivisions> localVarResp = getCountrySubdivisionsWithHttpInfo(countryCode);
        return localVarResp.getData();
    }

    /**
     * Get a list of country subdivisions
     * Returns a list of country subdivisions for a given country
     * @param countryCode Country Code (required)
     * @return ApiResponse&lt;CountrySubdivisions&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of Country Subdivisions </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Something was wrong with the request. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Authentication information was missing or invalid. </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Insufficient permissions for interacting with the resource. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<CountrySubdivisions> getCountrySubdivisionsWithHttpInfo(String countryCode) throws ApiException {
        okhttp3.Call localVarCall = getCountrySubdivisionsValidateBeforeCall(countryCode, null);
        Type localVarReturnType = new TypeToken<CountrySubdivisions>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get a list of country subdivisions (asynchronously)
     * Returns a list of country subdivisions for a given country
     * @param countryCode Country Code (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of Country Subdivisions </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Something was wrong with the request. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Authentication information was missing or invalid. </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Insufficient permissions for interacting with the resource. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCountrySubdivisionsAsync(String countryCode, final ApiCallback<CountrySubdivisions> _callback) throws ApiException {

        okhttp3.Call localVarCall = getCountrySubdivisionsValidateBeforeCall(countryCode, _callback);
        Type localVarReturnType = new TypeToken<CountrySubdivisions>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
