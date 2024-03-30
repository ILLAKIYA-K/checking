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
import com.example.geohub.model.*;
import com.example.geohub.service.CityJpaService;

@RestController

public class CityController {
    @Autowired
    public CityJpaService ser;

    @GetMapping("/cities/{cityId}/country")
    public Country getCountrypu(@PathVariable("cityId") int cityId) {
        return ser.getCountrypu(cityId);
    }

    @DeleteMapping("/countries/cities/{cityId}")
    public void delCity(@PathVariable("cityId") int cityId) {
        ser.delCity(cityId);
    }

    @GetMapping("/countries/cities/{cityId}")
    public City getCitybyId(@PathVariable("cityId") int cityId) {
        return ser.getCitybyId(cityId);
    }

    @GetMapping("/countries/cities")
    public ArrayList<City> getCity() {
        return ser.getCity();
    }

    @PostMapping("/countries/cities")
    public City addCity(@RequestBody City so) {
        return ser.addCity(so);
    }

    @PutMapping("/countries/cities/{cityId}")
    public City updateCity(@PathVariable int cityId, @RequestBody City son) {
        return ser.updateCity(cityId, son);
    }

}