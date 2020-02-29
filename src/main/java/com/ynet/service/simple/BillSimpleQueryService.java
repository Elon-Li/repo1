package com.ynet.service.simple;

public interface BillSimpleQueryService {
	
	/**
	 * <p>Title: findByid</p>
	 * <p>Description: 根据POJO实体中定义字段查询在Repository中无需写sql</p>
	 * @throws Exception
	 */
	public void findByid() throws Exception;

	/**
	 * <p>Title: findPOJOByid</p>
	 * <p>Description: JPQL简单查询</p>
	 * @throws Exception
	 */
	void findPOJOByid() throws Exception;

	/**
	 * <p>Title: findField</p>
	 * <p>Description: 查询返回某个字段</p>
	 * @throws Exception
	 */
	void findField() throws Exception;

	/**
	 * <p>Title: findFields</p>
	 * <p>Description: 返回某几个字段</p>
	 * @throws Exception
	 */
	void findFields() throws Exception;

	/**
	 * <p>Title: findPOJOs</p>
	 * <p>Description: 查询返回多个实例</p>
	 * @throws Exception
	 */
	void findPOJOs() throws Exception;

	/**
	 * <p>Title: findPages</p>
	 * <p>Description: 分页查询</p>
	 * @throws Exception
	 */
	void findPages() throws Exception;

}
