package com.ynet.service.projection.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ynet.bean.BillBean;
import com.ynet.bean.SimpleBillInfo;
import com.ynet.pojo.Bill;
import com.ynet.pojo.BillInterfaceProjection;
import com.ynet.repository.BillDynamicRepository;
import com.ynet.repository.BillProjectionRepository;
import com.ynet.service.projection.BillProjectionService;
@Service
public class BillProjectionServiceImpl implements BillProjectionService{
	
	private ObjectMapper mapper = new ObjectMapper();
	
	{
		mapper.setSerializationInclusion(Include.NON_NULL);
	}
	
	@Autowired
	private BillProjectionRepository billProjectionRepository;
	
	@Autowired
	private BillDynamicRepository billDynamicRepository;

	@Override
	public void newConstructor(Long activityId) throws Exception {
		List<SimpleBillInfo> list = billProjectionRepository.findHaspaySimpleBills(activityId);		
		System.out.println(mapper.writeValueAsString(list));
		
	}

	@Override
	public void nameQuery(Long id) throws Exception {
		Bill bill = billProjectionRepository.nameQueryById(1L);
		System.out.println(mapper.writeValueAsString(bill));
	}

	@Override
	public void interfaceMapper(Long idBegin,Long idEnd) throws Exception {
		List<BillInterfaceProjection> bill = billProjectionRepository.findByIdGreaterThanAndIdLessThanEqual(idBegin, idEnd);
		System.out.println(mapper.writeValueAsString(bill));
	}

	@Override
	public void dynamicMapper(String verifyId) throws Exception {
		List<BillBean> bill = billDynamicRepository.findByVerifyId(verifyId,BillBean.class);
		System.out.println(mapper.writeValueAsString(bill));
	}

}
