package com.project.steapx.common.util.rpc;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.collections.MapUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;

import com.google.common.collect.Lists;

public class DefaultPostRequestUrl extends AbstractRequestUrl {

	private HttpPost httpPost;
	private String json;
	private ContentType contentType;
	
	public DefaultPostRequestUrl append(String json) {
		this.json = json;
		this.contentType = ContentType.APPLICATION_JSON;
		return this;
	}
	
	@Override
	public DefaultIssueRequest<? extends HttpUriRequest> build() {
		try {
			this.httpPost = new HttpPost(url);
			if (Objects.equals(ContentType.APPLICATION_JSON, contentType)) {
				StringEntity entity = new StringEntity(json, contentType);
				this.httpPost.setEntity(entity);
			} else {
				if (MapUtils.isNotEmpty(params)) {
					List<NameValuePair> parameters = Lists.newArrayList();
					for (Map.Entry<String, String> pair : params.entrySet()) {
						parameters.add(new BasicNameValuePair(pair.getKey(), pair.getValue()));
					}
					UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameters);
					this.httpPost.setEntity(entity);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new DefaultIssueRequest<HttpPost>(httpPost);
	}
}
