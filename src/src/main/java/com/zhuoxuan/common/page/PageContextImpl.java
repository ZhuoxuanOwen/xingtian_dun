package com.zhuoxuan.common.page;


/**
 * @类功能说明：
 * @作者：高江涛
 * @创建时间：2012-4-28 下午01:41:46
 * @版本：V1.0
 */
public class PageContextImpl implements PageContext {

	private Page pager = null;
	private StringBuilder urlParams = null;
	private StringBuilder methods = null;

	public PageContextImpl() {
	}

	public PageContextImpl(Page pager) {
		this.pager = pager;
	}

	/**
	 * 设置每页显示多数条数据
	 * 
	 * @param pSize
	 * @return
	 */
	public PageContext psize(int pSize) {
		pager.setPageSize(pSize);
		return this;
	}

	/**
	 * 设置URL传递的参数
	 * 
	 * @param condition
	 * @return
	 */
	public PageContext params(String condition) {
		if (this.urlParams == null) {
			urlParams = new StringBuilder("&" + condition);
		} else {
			urlParams.append("&" + urlParams);
		}
		return this;
	}

	/**
	 * 设置连接
	 * 
	 * @param url
	 * @return
	 */
	public PageContextImpl url(String url) {
		pager.setLinkUrl(url);
		return this;
	}

	/**
	 * 设置刷新的区域
	 * 
	 * @param element
	 * @return
	 */
	public PageContext element(String element) {
		pager.setRefushElement(element);
		return this;
	}

	/**
	 * 添加回调函数名称
	 * 
	 * @param methedName
	 * @return
	 */
	public PageContext methed(String methedName) {
		pager.setMethedName(methedName);
		return this;
	}

	/**
	 * 完成 统一部署
	 */
	public void deployee() {
		// 连接参数
		if (urlParams != null) {
			pager.setUrlParams(urlParams.toString());
		}

		// 回调方法
		if (methods != null) {
			pager.setMethedName(methods.toString());
		}

	}

}
