package com.zhuoxuan.xingtian.res.util;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.zhuoxuan.xingtian.res.engine.CodeTemplateGeneratorEngine;
import com.zhuoxuan.xingtian.res.engine.impl.Gen_JavaDaoInterfaceGenerator;
import com.zhuoxuan.xingtian.res.engine.impl.Gen_JavaDoGenerator;
import com.zhuoxuan.xingtian.res.engine.impl.Gen_JavaServiceInterfaceGenerator;
import com.zhuoxuan.xingtian.res.engine.impl.Gen_SsiDaoImplGenerator;
import com.zhuoxuan.xingtian.res.engine.impl.Gen_SsiSqlMapGenerator;
import com.zhuoxuan.xingtian.res.service.CodeTempleteService;

/**
 * @description：根据选择的模板、创建对应的创建实例
 * @date 2013-12-15 下午04:50:15
 * @version JQ应用开发支撑平台
 * @author：高江涛
 */

@Repository("codeTemplateGeneratorFactory")
public class CodeTemplateGeneratorFactory {

	@Resource
	private CodeTempleteService codeTempleteService;

	public static enum TemplateDefine {
		JAVA_DO, JAVA_DAO,
		JAVA_IBATIS_SQL_MAP, 
		JAVA_IBATIS_DAO,
		JAVA_Service
	}

	/**
	 * 构建对应代码处理生成实例
	 * 
	 * @param templateDefine
	 * @return
	 */
	public CodeTemplateGeneratorEngine buildInstance(String templateDefine) {

		CodeTemplateGeneratorEngine instanceEngine = null;
		switch (TemplateDefine.valueOf(templateDefine)) {
		case JAVA_DO:
			instanceEngine = new Gen_JavaDoGenerator();
			break;
		case JAVA_DAO:
			instanceEngine = new Gen_JavaDaoInterfaceGenerator();
			break;
		case JAVA_IBATIS_SQL_MAP:
			instanceEngine = new Gen_SsiSqlMapGenerator();
			break;
		case JAVA_IBATIS_DAO:
			instanceEngine = new Gen_SsiDaoImplGenerator();
			break;
		case JAVA_Service:
			instanceEngine = new Gen_JavaServiceInterfaceGenerator();
		default:
			break;
		}

		instanceEngine.setTempleteCodeService(codeTempleteService);

		return instanceEngine;
	}

}
