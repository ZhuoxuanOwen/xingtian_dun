package com.zhuoxuan.xingtian.res.web;

import java.util.List;

import javax.annotation.Resource;

import com.zhuoxuan.common.result.ResultBase;
import com.zhuoxuan.common.util.BaseAction;
import com.zhuoxuan.xingtian.res.entity.FieldDO;
import com.zhuoxuan.xingtian.res.service.FieldService;

/**
 * @description：处理数据库表字段的业务
 * @date 2013-12-14 上午12:03:22
 * @version 刑天盾-数据平台
 * @author：高江涛
 */
public class FieldAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2253869671337933561L;
	
	@Resource
	private FieldService fieldService;
	
	
	/**
	 * 查询表对应的列信息
	 * @return
	 * @throws Exception
	 */
	public String queryTableFieldList() throws Exception{
		
		String tableId = getRequest().getParameter("tableId");
		
		ResultBase<List<FieldDO>> result = fieldService.queryFieldListByTableId(tableId);
		if (result.isSuccess() && result.getValue() != null) {
			pager.setRows(result.getValue());
			pager.setRowCount(result.getValue().size());
		}
		
		return "success";
	}

}
