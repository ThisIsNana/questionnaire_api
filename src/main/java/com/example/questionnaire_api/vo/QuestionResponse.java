package com.example.questionnaire_api.vo;

import java.util.List;

import com.example.questionnaire_api.entity.Question;

public class QuestionResponse {

	private Question question;

	private List<Question> questionList;

	private String message;

	// =================================================

	public QuestionResponse() {
		super();
	}

	public QuestionResponse(String message) {
		super();
		this.message = message;
	}

	public QuestionResponse(Question question, String message) {
		super();
		this.question = question;
		this.message = message;
	}

	public QuestionResponse(List<Question> questionList, String message) {
		super();
		this.questionList = questionList;
		this.message = message;
	}

	// =================================================

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
