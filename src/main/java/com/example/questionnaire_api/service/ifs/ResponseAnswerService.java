package com.example.questionnaire_api.service.ifs;

import com.example.questionnaire_api.entity.ResponseAnswer;
import com.example.questionnaire_api.vo.AddAnswerResponse;

public interface ResponseAnswerService {

	public AddAnswerResponse addAnswer(ResponseAnswer responseAnswer);

}
