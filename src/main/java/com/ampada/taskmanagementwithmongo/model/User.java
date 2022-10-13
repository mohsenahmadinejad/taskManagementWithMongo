package com.ampada.taskmanagementwithmongo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@ToString
@Document(collection = "user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends Auditable {

    @Id
    private String id;
    private String userName;
    private String firstName;
    private String lastName;

}
