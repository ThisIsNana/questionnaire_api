package com.example.questionnaire_api.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionnaire_api.entity.Survey;

@Repository
public interface SurveyDao extends JpaRepository<Survey, Integer> {

	// 搜尋標題
	public List<Survey> findByTitleContaining(String titleKeyword);

	// 搜尋開始日期(起)
	public List<Survey> findByStartDateAfter(LocalDate startDate);

	// 搜尋結束日期(迄)
	public List<Survey> findByEndDateBefore(LocalDate endDate);

	// 搜尋開始或結束日期
	public List<Survey> findByStartDateAfterAndEndDateBefore(LocalDate startDate, LocalDate endDate);

	// 搜尋標題與開始日期/結束日期
	public List<Survey> findByTitleContainingAndStartDateAfter(String titleKeyword, LocalDate startDate);

	public List<Survey> findByTitleContainingAndEndDateBefore(String titleKeyword, LocalDate endDate);

	public List<Survey> findByTitleContainingAndStartDateAfterAndEndDateBefore
			(String titleKeyword, LocalDate startDate, LocalDate endDate);

	
	
}
