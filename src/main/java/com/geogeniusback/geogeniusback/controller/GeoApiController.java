package com.geogeniusback.geogeniusback.controller;

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
    public QuizQuestionDTO getQuizQuestion() {
        // Fetch all countries and their capitals from the database
        List<Country> allCountries = countryRepository.findAll();

        // Ensure that there are enough countries in the database
        if (allCountries.size() < 4) {
            throw new IllegalStateException("Not enough countries in the database.");
        }

        // Shuffle the list of countries to ensure randomness
        Collections.shuffle(allCountries);

        // Select 4 random countries
        List<Country> selectedCountries = allCountries.subList(0, 4);

        // Randomly choose one country for the question
        Country selectedCountry = selectedCountries.get(0);

        // The correct answer is the capital of the selected country
        String correctAnswer = selectedCountry.getCapital();

        // Prepare the quiz question: "What is the capital of [Country]?"
        String question = "What is the capital of " + selectedCountry.getName() + "?";

        // Create the options: shuffle 3 incorrect capitals with the correct one
        List<String> options = List.of(
                correctAnswer, // Correct answer
                selectedCountries.get(1).getCapital(),
                selectedCountries.get(2).getCapital(),
                selectedCountries.get(3).getCapital()
        );

        // Shuffle the options to randomize the order
        Collections.shuffle(options);

        // Return the quiz question along with the options and correct answer
        return new QuizQuestion(question, options, correctAnswer);
    }
}

