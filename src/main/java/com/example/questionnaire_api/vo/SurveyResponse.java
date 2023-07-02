package com.example.questionnaire_api.vo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.questionnaire_api.entity.Survey;

public class SurveyResponse {

	private Survey survey;

	private List<Service> surveyList;

	private String message;

	// =================================================

	public SurveyResponse() {
		super();
	}

	public SurveyResponse(String message) {
		super();
		this.message = message;
	}

	public SurveyResponse(Survey survey, String message) {
		super();
		this.survey = survey;
		this.message = message;
	}

	public SurveyResponse(List<Service> surveyList, String message) {
		super();
		this.surveyList = surveyList;
		this.message = message;
	}

	// =================================================

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public List<Service> getSurveyList() {
		return surveyList;
	}

	public void setSurveyList(List<Service> surveyList) {
		this.surveyList = surveyList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
