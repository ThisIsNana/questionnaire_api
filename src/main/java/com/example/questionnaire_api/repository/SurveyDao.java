package com.example.questionnaire_api.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionnaire_api.entity.Survey;

@Repository
public interface SurveyDao extends JpaRepository<Survey, Integer> {

	// �j�M���D
	public List<Survey> findByTitleContaining(String titleKeyword);

	// �j�M�}�l���(�_)
	public List<Survey> findByStartDateAfter(LocalDate startDate);

	// �j�M�������(��)
	public List<Survey> findByEndDateBefore(LocalDate endDate);

	// �j�M�}�l�ε������
	public List<Survey> findByStartDateAfterAndEndDateBefore(LocalDate startDate, LocalDate endDate);

	// �j�M���D�P�}�l���/�������
	public List<Survey> findByTitleContainingAndStartDateAfter(String titleKeyword, LocalDate startDate);

	public List<Survey> findByTitleContainingAndEndDateBefore(String titleKeyword, LocalDate endDate);

	public List<Survey> findByTitleContainingAndStartDateAfterAndEndDateBefore
			(String titleKeyword, LocalDate startDate, LocalDate endDate);

	
	
}
