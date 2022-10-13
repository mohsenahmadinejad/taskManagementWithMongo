package com.ampada.taskmanagementwithmongo.service;


import com.ampada.taskmanagementwithmongo.dto.BoardDto;
import com.ampada.taskmanagementwithmongo.model.Board;
import com.ampada.taskmanagementwithmongo.repository.BoardRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final Logger LOGGER = LoggerFactory.getLogger(BoardServiceImpl.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public String addBoard(BoardDto boardDto) {
        Board board=new Board();
        board=modelMapper.map(boardDto,Board.class);
        LOGGER.info("Board added : "+board.toString());
        return boardRepository.save(board).getId();
    }

    @Override
    public Board updateBoard(BoardDto boardDto) {
        Board savedBoard =boardRepository.findById(boardDto.getId())
                .orElseThrow(()->new RuntimeException(
                        String.format("Can not find Board by id %s",boardDto.getId())
                ));
        savedBoard.setBoardName(boardDto.getBoardName());
        LOGGER.info("Board updated to  : "+savedBoard.toString());
        return boardRepository.save(savedBoard);
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
