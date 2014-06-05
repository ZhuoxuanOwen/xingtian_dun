package com.zhuoxuan.xingtian.res.service;

import java.util.List;
import java.util.Map;

import com.zhuoxuan.common.exception.XTServiceException;
import com.zhuoxuan.common.page.Page;
import com.zhuoxuan.xingtian.res.entity.CodeTempleteDO;

/**
 * <p>
 * CodeTemplete 业务处理层接口
 * </p>
 * 
 * @author: JQSupportPlateform
 * @创建时间：2012-07-27 09:38:50
 * @产品: 支撑平台方案
 * @version： V1.0
 */
public interface CodeTempleteService {
	public boolean insertCodeTemplete(CodeTempleteDO vo);

	public boolean modifyCodeTemplete(CodeTempleteDO vo);

	public boolean removeCodeTemplete(String id);

	public CodeTempleteDO queryCodeTempleteById(String id);

	public List<CodeTempleteDO> queryCodeTempleteList(Page page);

	public Map<String, String> queryCodeTempByTel(String tel) throws XTServiceException;
}
