package com.example.questionnaire_api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	private int questionId;

	@Column(name = "question_survey_id")
	private int questionSurveyId;

	@Column(name = "question")
	private String question;

	@Column(name = "question_type")
	private int questionType;

	@Column(name = "required")
	private boolean required;

	@Column(name = "option")
	private String option;

	//============================================================

	public Question() {
		super();
	}
	
	public Question(int questionId, int questionSurveyId, String question, int questionType, boolean required,
			String option) {
		super();
		this.questionId = questionId;
		this.questionSurveyId = questionSurveyId;
		this.question = question;
		this.questionType = questionType;
		this.required = required;
		this.option = option;
	}

	//============================================================
	
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getQuestionSurveyId() {
		return questionSurveyId;
	}

	public void setQuestionSurveyId(int questionSurveyId) {
		this.questionSurveyId = questionSurveyId;
	}

	public int getQuestionType() {
		return questionType;
	}

	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}
	
	
}
