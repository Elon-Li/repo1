package com.ynet.service.simple.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ynet.bean.BillPam;
import com.ynet.pojo.Bill;
import com.ynet.pojo.ReconcilationError;
import com.ynet.repository.BillRepository;
import com.ynet.repository.ReconcilationErrorRepository;
import com.ynet.service.simple.BillSimpleQueryService;

@Service
public class BillSimpleQueryServiceImpl implements BillSimpleQueryService {

	private ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private ReconcilationErrorRepository reconErrorRepository;

	@Override
	public void findByid() throws Exception {
		// 根据POJO实体中定义字段查询在Repository中无需写sql
		Bill bill1 = billRepository.findByid(1L);
		System.out.println(mapper.writeValueAsString(bill1));
	}
	
	@Override
	public void findPOJOByid() throws Exception {
		// JPQL简单查询
		Bill bill2 = billRepository.findByBillId(1L);
		System.out.println(mapper.writeValueAsString(bill2));
	}

	@Override
	public void findField() throws Exception {
		// 查询返回某个字段
		Long bill3 = billRepository.findidsByMchId(1L);
		System.out.println(mapper.writeValueAsString(bill3));
	}

	@Override
	public void findFields() throws Exception {
		// 返回某几个字段
		BillPam bill4 = billRepository.findPamById(1L);
		System.out.println(mapper.writeValueAsString(bill4));
	}

	@Override
	public void findPOJOs() throws Exception {
		// 查询返回多个实例
		List<Bill> bill5 = billRepository.findByMchId(2L);
		System.out.println(mapper.writeValueAsString(bill5));
	}

	@SuppressWarnings("deprecation")
	@Override
	public void findPages() throws Exception {
		// 分页查询
		PageRequest pr = new PageRequest(0, 2, new Sort(Direction.DESC, "id"));
		Page<ReconcilationError> error = reconErrorRepository.findSpecErrorByTradeTime("20180925", pr);
		System.out.println(mapper.writeValueAsString(error));
	}

}
