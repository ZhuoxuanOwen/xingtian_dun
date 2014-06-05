package com.zhuoxuan.xingtian.res.service.impl;

import javax.annotation.Resource;

import com.zhuoxuan.common.result.ResultBase;
import com.zhuoxuan.xingtian.res.engine.CodeTemplateGeneratorEngine;
import com.zhuoxuan.xingtian.res.entity.BuildConfigDO;
import com.zhuoxuan.xingtian.res.entity.BuildTaskDO;
import com.zhuoxuan.xingtian.res.entity.TableDO;
import com.zhuoxuan.xingtian.res.service.CodeTemplateGeneratorService;
import com.zhuoxuan.xingtian.res.service.TableService;
import com.zhuoxuan.xingtian.res.util.CodeTemplateGeneratorFactory;

/**
 * @description：生成对应的代码段处理业务实现类
 * @date 2013-12-15 下午04:25:57
 * @version JQ应用开发支撑平台
 * @author：高江涛
 */
public class CodeTemplateGeneratorServiceImpl implements CodeTemplateGeneratorService {
	
	@Resource
	private TableService tableService;
	@Resource
	private CodeTemplateGeneratorFactory codeTemplateGeneratorFactory;
	
	@Override
	public ResultBase<StringBuilder> generatorTemplateCode(String tableId, String templateDefine) {
		
		ResultBase<StringBuilder> result = new ResultBase<StringBuilder>();
		
		//查询表资源对象
		ResultBase<TableDO> tableDOQuery = tableService.queryTableDOByTableId(tableId);
		if (!tableDOQuery.isSuccess() || tableDOQuery.getValue() == null) {
			return result.setReturnErrorMsg(tableDOQuery.getErrorMsg());
		}
		TableDO tableDO = tableDOQuery.getValue();
		//构建对应的模板生成器
		CodeTemplateGeneratorEngine engine = codeTemplateGeneratorFactory.buildInstance(templateDefine);
		
		//构建对应的BuildTask
		BuildTaskDO buildTask = new BuildTaskDO();
		
		//初始化配置对象
		BuildConfigDO buildConfigDO = new BuildConfigDO();
		buildTask.setBuildConfig(buildConfigDO);
		
		return engine.generatorTemplateCode(buildTask, tableDO);
	}

}
