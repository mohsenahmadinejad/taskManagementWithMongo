package com.ampada.taskmanagementwithmongo.service;

import com.ampada.taskmanagementwithmongo.dto.CardDto;
import com.ampada.taskmanagementwithmongo.model.Card;

import java.util.List;

public interface CardService {

    String addCard(String boardId, CardDto cardDto);

    Card updateCard(String boardId,CardDto cardDto);

    List<Card> getCardsByBoardId(String boardId);

    Card getCardById(String boardId,String id);

    void deleteCard(String boardId,String id);
}
