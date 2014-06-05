package com.zhuoxuan.common.page;


/**
 * 获取显示格式的实现类
 * 
 * @author Gao Jiangtao
 * 
 */
public class PageTextFormatTextImpl implements PageTextFormat {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 将Pager对象转换成将要在页面上显示的文本
	 * 
	 * @param pager
	 *            Pager对象的数据载体
	 * @return 转换的结果
	 */
	public StringBuilder convertPagerToText(Page pager) {
		StringBuilder sb = new StringBuilder();
		sb.append("共<font color='red'>" + pager.getRowCount()
				+ "</font>条记录&nbsp;");
		sb.append("第" + pager.getCurrentPage() + "/" + pager.getPageCount()
				+ "页&nbsp;");
		/* 首页 */
		if (pager.getCurrentPage() == 1) {
			sb.append("首页&nbsp;上一页&nbsp;");
		} else {
			sb.append("<a href=\"javascript:refushPager('" + pager.getLinkUrl()
					+ "','" + pager.getRefushElement()
					+ "','pager.currentPage=1" + pager.getUrlParams()
					+ "'')\" "
					+ ">首页</a> &nbsp;<a  href=\"javascript:refushPager('"
					+ pager.getLinkUrl() + "','" + pager.getRefushElement()
					+ "','pager.currentPage=" + (pager.getCurrentPage() - 1)
					+ pager.getUrlParams() + "');\">上一页</a>&nbsp;");
		}

		/* 中间选页 */
		for (int i = pager.getCurrentPage() - 3; i <= pager.getCurrentPage() + 3; i++) {
			if (i <= 0 || i > pager.getPageCount())
				continue;
			if (i == pager.getCurrentPage())
				sb
						.append("<span style='color:red;border:1px'>" + i
								+ "</span>");
			else {
				sb.append("<a href=\"javascript:refushPager('"
						+ pager.getLinkUrl() + "','" + pager.getRefushElement()
						+ "','pager.currentPage=" + i + pager.getUrlParams()
						+ "');\">" + i + "</a>");
			}
			sb.append("&nbsp;");
		}
		sb.append("&nbsp;");
		/* 下一页 尾页 */
		if (pager.getPageCount() == 0
				|| pager.getPageCount() == pager.getCurrentPage()) {
			sb.append("下一页&nbsp;尾页");
		} else {
			sb.append("<a href=\"javascript:refushPager('" + pager.getLinkUrl()
					+ "','" + pager.getRefushElement()
					+ "','pager.currentPage=" + (pager.getCurrentPage() + 1)
					+ pager.getUrlParams() + "')\">下一页</a>&nbsp;"
					+ "<a  href=\"javascript:refushPager('"
					+ pager.getLinkUrl() + "','" + pager.getRefushElement()
					+ "','pager.currentPage=" + pager.getPageCount()
					+ pager.getUrlParams() + "')\">尾页</a>");
		}

		return sb;
	}

}
