package com.zhuoxuan.xingtian.res.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zhuoxuan.common.exception.XTServiceException;
import com.zhuoxuan.common.result.ResultBase;
import com.zhuoxuan.common.util.ExceptionUtil;
import com.zhuoxuan.xingtian.res.dao.TableDao;
import com.zhuoxuan.xingtian.res.entity.FieldDO;
import com.zhuoxuan.xingtian.res.entity.TableDO;
import com.zhuoxuan.xingtian.res.service.FieldService;

/**
 * @description：数据表对应的列信息业务处理
 * @date 2013-12-13 下午06:11:30
 * @version JQ应用开发支撑平台
 * @author：高江涛
 */

@Service("fieldService")
public class FieldServiceImpl implements FieldService {
	
	
	@Resource
	private TableDao tableDao;
	
	private  final Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Override
	public ResultBase<List<FieldDO>> queryFieldListByTableId(String tableId) throws XTServiceException {
		
		ResultBase<List<FieldDO>> result = new ResultBase<List<FieldDO>>();
		
		try {
			TableDO tableDO  = tableDao.queryTableDOByTableId(tableId);
			if (tableDO == null) {
				return result.setReturnErrorMsg("无法根据数据库表的ID查询表的对象。");
			}
			List<FieldDO> fieldList = tableDao.queryFieldByTableId(tableId);
			for (FieldDO fieldDO : fieldList) {
				fieldDO.setTableDO(tableDO);
			}
			return result.setReturnRightValue(fieldList);
		} catch (Exception e) {
			logger.error("查询表对应的字段失败,原因：" + ExceptionUtil.getStackTrace(e.fillInStackTrace()));
			return result.setReturnErrorMsg("查询表对应的字段失败。");
		}
		
		
	}

}
