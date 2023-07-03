package com.example.questionnaire_api.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.questionnaire_api.constant.RtnCode;
import com.example.questionnaire_api.entity.Question;
import com.example.questionnaire_api.entity.Survey;
import com.example.questionnaire_api.repository.QuestionDao;
import com.example.questionnaire_api.repository.SurveyDao;
import com.example.questionnaire_api.service.ifs.SurveyService;
import com.example.questionnaire_api.vo.AddSurveyAndQuestionResponse;
import com.example.questionnaire_api.vo.ShowResponse;

@Service
public class SurveyServiceImpl implements SurveyService {

	@Autowired
	private SurveyDao surveyDao;

	@Autowired
	private QuestionDao questionDao;

	@Transactional // 確保都成功才送出資料庫
	@Override
	public AddSurveyAndQuestionResponse addSurveyAndQuestion(Survey survey, List<Question> questionList) {

		// 防呆
		if (survey == null || questionList == null || !StringUtils.hasText(survey.getTitle())) {
			return new AddSurveyAndQuestionResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		// 確認Survey區
		// 問卷時間確認 1.結束時間<開始時間 2.開始時間<現在
		if (survey.getEndDate().isBefore(survey.getStartDate()) || survey.getStartDate().isBefore(LocalDate.now())) {
			return new AddSurveyAndQuestionResponse(RtnCode.DATETIME_ERROR.getMessage());
		}

//		//轉換字串為日期格式(string -> LocalDate)
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDate startTime = LocalDate.parse(survey.getStartDate(), formatter);
//		LocalDate endTime = LocalDate.parse(survey.getEndTime(), formatter);

		// 檢查Question區
		// 清單
		for (Question question : questionList) {

			// 防呆
			if (question.getQuestionSurveyId() != survey.getSurveyId() || question.getQuestionSurveyId() < 0) {
				return new AddSurveyAndQuestionResponse(RtnCode.NOT_FOUND.getMessage());
			}

			// 防止題目類型錯誤
			if (question.getQuestionType() >= 3) {
				return new AddSurveyAndQuestionResponse(RtnCode.QUESTION_TYPE_ERROR.getMessage());
			}

			// 勿空白
			if (!StringUtils.hasText(question.getQuestion())) {
				return new AddSurveyAndQuestionResponse(RtnCode.CANNOT_EMPTY.getMessage());
			}

			// 存正確格式的選項
			List<String> newOptStr = new ArrayList<>();

			// 簡答題(option應為空)
			if (question.getQuestionType() == 2 && question.getOption() != "") {
				return new AddSurveyAndQuestionResponse(RtnCode.DATA_ERROR.getMessage());
			}

			else if (question.getQuestionType() == 2 && question.getOption() == "") {
				newOptStr.add(question.getOption());
				continue;
			}

			// 選擇題(單+多)
			else if (question.getQuestionType() < 2) {

				if (!StringUtils.hasText(question.getOption())) {
					return new AddSurveyAndQuestionResponse(RtnCode.CANNOT_EMPTY.getMessage());
				}

				// 選項檢測&設定(用分號區分)
				String[] optStr = question.getOption().split(";");
				for (String opt : optStr) {
					if (StringUtils.hasText(opt)) {
						newOptStr.add(opt);
					}
				}

				// 確定不為空
				if (newOptStr.size() == 0) {
					return new AddSurveyAndQuestionResponse(RtnCode.CANNOT_EMPTY.getMessage());
				}
			}

			// 轉回字串(統一格式)
			String optionStr = String.join(";", newOptStr);
			question.setOption(optionStr);
		}

		// 確認後就存入資料庫
		surveyDao.save(survey);
		questionDao.saveAll(questionList);
		return new AddSurveyAndQuestionResponse(survey, questionList, RtnCode.CREATE_SUCCESS.getMessage());
	}

	// 顯示所有問卷
	public ShowResponse findAllSurvey() {
		List<Survey> surveyList = surveyDao.findAll();
		return new ShowResponse(surveyList, RtnCode.SEARCH_SUCCESS.getMessage());

	}

	// 搜尋功能!!(適用各種關鍵字)
	@Override
	public ShowResponse searchSurvey(String title, LocalDate startDate, LocalDate endDate) {

		// 三個皆空，則返回所有結果
		if (!StringUtils.hasText(title) && startDate == null && endDate == null) {

			List<Survey> resultList = surveyDao.findAll();
			return new ShowResponse(resultList, RtnCode.SEARCH_SUCCESS.getMessage());

			
			// 1 僅有開始日期
		} else if (!StringUtils.hasText(title) && endDate == null) {
			List<Survey> resultList = surveyDao.findByStartDateAfter(startDate);
			return new ShowResponse(resultList, RtnCode.SEARCH_SUCCESS.getMessage());

			
			// 2 僅有結束日期
		} else if (!StringUtils.hasText(title) && startDate == null) {
			List<Survey> resultList = surveyDao.findByEndDateBefore(endDate);
			return new ShowResponse(resultList, RtnCode.SEARCH_SUCCESS.getMessage());

			
			// 3 僅有關鍵字
		} else if (startDate == null && endDate == null) {
			List<Survey> resultList = surveyDao.findByTitleContaining(title);
			return new ShowResponse(resultList, RtnCode.SEARCH_SUCCESS.getMessage());

			
			// 4 搜尋關鍵字+開始日期
		}else if (endDate == null && StringUtils.hasText(title)) {
			List<Survey> resultList = surveyDao.findByTitleContainingAndStartDateAfter(title, startDate);
			return new ShowResponse(resultList, RtnCode.SEARCH_SUCCESS.getMessage());
			
			
			// 5 搜尋關鍵字+結束日期
		}else if (startDate == null && StringUtils.hasText(title)) {
			List<Survey> resultList = surveyDao.findByTitleContainingAndEndDateBefore(title, endDate);
			return new ShowResponse(resultList, RtnCode.SEARCH_SUCCESS.getMessage());

			
			// 6 搜尋開始日期+結束日期
		}else if (!StringUtils.hasText(title)) {
			List<Survey> resultList = surveyDao.findByStartDateAfterAndEndDateBefore(startDate, endDate);
			return new ShowResponse(resultList, RtnCode.SEARCH_SUCCESS.getMessage());

			
			// 7 搜尋關鍵字+開始日期+結束日期
		} else {
			List<Survey> resultList = surveyDao.findByTitleContainingAndStartDateAfterAndEndDateBefore(title, startDate, endDate);
			return new ShowResponse(resultList, RtnCode.SEARCH_SUCCESS.getMessage());
		}
	}

}
