package com.ampada.taskmanagementwithmongo.repository;


import com.ampada.taskmanagementwithmongo.model.Board;
import com.ampada.taskmanagementwithmongo.model.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends MongoRepository<Card,String> {
    public List<Card> findAllByBoardId(String boardId);

}