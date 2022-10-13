package com.ampada.taskmanagementwithmongo.model;

import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.Indexed;


import java.util.Date;

@Data
public class Auditable {
    @CreatedBy
    private String creatorId;

    @Indexed
    @CreatedDate
    private Date createdOn = new Date();

    @LastModifiedDate
    private Date modifiedOn;

}
