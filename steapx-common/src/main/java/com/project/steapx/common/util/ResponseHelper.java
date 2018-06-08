package com.project.steapx.common.util;

import com.project.steapx.common.bo.JsonEntity;
import com.project.steapx.common.exception.ErrorMsg;

public class ResponseHelper {
	
	public static <T> JsonEntity<T> createInstance(T object) {
		JsonEntity<T> response = new JsonEntity<>(object);
		response.setRequestId(null);
		return response;
	}

	public static <T> JsonEntity<T> of(T object) {
		return createInstance(object);
	}

	public static <T> JsonEntity<T> ofNothing() {
		return createInstance(null);
	}

	public static <T> JsonEntity<T> withMessage(String message) {
		return ofNothing().setMessage(message);
	}

	public static <T> JsonEntity<T> withMessage(ErrorMsg errorMsg) {
		return withMessage(errorMsg.getMessage()).setStatus(errorMsg.getStatus());
	}
}
