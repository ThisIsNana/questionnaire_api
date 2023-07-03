package com.example.questionnaire_api.service.ifs;

import java.time.LocalDate;
import java.util.List;

import com.example.questionnaire_api.entity.Question;
import com.example.questionnaire_api.entity.Survey;
import com.example.questionnaire_api.vo.AddSurveyAndQuestionResponse;
import com.example.questionnaire_api.vo.ShowResponse;

public interface SurveyService {

	public AddSurveyAndQuestionResponse addSurveyAndQuestion(Survey survey, List<Question> questionList);
	
	public ShowResponse findAllSurvey();

	//·j´M¥\¯à
	public ShowResponse searchSurvey(String title, LocalDate startDate, LocalDate endDate);
	
	

}
