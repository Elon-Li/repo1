package com.ynet.service.entitymanager;

import java.util.List;

import javax.persistence.Tuple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ynet.TestMain;
import com.ynet.bean.BillStatisticInfoObject;
import com.ynet.service.entitymanager.BillEntityManagerQueryService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestMain.class)
public class BillEntityManagerQueryTest {
	
	@Autowired
	private BillEntityManagerQueryService billService;

	@Test
	public void getBillInfoTuple() throws Exception {
		List<Tuple> postDTOs = billService.getBillInfoTuple(1L,1L,0,0,2);
		Integer actIds =  (Integer) postDTOs.get(0).get("activityId");
		String orgFullname = (String) postDTOs.get(0).get("orgFullname");
		Integer billCount =  (Integer) postDTOs.get(0).get("billCount");
	}
	
	@Test
	public void getBillInfoBean() throws Exception {
		List<BillStatisticInfoObject> list = billService.getBillInfoBean(1L,1L,0,0,2);
	}
	
	@Test
	public void getBillInfoMap() throws Exception {
		List list = billService.getBillInfoMap(1L,1L,0,0,2);
	}
}
