package com.zhuoxuan.common.util;

import com.zhuoxuan.common.page.Page;
import com.zhuoxuan.common.page.PageContext;
import com.zhuoxuan.common.page.PageContextImpl;

public class BaseController {
	
	private int defaultPageSize = 20;
	
	/**
	 * <p>
	 * 处理分页
	 * </p>
	 * 
	 * @return
	 * @return
	 * @exception
	 */
	protected Page paging() {
		
		Page pager = new Page();
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


		return pager;
	}
	

}
