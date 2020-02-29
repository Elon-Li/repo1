package com.ynet.service.projection;

public interface BillProjectionPageService {
	/**
	 * 构造函数（new）
	 * @param activityId
	 * @throws Exception
	 */
	void newConstructorPage(Long activityId) throws Exception;
	
	/**
	 * 实体映射
	 * @param verifyId
	 * @throws Exception
	 */
	void nameQueryPage(String verifyId) throws Exception;
	
	/**
	 * 接口映射
	 * @param idBegin
	 * @param idEnd
	 * @throws Exception
	 */
	void interfaceMapperPage(Long idBegin,Long idEnd) throws Exception;
	
	/**
	 * 动态映射
	 * @param verifyId
	 * @throws Exception
	 */
	void dynamicMapperPage(String verifyId) throws Exception;

}
