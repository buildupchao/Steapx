package com.project.steapx.common.util.rpc;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class DefaultIssueRequest<T extends HttpUriRequest> {
	
	T http;
	
	public DefaultIssueRequest(T http) {
		super();
		this.http = http;
	}
	
	/**
	 * Note: Normal confidence for statusCode(200).
	 * @see
	 * @return
	 */
	public String request() {
		CloseableHttpClient httpClient = HttpClients.createDefault();

		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(http);
//			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
//			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}
}
