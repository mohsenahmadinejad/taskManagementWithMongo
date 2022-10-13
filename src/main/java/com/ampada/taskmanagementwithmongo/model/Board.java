package com.ampada.taskmanagementwithmongo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "board")
public class Board  extends Auditable {

    @Id
    private String id;
    private String boardName;

    @Transient
    private List<Card> cardList;
}
