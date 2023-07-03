package com.example.questionnaire_api.vo;

import java.util.List;

import com.example.questionnaire_api.entity.Question;
import com.example.questionnaire_api.entity.Survey;

public class ShowResponse {

	private List<Survey> surveyList;

	private List<Question> QuestionList;

	private String message;
	
	// ====================================

	public ShowResponse() {
		super();
	}

	public ShowResponse(String message) {
		super();
		this.message = message;
	}

	public ShowResponse(List<Survey> surveyList, String message) {
		super();
		this.surveyList = surveyList;
		this.message = message;
	}

	public ShowResponse(String message, List<Question> questionList) {
		super();
		QuestionList = questionList;
		this.message = message;
	}

	public ShowResponse(List<Survey> surveyList, List<Question> questionList, String message) {
		super();
		this.surveyList = surveyList;
		QuestionList = questionList;
		this.message = message;
	}

	// ====================================

	public List<Survey> getSurveyList() {
		return surveyList;
	}

	public void setSurveyList(List<Survey> surveyList) {
		this.surveyList = surveyList;
	}

	public List<Question> getQuestionList() {
		return QuestionList;
	}

	public void setQuestionList(List<Question> questionList) {
		QuestionList = questionList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
