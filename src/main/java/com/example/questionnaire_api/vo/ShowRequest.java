package com.example.questionnaire_api.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShowRequest {

	//·j´M¥Î
	@JsonProperty("search_title")
	private String searchTitle;

	@JsonProperty("search_start_date")
	private LocalDate searchStartDate;

	@JsonProperty("search_end_date")
	private LocalDate SearchEndDate;

	// ===============================================================

	public String getSearchTitle() {
		return searchTitle;
	}

	public void setSearchTitle(String searchTitle) {
		this.searchTitle = searchTitle;
	}

	public LocalDate getSearchStartDate() {
		return searchStartDate;
	}

	public void setSearchStartDate(LocalDate searchStartDate) {
		this.searchStartDate = searchStartDate;
	}

	public LocalDate getSearchEndDate() {
		return SearchEndDate;
	}

	public void setSearchEndDate(LocalDate searchEndDate) {
		SearchEndDate = searchEndDate;
	}

}
