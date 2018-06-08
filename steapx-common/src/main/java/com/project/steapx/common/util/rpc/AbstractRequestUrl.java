package com.project.steapx.common.util.rpc;

import java.util.LinkedHashMap;

import org.apache.http.client.methods.HttpUriRequest;

public abstract class AbstractRequestUrl {
	protected LinkedHashMap<String, String> params = new LinkedHashMap<>();
	protected String url;
	
	public AbstractRequestUrl append(String key, String value) {
		params.put(key, value);
		return this;
	}
	
	public abstract DefaultIssueRequest<? extends HttpUriRequest> build();

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}