package com.ynet.service.entitymanager.impl;

import java.beans.PropertyDescriptor;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Tuple;


import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ynet.bean.BillStatisticInfoObject;
import com.ynet.repository.BillActivityStatisticsRepository;
import com.ynet.service.entitymanager.BillEntityManagerQueryService;

@Service
public class BillEntityManagerQueryServiceImpl implements BillEntityManagerQueryService{

	private ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private BillActivityStatisticsRepository billActivityStatisticsRepository;
	
	@Override
	public List<Tuple> getBillInfoTuple(Long actId,Long mchId,Integer payType,Integer pageNumber,Integer pageSize) throws Exception {
			List<Tuple> postDTOs = billActivityStatisticsRepository.getBillInfoTuple(actId, mchId, payType, pageNumber, pageSize);
			System.out.println(mapper.writeValueAsString(postDTOs));
			return postDTOs;
			
		
	}

	@Override
	public List<BillStatisticInfoObject> getBillInfoBean(Long actId,Long mchId,Integer payType,Integer pageNumber,Integer pageSize) throws Exception  {
		
		List<BillStatisticInfoObject> postDTOs = billActivityStatisticsRepository.getBillInfoBean(actId, mchId, payType, pageNumber, pageSize);
		System.out.println(mapper.writeValueAsString(postDTOs));
		return postDTOs;
		
	}

	@Override
	public List getBillInfoMap(Long actId,Long mchId,Integer payType,Integer pageNumber,Integer pageSize) throws Exception {
			List list = billActivityStatisticsRepository.getBillInfoMap(actId, mchId, payType, pageNumber, pageSize);
			System.out.println(mapper.writeValueAsString(list));
			return list;
		
	}
	
}
