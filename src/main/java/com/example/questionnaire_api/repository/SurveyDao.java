package com.example.questionnaire_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questionnaire_api.entity.Survey;

public interface SurveyDao extends JpaRepository<Survey, Integer> {

}
