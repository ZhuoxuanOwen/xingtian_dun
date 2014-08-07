package com.zhuoxuan.xingtian.res.web;

import java.util.List;

import javax.annotation.Resource;

import com.zhuoxuan.common.util.BaseAction;
import com.zhuoxuan.xingtian.res.entity.MongodbDO;
import com.zhuoxuan.xingtian.res.service.MongodbService;
/**
 * 
 * <p>
 * 处理mongodb的业务
 * </p>
 * 
 * @author 卓轩
 * @创建时间：2014年6月4日
 * @产品: 刑天盾-数据平台
 * @version： V1.0
 */
public class MongodbAction extends BaseAction {
	
	@Resource
	private MongodbService mongodbService;

	/**
	 * 
	 */
	private static final long serialVersionUID = -3750238268205424684L;
	
	
	private List<MongodbDO> mongodbList;
	
	/**
	 * 页面查询mongodb 信息列表
	 * @throws Exception
	 */
	public String queryMongodbList() throws Exception{
		
		super.paging();
		
		mongodbList = mongodbService.queryMongodbList(pager);
		
		return "success";
	}

	public List<MongodbDO> getMongodbList() {
		return mongodbList;
	}
	
	
	

}
