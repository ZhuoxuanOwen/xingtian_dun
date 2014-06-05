package com.zhuoxuan.xingtian.res.service;

import com.zhuoxuan.common.result.ResultBase;

/**
 * @description：生成对应的代码段处理业务接口
 * @date 2013-12-15 下午04:25:16
 * @version JQ应用开发支撑平台
 * @author：高江涛
 */
public interface CodeTemplateGeneratorService {
	
	/**
	 * 根据表资源、用户选择的模板生成对应的代码段
	 * @param tableId 表资源ID
	 * @param templateDefine 
	 * @return
	 */
	public ResultBase<StringBuilder> generatorTemplateCode(String tableId,String templateDefine);

}
