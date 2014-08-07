package com.zhuoxuan.xingtian.res.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zhuoxuan.common.exception.XTServiceException;
import com.zhuoxuan.common.page.Page;
import com.zhuoxuan.xingtian.res.dao.TempleteCodeDao;
import com.zhuoxuan.xingtian.res.entity.CodeTempleteDO;
import com.zhuoxuan.xingtian.res.service.CodeTempleteService;
/**
 * <p>
 * CodeTemplete 业务处理层实现类
 * </p>
 * 
 * @author: JQSupportPlateform
 * @创建时间：2012-07-27 09:38:50
 * @产品: 支撑平台方案
 * @version： V1.0
 */

@Service("codeTempleteService")
public class CodeTempleteServiceImpl implements CodeTempleteService {

	@Resource
	private TempleteCodeDao codetempleteDao;

	private  final Logger logger = LoggerFactory.getLogger(this.getClass());

	public boolean insertCodeTemplete(CodeTempleteDO vo) {

		try {
			codetempleteDao.addCodeTemplete(vo);
			return true;
		} catch (Exception e) {
			logger.error("CodeTempleteServiceImpl:insertCodeTemplete has error ,the cause is:" + e.getCause());
			return false;
		}
	}

	public boolean modifyCodeTemplete(CodeTempleteDO vo) {

		try {
			codetempleteDao.updateCodeTemplete(vo);
			return true;
		} catch (Exception e) {
			logger.error("CodeTempleteServiceImpl:modifyCodeTemplete has error ,the cause is:" + e.getCause());
			return false;
		}
	}

	public boolean removeCodeTemplete(String id) {

		try {
			codetempleteDao.deleteCodeTemplete(id);
			return true;
		} catch (Exception e) {
			logger.error("CodeTempleteServiceImpl:removeCodeTemplete has error ,the cause is:" + e.getCause());
			return false;
		}
	}

	public CodeTempleteDO queryCodeTempleteById(String codetempleteId) {
		CodeTempleteDO codetemplete = null;
		try {
			codetemplete = codetempleteDao.queryCodeTempleteByCodeTempleteId(codetempleteId);
		} catch (Exception e) {
			logger.error("CodeTempleteServiceImpl:queryCodeTempleteById has error ,the cause is:" + e.getCause());
		}
		return codetemplete;
	}

	public List<CodeTempleteDO> queryCodeTempleteList(Page page) {

		List<CodeTempleteDO> codetempleteList = null;
		try {
			codetempleteList = codetempleteDao.queryCodeTempleteList(page);
		} catch (Exception e) {
			logger.error(" CodeTempleteServiceImpl:queryCodeTempleteList(Page) has error ,the cause is:" + e.getCause());
		}
		return codetempleteList;
	}

	public void setCodeTempleteDao(TempleteCodeDao codetempleteDao) {
		this.codetempleteDao = codetempleteDao;
	}

	public Map<String, String> queryCodeTempByTel(String tel) throws XTServiceException {

		List<CodeTempleteDO> codeTempList = codetempleteDao.queryCodeTempleteByTel(tel);
		Map<String, String> codeTempMap = new HashMap<String, String>();
		CodeTempleteDO ct = null;
		for (int i = 0; i < codeTempList.size(); i++) {
			ct = codeTempList.get(i);
			codeTempMap.put(ct.getCtCode(), ct.getCtContent());
		}
		
		return codeTempMap;
	}
}
