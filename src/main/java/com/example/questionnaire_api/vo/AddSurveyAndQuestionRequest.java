package com.example.questionnaire_api.vo;

import java.util.List;

import com.example.questionnaire_api.entity.Question;
import com.example.questionnaire_api.entity.Survey;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddSurveyAndQuestionRequest {

	@JsonProperty("survey")
	private Survey survey;

	@JsonProperty("question_list")
	private List<Question> questionList;


	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	
	

}
