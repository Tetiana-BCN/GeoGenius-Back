package com.geogeniusback.geogeniusback.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geogeniusback.geogeniusback.model.Country;


@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByName(String name);
}

