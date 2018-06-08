package com.project.steapx.common.bo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class JsonEntity<T> implements Serializable {
    private static final long serialVersionUID = -1176732685636776472L;
    @ApiModelProperty(value = "API http response status. 200 is ok, 500 is failed.", example = "200", required = true)
    private int status = 200;
    @ApiModelProperty(value = "Human readable response message")
    private String message;
    @ApiModelProperty(value = "Unique request id", example = "5a124806f9f9e98924014e76", required = true)
    private String requestId;
    @ApiModelProperty(value = "Actual response data as JSON")
    T data;

    public JsonEntity() {
    }

    public JsonEntity(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    @SuppressWarnings("rawtypes")
	public JsonEntity setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    @SuppressWarnings("rawtypes")
	public JsonEntity setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getRequestId() {
        return requestId;
    }

    @SuppressWarnings("rawtypes")
	public JsonEntity setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public T getData() {
        return data;
    }

    @SuppressWarnings("rawtypes")
	public JsonEntity setData(T data) {
        this.data = data;
        return this;
    }

    @JsonIgnore
    public boolean normal() {
        return status == 200;
    }

    @Override
    public String toString() {
        return "JsonEntity{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", requestId='" + requestId + '\'' +
                ", data=" + data +
                '}';
    }
}
