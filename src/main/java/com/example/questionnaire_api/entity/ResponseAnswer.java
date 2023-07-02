package com.example.questionnaire_api.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "response_answer")
public class ResponseAnswer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "survey_id")
	private int answerId;

	@Column(name = "answer_date")
	private LocalDate answerDate;

	@Column(name = "answer_name")
	private String answerName;

	@Column(name = "answer_phone")
	private String answerPhone;

	@Column(name = "answer_email")
	private String answerEmail;

	@Column(name = "answer_age")
	private int answerAge;

	@Column(name = "answer_survey_id")
	private int answerSurveyId;

	@Column(name = "answer_option")
	private String answerOption;
	
	//============================================================

	public ResponseAnswer() {
		super();
	}

	public ResponseAnswer(int answerId, LocalDate answerDate, String answerName, String answerPhone, String answerEmail,
			int answerAge, int answerSurveyId, String answerOption) {
		super();
		this.answerId = answerId;
		this.answerDate = answerDate;
		this.answerName = answerName;
		this.answerPhone = answerPhone;
		this.answerEmail = answerEmail;
		this.answerAge = answerAge;
		this.answerSurveyId = answerSurveyId;
		this.answerOption = answerOption;
	}

	
	//============================================================
	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public LocalDate getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(LocalDate answerDate) {
		this.answerDate = answerDate;
	}

	public String getAnswerName() {
		return answerName;
	}

	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}

	public String getAnswerPhone() {
		return answerPhone;
	}

	public void setAnswerPhone(String answerPhone) {
		this.answerPhone = answerPhone;
	}

	public String getAnswerEmail() {
		return answerEmail;
	}

	public void setAnswerEmail(String answerEmail) {
		this.answerEmail = answerEmail;
	}

	public int getAnswerAge() {
		return answerAge;
	}

	public void setAnswerAge(int answerAge) {
		this.answerAge = answerAge;
	}

	public int getAnswerSurveyId() {
		return answerSurveyId;
	}

	public void setAnswerSurveyId(int answerSurveyId) {
		this.answerSurveyId = answerSurveyId;
	}

	public String getAnswerOption() {
		return answerOption;
	}

	public void setAnswerOption(String answerOption) {
		this.answerOption = answerOption;
	}

}
