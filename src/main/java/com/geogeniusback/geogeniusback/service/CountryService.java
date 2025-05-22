package com.geogeniusback.geogeniusback.service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogeniusback.geogeniusback.model.Country;
import com.geogeniusback.geogeniusback.repository.CountryRepository;


@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    
    public List<String> getRandomCountries(List<String> countryIds) {
       
        List<Long> countryLongIds = countryIds.stream()
    .map(Long::parseLong)
    .collect(Collectors.toList());

List<Country> countries = countryRepository.findAllById(countryLongIds);

        
        
        Collections.shuffle(countries);
        
        return countries.stream()
                         .limit(4)
                         .map(Country::getName)
                         .collect(Collectors.toList());
    }

    public List<String> getQuizOptions(List<String> randomCountries) {
        
        List<String> options = new ArrayList<>(randomCountries);
        
        return options;
    }
}
