package org.ansel.springmongo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@JsonInclude(Include.NON_NULL)
public class McqDetail {

    @MongoId
    private String id;

    private List<Option> option;
}
