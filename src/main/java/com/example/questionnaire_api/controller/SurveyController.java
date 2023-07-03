package com.example.questionnaire_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionnaire_api.service.ifs.SurveyService;
import com.example.questionnaire_api.vo.AddSurveyAndQuestionRequest;
import com.example.questionnaire_api.vo.AddSurveyAndQuestionResponse;
import com.example.questionnaire_api.vo.ShowRequest;
import com.example.questionnaire_api.vo.ShowResponse;

@CrossOrigin
@RestController
public class SurveyController {

	@Autowired
	private SurveyService surveyService;

	// 新增問卷
	@PostMapping(value = "add_survey_and_question")
	public AddSurveyAndQuestionResponse addSurveyAndQuestion(@RequestBody AddSurveyAndQuestionRequest Request) {
		return surveyService.addSurveyAndQuestion(Request.getSurvey(), Request.getQuestionList());
	}

	// 顯示所有問卷
	@GetMapping(value = "find_all_survey")
	public ShowResponse findAllSurvey() {
		return surveyService.findAllSurvey();
	}
	
	// 搜尋
	@PostMapping(value = "search_survey")
	public ShowResponse searchSurvey(@RequestBody ShowRequest request) {
		return surveyService.searchSurvey(request.getSearchTitle(), request.getSearchStartDate(), request.getSearchEndDate());
	}
	
	
	

}
