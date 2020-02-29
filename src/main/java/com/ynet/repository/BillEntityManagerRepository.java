package com.ynet.repository;

import java.util.List;

import javax.persistence.Tuple;

import com.ynet.bean.BillStatisticInfoObject;

public interface BillEntityManagerRepository {
	
	List<Tuple> getBillInfoTuple(Long actId,Long mchId,Integer payType,Integer pageNumber,Integer pageSize) throws Exception ;

	List<BillStatisticInfoObject> getBillInfoBean(Long actId,Long mchId,Integer payType,Integer pageNumber,Integer pageSize) throws Exception;
	
	List getBillInfoMap(Long actId,Long mchId,Integer payType,Integer pageNumber,Integer pageSize) throws Exception ;
	
	
}
