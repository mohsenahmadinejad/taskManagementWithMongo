package com.ampada.taskmanagementwithmongo.repository;


import com.ampada.taskmanagementwithmongo.model.Board;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends MongoRepository<Board,String> {

}