package com.project.steapx.common.util.rpc;

public final class RpcInvoker {

	public static DefaultGetRequestUrl get(String url) {
		DefaultGetRequestUrl uri = new DefaultGetRequestUrl();
		uri.setUrl(url);
		return uri;
	}

	public static DefaultPostRequestUrl post(String url) {
		DefaultPostRequestUrl uri = new DefaultPostRequestUrl();
		uri.setUrl(url);
		return uri;
	}
}
