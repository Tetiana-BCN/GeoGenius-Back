package com.geogeniusback.geogeniusback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geogeniusback.geogeniusback.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    // JpaRepository already provides methods like save(), findAll(), findById(), etc.
}
