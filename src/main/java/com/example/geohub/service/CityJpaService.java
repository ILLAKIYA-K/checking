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

import com.example.geohub.model.*;
import com.example.geohub.repository.*;
import com.example.geohub.repository.CityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@Service
public class CityJpaService implements CityRepository {

    @Autowired
    private CityJpaRepository serv;

    @Autowired
    private CountryJpaRepository con;

    @Override
    public Country getCountrypu(int cityId) {
        try {
            City ci = serv.findById(cityId).get();
            return ci.getCountry();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public City updateCity(int cityId, City son) {
        try {
            City f = serv.findById(cityId).get();
            if (son.getCityName() != null) {
                f.setCityName(son.getCityName());
            }
            if (son.getPopulation() != 0L) {
                f.setPopulation(son.getPopulation());
            }
            if (son.getLatitude() != null) {
                f.setLatitude(son.getLatitude());
            }
            if (son.getLongitude() != null) {
                f.setLongitude(son.getLongitude());
            }
            if (son.getCountry() != null) {
                Country y = son.getCountry();
                int ghk = y.getCountryId();
                Country nb = con.findById(ghk).get();
                f.setCountry(nb);
            }

            serv.save(f);
            return f;
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ArrayList<City> getCity() {
        List<City> CityColl = serv.findAll();
        ArrayList<City> arr = new ArrayList<>(CityColl);

        return arr;
    }

    @Override
    public City addCity(City so) {
        Country c = so.getCountry();
        int cId = c.getCountryId();
        try {
            Country g = con.findById(cId).get();
            so.setCountry(g);
            serv.save(so);
            return so;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public City getCitybyId(int cityId) {
        try {
            City ks = serv.findById(cityId).get();
            return ks;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void delCity(int cityId) {
        try {

            serv.deleteById(cityId);
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
}