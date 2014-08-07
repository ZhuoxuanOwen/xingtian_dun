package com.zhuoxuan.xingtian.res.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zhuoxuan.common.exception.XTServiceException;
import com.zhuoxuan.common.result.ResultBase;
import com.zhuoxuan.common.util.ExceptionUtil;
import com.zhuoxuan.common.util.XTExecuteThreadPool;
import com.zhuoxuan.xingtian.res.engine.DatabaseEngine;
import com.zhuoxuan.xingtian.res.entity.DatabaseDO;
import com.zhuoxuan.xingtian.res.entity.FieldDO;
import com.zhuoxuan.xingtian.res.entity.TableDO;
import com.zhuoxuan.xingtian.res.service.DatabaseDelegateService;
import com.zhuoxuan.xingtian.res.service.DatabaseService;
import com.zhuoxuan.xingtian.res.service.TableService;
import com.zhuoxuan.xingtian.res.util.ResEngineFactory;

/**
 * @description：数据库资源相关操作
 * @date 2013-12-13 上午10:58:05
 * @version JQ应用开发支撑平台
 * @author：高江涛
 */

@Service("databaseDelegateService")
public class DatabaseDelegateServiceImpl implements DatabaseDelegateService {

	@Resource
	private DatabaseService databaseService;
	@Resource
	private TableService tbService;
	@Resource
	private XTExecuteThreadPool XtExecuteThreadPool;

	private  final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public ResultBase<Boolean> initDatabase(String databaseId)
			throws XTServiceException {

		ResultBase<Boolean> result = new ResultBase<Boolean>();
		try {
			// do some check and modify status
			DatabaseDO db = databaseService.queryDatabaseById(databaseId);
			db.setDbStatus("1"); //初始化中
			db.setErrorMsg("");
			databaseService.modifyDatabase(db);

			//提交任务到线程池
			XtExecuteThreadPool.execute(new InitDataBaseTask(db));
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			logger.error("启动任务初始化数据库资源失败，原因:"
					+ ExceptionUtil.getStackTrace(e.fillInStackTrace()));
			return result.setReturnErrorMsg("启动任务初始化数据库资源失败");
		}
	}

	/**
	 * @description： 初始化数据库资源
	 * @date 2013-12-13 上午11:32:48
	 * @version JQ应用开发支撑平台
	 * @author：高江涛
	 */
	public class InitDataBaseTask implements Runnable {

		private DatabaseDO databaseDO;

		private DatabaseEngine engine;

		public InitDataBaseTask(DatabaseDO databaseDO) {
			super();
			this.databaseDO = databaseDO;
		}

		@Override
		public void run() {
 
			try {
				

				// 第二步：引用数据库的资源
				databaseService.cleanUpResouceReferenceDbId(databaseDO.getDatabaseId());

				// 第三步：创建数据库资源对应的处理引擎
				engine = ResEngineFactory.createDatabaseEngine(databaseDO);

				// 04-获取数据库资源服务器信息
				ResultBase<DatabaseDO> matchDatabaseResult = engine
						.matchDataBaseInfomation(databaseDO);
				if (!matchDatabaseResult.isSuccess()) {
					databaseDO.setDbStatus("4");
					databaseDO.setErrorMsg(matchDatabaseResult.getErrorMsg());
					databaseService.modifyDatabase(databaseDO);
					return;
				}
				databaseDO = matchDatabaseResult.getValue();
				// 第三步：查询数据库下的表
				List<TableDO> tables = engine.listDatabaseTable();
				// 第四步：将查询的表写入本地表
				databaseService.insertTableListBatch(tables);
				// 第五步：获取数据库信息下的表
				tables = tbService.queryTableListByDatabaseId(databaseDO.getDatabaseId());
				// 第六步：遍历表 获取表中的列
				for (int i = 0; i < tables.size(); i++) {
					TableDO t = tables.get(i);
					List<FieldDO> field = engine.listFieldByTName(
							t.getTableId(), t.getTableName());
					tbService.insertFieldBatch(field);
				}
				// end 执行成功，初始化数据库信息完成 修改数据库信息状态
				databaseDO.setTableCount(tables.size());
				databaseDO.setDbStatus("2");
				databaseService.modifyDatabase(databaseDO);
			} catch (Exception e) {
				// 执行过程中出现异常
				databaseService.cleanUpResouceReferenceDbId(databaseDO.getDatabaseId());
				databaseDO.setDbStatus("4");
				databaseDO.setErrorMsg("执行初始化出错，" + e.getMessage());
				databaseService.modifyDatabase(databaseDO);

			}
		}

	}

}
