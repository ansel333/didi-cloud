package org.ansel.springmongo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@JsonInclude(Include.NON_NULL)
public class Option {

    @MongoId
    private String id;

    private Boolean isAnswer;
    private String status;
    private String text;
}
