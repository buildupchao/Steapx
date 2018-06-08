package com.project.steapx.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {
	
	public static String getStackTrace(Throwable t) {
		StringWriter strWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(strWriter);

		try {
			t.printStackTrace(writer);
			return strWriter.toString();
		} finally {
			writer.close();
		}
	}
}
