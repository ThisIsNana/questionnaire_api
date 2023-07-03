package com.example.questionnaire_api.vo;

import com.example.questionnaire_api.entity.ResponseAnswer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddAnswerRequest {
	

	@JsonProperty("response_answer")
	private ResponseAnswer responseAnswer;

	public ResponseAnswer getAnswer() {
		return responseAnswer;
	}

	public void setAnswer(ResponseAnswer responseAnswer) {
		this.responseAnswer = responseAnswer;
	}

}
