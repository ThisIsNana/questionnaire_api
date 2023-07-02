package com.example.questionnaire_api.vo;

import java.util.List;

import com.example.questionnaire_api.entity.ResponseAnswer;

public class ResponseAnswerResponse {

	private ResponseAnswer resAns;

	private List<ResponseAnswer> resAnsLst;

	private String message;

	// =================================================

	public ResponseAnswerResponse() {
		super();
	}

	public ResponseAnswerResponse(String message) {
		super();
		this.message = message;
	}

	public ResponseAnswerResponse(ResponseAnswer resAns, String message) {
		super();
		this.resAns = resAns;
		this.message = message;
	}

	public ResponseAnswerResponse(List<ResponseAnswer> resAnsLst, String message) {
		super();
		this.resAnsLst = resAnsLst;
		this.message = message;
	}
	
	// =================================================

	public ResponseAnswer getResAns() {
		return resAns;
	}

	public void setResAns(ResponseAnswer resAns) {
		this.resAns = resAns;
	}

	public List<ResponseAnswer> getResAnsLst() {
		return resAnsLst;
	}

	public void setResAnsLst(List<ResponseAnswer> resAnsLst) {
		this.resAnsLst = resAnsLst;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
