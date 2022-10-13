package com.ampada.taskmanagementwithmongo.service;


import com.ampada.taskmanagementwithmongo.dto.CardDto;
import com.ampada.taskmanagementwithmongo.model.Board;
import com.ampada.taskmanagementwithmongo.model.Card;
import com.ampada.taskmanagementwithmongo.repository.BoardRepository;
import com.ampada.taskmanagementwithmongo.repository.CardRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private final Logger LOGGER = LoggerFactory.getLogger(CardServiceImpl.class);

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String addCard(String boardId, CardDto cardDto) {

        Card card=new Card();
       // modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        card=modelMapper.map(cardDto,Card.class);

        LOGGER.info("Card added : "+card.toString());
        return cardRepository.save(card).getId();
    }

    @Override
    public Card updateCard(String boardId, CardDto cardDto) {
        Card savedCard =cardRepository.findById(cardDto.getId())
                .orElseThrow(()->new RuntimeException(
                        String.format("Can not find Card by id %s",cardDto.getId())
                ));
        savedCard.setCardTitle(cardDto.getCardTitle());
        savedCard.setBoardId(cardDto.getBoardId());
        LOGGER.info("Card updated to  : "+savedCard.toString());
        return cardRepository.save(savedCard);
    }

    @Override
    public List<Card> getCardsByBoardId(String boardId) {
        return cardRepository.findAllByBoardId(boardId);
    }

    @Override
    public Card getCardById(String boardId, String id) {
        return cardRepository.findById(id).get();
    }

    @Override
    public void deleteCard(String boardId, String id) {
        LOGGER.info("CardId {} deleted : ",id);
        cardRepository.deleteById(id);
    }
}
