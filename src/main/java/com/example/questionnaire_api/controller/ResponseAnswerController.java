package com.example.questionnaire_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionnaire_api.entity.ResponseAnswer;
import com.example.questionnaire_api.service.ifs.ResponseAnswerService;
import com.example.questionnaire_api.service.ifs.SurveyService;
import com.example.questionnaire_api.vo.AddAnswerRequest;
import com.example.questionnaire_api.vo.AddAnswerResponse;

@CrossOrigin
@RestController
public class ResponseAnswerController {

//	@Autowired
//	private SurveyService surveyService;

	@Autowired
	private ResponseAnswerService answerService;

	//·s¼W¦^µª
	@PostMapping(value = "add_answer")
	public AddAnswerResponse addAnswer(@RequestBody AddAnswerRequest request) {
		return answerService.addAnswer(request.getAnswer());
	}
	
	
}
