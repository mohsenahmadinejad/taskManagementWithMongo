package com.ampada.taskmanagementwithmongo.service;

import com.ampada.taskmanagementwithmongo.model.Board;
import com.ampada.taskmanagementwithmongo.model.Card;
import com.ampada.taskmanagementwithmongo.repository.BoardRepository;
import com.ampada.taskmanagementwithmongo.repository.CardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceImplTest {

    @Autowired
    private BoardService boardService;

    @MockBean
    private BoardRepository boardRepository;

    @BeforeEach
    void setUp() {
        Board board= Board.builder()
                .id("100")
                .boardName("Board1")
                .build();
        Optional<Board> optionalBoard=Optional.of(board);
        Mockito.when(boardRepository.findById("100")).thenReturn(optionalBoard);

    }

    @Test
    public void whenValidBoardId_thenReturnCard(){
        String boardId = "100";
        Board  foundedboard = boardService.getBoardById(boardId);
        assertEquals(boardId, foundedboard.getId());
    }
}