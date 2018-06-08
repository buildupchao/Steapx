package com.project.steapx.common.exception;

public enum ErrorMsg {
    EVERYTHING_IS_OK(200, "Everything is OK!"),
    FILE_UPLOAD_SUCCESS(10000, "Uploading files is successful! URL is {}."),
    FILE_UPLOAD_FAIL(100001, "Uploading files is not successful!"),
    FILE_UPLOAD_ERROR(100002, "Uploading files generates an error!"),
    CANNOT_FIND_DATA(100003, "Error here!!!Can't find data %s!>>>>>>>");

    private Integer status;
    private String message;

    ErrorMsg(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
