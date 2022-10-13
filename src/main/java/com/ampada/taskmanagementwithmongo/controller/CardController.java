package com.ampada.taskmanagementwithmongo.controller;


import com.ampada.taskmanagementwithmongo.dto.CardDto;
import com.ampada.taskmanagementwithmongo.model.Card;
import com.ampada.taskmanagementwithmongo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/board/{boardId}/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<String> addCard(@PathVariable String boardId, @RequestBody CardDto cardDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cardService.addCard(boardId,cardDto));
    }

    @PutMapping
    public ResponseEntity<Card> updateCard(@PathVariable String boardId, @RequestBody CardDto cardDto) {
        return ResponseEntity.ok(cardService.updateCard(boardId,cardDto));
    }

    @GetMapping("boardId/{boardId}")
    public ResponseEntity<List<Card>> getCardsByBoardId(@PathVariable String boardId) {
        return ResponseEntity.ok(cardService.getCardsByBoardId(boardId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable String boardId, @PathVariable String id) {
        return ResponseEntity.ok(cardService.getCardById(boardId,id));
    }

    @DeleteMapping("/{id},{}")
    public ResponseEntity deleteCard(@PathVariable String boardId, @PathVariable String id) {
        cardService.deleteCard(boardId,id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("assing-user/{userId},{cardId}")
    public ResponseEntity<Card> assignCardToUser(@PathVariable String boardId,
                                                 @PathVariable String userId,
                                                 @PathVariable String cardId) {
        return ResponseEntity.ok(cardService.assignUserToCard(userId, cardId));
    }
    @PutMapping("unassing-user/{userId},{cardId}")
    public ResponseEntity<Card> unassignCardToUser(@PathVariable String boardId,
                                                 @PathVariable String userId,
                                                 @PathVariable String cardId) {
        return ResponseEntity.ok(cardService.assignUserToCard(userId, cardId));
    }

    @GetMapping("card-title/{cardTitle}")
    public ResponseEntity<List<Card>> getCardsByCardTitle(@PathVariable String cardTitle) {
        return ResponseEntity.ok(cardService.getCardsByCardTitle(cardTitle));
    }

    @PostMapping("get-cards-by-userids")
    public ResponseEntity<List<Card>> getCardsByUserIds(@RequestBody List<String> userIds) {
        return ResponseEntity.ok(cardService.getCardsByUserIds(userIds));
    }

    @PostMapping("get-cards-by-modifyon")
    public ResponseEntity<List<Card>> getCardsByModifyOn(@RequestBody Date modifyOn) {
        return ResponseEntity.ok(cardService.getCardsByModifyOn(modifyOn));
    }



}