package com.zhuoxuan.xingtian.res.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.zhuoxuan.common.exception.JQDaoException;
import com.zhuoxuan.common.page.Page;
import com.zhuoxuan.xingtian.res.dao.TempleteCodeDao;
import com.zhuoxuan.xingtian.res.entity.CodeTempleteDO;

/**
 * <p>
 * CodeTemplete 数据库访问层实现类
 * </p>
 * 
 * @author: JQSupportPlateform
 * @创建时间：2012-07-27 09:38:50
 * @产品: 支撑平台方案
 * @version： V1.0
 */
public class TempleteCodeDaoImpl extends SqlMapClientDaoSupport implements TempleteCodeDao {

	public void addCodeTemplete(CodeTempleteDO vo) throws Exception {

		super.getSqlMapClientTemplate().insert("codetemplete_manage.addCodeTemplete", vo);
	}
	public void updateCodeTemplete(CodeTempleteDO vo) throws Exception {

		super.getSqlMapClientTemplate().update("codetemplete_manage.addCodeTemplete", vo);
	}
	public void deleteCodeTemplete(String codetempleteId) throws Exception {

		super.getSqlMapClientTemplate().delete("codetemplete_manage.delete", codetempleteId);
	}
	public CodeTempleteDO queryCodeTempleteByCodeTempleteId(String codetempleteId) throws Exception {

		CodeTempleteDO vo = (CodeTempleteDO) super.getSqlMapClientTemplate().queryForObject("codetemplete_manage.queryCodeTempleteById", codetempleteId);
		return vo;
	}
	@SuppressWarnings("unchecked")
	public List<CodeTempleteDO> queryCodeTempleteList(Page page) throws Exception {

		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("codetemplete_manage.queryCodeTempleteRowCount", page);
		page.setRowCount(count).commonInit();
		List<CodeTempleteDO> CodeTempleteList = getSqlMapClientTemplate().queryForList("codetemplete_manage.queryCodeTempletePageList", page);
		return CodeTempleteList;
	}
	@SuppressWarnings("unchecked")
	public List<CodeTempleteDO> queryCodeTempleteByTel(String tel) throws JQDaoException {
		List<CodeTempleteDO> codeTempleteList = getSqlMapClientTemplate().queryForList("codetemplete_manage.querycodeTempByTel", tel);
		return codeTempleteList;
	}

}