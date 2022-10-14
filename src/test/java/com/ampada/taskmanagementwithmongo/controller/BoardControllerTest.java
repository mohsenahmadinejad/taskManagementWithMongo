package com.ampada.taskmanagementwithmongo.controller;

import com.ampada.taskmanagementwithmongo.controller.BoardController;
import com.ampada.taskmanagementwithmongo.dto.BoardDto;
import com.ampada.taskmanagementwithmongo.model.Board;
import com.ampada.taskmanagementwithmongo.service.BoardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BoardController.class)
class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private Board board;
    @MockBean
    private BoardService boardService;

    @BeforeEach
    void setUp() {
        board=Board.builder()
                .id("100")
                .boardName("Board1")
                .build();


    }

    @Test
    void addBoard() throws Exception {
        Board inputBoard=Board.builder()
                .boardName("Board1")
                .build();
        BoardDto boardDto=new BoardDto();
        boardDto.setBoardName("Board1");

        Mockito.when(boardService.addBoard(boardDto)).thenReturn(board.getId());
        mockMvc.perform(post("/api/board")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"boardId\": \"Board1\"\n" +
                        "}"))
                .andExpect(status().isOk());


    }

    @Test
    void getBoardById() throws Exception {
        Mockito.when(boardService.getBoardById("100")).thenReturn(board);
        mockMvc.perform((get("/api/board"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.boardName").value(board.getBoardName()));
    }
}