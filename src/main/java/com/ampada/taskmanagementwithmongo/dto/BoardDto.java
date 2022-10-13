package com.ampada.taskmanagementwithmongo.dto;

import com.ampada.taskmanagementwithmongo.model.Auditable;
import com.ampada.taskmanagementwithmongo.model.Card;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
 public class BoardDto  {

    private String id;
    private String boardName;

}
