package com.zhuoxuan.xingtian.res.dao;

import java.util.List;

import com.zhuoxuan.common.exception.JQDaoException;
import com.zhuoxuan.common.page.Page;
import com.zhuoxuan.xingtian.res.entity.CodeTempleteDO;

/**
 * <p>
 * CodeTemplete 数据库访问层接口
 * </p>
 * 
 * @author: 高江涛
 * @创建时间：2012-07-27 09:38:50
 * @产品: 刑天盾
 * @version： V1.0
 */
public interface TempleteCodeDao {

	public void addCodeTemplete(CodeTempleteDO vo) throws Exception;

	public void updateCodeTemplete(CodeTempleteDO vo) throws Exception;

	public void deleteCodeTemplete(String CodeTempleteId) throws Exception;

	public CodeTempleteDO queryCodeTempleteByCodeTempleteId(String id) throws Exception;

	public List<CodeTempleteDO> queryCodeTempleteList(Page page) throws Exception;
	
		/**
		 * <p> 根据技术方案 查询构建模板 </p>
		 * @param tel
		 * @return List<CodeTemplete>
		 * @throws Exception  
		 */
	public List<CodeTempleteDO> queryCodeTempleteByTel(String tel) throws JQDaoException;

}