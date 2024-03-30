/*
 *
 * You can use the following import statements
 * 
 * java.util.ArrayList;
 * 
 */

// Write your code here

package com.example.geohub.repository;

import java.util.*;

import com.example.geohub.model.Country;

public interface CountryRepository {
    ArrayList<Country> getCountries();

    void delCountry(int countryId);

    Country getCountrybyId(int countryId);

    Country addCountry(Country so);

    Country updateCountry(int countryId, Country son);
}