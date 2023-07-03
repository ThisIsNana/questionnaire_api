package com.example.questionnaire_api.service.impl;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.questionnaire_api.constant.RtnCode;
import com.example.questionnaire_api.entity.ResponseAnswer;
import com.example.questionnaire_api.service.ifs.ResponseAnswerService;
import com.example.questionnaire_api.vo.AddAnswerResponse;

@Service
public class ResponseAnswerServiceImpl implements ResponseAnswerService{

	//新增答案
	@Override
	public AddAnswerResponse addAnswer(ResponseAnswer responseAnswer) {
		
		// 防呆
		if(responseAnswer == null || !StringUtils.hasText(responseAnswer.getAnswerName())
				|| !StringUtils.hasText(responseAnswer.getAnswerPhone())
				|| !StringUtils.hasText(responseAnswer.getAnswerEmail())
				|| responseAnswer.getAnswerAge() <= 0
				|| !StringUtils.hasText(responseAnswer.getAnswerOption())) {
			return new AddAnswerResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		
		if(responseAnswer.getAnswerSurveyId() < 0) {
			return new AddAnswerResponse(RtnCode.NOT_FOUND.getMessage());
		}
		
		// 確認必填有填寫 => 前端擋下
		
		// 電話格式
		String phonePattern = "^09\\d{8}$";
		if(!Pattern.matches(phonePattern, responseAnswer.getAnswerPhone())) {
			return new AddAnswerResponse(RtnCode.PHONE_NUMBER_ERROR.getMessage());
		}
		
		//email格式
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if(!Pattern.matches(emailPattern,responseAnswer.getAnswerEmail())) {
			return new AddAnswerResponse(RtnCode.EMAIL_ERROR.getMessage());
		}
        
        //選項整理 => 因為有簡答與非必填項目，允許空格/不做篩選。
        
		//確認新增
		return new AddAnswerResponse(RtnCode.ANSWER_SUCCESS.getMessage());
	}
	
	

}
