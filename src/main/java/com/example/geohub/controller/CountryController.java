/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here

package com.example.geohub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.geohub.model.Country;
import com.example.geohub.service.CountryJpaService;

@RestController

public class CountryController {
    @Autowired
    public CountryJpaService ser;

    @DeleteMapping("/countries/{countryId}")
    public void delCountry(@PathVariable("countryId") int countryId) {
        ser.delCountry(countryId);
    }

    @GetMapping("/countries/{countryId}")
    public Country getCountrybyId(@PathVariable("countryId") int countryId) {
        return ser.getCountrybyId(countryId);
    }

    @GetMapping("/countries")
    public ArrayList<Country> getCountries() {
        return ser.getCountries();
    }

    @PostMapping("/countries")
    public Country addCountry(@RequestBody Country so) {
        return ser.addCountry(so);
    }

    @PutMapping("/countries/{countryId}")
    public Country updateCountry(@PathVariable int countryId, @RequestBody Country son) {
        return ser.updateCountry(countryId, son);
    }

}