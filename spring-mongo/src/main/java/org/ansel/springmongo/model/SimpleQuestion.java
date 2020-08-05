package org.ansel.springmongo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimpleQuestion {

    private String question;
    private String answer;
}
