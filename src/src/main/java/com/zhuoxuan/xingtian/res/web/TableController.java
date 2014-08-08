package com.zhuoxuan.xingtian.res.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zhuoxuan.common.page.Page;
import com.zhuoxuan.common.util.BaseController;
import com.zhuoxuan.xingtian.res.entity.DatabaseDO;
import com.zhuoxuan.xingtian.res.entity.TableDO;
import com.zhuoxuan.xingtian.res.service.DatabaseService;
import com.zhuoxuan.xingtian.res.service.TableService;

/**
 * 
 * <p>
 *  处理数据表的业务
 * </p>
 * 
 * @author 卓轩
 * @创建时间：2014年8月8日
 * @产品: 刑天盾
 * @version： V1.0
 */

@Controller
@RequestMapping("/res/table")
public class TableController extends BaseController {
	
	@Resource
	private TableService tableService;
	
	@Resource
	private DatabaseService databaseService;
	
	/**
	 * 数据资源表列表
	 * @param databaseId
	 * @return
	 */
	@RequestMapping("/tableList")
	public ModelAndView tableList(ModelMap modelMap,@RequestParam("databaseId") String databaseId){
		
		Page page = super.paging();
		//按照数据库信息ID 查询表信息
		List<TableDO> tableList = tableService.queryTableListByDatabaseId(databaseId);
		page.setRows(tableList);
		page.setRowCount(tableList.size());
		
		modelMap.put("tableList", tableList);
		modelMap.put("page", page);
		
		//DatabaseDO
		DatabaseDO databaseDO = databaseService.queryDatabaseById(databaseId);
		
		modelMap.put("databaseDO", databaseDO);

		return new ModelAndView("resource/table_list");
	}
	
	

}
