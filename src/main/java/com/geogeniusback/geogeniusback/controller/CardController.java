// package com.geogeniusback.geogeniusback.controller;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.geogeniusback.geogeniusback.model.Card;
// import com.geogeniusback.geogeniusback.service.CardService;


// @RestController
// @RequestMapping("/api/v1/cards")
// public class CardController {
//     private final CardService cardService;
//     public CardController(CardService cardService) {
//         this.cardService = cardService;
//     }


// @PostMapping
// public ResponseEntity<Object> createCard(@RequestBody Card card) {
//     return cardService.createCard(card);

// }
// }