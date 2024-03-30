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

import com.example.geohub.model.*;

public interface CityRepository {
    ArrayList<City> getCity();

    void delCity(int cityId);

    City getCitybyId(int cityId);

    City addCity(City so);

    City updateCity(int cityId, City son);

    Country getCountrypu(int cityId);
}