package com.ampada.taskmanagementwithmongo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Card  extends  Auditable{

    @Id
    private String id;
    private String cardTitle;
    private String boardId;
    private List<String> userIdList;

}