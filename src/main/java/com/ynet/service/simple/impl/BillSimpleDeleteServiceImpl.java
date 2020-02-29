package com.ynet.service.simple.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynet.repository.MerchantTypeRepository;
import com.ynet.service.simple.BillSimpleDeleteService;

@Service
public class BillSimpleDeleteServiceImpl implements BillSimpleDeleteService {
	
	@Autowired
	private MerchantTypeRepository merchantTypeRepository;

	@Transactional
	@Override
	public void delete() {
		merchantTypeRepository.deleteByid(42L);
	}
}
