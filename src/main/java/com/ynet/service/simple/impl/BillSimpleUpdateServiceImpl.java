package com.ynet.service.simple.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynet.repository.MerchantTypeRepository;
import com.ynet.service.simple.BillSimpleUpdateService;

@Service
public class BillSimpleUpdateServiceImpl implements BillSimpleUpdateService {
	
	@Autowired
	private MerchantTypeRepository merchantTypeRepository;

	@Transactional
	@Override
	public void update() {
		merchantTypeRepository.updateByid("修改测试",44L);
	}

}
