package com.ampada.taskmanagementwithmongo.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data

public class CardDto {

    @Id
    private String id;
    private String cardTitle;
    private String boardId;
    private List<String> userIdList;

}