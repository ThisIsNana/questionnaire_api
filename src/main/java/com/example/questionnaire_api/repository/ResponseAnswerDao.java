package com.example.questionnaire_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questionnaire_api.entity.ResponseAnswer;

public interface ResponseAnswerDao extends JpaRepository<ResponseAnswer, Integer>{

}
