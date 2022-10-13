package com.ampada.taskmanagementwithmongo.dto;

import com.ampada.taskmanagementwithmongo.model.Auditable;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class UserDto  {

    @Id
    private String id;
    private String userName;
    private String firstName;
    private String lastName;

}
