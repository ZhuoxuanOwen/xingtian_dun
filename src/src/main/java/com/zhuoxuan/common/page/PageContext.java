package com.zhuoxuan.common.page;

/**
 * 处理分页的核心的接口
 * 
 * @author Gao Jiangtao
 * 
 */
public interface PageContext {

	/**
	 * 设置每页显示多数条数据
	 * 
	 * @param pSize
	 * @return
	 */
	public PageContext psize(int pSize);

	/**
	 * 设置刷新的区域
	 * 
	 * @param element
	 * @return
	 */
	public PageContext element(String element);

	/**
	 * 设置URL传递的参数
	 * 
	 * @param condition
	 * @return
	 */
	public PageContext params(String condition);

	/**
	 * 设置连接
	 * 
	 * @param url
	 * @return
	 */
	public PageContext url(String url);

	/**
	 * 添加回调函数名称
	 * 
	 * @param methedName
	 * @return
	 */
	public PageContext methed(String methedName);

	/**
	 * 完成 统一部署
	 */
	public void deployee();

}
