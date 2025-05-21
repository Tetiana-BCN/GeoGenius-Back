package com.geogeniusback.geogeniusback.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.geogeniusback.geogeniusback.repository.CardRepository;


@Service
public class CardService {
    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

public ResponseEntity<Object> createCard(Card card){
    cardRepository.save(card);
    return new ResponseEntity<>(card, HttpStatus.CREATED);
}
}
