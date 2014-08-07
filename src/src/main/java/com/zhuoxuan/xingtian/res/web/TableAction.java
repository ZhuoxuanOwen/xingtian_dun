package com.zhuoxuan.xingtian.res.web;


import java.util.List;

import javax.annotation.Resource;

import com.zhuoxuan.common.util.BaseAction;
import com.zhuoxuan.xingtian.res.entity.DatabaseDO;
import com.zhuoxuan.xingtian.res.entity.TableDO;
import com.zhuoxuan.xingtian.res.service.DatabaseService;
import com.zhuoxuan.xingtian.res.service.TableService;

/**
 * <p>   表 Controller     </p>
 *  @author 高江涛
 * @创建时间：Jul 9, 2012 1:14:42 PM
 * @产品: JQSupportPlateform
 * @version： V1.0
 */
public class TableAction extends BaseAction {

	/**
	 * <p> </p>
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private TableService tableService;
	
	@Resource
	private DatabaseService databaseService;
	
	private List<TableDO> tableList;
	
	private DatabaseDO databaseDO;
	
	
	
	/**
	 * 查询数据库资源下的表
	 * @return
	 * @throws Exception
	 */
	public String queryTableList() throws Exception {
		
		String databaseId = getRequest().getParameter("databaseId");
		
		tableList = tableService.queryTableListByDatabaseId(databaseId);
		pager.setRows(tableList);
		pager.setRowCount(tableList.size());
		
		//DatabaseDO
		databaseDO = databaseService.queryDatabaseById(databaseId);

		return "success";
	}



	public void setTableService(TableService tableService) {
		this.tableService = tableService;
	}

    

	public DatabaseDO getDatabaseDO() {
		return databaseDO;
	}



	public List<TableDO> getTableList() {
		return tableList;
	}
	
	
	

}
