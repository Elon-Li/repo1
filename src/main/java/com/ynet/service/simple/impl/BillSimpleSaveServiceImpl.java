package com.ynet.service.simple.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynet.pojo.MerchantType;
import com.ynet.repository.MerchantTypeRepository;
import com.ynet.service.simple.BillSimpleSaveService;

@Service
public class BillSimpleSaveServiceImpl implements BillSimpleSaveService {
	
	@Autowired
	private MerchantTypeRepository mchtTypeRepository;

	@Override
	public void save() {
		MerchantType mchType = new MerchantType();
		mchType.setName("jpa测试");
		mchType.setIndustryTypeId(1);
		mchType.setIndustryTypeName("教育");
		mchType.setTrade(12);
		mchType.setComment("jpa测试");
		mchtTypeRepository.save(mchType);
		
	}

	@Override
	public void saveAll() {
		List<MerchantType> mchTypeList = new ArrayList<MerchantType>();
		
		MerchantType mchType1 = new MerchantType();
		mchType1.setName("jpa测试1");
		mchType1.setIndustryTypeId(1);
		mchType1.setIndustryTypeName("教育");
		mchType1.setTrade(12);
		mchType1.setComment("jpa测试2");
		
		MerchantType mchType2 = new MerchantType();
		mchType2.setName("jpa测试2");
		mchType2.setIndustryTypeId(1);
		mchType2.setIndustryTypeName("教育");
		mchType2.setTrade(12);
		mchType2.setComment("jpa测试2");
		
		mchTypeList.add(mchType1);
		mchTypeList.add(mchType2);
		
		mchtTypeRepository.saveAll(mchTypeList);
		
	}

}
