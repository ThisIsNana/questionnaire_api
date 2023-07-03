package com.example.questionnaire_api.vo;

import com.example.questionnaire_api.entity.ResponseAnswer;

public class AddAnswerResponse {

	private ResponseAnswer responseAnswer;

	private String message;

	//====================================================
	
	public AddAnswerResponse() {
		super();
	}

	public AddAnswerResponse(String message) {
		super();
		this.message = message;
	}

	public AddAnswerResponse(ResponseAnswer responseAnswer, String message) {
		super();
		this.responseAnswer = responseAnswer;
		this.message = message;
	}

	//====================================================
	
	public ResponseAnswer getResponseAnswer() {
		return responseAnswer;
	}

	public void setResponseAnswer(ResponseAnswer responseAnswer) {
		this.responseAnswer = responseAnswer;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
