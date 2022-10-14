package com.ampada.taskmanagementwithmongo.repository;

import com.ampada.taskmanagementwithmongo.model.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Board board= Board.builder()
                .id("100")
                .boardName("Board1")
                .build();

        entityManager.persist(board);

    }

    @Test
    @Disabled
    public void whenFindById_thenReturnBoard(){
        Board board=boardRepository.findById("100").get();
        assertEquals(board.getBoardName(),"Board1");
    }

}