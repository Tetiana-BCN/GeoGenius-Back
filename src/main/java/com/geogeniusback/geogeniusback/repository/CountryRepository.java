package com.geogeniusback.geogeniusback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geogeniusback.geogeniusback.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
   @Override
   public List<Country> findAll();
}

