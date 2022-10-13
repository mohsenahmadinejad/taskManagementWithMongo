package com.ampada.taskmanagementwithmongo.controller;


import com.ampada.taskmanagementwithmongo.model.Board;
import com.ampada.taskmanagementwithmongo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping
    public ResponseEntity<String> addBoard(@RequestBody Board board) {
       return ResponseEntity.status(HttpStatus.CREATED).body(boardService.addBoard(board));
    }

    @PutMapping
    public ResponseEntity<Board> updateBoard(@RequestBody Board board) {
       return ResponseEntity.ok(boardService.updateBoard(board));
    }

    @GetMapping
    public ResponseEntity<List<Board>> getAllBoards() {
        return ResponseEntity.ok(boardService.getAllBoards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable String id) {
        return ResponseEntity.ok(boardService.getBoardById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBoard(@PathVariable String id) {
        boardService.deleteBoard(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}