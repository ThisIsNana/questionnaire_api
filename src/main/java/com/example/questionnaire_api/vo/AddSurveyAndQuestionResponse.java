package com.example.questionnaire_api.vo;

import java.util.List;

import com.example.questionnaire_api.entity.Question;
import com.example.questionnaire_api.entity.Survey;

public class AddSurveyAndQuestionResponse {

	private Survey survey;

	private List<Question> questionList;

	private String message;
	
	public AddSurveyAndQuestionResponse() {
		super();
	}

	public AddSurveyAndQuestionResponse(String message) {
		super();
		this.message = message;
	}
	
	public AddSurveyAndQuestionResponse(Survey survey, List<Question> questionList, String message) {
		super();
		this.survey = survey;
		this.questionList = questionList;
		this.message = message;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
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
