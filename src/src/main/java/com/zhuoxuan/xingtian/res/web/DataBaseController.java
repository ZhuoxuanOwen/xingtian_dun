/**
 * 
 */
package com.zhuoxuan.xingtian.res.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhuoxuan.common.page.Page;
import com.zhuoxuan.common.util.BaseController;
import com.zhuoxuan.xingtian.res.entity.DatabaseDO;
import com.zhuoxuan.xingtian.res.service.DatabaseService;

/**
 * <p>
 *  数据库资源管理
 * </p>
 * 
 * @author 卓轩
 * @创建时间：2014年7月12日
 * @产品: 刑天盾
 * @version： V1.0
 */
@RequestMapping("/res/database")
@Controller
public class DataBaseController extends BaseController{
	
	
	@Resource
	private DatabaseService databaseService;
	
	/**
	 * 查询数据库资源列表
	 * @return
	 */
	@RequestMapping("/databaseList")
	public ModelAndView databaseList(ModelMap modelMap){
		
		Page page = super.paging();
		
		//调用业务接口进行查询
		List<DatabaseDO> databaseList = databaseService.queryDatabaseList(page);

		modelMap.put("databaseList", databaseList);
		modelMap.put("page", page);
		
		return new ModelAndView("resource/database_resource");
	}
	

}
