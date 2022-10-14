package com.ampada.taskmanagementwithmongo.service;

import com.ampada.taskmanagementwithmongo.model.Board;
import com.ampada.taskmanagementwithmongo.model.Card;
import com.ampada.taskmanagementwithmongo.repository.BoardRepository;
import com.ampada.taskmanagementwithmongo.repository.CardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CardServiceImplTest {

    @Autowired
    private CardService cardService;

    @MockBean
    private CardRepository cardRepository;


    @BeforeEach
    void setUp() {
        Card card= Card.builder()
                .cardTitle("Card1")
                .boardId("100")
                .id("1")
                .build();
        List<Card> cards=new ArrayList<>();
        cards.add(card);
        Mockito.when(cardRepository.findAllByCardTitle("Card1")).thenReturn(cards);

    }

    @Test
    @DisplayName("Get card based on cardTitle ")
    public void whenValidCardTitle_thenReturnCard(){
        String cardTitle = "Card1";
        List<Card> foundedCards = cardService.getCardsByCardTitle(cardTitle);
        assertEquals(cardTitle, foundedCards.get(0).getCardTitle());
    }
}