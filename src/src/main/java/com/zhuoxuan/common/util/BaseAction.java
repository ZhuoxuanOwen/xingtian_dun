package com.zhuoxuan.common.util;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.zhuoxuan.common.page.Page;
import com.zhuoxuan.common.page.PageContext;
import com.zhuoxuan.common.page.PageContextImpl;
import com.zhuoxuan.common.result.JsonResult;

/**
 * <p>
 * 所有Action的基类 处理公共的业务
 * </p>
 * 
 * @author 高江涛
 * @创建时间：2012-4-28 下午02:59:33
 * @产品: JQDevPlateform
 * @version： V1.0
 */
public class BaseAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware, ServletContextAware, ParameterAware {

	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	private HttpServletResponse response;
	private ServletContext servletContext;
	private Map<String, String[]> parameters;
	private String msg;
	private JsonResult jsonResult;
	private String jsonContext;

	/**
	 * <p>
	 * 默认每页显示的条数
	 * </p>
	 */
	private int defaultPageSize = 20;

	public BaseAction() {
		this.request = null;
		this.response = null;
		this.servletContext = null;
		this.parameters = null;
		this.msg = null;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public void setParameters(Map<String, String[]> params) {
		this.parameters = params;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public Map<String, String[]> getParameters() {
		return parameters;
	}

	public HttpSession getSession() {
		return this.getRequest().getSession();
	}

	public String getMsg() {
		return msg;
	}

	public void setJavaScriptMsg(String msg) {
		this.msg = "<script lanage='javascript'>" + msg + "</script>";
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	

	public JsonResult getJsonResult() {
		return jsonResult;
	}

	public JsonResult setJsonResult() {
		this.jsonResult = new JsonResult();
		return jsonResult;
	}

	protected Page pager = new Page();
	protected PageContext pagerContext = null;

	/**
	 * <p>
	 * 处理分页
	 * </p>
	 * 
	 * @return
	 * @return
	 * @exception
	 */
	protected PageContext paging() {
		/**
		 * 当前的页数
		 */
		int currentPager = pager.getCurrentPage() == 0 ? 1 : pager
				.getCurrentPage();
		pager.setCurrentPage(currentPager);

		/**
		 * 每页显示几条数据
		 */
		int psize = pager.getPageSize() == 0 ? defaultPageSize : pager
				.getPageSize();
		pager.setPageSize(psize);

		pagerContext = new PageContextImpl(pager);

		return pagerContext;
	}
	
	public void printJsonObject(Object object) throws IOException{
		JSONObject jsonObject = JSONObject.fromObject(object);
		response.getWriter().print(jsonObject.toString());
	}
	
	public void printJsonArrayObject(Object object) throws IOException{
		JSONArray jsonArray = JSONArray.fromObject(object);
		response.getWriter().print(jsonArray.toString());
	}

	/**
	 * <p>
	 * 得到分页对象
	 * </p>
	 * 
	 * @param
	 * @return
	 * @exception
	 */
	public Page getPager() {
		return pager;
	}

	/**
	 * <p>
	 * 获取Spring工厂的上下文对象
	 * </p>
	 * 
	 * @return ApplicationContext Spring工厂的上下文
	 * @exception
	 */
	public ApplicationContext getWebApplicationContext() {

		ApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);

		return applicationContext;

	}

	public void setPager(Page pager) {
		this.pager = pager;
	}

	public PageContext getPagerContext() {
		return pagerContext;
	}

	public void setPagerContext(PageContext pagerContext) {
		this.pagerContext = pagerContext;
	}

	public String getJsonContext() {
		return jsonContext;
	}

	public void setJsonContext(String jsonContext) {
		this.jsonContext = jsonContext;
	}

	
}
