package com.project.steapx.common.util.rpc;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;

public class DefaultGetRequestUrl extends AbstractRequestUrl {

	private HttpGet httpGet;

	@Override
	public DefaultIssueRequest<? extends HttpUriRequest> build() {
		try {
			URIBuilder uriBuilder = new URIBuilder(url);
			if (MapUtils.isNotEmpty(params)) {
				for (Map.Entry<String, String> pair : params.entrySet()) {
					uriBuilder.addParameter(pair.getKey(), pair.getValue());
				}
			}
			URI uri = uriBuilder.build();
			this.httpGet = new HttpGet(uri);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return new DefaultIssueRequest<HttpGet>(httpGet);
	}
}
