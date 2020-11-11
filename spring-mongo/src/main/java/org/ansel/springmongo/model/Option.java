package org.ansel.springmongo.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class Option {

	@MongoId
	private String id;

	private Boolean isAnswer;
	private String status;
	private String text;
}
