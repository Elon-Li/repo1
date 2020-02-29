package com.ynet.service.projection;

public interface BillProjectionService {
	/**
	 * 构造函数（new）
	 * @param activityId
	 * @throws Exception
	 */
	void newConstructor(Long activityId) throws Exception;
	
	/**
	 * 实体映射
	 * @param id
	 * @throws Exception
	 */
	void nameQuery(Long id) throws Exception;
	
	/**
	 * 接口映射
	 * @param idBegin
	 * @param idEnd
	 * @throws Exception
	 */
	void interfaceMapper(Long idBegin,Long idEnd) throws Exception;
	
	/**
	 * 动态映射
	 * @param verifyId
	 * @throws Exception
	 */
	void dynamicMapper(String verifyId) throws Exception;

}
