package com.geogeniusback.geogeniusback.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geogeniusback.geogeniusback.dto.QuizQuestionDTO;
import com.geogeniusback.geogeniusback.model.Country;
import com.geogeniusback.geogeniusback.repository.CountryRepository;

@RestController
public class GeoApiController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/api/geoApi/question")
    public QuizQuestionDTO getQuizQuestionDTO() {
        List<Country> allCountries = countryRepository.findAll();

        if (allCountries.size() < 4) {
            throw new IllegalStateException("Not enough countries in the database.");
        }

        Collections.shuffle(allCountries);
        List<Country> selectedCountries = allCountries.subList(0, 4);
        Country selectedCountry = selectedCountries.get(0);

        String correctAnswer = selectedCountry.getCapital();
        String question = "What is the capital of " + selectedCountry.getName() + "?";

        List<String> options = new ArrayList<>(List.of(
        correctAnswer, // Correct answer
        selectedCountries.get(1).getCapital(),
        selectedCountries.get(2).getCapital(),
        selectedCountries.get(3).getCapital()
));

        Collections.shuffle(options);

       
        QuizQuestionDTO dto = new QuizQuestionDTO();
        dto.setQuestion(question);
        dto.setOptions(options);
        dto.setCorrectAnswer(correctAnswer);

        return dto;
    }
}
