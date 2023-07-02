package com.example.questionnaire_api.constant;

public enum RtnCode {

    CREATE_COMPLETED("200", "新增成功 Create Success"),
    ANSWER_COMPLETED("200", "回應成功 Answer Success"),
    SEARCH_SUCCESS("200", "搜尋成功 Search Success"),
    DATA_ERROR("400", "格式錯誤 Data Error"),
    PHONE_NUMBER_ERROR("400", "電話格式錯誤 Phone Error"),
    EMAIL_ERROR("400", "信箱格式錯誤 Email Error"),
    DATETIME_ERROR("400", "日期有誤 Date Error"),
    CANNOT_EMPTY("400", "請勿空白 Can Not Empty"),
    NOT_FOUND("401", "查無相關資料 NOT FOUND"),
    ALREADY_EXIST("409", "資料已存在 Already Exist"),
    NO_CHANGE("409", "無項目變更 Nothimg Change");


    private String code;

    private String message;

    private RtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}