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

	@Transactional // �T�O�����\�~�e�X��Ʈw
	@Override
	public AddSurveyAndQuestionResponse addSurveyAndQuestion(Survey survey, List<Question> questionList) {

		// ���b
		if (survey == null || questionList == null || !StringUtils.hasText(survey.getTitle())) {
			return new AddSurveyAndQuestionResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		// �T�{Survey��
		// �ݨ��ɶ��T�{ 1.�����ɶ�<�}�l�ɶ� 2.�}�l�ɶ�<�{�b
		if (survey.getEndDate().isBefore(survey.getStartDate()) || survey.getStartDate().isBefore(LocalDate.now())) {
			return new AddSurveyAndQuestionResponse(RtnCode.DATETIME_ERROR.getMessage());
		}

//		//�ഫ�r�ꬰ����榡(string -> LocalDate)
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDate startTime = LocalDate.parse(survey.getStartDate(), formatter);
//		LocalDate endTime = LocalDate.parse(survey.getEndTime(), formatter);

		// �ˬdQuestion��
		// �M��
		for (Question question : questionList) {

			// ���b
			if (question.getQuestionSurveyId() != survey.getSurveyId() || question.getQuestionSurveyId() < 0) {
				return new AddSurveyAndQuestionResponse(RtnCode.NOT_FOUND.getMessage());
			}

			// �����D���������~
			if (question.getQuestionType() >= 3) {
				return new AddSurveyAndQuestionResponse(RtnCode.QUESTION_TYPE_ERROR.getMessage());
			}

			// �Ūť�
			if (!StringUtils.hasText(question.getQuestion())) {
				return new AddSurveyAndQuestionResponse(RtnCode.CANNOT_EMPTY.getMessage());
			}

			// �s���T�榡���ﶵ
			List<String> newOptStr = new ArrayList<>();

			// ²���D(option������)
			if (question.getQuestionType() == 2 && question.getOption() != "") {
				return new AddSurveyAndQuestionResponse(RtnCode.DATA_ERROR.getMessage());
			}

			else if (question.getQuestionType() == 2 && question.getOption() == "") {
				newOptStr.add(question.getOption());
				continue;
			}

			// ����D(��+�h)
			else if (question.getQuestionType() < 2) {

				if (!StringUtils.hasText(question.getOption())) {
					return new AddSurveyAndQuestionResponse(RtnCode.CANNOT_EMPTY.getMessage());
				}

				// �ﶵ�˴�&�]�w(�Τ����Ϥ�)
				String[] optStr = question.getOption().split(";");
				for (String opt : optStr) {
					if (StringUtils.hasText(opt)) {
						newOptStr.add(opt);
					}
				}

				// �T�w������
				if (newOptStr.size() == 0) {
					return new AddSurveyAndQuestionResponse(RtnCode.CANNOT_EMPTY.getMessage());
				}
			}

			// ��^�r��(�Τ@�榡)
			String optionStr = String.join(";", newOptStr);
			question.setOption(optionStr);
		}

		// �T�{��N�s�J��Ʈw
		surveyDao.save(survey);
		questionDao.saveAll(questionList);
		return new AddSurveyAndQuestionResponse(survey, questionList, RtnCode.CREATE_SUCCESS.getMessage());
	}

	// ��ܩҦ��ݨ�
	public ShowResponse findAllSurvey() {
		List<Survey> surveyList = surveyDao.findAll();
		return new ShowResponse(surveyList, RtnCode.SEARCH_SUCCESS.getMessage());

	}

	// �j�M�\��!!(�A�ΦU������r)
	@Override
	public ShowResponse searchSurvey(String title, LocalDate startDate, LocalDate endDate) {

		// �T�ӬҪšA�h��^�Ҧ����G
		if (!StringUtils.hasText(title) && startDate == null && endDate == null) {

			List<Survey> resultList = surveyDao.findAll();
			return new ShowResponse(resultList, RtnCode.SEARCH_SUCCESS.getMessage());

			
			// 1 �Ȧ��}�l���
		} else if (!StringUtils.hasText(title) && endDate == null) {
			List<Survey> resultList = surveyDao.findByStartDateAfter(startDate);
			return new ShowResponse(resultList, RtnCode.SEARCH_SUCCESS.getMessage());

			
			// 2 �Ȧ��������
		} else if (!StringUtils.hasText(title) && startDate == null) {
			List<Survey> resultList = surveyDao.findByEndDateBefore(endDate);
			return new ShowResponse(resultList, RtnCode.SEARCH_SUCCESS.getMessage());

			
			// 3 �Ȧ�����r
		} else if (startDate == null && endDate == null) {
			List<Survey> resultList = surveyDao.findByTitleContaining(title);
			return new ShowResponse(resultList, RtnCode.SEARCH_SUCCESS.getMessage());

			
			// 4 �j�M����r+�}�l���
		}else if (endDate == null && StringUtils.hasText(title)) {
			List<Survey> resultList = surveyDao.findByTitleContainingAndStartDateAfter(title, startDate);
			return new ShowResponse(resultList, RtnCode.SEARCH_SUCCESS.getMessage());
			
			
			// 5 �j�M����r+�������
		}else if (startDate == null && StringUtils.hasText(title)) {
			List<Survey> resultList = surveyDao.findByTitleContainingAndEndDateBefore(title, endDate);
			return new ShowResponse(resultList, RtnCode.SEARCH_SUCCESS.getMessage());

			
			// 6 �j�M�}�l���+�������
		}else if (!StringUtils.hasText(title)) {
			List<Survey> resultList = surveyDao.findByStartDateAfterAndEndDateBefore(startDate, endDate);
			return new ShowResponse(resultList, RtnCode.SEARCH_SUCCESS.getMessage());

			
			// 7 �j�M����r+�}�l���+�������
		} else {
			List<Survey> resultList = surveyDao.findByTitleContainingAndStartDateAfterAndEndDateBefore(title, startDate, endDate);
			return new ShowResponse(resultList, RtnCode.SEARCH_SUCCESS.getMessage());
		}
	}

}
