package com.ampada.taskmanagementwithmongo.service;

import com.ampada.taskmanagementwithmongo.model.Board;

import java.util.List;

public interface CardService {

    String addBoard(Board board);

    Board updateBoard(Board board);

    List<Board> getAllBoards();

    Board getBoardById(String id);

    void deleteBoard(String id);
}
