package com.ynet.service.entitymanager;

import java.util.List;

import javax.persistence.Tuple;

import com.ynet.bean.BillStatisticInfoObject;

public interface BillEntityManagerQueryService {

	/**
	 * <p>Title: getBillInfoTuple</p>
	 * <p>Description: 动态条件查询或查询结果映射到Tuple</p>
	 * @throws Exception
	 */
	public List<Tuple> getBillInfoTuple(Long actId,Long mchId,Integer payType,Integer pageNumber,Integer pageSize)  throws Exception;
	
	/**
	 * <p>Title: getBillInfoBean</p>
	 * <p>Description: 动态条件查询或查询结果映射到实例</p>
	 * @throws Exception
	 */
	public List<BillStatisticInfoObject> getBillInfoBean(Long actId,Long mchId,Integer payType,Integer pageNumber,Integer pageSize)  throws Exception;
	
	/**
	 * <p>Title: getBillInfoMap</p>
	 * <p>Description: 动态条件查询或查询结果映射到MAP</p>
	 * @throws Exception
	 */
	public List getBillInfoMap(Long actId,Long mchId,Integer payType,Integer pageNumber,Integer pageSize)  throws Exception;
}
