// package com.geogeniusback.geogeniusback.service;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Service;

// import com.geogeniusback.geogeniusback.model.Card;
// import com.geogeniusback.geogeniusback.repository.CardRepository;

// @Service
// public class CardService {
//     private final CardRepository cardRepository;

//     public CardService(CardRepository cardRepository) {
//         this.cardRepository = cardRepository;
//     }

//     public ResponseEntity<Object> createCard(Card card) {
//         // Save the card to the database
//         cardRepository.save(card);

//         // Return the saved card with a 201 CREATED status
//         return new ResponseEntity<>(card, HttpStatus.CREATED);
//     }
// }
