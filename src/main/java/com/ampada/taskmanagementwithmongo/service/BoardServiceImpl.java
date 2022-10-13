package com.ampada.taskmanagementwithmongo.service;


import com.ampada.taskmanagementwithmongo.model.Board;
import com.ampada.taskmanagementwithmongo.repository.BoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final Logger LOGGER = LoggerFactory.getLogger(BoardServiceImpl.class);

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public String addBoard(Board board) {
        LOGGER.info("Board added : "+board.toString());
        return boardRepository.save(board).getId();
    }

    @Override
    public Board updateBoard(Board board) {
        Board saveBoard =boardRepository.findById(board.getId())
                .orElseThrow(()->new RuntimeException(
                        String.format("Can not find Board by id %s",board.getId())
                ));
        saveBoard.setBoardName(board.getBoardName());
        LOGGER.info("Board updated to  : "+saveBoard.toString());
        return boardRepository.save(saveBoard);
    }

    @Override
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    @Override
    public Board getBoardById(String id) {
        return boardRepository.findById(id).get();
    }

    @Override
    public void deleteBoard(String id) {
        LOGGER.info("BoardId {} deleted : ",id);
        boardRepository.deleteById(id);
    }
}
