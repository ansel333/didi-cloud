package org.ansel.springmongo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Builder
@Data
@JsonInclude(Include.NON_NULL)
public class QuizQuestion {

    @MongoId
    private String id;

    private String status;
    private String questionAlias;
    private String question;
    private String questionDescription;
    private String type;
    private LocalDateTime createAt;
    private LocalDateTime lastUpdateAt;
    private McqDetail mcqDetail;
}
