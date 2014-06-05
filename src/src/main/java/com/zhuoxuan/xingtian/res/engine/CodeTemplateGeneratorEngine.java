package com.zhuoxuan.xingtian.res.engine;

import java.util.Map;

import javax.annotation.Resource;

import com.zhuoxuan.common.constants.BuildConstants;
import com.zhuoxuan.common.result.ResultBase;
import com.zhuoxuan.xingtian.res.entity.BuildTaskDO;
import com.zhuoxuan.xingtian.res.entity.TableDO;
import com.zhuoxuan.xingtian.res.service.CodeTempleteService;

/**
 * @description：
 * 单一模板代码段生成引擎,负责根据表渲染对应的代码，数据由对象传入
 * @date 2013-12-15 下午04:39:12
 * @version JQ应用开发支撑平台
 * @author：高江涛
 */
public abstract class CodeTemplateGeneratorEngine {
	
	@Resource
	protected CodeTempleteService codeTempleteService;
	
	
	protected String getFieldName(String fieldName) {
		return fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
	}

	protected String getLowerName(String name) {
		return name.toLowerCase();
	}
	
	/**
	 * 刷新TaskDO
	 * @param buildTaskDO
	 * @param tel
	 */
	protected void refushBuildTask(BuildTaskDO buildTaskDO , String tel){
		
		Map<String, String> codeTemplateMap = codeTempleteService.queryCodeTempByTel(BuildConstants.TECL_SSI);
		buildTaskDO.setCodeTemplate(codeTemplateMap);
	}
	
	/**
	 * 按照表资源ID创建对应的内容
	 * @param tableId
	 * @return
	 */
	public abstract ResultBase<StringBuilder> generatorTemplateCode(BuildTaskDO buildTask , TableDO tableDO);

	public void setTempleteCodeService(CodeTempleteService templeteCodeService) {
		this.codeTempleteService = templeteCodeService;
	}
	
}
