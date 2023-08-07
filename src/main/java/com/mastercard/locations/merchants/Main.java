package com.mastercard.locations.merchants;

import org.openapitools.client.model.Categories;
import org.openapitools.client.model.Countries;
import org.openapitools.client.model.CountrySubdivisions;
import org.openapitools.client.model.MerchantSearch;
import org.openapitools.client.model.Merchants;

public class Main {

    private static ApiService apiService;

    public static void main(String[] args) throws Exception {

        if (apiService == null) {
            apiService = new ApiService();
        }

        // Get Merchants by latitude and longitude
        MerchantSearch merchantSearch = new MerchantSearch();
        merchantSearch.setMerchantType("paypass");
        merchantSearch.setLatitude("38.794676");
        merchantSearch.setLongitude("-90.5689");
        Merchants merchants = apiService.getMerchants(merchantSearch, 25, 0, 5, "MILE");
        System.out.println(merchants.toString());

        // Get Paypass Merchants by address
        MerchantSearch merchantSearchByAddress = new MerchantSearch();
        merchantSearchByAddress.setMerchantType("paypass");
        merchantSearchByAddress.setAddressLine1("4105 N CLOVERLEAF DR");
        merchantSearchByAddress.setCity("SAINT PETERS");
        merchantSearchByAddress.setCountryCode("USA");
        merchantSearchByAddress.setPostalCode("63376");
        Merchants merchantsByAddress = apiService.getMerchants(merchantSearchByAddress, 25, 0, 5, "MILE");
        System.out.println(merchantsByAddress.toString());

        // Get Categories
        Categories categories = apiService.getCategories();
        System.out.println(categories.toString());

        // Get Countries
        Countries countries = apiService.getCountries();
        System.out.println(countries.toString());

        // Get Country Subdivisions
        CountrySubdivisions countrySubdivisions = apiService.getCountrySubdivisions("USA");
        System.out.println(countrySubdivisions.toString());
    }

}
