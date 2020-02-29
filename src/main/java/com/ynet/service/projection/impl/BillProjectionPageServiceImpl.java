package com.ynet.service.projection.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ynet.bean.BillBean;
import com.ynet.bean.SimpleBillInfo;
import com.ynet.pojo.Bill;
import com.ynet.pojo.BillInterfaceProjection;
import com.ynet.repository.BillDynamicRepository;
import com.ynet.repository.BillProjectionPageRepository;
import com.ynet.service.projection.BillProjectionPageService;
@Service
public class BillProjectionPageServiceImpl implements BillProjectionPageService{
	
	private ObjectMapper mapper = new ObjectMapper();
	
	{
		mapper.setSerializationInclusion(Include.NON_NULL);
	}
	
	@Autowired
	private BillProjectionPageRepository billProjectionPageRepository;
	
	@Autowired
	private BillDynamicRepository billDynamicRepository;

	@Override
	public void newConstructorPage(Long activityId) throws Exception {
		PageRequest pageRequest = PageRequest.of(0,2);
		Page<SimpleBillInfo> list = billProjectionPageRepository.findHaspaySimpleBills(activityId,pageRequest);		
		System.out.println(mapper.writeValueAsString(list.getContent()));
		
	}

	@Override
	public void nameQueryPage(String verifyId) throws Exception {
		PageRequest pageRequest = PageRequest.of(0,100);
		Page<Bill> bill = billProjectionPageRepository.nameQueryByVerifyId(verifyId,pageRequest);
		System.out.println(mapper.writeValueAsString(bill.getContent()));
	}

	@Override
	public void interfaceMapperPage(Long idBegin,Long idEnd) throws Exception {
		PageRequest pageRequest = PageRequest.of(0,1);
		Page<BillInterfaceProjection> bill = billProjectionPageRepository.findByIdGreaterThanAndIdLessThanEqual(idBegin, idEnd,pageRequest);
		System.out.println(mapper.writeValueAsString(bill.getContent()));
	}

	@Override
	public void dynamicMapperPage(String verifyId) throws Exception {
		PageRequest pageRequest = PageRequest.of(0,1);
		Page<BillBean> bill = billDynamicRepository.findByVerifyId(verifyId,BillBean.class,pageRequest);
		System.out.println(mapper.writeValueAsString(bill.getContent()));
	}


}
