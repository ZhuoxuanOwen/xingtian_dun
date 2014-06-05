package com.zhuoxuan.xingtian.res.action;

import java.util.List;

import javax.annotation.Resource;

import com.zhuoxuan.common.result.ResultBase;
import com.zhuoxuan.common.util.BaseAction;
import com.zhuoxuan.xingtian.res.entity.DatabaseDO;
import com.zhuoxuan.xingtian.res.service.DatabaseService;

/**
 * <p>
 * 数据库Controller
 * </p>
 * 
 * @author 高江涛
 * @创建时间：Jul 9, 2012 1:07:10 PM
 * @产品: JQSupportPlateform
 * @version： V1.0
 */
public class DatabaseAction extends BaseAction {

	/**
	 * <p>
	 * </p>
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private DatabaseService databaseService;

	private DatabaseDO vo;

	private List<DatabaseDO> databases;

	/**
	 * <p>
	 * 保存数据库信息
	 * </p>
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String saveDatabase() throws Exception {

		boolean result = databaseService.insertDatabase(vo);
		if (result) {
			super.setJsonResult().setSuccess(true);
		} else {
			super.setJsonResult().setSuccess(false).setErrorMsg("保存数据库信息失败!");
		}
		return SUCCESS;
	}

	/**
	 * <p>
	 * 查询数据库列表
	 * </p>
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String queryDatabase() throws Exception {

		super.paging();
		databases = databaseService.queryDatabaseList(pager);
		pager.setRows(databases);

		return SUCCESS;
	}
	
	/**
	 * <p>
	 * 查询数据库列表 对外，查询可以使用的
	 * </p>
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String queryAliseDatabase() throws Exception {

		super.paging();
		databases = databaseService.queryDatabaseList(pager);
		return SUCCESS;
	}
	

	/**
	 * <p>
	 * 初始化数据库信息
	 * </p>
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String initDatabase() throws Exception {

		ResultBase<Boolean> result = databaseService.initDataBaseResource(vo.getDatabaseId());
		if (result.isSuccess()) {
			super.setJsonResult();
		}
		return SUCCESS;

	}

	public DatabaseDO getVo() {
		return vo;
	}

	public void setVo(DatabaseDO vo) {
		this.vo = vo;
	}

	public List<DatabaseDO> getDatabases() {
		return databases;
	}

}
