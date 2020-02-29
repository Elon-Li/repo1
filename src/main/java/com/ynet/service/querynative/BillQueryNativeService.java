package com.ynet.service.querynative;

public interface BillQueryNativeService {

	/**
	 * <p>Title: getBillStatistics</p>
	 * <p>Description: Repository（@query native）Native SQL 的Interface projection</p>
	 * @throws Exception
	 */
	public void getBillStatistics(Long actId,Long mchId,Integer payType) throws Exception ;
	
	/**
	 * <p>Title: getBillStatisticsPage</p>
	 * <p>Description: Repository（@query native）Native SQL 的Interface projection分页查询</p>
	 * @throws Exception
	 */
	public void getBillStatisticsPage(Long actId,Long mchId,Integer payType,Integer pageNumber,Integer pageSize) throws Exception ;
	
	
}
