package com.project.steapx.common.web;

import java.util.UUID;

public class IdUtils {
	
	public static String id() {
		return UUID.randomUUID().toString();
	}
}
