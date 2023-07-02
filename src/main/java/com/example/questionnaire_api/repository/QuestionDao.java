package com.example.questionnaire_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questionnaire_api.entity.Question;

public interface QuestionDao extends JpaRepository<Question, Integer>{

}
