/**
 * 
 */
package com.zhuoxuan.xingtian.res.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhuoxuan.common.page.Page;
import com.zhuoxuan.common.result.ResultBase;
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
	 * 初始化添加数据源
	 * @return
	 */
	@RequestMapping("/initAddDatabase")
	public ModelAndView initDatabaseAdd(ModelMap modelMap){
		return new ModelAndView("resource/database_add");
	}
	
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
	
	/**
	 * 保存数据库资源信息
	 * @return
	 */
	@RequestMapping("/saveDatabase")
	@ResponseBody
	public ResultBase<Boolean> saveDatabase(@ModelAttribute("vo") DatabaseDO vo){
		
		ResultBase<Boolean> result = new ResultBase<Boolean>();
		//调用接口保存数据库资源信息
		boolean resultSave = databaseService.insertDatabase(vo);
		if (resultSave) {
			return result.setReturnRightValue(true);
		}else{
			return result.setReturnErrorMsg("保存数据库资源信息失败。");
		}
	}
	
	/**
	 * 初始化数据库信息
	 */
	@RequestMapping("/initDatabase")
	@ResponseBody
	public ResultBase<Boolean> initDatabase(@RequestParam("databaseId") String databaseId){
		
		return databaseService.initDataBaseResource(databaseId);
		
	}
	

}
