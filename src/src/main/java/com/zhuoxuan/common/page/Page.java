package com.zhuoxuan.common.page;

import java.util.List;

public class Page {

	private String dataKey;
	private String countKey;
	private Object condation;
	private int pageSize;
	private int currentPage;
	private String linkUrl;
	private int rowCount;
	private int pageCount;
	private int start;
	private int end;
	private String urlParams;
	private String refushElement;
	private String methedName;
	
	private List<?> rows;
	private int total;
	

	public String getMethedName() {
		return methedName;
	}

	public void setMethedName(String methedName) {
		this.methedName = methedName;
	}

	public Page() {
	}

	/**
	 * @param table
	 * @param clu
	 * @param condation
	 * @param pageSize
	 * @param currentPage
	 * @param linkUrl
	 */
	public Page(String table, String clu, String condation, int pageSize,
			int currentPage, String linkUrl) {
		super();
		this.condation = condation;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.linkUrl = linkUrl;
	}

	public String getRefushElement() {
		return refushElement;
	}

	public void setRefushElement(String refushElement) {
		this.refushElement = refushElement;
	}

	public String getDataKey() {
		return dataKey;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

	public String getCountKey() {
		return countKey;
	}

	public void setCountKey(String countKey) {
		this.countKey = countKey;
	}

	public Object getCondation() {
		return condation;
	}

	public void setCondation(Object condation) {
		this.condation = condation;
	}

	public String getUrlParams() {
		if (this.urlParams == null) {
			return "";
		} else {
			return urlParams;
		}
	}

	public void setUrlParams(String urlParams) {
		this.urlParams = urlParams;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public int getRowCount() {
		return rowCount;
	}

	public Page setRowCount(int rowCount) {
		this.rowCount = rowCount;
		this.total = rowCount;
		return this;
	}

	public int getPageCount() {
		if (pageCount == 0)
			return 1;
		else
			return pageCount;
	}

	
	
	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return this.rowCount;
	}


	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public Page commonInit() {
		if (rowCount % pageSize != 0) {
			pageCount = rowCount / pageSize + 1;
		} else {
			pageCount = rowCount / pageSize;
		}
		if (currentPage == 1) {
			if (rowCount < pageSize) {
				start = currentPage * pageSize - pageSize;
				end = rowCount;
			} else {
				start = currentPage * pageSize - pageSize;
				end = currentPage * pageSize;
			}
		} else if (currentPage == pageCount) {
			start = currentPage * pageSize - pageSize;
			end = rowCount;
		} else {
			start = currentPage * pageSize - pageSize;
			end = currentPage * pageSize;
		}
		return this;
	}

}
