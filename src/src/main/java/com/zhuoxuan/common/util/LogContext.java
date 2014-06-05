package com.zhuoxuan.common.util;

/**
 * 本地线程中的变量
 * 
 * @author 高江涛
 * 
 */
public class LogContext {

	/**
	 * 日志
	 */
	private final static ThreadLocal<String> localThread = new ThreadLocal<String>();

	/**
	 * 给本地线程中设置日志内容
	 * 
	 * @param content
	 */
	public static void configLogContent(String content) {
		localThread.set(content);
	}

	/**
	 * 获取本地线程中的日志内容
	 * 
	 * @return
	 */
	public static String getLogContent() {
		String content = localThread.get();
		localThread.set(null);
		return content;
	}

}
