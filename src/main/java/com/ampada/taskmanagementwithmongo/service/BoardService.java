package com.ampada.taskmanagementwithmongo.service;


import com.ampada.taskmanagementwithmongo.dto.BoardDto;
import com.ampada.taskmanagementwithmongo.model.Board;

import java.util.List;

public interface BoardService {

    String addBoard(BoardDto boardDto);

    Board updateBoard(BoardDto boardDto);

    List<Board> getAllBoards();

    Board getBoardById(String id);

    void deleteBoard(String id);
}
