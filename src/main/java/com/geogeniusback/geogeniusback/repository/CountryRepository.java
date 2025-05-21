package com.geogeniusback.geogeniusback.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geogeniusback.geogeniusback.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
    // Custom query method to find a country by its name
    Optional<Country> findByName(String name);
}
