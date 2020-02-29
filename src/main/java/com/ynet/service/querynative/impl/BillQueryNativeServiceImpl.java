package com.ynet.service.querynative.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ynet.bean.BillStatisticInfoPro;
import com.ynet.repository.BillActivityStatisticsRepository;
import com.ynet.service.querynative.BillQueryNativeService;

@Service
public class BillQueryNativeServiceImpl implements BillQueryNativeService{

	private ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private BillActivityStatisticsRepository billActStatisticsRepository;
	
	@Override
	public void getBillStatistics(Long actId,Long mchId,Integer payType) throws Exception {
		List<BillStatisticInfoPro> infoList = billActStatisticsRepository.getActPro(actId, payType, mchId);
		System.out.println(mapper.writeValueAsString(infoList));
	}

	@Override
	public void getBillStatisticsPage(Long actId,Long mchId,Integer payType,Integer pageNumber,Integer pageSize) throws Exception {
		List<BillStatisticInfoPro> infoList = billActStatisticsRepository.getActProByPage(actId, payType, mchId,pageNumber,pageSize);
		System.out.println(mapper.writeValueAsString(infoList));
		
	}
	
}
