package com.zhuoxuan.xingtian.res.action;

import javax.annotation.Resource;

import com.zhuoxuan.common.result.ResultBase;
import com.zhuoxuan.common.util.BaseAction;
import com.zhuoxuan.xingtian.res.service.CodeTemplateGeneratorService;

/**
 * @description：代码生成器后台处理Action
 * @date 2013-12-15 下午04:21:08
 * @version JQ应用开发支撑平台
 * @author：高江涛
 */
public class CodeTemplateGeneratorAction extends BaseAction {

	@Resource
	private CodeTemplateGeneratorService codeTemplateGeneratorService;

	/**
	 * 
	 */
	private static final long serialVersionUID = -4486652188191516604L;

	/**
	 * 根据相应的模板生成代码
	 * @return
	 * @throws Exception
	 */
	public String generatorTemplateCode() throws Exception {

		String tableId = getRequest().getParameter("tableId");
		String templateDefine = getRequest().getParameter("templateDefine");

		ResultBase<StringBuilder> result = codeTemplateGeneratorService.generatorTemplateCode(tableId, templateDefine);
		if (result.isSuccess()) {
			super.setJsonResult().setContent(String.valueOf(result.getValue()));
		}
		
		return SUCCESS;
	}

}
