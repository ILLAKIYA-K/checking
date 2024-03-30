/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here

package com.example.geohub.service;

import com.example.geohub.model.Country;
import com.example.geohub.repository.CountryJpaRepository;
import com.example.geohub.repository.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@Service
public class CountryJpaService implements CountryRepository {

    @Autowired
    private CountryJpaRepository serv;

    @Override
    public Country updateCountry(int countryId, Country son) {
        try {
            Country f = serv.findById(countryId).get();
            if (son.getCountryName() != null) {
                f.setCountryName(son.getCountryName());
            }
            if (son.getPopulation() != 0) {
                f.setPopulation(son.getPopulation());
            }
            if (son.getCurrency() != null) {
                f.setCurrency(son.getCurrency());
            }
            if (son.getLatitude() != null) {
                f.setLatitude(son.getLatitude());
            }
            if (son.getLongitude() != null) {
                f.setLongitude(son.getLongitude());
            }

            serv.save(f);
            return f;
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ArrayList<Country> getCountries() {
        List<Country> CountryColl = serv.findAll();
        ArrayList<Country> arr = new ArrayList<>(CountryColl);

        return arr;
    }

    @Override
    public Country addCountry(Country so) {
        serv.save(so);
        return so;
    }

    @Override
    public Country getCountrybyId(int countryId) {
        try {
            Country ks = serv.findById(countryId).get();
            return ks;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void delCountry(int countryId) {
        try {

            serv.deleteById(countryId);
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
}