package com.zhuoxuan.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description：字符集过滤器
 * @date 2013-9-14 上午12:01:25
 * @version jq-common 1.0.0
 * @author：高江涛
 */
public class CharSetFilter implements Filter {

	private static final String DEFAUT_CHARSET = "UTF-8";

	private String charset;

	public void destroy() {
		charset = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponse hresponse = (HttpServletResponse) response;

		hrequest.setCharacterEncoding(charset);
		hresponse.setCharacterEncoding(charset);

		chain.doFilter(hrequest, hresponse);

	}

	public void init(FilterConfig config) throws ServletException {

		this.charset = config.getInitParameter("charset");
		if (charset == null) {
			// logger.info("读取并设置字符集成功,当前工程的字符集是:" + charset);
			// } else {
			this.charset = DEFAUT_CHARSET;
			// logger.warn("系统没有配置字符集，配置默认的字符集为:" + DEFAUT_CHARSET);
		}

	}

}
