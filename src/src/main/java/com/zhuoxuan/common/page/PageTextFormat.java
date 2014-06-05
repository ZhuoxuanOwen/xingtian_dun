package com.zhuoxuan.common.page;

import java.io.Serializable;

/**
 * 获取显示格式的接口
 * 
 * @author Gao Jiangtao
 * 
 */
public interface PageTextFormat extends Serializable {

	/**
	 * 将Pager对象转换成将要在页面上显示的文本
	 * 
	 * @param pager
	 *            Pager对象的数据载体
	 * @return 转换的结果
	 */
	public StringBuilder convertPagerToText(Page pager);

}
