package com.zhuoxuan.common.util;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;

/**
 * @description：异常操作工具类
 * @date 2013-10-2 下午11:19:55
 * @version starsoft.devbase 1.0.0
 * @author：高江涛
 */
public class ExceptionUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 获取异常信息的字符串，将异常信息转换为字符串
	 * 
	 * @param throwable
	 *            异常信息
	 * @return stacktrace 字符串
	 */
	public static String getStackTrace(Throwable throwable) {

		StringWriter buffer = new StringWriter();
		PrintWriter out = new PrintWriter(buffer);

		throwable.printStackTrace(out);
		out.flush();

		return buffer.toString();

	}
}
